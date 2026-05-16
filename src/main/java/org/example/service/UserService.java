package org.example.service;

import org.example.domain.User;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository =
            new UserRepository();

    // 회원가입
    public void register(String id,
                         String password) {

        List<User> users =
                userRepository.findAll();

        // 중복 검사
        for (User user : users) {

            if (user.getId().equals(id)) {

                System.out.println("이미 존재하는 아이디");
                return;
            }
        }

        User newUser =
                new User(id, password, 10000);

        userRepository.save(newUser);

        System.out.println("회원가입 성공");
    }

    // 로그인
    public boolean login(String id,
                         String password) {

        List<User> users =
                userRepository.findAll();

        for (User user : users) {

            if (user.getId().equals(id)
                    &&
                    user.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }
}