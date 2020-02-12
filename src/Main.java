import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
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
                    controller.writeFileStudent();
                    break;
                case 7:
                    controller.readFile();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
