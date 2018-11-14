#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: To Test login function

  @tag1
  Scenario: Verify the login functionalities
    Given The user is in guru login page
    When The user enter valid username and password
    When The user clicks the submit button
    Then The user should be manager home

  @tag2
  Scenario: To enter new customer information
    Given The user clicks New customer button
    When The user enters the mandatory fields
    And The user clicks the submit new register button
      | customername | Divya           |
      | gender       | female           |
      | address       | Salem           |
      | city          | Vellore         |
      | state         | Tamil Nadu      |
      | pin           |          632006 |
      | mobileNum     |      9786238237 |
      | email         | dvy13222@gmail.com |
      | password      | sdcbrw            |
    Then The user should be Registered successfully

    @tag3
  Scenario: Verify the customer Id
    Given The user get the customer ID
    And The user click on Edit customer button
    When The user gives the customer ID
    And The user clicks on Submit button
    And The user should be in edit customer page
    Then user validate the details and does the change in the details
    And clicks on submit