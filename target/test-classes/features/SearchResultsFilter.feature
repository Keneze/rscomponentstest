@Search-Filter
Feature: As RS customer, I want to be able to apply filters to my search results

  @Search-Filter-Test1
  Scenario: Check that user can apply single filter on search results page
    Given I am on RS Components homepage as guest
    When I search for 'monitors'
    And I select 'Brand' filter named 'Samsung'
    Then I verify filter is present in filters breadcrumbs correctly
    And I verify displayed results are correct
    And I verify the total search results for the applied filter

  @Search-Filter-Test2
  Scenario: Check that user can apply more than one filter on search results page
    Given I am on RS Components homepage as guest
    When I search for 'sealants'
    And I select 'Brand' filter named 'Geocel'
    And I select another 'Colour' filter named 'White'
    Then I verify multiple filters has been applied applied correctly
    And I verify the total search results for the applied filter

  @Search-Filter-Test3
  Scenario: Check that user can remove filters
    Given I am on RS Components homepage as guest
    And I search for 'clock'
    And I select 'Display' filter named 'Analogue'
    And I select another 'Battery Type' filter named 'AA'
    When I remove all filters
    Then I verify all filters has been removed



