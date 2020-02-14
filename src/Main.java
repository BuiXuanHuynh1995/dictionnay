import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Thêm từ.");
        System.out.println("2. Hiển thị");
        System.out.println("3. Tìm");
        System.out.println("4. Sửa");
        System.out.println("5. Xóa");
        System.out.println("6. Ghi file");
        System.out.println("7. đọc file");
        System.out.println("8. exit");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
            showMenu();
            System.out.println("Moi nhap lua chon: ");
            int luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    controller.themTu();
                    break;
                case 2:
                    controller.hienThiDanhSachTu();
                    break;
                case 3:
                    controller.tim();
                    break;
                case 4:
                    controller.suaTu();
                    break;
                case 5:
                    controller.xoa();
                    break;
                case 6:
                    controller.ghiFile();
                    break;
                case 7:
                    controller.docFile();
                    break;
                case 8:
                    System.exit(8);
            }
        }
    }
}
