
package hnc.controller;

import java.awt.event.*;
import hnc.business.manager.MemberManager;
import hnc.business.manager.FamilyManager;
import hnc.view.MemberUI;
import hnc.domain.Member;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import hnc.domain.Family;
import javax.swing.JOptionPane;

/**MemberController
 This class is a controller class for the MemberUI. It assigns ActionListeners to
 * the buttons, then defines the actions to be taken when an event occurs.
 *
 * @author Karl Schultz
 * Version 1.0 9/6/2016
 * Version 2.0 10/6/2016
 * Updated comments and re-ordered methods to match UI appearance order
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
    
    ///////////////////////// MEMBER TABS SECTION //////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    private void memberSearchActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will call to the UI to get parameters for the member search.
        It will then ask the MemberManager to do the search with the parameters given.
        It will then ask the UI to display the ArrayList provided by the MemberManager.
        */
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMemberSearchParams();
        try{
            //displayMemberSearch will display the result list generated by the searchMember method
            memberUI.displayMemberSearch(memMan.searchMember(member));
            
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    private void loadMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will get the memberID from the UI from the member edit/delete tab.
        It will then task the memberManager with searching the database for a matching
        member. It will then ask the UI to display the resulting Member object.
        */
        MemberManager memMan = new MemberManager();
        String memId = memberUI.getMemberID3();
        try{
        Member member = memMan.findMember(memId);
        memberUI.loadMember(member);        
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void todayActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will display the current date in MM/dd//yyyy format in the 
        // updatedDate text field of the member edit/delete tab.
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        memberUI.setUpdate(dateFormat.format(date));
    }
    
    private void updateMemberDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will ask the MemberUI to get the data from the member edit/delete tab,
        and return it as a Member object. This method will then task the memberManager with
        using this Member object to update the database of this member.
        */
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMember3();
        try{
            memMan.updateMember(member);
            memberUI.showDump();
            JOptionPane.showMessageDialog(memberUI, "Member "+ member.getLName()+ " updated");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void deleteMemberRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will activate the deletion confirm button to allow deletion of member row.
        memberUI.enableConfirmMemberDeleteButton();        
    }
    
    private void confirmMemberDeleteActionPerformed(ActionEvent event, MemberUI memberUI) {
        /*This method will get the memberID number from the member edit/delete tab. It
        will then task the memberManager with deleting this member from the database.
        If deleted correctly, it will disable the confirm member delete button and show a 
        dialog box with confimration of deletion. Finally it will clear out the text form.
        */
        MemberManager memMan = new MemberManager();
        String memId = memberUI.getMemberID3();
        try{
        Boolean deleted = memMan.deleteMember(memId);
        //if deleted successfully
        if (deleted){
            JOptionPane.showMessageDialog(memberUI, "Member deleted");
            //resets the confirmation button
            memberUI.disableConfirmMemberDeleteButton();
            Member member = new Member();
            //clears the form by loading a blank member
            memberUI.loadMember(member);
            memberUI.setMemberID3(null);
            memberUI.showDump();
        }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void createMemberActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will ask the UI to create a Member object from the displayed 
        data in on the create member form. It will then task the member manager with
        creating a new entry with the Member object provded. Finally there will be 
        a dialog box pop up with confirmation.
        */
        MemberManager memMan = new MemberManager();
        Member member = memberUI.getMember2();
        try{
            memberUI.setMemberID2(memMan.saveMember(member));
            memberUI.showDump();
            JOptionPane.showMessageDialog(memberUI, "Member "+ member.getLName()+ " created");
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    
    /////////////////////////FAMILY TABS SECTION////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    private void familySearchActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will get the input parameters from the search family tab data
        fields in the UI as a Family object. It will then task the family manager
        with searching for matching parameters, and then will provide the UI with 
        the list returned by the family manager for display in the family search tab
        */
        FamilyManager famMan = new FamilyManager();
        
        Family family = memberUI.getFamilySearchParams();
        try{
            //displayFamilySearch will display the result list generated by the searchMember method
            memberUI.displayFamilySearch(famMan.searchFamily(family));
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void loadFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will ask the UI for the familyID number listed in the family edit/delete
        tab. This number will then be used to task the Family manager with finding the 
        matching family object in the database. This object will then be sent to the UI to 
        be displayed on the family edit/delete tab text fields. The memberManager will
        then be tasked with finding all the members with matching family ID's. This list will
        be returned to the UI to display the family members in the text area.
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
        The member manager will then be tasked with finding the matching family object
        in the database. This Member object will then be used by the UI to update 
        text fields on the Family edit/delete tab. This member's familyID will then
        be updated with the current family ID of the UI tab. This updated Member object
        will then be sent to the memberManager to be updated.*/
        String memId = memberUI.getMemberID5();
        String famId = memberUI.getFamID5();
        MemberManager memMan = new MemberManager();
        try{
            Member member = memMan.findMember(memId);
            memberUI.updateFamilyGroups(member);
            member.setFamilyId(famId);
            memMan.updateMember(member);        
            memberUI.displayFamilyMembers(memMan.getFamilyMembers(famId));
            memberUI.showDump();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void updateFamilyDataActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method asks the UI to return a Family object from the data shown in the
        Family edit/delete tab. This Family object is then sent to the family manager
        to be updated in the database. A pop up dialog box is then generated to show 
        update success.*/
        Family family = memberUI.getFamily5();
        FamilyManager famMan = new FamilyManager();
        try{
            famMan.updateFamily(family);
            memberUI.showDump();
            JOptionPane.showMessageDialog(memberUI, "Family "+ family.getLName()+ " updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void deleteFamilyRecordActionPerformed(ActionEvent event, MemberUI memberUI){
        //This method will activate the deletion confirm button to allow deletion of a family row.
        memberUI.enableConfirmFamilyDeleteButton(); 
    }
    
    private void confirmDeleteFamilyActionPerformed(ActionEvent event, MemberUI memberUI) {
        /*This method will ask the UI to return the family ID from the text field on 
        the edit/delete family tab,it will then task the family manager to delete the 
        family row from the family database matching the Family ID number.
        A pop up box will confirm deletion. And the form will be cleared.
        Note: The database is set so the foreign key family ID values of the members
        will be set to null when the familyID is deleted from the families table*/
        String familyId = memberUI.getFamID5();
        FamilyManager famMan = new FamilyManager();
        try{
            famMan.deleteFamily(familyId);
            JOptionPane.showMessageDialog(memberUI, "Family "+ familyId+ " deleted");
            Family family = new Family();
            memberUI.loadFamily(family);            
            memberUI.showDump();
        }catch (Exception e){
            System.out.println(e);
        }
        memberUI.disableConfirmFamilyDeleteButton();
    }
    
    
    private void loadMemberDataFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will ask the UI to provide a member ID from the Family create tab.
        The family manager will then be tasked with finding a matching family object.
        This Family object will then be provided to the UI to display the data members
        on the Create Family tab.
        */
        
        String memId = memberUI.getMemberID6();
        FamilyManager famMan = new FamilyManager();
        try{
            memberUI.loadPrimaryMember(famMan.getPrimaryMember(memId));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void createFamilyActionPerformed(ActionEvent event, MemberUI memberUI){
        /*This method will ask the UI to return a Family object created from the 
        data members shown on the Create Family tab. The family manager will then
        be tasked with creating a new Family row in the database. This new family
        ID number will be returned to the UI to be displayed. The member manager 
        will then be tasked with updating the family ID of the primary member 
        listed in the Family Create tab of the UI. A dialog box will then be shown
        to confirm creation of family.
        */
        Family family = new Family();
        family = memberUI.getFamily6();
        String memId = memberUI.getMemberID6();
        FamilyManager famMan = new FamilyManager();
        MemberManager memMan = new MemberManager();
        try{
            String famId = famMan.createFamily(family);
            memberUI.setFamilyID6(famId);
            memMan.updateFamilyId(famId, memId);
            memberUI.showDump();
            JOptionPane.showMessageDialog(memberUI, "Family "+ family.getLName()+ " created");
        }catch (Exception e){
            System.out.println(e +" @ memcontroller");
        }
        
    }
    
    
    
    
    
    
    
    
    
    
  
   
    
    
    
    
    
    
    
    
    
    
    
    
}
