package webapp.exception;
//Исключение для тех случаев, когда объекта Resume нету

public class NotExistStorageException extends StorageException{

    public NotExistStorageException(String uuid) {
        super("Resume не существует ",uuid);
    }
}
