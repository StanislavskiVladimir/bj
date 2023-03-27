package webapp.storage;

import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.exception.StorageException;
import webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume r) {
        int sI = searchIndex(r.getUuid());
        if (size == storage.length) {
            throw new StorageException("Недостаточно места для добавления Resume", r.getUuid());
        } else if (sI >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertElement(r, sI);
            size++;
        }
    }

    public Resume get(String uuid) {
        int sI = searchIndex(uuid);
        if (sI < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return storage[sI];
        }
    }

    public void update(Resume r) {
        int sI = searchIndex(r.getUuid());
        if (sI >= 0) {
            storage[sI] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }

    }

    public void delete(String uuid) {
        int sI = searchIndex(uuid);
        if (sI >= 0) {
            fillDeleteElement(sI);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
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

    protected abstract int searchIndex(String uuid);
    protected abstract void insertElement(Resume r, int sI);
    protected abstract void fillDeleteElement(int sI);



}
