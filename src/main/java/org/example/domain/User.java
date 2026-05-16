package org.example.domain;

public class User {

    private String id;
    private String password;
    private int balance;

    public User(String id,
                String password,
                int balance) {

        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    // CSV 저장용 문자열
    public String CsvtoString() {
        return id + "," +
                password + "," +
                balance;
    }
}