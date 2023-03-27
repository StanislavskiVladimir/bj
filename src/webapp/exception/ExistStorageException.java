package webapp.exception;
//Исключение для тех случаев, когда объекта Resume есть

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume уже существует ",uuid);
    }
}
