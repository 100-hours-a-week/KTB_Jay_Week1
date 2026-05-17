package org.example.service;

import org.example.domain.user.User;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repo){
        this.userRepository = repo;
    }


    // 회원가입
    public boolean register(String id,
                         String password) {
        // List 안에 user 정보를 전부 받아오기
        List<User> users = userRepository.findAll();

        // 하나씩 돌면서 전부 id 값을 꺼내서 비교
        for (User user : users) {
            // 한개라도 같은게 있으면 id는 겹치면 안되기 때문에 False 반환
            if (user.getId().equals(id)) {

                System.out.println("이미 존재하는 아이디");
                return false;
            }
        }
        // 전부 검사했는데 일치하는게 없다면 새로운 객체 만들기
        User newUser = new User(id, password, 10000);

        userRepository.save(newUser);

        System.out.println("회원가입 성공");
        return true;
    }

    // 로그인
    public boolean login(String id, String password) {

        List<User> users = userRepository.findAll();

        for (User user : users) {

            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                System.out.println("로그인 성공!!");
                return true;
            }
        }

        return false;
    }
}