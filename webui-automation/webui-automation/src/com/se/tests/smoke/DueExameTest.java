//package com.se.tests.smoke;
//
//import com.se.rolesbase.StudentLoginBase;
//import com.se.utils.LoginUtil;
//import com.se.utils.NavigationUtil;
//import com.se.utils.UtilsSet;
//import com.se.utils.WebDriverUtil;
//import com.se.config.Constants;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class DueExameTest extends StudentLoginBase {
//    private WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        driver = WebDriverUtil.initializeDriver();
//        LoginUtil.loginAsStudent(driver); // Change to Teacher if needed
//    }
//
//    @Test(dependsOnMethods = {"com.se.tests.smoke.StudentAccountTest.verifyStudentIsLoggedIn"})
//    public void verifyDueExameButtonIsClicked() {
//        System.out.println("Starting verifyDueExamButtonIsClicked test");
//        NavigationUtil.clickDueExameButton();
//        System.out.println("Due Exam button is clicked");
//
//        try {
//            int timeoutSeconds = 27;
//
//            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_dueExameSection, timeoutSeconds);
//            String dueExameSectionText = UtilsSet.getElementText(Constants.DueExame.BY_dueExameSection);
//            System.out.println("Due Exame section is visible with text: " + dueExameSectionText);
//
//            Assert.assertNotNull(dueExameSectionText, "dueExameSectionText should not be null");
//            Assert.assertFalse(dueExameSectionText.isEmpty(), "dueExameSectionText should not be empty");
//            Assert.assertEquals(dueExameSectionText, "Expected Text", "Mismatch text when the Due Exame button is clicked");
//            System.out.println("verifyDueExameButtonIsClicked test completed successfully");
//        } catch (Exception e) {
//            System.err.println("The dueExameSectionElement was not found or did not behave as expected.");
//            Assert.fail("The dueExameSectionElement was not found or did not behave as expected.", e);
//        }
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//}
//
