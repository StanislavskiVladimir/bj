import webapp.model.Resume;
import webapp.storage.ListStorage;
import webapp.storage.Storage;

/**
 * Test for your webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    //static final AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();
    static final Storage ARRAY_STORAGE = new ListStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r5 = new Resume("uuid5");
        Resume r6 = new Resume("uuid6");
        Resume r8 = new Resume("uuid8");
        Resume r4 = new Resume("uuid4");



        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        printAll();
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        printAll();
        ARRAY_STORAGE.save(r8);
        printAll();
        ARRAY_STORAGE.save(r4);
        printAll();

        System.out.println("============");
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        // System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        System.out.println("============");
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
