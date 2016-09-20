/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.controller;

import java.awt.event.*;
import hnc.business.manager.MemberManager;
import hnc.view.MemberUI;
import java.io.*;
import hnc.domain.Member;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        String memId = memberUI.tf_memID3.getText();
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
        
        memberUI.ConfirmMemberDeleteButton.setEnabled(false);
    }
    
    private void createMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will get the data from the text fields and checkboxes of the
        add new member screen and create a member object. This object will then be 
        sent to be stored. The assigned member ID will be displayed in the text
        field at the bottom.
        */
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMember();
        try{
            memberUI.tf_memID2.setText(memMan.saveMember(member));
            System.out.print(member.getLName());
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    private void deleteMemberRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will activate the deletion confirm button to allow deletion of member row.
        memberUI.ConfirmMemberDeleteButton.setEnabled(true);        
    }
    
    private void todayActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will display the current date in MM/dd//yyyy format in the 
        // updatedDate text field.
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        memberUI.tf_update3.setText(dateFormat.format(date));
    }
    
    
    private void addFamilyMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void confirmDeleteFamilyActionPerformed(ActionEvent event, MemberUI memberUI) {
        //stub
    }
    
    
    
    private void createFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    
    
    private void deleteFamilyRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    
    
    private void familySearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void loadFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    
    
    private void loadMemberDataFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void memberSearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    
    
    private void updateFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void updateMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
}
