package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {

    public static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResume;

    public void clear() {
        if (countResume > 0) {
            Arrays.fill(storage, 0, countResume, null);
            countResume = 0;
        }
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.out.println("Резюме " + uuid  + " найдено!");
                return i;
            }
        }
        System.out.println("Ошибка: резюме " + uuid  + " не найдено!");
        return -1;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            System.out.println("Резюме " + storage[0].getUuid() +
                    " было актулизировано на " + resume.getUuid());
            storage[2] = resume;
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(countResume >= STORAGE_LIMIT) {
            System.out.println("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + STORAGE_LIMIT);
        } else if (index != -1) {
            System.out.println("Ошибка: резюме " + resume.getUuid()  + " не добавлено!");
        } else {
            storage[countResume++] = resume;
            System.out.println("Резюме " + resume.getUuid() + " добавлено!");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (countResume != 0 && index == -1) {
            System.out.println("Ошибка: резюме " + uuid  + " не удалено!");
        } else {
            if (index != --countResume) {
                System.arraycopy(storage, index + 1, storage, index, countResume - index);
            }
            storage[countResume] = null;
            System.out.println("Резюме " + uuid  + " удалено!");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }
}