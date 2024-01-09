package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public final void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public final void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public final void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public final Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
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

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doGetAll();

        Comparator<Resume> RESUME_COMPARATOR = (resume1, resume2) -> {
            int cmp = resume1.getFullName().compareTo(resume2.getFullName());
            if (cmp == 0) {
                return resume1.getUuid().compareTo(resume2.getUuid());
            }
            return cmp;
        };

        list.sort(RESUME_COMPARATOR);
        return list;
    }

    public abstract boolean isExist(Object index);
    protected abstract Object getSearchKey(String uuid);
    protected abstract void doSave(Resume resume, Object searchKey);
    protected abstract Resume doGet(Object searchKey);
    protected abstract void doUpdate(Resume resume, Object searchKey);
    protected abstract void doDelete(Object searchKey);
    protected abstract List<Resume> doGetAll();
}
