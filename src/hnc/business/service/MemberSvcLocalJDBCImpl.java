/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.business.service;

import hnc.domain.Member;
import java.sql.*;
/**
 *
 * @author Karl
 */
public class MemberSvcLocalJDBCImpl implements IMemberSvc {
    
    private String connString = 
            "jdbc:mysql://localhost:3306/hnc?user=root&password=73bLood?";
    
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(connString);
    }
    
    @Override
    public String createMember(Member member) throws Exception{
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
            
            //String sql2 = "SELECT memId FROM member WHERE lName ='"+ member.getLName()+ "'";
            
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            rs.next();
            int memId = rs.getInt(1);
            String ID = Integer.toString(memId);
            
            System.out.printf(ID);
            return ID;
           /*
            */
        } catch (Exception e) {
            System.out.println(e);
            return "JDBC Exception: Unable to find MemID";
            
           
            
            
            
        } finally {
            if (conn != null) 
                conn.close();
        }
        
    }
    
}
