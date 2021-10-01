package com.playground.api;

import com.playground.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.playground.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository _userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("Ahmet");
        user.setSurname("Mehmet");
        user.setAddress("kemer");
        user.setBirthDate(Calendar.getInstance().getTime());

        _userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {
        List<User> userList = _userRepository.findByNameLikeOrSurnameLike(search,search);
        return ResponseEntity.ok(userList);
    }
}
