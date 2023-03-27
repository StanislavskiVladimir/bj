package webapp.storage;

import webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int searchIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    protected void insertElement(Resume r, int sI) {
        storage[size] = r;
    }

    protected void fillDeleteElement(int sI) {
        storage[sI] = storage[size - 1];

    }

}
