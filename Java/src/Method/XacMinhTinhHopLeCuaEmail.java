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
public class XacMinhTinhHopLeCuaEmail {

    /*
    Một địa chỉ email username@xmail.domain gọi là hợp lệ nếu nó thỏa mãn các điều kiện sau:
    Phần username chỉ chứa kí tự chữ cái, chữ số, dấu chấm, gạch dưới, dấu trừ.
    Phần domain chỉ chứa chữ cái.
    Phần xmail chỉ chứa chữ cái.
    Không phân biệt chữ hoa, chữ thường. Hãy viết chương trình kiểm tra định dạng email 
    do người dùng nhập vào có chính xác hay không ?
    ví dụ một email chuẩn: trieu.than_92@hotmail.com
    ví dụ một email không được chấp nhận: trieu than*92@@domain.com.vn
     */

    public static void main(String[] args) {

        String s1 = "@gmail.mmm";
        String s2 = "trieu.than...92@hotmail.com.net";
        String s3 = "trieu-than.@domain.com";
        String s4 = "trieu_than92pro@gmail.com";

        isAccepted(s1);
        isAccepted(s2);
        isAccepted(s3);
        isAccepted(s4);

    }

    public static void isAccepted(String s) {
        String reg = "^[\\w-_\\.]+\\@[\\w&&[^0-9]]+\\.com$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            System.out.println("Email + " + s + " ACCEPTED!");
        } else {
            System.out.println("Email + " + s + " NOT accepted!");
        }

    }
}
