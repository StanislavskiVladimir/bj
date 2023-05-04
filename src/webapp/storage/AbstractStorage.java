package webapp.storage;

import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.model.Resume;

public abstract class AbstractStorage implements Storage{
    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);

    }

    @Override
    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    //сохранение резюме
    protected abstract void doSave(Resume r, Object searchKey);
    //обновление резюме
    protected abstract void doUpdate(Resume r, Object searchKey);
    //удалить резюме
    protected abstract void doDelete(Object searchKey);
    //получение резюме
    protected abstract Resume doGet(Object searchKey);
    //сущесвует ли резюме или нет
    protected abstract boolean isExist(Object searchKey);
    //поиск резюме, ранее searchIndex
    protected abstract Object getSearchKey(String uuid);

    //когда нам нужно, чтобы резюме было
    private Object getExistedSearchKey(String uuid){
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)){
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    //когдам нам нужно, чтобы резюме не было
    private Object getNotExistedSearchKey(String uuid){
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)){
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}
