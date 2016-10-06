
package hnc.business.manager;

import hnc.business.factory.Factory;
import hnc.domain.*;
import hnc.business.service.IFamilySvc;
import java.util.ArrayList;
/**
 *
 * @author Karl
 */
public class FamilyManager {
    
    //constructor
    public FamilyManager(){}
    
    public Member getPrimaryMember(String memId) throws Exception{
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.findPrimaryMember(memId);
        }catch (Exception e){
            System.out.println(e);
            Member errorMember = new Member();
            return errorMember;
        }
    }
    
    public String createFamily(Family family) throws Exception{
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
    
    
    
    public Family getFamily (String famId) throws Exception{
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.getFamily(famId);
        }catch (Exception e){
            System.out.println(e);
            Family errFam = new Family("Family not found");
            return errFam;
        }
    }
    
    public void updateFamily (Family family) throws Exception{
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            familySvc.updateFamily(family);
        }catch (Exception e){
            System.out.println(e);            
        }
    }
    
    public void deleteFamily (String famId) throws Exception{
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
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            return familySvc.searchFamily(family);
        }catch (Exception e) {
            System.out.println(e);
            ArrayList<Family> list = new ArrayList();
            Family  errFam = new Family();
            errFam.setLName("Error @ Fam Manager");
            list.add(errFam);
            return list;            
        }
    }
}
