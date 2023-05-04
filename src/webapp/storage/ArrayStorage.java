package webapp.storage;

import webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    protected void insertElement(Resume r, int searchKey) {
        storage[size] = r;
    }

    protected void fillDeleteElement(int searchKey) {
        storage[searchKey] = storage[size - 1];

    }

}
