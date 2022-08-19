package testcases.RebatePayment;

import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

//Test Case 9518:Cloud: Create a new rebate payment where check Roll -Up to Aggregate by Pay to. Verfiy user will pick Check Pay to and Check Send to will be locked


public class TestCase_9518 {


	@Test
	public void RebatePayment(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		new WebDriverServiceImpl();
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
		.clickNext()
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clicSignin()
		.clicYesInStaySignedin()

		//2.Go to Workplace > Accounts and search for  
		.selectAccountsTab()

		//Search GPO Active Member
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.selectRebatePayment()
		.clickNewRebateButton()
		.selectCheckRollUp(DataInputProvider.getCellData_ColName(iRowNumber, "CheckRollUp", sDataSheetName))
		.selectCheckSendTo(DataInputProvider.getCellData_ColName(iRowNumber, "CheckSendTo", sDataSheetName))
		.selectRebatePaymentStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "startDate", sDataSheetName))
		.saveRebatePayment()
		.ACHStatusList()
		
		;
	}

}
