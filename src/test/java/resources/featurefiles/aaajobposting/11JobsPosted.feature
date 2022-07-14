@11JobPostingApi @Regression @skip_hooks @Api @ReleaseRegression1 @Partnerships
Feature: 11 Job Posting api

  @11apiJobPostingWithAccount
  Scenario: Posting 11 jobs via api for testing purposes
    Given I set up as test partner
    And I set on request header for account
    And I generate request body for 11 new jobs
    When I request job create using HTTP POST
    Then the job API response code is 201