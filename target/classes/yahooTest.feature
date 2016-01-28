Feature: To test the Yahoo left sites

Background: 
 	Given I am on the yahoo home page

  Scenario Outline: Check the left sites
    When I click on <Link>
    Then I check that page has <Title>
    And I check page load time
    
    Examples:
  		| Link	| Title	|
    	| nav-mail	| Yahoo - login |
    	| nav-news | Yahoo News - Latest News & Headlines |
    	| nav-sports | Yahoo Sports – Sports News, Scores, Rumors, Fantasy Games, and more |
    	| nav-stock | Yahoo Finance - Business Finance, Stock Market, Quotes, News |
    	| nav-wthr | Yahoo Weather - Weather Forecasts |
    	| nav-autos | Yahoo Autos |
    	| nav-fntsyfb | Fantasy Football |
    	| nav-shpg | Yahoo Shopping - Online Shopping with great products, prices and reviews |
    	| nav-diy | Yahoo Makers |
    	| nav-parenting | Yahoo Parenting |
    	| nav-health | Yahoo Health |
    	| nav-style | Yahoo Style |
    	| nav-beauty | Yahoo Beauty |
    	| nav-politics | Yahoo Politics |
    	| nav-movie | Yahoo Movies |
    	| nav-travel | Yahoo Travel |
    	| nav-tech | Yahoo Tech |
    	| nav-tv | Yahoo TV |
    	| nav-omg | Yahoo Celebrity |
    	| nav-games | Yahoo Games - Play Free Online Games |