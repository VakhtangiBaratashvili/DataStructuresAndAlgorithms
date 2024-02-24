package datastructures.list;


public class List<T> {
    private Object[] arr;
    private int capacity = 10;
    private int size;

    public List(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.arr = new Object[capacity];
    }

    public List() {
        this.size = 0;
        this.arr = new Object[capacity];
    }

    public List(Object[] arr) {
        while (arr.length > capacity) {
            resize();
        }
        this.arr = arr;
        this.size = arr.length;
    }

    public void add(T value) {
        add(value, this.size);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object remove(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new RuntimeException("Couldn't remove");
        }
        else {
            Object value = arr[index];
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return value;
        }
    }

    public boolean remove(T value) {
        if (!contains(value) || isEmpty()) {
            return false;
        }
        else {
            for (int i = indexOf(value); i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return true;
        }
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(arr[i]);
            if (i != this.size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private void add(T value, int index) {

        if (size == capacity) {
            resize();
        } else if (index < 0 || index > size) {
            throw new RuntimeException("Couldn't add a new element");
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    private void resize() {
        Object[] temp = new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        capacity *= 2;
    }
}
