
package hnc.business.manager;

import hnc.business.factory.Factory;
import hnc.domain.*;
import hnc.business.service.IFamilySvc;
import java.util.ArrayList;
/**FamilyManager.java
 * This class provides an intermediate step between the controller and the
 * end implementations of requested methods. This class deals with methods that 
 * effect family objects in permanence. All methods will refer to a Factory class
 * that will provide the implementation class for the requested method.
 *
 * @author Karl Schultz
 * Version 1.0 9/8/2016
 * Version 2/0 10/6/2016
 * Changes: Moved getPrimaryMember over to IMemberManager
 */
public class FamilyManager {
    
    //constructor
    public FamilyManager(){}
    
    
    
    public String createFamily(Family family) throws Exception{
        /*Retrieves a IFamilySvc from the factory and then requests a method from
        that IFamilySvc for the end implementation of the method to save a Family
        object to permenance. Returns the newly created familyID from the database.
        */
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.createFamily(family);
        }catch (Exception e){
            System.out.println(e);
            String error = "error";
            return error;
        }
    }
    
    
    
    public Family findFamily (String famId) throws Exception{
        /*Retrieves a IFamilySvc from the factory and then requests a method from
        that IFamilySvc for the end implementation of the method to find a Family
        object from permenance matching a familyID String.
        Returns the Family object from the database.
        */
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.findFamily(famId);
        }catch (Exception e){
            System.out.println(e);
            Family errFam = new Family("Family not found");
            return errFam;
        }
    }
    
    public void updateFamily (Family family) throws Exception{
        /*Retrieves a IFamilySvc from the factory and then requests a method from
        that IFamilySvc for the end implementation of the method to update a Family
        object in permenance with the values of a Family object.
        */
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            familySvc.updateFamily(family);
        }catch (Exception e){
            System.out.println(e);            
        }
    }
    
    public void deleteFamily (String famId) throws Exception{
        /*Retrieves a IFamilySvc from the factory and then requests a method from
        that IFamilySvc for the end implementation of the method to delete a Family
        object from permenance. 
        */
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            familySvc.deleteFamily(famId);
        }catch (Exception e){
            System.out.println(e);
            Family errFam = new Family("Family not found");            
        }
    }
    
    public ArrayList<Family> searchFamily (Family family) throws Exception{
        /*Retrieves a IFamilySvc from the factory and then requests a method from
        that IFamilySvc for the end implementation of the method to use a Family
        object as parameters for a database search. Returns an ArrayList of Family
        objects from the database search.
        */
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.searchFamily(family);
        }catch (Exception e) {
            System.out.println(e);
            ArrayList<Family> list = new ArrayList<Family>();
            Family  errFam = new Family();
            errFam.setLName("Error @ Fam Manager");
            list.add(errFam);
            return list;            
        }
    }
}
