/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.factory;

import hnc.business.service.IService;
import java.io.*;
import java.util.*;

/**Factory.java
 *This class is a factory that allows linking of Service implementation to the 
 * service interfaces, thus hiding the implementations and allowing them to be 
 * easily modified if needed.
 * @author Karl
 * @version 1.0
 * - added the IService getService( ) method. This allows the factory to look up
 *  the correct Service implementation and then start an instance of that service
 */
public class Factory {
    
     
    public IService getService(String serviceName) throws Exception {
        Class c = Class.forName(getImplName (serviceName));
        return (IService) c.newInstance();
    }
    
    //this method loads the config text file and returns the implementation FQN
    //  of the matching servicename
    public String getImplName(String serviceName) throws Exception {
        FileInputStream fis = new FileInputStream("config/properties.txt");
        Properties props = new Properties();
        props.load(fis);
        fis.close();        
        return props.getProperty(serviceName);
    }
    
    
}

