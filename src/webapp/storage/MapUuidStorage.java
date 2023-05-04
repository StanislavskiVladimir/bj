package webapp.storage;

import webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage{
    private Map<String,Resume> map = new HashMap<>();


    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
