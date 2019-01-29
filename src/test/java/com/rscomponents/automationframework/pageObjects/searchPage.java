package com.rscomponents.automationframework.pageObjects;

import com.rscomponents.automationframework.helpers.globalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class searchPage extends globalHelper {

    private By itemsStockNo = By.cssSelector("#search-results > div.grid-container > div > div.cell.small-8.xlarge-9.xxlarge-10 > div.wrapper_2zZyTprJ.loading-overlay.results-wrapper > div.product-grid-container > div > div:nth-child(1) > div > div.details_1BWgUA5n > div:nth-child(1) > div > a > span");
    private By itemsPrices = By.cssSelector("#search-results > div.grid-container > div > div.cell.small-8.xlarge-9.xxlarge-10 > div.wrapper_2zZyTprJ.loading-overlay.results-wrapper > div.product-grid-container > div > div:nth-child(1) > div > div.actions_RcIJPW_C > div > span.price_TfImslv4");
    private By applyFiltersBtn = By.cssSelector("#filters > div > div > rs-facets > div > div.popover-inner > div > div:nth-child(6) > rs-apply-button > button");
    private By mainCategoriesFilter = By.cssSelector("#filters > div > div > rs-facets > a");
    private By SubCategoriesFilter = By.cssSelector("#filters > div > div > rs-facets > div > div > div > div.clearfix > div > span > div > label > span:nth-child(2)");
    private By subCategoriesNames = By.cssSelector("#filters > div > div > rs-facets > div > div.popover-inner > div > div.clearfix > div > span > div > label > span:nth-child(2) > span");
    private By appliedFilters = By.cssSelector("#bread-box > div.appliedFilters > rs-bread-box > div.row > div.row > div> div");
    private By filteredResults = By.cssSelector("#results-table > tbody > tr > td.descriptionCol.compareContainer > div.row.margin-bottom > a");
    private By numberOfProductsForAFilter = By.cssSelector("#filters > div > div > rs-facets > div > div > div > div.clearfix > div > span > div > label > span:nth-child(2) > span > span");
    private By numberOfFilteredResults = By.cssSelector("#sticky-results-header > rs-pagination > div > div > div:nth-child(1) > div");
    private By removeAllFilters = By.cssSelector("#bread-box > div.appliedFilters > rs-bread-box > div.col-xs-12.noPaddingCol > div > a");
    private By itemQty = By.cssSelector("#search-results > div.grid-container > div > div.cell.small-8.xlarge-9.xxlarge-10 > div.wrapper_2zZyTprJ.loading-overlay.results-wrapper > div.product-grid-container > div > div:nth-child(1) > div > div.actions_RcIJPW_C > form > div > input[type=\"text\"]");
    private By addToCart = By.cssSelector("#search-results > div.grid-container > div > div.cell.small-8.xlarge-9.xxlarge-10 > div.wrapper_2zZyTprJ.loading-overlay.results-wrapper > div.product-grid-container > div > div:nth-child(1) > div > div.actions_RcIJPW_C > form > button > div");


    public void addFirstItemToCartFromSearchResults(){
        clickElementUsingJavascriptExecutor(waitForElementVisibleBy(addToCart));
    }

    public void changeFirstItemQuantity(String Qty){ waitClearAndEnterText(itemQty, Qty); }

    private List<WebElement> listNumberOfProductsForAFilter(){ return visibilityOfAllElementsLocatedBy(numberOfProductsForAFilter); }

    public String getNumberOfProductsForAFilter(String subCategory){
        String value = "";
        for(int i=0; i<listNumberOfProductsForAFilter().size(); i++){
            String expectedCategory = getSubcategoryNames().get(i).getText().trim();
            if(expectedCategory.contains(subCategory)){
                value = listNumberOfProductsForAFilter().get(i).getText().trim();
            }
        }
        return value;
    }

    public String getNumberOfFilteredResults(){ return waitForElementVisibleBy(numberOfFilteredResults).getText().trim(); }

    public String getFirstItemPriceFromSearchResults(){
        String itemPrice = visibilityOfAllElementsLocatedBy(itemsPrices).get(0).getText().trim();
        return itemPrice;
    }

    public void clickRemoveAllFilters(){ waitForElementVisibleBy(removeAllFilters).click(); }

    public String getFirstItemStockNoFromSearchResults(){
        String itemStockNo = visibilityOfAllElementsLocatedBy(itemsStockNo).get(0).getText().trim();
        return itemStockNo;
    }

    public List<WebElement> getListOfMainCategoriesFilters(){
        return visibilityOfAllElementsLocatedBy(mainCategoriesFilter);
    }

    public List<WebElement> getListOfSubCategoriesFilters(){
        return visibilityOfAllElementsLocatedBy(SubCategoriesFilter);
    }

    public List<WebElement> getSubcategoryNames(){
        return visibilityOfAllElementsLocatedBy(subCategoriesNames);
    }

    public List<WebElement> getItemsDescriptionForFilteredResults(){
        return visibilityOfAllElementsLocatedBy(filteredResults);
    }

    public void selectAFilterMainCategory(String mainCategory) {
        for (int i = 0; i < getListOfMainCategoriesFilters().size(); i++) {
            String Category = getListOfMainCategoriesFilters().get(i).getText().trim();
            if (Category.equalsIgnoreCase(mainCategory)) {
                sleep(2);
                getListOfMainCategoriesFilters().get(i).click();
                break;
            }
        }
    }

    public void selectASubCategory(String filterSubCategory){
        for(int i=0; i<getSubcategoryNames().size(); i++){
            String subCategory = getSubcategoryNames().get(i).getText().trim();
            if(subCategory.contains(filterSubCategory)){
                getListOfSubCategoriesFilters().get(i).click();
                break;
            }
        }
    }

    public void clickApplyFiltersBtn(){ waitForElementVisibleBy(applyFiltersBtn).click(); }

    public List<WebElement> getAppliedFilters(){ return visibilityOfAllElementsLocatedBy(appliedFilters); }

    public boolean checkAllFilterIsCleared(){
        return driver.findElements(appliedFilters).isEmpty();
    }

    public boolean isFilterApplied(String subCategory){
        boolean value = false;
        for(int i=0; i< getAppliedFilters().size(); i++){
            String expectedSubCategory = getAppliedFilters().get(i).getText().trim();
            if(expectedSubCategory.contains(subCategory)){
                value = true;
            }
        }
        return value;
    }

    public boolean isItemsDescriptionCorrectForBrandFilters(String subCategory){
        boolean value = false;
        for(int i=0; i< getItemsDescriptionForFilteredResults().size(); i++){
            String itemsDescription = getItemsDescriptionForFilteredResults().get(i).getText().trim();
            if(itemsDescription.contains(subCategory)){
                value = true;
            }
        }
        return value;
    }
}
