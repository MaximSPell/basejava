import model.Resume;
import storage.ArrayStorage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resumeFirst = new Resume();
        resumeFirst.setUuid("uuid1");
        Resume resumeSecond = new Resume();
        resumeSecond.setUuid("uuid2");
        Resume resumeThird = new Resume();
        resumeThird.setUuid("uuid3");

        ARRAY_STORAGE.save(resumeFirst);
        ARRAY_STORAGE.save(resumeSecond);
        ARRAY_STORAGE.save(resumeThird);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resumeFirst.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(resumeFirst.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
