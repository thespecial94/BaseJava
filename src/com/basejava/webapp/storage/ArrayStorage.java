package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {

    public static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResume;
    private int indexUuid;

    public void clear() {
        if (countResume > 0) {
            Arrays.fill(storage, 0, countResume, null);
            countResume = 0;
        }
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                indexUuid = i;
                System.out.println("Резюме " + uuid  + " найдено!");
                return i;
            }
        }
        System.out.println("Ошибка: резюме " + uuid  + " не найдено!");
        return -1;
    }

    public void update(Resume resume) {
        if (indexUuid != -1) {
            System.out.println("Резюме " + resume.getUuid() + " актулизировано!");
        }
    }

    public boolean save(Resume resume) {
        if(countResume + 1 > STORAGE_LIMIT) {
            System.out.println("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + STORAGE_LIMIT);
            return false;
        } else if (countResume!= 0 && getIndex(resume.getUuid()) != -1) {
            return false;
        }
        storage[countResume++] = resume;
        System.out.println("Резюме " + resume.getUuid() + " добавлено!");
        return true;
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) == -1) {
            return null;
        }
        return storage[indexUuid];
    }

    public boolean delete(String uuid) {
        if (getIndex(uuid) == -1) {
            return false;
        }
        if (indexUuid != --countResume) {
            System.arraycopy(storage, indexUuid + 1, storage, indexUuid, countResume - indexUuid);
        }
        storage[countResume] = null;
        System.out.println("Резюме " + uuid  + " удалено!");
        return true;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }
}