package webapp.storage;

import webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {





    public void update(Resume r) {
        int sI = searchIndex(r.getUuid());
        if (sI != -1) {
            storage[sI] = r;
        } else {
            System.out.println("Невозможно обновить Resume, так как он отсутствует");
        }
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Недостаточно места для добавления Resume");
        } else if (searchIndex(r.getUuid()) != -1) {
            System.out.println("Такой webapp.model.Resume уже есть");
        } else {
            storage[size++] = r;
        }
    }

    public void delete(String uuid) {
        int sI = searchIndex(uuid);
        if (sI != -1) {
            storage[sI] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Невозможно удалить Resume, так как он отсутствует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */


    protected int searchIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }


}
