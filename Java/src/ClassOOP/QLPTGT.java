/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassOOP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Than
 */
public class QLPTGT{
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<PT> list;
    public QLPTGT(){
        list = new ArrayList();
    }
    
    public ArrayList getArrayList(){
        return list;
    }
    
    public static void main(String[] args) throws IOException {
        QLPTGT ex = new QLPTGT();
        
        
        int lc;
        do{
            System.out.println("Nhap cac lua chon: \n0_Thoat.\n1_Nhap Xe may."
                    + "\n2_Nhap Oto.\n3_Nhap xe tai.\n4_Xuat thong tin cac ptgt."
                    + "\n5_Tim kiem ptgt theo hang san xuat.\n6_Tim theo khoang gia."
                    + "\n7_Sap xep theo Gia.\n8_Sap xep theo Hang san xuat."
                    + "\n9_Tinh toan tong gia theo hang.\n10_Ghi thong tin ra file text."
                    + "\n11_Ghi thong tin ra file kieu Object.\n12_Doc thong tin tu file text."
                    + "\n13_Doc thong tin tu file kieu Object."
                    + "\nBan chon ? ");
            lc = sc.nextInt();
            switch(lc){
                case 0: break;
                case 1:{
                    ex.nhapXeMay();
                    break;
                }
                case 2:{
                    ex.nhapOto();
                    break;
                }
                case 3:{
                    ex.nhapXeTai();
                    break;
                }
                case 4:{
                    ex.display(ex.getArrayList());
                    break;
                }
                case 5:{
                    System.out.println("Nhap ten hang can tim: ");
                    ex.timKiemTheoHangSX(sc.next());
                    break;
                }
                case 6:{
                    System.out.println("tim theo khoang gia: ");
                    System.out.println("nhap gia tu ?$ toi ?$");
                    ex.timKiemTheoGia(sc.nextInt(), sc.nextInt());
                    break;
                }
                case 7:{
                    ex.sortByGia();
                    break;
                }
                case 8:{
                    ex.sortByHang();
                    break;
                }
                
                case 9:{
                    System.out.println("Nhap hang can tim: ");
                    ex.tinhGiaTheoHang(sc.next());
                    break;
                }
                case 10:{
                    ex.ghiFileText();
                    break;
                }
                case 11:{
                    ex.ghiFileObject();
                    break;
                }
                case 12:{
                    ex.docFileText();
                    break;
                }
                case 13:{
                    ex.docfileObject();
                    break;
                }
            }
        } while(lc != 0);
        
    }
    
      private PTGT nhapPTGT(){
          PTGT p = new PTGT();
          System.out.println("Nhap Hang: ");
          p.hang = sc.next();
          //p.setHang(sc.next());
          System.out.println("Nam SX: ");
          p.setNamSX(sc.nextInt());
          System.out.println("Gia: ");
          p.setGiaBan(sc.nextInt());
          System.out.println("Mau: ");
          p.setColor(sc.next());
          return p;
      }
      
      public void nhapXeMay(){
          PTGT p = nhapPTGT();
          XeMay x = new XeMay();
          System.out.println("Cong suat: ");
          x.setCongSuat(sc.nextInt());
          x.setColor(p.getColor());
          x.setGiaBan(p.getGia());
          x.setNamSX(p.getNamSX());
          x.setHang(p.getHang());
          list.add(x);
      }
      
      public void nhapOto(){
          PTGT p = nhapPTGT();
          Oto x = new Oto();
          System.out.println("So cho: ");
          x.setSoCho(sc.nextInt());
          System.out.println("Kieu DC: ");
          sc.nextLine();
          x.setKieuDC(sc.nextLine());
          x.setColor(p.getColor());
          x.setGiaBan(p.getGia());
          x.setNamSX(p.getNamSX());
          x.setHang(p.getHang());
          list.add(x);
      }
      
