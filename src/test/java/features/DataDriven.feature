
Feature: POST API with multiple data set Data Driven concept

Scenario Outline: Verify if POST API is working successfully 
Given Add POST API with unique name "<name>" "<salary>" "<age>"
When User calls POST API
Then The API call got success with status code

Examples: 

     | name | salary | age |
     |Avnish |50000  |28|
     |AKASH |60000  |30|