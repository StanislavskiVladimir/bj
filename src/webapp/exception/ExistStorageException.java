package webapp.exception;
//���������� ��� ��� �������, ����� ������� Resume ����

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume ��� ���������� ",uuid);
    }
}
