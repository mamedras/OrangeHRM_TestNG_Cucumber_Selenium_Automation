Feature:modifying employee`s contact
  @SmokeTest
  Scenario Outline: modifying employee`s account
    Given LOGIN PAGE
    And HEADING TO EMPLOYEE`S CONTACTS
    When MODIFYING THE MAIN INFORMATION LIKE POSTAL CODE AND CITY AND ETC..
    Then UPLOAD ATTACHEMENT AND SAVE THE INFO
    Examples:
      | S1               | S2            | city    | state     | zip   | country | home        | mobile      | work        | email               | other |
      | choiab al dokali | al mowahadine | ouedzem | khouribga | 25000 | morocco | 08234567438 | 03244566449 | 01234537438 | micheal@hotmail.com |  IBMTEAM@gmail.com     |