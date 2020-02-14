import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
     LinkedList<Tu> tuDien =new LinkedList<>();
//     HashMap<String,Tu>hashMap=new HashMap<String, Tu>();
     Tu tu;
     Scanner scanner =new Scanner(System.in);

    public void hienThiDanhSachTu(){
        if (tuDien.size()==0){
            System.out.println("Khong co tu de hien thi");
        }else {
            for (Tu tu : tuDien) {
                tu.hienThi();
            }
        }
    }

    public void themTu(){
        Tu tu = new Tu();
        tu.nhapTu();
        tuDien.add(tu);
    }

    Pattern pattern;
    Matcher matcher;
    LinkedList<Tu> nhomTuTheoChuCai =new LinkedList<>();
    public void timTuTheoChuCai(){
        System.out.println("Nhap chu cai: ");
        Character chuCai =scanner.next().charAt(0);
        String regex =chuCai+"[\\w]*";
        pattern=Pattern.compile(regex);
        for (int i = 0; i < tuDien.size(); i++) {
            matcher=pattern.matcher(tuDien.get(i).getTenTu());
            if (Character.toString(tuDien.get(i).getTenTu().charAt(0)).equalsIgnoreCase(String.valueOf(chuCai))){
                nhomTuTheoChuCai.add(tuDien.get(i));
            }
        }
        if (nhomTuTheoChuCai.size()==0){
            System.out.println("Khong tim thay chu cai bat dau bang "+chuCai);
        }else {
            for (Tu nhomTu: nhomTuTheoChuCai) {
                nhomTu.hienThi();
            }
        }
    }

    public void tim() {
        timTuTheoChuCai();
        System.out.println("moi nhap tu can tim:");
        scanner.nextLine();
        String tuCanTim = scanner.nextLine();
        for (int i = 0; i< nhomTuTheoChuCai.size(); i++) {
            if (nhomTuTheoChuCai.get(i).getTenTu().equalsIgnoreCase(tuCanTim)) {
                nhomTuTheoChuCai.get(i).hienThi();
            }else {
                System.out.println("Khong tim thay");
            }
        }
        nhomTuTheoChuCai.clear();
    }

    public void suaTu() {
        nhomTuTheoChuCai.clear();
        timTuTheoChuCai();
        System.out.println("Nhap tu can sua: ");
        scanner.nextLine();
        String tuCanSua = scanner.nextLine();
        for (int i = 0; i < nhomTuTheoChuCai.size(); i++) {
            if (nhomTuTheoChuCai.get(i).getTenTu().equalsIgnoreCase(tuCanSua)) {
                System.out.println("Moi nhap ten tu:");
                String tenTu = scanner.nextLine();
                nhomTuTheoChuCai.get(i).setTenTu(tenTu);

                System.out.println("Moi nhap cach phat am");
                String phatAm = scanner.nextLine();
                nhomTuTheoChuCai.get(i).setTenTu(phatAm);

                System.out.println("Moi nhap tu loai:");
                String tuLoai = scanner.nextLine();
                nhomTuTheoChuCai.get(i).setTenTu(tuLoai);

                System.out.println("Moi nhap nghia cua tu:");
                String nghiaCuaTu = scanner.nextLine();
                nhomTuTheoChuCai.get(i).setTenTu(nghiaCuaTu);
                hienThiDanhSachTu();
            } else {
                System.out.println("Not found");
            }
        }
    }

    public void xoa(){
        nhomTuTheoChuCai.clear();
        timTuTheoChuCai();
        System.out.println("moi nhap tu can xoa:");
        scanner.nextLine();
        String tuCanXoa =scanner.nextLine();
        for (int i = 0; i< nhomTuTheoChuCai.size(); i++){
            if (nhomTuTheoChuCai.get(i).getTenTu().equalsIgnoreCase(tuCanXoa)) {
                nhomTuTheoChuCai.remove(i);
                tuDien.remove(i);
                hienThiDanhSachTu();
            }else {
                System.out.println("Khong tim thay");
            }
        }
    }

    public void ghiFile() {
        final String PATH = "E:\\codeGym\\dictionnary\\src\\tuDienAnhViet.txt";
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Tu tu : tuDien) {
                line =tu.getTenTu() + ";"+tu.getPhatAm()+";"+tu.getTuLoai() + ";"+ tu.getNghiaCuaTu()+"\n";
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi thanh cong");
    }

    public void docFile() {
        String filePath="E:\\codeGym\\dictionnary\\src\\tudien.txt";
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String regex ="@(.+);(\\/.+\\/);(\\*.+);(.+)(.*?)";
            Pattern pattern = Pattern.compile(regex);
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String tenTu = matcher.group(1);
                    String cachPhatAm = matcher.group(2);
                    String tuLoai = matcher.group(3);
                    String nghiaCuaTu= matcher.group(4);
                    tu=new Tu(tenTu,cachPhatAm,tuLoai,nghiaCuaTu);
                    tuDien.add(tu);
//                    hashMap.put(tenTu, tuDien.getLast());
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
