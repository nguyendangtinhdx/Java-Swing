/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Demo extends JFrame{
    private JFrame frame;
    JButton button;
    public void JFrame(){
        createAndShow();
    }
    public void createAndShow(){
        button = new JButton("OK");// thêm nút button vào Frame
        frame = new JFrame("Title");
        setSize(400,300);
        setLocationRelativeTo(null);// chính giữa màn hình
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE);// click vào kết thúc thì chương trình kết thúc luôn
        add(button);
        setLayout(new FlowLayout());
//        frame.park(); // ngươc với setSize: tạo khung vừa đủ nút OK
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo();
    }
}
