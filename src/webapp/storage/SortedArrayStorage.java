package webapp.storage;

import webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertElement(Resume r, int searchKey) {
        searchKey = Math.abs(searchKey) - 1;
        System.arraycopy(this.storage,searchKey, this.storage,searchKey+1, size-searchKey);
        storage[searchKey] = r;
    }

    @Override
    protected void fillDeleteElement(int searchKey) {
        System.arraycopy(this.storage,searchKey+1, this.storage,searchKey, size-searchKey-1);
    }


}
