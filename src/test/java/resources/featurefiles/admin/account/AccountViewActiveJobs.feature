@AccountViewActiveJobs @Regression @Admin @ReleaseRegression1 @Recruiters
Feature: Account View Active Jobs without Error

  @accountViewActiveJobsOne
  Scenario: Search for an account using account number and verify Active Jobs page load case 1
    Given   I login as an admin user
    When    I navigate to page on admin "Account 1478"
    Then    I should see text "Acme Company No 1728 (1478)"
    Then    I click on Active Jobs
    Then    I should see text "Active Jobs for Acme Company No 1728 #1478"
    Then    I should see text "Job ID"
    Then    I should see text "Posted"
    Then    I should see text "Expiry"
    Then    I should see text "Last Updated"
    Then    I should see text "Posted By"
    Then    I should see text "Job Title"
    Then    I should see text "Views"
    Then    I should see text "Apps"
    Then    I should see text "Status"

  @accountViewActiveJobsTwo
  Scenario: Search for an account using account number and verify Active Jobs page load case 2
    Given   I login as an admin user
    When    I navigate to page on admin "Account 19088"
    Then    I should see text "Acme Company No 787777 (19088)"
    Then    I click on Active Jobs
    Then    I should see text "Active Jobs for Acme Company No 787777 #19088"
    Then    I should see text "Job ID"
    Then    I should see text "Posted"
    Then    I should see text "Expiry"
    Then    I should see text "Last Updated"
    Then    I should see text "Posted By"
    Then    I should see text "Job Title"
    Then    I should see text "Views"
    Then    I should see text "Apps"
    Then    I should see text "Status"