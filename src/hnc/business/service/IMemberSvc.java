
package hnc.business.service;

import hnc.domain.Member;
import java.util.ArrayList;

/**IMemberSvc.java
 *This is an interface that extends IService. It allows for abstraction by the 
 * Factory to point the MemberManager to the chosen implementations of requested
 * methods.
 * @author Karl Schultz
 * Version 1.0 9/9/2016
 * Version 2.0 10/6/2016
 * Changes: findPrimaryMember moved in from IFamilySvc
 */
public interface IMemberSvc extends IService{
    
    //abstract methods
    public String createMember(Member member) throws Exception;
    public Member findMember (String memId) throws Exception;
    public Boolean deleteMember(String memId) throws Exception;
    public void updateMember(Member member) throws Exception;
    public ArrayList<Member> displayMemberSearch(Member member) throws Exception;
    public ArrayList<Member> getFamilyMembers(String famId) throws Exception;
    public void updateFamilyId (String famId, String memId) throws Exception;
    public Member findPrimaryMember(String memId) throws Exception;    
}
