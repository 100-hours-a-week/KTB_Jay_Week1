package org.example.Controller;

import org.example.service.UserService;

import java.util.Scanner;

public class UserController {
    private UserService userService;
    private Scanner sc = new Scanner(System.in);

    public UserController(UserService userService){
        this.userService = userService;
    }

    public void register(){
        System.out.print("아이디 입력: ");
        String id = sc.nextLine();

        System.out.print("비밀번호 입력: ");
        String pw = sc.nextLine();

        // 서비스한테 회원가입 시켜! 보내기
        boolean result = userService.register(id, pw);

        if (! result){
            System.out.println("회원가입 실패!!");
        }

    }

    public void login(){
        System.out.print("아이디 입력: ");
        String id = sc.nextLine();

        System.out.print("비밀번호 입력: ");
        String pw = sc.nextLine();

        boolean result = userService.login(id, pw);

        if(! result){
            System.out.println("로그인 실패!!");
        }
    }
}
