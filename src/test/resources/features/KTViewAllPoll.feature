Feature: View All Poll
  As a blogger I want to see all existing polls, which then can be added to the page

  Background:
    Given I login as administrator
    And I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls

  Scenario Outline: Sorting columns
    When I click <column_name> column
    Then I see polls are sorted by <column_name> in ascending order
    When I click <column_name> column
    Then I see polls are sorted by <column_name> in descending order
    Examples:
      | column_name |
      | Title       |
      | Status      |
      | Votes       |
      | Author      |
      | Start Date  |
      | End Date    |

  Scenario Outline: Searching
    When I enter <search> in the search field
    And I press ENTER key
    Then I see polls are filtered by name <search>
    Examples:
      | search |
      |        |

  Scenario Outline: Filtering
    When I click <filter_option> filter option
    Then I see polls are filtered by <filter_option>
    Examples:
      | filter_option |
      | Published     |
      | Draft         |
      | Ending Soon   |
      | Ended         |

  Scenario: Filtering All
    When I click Published filter option
    And I click All filter option
    Then I see polls are filtered by All

    # index starts at 0
  Scenario Outline: Cloning
    When I click Clone on poll at <index>
    Then I see poll that has been at <index> is cloned correctly
    When I click Clone on poll at 0
    Then I see poll that has been at 0 is cloned correctly
    Examples:
      | index |
      | 0     |

  Scenario Outline: Deleting an individual poll
    When I click Trash
