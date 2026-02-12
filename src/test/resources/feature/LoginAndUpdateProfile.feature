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

    Given I tap on My accounts icon from bottom navigation bar
    And I land on My account page
    And I tap on My profile option
    And I land on the edit profile page
    When I tap on Date of birth field
    Then the calendar picker opens
    When I choose the date "15" May "2002" and confirms the date

#    When I tap on profile icon it opens a drop down to to edit photo "Profile"
#    Then I updated my profile picture

    When I update the state as "California"
    Then I update the city as "Los Angeles"
    And I update the zipcode as "90001"
    Then I tap on Update button


