package webapp.storage;

import webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class  AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void update(Resume r) {
        int sI = searchIndex(r.getUuid());
        if (sI >= 0) {
            storage[sI] = r;
        } else {
            System.out.println("Невозможно обновить, так как он отсутствует");
        }

    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int sI = searchIndex(uuid);
        if (sI == -1) {
            System.out.println("Resume отсутствует");
            return null;
        } else {
            return storage[sI];
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        System.arraycopy(this.storage, 0, result, 0, size);
        return result;
    }

    protected abstract int searchIndex(String uuid);

}
