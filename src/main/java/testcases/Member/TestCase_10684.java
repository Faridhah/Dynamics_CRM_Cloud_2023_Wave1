package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_ 10684 :Cloud:Verify on  deactivating active DEA ,should get removed from Member form.



public class TestCase_10684 {

	  	
	@Test
	public void verifyAccountNumberEntity(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as Member
		new LoginPage()
			.typeEmail(DataInputProvider.getCellData_ColName(iRowNumber, "email", sDataSheetName))
			.clickNext()
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
	  	    .clicSignin()
	  	    .clicYesInStaySignedin()
		
		//2. Go to Workplace >> Take Any Member Account 
		.selectAccountsTab()		
		.searchAccount(DataInputProvider.getCellData_ColName(iRowNumber, "crmNumber", sDataSheetName)) 
		.selectAccountFromSearchResults()

		//3.Verify DEA when Deactivated is removed from Member Form  
		
		.verifyDEAIsNull()
		.selectAccountNumbers()
		.clickAddNewAccountNumberInAccountNumbers()
		.chooseAccountNumberTypeDEA()
		.typeAccountNumberDEA()
		.clickSaveInAccountNumbersEntity()
		.clickGoBack()
		.clickGeneralTab()
		.verifyDEA(DataInputProvider.getCellData_ColName(iRowNumber, "DEANumber", sDataSheetName))
		.selectAccountNumbers()
		.doubleClickExistingAccountNumberDEA()
		.clickDeactivateInAccountNumbers()
		.clickGoBackOnMemberForm()
		.clickGeneralTab()
		.verifyDEAIsNull();
		
			
					
		//Data Reset	- Not required
		
			
	}
}
