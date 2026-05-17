package org.example;

import org.example.Controller.UserController;
import org.example.domain.item.Item;
import org.example.repository.ItemRepository;
import org.example.repository.UserRepository;
import org.example.service.ItemService;
import org.example.service.UserService;
import org.example.view.UserView;

public class Start {

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        ItemRepository irepo = new ItemRepository();

        UserService userService = new UserService(repo);
        ItemService itemService = new ItemService(irepo);

        UserController userController = new UserController(userService);

        UserView userView = new UserView(userController);

        userView.start();
    }
}