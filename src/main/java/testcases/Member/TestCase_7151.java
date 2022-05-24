package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

//Test Case 7151:Create new Bill to account - New Member form and Save it as prospect first

public class TestCase_7151 {

	  	
	@Test
	public void createNewBillToAcc(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
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
			.selectAccountFromSearchResults()
			.getDPData()
	  	  	.clickNewOnAccountsPage()
			.chooseMemberForm()
		
		//3. Account Name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "accountName", sDataSheetName))
		
			//Click on save 			
			.clickSave() 
		
		//4. Verify CRM Account # is generated 
			.verifyCRMNumberIsDisplayed()	
		
		//5. Account Type = Member
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "accountType", sDataSheetName))
				
			//Class of Trade =Any
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "classOfTrade", sDataSheetName))
			
			//Business Classification = Auto populated
			.verifyBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "verifyBusinessClassification", sDataSheetName))
			
			//Account Status = Auto Populated to Active
			.verifyDefaultAccountStatus()	
			
			//Store/Location type = Bill to
			.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "locationType", sDataSheetName))	
					
			//CAMS Flag = Yes
			.changeCAMSFlagAsYes()
			
			//Direct Parent Entity Code = 673415
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "directParent", sDataSheetName))
				
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged() 
					
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "directParentRelationDate", sDataSheetName))
					
			//Top Parent Relation =  OLM
			.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelation", sDataSheetName))
			
			// Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "topParentRelationDate", sDataSheetName))
					 
			//Click on Save 
			 .clickSave() 
					 
		//6. Street 1 = Any
			 .typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "street1", sDataSheetName))
				
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "city", sDataSheetName))
			
			 //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "country", sDataSheetName))
			
			//Type Zip code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
			
			//Click on Save 
			.clickSave() 
				
		//7. Record Status = Published
			.chooseRecordStatusPublished()				
				
			//Click on Save 
			.clickSave() 
				
		//8. Verify Entity code is same as DP's entity code 
			.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			.verifyAgEffectiveDateIsNull()
			.verifyAffiliateGroupIsNull()
			.selectRelatedMembership()
			.clickSave()
			.clickGeneralTab()
		//Verify Premier start date is auto populated
			.verifyPremierStartDateIsAutoPopulated()
				
			//13. Verify "IS Corporate account" field
			.verifyIsCorporateAccount(WebDriverServiceImpl.Dpdata.get("IsCorporate"))

			//14. Verify Corporate parent name in the form
			.verifyCorporateParentName(WebDriverServiceImpl.Dpdata.get("CorporateName"))

			//15. Verify "Is Food Service parent" field 
			.verifyIsFoodServiceParent(WebDriverServiceImpl.Dpdata.get("isFoodService"))

			//16 Verify Food Service parent name in the form 
			.verifyFoodServiceParentName(WebDriverServiceImpl.Dpdata.get("FoodServiceName"))

			//17 Verify Sponsor field 
			.verifySponsor(WebDriverServiceImpl.Dpdata.get("SponsorName"))

			//16 Verify "Is Sponsor" field 
			.verifyIsSponsor(WebDriverServiceImpl.Dpdata.get("isSponsor"))
		
			// Changing the Location type =Bill to  to Ship to Account
			
			//Store/Location type = Bill to
			.chooseLocationType("Ship To")	
			
			//Click on Save 
			.clickSave() 
			;
		

	}
}