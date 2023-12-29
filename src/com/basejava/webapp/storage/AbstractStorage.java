package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        executeUpdate(resume, searchKey);
    }

    public final void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        executeSave(resume, searchKey);
    }

    public final void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        executeDelete(searchKey);
    }

    public final Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return executeGet(searchKey);
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public abstract boolean isExist(Object index);
    protected abstract Object getSearchKey(String uuid);
    protected abstract void executeSave(Resume resume, Object searchKey);
    protected abstract Resume executeGet(Object searchKey);
    protected abstract void executeUpdate(Resume resume, Object searchKey);
    protected abstract void executeDelete(Object searchKey);
}
