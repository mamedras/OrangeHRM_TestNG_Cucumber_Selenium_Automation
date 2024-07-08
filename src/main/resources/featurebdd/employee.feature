Feature: modifying employee`s info
   @SmokeTest
   Scenario Outline: modifying employee`s account
    Given WE ARE ON THE LOGIN DASHBOARD PAGE
    And HEADING TO EMPLOYEE`S INFO
    When MODIFYING MAIN EMPLOYEE INFORMATION SUCH AS NAME DRIVING LICENSE BIRTHDATE AND ETC
    And UPLOAD EMPLOYEE FILE
    Then UPDATE PROFILE PICTURE SAVE AND APPLY THE MODIFICATION
    Examples:
       | First Name | Last Name | Employee ID | Date of Birth | License File | Profile Picture |
       | Moh        | Nassi     | AK-9E344    | 9/09/2001     | test.png     | moh.jpeg        |