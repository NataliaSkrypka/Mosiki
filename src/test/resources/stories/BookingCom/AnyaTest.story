Signing Up on booking.com

Changelog
|Date           |Author            |Change                             |
|May, 5th 2015  |Ganna Barsuk      |story file created                |

Scenario: 1 User signs into account
Given user opens main page
When user inputs anya_test@yahoo.com and hannah_evergreen1 on main page
Then displayed name is anya_test@yahoo.com
When user clicks log out


Scenario: 2 User tries to sign in with invalid credentials
Given user logs in with invalid creds on main page
When user inputs <mail> and <password> on main page
Then <error message> displayed

Examples:
|mail                      |password          |error message                                                                   |
|""abc##                   |hannah_evergreen1 | You entered an email address/password combination that doesn't match. I forgot |
|                          |                  | Please enter a valid email address.                                            |





