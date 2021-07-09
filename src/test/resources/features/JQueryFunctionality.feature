Feature: JQuery main functions

  Background:
    Given  User opens JQuery site

  Scenario Outline: Checking JQuery main functions
    When User searches for '<function>'
    And Opens code source
    Then  Page contains proper '<description>'

    Examples:
      | function  | description                                    |
      | Draggable | Allow elements to be moved using the mouse.    |
      | Droppable | Create targets for draggable elements.         |
      | Resizable | Change the size of an element using the mouse. |
