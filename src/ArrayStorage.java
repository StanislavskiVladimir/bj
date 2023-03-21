import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume r) {
        int sI = searchIndex(r.uuid);
        if (sI != -1) {
            storage[sI] = r;
        } else {
            System.out.println("Ќевозможно обновить Resume, так как он отсутствует");
        }
    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Ќедостаточно места дл€ добавлени€ Resume");
        } else if (searchIndex(r.uuid) != -1) {
            System.out.println("“акой Resume уже есть");
        } else {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        int sI = searchIndex(uuid);
        if (sI == -1) {
            System.out.println("Resume отсутствует");
            return null;
        } else {
            return storage[sI];
        }
    }

    private int searchIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }

    void delete(String uuid) {
        int sI = searchIndex(uuid);
        if (sI != -1) {
            storage[sI] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Ќевозможно удалить Resume, так как он отсутствует");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        System.arraycopy(this.storage, 0, result, 0, size);
        return result;
    }

    int size() {
        return size;
    }


}
