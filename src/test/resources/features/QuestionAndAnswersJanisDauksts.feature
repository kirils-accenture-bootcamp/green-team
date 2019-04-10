Feature: Writing test scenarios for Question and Answers tab

  @testAddPoll
  Scenario Outline: making poll with basic settings
    Given I am on the Wordpress page
    When I press Add New poll
    And Input the <name> of the poll
    And I choose template
    And I move to Questions and Answers tab
    And Enter <question>
    And Enter <answerA>
    And Enter <answerB>
    And Add a new answer
    And Enter <answerC> #should I delete the answer just to check its functionality right now or in later scenario
    And Press Publish button
    And Edit access configurations
    And Publish poll
    And I am redirected to All poll page
    And I open the poll I have made
    Then I check saved inputs

    Examples:
    |name             | question       |answerA     |answerB                          |answerC                       |
    |Green Team's poll|How is your day?|It is fine  |Thank you, it is really great :) |I do not feel that well today |


