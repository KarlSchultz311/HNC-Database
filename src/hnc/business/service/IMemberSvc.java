/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.service;

import hnc.domain.Member;
import java.util.ArrayList;

/**
 *
 * @author Karl
 */
public interface IMemberSvc extends IService{
    
    //abstract methods
    public String saveMember(Member member) throws Exception;
    public Member findMember (String memId) throws Exception;
    public Boolean deleteMember(String memId) throws Exception;
    public void updateMember(Member member) throws Exception;
    public ArrayList<Member> displayMemberSearch(Member member) throws Exception;
    
}
