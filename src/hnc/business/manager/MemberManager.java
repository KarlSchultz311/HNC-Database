/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.manager;

import hnc.domain.Member;
import hnc.business.factory.Factory;
import hnc.business.service.IMemberSvc;

/**
 *
 * @author Karl
 */
public class MemberManager {
    
    //constructor
    public MemberManager(){}
    
    //methods
    public String saveMember(Member member) throws Exception {
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.saveMember(member);
        } catch (Exception e) {
            System.out.println(e);
            return "Unable to find MemID";
        }
        
    }
    
    public Member findMember(String memId) throws Exception {
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.findMember(memId);
        }catch (Exception e){
            System.out.println(e);
            Member member = new Member();
            return member;
        }
           
    }
    
}
