package testcases.PrescriptionData;

import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

//TFS ID 9520 Cloud : Verify Prescription data from/visualization

public class TestCase_9520 {


	@Test
	public void PrescriptionData(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
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
		.selectPrescriptionData()
		.clickPrescritpionDataButton()
		.AddPrescriptionData(DataInputProvider.getCellData_ColName(iRowNumber, "DataContact", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "PharmacySelect", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "DataSource", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "CollectionReason", sDataSheetName),DataInputProvider.getCellData_ColName(iRowNumber, "startDate", sDataSheetName))
		.PharmacySystem()
		.verifyCollectionStatus()
		.verifyCollectionreason()
		.verifyDataSource()
		;
	}

}
