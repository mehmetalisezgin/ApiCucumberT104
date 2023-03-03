Feature:


  Scenario Outline: TC01 : As an admin, I should be able to establish an API connection with the correct E-mail and Password.
    Given Admin should connect to the API server with <id>
    Then  Verify the status code is <statusCode>
    Then  Verify the content type is "<contentType>"
    And   Verify the user , "<first_name>", "<username>", "<email>"
    Examples:
      | id | statusCode | contentType      | first_name | username    | email                 |
      | 1  | 200        | application/json | Super      | 0181        | info@trendlifebuy.com |
      | 19 | 200        | application/json | John Doe   | 54654965626 | johndoe@gmail.com     |
      | 3  | 200        | application/json | Staff      | 0183        | staff@gmail.com       |
      | 4  | 200        | application/json | Customer   | 018444444   | customer@gmail.com    |