      public void nhapXeTai(){
          PTGT p = nhapPTGT();
          XeTai x = new XeTai();
          System.out.println("Trong Tai: ");
          x.setTT(sc.nextDouble());
          x.setColor(p.getColor());
          x.setGiaBan(p.getGia());
          x.setNamSX(p.getNamSX());
          x.setHang(p.getHang());
          list.add(x);
      }
      
      public void display(ArrayList<PT> arr){
          System.out.println("Hang\t Nam SX\t Mau\t Gia\tC.Suat.\tT.Tai\t S.Cho\t KieuDC");
          for(PT p: arr){
              System.out.println(  p.toString());
          }
          System.out.println("");
      }
      
      public void timKiemTheoHangSX(String s){
          ArrayList<PT> arr = new ArrayList();
          for(PT p:list){
                  if(((PTGT)p).hang.toLowerCase().matches(".*" + s.toLowerCase() + ".*"))
                      arr.add(p);
          }
          if(arr.isEmpty()) System.out.println("Khong tim thay hang ban muon.");
          else display(arr);
      }
      
     public void timKiemTheoGia( int from, int to ){
          ArrayList<PT> arr = new ArrayList();
          for(PT p:list){            
                  if(((PTGT)p).getGia() >= from && ((PTGT)p).getGia()<= to )
                      arr.add(p);
          }
          if(arr.isEmpty()) System.out.println("Khong tim thay PT trong khoang gia ban muon.");
          else display(arr);
      } 
     
     public void sortByHang(){
         for (int i = 0; i < list.size()-1; i++) {
             for (int j = i+1; j < list.size(); j++) {
                 if(((PTGT)list.get(i)).hang.compareToIgnoreCase(((PTGT)list.get(j)).hang) > 0){
                     PT p = list.get(i);
                     list.set(i, list.get(j));
                     list.set(j, p);
                 }
             }
         }
     }
     
     public void sortByGia(){
         for (int i = 0; i < list.size()-1; i++) {
             for (int j = i+1; j < list.size(); j++) {
                 if(((PTGT)list.get(i)).gia  > ((PTGT)list.get(j)).gia){
                     PT p = list.get(i);
                     list.set(i, list.get(j));
                     list.set(j, p);
                 }
             }
         }
     }
     
     public void tinhGiaTheoHang(String h){
         long total = 0;
         for(PT p:list){
             if(((PTGT)p).hang.toLowerCase().matches(".*" + h.toLowerCase() + ".*"))
                 total+= ((PTGT)p).gia;
          }
         System.out.println("Tong gia ban cua hang "+h+" = "+total);
     }
     
     public void ghiFileText(){ // ghi thong tin kieu text ra file
         try(PrintWriter pr = new PrintWriter("Data.txt")){
             for(PT p: list){
                 pr.println(p.toString());
             }
             System.out.println("Write to file success.");
         } catch(IOException e){
             System.out.println("Got an exception.");
         }
     }
     
     public void ghiFileObject(){ // ghi thong tin kieu Object ra file.
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.DAT"))){
             oos.writeObject(list);
             System.out.println("Write to file success.");
         } catch(IOException e){
             System.out.println("Got an exception.");
         }
     }
     
     public void docFileText(){ //doc thong tin ra tu file text
         try(Scanner read = new Scanner(new File("Data.txt"))){
             while(read.hasNext()){
                 System.out.println(read.nextLine());
             }
             System.out.println("Read from file success.");
         } catch(IOException e){
             System.out.println("Got an exception.");
         }
     }
     
     public void docfileObject(){ // doc thong tin ra tu file Object
         
         try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Data.DAT"))){
             ArrayList<PT> p  = (ArrayList<PT>) oos.readObject();
             display(p);
             System.out.println("Read from file success.");
         } catch(IOException e){
             System.out.println("Got an IOException.");
         } catch (ClassNotFoundException ex) {
             System.out.println("Got an ClassNotFoundException.");
         }
     }
     
}
