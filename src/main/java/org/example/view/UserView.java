package org.example.view;

import org.example.service.UserService;

import java.util.Scanner;

public class UserView {

    private Scanner sc =
            new Scanner(System.in);

    private UserService userService =
            new UserService();

    public void start() {

        while (true) {

            System.out.println("===== 배달 앱 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");

            int choice =
                    sc.nextInt();

            sc.nextLine();

            // 회원가입
            if (choice == 1) {

                System.out.print("아이디 입력 : ");
                String id =
                        sc.nextLine();

                System.out.print("비밀번호 입력 : ");
                String pw =
                        sc.nextLine();

                userService.register(id, pw);
            }

            // 로그인
            else if (choice == 2) {

                System.out.print("아이디 입력 : ");
                String id =
                        sc.nextLine();

                System.out.print("비밀번호 입력 : ");
                String pw =
                        sc.nextLine();

                boolean result =
                        userService.login(id, pw);

                if (result) {
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("로그인 실패");
                }
            }

            // 종료
            else if (choice == 3) {
                break;
            }
        }
    }
}