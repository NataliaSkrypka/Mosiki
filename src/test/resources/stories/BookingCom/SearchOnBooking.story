Full text search on booking.com

Changelog
|Date           |Author           |Change                              |
|Feb, 19th 2014 |Natalia Skrypka  |story file created                  |

Scenario: 1 Full text search with valid parameters
Given user opens main page
When user performs search for <fullText> on main page
Then mentioned entity is shown in the result

Examples:
|fullText            |
|Lon                 |
|Ellington           |

Scenario: 2 Full text search with invalid parameters
Given user opens main page
When user performs search for <fullText> on main page
Then message <message> is shown on search result

Examples:
|fullText         |message                              |
|@#$ %^&          |Sorry, we don't recognize that name. |

Scenario: 3 Full text search with empty parameters
Given user open main page
When user leave search fields empty
Then message <message> is shown on search result

Examples:
|message                                                    |
|Oops! We need at least part of the name to start searching.|

Scenario: 4 Full text search with not specified dates
Given user opens main page
When user performs search for <fullText> on main page and leave dates not specified
Then error message <message> about invalid dates is shown on search result

Examples:
|fullText |message                                  |
|New York |Please enter dates to check availability.|

Scenario: 1 User signs into account
Given user opens main page
When user inputs anya_test@yahoo.com and hannah_evergreen1 on main page
Then displayed name is anya_test@yahoo.com
When user clicks log out

