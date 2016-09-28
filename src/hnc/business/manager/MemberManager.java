/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.manager;

import hnc.domain.Member;
import hnc.business.factory.Factory;
import hnc.business.service.IMemberSvc;
import java.util.ArrayList;

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
    
    public Boolean deleteMember(String memId) throws Exception {
        Factory factory = new Factory();
        Boolean success = false;
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.deleteMember(memId);
        } catch (Exception e){
            System.out.println(e);
            return success;
        }
    }
    
    public void updateMember(Member member) throws Exception {
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            memberSvc.updateMember(member);
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public ArrayList<Member> searchMember (Member member) throws Exception {
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.displayMemberSearch(member);
        } catch (Exception e){
            System.out.println(e);
            ArrayList<Member> list = new ArrayList();
            return list;
        }
    }
    
    public ArrayList<Member> getFamilyMembers(String famId) throws Exception {
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.getFamilyMembers(famId);
        } catch (Exception e){
            System.out.println(e);
            ArrayList<Member> list = new ArrayList();
            return list;
        }
    }
}
