/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.domain;

/**Family.java
 * This Class is designed to represent a Family within HNC. Each Family will be 
 * assigned a FamilyID number as they are created. Each family will contain string
 * members for:
 * Last name, Street Address 1, Street Address 2, City, State, Zip, County, 
 * Email 1, Email 2, Home Phone, Cell Phone, Bleeding Disorder, Date Updated, and
 * comments.
 * Each Family will contain int members for:
 * Region, Family ID
 * Each Family will contain Boolean values for descriptive groups/interests:
 * Soar, Blood Brotherhood, Teens, Latin Union, Inhibitors, Advocacy, and Hope
 * Each Family will contain the MemberIDs of the members of the family
 *
 * @author Karl Schultz
 * Version 1.0 8/29/16
 */
public class Family {
    
    //members
    private String familyId;
    private String region;
    private String lName;
    private String email1;
    private String email2;
    private String streetAdd1;
    private String streetAdd2;
    private String city;
    private String zip;
    private String state;
    private String county;
    private String homePhone;
    private String cellPhone;
    private String bleedDisorder;
    private String updatedDate;;
    private String comments;
    private int hope;
    private int teens;
    private int latinUnion;
    private int soar;
    private int bloodBrotherhood;
    private int inhibitors;
    private int advocacy;
    
    //constructor
    public Family(){
        familyId = null;
        region = null;
        lName = null;
        email1 = null;
        email2 = null;
        streetAdd1 = null;
        streetAdd2 = null;
        city = null;
        zip = null;
        state = null;
        county = null;
        homePhone = null;
        cellPhone = null;
        bleedDisorder = null;
        updatedDate = null;
        comments = null;
        hope = 0;
        teens = 0;
        latinUnion = 0;
        soar = 0;
        bloodBrotherhood = 0;
        inhibitors = 0;
        advocacy = 0;
    }
    
    public Family(String name){
        familyId = null;
        region = null;
        lName = name;
        email1 = null;
        email2 = null;
        streetAdd1 = null;
        streetAdd2 = null;
        city = null;
        zip = null;
        state = null;
        county = null;
        homePhone = null;
        cellPhone = null;
        bleedDisorder = null;
        updatedDate = null;
        comments = null;
        hope = 0;
        teens = 0;
        latinUnion = 0;
        soar = 0;
        bloodBrotherhood = 0;
        inhibitors = 0;
        advocacy = 0;
    }
    
    
    //methods
    public int getAdvocacy(){
        return advocacy;
    }
    
    public void setAdvocacy(int advocacy){
        this.advocacy = advocacy;
    }
    
    public String getBleedDisorder(){
        return bleedDisorder;        
    }
    
    public void setBleedDisorder(String bleedDisorder){
        this.bleedDisorder = bleedDisorder;
    }
    
    public int getBloodBrotherhood(){
        return bloodBrotherhood;
    }
    
    public void setBloodBrotherhood(int bloodBrotherhood){
        this.bloodBrotherhood = bloodBrotherhood;
    }
    
    public String getCellPhone(){
        return cellPhone;
    }
    
    public void setCellPhone(String cellPhone){
        this.cellPhone = cellPhone;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getComments(){
        return comments;
    }
    
    public void setComments(String comments){
        this.comments = comments;
    }
    
    public String getCounty(){
        return county;
    }
    
    public void setCounty(String county){
        this.county = county;
    }
    
    public String getEmail1(){
        return email1;
    }
    
    public void setEmail1(String email1){
        this.email1 = email1;
    }
    
    public String getEmail2(){
        return email2;
    }
    
    public void setEmail2(String email2){
        this.email2 = email2;
    }
    
    public String getFamilyId(){
        return familyId;
    }
    
    public void setFamilyId(String familyId){
        this.familyId = familyId;        
    }
    
    public String getHomePhone(){
        return homePhone;
    }
    
    public void setHomePhone(String cellHome){
        this.homePhone = cellHome;
    }
    
    public int getHope(){
        return hope;
    }
    
    public void setHope(int hope){
        this.hope = hope;
    }
    
    public int getInhibitors(){
        return inhibitors;
    }
    
    public void setInhibitors(int inhibitors){
        this.inhibitors = inhibitors;
    }
    
    public String getLName(){
        return lName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public int getLatinUnion(){
        return latinUnion;
    }
    
    public void setLatinUnion(int latinUnion){
        this.latinUnion = latinUnion;
    }
    
    public String getRegion(){
        return region;
    }
    
    public void setRegion(String region){
        this.region = region;
    }
    
    public int getSoar(){
        return soar;
    }
    
    public void setSoar(int soar){
        this.soar = soar;
    }
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public String getStreetAdd1(){
        return streetAdd1;
    }
    
    public void setStreetAdd1(String streetAdd1){
        this.streetAdd1 = streetAdd1;
    }
    
    public String getStreetAdd2(){
        return streetAdd2;
    }
    
    public void setStreetAdd2(String streetAdd2){
        this.streetAdd2 = streetAdd2;
    }
    
    public int getTeens(){
        return teens;
    }
    
    public void setTeens(int teens){
        this.teens = teens;
    }
    
    public String getUpdatedDate(){
        return updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate){
        this.updatedDate = updatedDate;
    }
    
    public String getZip(){
        return zip;
    }
    
    public void setZip(String zip){
        this.zip = zip;
    }
            
            
    
    
    
    
    
    
    
    
}
