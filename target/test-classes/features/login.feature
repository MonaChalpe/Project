Feature: Login into qa academy

Scenario Outline:negative test scenario
	Given Initilize browser with chrome
    And navigate to "http://www.qaclickacademy.com/" site
    And Click on login link in homepage to land on secure sign in page
    When User enters "<username>" and "<password>" logs in
    Then Verify user sucessfully logged in
    
Examples:
|username|password|
|mona.chalpe@gmail.com|mona5678|
|monachalpe93@yahoo.com|mona9101|
|mona.chalpe56@gmail.com|mona5678|
|monachalpe9375@yahoo.com|mona9101|
