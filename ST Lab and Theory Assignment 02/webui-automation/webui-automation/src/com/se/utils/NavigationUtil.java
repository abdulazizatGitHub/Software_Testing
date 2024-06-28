package com.se.utils;

import com.se.config.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.scanner.Constant;

import java.sql.Driver;

import static com.se.utils.UtilsSet.*;

public class NavigationUtil {
    @Step("Opening a subject base on {0}.")
    public static void openSubjectFromLearnMenu(String subName) {
        clickOnElement(By.linkText(subName));
    }

    @Step("Clicking on the Due Exame button.")
    public static void clickDueExameButton() {
        clickOnElement(Constants.DueExame.BY_dueExameButton);
    }
    @Step("Clicking on the quiz title link.")
    public static void clickQuizTitleLink() {
        clickOnElement(Constants.DueExame.BY_examTitleLink);
    }

    @Step("Performing exam title search with query: {0}")
    public static void searchExamTitle(String title) {
        clearAndSetElementText(Constants.DueExame.BY_examTitleSearchField, title);
        clickOnElement(Constants.DueExame.BY_examTitleSearchButton);
    }

    @Step("Verifying exam title: {0} is displayed")
    public static boolean verifyExamTitleDisplayed(String expectedTitle) {
        String actualTitle = getElementText(Constants.DueExame.BY_examTitleLink);
        return actualTitle.equals(expectedTitle);
    }

    @Step("Verifying Exams status filtering is performed")
    public static void selectExamStatus(String status) {
        WebElement selectElement = findElement(Constants.DueExame.BY_examStatusSelector);
        Select select = new Select(selectElement);
        select.selectByVisibleText(status);
        clickOnElement(Constants.DueExame.BY_examTitleSearchButton);
    }

}
