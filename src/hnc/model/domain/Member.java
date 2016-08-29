/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.model.domain;

import java.io.*;

/** Member.java
 * This class is designed to represent a single organization member. Within this 
 * class, you can find a constructor for a new empty Member object, a new Member
 * object with a provided memID number, as well as getters/setters for member 
 * data stored as strings for:
 * First Name, Last Name, Street Address, City, Zip Code, State, County, Region,
 * Home Phone Number, Cell Phone Number, Bleeding Disorder, Date of Birth, 
 * Join Date, Date of Last Renewal, and a MemberID.
 * @author Karl Schultz
 * version 1.0 8/24/16
 */
public class Member {
    
    //members
    private int memId;
    private String lName;
    private String fName;
    private String streetAdd;
    private String city;
    private String zip;
    private String state;
    private String county;
    private String region;
    private String homePhone;
    private String cellPhone;
    private String bleedDisorder;
    private String dob;
    private String joinDate;
    private String updatedDate;;
    private String comments;
    private Boolean badAdd;
    private Boolean industry;
    private String organization;
    private Boolean hope;
    private Boolean teens;
    private Boolean latinUnion;
    private Boolean soar;
    private Boolean bloodBrotherhood;
    private Boolean inhibitors;
    private Boolean advocacy;
    
    //constructor
    public Member(){
        memId = 0;
        lName = null;
        fName = null;
        streetAdd = null;
        city = null;
        zip = null;
        state = null;
        county = null;
        region = null;
        homePhone = null;
        cellPhone = null;
        bleedDisorder = null;
        dob = null;
        joinDate = null;
        updatedDate = null;
        comments = null;
        badAdd = false;
        industry = false;
        organization = null;
        hope = false;
        teens = false;
        latinUnion = false;
        soar = false;
        bloodBrotherhood = false;
        inhibitors = false;
        advocacy = false;
    }
    
     public Member(int memId){
        this.memId = memId;
        lName = null;
        fName = null;
        streetAdd = null;
        city = null;
        zip = null;
        state = null;
        county = null;
        region = null;
        homePhone = null;
        cellPhone = null;
        bleedDisorder = null;
        dob = null;
        joinDate = null;
        updatedDate = null;
        comments = null;
        badAdd = false;
        industry = false;
        organization = null;
        hope = false;
        teens = false;
        latinUnion = false;
        soar = false;
        bloodBrotherhood = false;
        inhibitors = false;
        advocacy = false;
    }
    
    //methods
    public String getLName(){
        return lName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public String getFName(){
        return fName;
    }
    
    public void setFName(String fName){
        this.fName = fName;
    }
           
    public String getStreetAdd(){
        return streetAdd;
    }
    
    public void setlName(String streetAdd){
        this.streetAdd = streetAdd;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getZip(){
        return zip;
    }
    
    public void setZip(String zip){
        this.zip = zip;
    }
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public String getCounty(){
        return county;
    }
    
    public void setCounty(String county){
        this.county = county;
    }
    
    public String getRegion(){
        return region;
    }
    
    public void setRegion(String region){
        this.region = region;
    }
    
    public String getHomePhone(){
        return homePhone;
    }
    
    public void setHomePhone(String homePhone){
        this.homePhone = homePhone;
    }
    
    public String getCellPhone(){
        return cellPhone;
    }
    
    public void setCellPhone(String cellPhone){
        this.cellPhone = cellPhone;
    }
    
    public String getBleedDisorder(){
        return bleedDisorder;
    }
    
    public void setBleedDisorder(String bleedDisorder){
        this.bleedDisorder = bleedDisorder;
    }
    
    public String getDob(){
        return dob;
    }
    
    public void setDob(String dob){
        this.dob = dob;
    }
    
    public String getJoinDate(){
        return joinDate;
    }
    
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    
    public String getUpdatedDate(){
        return updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate){
        this.updatedDate = updatedDate;
    }
    
    public int getMemId(){
        return memId;
    }
    
    public void setMemId(int memId){
        this.memId = memId;
    }
     
    public String getComments(){
        return comments;
    }
    
    public void setComments(String comments){
        this.comments = comments;
    }
    
    public boolean getBadAdd(){
        return badAdd;
    }
    
    public void setBadAdd(boolean badAdd){
        this.badAdd = badAdd;
    }
    
    public boolean getIndustry(){
        return industry;
    }
    
    public void setIndustry(boolean industry){
        this.industry = industry;
    }
    
    public String getOrganization(){
        return organization;
    }
    
    public void setOrganization(String organization){
        this.organization = organization;
    }
    
    public boolean getSoar(){
        return soar;
    }
    
    public void setSoar(boolean soar){
        this.soar = soar;
    }
    
    public boolean getTeens(){
        return teens;
    }
    
    public void setTeens(boolean teens){
        this.teens = teens;
    }
    
    public boolean getLatinUnion(){
        return latinUnion;
    }
    
    public void setLatinUnion(boolean latinUnion){
        this.latinUnion = latinUnion;
    }
    
    public boolean getBloodBrotherhood(){
        return bloodBrotherhood;
    }
    
    public void setBloodBlotherhood(boolean bloodBrotherhood){
        this.bloodBrotherhood = bloodBrotherhood;
    }
    
    public boolean getInhibitors(){
        return inhibitors;
    }
    
    public void setInhibitors(boolean inhibitors){
        this.inhibitors = inhibitors;
    }
    
    public boolean getAdvocacy(){
        return advocacy;
    }
    
    public void setAdvocacy(boolean advocacy){
        this.advocacy = advocacy;
    }
    
   
    @Override
    public String toString(){
        return "Member ID " + memId + " " + fName + " " + lName;
    }
    
}
    

