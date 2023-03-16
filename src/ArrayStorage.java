import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    private int size = 0;

    void clear() {
        // TODO completed
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume r) {
        // TODO completed
        for (int i = 0; i < size; i++) {
            if (r.equals(storage[i])) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Ќевозможно обновить Resume, так как он отсутствует");
    }

    void save(Resume r) {
        //TODO completed
        if (size == storage.length) {
            System.out.println("Ќедостаточно места дл€ добавлени€ Resume");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (r.equals(storage[i])) {
                System.out.println("“акое Resume уже есть");
                return;
            }
        }
        storage[size++] = r;
    }

    Resume get(String uuid) {
        // TODO completed
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];

            }
        }
        System.out.println("Resume отсутствует");
        return null;
    }

    int searchIndex(String uuid) {
        int i = 0;
        for (; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                break;
            }
        }
        return i;
    }

    void delete(String uuid) {
        // TODO completed
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Ќевозможно удалить Resume, так как он отсутствует");

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        // TODO completed
        Resume[] result = new Resume[size];
        System.arraycopy(this.storage, 0, result, 0, size);
        return result;
    }

    int size() {
        //TODO completed
        return size;
    }


}
