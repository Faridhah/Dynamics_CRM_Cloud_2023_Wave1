package testcases.Pipeline;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS_ID_5342-Cloud :Verify if new pipeline is created by filling all the mandatory fields

public class TestCase_5342 {

	  	
	@Test
	public void verifyLimitedMemberEditablefields(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as Member with Pipeline Steward Role
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

		//3.Verify  Referred By field access 
			.verifyEstLocIsEditable(DataInputProvider.getCellData_ColName(iRowNumber, "numEstLoc", sDataSheetName))
			.verifyReferredByIsEditable(DataInputProvider.getCellData_ColName(iRowNumber, "referredBy", sDataSheetName))						
			.clickNyTabSave()
			
			
			
			//Data Reset
			.removeReferredBy();
		
						
		
				
			
	}
}
