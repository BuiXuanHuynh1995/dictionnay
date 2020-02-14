import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tu {
    private String tenTu;
    private String phatAm;
    private String tuLoai;
    private String nghiaCuaTu;

    public Tu() {
    }

    public Tu(String tenTu, String phatAm, String tuLoai, String nghiaCuaTu) {
        this.tenTu = tenTu;
        this.phatAm = phatAm;
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

    public String getPhatAm() {
        return phatAm;
    }

    public void setPhatAm(String phatAm) {
        String regex ="^[a-zA-Z]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(phatAm);
        while (!matcher.matches()){
            System.out.println("Nhap sai dinh dang!Moi nhap lai:");
            this.setPhatAm(scanner.nextLine());
        }
        this.phatAm = phatAm;
    }

    public String getTuLoai() {
        return tuLoai;
    }

    public void setTuLoai(String tuLoai) {
        String regex ="^[a-z\\sA-Z]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(tuLoai);
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
        String regex ="^[a-zA-Z\\s]{1,50}$";
        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(nghiaCuaTu);
        while (!matcher.matches()){
            System.out.println("Nhap sai dinh dang!Moi nhap lai:");
            this.setNghiaCuaTu(scanner.nextLine());
        }
        this.nghiaCuaTu = nghiaCuaTu;
    }

    public void nhapTu(){
        System.out.println("Moi nhap tu:" );
        setTenTu(scanner.nextLine());

        System.out.println("Cach phat am:");
        setPhatAm(scanner.nextLine());

        System.out.println("Tu loai: ");
        setTuLoai(scanner.nextLine());

        System.out.println("Nghia cua tu: ");
        setNghiaCuaTu(scanner.nextLine());
    }

    public void hienThi(){
        System.out.printf("%-15s%-30s%-20s%-20s",tenTu,phatAm,tuLoai,nghiaCuaTu+"\n");
    }
}
