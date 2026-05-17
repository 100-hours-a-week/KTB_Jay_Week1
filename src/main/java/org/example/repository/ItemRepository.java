package org.example.repository;

import org.example.domain.item.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static final String FILE_PATH = "data/items.csv";

    public List<Item> findAll() {

        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Item item = new Item(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2])
                );

                items.add(item);
            }

        } catch (IOException e) {
            System.out.println("상품 로딩 실패");
        }

        return items;
    }
}