  @LoginViaRegistration @Regression @Web @Candidate5 @Traffic
  Feature: Candidate Registration LoginViaRegistration

    @registerApplyLogin
    Scenario: Login as an existing candidate via Register and Apply
     Given  I navigate to page "Jobs Non External Test Jobs"
      And   I click on non external job to apply
      And   I Click on Link Register & Apply
      And   I fill candidate email with "testers+candidate@resume-library.com"
      And   I fill job apply password with "rl" on job apply
      Then  I should see text "This email already exists, please login"
      When  I click on "Menu"
      Then  I click on "Login"
      And   I fill job apply password with "rltest01" on job apply
      And   I Click on Link Register & Apply
      Then  I should see text p tag replace all "Resume-Library, you're applying for:"
      And   I should be able to see in browser URL "Job Apply"