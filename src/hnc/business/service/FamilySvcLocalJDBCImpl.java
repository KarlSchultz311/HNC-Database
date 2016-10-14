
package hnc.business.service;

import java.sql.*;
import hnc.domain.*;
import java.util.ArrayList;
import hnc.business.factory.Factory;
/**FamilySvcLocalJDBCImpl.java
 * This class provides the implementation for methods listed in the IFamilySvc
 * interface.
 * @author Karl Schultz
 * Version 1.0 9/15/2016
 * Version 2.0 10/6/2016
 * Changes: modified the getConnection method to call to Factory to retrieve the
 * connection string saved to the properties.txt file.
 */
public class FamilySvcLocalJDBCImpl implements IFamilySvc {
    
    
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
    public String createFamily(Family family) throws Exception{
        /*This method first gets a connection to the database. It then creates a
        string to use as a SQL statement to insert the data members of a Family 
        object that was passed into the method. It then executes the insert into
        the database. Then the method will query the database for the last inserted
        Family ID value that was auto increment assigned by the database. The familyID
        is then extracted from the resultset, and returned.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.createStatement();
        
            String sql = "INSERT INTO families (lName, email1, email2, streetAdd1, " +
                    "streetAdd2, city, zip, state, county, region, homePhone, cellPhone," +
                    "bleedDisorder, comments," +
                    "hope, teens, latinUnion, soar, bloodBrotherhood," +
                    "inhibitors, advocacy) VALUES ('" + family.getLName()+"', '"+
                    family.getEmail1()+"', '"+family.getEmail2()
                    +"', '"+family.getStreetAdd1()+"', '"+family.getStreetAdd2()
                    +"', '"+family.getCity()+"', '"+family.getZip()+"', '"+
                    family.getState()+"', '"+family.getCounty()+"', '"+family.getRegion()
                    +"', '"+family.getHomePhone()+"', '"+family.getCellPhone()
                    +"', '"+family.getBleedDisorder()+"', '"+family.getComments()+"', '"+                   
                    family.getHope()+"', '"+family.getTeens()+"', '"+family.getLatinUnion()
                    +"', '"+family.getSoar()+"', '"+family.getBloodBrotherhood()+"', '"+
                    family.getInhibitors()+"', '"+family.getAdvocacy()+"')";
                  
            
            stmt.executeUpdate(sql);
            
          
            //get this last famID number auto-incremented to return to the UI to display
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            //advance result set cursor to first result
            rs.next();
            int famId = rs.getInt(1);
            //change data type to String for UI display in text field
            String ID = Integer.toString(famId);           
                  
            return ID;
           
        } catch (Exception e) {
            System.out.println(e);
            return "Error @ JDBCImp";
               
        } finally {
            if (conn != null) 
                conn.close();
        }
    }
    
    
    
    @Override
    public Family findFamily (String famId) throws Exception{
        /*This method establishes a connection to the database, then creates a
        SQL statement to select a Family row that matches the provided familyID 
        string. The SQL query is executed and the resultset is unpacked into a 
        Family object. This Family object is returned.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;            
            stmt = conn.createStatement();
            String sql = "SELECT * FROM families WHERE familyID = '"+famId+"'";
            Family family = new Family();
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                family.setFamilyId(rs.getString(1));                
                family.setLName(rs.getString(2));
                family.setStreetAdd1(rs.getString(3));
                family.setStreetAdd2(rs.getString(4));
                family.setCity(rs.getString(5));
                family.setState(rs.getString(6));
                family.setZip(rs.getString(7));
                family.setCounty(rs.getString(8));
                family.setRegion(rs.getString(9));
                family.setHomePhone(rs.getString(10));
                family.setCellPhone(rs.getString(11));
                family.setEmail1(rs.getString(12));
                family.setEmail2(rs.getString(13));
                family.setBleedDisorder(rs.getString(14));
                family.setComments(rs.getString(15));
                family.setHope(rs.getInt(16));
                family.setTeens(rs.getInt(17));
                family.setSoar(rs.getInt(18));
                family.setBloodBrotherhood(rs.getInt(19));
                family.setLatinUnion(rs.getInt(20));
                family.setInhibitors(rs.getInt(21));
                family.setAdvocacy(rs.getInt(22));                              
            }
            return family;
            
        } catch (Exception e){
            System.out.println(e);
            Family errFam = new Family("Family not found");
            return errFam;
        } finally {
            if (conn != null)
                conn.close();
        }
    }
    
    @Override
    public void updateFamily(Family family) throws Exception{
        /*This method will first establish a connection to the databbase. It will
        then create a string to be used as an update SQL statement using the data
        members from the provided Family object. The update is then executed using 
        the string.
        */
        Connection conn = getConnection();
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE families SET lName= '"+ family.getLName()+"', email1= '"+
                    family.getEmail1()+"', email2= '"+family.getEmail2()
                    +"', streetAdd1= '"+family.getStreetAdd1()+"', streetAdd2= '"+family.getStreetAdd2()
                    +"', city= '"+family.getCity()+"', zip= '"+family.getZip()+"', state= '"+
                    family.getState()+"', county= '"+family.getCounty()+"', region= '"+family.getRegion()
                    +"', homePhone= '"+family.getHomePhone()+"', cellPhone= '"+family.getCellPhone()
                    +"', bleedDisorder= '"+family.getBleedDisorder()+"', comments= '"+family.getComments()+"', hope= '"+
                    family.getHope()+"', teens= '"+family.getTeens()+"', latinUnion= '"+family.getLatinUnion()
                    +"', soar= '"+family.getSoar()+"', bloodBrotherhood= '"+family.getBloodBrotherhood()+"', inhibitors='"+
                    family.getInhibitors()+"', advocacy= '"+family.getAdvocacy()+
                    "' WHERE familyID='"+ family.getFamilyId()+"'";
            stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e+" @ updateFamily");
        } finally {
            if (conn != null)
                conn.close();
        }
    }
    
    @Override
    public void deleteFamily(String familyId) throws Exception{
        /*This method first creates a connection with the database. Then it creates
        a string to be used as a SQL update message. It first creates a message to update
        any member objects with a matching familyID to 0. The database needs to have 
        a Family row with a 0 familyId to serve as a catch-all for members without an 
        attatched family. These need to be updated first as the familyID is a foreign key
        of the member rows. Next the database deletes the family row that matches the
        familyID.
        */
        Connection conn = getConnection();
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE members SET familyID = '0' WHERE familyID ='"+familyId+"'";
            stmt.executeUpdate(sql);
            String sql2 = "DELETE FROM families WHERE familyID = '"+familyId+"'";
            stmt.executeUpdate(sql2);
        } catch (Exception e){
            System.out.println(e+" @ deleteFamily");
        } finally {
            if (conn != null)
                conn.close();
        }
    }
    
    @Override
    public ArrayList<Family> searchFamily(Family parameters) throws Exception {
        /*This method starts by getting a connecction to the database. It then
        creates a string to be used as a generic SQL query statement. As the method
        compares the Family parameter object to the if statements, portions of the 
        string are appended to the SQL string. The use of LIKE allows for partial 
        parameter entry and look up by the database. This method checks a boolean
        value to see if this is the first selection parameter. If false it appends
        the AND version of the addition. Near the end it appends a WHERE familyID is 
        not 0 to omit the empty family from being collected. The method then executes
        the SQL query and unpacks the result set into an ArrayList of Family objects
        that it returns.
        */
        Connection conn = getConnection();  //establishes connection to DB
        try {
            Statement stmt = null;
            ResultSet rs = null;            
            stmt = conn.createStatement();
            Boolean first = true;
            
            
            String sql = "SELECT * FROM families WHERE ";
            
            if (! parameters.getFamilyId().isEmpty()){
                //check to see if this is the first paramater
                if(first==true){
                    sql += "familyID = '"+parameters.getFamilyId()+"'";
                    first=false;
                }else{
                    sql += " AND familyID = '"+parameters.getFamilyId()+"'";                   
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
                    sql += "region LIKE '"+parameters.getRegion()+"%'";
                    first=false;
                }else{
                    sql += " AND region LIKE '"+parameters.getRegion()+"%'";                   
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
              
            
            if(first==true){
                sql="SELECT * FROM families WHERE familyId != 0";                
            }else{
                sql=sql+" AND familyID != 0";
            }
                     
            rs = stmt.executeQuery(sql);
            
            ArrayList<Family> familyList = new ArrayList<Family>();
            
            
            //unpack the result set into ArrayList
            while(rs.next()){
                Family row = new Family();
                row.setFamilyId(rs.getString("familyID"));
                row.setLName(rs.getString("lName"));
                row.setStreetAdd1(rs.getString("streetAdd1"));
                row.setStreetAdd2(rs.getString("streetAdd2"));
                row.setCity(rs.getString("city"));                
                row.setState(rs.getString("state"));
                row.setZip(rs.getString("zip"));
                row.setCounty(rs.getString("county"));
                row.setRegion(rs.getString("region"));
                row.setHomePhone(rs.getString("homePhone"));
                row.setCellPhone(rs.getString("cellPhone"));
                row.setEmail1(rs.getString("email1"));
                row.setEmail2(rs.getString("email2"));
                row.setBleedDisorder(rs.getString("bleedDisorder"));
                row.setComments(rs.getString("comments"));
                row.setHope(rs.getInt("hope"));
                row.setTeens(rs.getInt("teens"));
                row.setSoar(rs.getInt("soar"));
                row.setBloodBrotherhood(rs.getInt("bloodBrotherhood"));
                row.setLatinUnion(rs.getInt("latinUnion"));
                row.setInhibitors(rs.getInt("inhibitors"));
                row.setAdvocacy(rs.getInt("advocacy"));
                
                familyList.add(row); 
            }
            
            return familyList;
            
        }catch (Exception e) {
            System.out.println(e);
            ArrayList<Family> list = new ArrayList<Family>();
            Family  errFam = new Family(); //create empty Family object
            errFam.setLName("Error @ JDBC Implement");
            list.add(errFam);//add empty Family to ArrayList
            return list;            
        }finally {
            if (conn != null) 
                conn.close();
        }
    
    }
}
