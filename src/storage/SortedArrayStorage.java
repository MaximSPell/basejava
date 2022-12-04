package storage;

import model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        System.arraycopy(storage, -index, storage, -index + 1, size - (-index));
        storage[-index] = resume;
        size++;
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        size--;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size] = null;
    }
}