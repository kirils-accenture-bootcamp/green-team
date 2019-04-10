Feature: View All Poll
  As a blogger I want to see all existing polls, which then can be added to the page

  Background:
    Given I click All Polls link under Poll section

  Scenario Outline: Sorting columns
    When I click <column_name> column
    Then I see polls are sorted by <column_name> in ascending order
    When I click <column_name> column
    Then I see polls are sorted by <column_name> in descending order
    Examples:
      | column_name |
      | poll name   |
      | total votes |
      | start date  |
      | end date    |
  @should_fail
    Examples:
      | column_name |
      | author      |

    Scenario: Searching
