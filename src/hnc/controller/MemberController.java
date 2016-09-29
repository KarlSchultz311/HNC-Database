/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.controller;

import java.awt.event.*;
import hnc.business.manager.MemberManager;
import hnc.business.manager.FamilyManager;
import hnc.view.MemberUI;
import java.io.*;
import hnc.domain.Member;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import hnc.domain.Family;

/**MemberController
 This class is a controller class for the MemberUI. It assigns ActionListeners to
 * the buttons, then defines the actions to be taken when an event occurs.
 *
 * @author Karl Schultz
 * Version 1.0
 * Sept6,2016
 */
public class MemberController implements ActionListener {
    
    //members
    private MemberUI memberUI;
    
    //constructor
    
    public MemberController() {}
    
    //creates a MemberController for an entered MemberUI, and attaches listeners
    //  to the buttons 
    public MemberController(MemberUI memberUI){
        this.memberUI = memberUI;        
        memberUI.getAddFamilyMemberButton().addActionListener(this);
        memberUI.getConfirmDeleteFamilyButton().addActionListener(this);
        memberUI.getConfirmMemberDeleteButton().addActionListener(this);
        memberUI.getCreateFamilyButton().addActionListener(this);
        memberUI.getCreateMemberButton().addActionListener(this);
        memberUI.getDeleteFamilyRecordButton().addActionListener(this);
        memberUI.getDeleteMemberRecordButton().addActionListener(this);
        memberUI.getFamilySearchButton().addActionListener(this);
        memberUI.getLoadFamilyDataButton().addActionListener(this);
        memberUI.getLoadMemberDataButton().addActionListener(this);
        memberUI.getLoadMemberDataFamilyButton().addActionListener(this);
        memberUI.getMemberSearchButton().addActionListener(this);
        memberUI.getTodayButton().addActionListener(this);
        memberUI.getUpdateFamilyDataButton().addActionListener(this);
        memberUI.getUpdateMemberDataButton().addActionListener(this); 
    }
    
