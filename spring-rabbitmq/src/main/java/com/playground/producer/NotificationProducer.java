package com.playground.producer;

import com.playground.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        Notification nf = new Notification();
        nf.setNotificationId(UUID.randomUUID().toString());
        nf.setCreatedAt(new Date());
        nf.setMessage("test message");
        nf.setSeen(Boolean.FALSE);

        sendToQueue(nf);
    }

    public void sendToQueue(Notification notification){
        System.out.println("Notification sent ID : " + notification.getNotificationId());

        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
        }
    }
}
