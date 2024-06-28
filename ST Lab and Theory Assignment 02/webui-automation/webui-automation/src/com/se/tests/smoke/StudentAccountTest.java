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
        } catch (Exception e) {
            System.err.println("The dueExameSectionElement was not found or did not behave as expected.");
            Assert.fail("The dueExameSectionElement was not found or did not behave as expected.", e);
        }

    }

    @Test(dependsOnMethods = {"verifyDueExameButtonIsClicked"})
    public void verifyExamTitleSearchIsPerformed() {
        System.out.println("Starting verifyExamTitleSearchIsPerformed test");

        String searchTitle = "Quiz 1 SP24";

        // Perform search
        NavigationUtil.searchExamTitle(searchTitle);

        // Verify search result
        try {
            int timeoutSeconds = 15;
            UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_examTitleLink, timeoutSeconds);

            // Assert that the searched title is displayed
            Assert.assertTrue(NavigationUtil.verifyExamTitleDisplayed(searchTitle),
                    "Searched exam title is not displayed correctly");

            System.out.println("verifyExamTitleSearchIsPerformed test completed successfully");
        } catch (Exception e) {
            System.err.println("The exam title link was not found or did not behave as expected.");
            Assert.fail("The exam title link was not found or did not behave as expected.", e);
        }
    }

    @Test(dependsOnMethods = {"verifyExamTitleSearchIsPerformed"})
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
        } catch (Exception e) {
            System.err.println("The verifyExamTitleLink was not found or did not behave as expected.");
            Assert.fail("The verifyExamTitleLink was not found or did not behave as expected.", e);
        }
    }

    @Test(dependsOnMethods = {"verifyExamTitleLinkIsClicked"})
    public void verifyExamsWithStatusDisplayed() {
        System.out.println("Starting verifyExamsWithStatusDisplayed test");

        try {
            // Define exam status options
            String[] statuses = {"Closed"};

            for (String status : statuses) {
                System.out.println("Selecting exam status: " + status);
                NavigationUtil.selectExamStatus(status);
                UtilsSet.scrollToElement(Constants.DueExame.BY_examSummarySection);
                // Wait for a reasonable amount of time for the exams table to appear
                int timeoutSeconds = 15;
                UtilsSet.waitForElementToBeVisible(Constants.DueExame.BY_examsTableSectionDisplayed, timeoutSeconds);

                // Check if the exams table is visible using another method or condition
                boolean isExamsTableVisible = UtilsSet.isElementVisible(Constants.DueExame.BY_examsTableSectionDisplayed);
                Assert.assertTrue(isExamsTableVisible, "Exams table should be visible for status: " + status);
            }
            System.out.println("verifyExamsWithStatusDisplayed test completed successfully");

        } catch (Exception e) {
            System.err.println("Exams with status were not displayed as expected.");
            Assert.fail("Exams with status were not displayed as expected.", e);
        }
    }

    @Test(dependsOnMethods = {"verifyExamTitleLinkIsClicked"})
    public void verifyNoExamsSectionDisplayed() {
        System.out.println("Starting verifyNoExamsSectionDisplayed test");

        try {
            // Select a status for which no exams should be displayed
            String status = "In Progress"; // Replace with an appropriate non-existent status

            NavigationUtil.selectExamStatus(status);

            // Wait for no exams section to be visible
            int timeoutSeconds = 15;
            boolean isNoExamsSectionVisible = UtilsSet.isElementVisible(Constants.DueExame.BY_noExamsSectionDisplayed);
            Assert.assertTrue(isNoExamsSectionVisible, "No exams section should be visible for status: " + status);

            System.out.println("verifyNoExamsSectionDisplayed test completed successfully");

        } catch (Exception e) {
            System.err.println("No exams section was not displayed as expected.");
            Assert.fail("No exams section was not displayed as expected.", e);
        }
    }
}
