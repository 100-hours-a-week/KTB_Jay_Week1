package org.example.domain.discount;

public class BasicDiscountPolicy
        implements DiscountPolicy {

    @Override
    public int discount(int price) {

        // 일반회원 할인 없음
        return 0;
    }
}