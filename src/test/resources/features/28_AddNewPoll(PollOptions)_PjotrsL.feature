Feature: 28 Add New Poll (Poll Options)
  As a blogger I want to create a poll with additional options, which then can be added to the page
  User can use additional options while creating poll for results.
  "Yop Poll > Add New > Options"


  Background:
    Given I login as administrator
    And I go to Add poll - Poll Options page

  Scenario Outline: Fill form: Options > Poll
    When I click Poll tab in Poll Options
    And I enter values in fields for Vote Button section:
      | Vote Button Label   | new label name |
      | Show [Results] Link | Yes            |
      | Show Total Votes    | Yes            |
      | Show Total Answers  | Yes            |
    And I enter values in fields for Preferences section:
      | Start Date                     | Custom Date               |
      | End Date                       | Custom Date               |
      | Redirect after vote option     | Yes                       |
      | Redirect after vote Url        | http://some.url           |
      | Reset Poll Stats automatically | Yes                       |
      | Reset every                    | 5                         |
      | Hours/Days select              | Days                      |
      | Auto Generate Poll Page        | Yes                       |
      | Use Captcha                    | Yes, use built in Captcha |
    Then I select Start Date from calendar
    Then I enter values in fields for Notifications section:
      | Send Email notifications | Yes          |
      | From Name                | <fromName>   |
      | From Email               | <fromEmail>  |
      | Recipients               | <recipients> |
      | Subject                  | <subject>    |
      | Message                  | <message>    |
    Then I enter values in fields for Compliance section:
      | Enable GDPR               | Yes                                                                         |
      | Solution                  | Ask for consent ( Ip Addresses will be stored and cookies will be enabled ) |
      | Text for consent checkbox | Some text here                                                              |

    Examples:
      | fromName  | fromEmail   | recipients                          | subject      | message           |
      | Some Name | some@e.mail | another@e.mail, more.another@e.mail | Subject name | Some message here |
