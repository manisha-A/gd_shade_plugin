Feature:As a test player, I should be able to play games free

  Scenario:As a registered test player, I should be able to play games free
    Given I am on GameDuell website
    When I want to play for free
    And I log in as a registered user with "gd2@trashmail.com" and "123456"
    Then I should be on "Welcome" page
    And I should see emailValidation link
    When I navigate to "My GameDuell"
    Then I should be on "My GameDuell" page
    And account balance should be same in overview and account

  Scenario Outline:As a new test player, I should be able to play games free
    Given I am on GameDuell website
    When I want to play for free
    And I sign up as a registered user with "<name>","<email>" and "<password>"
    Then I should be on "Welcome" page
    And I should see emailValidation link
    When I navigate to "My GameDuell"
    Then I should be on "My GameDuell" page
    And account balance should be same in overview and account
    When I log out
    And I login again with "<email>" and "<password>"
    Then I should see emailValidation link

  Examples:
    | name        | email             | password |
    | TestFeature | gd@trashmail.com | 123456   |