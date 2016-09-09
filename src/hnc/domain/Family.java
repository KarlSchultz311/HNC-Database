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
    private int familyId;
    private int region;
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
    private Boolean hope;
    private Boolean teens;
    private Boolean latinUnion;
    private Boolean soar;
    private Boolean bloodBrotherhood;
    private Boolean inhibitors;
    private Boolean advocacy;
    
    //constructor
    public Family(){
        familyId = 0;
        region = 0;
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
        hope = false;
        teens = false;
        latinUnion = false;
        soar = false;
        bloodBrotherhood = false;
        inhibitors = false;
        advocacy = false;
    }
    
    //constructor with provided family ID
    public Family(int familyId){
        this.familyId = familyId;
        region = 0;
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
        hope = false;
        teens = false;
        latinUnion = false;
        soar = false;
        bloodBrotherhood = false;
        inhibitors = false;
        advocacy = false;
    }
    
    //methods
    public boolean getAdvocacy(){
        return advocacy;
    }
    
    public void setAdvocaccy(boolean advocacy){
        this.advocacy = advocacy;
    }
    
    public String getBleedDisorder(){
        return bleedDisorder;        
    }
    
    public void setBleedDisorder(String bleedDisorder){
        this.bleedDisorder = bleedDisorder;
    }
    
    public boolean getBloodBrotherhood(){
        return bloodBrotherhood;
    }
    
    public void setBloodBrotherhood(boolean bloodBrotherhood){
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
    
    public int getFamilyId(){
        return familyId;
    }
    
    public void setFamilyId(int familyId){
        this.familyId = familyId;        
    }
    
    public String getHomePhone(){
        return homePhone;
    }
    
    public void setHomePhone(String cellHome){
        this.homePhone = cellHome;
    }
    
    public boolean getHope(){
        return hope;
    }
    
    public void setHope(boolean hope){
        this.hope = hope;
    }
    
    public boolean getInhibitors(){
        return inhibitors;
    }
    
    public void setInhibitors(boolean inhibitors){
        this.inhibitors = inhibitors;
    }
    
    public String getLName(){
        return lName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public boolean getLatinUnion(){
        return latinUnion;
    }
    
    public void setLatinUnion(boolean latinUnion){
        this.latinUnion = latinUnion;
    }
    
    public int getRegion(){
        return region;
    }
    
    public void setRegion(int region){
        this.region = region;
    }
    
    public boolean getSoar(){
        return soar;
    }
    
    public void setSoar(boolean soar){
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
    
    public boolean getTeens(){
        return teens;
    }
    
    public void setTeens(boolean teens){
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
