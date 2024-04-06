@TopNavBar
Feature: Verify Top Navigation bar

  Scenario: Top Navigation bar Editions button is functional
    Given "/" page
    When user hovers over Edition button on the Top Navigation bar
    Then the Edition popup is displayed
    And the Edition popup contains the following values:
      | English (UK)           |
      | Русский                |
      | English (India)        |
      | Türkçe                 |
      | English (Canada)       |
      | العربية                |
      | English (Australia)    |
      | Ελληνικά               |
      | English (South Africa) |
      | Svenska                |
      | English (Philippines)  |
      | Suomi                  |
      | English (Nigeria)      |
      | עברית                  |
      | Deutsch                |
      | 日本語                  |
      | Español (España)       |
      | 한국어                   |
      | Español (México)       |
      | 简体中文                 |
      | Français               |
      | 繁體中文                 |
      | Italiano               |
      | Bahasa Indonesia       |
      | Nederlands             |
      | Bahasa Melayu          |
      | Português (Portugal)   |
      | ไทย                    |
      | Polski                 |
      | Tiếng Việt             |
      | Português (Brasil)     |
      | हिंदी                     |
