/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.model.domain;

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
    
    
    
}
