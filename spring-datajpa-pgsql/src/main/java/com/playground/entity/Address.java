package com.playground.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "{id}")
@ToString
public class Address {
    @Id
    @SequenceGenerator(name = "seq_user_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500)
    private String addressDetail;

    @Enumerated
    private AddressType addressType;

    @Column(name = "isactive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

   public enum AddressType {
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}
