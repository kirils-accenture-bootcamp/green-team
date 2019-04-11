Feature: Add New poll

Scenario Outline: create new poll
  Given Login as admin
  When  i am on add poll page
  And   i enter the poll"<name>"
  And   i choose a template
  And   i enter poll question "<question>"
  And   i choose poll options

  Examples:
    | name           | question           |
    | Svetlana Poll  | Do you like cats ? |



