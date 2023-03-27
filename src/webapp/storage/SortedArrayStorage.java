package webapp.storage;

import webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int searchIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertElement(Resume r, int sI) {
        sI = Math.abs(sI) - 1;
        System.arraycopy(this.storage,sI, this.storage,sI+1, size-sI);
        storage[sI] = r;
    }

    @Override
    protected void fillDeleteElement(int sI) {
        System.arraycopy(this.storage,sI+1, this.storage,sI, size-sI-1);
    }


}
