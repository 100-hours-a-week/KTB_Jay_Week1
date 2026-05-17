package org.example.controller;

import org.example.domain.item.Item;
import org.example.domain.user.User;
import org.example.service.ItemService;
import org.example.service.OrderService;

public class OrderController {

    private OrderService orderService;

    private ItemService itemService;

    public OrderController(OrderService orderService,
                           ItemService itemService) {

        this.orderService = orderService;
        this.itemService = itemService;
    }

    // 상품 목록 출력
    public void showItems() {

        System.out.println("===== 상품 목록 =====");

        for (Item item : itemService.getItems()) {

            System.out.println(
                    item.getId()
                            + " / "
                            + item.getName()
                            + " / "
                            + item.getPrice()
            );
        }
    }

    // 주문 요청
    public String order(User user,
                        String itemId) {

        return orderService.order(user, itemId);
    }
}