Feature: selenium test

  Scenario: load google
    Given Load page google.com
    When i search for "twitter"
    Then is see "Twitter" in search results