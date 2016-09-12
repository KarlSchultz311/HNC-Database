/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnc.controller;

import java.awt.event.*;
import hnc.view.*;
import java.io.*;

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
    
    private void addFamilyMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        System.out.print("pushed add family button");
    }
    
    private void confirmDeleteFamilyActionPerformed(ActionEvent event, MemberUI memberUI) {
        System.out.print("pushed confirm delete family button");
    }
    
    private void confirmMemberDeleteActionPerformed(ActionEvent event, MemberUI memberUI) {
        //stub
    }
    
    private void createFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void createMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        memberUI.getMember();
    }
    
    private void deleteFamilyRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void deleteMemberRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void familySearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void loadFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void loadMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void loadMemberDataFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void memberSearchActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void todayActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void updateFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
    
    private void updateMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        //stub
    }
}
