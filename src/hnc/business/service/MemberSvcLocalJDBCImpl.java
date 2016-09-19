


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
    public String saveMember(Member member) throws Exception{
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
            
            System.out.printf(ID);
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
        Connection conn2 = getConnection();  //establishes connection to DB
        Member member = new Member();
        try{
            Statement stmt = null;
            
            
            stmt = conn2.createStatement();
            
            String sql2 = "select * from members WHERE memId = '"+memId+"'";
            ResultSet rs = stmt.executeQuery(sql2);
            
            while(rs.next()){                
                member.setMemId(rs.getInt(1));
                member.setFamilyId(rs.getInt(2));
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
}
