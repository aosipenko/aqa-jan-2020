Feature: my first feature

  Scenario Outline: my scenario
    Given Set request parameter "inc" as "<request_params>"
    When i make request to randomuser.me
    Then i receive response with user data with value "<expected_str>"
    Examples:
      | request_params       |expected_str  |
      | gender,location,name |gender        |
      | gender, name         |name          |
      | name                 |name          |
      | gender               |gender        |

#    ** - use soft assert to check first and second name
#   *** - find some nice way to store data
  Scenario: test seed generator
    Given Set request parameter "seed" as "asdasdasdasdasd"
    When i make request to randomuser.me
    Then i receive response with user data with value "Necati"
    And i receive response with user data with value "Abadan"
    And i receive response with user data with value "Filistin Cd"