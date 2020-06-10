Feature: Validating get APIs

Scenario: Verify if GET API is working successfully 
Given Add get API
When User calls Get API
Then The API call got success with status code 200
