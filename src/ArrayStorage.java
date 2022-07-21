import java.util.Arrays;

import static java.util.logging.Logger.global;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.uuid);
        if (index != -1) {
            storage[index] = resume;
            return;
        }
        System.out.println("The resume not found");
    }

    public void save(Resume resume) {
        int index = findIndex(resume.uuid);
        if (size >= storage.length) {
            System.out.println("Not enough space!");
            return;
        } else if (index != -1) {
            System.out.println("The resume already exist");
            return;
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("The resume not found");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("The resume not found");
            return;
        }
        storage[index] = null;
        size--;
        storage[index] = storage[size];
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
