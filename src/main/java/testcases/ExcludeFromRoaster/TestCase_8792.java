package testcases.ExcludeFromRoaster;

import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

//Test Case 8792:Cloud : Verify Whether "Do Not Roster" Field Name Changed to "Exclude from Roster" for Member/Non GPO/Location Type/Prospect Accounts

public class TestCase_8792 {


	@Test
	public void ExcludeRoster(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		new WebDriverServiceImpl();
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()
		.clicYesInStaySignedin()

		//2.Go to Workplace > Accounts and search   
		.selectAccountsTab()

		//Search GPO Active Member
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;

		new DashboardPage()
		.selectAccountsTab()

		//GPO Draft Member
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;

		new DashboardPage()
		.selectAccountsTab()

		//Non GPO Active
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber2", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;


		new DashboardPage()
		.selectAccountsTab()

		//Prospect search
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber3", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;

		new DashboardPage()
		.selectAccountsTab()

		//Ship to Active
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber4", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;

		new DashboardPage()
		.selectAccountsTab()

		//Ship to Draft
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber5", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;


		// Non GPO Draft member

		new DashboardPage()
		.selectAccountsTab()
		
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber6", sDataSheetName))

		.selectAccountFromSearchResults()
		.navigateToroster()
		.excludeFromRoster()
		;
	}

}
