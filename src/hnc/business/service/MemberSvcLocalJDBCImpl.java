
package hnc.business.service;

import hnc.business.factory.Factory;
import hnc.domain.Member;
import java.sql.*;
import java.util.ArrayList;

/**MemberSvcLocalJDBCImpl.java
 * This class provides the implementation for methods listed in the IMemberSvc
 * interface.
 * @author Karl Schultz
 * Version 1.0 9/15/2016
 * Version 2.0 10/6/2016
 * Changes: modified the getConnection method to call to Factory to retrieve the
 * connection string saved to the properties.txt file.
 * Version 2.1 10/16/2016
 * Changed UpdateMember method to read in familyId as a string not an integer. Also
 * added getBadAdd and updated SQL sequence to match addition.
 */
public class MemberSvcLocalJDBCImpl implements IMemberSvc {
    
    
    private Connection getConnection() throws Exception {
        /*This method calls to the Factory to return the connection String values
        for the connection to the local database from the properties.txt file, then
        returns the connection object.
        */
        String dbPass = "connString";
        Factory factory = new Factory();        
        return DriverManager.getConnection(factory.getConnString(dbPass));
    }
    
    @Override
    public ArrayList<Member> displayMemberSearch(Member parameters) throws Exception {
        /*This method first establishes a connection to the database. It then
        creates a string to be used as a SQL query statement. The method uses
        the input Member object data members as parameters for the search. This
        method then checks each applicable data member for existance and if found,
        appends the SQL string with WHERE parameters. If the boolean check fails,
        the AND portion is inserted for SQL syntax reasons. If after all parameter
        checks complete and first is still true, the SQL string is overwritten with
        a general "Select all" statement. The string is then executed and the
        result set is unpacked into an ArrayList of Member objects. Ths ArrayList 
        is then returned.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;            
            stmt = conn.createStatement();
            Boolean first = true;
            
            
            String sql = "SELECT * FROM members WHERE ";
            
            if (! parameters.getMemId().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "memId = '"+parameters.getMemId()+"'";
                    first=false;
                }else{
                    sql += " AND memId = '"+parameters.getMemId()+"'";                   
                }
                
            }if (! parameters.getLName().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "lName LIKE '"+parameters.getLName()+"%'";
                    first=false;
                }else{
                    sql += " AND lName LIKE '"+parameters.getLName()+"%'";                   
                }                
            }
            
            if (! parameters.getFName().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "fName LIKE '"+parameters.getFName()+"%'";
                    first=false;
                }else{
                    sql += " AND fName LIKE '"+parameters.getFName()+"%'";                   
                }                
            }
            
            if (! parameters.getCity().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "city LIKE '"+parameters.getCity()+"%'";
                    first=false;
                }else{
                    sql += " AND city LIKE '"+parameters.getCity()+"%'";                   
                }                
            }
            
            if ( ! parameters.getCounty().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "county LIKE '"+parameters.getCounty()+"%'";
                    first=false;
                }else{
                    sql += " AND county LIKE '"+parameters.getCounty()+"%'";                   
                }                
            }
            
            if (! parameters.getRegion().matches("All")){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "region = '"+parameters.getRegion()+"'";
                    first=false;
                }else{
                    sql += " AND region = '"+parameters.getRegion()+"'";                   
                }                
            }
            
            if (! parameters.getBleedDisorder().matches("All")){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "bleedDisorder = '"+parameters.getBleedDisorder()+"'";
                    first=false;
                }else{
                    sql += " AND bleedDisorder = '"+parameters.getBleedDisorder()+"'";                   
                }                
            }
            
            if (parameters.getHope() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "hope = 1";
                    first=false;
                }else{
                    sql += " AND hope = 1";                   
                }                
            }
            
            if (parameters.getTeens() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "teens = 1";
                    first=false;
                }else{
                    sql += " AND teens = 1";                   
                }                
            }
            
            if (parameters.getLatinUnion() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "latinUnion = 1";
                    first=false;
                }else{
                    sql += " AND latinUnion = 1";                   
                }                
            }
            
            if (parameters.getSoar() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "soar = 1";
                    first=false;
                }else{
                    sql += " AND soar = 1";                   
                }                
            }
            
            if (parameters.getBloodBrotherhood() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "bloodBrotherhood = 1";
                    first=false;
                }else{
                    sql += " AND bloodBrotherhood = 1";                   
                }                
            }
            
            if (parameters.getInhibitors() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "inhibitors = 1";
                    first=false;
                }else{
                    sql += " AND inhibitors = 1";                   
                }                
            }
            
            if (parameters.getAdvocacy() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "advocacy = 1";
                    first=false;
                }else{
                    sql += " AND advocacy = 1";                   
                }                
            }
            
            //if the parameter for industry is checked, the user wants to exclude industry
            // so we search for industry = 0 not 1
            if (parameters.getIndustry() == 1){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "industry = 0";
                    first=false;
                }else{
                    sql += " AND industry = 0";                   
                }                
            }
            if(first==true){
                sql="SELECT * FROM members";
            }
                    
            rs = stmt.executeQuery(sql);
            
            ArrayList<Member> memberList = new ArrayList<Member>();
            
            
            while(rs.next()){
                Member row = new Member();
                row.setMemId(rs.getString("memId"));
                row.setLName(rs.getString("lName"));
                row.setFName(rs.getString("fName"));
                row.setEmail1(rs.getString("email1"));
                row.setEmail2(rs.getString("email2"));
                row.setStreetAdd1(rs.getString("streetAdd1"));
                row.setStreetAdd2(rs.getString("streetAdd2"));
                row.setCity(rs.getString("city"));
                row.setZip(rs.getString("zip"));
                row.setState(rs.getString("state"));
                row.setCounty(rs.getString("county"));
                row.setRegion(rs.getString("region"));
                row.setHomePhone(rs.getString("homePhone"));
                row.setCellPhone(rs.getString("cellPhone"));
                row.setBleedDisorder(rs.getString("bleedDisorder"));
                row.setDob(rs.getString("dob"));
                row.setJoinDate(rs.getString("joinDate"));
                row.setUpdatedDate(rs.getString("updatedDate"));
                row.setComments(rs.getString("comments"));
                row.setBadAdd(rs.getString("badAdd"));
                row.setOrganization(rs.getString("organization"));
                row.setIndustry(rs.getInt("industry"));
                row.setHope(rs.getInt("hope"));
                row.setTeens(rs.getInt("teens"));
                row.setLatinUnion(rs.getInt("latinUnion"));
                row.setSoar(rs.getInt("soar"));
                row.setBloodBrotherhood(rs.getInt("bloodBrotherhood"));
                row.setInhibitors(rs.getInt("inhibitors"));
                row.setAdvocacy(rs.getInt("advocacy"));
                
                memberList.add(row);
                
            }
            
            return memberList;
            
        }catch (Exception e) {
            System.out.println(e);
            ArrayList<Member> list = new ArrayList<Member>();
            Member errorMember = new Member();
            errorMember.setLName("Error");
            list.add(errorMember);
            return list;            
        }finally {
            if (conn != null) 
                conn.close();
        }
    }
    
    
    
    @Override
    public String createMember(Member member) throws Exception{
        /*This method first gets a connection to the database. It then creates a
        string to use as a SQL statement to insert the data members of a Member 
        object that was passed into the method. It then executes the insert into
        the database. Then the method will query the database for the last inserted
        MemberID value that was auto increment assigned by the database. The memberID
        is then extracted from the resultset, and returned.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.createStatement();
        
            String sql = "INSERT INTO members (lName, fName, email1, email2, streetAdd1," +
                    "streetAdd2, city, zip, state, county, region, homePhone, cellPhone," +
                    "bleedDisorder, dob, joinDate, comments," +
                    "organization, industry, hope, teens, latinUnion, soar, bloodBrotherhood," +
                    "inhibitors, advocacy) VALUES ('" + member.getLName()+"', '"+
                    member.getFName()+"', '"+member.getEmail1()+"', '"+member.getEmail2()
                    +"', '"+member.getStreetAdd1()+"', '"+member.getStreetAdd2()
                    +"', '"+member.getCity()+"', '"+member.getZip()+"', '"+
                    member.getState()+"', '"+member.getCounty()+"', '"+member.getRegion()
                    +"', '"+member.getHomePhone()+"', '"+member.getCellPhone()
                    +"', '"+member.getBleedDisorder()+"', '"+member.getDob()+"', '"+
                    member.getJoinDate()+"', '"+member.getComments()+"', '"+
                    member.getOrganization()+"', '"+member.getIndustry()+"', '"+
                    member.getHope()+"', '"+member.getTeens()+"', '"+member.getLatinUnion()
                    +"', '"+member.getSoar()+"', '"+member.getBloodBrotherhood()+"', '"+
                    member.getInhibitors()+"', '"+member.getAdvocacy()+"')";
                  
            
            stmt.executeUpdate(sql);
            
          
            //get this last memID number auto-incremented to return to the UI to display
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            //advance result set cursor to first result
            rs.next();
            int memId = rs.getInt(1);
            //change data type to String for UI display in text field
            String ID = Integer.toString(memId);           
            
            return ID;
           
        } catch (Exception e) {
            System.out.println(e);
            return "JDBC Exception: Unable to find MemID";
               
        } finally {
            if (conn != null) 
                conn.close();
        }
        
    }
    
    @Override
    public Member findMember (String memId) throws Exception{
        /*This method establishes a connection to the database, then creates a
        SQL statement to select a Member row that matches the provided memberID 
        string. The SQL query is executed and the resultset is unpacked into a 
        Member object. This Member object is returned.
        */
        Connection conn2 = getConnection();  //establishes connection to DB
        Member member = new Member();
        try{
            Statement stmt = null;
            
            
            stmt = conn2.createStatement();
            
            String sql2 = "SELECT * FROM members WHERE memId = '"+memId+"'";
            ResultSet rs = stmt.executeQuery(sql2);
            
            while(rs.next()){                
                member.setMemId(rs.getString(1));
                member.setFamilyId(rs.getString(2));
                member.setLName(rs.getString(3));
                member.setFName(rs.getString(4));
                member.setEmail1(rs.getString(5));
                member.setEmail2(rs.getString(6));
                member.setStreetAdd1(rs.getString(7));
                member.setStreetAdd2(rs.getString(8));
                member.setCity(rs.getString(9));
                member.setZip(rs.getString(10));
                member.setState(rs.getString(11));
                member.setCounty(rs.getString(12));
                member.setRegion(rs.getString(13));
                member.setHomePhone(rs.getString(14));
                member.setCellPhone(rs.getString(15));
                member.setBleedDisorder(rs.getString(16));
                member.setDob(rs.getString(17));
                member.setJoinDate(rs.getString(18));
                member.setUpdatedDate(rs.getString(19));
                member.setComments(rs.getString(20));
                member.setBadAdd(rs.getString(21));
                member.setOrganization(rs.getString(22));
                member.setIndustry(rs.getInt(23));
                member.setHope(rs.getInt(24));
                member.setTeens(rs.getInt(25));
                member.setLatinUnion(rs.getInt(26));
                member.setSoar(rs.getInt(27));
                member.setBloodBrotherhood(rs.getInt(28));
                member.setInhibitors(rs.getInt(29));
                member.setAdvocacy(rs.getInt(30));                
            }
            return member;
        } catch (Exception e){
            System.out.println(e);
            return member;
            
        } finally {
            if (conn2 != null) 
                conn2.close();
        }
        
    }
    
