/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FeeAccountAction;
import java.util.Scanner;
import model.dto.FeeAccount;

/**
 *
 * @author BVMT
 */
public class ProgramRun {
    public static void main(String[] args) {
        FeeAccount fee = new FeeAccount();
        FeeAccountAction action = new FeeAccountAction();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap AccountID: ");
        int accountId = new Scanner(System.in).nextInt();
        fee.setAccountId(accountId);
        System.out.println("Nhap RoleId: ");
        int roleId = new Scanner(System.in).nextInt();
        fee.setRoleId(roleId);
        System.out.println("Nhap Username: ");
        String userName = new Scanner(System.in).nextLine();
        fee.setUsername(userName);
        System.out.println("Nhap Password: ");
        String password = new Scanner(System.in).nextLine();
        fee.setPassword(password);
        action.create(fee);
    }
    
}
