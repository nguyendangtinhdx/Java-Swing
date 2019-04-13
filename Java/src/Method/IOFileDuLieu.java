/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class IOFileDuLieu {
    // ghi 1 đối tượng
    public void ghi(Object o, String name){
        try (FileOutputStream fos = new FileOutputStream(new File(name))){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
        } catch (Exception e) {
            System.out.println("Got an exception in write data out file");
        }
    }
    // ghi cả danh sách hoặc ghi 1 mảng SinhVien[] list
    public void ghiDS(List list, String name){
        try (FileOutputStream fos = new FileOutputStream(new File(name))){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Got an exception in write data out file");
        }
    }
    
    // đọc 1 đối tượng
    public Object doc(String name){
        Object o = new Object();
        try (FileInputStream fos = new FileInputStream(new File(name))){
            ObjectInputStream oos = new ObjectInputStream(fos);
            o = oos.readObject();
        } catch (Exception e) {
            System.out.println("Got an exception in read data from file");
        }
        return o;
    }
    // đọc cả danh sách hoặc ghi 1 mảng SinhVien[] list
    public ArrayList docDS(String name){
        ArrayList list = new ArrayList();
        try (FileInputStream fos = new FileInputStream(new File(name))){
            ObjectInputStream oos = new ObjectInputStream(fos);
            list = (ArrayList)oos.readObject();
        } catch (Exception e) {
            System.out.println("Got an exception in read data from file");
        }
        return list;
    }
    
    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        list.add(new GhiDuLieuRaFileObjectOutputStream(21,"Hai Ba Trung","Ha Noi",8.5));
//        list.add(new GhiDuLieuRaFileObjectOutputStream(20,"Hoang Van Thu","Da Nang",8.9));
//        list.add(new GhiDuLieuRaFileObjectOutputStream(21,"Le Loi","Hue",7.8));
//        list.add(new GhiDuLieuRaFileObjectOutputStream(21,"Nguyen Hien","Ha Noi",8.5));
//        list.add(new GhiDuLieuRaFileObjectOutputStream(21,"Sao Nam","Quang Binh",6.5));
    
    IOFileDuLieu IOF = new IOFileDuLieu();
//    IOF.ghi(new GhiDuLieuRaFileObjectOutputStream(21,"Sao Nam","Quang Binh",6.5),"OutputFileObjectStream.TXT");
//    IOF.ghiDS(list,"OutputFileObjectStream.PDF");
    
    // đọc
    GhiDuLieuRaFileObjectOutputStream s = (GhiDuLieuRaFileObjectOutputStream) IOF.doc("OutputFileObjectStream.TXT");
    ArrayList<GhiDuLieuRaFileObjectOutputStream> list = new ArrayList<>();
    list = IOF.docDS("OutputFileObjectStream.PDF");
    
//    System.out.println("Thong tin sinh vien trong file OutputFileObjectStream.PDF ");
//    System.out.println(s.getTen() + ", "+ s.getTuoi()+ ", " + s.getDiaChi() + ", " + s.getDiemTB());
//    
    
    System.out.println("Thong tin sinh vien trong file OutputFileObjectStream.PDF ");
        for (GhiDuLieuRaFileObjectOutputStream s1: list) {
            System.out.println(s1.getTen() + ", "+ s1.getTuoi()+ ", " + s1.getDiaChi() + ", " + s1.getDiemTB());
        }
    
    }
}
