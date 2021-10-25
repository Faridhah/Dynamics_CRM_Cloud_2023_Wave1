package testcases.Member;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;

//Test Case 8925:Cloud: Verify AG and AG effective date on Account termination when AG populated based on FBO and Business classification is NON Healthcare


public class TestCase_8925 {
	  	
	@Test
	public void createMember(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
		
	  	//2. From the left navigation column ,Go to My Work>Accounts > + New
		    .selectAccountsTab()
	  	  	.clickNewOnAccountsPage()
			.chooseMemberForm()				
			
		//3. Account  Type = Member
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "accountType", sDataSheetName))
			
			//Account name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
			
			//Class of Trade =Any
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "classOfTrade", sDataSheetName))
			
			//Business Classification =NON Healthcare
			.clearAndSelectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "businessClassification", sDataSheetName))
			
			//Account Status = Auto Populated to Active
			.verifyDefaultAccountStatus()	
			
			//Application Start Date = Today's Date
			.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "applicationDate", sDataSheetName))
		
			//CAMS Flag = Yes
			.changeCAMSFlagAsYes()
			
			//Participation Type = Standard
			.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "participationType", sDataSheetName))
				
			//Direct Parent Entity Code = MN2003
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
			
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged() 
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "directParentRelationDate", sDataSheetName))
			
			//Top Parent Relation =  OLM
			.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelation", sDataSheetName))
			
			// Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelationDate", sDataSheetName))
			 
		//4. Street 1 = Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
					
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "city", sDataSheetName))
			
			 //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "country", sDataSheetName))
			
			//Type Zip code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
		 
			// Click on Save 
			 .clickSave() 
			 
		//5. Go to Membership and Click on add new membership
			 .clickAddNewMembership()
			 .selectMembershipType(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderType", sDataSheetName))
			 .selectMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
				
			//Provide any start date and click on save
			.typeMembershipStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderStartDate", sDataSheetName))
			
			//Click on membership save and close
			.clickQuickCreateMembershipSaveAndClose()
			
			// Click the + icon on the Line of Business Grid
			.clickLineOfBusiness()
					
		//6.Go to LOB and click on add LOB
			.clickAddNewLineOfBusiness()
		
			// Line of Business =General GPO
			.selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfBusiness", sDataSheetName))
			
			// Classification Type = General GPO
			.selectLOBfClassificationType(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfClassification", sDataSheetName))
			
			// Start Date =Today's date
			.typeLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "lineOfBusinessStartDate", sDataSheetName))
			
			// Click on LOB Save 
			.clickLOBSaveAndClose()			
			
		//7.Observe the AG and AG effective date populated 
			.verifyAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "affiliateGroup", sDataSheetName))
			.verifyAgEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFBORD", sDataSheetName))
			
		//8.Go to the Premier Membership and end date the Membership with any future date then save
			
			.goToMembershipPage(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
			
			//Provide end date = Any future date **** Account should be saved successfully 
			.typeMembershipEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))
			
			// End reason = Anything from dropdown,
			.selectMembershipEndReason(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndReason", sDataSheetName))
			
			// then save
			.clickMembershipSaveAndClose()
			
			//Verify the account status  ***** Account status should become terminated 
			.verifyAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "accountStatus", sDataSheetName))
			
			//Verify Premier end date **** Premier end date should be populated with the same date  as National membership end date 
			.verifyPremierEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))
			
		//9.Observe the AG and AG effective date populated 
			.verifyAffiliateGroup("Non Premier NonAcute")
			.verifyAgEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipEndDate", sDataSheetName))
		;
	}
}
