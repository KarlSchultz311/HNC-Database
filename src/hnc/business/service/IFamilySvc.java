/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.service;

import hnc.domain.*;
/**
 *
 * @author Karl
 */
public interface IFamilySvc extends IService{
    //abstract methods
    public Member findPrimaryMember(String memId) throws Exception;
    public String createFamily(Family family) throws Exception;
    public void updateFamilyId (String famId, String memId) throws Exception;
    public Family getFamily (String famId) throws Exception;
    
}
