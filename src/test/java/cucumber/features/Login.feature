#Author: Gaurav Datta
Feature: Login feature
  This feature deals with the login functionality of the application

  Scenario: Login with correct Username and Password
    Given I navigate to login page of EZTest
    When I enter the following for Login
      | username | password |
      | Buddha   |   123456 |
    And I click on Login button
    Then I should see the Homepage of Buddha
    And check the title of the page
    
      Scenario: 
    Login with Incorrect Username and Password

    Given I navigate to login page of EZTest
    When I enter the following for Login
      | username | password |
      | Gaurav   |   123456 |
    And I click on Login button
    Then I shouldnot see the Homepage of Gaurav
    And check the error message
    

