package testcases.Member;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;
//Test Case 8802:Cloud - Verify newly added "GPO memberships" in DP should not get cascaded to the "location type children" in draft status.


public class TestCase_8802 {


	@Test
	public void TPRDCheck(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()

		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()

		.clicYesInStaySignedin()

		//2. From the left navigation column ,Go to Accounts > +New
		.selectAccountsTab()


		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
		.selectAccountFromGlobalSearchResults(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))


		//10.Go to membership and Open the Premier National membership ***** Premier National membership should be opened
		.goToMembershipPage(DataInputProvider.getCellData_ColName(iRowNumber,
				"membershipProvider", sDataSheetName)) 

		

		//11.Provide end date = Any future date **** Account should be saved successfully
		.typeMembershipEndDate(DataInputProvider.getCellData_ColName(iRowNumber,
				"membershipEndDate", sDataSheetName))

		// End reason = Anything from dropdown,
		.selectMembershipEndReason(DataInputProvider.getCellData_ColName(iRowNumber,
				"membershipEndReason", sDataSheetName))

		// then save 
		.clickMembershipSaveAndClose()

		.selectSubaccount()

		.createSubAccountLocationType(1)

		.clickGeneralTab()
		.chooseRecordStatusDraft()

		//Click on Save 
		.clickSave() 
		;
		new DashboardPage()

		//2. From the left navigation column ,Go to Accounts > +New
		.selectAccountsTab()


		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
		.selectAccountFromGlobalSearchResults(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		.chooseRecordStatusDraft()

		//Click on Save 
		.clickSave() 

		
		  // 10.Click the + icon on the Line of Business Grid 
		.clickLineOfBusinesses()
		  
		  //Click New Line Of Business 
		.clickAddNewLineOfBusiness()
		  
		  // Line of Business =General GPO
		  .selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber,
		  "lineOfBusiness", sDataSheetName))
		  
		  // Classification Type = General GPO
		  .selectLOBfClassificationTypeIntersectta(DataInputProvider.
		  getCellData_ColName(iRowNumber, "lineOfClassification", sDataSheetName))
		  
		  // Start Date =Today's date
		  .typeLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(
		  iRowNumber, "lineOfBusinessStartDate", sDataSheetName))
		  
		  // Click on LOB Save 
		  .clickLOBSaveAndClose()
		 
		//Click add new membership
		.clickMembershipAndAddNewMembership()

		// Choose Membership type 
		.selectMembershipType(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderType", sDataSheetName))
		.selectMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))

		//Provide any start date and click on save
		.typeMembershipStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProviderStartDate", sDataSheetName))

		//Click on membership save and close
		.clickQuickCreateMembershipSaveAndClose()

		//11. Record Status = Published
		.chooseRecordStatusPublished()

		//Click on Save 
		.clickSave() 
		;

		new DashboardPage()

		.selectAccountsTab()

		.searchAccount(WebDriverServiceImpl.CRMNumber)
		.selectAccountFromGlobalSearchResults(WebDriverServiceImpl.CRMNumber)
		.selectRelatedMembership()
		.searchinMemberShip(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))

		.verifyMembership(false,DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))
		.clickGeneralTab()
		.chooseRecordStatusPublished()

		//Click on Save 
		.clickSave()

		.selectRelatedMembership()
		.searchinMemberShip(DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))

		.verifyMembership(true,DataInputProvider.getCellData_ColName(iRowNumber, "membershipProvider", sDataSheetName))



		;
	}
}
