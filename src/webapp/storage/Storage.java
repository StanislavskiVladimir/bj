package webapp.storage;

import webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {
    void save(Resume r);
    Resume get(String uuid);
    void update(Resume r);
    void delete(String uuid);
    Resume[] getAll();
    void clear();
    int size();

}
