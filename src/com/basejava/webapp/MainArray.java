package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ArrayStorage;
import com.basejava.webapp.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainArray {
    private final static Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | size |" +
                    " update uuid fullName | save fullName | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length > 1) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "update":
                    r = new Resume(param, params[2]);
                    ARRAY_STORAGE.update(r);
                    break;
                case "save":
                    r = new Resume(param);
                    ARRAY_STORAGE.save(r);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(param);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(param));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        List<Resume> list = ARRAY_STORAGE.getAllSorted();
        System.out.println("----------------------------");
        if (list.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Resume r : list) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}