    @Override
    public Boolean deleteMember(String memId) throws Exception {
        /*This method first creates a connection with the database. Then it creates
        a string to be used as a SQL update message with the provided memID as the
        deletion row target. The sql message is then executed and returns a boolean
        true if successful.
        */
        Connection conn3 = getConnection();
        Statement stmt = null;
        Boolean success = false;
        try{
            stmt = conn3.createStatement();
            String sql3 = "DELETE FROM members WHERE memId = '"+ memId+"'";
            stmt.executeUpdate(sql3);
            success = true;
            return success;
        } catch (Exception e){
            System.out.println(e);
            return success;
        } finally {
            if (conn3 != null)
                conn3.close();
        }
                
    }
    
                        
    @Override
    public void updateMember(Member member) throws Exception {
        /*This method will first establish a connection to the databbase. It will
        then create a string to be used as an update SQL statement using the data
        members from the provided Member object. The update is then executed using 
        the string.
        */
        Connection conn4 = getConnection();
        Statement stmt = null;
        
                
        try{
            
            stmt = conn4.createStatement();
            String sql4 = "UPDATE members SET familyID= '"+ member.getFamilyId()+
                    "', lName= '"+ member.getLName()+"', fName= '"+
                    member.getFName()+"', email1= '"+member.getEmail1()+"', email2= '"+member.getEmail2()
                    +"', streetAdd1= '"+member.getStreetAdd1()+"', streetAdd2= '"+member.getStreetAdd2()
                    +"', city= '"+member.getCity()+"', zip= '"+member.getZip()+"', state= '"+
                    member.getState()+"', county= '"+member.getCounty()+"', region= '"+member.getRegion()
                    +"', homePhone= '"+member.getHomePhone()+"', cellPhone= '"+member.getCellPhone()
                    +"', bleedDisorder= '"+member.getBleedDisorder()+"', dob= '"+member.getDob()+"', joinDate= '"+
                    member.getJoinDate()+"', comments= '"+member.getComments()+
                    "', badAdd= '"+member.getBadAdd()+ "', organization= '"+
                    member.getOrganization()+"', industry= '"+member.getIndustry()+"', hope= '"+
                    member.getHope()+"', teens= '"+member.getTeens()+"', latinUnion= '"+member.getLatinUnion()
                    +"', soar= '"+member.getSoar()+"', bloodBrotherhood= '"+member.getBloodBrotherhood()+"', inhibitors='"+
                    member.getInhibitors()+"', advocacy= '"+member.getAdvocacy()+"', updatedDate= '"
                    +member.getUpdatedDate()+"'WHERE memId='"+ Integer.parseInt(member.getMemId())+"'";
            
            stmt.executeUpdate(sql4);
            
        } catch (Exception e){
            System.out.println(e+ " @ updateMember");
        } finally {
            if (conn4 != null)
                conn4.close();
        }
    }
    
