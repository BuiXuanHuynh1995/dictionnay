import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
     static LinkedList<Tu>tus=new LinkedList<>();
    Tu tu;
    static Scanner scanner =new Scanner(System.in);


    public void hienThiDanhSachTu(){
        for (int i=0;i<tus.size();i++){
            tus.get(i).hienThi();
        }
    }

    public void themTu(){
        Tu tu = new Tu();
        tu.nhapTu();
        tus.add(tu);
    }

    Pattern pattern;
    Matcher matcher;
    LinkedList<Tu>nhomTuCanTim =new LinkedList<>();

    public void timTuTheoChuCai(){
        System.out.println("Nhap chu cai: ");
        Character chuCai= Character.toUpperCase(scanner.next().charAt(0));
        String regex =chuCai+"[\\w]*";
        pattern=Pattern.compile(regex);
        for (int i=0;i<tus.size();i++){
            matcher=pattern.matcher(tus.get(i).getTenTu());
            if (matcher.matches() && Character.toUpperCase(tus.get(i).getTenTu().charAt(0))==chuCai){
                nhomTuCanTim.add(tus.get(i));
            }else {
                System.out.println("Not found");
                break;
            }
        }
        for (Tu nhomTuCanTim:tus) {
            nhomTuCanTim.hienThi();
        }
    }

    public void suaTu(){
        timTuTheoChuCai();
        System.out.println("Nhap tu can sua: ");
        scanner.nextLine();
        String tuCanSua=scanner.nextLine();
        for (Tu tu:tus){
            if (tu.getTenTu().equalsIgnoreCase(tuCanSua)){
                System.out.println("Moi nhap ten tu:" );
                String tenTu =scanner.nextLine();
                tu.setTenTu(tenTu);

                System.out.println("Moi nhap tu loai:" );
                String tuLoai =scanner.nextLine();
                tu.setTuLoai(tuLoai);

                System.out.println("Moi nhap nghia cua tu:" );
                String nghiaCuaTu =scanner.nextLine();
                tu.setNghiaCuaTu(nghiaCuaTu);
                break;
            }else {
                System.out.println("Not found");
                break;
            }
        }
        hienThiDanhSachTu();
    }

    public void xoa(){
        timTuTheoChuCai();
        System.out.println("moi nhap tu can tim:");
        scanner.nextLine();
        String tuCanXoa =scanner.nextLine();
        for (int i=0;i<nhomTuCanTim.size();i++){
            if (nhomTuCanTim.get(i).getTenTu().equals(tuCanXoa));
            nhomTuCanTim.remove(i);
            tus.remove(i);
        }
        hienThiDanhSachTu();
    }

    public void tim(){
        timTuTheoChuCai();
        System.out.println("moi nhap tu can tim:");
        scanner.nextLine();
        String tuCanTim =scanner.nextLine();
        System.out.printf("%-15s%-15s%-15s","Ten Tu","Tu Loai","nghiaCuaTu"+"\n");
        for (int i=0;i<nhomTuCanTim.size();i++) {
            if (nhomTuCanTim.get(i).getTenTu().equalsIgnoreCase(tuCanTim)) {
                nhomTuCanTim.get(i).hienThi();
                break;
            }else {
                System.out.println("Not found");
            }
        }
    }

    public void writeFileStudent() {
        final String PATH = "E:\\codeGym\\dictionnary\\src\\tudien.txt";
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Tu tu : tus) {
                line =tu.getTenTu() + ";"+ tu.getTuLoai() + ";"+ tu.getNghiaCuaTu()+"\n";
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi thanh cong");
    }

    public void readFile() {
        final String PATH = "E:\\codeGym\\dictionnary\\src\\tudien.txt";
        BufferedReader bufferedReader = null;
        String line = "";
        String splitBy = ";";
        String[] information;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line = bufferedReader.readLine()) != null) {
                information = line.split(splitBy);
                tu= new Tu(information[0], information[1], information[2]);
                tus.add(tu);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
