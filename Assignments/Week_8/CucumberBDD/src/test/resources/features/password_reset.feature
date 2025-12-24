@password @security
Feature: Password Reset
  As a registered user
  I want to reset my password
  So that I can regain access to my account if I forget my password

  @smoke
  Scenario: Request password reset with valid email
    Given user "john@example.com" is logged in
    When user requests a password reset
    Then a reset link should be sent to "john@example.com"


  Scenario: Request password reset with invalid email format
    Given user "invalidemail@"
    When user requests a password reset
    Then an error message is displayed


  Scenario: Request password reset with unregistered email
    # Note: For security, message should not reveal if email exists
    Given user "unregistered@example.com"
    When user requests a password reset
    Then an error message is displayed

  Scenario: Reset link expires after 24 hours
    # Use time-based Given clause
  Given reset link has existed longer than 24 hours
  When user clicks on link
  Then error message is displayed

  Scenario: Successfully reset password
    # Include setting new password and verification
  Given user clicks on reset link
  When user inputs new password
  Then password is updated

  Scenario: Old password fails after reset
    Given the user "john@example.com" has reset their password to "NewPass123!"
    When the user attempts to login with email "john@example.com" and password "OldPass456!"
    Then the login should fail
    And an error message should indicate "Invalid credentials"

  Scenario: Password must meet complexity requirements
    # Include scenarios for passwords that don't meet requirements
    Given password "short" is input
    When user clicks create password
    Then error message should display "Password must be at least 8 characters"