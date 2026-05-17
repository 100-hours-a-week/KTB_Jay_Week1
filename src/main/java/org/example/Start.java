package org.example;

import org.example.controller.OrderController;
import org.example.controller.UserController;
import org.example.repository.ItemRepository;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.example.service.ItemService;
import org.example.service.OrderService;
import org.example.service.UserService;
import org.example.view.OrderView;
import org.example.view.UserView;

public class Start {

    public static void main(String[] args) {

        // repository 생성
        UserRepository userRepository =
                new UserRepository();

        ItemRepository itemRepository =
                new ItemRepository();

        OrderRepository orderRepository =
                new OrderRepository();

        // service 생성
        UserService userService =
                new UserService(userRepository);

        ItemService itemService =
                new ItemService(itemRepository);

        OrderService orderService =
                new OrderService(
                        userRepository,
                        itemRepository,
                        orderRepository
                );

        // controller 생성
        UserController userController =
                new UserController(userService);

        OrderController orderController =
                new OrderController(
                        orderService,
                        itemService
                );

        // view 생성
        OrderView orderView =
                new OrderView(orderController);

        UserView userView =
                new UserView(
                        userController,
                        orderView
                );

        // 시작
        userView.start();
    }
}