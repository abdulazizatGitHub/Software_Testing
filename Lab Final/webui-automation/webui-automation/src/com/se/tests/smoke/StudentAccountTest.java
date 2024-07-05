package com.se.tests.smoke;

import com.se.config.Constants;
import com.se.rolesbase.StudentLoginBase;
import com.se.utils.NavigationUtil;
import com.se.utils.UtilsSet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentAccountTest extends StudentLoginBase {


    @Test
    public void verifyStudentIsLoggedIn(){


        System.out.println("A Student is now logged in");
    }

    @Test(dependsOnMethods = {"verifyStudentIsLoggedIn"})
    public void verifySkipButtonAndNavigateToHomePage() {
        System.out.println("Starting verifySkipButtonAndNavigateToHomePage test");

        try {
            // Click the Skip Button
            NavigationUtil.clickonskipbutton();
            System.out.println("Skip button clicked");

            // Wait for the home page to load
            int timeoutSeconds = 15;
            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_HomepageText, timeoutSeconds);

            // Verify that we're on the home page
            String homePageText = UtilsSet.getElementText(Constants.DueExame.BY_HomepageText);
            System.out.println("Home page text: " + homePageText);

            Assert.assertFalse(homePageText.isEmpty(), "Home page text should not be empty");
            Assert.assertEquals(homePageText, "Welcome! Abdul Aziz", "Home page text should be 'Homepage'");

            System.out.println("verifySkipButtonAndNavigateToHomePage test completed successfully");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("Failed to click Skip button or navigate to Home Page");
            Assert.fail("Failed to click Skip button or navigate to Home Page", e);
        }
    }


    @Test(dependsOnMethods = {"verifyStudentIsLoggedIn","verifySkipButtonAndNavigateToHomePage"})
    public void verifyDueExameButtonIsClicked() {
        System.out.println("Starting verifyDueExamButtonIsClicked test");
        NavigationUtil.clickDueExameButton();
        System.out.println("Due Exam button is clicked");

        try {
            int timeoutSeconds = 27;

            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_dueExameSection, timeoutSeconds);
            String dueExameSectionText = UtilsSet.getElementText(Constants.DueExame.BY_dueExameSection);
            System.out.println("Due Exame section is visible with text: " + dueExameSectionText);

//            Assert.assertNotNull(dueExameSectionText, "dueExameSectionText should not be null");
            Assert.assertFalse(dueExameSectionText.isEmpty(), "dueExameSectionText should not be empty");
            Assert.assertEquals(dueExameSectionText, "Exams", "Mismatch text when the Due Exame button is clicked");
            System.out.println("verifyDueExameButtonIsClicked test completed successfully");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("The dueExameSectionElement was not found or did not behave as expected.");
            Assert.fail("The dueExameSectionElement was not found or did not behave as expected.", e);
        }

    }

    @Test(dependsOnMethods = {"verifyStudentIsLoggedIn", "verifyDueExameButtonIsClicked"})
    public void verifyExamTitleLinkIsClicked() {
        System.out.println("Starting verifyExameTitleLinkIsClicked test");
        NavigationUtil.clickQuizTitleLink();
        System.out.println("The quiz title link is clicked");

        try{
            int timeoutSeconds = 15;

            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_examSummarySection, timeoutSeconds);

            // Scroll to the Exam Summary section
            UtilsSet.scrollToElement(Constants.DueExame.BY_examSummarySection);

            String examSummarySectionText = UtilsSet.getElementText(Constants.DueExame.BY_examSummarySection);
            System.out.println("Exam Summary section is visible with text: " + examSummarySectionText);
            Assert.assertFalse(examSummarySectionText.isEmpty(), "examSummarySection should not be empty");
            Assert.assertEquals(examSummarySectionText, "Quiz 1 SP24 in Software Testing", "Mismatch text when the exam title link is clicked");
            System.out.println("verifyExamTitleLinkIsClicked test completed successfully");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("The verifyExamTitleLink was not found or did not behave as expected.");
            Assert.fail("The verifyExamTitleLink was not found or did not behave as expected.", e);
        }

    }
    @Test(dependsOnMethods = {"verifyStudentIsLoggedIn","verifySkipButtonAndNavigateToHomePage", "verifyDueExameButtonIsClicked", "verifyExamTitleLinkIsClicked"})
    public static void verifyExamResults() {
        System.out.println("Starting verifyExamResults test");
        NavigationUtil.verifyTestResultSDisplayed();

        try {
            int timeoutSeconds = 27;

            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_testResultSection, timeoutSeconds);
            String testResultSectionText = UtilsSet.getElementText(Constants.DueExame.BY_testResultSection);
            System.out.println("Test result section is visible with text: " + testResultSectionText);

            Assert.assertFalse(testResultSectionText.isEmpty(), "testResultSectionText should not be empty");
            Assert.assertEquals(testResultSectionText, "Exam Results of 'Abdul Aziz' (User Name: Fa21-058)", "Mismatch text when the Due Exame button is clicked");
            System.out.println("verifyExamResults test completed successfully");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("The testResultSectionText was not found or did not behave as expected.");
            Assert.fail("The testResultSectionText was not found or did not behave as expected.", e);
        }

    }
}
