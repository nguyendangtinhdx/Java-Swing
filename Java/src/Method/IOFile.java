/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class IOFile {
    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\A","B");// tạo thư mục A và có thư mục B ở trong
//        file.mkdirs();// tạo thư mục
        File file5 = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\A");// tạo thư mục A
                file5.mkdirs();
        File file = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\A\\B.txt");// tạo file B ở trong thư mục A
//        File file = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\DemoJavaTaoFile.TXT");
        file.createNewFile(); // tạo file
//        System.out.println("Đường dẫn tuyệt đối của file: " + file.getAbsoluteFile());
//        System.out.println("Kích thước file: " + file.length() + " KB");
//        System.out.println("Last Modify Date: " + new Date(file.lastModified()));
//        System.out.println("File có thể đọc: " + file.canRead());
//        
//        File file1 = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\DemoJavaTaoFile.PDF");
//        file.renameTo(file1); // đổi đuôi file > file1
//        file.delete(); // xóa file
//        file1.delete();
        
//        File file3 = new File("C:\\Users\\Nguyen Dang Tinh\\Desktop\\A");
//        for (File f: file.listFiles()) { 
//            f.delete();// xóa all các file
//        }
//            System.out.println("Tên file: " + f.getName());// xuất all cac file trong thư mục A
    }
}
