@Equity
Feature: Verify that the current stock value is within the 52 week range

  @TestCurrentValueIn52WeekRange
  Scenario Outline: Compare the current value with the 52 week range on the "<page>" page
    Given "<page>" page
    When get the current Stock value from the page
    And get the 52 week range values
    Then verify that the current value is within the 52 week range values

    Examples:
      | page                         |
      | /equities/gamestop-corp      |
      | /equities/apple-computer-inc |
      | /equities/tesla-motors       |
