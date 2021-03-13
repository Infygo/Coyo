Feature: Calculate factorial of an integer 


Scenario Outline: E2E process of calculating the factorial of an integer 
Given Initialise driver and navigate to factorial home page
Given Input an integer <number> in the input box 
When  User clicks Calculate button 
Then  Factorial of <number> is calculated 
And   Close the browser 

Examples:
|number   |        
|0        |
|1        |
|169      |
|170      |
|10       |
|50       |
|100      |




	

