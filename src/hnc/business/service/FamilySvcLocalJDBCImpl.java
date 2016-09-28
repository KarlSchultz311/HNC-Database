/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.service;

import java.sql.*;
import hnc.domain.*;
/**
 *
 * @author Karl
 */
public class FamilySvcLocalJDBCImpl implements IFamilySvc {
    
    private String connString = 
        "jdbc:mysql://localhost:3306/hnc?user=root&password=73bLood?";
    
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(connString);
    }
    
    @Override
    public Member findPrimaryMember(String memId) throws Exception{
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
            if (member.getFamilyId() == null){
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
    
    @Override
    public String createFamily(Family family) throws Exception{
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
            return "JDBC Exception: Unable to find FamID";
               
        } finally {
            if (conn != null) 
                conn.close();
        }
    }
    
    @Override
    public void updateFamilyId (String famId, String memId) throws Exception{
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
    public Family getFamily (String famId) throws Exception{
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
                    "' WHERE familyID='"+ Integer.parseInt(family.getFamilyId())+"'";
            stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e+" @ updateFamily");
        } finally {
            if (conn != null)
                conn.close();
        }
    }
    
}
