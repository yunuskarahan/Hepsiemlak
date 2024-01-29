Feature: Hepsiemlak task

  Background:
    Given Navigate to Home Page


  @webTest @case2
  Scenario: Case 2 test
    When User can click Kiralık button
    Then Verify the user "https://www.hepsiemlak.com/kiralik"
    When user can select il Ankara
    And user can select ilçe Çankaya
    And user can select Konut
    And user can select iki artı bir
    And user can select evet in site içerisinde
    And user can click search button
    Then user should see "Çankaya Site İçerisinde 2+1 Kiralık Ev"
    And user can click page 3
    Then user should see page "page=3"
    Then user should see show phone number
    And user can clik show phone number
    Then user should see phone number and verify validate phone number


  @mobileTest2 @case2
  Scenario: Case 2 mobile Test
    When user can click kiralık button
    Then Verify the user "https://www.hepsiemlak.com/kiralik"
    When user can click filtrele button
    And user can select mobile il  Ankara
    And user can click Tamam Button
    And user can click ilçe Çankaya
    And user can click Tamam Button
    And user can click Konut
    And user can click oda sayısı iki artı bir
    And user can click Tamam Button
    And user can click site içerisinde yes
    And user can click Tamam Button
    And user click search butto
    Then user should see "Çankaya Site İçerisinde 2+1 Kiralık Ev" in the mobile
    And user can click page 3
    Then user should see page "page=3"
    Then user should see show phone number in the mobile
    And user can clik show phone number in the mobile
    Then user should see phone number and verify validate phone number in the mobile








