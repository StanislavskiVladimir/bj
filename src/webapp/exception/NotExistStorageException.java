package webapp.exception;
//���������� ��� ��� �������, ����� ������� Resume ����

public class NotExistStorageException extends StorageException{

    public NotExistStorageException(String uuid) {
        super("Resume �� ���������� ",uuid);
    }
}
