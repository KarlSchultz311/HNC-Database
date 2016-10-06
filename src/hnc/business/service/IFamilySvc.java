
package hnc.business.service;

import hnc.domain.*;
import java.util.ArrayList;
/**
 *
 * @author Karl
 */
public interface IFamilySvc extends IService{
    //abstract methods
    public Member findPrimaryMember(String memId) throws Exception;
    public String createFamily(Family family) throws Exception;
    public Family getFamily (String famId) throws Exception;
    public void updateFamily(Family family) throws Exception;
    public void deleteFamily(String famId) throws Exception;
    public ArrayList<Family> searchFamily (Family family) throws Exception;
}
