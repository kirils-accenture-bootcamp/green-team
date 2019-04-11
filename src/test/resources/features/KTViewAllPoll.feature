Feature: View All Poll
  As a blogger I want to see all existing polls, which then can be added to the page

  Scenario Outline: Sorting columns
    Given I populate polls
      | Title2; Draft; 0; April 11, 2019 3:36 pm; Never |
      | Title, Published, 2, April 11, 2017 0:00 pm, January 1, 2020 0:00 am |
    And I click All Polls link under Yop Poll section
    And I remember the polls
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
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I enter <search> in the search field
    And I press ENTER key in the search field
    Then I see polls are filtered by name <search>
    When I enter <search> in the search field
    And I click Search Polls button
    Then I see polls are filtered by name <search>
    Examples:
      | search |
      |        |
      | Title  |

  Scenario Outline: Filtering
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I click <filter_name> filter link
    Then I see polls are filtered by <filter_option>
    Examples:
      | filter_name |
      | Published   |
      | Draft       |
      | Ending Soon |
      | Ended       |

  Scenario Outline: Filter counters
    When I populate polls with statuses: <statuses_list>
    And I click All Polls link under Yop Poll section
    Then I see numbers on corresponding filters
      | All         | <all>       |
      | Published   | <published> |
      | Draft       | <draft>     |
      | Ending Soon | <ending>    |
      | Ended       | <ended>     |
    Examples:
      | all | published | draft | ending | ended | statuses_list    |
      | 2   | 1         | 1     | 0      | 0     | published, draft |

  Scenario: Filtering All
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I click Published filter link
    And I click All filter link
    Then I see polls are filtered by All

    # index starts at 0
  Scenario Outline: Cloning a individual poll
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I click Clone on poll at <index>
    Then I see poll that has been at <index> is cloned correctly
    When I click Clone on poll at 0
    Then I see poll that has been at 0 is cloned correctly
    Examples:
      | index |
      | 0     |
      | 1     |
      | 2     |

    # index starts at 0
  Scenario Outline: Cloning polls using bulk action
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I select polls at <indexes>
    And I select Clone option in bulk action selection
    And I click Apply button
    Then I see polls that have been at <indexes> are cloned correctly
    Examples:
      | indexes |
      |         |
      | 0       |
      | 0,1,2   |
      | 1,2     |

    # index starts at 0
  Scenario Outline: Deleting an individual poll
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I click Trash on poll at <index>
    Then I see poll that has been at <index> is deleted
    Examples:
      | index |
      | 0     |
      | 1     |
      | 2     |

    # index starts at 0
  Scenario Outline: Deleting polls using bulk action
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I select polls at <indexes>
    And I select Move to Trash option in bulk action selection
    And I click Apply button
    Then I see polls that have been at <indexes> are deleted
    Examples:
      | indexes |
      |         |
      | 0       |
      | 0,1,2   |
      | 1,2     |

    # index starts at 0
  Scenario Outline: Resetting votes
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I select polls at <indexes>
    And I select Reset Votes option in bulk action selection
    And I click Apply button
    Then I see polls that have been at <indexes> have zero votes
    Examples:
      | indexes |
      |         |
      | 0       |
      | 0,1,2   |
      | 1,2     |

  Scenario: Add New button
    When I click Add New button
    Then I open Create Poll page

    # index starts at 0
  Scenario Outline: Selecting all
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I select polls at <indexes>
    And I click select all checkbox
    Then I see all polls are selected
    When I deselect polls at <indexes>
    And I click select all checkbox
    Then I see all polls are selected
    When I click select all checkbox
    Then I see all polls are unselected
    Examples:
      | indexes |
      |         |
      | 0       |
      | 0,1,2   |
      | 1,2     |

  Scenario Outline: Items Per Page
    Given I populate polls
      | Title, Status, Votes, Start Date, End Date |
    And I click All Polls link under Yop Poll section
    And I remember the polls
    When I enter <number> in Items Per Page field
    And I click Set button
    Then I see <polls_number> polls
    And I see <pages_number> pages
    Examples:
      | number | polls_number | pages_number |

  Scenario: Select "Bulk Actions" option and click Apply

  # TODO edit link works
  # TODO page buttons