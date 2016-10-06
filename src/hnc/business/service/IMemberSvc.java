
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
    public ArrayList<Member> getFamilyMembers(String famId) throws Exception;
    public void updateFamilyId (String famId, String memId) throws Exception;
    //public void updateMemberFamily(Member member, String famId) throws Exception;
}
