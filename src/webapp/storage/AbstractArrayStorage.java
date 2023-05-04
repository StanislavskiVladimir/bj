package webapp.storage;

import webapp.exception.StorageException;
import webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void doSave(Resume r, Object searchKey) {
        if (size == storage.length) {
            throw new StorageException("Недостаточно места для добавления Resume", r.getUuid());
        } else {
            insertElement(r, (Integer) searchKey);
            size++;
        }
    }

    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeleteElement((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        System.arraycopy(this.storage, 0, result, 0, size);
        return result;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void insertElement(Resume r, int sI);

    protected abstract void fillDeleteElement(int sI);


}
