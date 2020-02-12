import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tu {
    private String tenTu;
    private String tuLoai;
    private String nghiaCuaTu;

    public Tu() {
    }

    public Tu(String tenTu, String tuLoai, String nghiaCuaTu) {
        this.tenTu = tenTu;
        this.tuLoai = tuLoai;
        this.nghiaCuaTu = nghiaCuaTu;
    }

    public String getTenTu() {
        return tenTu;
    }

    Pattern pattern;
    Matcher matcher;
    Scanner scanner =new Scanner(System.in);
    public void setTenTu(String tenTu) {
        String regex ="^[a-zA-Z]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(tenTu);
        while (!matcher.matches()){
            System.out.println("Nhap sai dinh dang!Moi nhap lai:");
            this.setTenTu(scanner.nextLine());
        }
            this.tenTu = tenTu;
    }

    public String getTuLoai() {
        return tuLoai;
    }

    public void setTuLoai(String tuLoai) {
        String regex ="^[a-zA-Z]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(tenTu);
        while (!matcher.matches()){
            System.out.println("Nhap sai dinh dang!Moi nhap lai:");
            this.setTuLoai(scanner.nextLine());
        }
        this.tuLoai = tuLoai;
    }

    public String getNghiaCuaTu() {
        return nghiaCuaTu;
    }

    public void setNghiaCuaTu(String nghiaCuaTu) {
        String regex ="^[a-zA-Z]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(tenTu);
        while (!matcher.matches()){
            System.out.println("Nhap sai dinh dang!Moi nhap lai:");
            this.setNghiaCuaTu(scanner.nextLine());
        }
    }

    public void nhapTu(){
        System.out.println("Moi nhap tu:" );
        setTenTu(scanner.nextLine());

        System.out.println("Tu loai: ");
        setTuLoai(scanner.nextLine());

        System.out.println("Nghia cua tu: ");
        setNghiaCuaTu(scanner.nextLine());
    }

    public void hienThi(){
        System.out.printf("%-15s%-15s%-15s",tenTu,tuLoai,nghiaCuaTu+"\n");
    }
}
