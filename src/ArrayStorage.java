import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int top = 0;//add new field for the actual array size
                // and the position of adding new elements

    void clear() {
        for (int i = 0; i < top; i++) {
            storage[i] = null;
        }
        top = 0;
    }

    void save(Resume r) {
        storage[top] = r;
        top++;
    }

    Resume get(String uuid) {
        int pos = -1;
        for (int i = 0; i < top; i++) {
            if(storage[i].uuid.equals(uuid)){
                pos = i;
                break;
            }
        }
        if (pos >= 0){
            return storage[pos];
        }else {
            return null;
        }
    }

    void delete(String uuid) {
        int pos = -1;
        for (int i = 0; i < top; i++) {
            if(storage[i].uuid.equals(uuid)){
                pos = i;
                break;
            }
        }
        if (pos >= 0){
            for (int i = pos + 1; i < top; i++){
                storage[i-1] = storage[i];
            }
            top--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage,0, top);
    }

    int size() {
        return top;
    }
}
