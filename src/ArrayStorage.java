import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResume;

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void save(Resume resume) {
        storage[countResume] = resume;
        countResume++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                countResume--;
                System.arraycopy(storage, i + 1, storage, i, countResume - i);
                storage[countResume] = null;
                System.out.println("Success deleted");
                return;
            }
        }
        System.out.println("The resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }
}
