/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DocGhiFileText2 {
    public static void main(String[] args) {
        File file = new File("OUTPUTFileJava.TXT");
        try(Scanner sc = new Scanner(file)) {
//            String str = sc.nextLine(); // đoc dòng đầu tiên của file
//            System.out.println("Nội dung vừa đọc từ file OUTPUTFileJava.TXT: " + str);
//            str = sc.nextLine(); // đoc dòng thứ 2 của file
                String str; // Int str:  nếu đọc kiểu int
            while(sc.hasNext()){
                str = sc.nextLine();
                System.out.println("Nội dung vừa đọc từ file OUTPUTFileJava.TXT: " + str);
            }
        } catch (Exception e) {
        }
    }
}   
