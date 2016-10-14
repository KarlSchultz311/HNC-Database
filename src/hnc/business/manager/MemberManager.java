
package hnc.business.manager;

import hnc.domain.Member;
import hnc.business.factory.Factory;
import hnc.business.service.IMemberSvc;
import java.util.ArrayList;

/**MemberManager.java
 * This class provides an intermediate step between the controller class and the 
 * implementations of the required methods. The Member manager is used for methods
 * that impact Member objects in the database. Methods in this class will refer
 * to the Factory object to obtain the correct method of implementation for the
 * requested methods. This allows for a high amount of abstraction.
 *
 * @author Karl Schultz
 * Version 1.0 9/5/2106
 * Version 2.0 10/6/2016
 * Changes: Moved in getPrimaryMember from FamilyManager
 */
public class MemberManager {
    
    //constructor
    public MemberManager(){}
    
    //methods
    public String createMember(Member member) throws Exception {
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to save a Member
        object to permenance. Returns the newly created memberID from the database.
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.createMember(member);
        } catch (Exception e) {
            System.out.println(e);
            return "Unable to find MemID";
        }
        
    }
    
    public Member findMember(String memId) throws Exception {
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to search for a Member
        object from permenance. Returns Member object.
        */
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
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to delete a Member
        object from permenance. Returns a boolean depending on success.
        */
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
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to update a Member
        object in permenance. 
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            memberSvc.updateMember(member);
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public ArrayList<Member> searchMember (Member member) throws Exception {
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to search for a 
        multiple Member objects from permenance using a Member object for parameters.
        Returns ArrayList of Member objects.
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.displayMemberSearch(member);
        } catch (Exception e){
            System.out.println(e);
            ArrayList<Member> list = new ArrayList<Member>();
            return list;
        }
    }
    
    public ArrayList<Member> getFamilyMembers(String famId) throws Exception {
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to search for any
        Member objects from permenance that match the provided family ID.
        Returns ArrayList of Member objects.
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.getFamilyMembers(famId);
        } catch (Exception e){
            System.out.println(e);
            ArrayList<Member> list = new ArrayList<Member>();
            return list;
        }
    }
    
    public void updateFamilyId (String famId, String memId) throws Exception{
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to update a Member
        object's family ID number in the database.
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            memberSvc.updateFamilyId(famId, memId);
        }catch (Exception e){
            System.out.println(e);            
        }
    }
    
    public Member getPrimaryMember(String memId) throws Exception{
        /*Retrieves a IMemberSvc from the factory and then requests a method from
        that IMemberSvc for the end implementation of the method to search permanence
        for a Member object from permenance. Returns Member object.
        */
        Factory factory = new Factory();
        try{
            IMemberSvc memberSvc = (IMemberSvc)factory.getService("IMemberSvc");
            return memberSvc.findPrimaryMember(memId);
        }catch (Exception e){
            System.out.println(e);
            Member errorMember = new Member();
            return errorMember;
        }
    }
}
