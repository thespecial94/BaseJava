package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Резюме " + resume.getUuid() + " было актулизировано!");
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(countResume >= STORAGE_LIMIT) {
            System.out.println("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + STORAGE_LIMIT);
        } else if(index >= 0) {
            System.out.println("Ошибка: резюме " + resume.getUuid()  + " не добавлено!");
        } else {
            saveElement(resume, index);
            countResume++;
            System.out.println("Резюме " + resume.getUuid() + " добавлено!");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Ошибка: резюме " + uuid  + " не удалено!");
        } else {
            deleteElement(index);
            storage[countResume] = null;
            System.out.println("Резюме " + uuid  + " удалено!");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public void clear() {
        if (countResume > 0) {
            Arrays.fill(storage, 0, countResume, null);
            countResume = 0;
        }
    }

    public int size() {
        return countResume;
    }

    protected abstract int getIndex(String uuid);
    protected abstract void saveElement(Resume resume, int index);
    protected abstract void deleteElement(int index);
}
