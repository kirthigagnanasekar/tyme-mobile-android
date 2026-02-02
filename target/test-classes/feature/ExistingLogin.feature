Feature: Login as Existing TyMe Member

  Scenario: Successful login with valid credentials
    Given I launch the TyMe application
    Then the application opens successfully and allows a notification
    Then I skipped a splash screen
    When lands on login page and I enter email address "kirthiga.g+not1@spritle.com"
    And I enter password "Password@123"
    And I tap on the Sign In button
    Then I enter otp as "123456"
    And I tap on the Verify button
    Then I land on the dashboard

