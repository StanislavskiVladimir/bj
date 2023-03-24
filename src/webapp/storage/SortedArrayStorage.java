package webapp.storage;

import webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public void save(Resume r) {
        int sI = searchIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("Недостаточно места для добавления Resume");
        } else if (sI >= 0) {
            System.out.println("Такой Resume уже есть");
        } else {
            sI = Math.abs(sI) - 1;
            System.arraycopy(this.storage,sI, this.storage,sI+1, size-sI);
            size++;
            storage[sI] = r;
        }
    }

    @Override
    public void delete(String uuid) {
        int sI = searchIndex(uuid);
        System.out.println(size);
        if (sI >= 0) {
            System.arraycopy(this.storage,sI+1, this.storage,sI, size-sI-1);
            size--;
        } else {
            System.out.println("Невозможно удалить Resume, так как он отсутствует");
        }
    }


    @Override
    protected int searchIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


}
