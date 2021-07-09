Feature: As a user I want to have an ability to get historical books collection

  Scenario: Books Collection should contain historical books
    Given User navigates OverDrive library home page
    When User chooses Browse Collection item
    And User clicks HISTORY button on the opened collections page
    Then Page with History title is opened

