Feature: Add Poll to page

Scenario: add poll to a new page

    Given Login as admin
    When  I am on View all poll page
    And   I get the poll code from shortcode field
    And   I put shortcode in New page
    And   I Publish the page
    Then  The Poll is published to page

  Scenario: add poll to existing page
    Given Login as admin
    When  I am on View all poll page
    And   I get the poll code from shortcode field
    And   I put shortcode in Existing page
    And   I Publish the page
    Then  The Poll is published to page

  Scenario: verify logged users can see the poll
    Given
    When I Publish poll on the page
    And  The Poll is published to page
    And  I logout the Page
    Then I see poll as unloged user


  Scenario: verify unlogged users can see the poll
    Given
    When I Publish poll on the page
    And  The Poll is published to page
    And  I logout the Page
    Then I see poll as unloged user


  Scenario: verify poll is added with correct settings
    Given
    When I create poll
    And  I Publish poll on the page
    And  I navigate to the page where the poll is published
    Then I check that the poll behaves accordingly to the options set



