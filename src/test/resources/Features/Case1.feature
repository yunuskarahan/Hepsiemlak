Feature: Hepsiemlak Case 1 Test

  Background:
    Given Navigate to Home Page
    Then user should see hepsiemlak logo

  @webTest
  Scenario: Case 1 web test
    When User can click Satılık button
    Then Verify the user "https://www.hepsiemlak.com/satilik"
    When user can select il "İzmir"
    And user can select ilçe  "Bornova"
    And user can select İşyeri
    And user can write low price "1000000"
    And user can write high price "20000000"
    And user can select bina yaşı "sıfır bina"
    And user can select "1-5" and "6-10"
    And user can click search button
    Then the user should see that the search results are accurate
      | Sıfır Bina                   |
      | 1-5                          |
      | 6-10                         |
      | 1.000.000 TL - 20.000.000 TL |
      | İzmir                        |
      | Bornova                      |
      | İşyeri                       |


  @mobileTest
  Scenario: Case 1 mobile test
    When User can click Satılık
    Then Verify the user "https://www.hepsiemlak.com/satilik"
    And user can click filtrele button
    When user can select il İzmir
    And user can click Tamam Button
    And user can write "Bornova"
    And user can click ilçe Bornova
    And user can click Tamam Button
    And user can click İşyeri
    And user can write low price
    And user can write high price
    And user can select bina yaşı
    And user can click Tamam Button
    And user can select  kat sayısı
    And user can click Tamam Button
    And user can click search button
    Then user should see result "Bornova Satılık İşyeri"
    When user can click filtrele button
    Then the user should see that the search results are accurate
      | 6-10          |
      | 1-5           |
      | Sıfır Bina    |
      | 20.000.000 TL |
      | 1.000.000 TL  |
      | Satılık       |