    //When an event is regestered, this class method figures out what button was pressed
    //  then calls for an action.
    @Override
    public void actionPerformed(ActionEvent event) {       
        if (event.getSource().equals(memberUI.getAddFamilyMemberButton()))
            addFamilyMemberActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getConfirmDeleteFamilyButton()))
            confirmDeleteFamilyActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getConfirmMemberDeleteButton()))
            confirmMemberDeleteActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getCreateFamilyButton()))
            createFamilyActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getCreateMemberButton()))
            createMemberActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getDeleteFamilyRecordButton()))
            deleteFamilyRecordActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getDeleteMemberRecordButton()))
            deleteMemberRecordActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getFamilySearchButton()))
            familySearchActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getLoadFamilyDataButton()))
            loadFamilyDataActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getLoadMemberDataButton()))
            loadMemberDataActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getLoadMemberDataFamilyButton()))
            loadMemberDataFamilyActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getMemberSearchButton()))
            memberSearchActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getTodayButton()))
            todayActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getUpdateFamilyDataButton()))
            updateFamilyDataActionPerformed(event, memberUI);
        else if (event.getSource().equals(memberUI.getUpdateMemberDataButton()))
            updateMemberDataActionPerformed(event, memberUI);
         
    }
    
    private void loadMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //this method gets the MemberID from input and searched DB for a match
        //if found, it populates all the avalible text fields on the member edit/delete UI
        MemberManager memMan = new MemberManager();
        String memId = memberUI.getMemberID3();
        try{
        Member member = memMan.findMember(memId);
        memberUI.loadMember(member);
        
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void confirmMemberDeleteActionPerformed(ActionEvent event, MemberUI memberUI) {
        //this method will delete the current member row that attatched to the member
        // which has the memId displayed on the member edit screen. It will then 
        // disable the confirm button, resetting this safety.
        MemberManager memMan = new MemberManager();
        String memId = memberUI.getMemberID3();
        try{
        Boolean deleted = memMan.deleteMember(memId);
        //if deleted successfully
        if (deleted){
            //resets the confirmation button
            memberUI.disableConfirmMemberDeleteButton();
            Member member = new Member();
            //clears the form by loading a blank member
            memberUI.loadMember(member);
            memberUI.setMemberID3(null);
        }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void createMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will get the data from the text fields and checkboxes of the
        add new member screen and create a member object. This object will then be 
        sent to be stored. The assigned member ID will be displayed in the text
        field at the bottom.
        */
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMember2();
        try{
            memberUI.setMemberID2(memMan.saveMember(member));          
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    private void deleteMemberRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will activate the deletion confirm button to allow deletion of member row.
        memberUI.enableConfirmMemberDeleteButton();        
    }
    
    private void todayActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will display the current date in MM/dd//yyyy format in the 
        // updatedDate text field.
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        memberUI.tf_update3.setText(dateFormat.format(date));
    }
    
    private void updateMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //this method will grab the data from the text fields and update the database
        //row of the memberID with the new information, then clear the form by loading a
        //blank member
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMember3();
        try{
            memMan.updateMember(member);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void memberSearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will grab the parameters from the member search tab, then 
        //querry the database for the results. It will then display the results in
        //the main text area.
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getSearchParams1();
        try{
            //displayMemberSearch will display the result list generated by the searchMember method
            memberUI.displayMemberSearch(memMan.searchMember(member));
            
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    private void loadMemberDataFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        //this method will fetch the apporpriate data from a member by the member ID number
        //it will then load the data into the textfields for a new family object.
        
        String memId = memberUI.getMemberID6();
        FamilyManager famMan = new FamilyManager();
        try{
            memberUI.loadPrimaryMember(famMan.getPrimaryMember(memId));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void createFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will take the data loaded into the text fields on tab 6 and 
        create a Family object. This Family object will then be saved to the database.
        */
        Family family = new Family();
        family = memberUI.memberToFamily();
        String memId = memberUI.getMemberID6();
        FamilyManager famMan = new FamilyManager();
        try{
            String famId = famMan.createFamily(family);
            memberUI.setFamilyID6(famId);
            famMan.updateFamilyId(famId, memId);
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    private void loadFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will get the family ID number entered on the family edit/delete tab
        and search the database for that family. It will then populate the rest of the 
        data fields with the information. It will then search the member database for 
        members that have matching family ID numbers and display their firstname, lastname
        in the text area in the upper right of the tab.
        */
        String famId = memberUI.getFamID5();
        FamilyManager famMan = new FamilyManager();
        MemberManager memMan = new MemberManager();
        try{
            memberUI.loadFamily(famMan.getFamily(famId));
            memberUI.displayFamilyMembers(memMan.getFamilyMembers(famId));
            
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    
    
    private void addFamilyMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will grab the memberID from the additional family member ID text field
        on the family edit/delete tab when the add family member button is pushed.
        The memberID will be searched for on the database and any interest groups
        that the member has checked that the family does not will update the family
        interest boxes. The added family member will then have their family ID set to
        match the currently displayed family, and the new member's name will appear in
        the text area in the top right of the tab.*/
        String memId = memberUI.getMemberID5();
        String famId = memberUI.getFamID5();
        MemberManager memMan = new MemberManager();
        try{
            Member member = memMan.findMember(memId);
            memberUI.updateFamilyGroups(member);
            member.setFamilyId(famId);
            memMan.updateMember(member);        
            memberUI.displayFamilyMembers(memMan.getFamilyMembers(famId));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void updateFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method commits the data in the text fields on the family edit/delete tab
        to the database for the familyID number shown at the top when the Update Family Data
        button is pushed*/
        Family family = memberUI.getFamily5();
        FamilyManager famMan = new FamilyManager();
        try{
            famMan.updateFamily(family);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    private void deleteFamilyRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will activate the deletion confirm button to allow deletion of member row.
        memberUI.enableConfirmFamilyDeleteButton(); 
    }
    
    private void confirmDeleteFamilyActionPerformed(ActionEvent event, MemberUI memberUI) {
        //stub
        memberUI.disableConfirmFamilyDeleteButton();
    }
    
    
    
    
    
    
    private void familySearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
