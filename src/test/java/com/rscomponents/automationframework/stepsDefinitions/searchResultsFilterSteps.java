package com.rscomponents.automationframework.stepsDefinitions;

import com.rscomponents.automationframework.dataFactory.searchPageData;
import com.rscomponents.automationframework.pageObjects.searchPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import static org.junit.Assert.assertTrue;


public class searchResultsFilterSteps {

    private searchPage SearchPage;
    private searchPageData SearchFiltersModel;

    public searchResultsFilterSteps(searchPage searchPage, searchPageData searchFiltersModel){
        this.SearchPage = searchPage;
        this.SearchFiltersModel = searchFiltersModel;
    }

    @And("^I (?:select|select another) '(.*)' filter named '(.*)'$")
    public void iApplyABrandFilter(String mainCategory, String subCategory) throws InterruptedException {
        SearchPage.selectAFilterMainCategory(mainCategory);
        String FilteredProducts = SearchPage.getNumberOfProductsForAFilter(subCategory).replaceAll("\\p{P}","");
        SearchFiltersModel.setProductsInAppliedFilter(FilteredProducts);
        SearchPage.selectASubCategory(subCategory);
        SearchPage.clickApplyFiltersBtn();
        SearchFiltersModel.setSubCategory(subCategory);
    }

    @And("^I verify the total search results for the applied filter$")
    public void iVerifyTotalSearchResults(){
        assertTrue(SearchPage.getNumberOfFilteredResults().endsWith(SearchFiltersModel.getProductsInAppliedFilter()+" products"));
    }

    @Then("^I verify multiple filters has been applied applied correctly$")
    public void iVerifyMultipleFiltersHasBeenAppliedCorrectly(){
        SearchPage.sleep(2);
        assertTrue(SearchPage.getAppliedFilters().size()>1);
    }

    @And("^I verify filter is present in filters breadcrumbs correctly$")
    public void iVerifyFilterIsPresentInFilterCrumbsCorrectly(){
        String appliedFilter = SearchFiltersModel.getSubCategory();
        assertTrue(SearchPage.isFilterApplied(appliedFilter));
    }

    @And("^I verify displayed results are correct$")
    public void iVerifyDisplayedResutsAreCorrect(){
        String appliedFilter = SearchFiltersModel.getSubCategory();
        assertTrue(SearchPage.isItemsDescriptionCorrectForBrandFilters(appliedFilter));
    }

    @When("^I remove all filters$")
    public void iRemoveAllFilters(){
        SearchPage.clickRemoveAllFilters();
    }

    @Then("^I verify all filters has been removed$")
    public void iVerifyAllFiltersHasBeenRemoved(){
        SearchPage.sleep(1);
        assertTrue(SearchPage.checkAllFilterIsCleared());
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) SearchPage.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}
