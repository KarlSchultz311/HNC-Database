
package hnc.business.service;

import hnc.domain.*;
import java.util.ArrayList;
/**IFamilySvc.java
 * This is an interface that extends IService. It allows for abstraction by the 
 * Factory to point the FamilyManager to the chosen implementations of requested
 * methods.
 *
 * @author Karl Schultz
 * Version 1.0 9/9/2016
 * Version 2.0 10/6/2016
 * Changes: moved findPrimaryMember to the IMemberSvc class.
 */
public interface IFamilySvc extends IService{
    //abstract methods    
    public String createFamily(Family family) throws Exception;
    public Family getFamily (String famId) throws Exception;
    public void updateFamily(Family family) throws Exception;
    public void deleteFamily(String famId) throws Exception;
    public ArrayList<Family> searchFamily (Family family) throws Exception;
}
