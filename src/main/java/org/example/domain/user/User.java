package org.example.domain.user;

public class User {

    // 해당 값을 초기화할 때 final을 실무에서는 어떻게 붙히나
    private String id;
    private String password;
    private int orderCount;
    private int balance;

    public User(String id,
                String password,
                int balance) {

        this.id = id;
        this.password = password;
        this.orderCount = 0;
        this.balance = balance;
    }

    // 값들을 외부에서 받을 수 있는 get method들
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public int getOrderCount(){
        return orderCount;
    }

    public void increaseOrderCount(){
        orderCount ++;
    }
    // CSV 저장용 문자열
    public String CsvtoString() {
        return id + "," +
                password + "," +
                balance;
    }
}