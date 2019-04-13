/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class KiemTraDinhDangNhapLieuChoUsername {
    // Một username gọi là chuẩn nếu nó bắt đầu bởi chữ cái B hoặc b, theo sau là hai chữ số, tiếp đó
    // là 4 kí tự chữ cái hoa hoặc thường và kết thúc bởi 3 chữ số.
    // viết chương trình kiểm tra xem dữ liệu nhập vào của người dùng có chính xác hay không.
    // ví dụ một username chính xác: B14DCCN175, không chinh xác: B14DC5G8t9

    public static void main(String[] args) {

        String s1 = "b14dccn175";
        String s2 = "B14DCCN589";
        String s3 = "g52oiyh968";
        String s4 = "B18DCQT234";
        String s5 = "b16Dc5T636";

        isAccepted(s1);
        isAccepted(s2);
        isAccepted(s3);
        isAccepted(s4);
        isAccepted(s5);

    }

    static void isAccepted(String s) {
        Pattern pattern = Pattern.compile("\\A[bB][0-9]{2}[a-zA-Z]{4}[0-9]{3}$");//"^[bB]\\d{2}[a-zA-Z]{4}\\d{3}$"
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            System.out.println("Accepted!");
        } else {
            System.out.println("Failed. Try again!");
        }
    }
}
