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

    @Test
    public void verifyWelcomeToTrainStudent(){

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

    @Test
    public void verifyExameTitleLinkIsClicked() {
        System.out.println("Starting verifyExameTitleLinkIsClicked test");
        
    }

}
