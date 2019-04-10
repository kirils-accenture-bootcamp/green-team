Feature: 28 Add New Poll (Poll Options)
  As a blogger I want to create a poll with additional options, which then can be added to the page
  User can use additional options while creating poll for results.
  "Yop Poll > Add New > Options"


  Background:
    Given I login as administrator
    And I go to Add poll - Poll Options page

  Scenario:
    When I click Poll tab
    And I enter values in fields: