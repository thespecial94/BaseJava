package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    @Override
    public final void doUpdate(Resume resume,Integer index) {
        storage[index] = resume;
    }

    public final void doSave(Resume resume, Integer index) {
        if(countResume >= STORAGE_LIMIT) {
            throw new StorageException("Ошибка: резюме " + resume.getUuid() +
                    " не добавлено, так как превышает длину хранилища = " + STORAGE_LIMIT, resume.getUuid());
        } else {
            saveElement(resume, index);
            countResume++;
        }
    }

    @Override
    public final void doDelete(Integer index) {
        countResume--;
        deleteElement(index);
        storage[countResume] = null;
    }

    @Override
    public final Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    public final boolean isExist(Integer index) {
        return index >= 0;
    }

    public List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, countResume));
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
    protected abstract void saveElement(Resume resume, int index);
    protected abstract void deleteElement(int index);
    protected abstract Integer getSearchKey(String uuid);
}