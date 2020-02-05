Feature: my first feature

  Scenario Outline: my scenario
    Given a rest api request with parameters: "<request_params>"
    When i make request to randomuser.me
    Then i receive response with user data
    Examples:
      | request_params       |
      | gender,location,name |
      | gender, name         |
      | name                 |
      | gender               |

#     * - make this work
#    ** - use soft assert to check first and second name
#   *** - find some nice way to store data
  Scenario: test seed generator
    Given a rest api request with seed "asdasdasdasdasd"
    When i make request with specified seed
    Then i recieve response name "some_name"
    And i recieve response name "some_second_name"