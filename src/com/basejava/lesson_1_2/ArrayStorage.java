package com.basejava.lesson_1_2;

import java.util.Arrays;

public class ArrayStorage {

    public static final int LEN = 10000;
    Resume[] storage = new Resume[LEN];
    private int countResume;

    public void clear() {
        if (countResume > 0) {
            Arrays.fill(storage, 0, countResume, null);
            countResume = 0;
        }
    }

    public void update(Resume resume) {
        if (get(resume.getUuid()) != null) {
            System.out.println("Резюме " + resume.getUuid() + " актулизировано!");
        }
    }

    public void save(Resume resume) {
        if(countResume + 1 > LEN ) {
            System.out.println("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + LEN);
        } else if (get(resume.getUuid()) == null) {
            storage[countResume++] = resume;
            System.out.println("Резюме " + resume.getUuid() + " добавлено!");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.out.println("Резюме " + uuid  + " найдено!");
                return storage[i];
            }
        }
        System.out.println("Ошибка: резюме " + uuid  + " не найдено!");
        return null;
    }

    public void delete(String uuid) {
        boolean deleted = true;
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                if (i != --countResume) {
                    System.arraycopy(storage, i + 1, storage, i, countResume - i);
                }
                storage[countResume] = null;
                System.out.println("Резюме " + uuid  + " удалено!");
                deleted = false;
                break;
            }
        }
        if (deleted) {
            System.out.println("Ошибка: резюме " + uuid  + " не удалено!");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }

    public boolean printExistsResume(int index) {
        if (countResume >= index) {
            return true;
        }
        System.out.println("Ошибка: резюме не существует, под номером " + index +
                " так как превышает количество существующих резюме = " + countResume);
        return false;
    }
}