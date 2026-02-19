Feature: Login as Existing TyMe Member

  Background: Successful login with valid credentials
    Given I launch the TyMe application
    Then the application opens successfully and allows a notification
    Then I skipped a splash screen
    When lands on login page and I enter email address "kirthiga.g+not1@spritle.com"
    And I enter password "Password@123"
    And I tap on the Sign In button
    Then I enter otp as "123456"
    And I tap on the Verify button
    Then I land on the dashboard

    Scenario: Edit Profile
    Given I tap on My accounts icon from bottom navigation bar
    And I land on My account page
    And I tap on My profile option
    And I land on the edit profile page
    Then I change the First Name as "Kirthiga"
    And I change the Last Name as "QA"
    Then I updated the gender
    When I tap on Date of birth field
    Then the calendar picker opens
    When I choose the date "15" May "2001" and confirms the date
    When I upload image from gallery
    When I update the state as "California"
    Then I update the city as "Los Angeles"
    And I update the zipcode as "90001"
    Then I tap on Update button

#  Scenario: Update email address and phone number
#    Given I tap on My accounts icon from bottom navigation bar
#    And I land on My account page
#    And I tap on My profile option
#    And I land on the edit profile page
#    Then I update the email address as "kirthiga.g+not11@spritle.com"
#    Then I update a phone number as "6266723451"
#    Then I tap on Update button


