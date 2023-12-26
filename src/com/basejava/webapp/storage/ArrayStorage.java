package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected void saveElement(Resume resume, int index) {
        storage[countResume] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        storage[index] = storage[countResume];
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}