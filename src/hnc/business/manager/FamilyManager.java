/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.manager;

import hnc.business.factory.Factory;
import hnc.domain.*;
import hnc.business.service.IFamilySvc;
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
    
    public void updateFamilyId (String famId, String memId) throws Exception{
        Factory factory = new Factory();
        try{
            IFamilySvc familySvc = (IFamilySvc)factory.getService("IFamilySvc");
            familySvc.updateFamilyId(famId, memId);
        }catch (Exception e){
            System.out.println(e);            
        }
    }
    
}
