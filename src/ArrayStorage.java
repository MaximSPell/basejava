import java.util.Arrays;

import static java.util.logging.Logger.global;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResume;
    private int index;

    private boolean check(Resume resume) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                index = i;
                return true;
            }
        }
        return false;
    }

    private boolean check(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void update(Resume resume) {
        if (check(resume)) {
            storage[index] = resume;
            return;
        }
        System.out.println("The resume not found");
    }

    public void save(Resume resume) {
        if (countResume >= storage.length) {
            System.out.println("Not enough space!");
            return;
        }
        storage[countResume] = resume;
        countResume++;
    }

    public Resume get(String uuid) {
        if (check(uuid)) {
            return storage[index];
        }
        System.out.println("The resume not found");
        return null;
    }

    public void delete(String uuid) {
        if (check(uuid)) {
            countResume--;
            System.arraycopy(storage, index + 1, storage, index, countResume - index);
            storage[countResume] = null;
            System.out.println("Success deleted");
            return;
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
