import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
     static LinkedList<Tu>tus=new LinkedList<>();
     static HashMap<String,Tu>hashMap=new HashMap<String, Tu>();
    static Tu tu;
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
                nhomTuCanTim.get(i).hienThi();
            }else {
                System.out.println("Not found");
                break;
            }
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

                System.out.println("Moi nhap cach phat am");
                String phatAm=scanner.nextLine();
                tu.setPhatAm(phatAm);

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
        System.out.println("moi nhap tu can xoa:");
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
        System.out.printf("%-15s%-30s%-20s-%50s","Ten tu","Phat am","Tu loai","nghiaCuaTu"+"\n");
        for (int i=0;i<nhomTuCanTim.size();i++) {
            if (nhomTuCanTim.get(i).getTenTu().equalsIgnoreCase(tuCanTim)) {
                nhomTuCanTim.get(i).hienThi();
                break;
            }else {
                System.out.println("Not found");
                break;
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

    public static void readFile() {
        String filePath="E:\\codeGym\\dictionnary\\src\\tudien.txt";
        File file = new File(filePath);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String regex ="^(.+)(\\/.+\\/);(\\*.+);(.+)(.*?)$";
            Pattern pattern = Pattern.compile(regex);
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String tenTu = matcher.group(1);
                    String cachPhatAm = matcher.group(2);
                    String tuLoai = matcher.group(3);
                    String nghiaCuaTu= matcher.group(4);
                    tu=new Tu(tenTu,cachPhatAm,tuLoai,nghiaCuaTu);
                    tus.add(tu);
                    hashMap.put(tenTu,tus.getLast());
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
