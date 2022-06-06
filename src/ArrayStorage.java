import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int pos = -1;
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                pos = i;
                break;
            }
        }
        if (pos >= 0) {
            for (int i = pos + 1; i < count; i++) {
                storage[i - 1] = storage[i];
            }
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    int size() {
        return count;
    }
}
