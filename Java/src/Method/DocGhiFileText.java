/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DocGhiFileText {
    public static void main(String[] args) {
        File file = new File("OUTPUTFileJava.TXT");
        try(//FileWriter fw = new FileWriter(file,true); // ghi thêm vào file (tăng gấp đôi dữ liệu)
              //  BufferedWriter bf = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(file)) {
            pw.println("Hello Nguyễn Đăng Tỉnh"); // ghi file
            pw.println("Ghi file từ bằng Java");
        } catch (Exception e) {
            
        }
    }
}
