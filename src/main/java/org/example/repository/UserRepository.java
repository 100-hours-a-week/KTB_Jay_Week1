package org.example.repository;

import org.example.domain.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String FILE_PATH =
            "data/users.csv";

    // 회원 저장
    public void save(User user) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE_PATH, true)
                    );

            bw.write(user.CsvtoString());

            bw.newLine();

            bw.close();

        } catch (IOException e) {

            System.out.println("파일 저장 실패");
        }
    }

    // 전체 회원 조회
    public List<User> findAll() {

        List<User> users =
                new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                User user =
                        new User(
                                data[0],
                                data[1],
                                Integer.parseInt(data[2])
                        );

                users.add(user);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("파일 읽기 실패");
        }

        return users;
    }
}