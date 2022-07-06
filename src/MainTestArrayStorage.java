/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resumeFirst = new Resume();
        resumeFirst.uuid = "uuid1";
        Resume resumeSecond = new Resume();
        resumeSecond.uuid = "uuid2";
        Resume resumeThird = new Resume();
        resumeThird.uuid = "uuid3";

        ARRAY_STORAGE.save(resumeFirst);
        ARRAY_STORAGE.save(resumeSecond);
        ARRAY_STORAGE.save(resumeThird);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resumeFirst.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(resumeFirst.uuid);
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
