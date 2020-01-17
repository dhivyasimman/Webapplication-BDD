Feature: Input trade details Function
Scenario: Buy trades for Order type Market
      Given User selects TRADE STOCKS option in MAKE A TRADE dropdown 
      When User selects the Region, Location and keys in necessary values
      And Clicks the Preview Button
      Then Now User Clicks the Confirm Button
      And Trade is successfully placed