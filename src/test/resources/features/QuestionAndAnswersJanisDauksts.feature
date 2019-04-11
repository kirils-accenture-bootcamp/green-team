Feature: Writing test scenarios for Question and Answers tab

  @testAddPoll
  Scenario Outline: making poll with basic settings

    Given Web page is opened
    When I log in as gt
    And Open All poll page
    And I press Add New poll
    And Input the <name> of the poll
    And I choose template
         #moving to right and then back to left template (checking arrows functionality)
    And I move to Questions and Answers tab
    And I Enter question <question>
    And I Enter answerA <answerA>
    And I Enter answerB <answerB>
    And Add a new answer
    And I Enter answerC <answerC>
    And Edit access configurations
    And Publish poll
    # redirected to all poll page + wait.until
    And I open the poll I have made
    Then I check saved inputs

    Examples:
    |name             | question       |answerA     |answerB                          |answerC                       |
    |Green Team's poll|How is your day?|It is fine  |Thank you, it is really great :) |I do not feel that well today |


