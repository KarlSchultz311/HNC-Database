/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.view;

import hnc.model.domain.Member;
import java.io.*;

/**
 *
 * @author Karl
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Member member = new Member();
        member.setMemId(0001);
        member.setFName("Jenny");
        member.setLName("Jones");
        System.out.print(member.toString());
        MemberUI view = new MemberUI();
    }
 
    
}
