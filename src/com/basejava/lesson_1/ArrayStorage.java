package com.basejava.lesson_1;

import java.util.Arrays;

public class ArrayStorage {

    private static final int LEN = 10000;
    Resume[] storage = new Resume[LEN];
    private int countResume;

    public void clear() {
        if (countResume > 0) {
            Arrays.fill(storage, 0, countResume, null);
            countResume = 0;
        }
    }

    public void save(Resume resume) {
        storage[countResume++] = resume;
    }

    public Resume get(String uuid) {
        for (Resume resume : getAll()) {
            if (resume.getUuid().equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                if (i != --countResume) {
                    System.arraycopy(storage, i + 1, storage, i, countResume - i + 1);
                }
                storage[countResume] = null;
                break;
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }
}