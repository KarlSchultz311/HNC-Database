


package hnc.business.service;

import hnc.domain.Member;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Karl
 */
public class MemberSvcLocalJDBCImpl implements IMemberSvc {
    
    final private String connString = 
            "jdbc:mysql://localhost:3306/hnc?user=root&password=73bLood?";
    
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(connString);
    }
    
    @Override
    public ArrayList<Member> displayMemberSearch(Member parameters) throws Exception {
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
    
    
    //"', familyID= '"+ (Integer.parseInt(member.getFamilyId())+0)+ "' 
                    
    @Override
    public void updateMember(Member member) throws Exception {
        Connection conn4 = getConnection();
        Statement stmt = null;
        
                
        try{
            
            stmt = conn4.createStatement();
            String sql4 = "UPDATE members SET familyID= '"+ member.getInteger(member.getFamilyId())+
                    "', lName= '"+ member.getLName()+"', fName= '"+
                    member.getFName()+"', email1= '"+member.getEmail1()+"', email2= '"+member.getEmail2()
                    +"', streetAdd1= '"+member.getStreetAdd1()+"', streetAdd2= '"+member.getStreetAdd2()
                    +"', city= '"+member.getCity()+"', zip= '"+member.getZip()+"', state= '"+
                    member.getState()+"', county= '"+member.getCounty()+"', region= '"+member.getRegion()
                    +"', homePhone= '"+member.getHomePhone()+"', cellPhone= '"+member.getCellPhone()
                    +"', bleedDisorder= '"+member.getBleedDisorder()+"', dob= '"+member.getDob()+"', joinDate= '"+
                    member.getJoinDate()+"', comments= '"+member.getComments()+"', organization= '"+
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
}
