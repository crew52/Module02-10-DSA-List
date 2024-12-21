package th2;

// Lớp MyLinkedList để quản lý một danh sách liên kết đơn
public class MyLinkedList {
    // Node đầu tiên của danh sách
    private Node head;

    // Số lượng Node trong danh sách
    private int numNodes;

    // Constructor, khởi tạo danh sách liên kết với một Node chứa dữ liệu đầu tiên
    public MyLinkedList(Object data) {
        head = new Node(data); // Tạo Node đầu tiên
        numNodes++; // Tăng số lượng Node
    }

    // Phương thức thêm một Node tại vị trí index trong danh sách
    public void add(int index, Object data) {
        Node temp = head; // Biến tạm trỏ đến Node đầu tiên
        Node holder; // Biến tạm để lưu Node tiếp theo

        // Duyệt danh sách để tìm vị trí chèn
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next; // Di chuyển temp đến Node tại vị trí index-1
        }

        holder = temp.next; // Lưu Node tại vị trí index (nếu có)
        temp.next = new Node(data); // Chèn Node mới vào vị trí index
        temp.next.next = holder; // Liên kết Node mới với phần còn lại của danh sách
        numNodes++; // Tăng số lượng Node
    }

    // Phương thức thêm một Node mới vào đầu danh sách
    public void addFirst(Object data) {
        Node temp = head; // Lưu Node đầu hiện tại
        head = new Node(data); // Tạo Node mới làm Node đầu
        head.next = temp; // Liên kết Node mới với Node cũ đầu danh sách
        numNodes++; // Tăng số lượng Node
    }

    // Phương thức lấy Node tại vị trí index
    public Node get(int index) {
        Node temp = head; // Bắt đầu từ Node đầu tiên
        // Duyệt danh sách đến vị trí index
        for (int i = 0; i < index; i++) {
            temp = temp.next; // Di chuyển temp đến Node tiếp theo
        }
        return temp; // Trả về Node tại vị trí index
    }

    // Phương thức in toàn bộ dữ liệu trong danh sách
    public void printList() {
        Node temp = head; // Bắt đầu từ Node đầu tiên
        while (temp != null) { // Lặp đến khi hết danh sách
            System.out.println(temp.data); // In dữ liệu của Node hiện tại
            temp = temp.next; // Di chuyển temp đến Node tiếp theo
        }
    }

    // Lớp Node là một lớp lồng bên trong, đại diện cho từng phần tử của danh sách
    private class Node {
        private Node next; // Trỏ đến Node tiếp theo
        private Object data; // Dữ liệu lưu trong Node

        // Constructor khởi tạo Node với dữ liệu
        public Node(Object data) {
            this.data = data;
        }

        // Phương thức trả về dữ liệu của Node
        public Object getData() {
            return this.data;
        }
    }
}
