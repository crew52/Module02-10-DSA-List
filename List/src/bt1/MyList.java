package bt1;

import java.util.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0; // Số lượng phần tử hiện tại
    public static final int DEFAULT_CAPACITY = 10; // Dung lượng mặc định
    private Object[] elements; // Mảng lưu trữ các phần tử

    // Constructor mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor với dung lượng do người dùng chỉ định
    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }

    // Thêm phần tử tại vị trí chỉ định
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Xóa phần tử tại vị trí chỉ định và trả về phần tử bị xóa
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Loại bỏ phần tử cuối
        return removedElement;
    }

    // Trả về số lượng phần tử
    public int size() {
        return size;
    }

    // Tăng dung lượng lưu trữ nếu cần thiết
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Kiểm tra danh sách có chứa phần tử không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Tìm vị trí của phần tử trong danh sách, trả về -1 nếu không tồn tại
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o == null && elements[i] == null) return i;
            if (o != null && o.equals(elements[i])) return i;
        }
        return -1;
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Lấy phần tử tại vị trí chỉ định
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }

    // Xóa tất cả phần tử khỏi danh sách
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Tạo bản sao của danh sách
    public E clone() {
        try {
            MyList<E> clonedList = (MyList<E>) super.clone();
            clonedList.elements = Arrays.copyOf(elements, size);
            return (E) clonedList;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Không xảy ra
        }
    }
}

