package bt1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        // Thêm phần tử
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "D"); // Thêm vào vị trí 1

        System.out.println("Danh sách sau khi thêm phần tử: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Xóa phần tử
        list.remove(2); // Xóa phần tử tại vị trí 2
        System.out.println("\nDanh sách sau khi xóa phần tử tại vị trí 2: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Kiểm tra phần tử
        System.out.println("\nDanh sách có chứa 'B': " + list.contains("B"));
        System.out.println("Vị trí của 'D': " + list.indexOf("D"));

        // Clear danh sách
        list.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ: " + list.size());
    }
}
