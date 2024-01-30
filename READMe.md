 Hepsiemlak Test Otomasyon Projesi
---

* Proje Java  programlama dilinde yazılmıştır.
* Proje Maven projesi olarak inşa edilmiştir.
* Selenium WebDriver , JUnit kütüphaneleri kullanılmıştır.

---
* Test senaryoları : src/test/resources/Features ,
* Test adımları    :src/test/java/Step_Definitions 
* Locatorlar       : src/test/java/Pages

package'ları içerisinde oluşturulmuştur.


---
#### Test koşturma yolları
- Testleri IDE ile manuel koşturmak isterseniz;
  - Cukes Runner classı içerisinden;
    - Web testi için
      - 1- configuration.properties dosyası içerisinde  mobile.status'üne false olması gerekli ==> "mobile.status=false"
      - 2- CukesRunner Classı içerisinde ( tags ="" ) değerini tags = "@webTest" tag'ını yazmalısınız
    - Mobile Web testi için 
      - 1- configuration.properties dosyası içerisinde  mobile.status'ün true olması gerekli ==> "mobile.status=true"
      - 2- CukesRunner Classı içerisinde ( tags ="" )   tags = "@mobileTest" 


- Testleri Maven komutu ile terminalden koşturmak isterseniz;
   - Web testi için;
     - mvn clean verify "-DargLine=-Denvironment=web -Dcucumber.filter.tags='@webTest'"
   - Mobile Web testi için;
     - mvn clean verify "-DargLine=-Denvironment=mobile -Dcucumber.filter.tags='@mobileTest'"

bu komutları kopyalayıp yazmanız yeterli olacaktır.

