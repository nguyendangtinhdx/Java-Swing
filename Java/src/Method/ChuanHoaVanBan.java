/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ChuanHoaVanBan {

    /*
    Chuẩn hóa xâu kí tự: loại bỏ dấu cách thừa ở trong câu, 
    loại bỏ dấu cách trước các dấu câu, thêm dấu cách đằng sau 
    các dấu câu. viết thường, viết hoa
    các chữ cái sau dấu câu theo quy luật chính tả.
    
    -->> ý tưởng, các bước chuẩn hóa:
    
    B1: Viết thường tất cả các chữ cái của xâu.
    B2: Loại bỏ tất cả các dấu cách thừa: đầu, cuối, giữa xâu
    B3: Thêm dấu cách vào sau cac dấu  , . ? ! ; : ( ) ...
    B4: Loại bỏ dấu cách trước các dấu , . ? ! ; : ( ) ...
    B5: Viết hoa chữ cái sau ba dấu . ? !
    B6: Trả về kết quả. 
        --->> The end.
     */

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        System.out.println("Xau truoc khi chuan hoa: \n" + s);
        System.out.println("Xau sau khi chuan hoa: \n" + getRes(s.toLowerCase()).toString());
        System.out.println("");
    }

    static StringBuilder getRes(String s) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder(matcher.replaceAll(" "));
        if (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 1) {
                if ((sb.charAt(i) == ',' || sb.charAt(i) == '.' || sb.charAt(i) == '?'
                        || sb.charAt(i) == ';' || sb.charAt(i) == ':' || sb.charAt(i) == '!')
                        && sb.charAt(i + 1) != ' ') {
                    sb.insert(i + 1, " ");
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 1) {
                if ((sb.charAt(i + 1) == ',' || sb.charAt(i + 1) == '.' || sb.charAt(i + 1) == '?'
                        || sb.charAt(1 + i) == ';' || sb.charAt(i + 1) == ':' || sb.charAt(1 + i) == '!')
                        && sb.charAt(i) == ' ') {
                    sb.deleteCharAt(i);
                }
            }
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 2) {
                if (sb.charAt(i) == '.' || sb.charAt(i) == '?' || sb.charAt(i) == '!') {
                    sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(2 + i)));
                }
            }
        }

        return sb;

    }

}
