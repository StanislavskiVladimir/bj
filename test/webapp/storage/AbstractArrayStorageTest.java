package webapp.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.exception.StorageException;
import webapp.model.Resume;

abstract class AbstractArrayStorageTest {
    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage){
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {

        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void save() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }

    @Test
    void get() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assertions.assertSame(r, storage.get(r.getUuid()));

    }

    @Test
    void update() {
        // TODO
    }

    @Test
    void delete() {
        storage.delete("uuid2");
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("uuid2");
        });
        Assertions.assertEquals(2, storage.size());


    }

    @Test
    void getAll() {
        Resume[] resumes = storage.getAll();
        for(Resume r : resumes){
            Assertions.assertSame(r, storage.get(r.getUuid()));
        }
        Assertions.assertEquals(resumes.length, storage.size());


    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());

    }

    @Test
    void size() {
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    void getNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("uuid0");
        });
    }

    @Test
    void saveExistStorageException(){
        Assertions.assertThrows(ExistStorageException.class, () -> {
            Resume r = new Resume(UUID_1);
            storage.save(r);
        });
    }
    @Test
    void updateNotExist(){
        Assertions.assertThrows(NotExistStorageException.class, () ->{
            storage.update(new Resume("uuid0"));
        });
    }

    @Test
    void deletNotExist(){
        Assertions.assertThrows(NotExistStorageException.class, () ->{
            storage.delete("uuid0");
        });
    }

    @Test
    void saveOverflowStorage(){
        int limit = AbstractArrayStorage.STORAGE_LIMIT;
        for(int i = storage.size()+1; i <= limit; i++){
            storage.save(new Resume("uuid" + i));
        }
        Assertions.assertThrows(StorageException.class, () ->{
            storage.save(new Resume("uuid" + (limit+1)));
        });

    }


}
