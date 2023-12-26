package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(countResume >= STORAGE_LIMIT) {
            throw new StorageException("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + STORAGE_LIMIT, resume.getUuid());
        } else if(index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveElement(resume, index);
            countResume++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            countResume--;
            deleteElement(index);
            storage[countResume] = null;
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
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