    @Override
    public ArrayList<Member> getFamilyMembers(String famId) throws Exception{
        /*This method first establishes a connection to the database. It then 
        creates a string to be used as a SQL statement using the provided familyID
        string as a query target. The result set is then unpacked into an ArrayList
        of Member objects containing only first and last names, which is returned.
        */
         Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;            
            stmt = conn.createStatement();
           
            String sql = "SELECT fName, lName FROM members WHERE familyID = '"+
                    famId+"'";
            rs = stmt.executeQuery(sql);
            
            ArrayList<Member> memberList = new ArrayList<Member>();
            
            
            while(rs.next()){
                Member row = new Member();                
                row.setLName(rs.getString("lName"));                
                row.setFName(rs.getString("fName"));
                
                memberList.add(row);
            }
            
            return memberList;
            
        }catch (Exception e) {
            System.out.println(e);
            ArrayList<Member> list = new ArrayList<Member>();
            Member errorMember = new Member();
            errorMember.setFName("Error at JDBC");
            list.add(errorMember);
            return list;            
        }finally {
            if (conn != null) 
                conn.close();
        }
    }
    
    @Override
    public void updateFamilyId (String famId, String memId) throws Exception{
        /*This method first establishes a connection to the database. It then 
        creates a string to be used as a SQL statement that will update the given
        member row matching the given memberID. The familyID column will be updated 
        to match the given familyID string. The sql update is then executed.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;            
            
            stmt = conn.createStatement();
        
            String sql = "UPDATE members SET familyID = '"+famId+"' WHERE memID = '"+
                    memId+"'";
                  
            stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            if (conn != null)
                conn.close();
        }
            
        
    }
    
    @Override
    public Member findPrimaryMember(String memId) throws Exception{
        /*This method begins by establishing a connection to the database. It then
        creates a string to be used as a SQL query message that selects the member
        row that matches the provided memberID. The method then executes the query,
        and unpacks the resultset into a new Member object. It then checks to see if
        the Member has a familyID that is not 0 (signifying that the member has already
        been assigned to a family). If the familyID is not 0 it returns an error that
        the Member already has a family, otherwise it returns the Member object.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try{
            Statement stmt = null;
            ResultSet rs = null;            
            stmt = conn.createStatement();
            Member member = new Member();
            String sql2 = "SELECT * FROM members WHERE memId = '"+memId+"'";
            rs = stmt.executeQuery(sql2);
            
            while(rs.next()){
                member.setMemId(rs.getString(1));
                member.setFamilyId(rs.getString(2));
                member.setLName(rs.getString(3));
                member.setFName(rs.getString(4));
                member.setEmail1(rs.getString(5));
                member.setEmail2(rs.getString(6));
                member.setStreetAdd1(rs.getString(7));
                member.setStreetAdd2(rs.getString(8));
                member.setCity(rs.getString(9));
                member.setZip(rs.getString(10));
                member.setState(rs.getString(11));
                member.setCounty(rs.getString(12));
                member.setRegion(rs.getString(13));
                member.setHomePhone(rs.getString(14));
                member.setCellPhone(rs.getString(15));
                member.setBleedDisorder(rs.getString(16));
                member.setDob(rs.getString(17));
                member.setJoinDate(rs.getString(18));
                member.setUpdatedDate(rs.getString(19));
                member.setComments(rs.getString(20));
                member.setBadAdd(rs.getString(21));
                member.setOrganization(rs.getString(22));
                member.setIndustry(rs.getInt(23));
                member.setHope(rs.getInt(24));
                member.setTeens(rs.getInt(25));
                member.setLatinUnion(rs.getInt(26));
                member.setSoar(rs.getInt(27));
                member.setBloodBrotherhood(rs.getInt(28));
                member.setInhibitors(rs.getInt(29));
                member.setAdvocacy(rs.getInt(30));                
            }
            if (member.getInteger(member.getFamilyId()) == 0){
                return member;
            }else{
                Member hasFam = new Member();
                hasFam.setLName(member.getFName()+", "+member.getLName()+" already has a Family");
                return hasFam;
            }
            
        }catch (Exception e){
            System.out.println(e);
            Member errMember = new Member();
            return errMember;
        }finally {
            if (conn != null) 
                conn.close();
        }
    }
}
