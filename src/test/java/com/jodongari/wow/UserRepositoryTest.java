package com.jodongari.wow;

import com.jodongari.wow.entity.User;
import com.jodongari.wow.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void User_등록_테스트() {

        //given
        User user = User.builder()
                .email("test@test.com")
                .gender("male")
                .nickName("test")
                .birthday("20210000")
                .build();

        userRepository.save(user);

        List<User> users = userRepository.findAll();
        User savedUser = users.get(0);

        System.out.println(">>>>> createDateTime = " + savedUser.getCreatedDateTime() + ", updatedDateTime = " + savedUser.getUpdatedDatetime());

        Assertions.assertEquals(user.getEmail(), savedUser.getEmail());
        Assertions.assertEquals(user.getBirthday(), savedUser.getBirthday());
        Assertions.assertEquals(user.getGender(), savedUser.getGender());
        Assertions.assertEquals(user.getNickName(), savedUser.getNickName());
    }
}
