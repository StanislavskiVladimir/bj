package webapp.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webapp.exception.StorageException;
import webapp.model.Resume;

abstract class AbstractArrayStorageTest extends AbstractStorageTest{


    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    void saveOverflowStorage(){
        int limit = AbstractArrayStorage.STORAGE_LIMIT;
        try {
            for(int i = storage.size()+1; i <= limit; i++){
                storage.save(new Resume("uuid" + i));
            }
        } catch (Exception e) {
            Assertions.fail();
        }
        Assertions.assertThrows(StorageException.class, () ->{
            storage.save(new Resume("uuid" + (limit+1)));
        });

    }


}
