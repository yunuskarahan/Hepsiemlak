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
      - <img width="801" alt="config mobile false" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/822764cc-b6fd-4df6-b4db-c56cdf37c770">
      - 2- CukesRunner Classı içerisinde ( tags ="" ) değerini tags = "@webTest" tag'ını yazmalısınız
      - <img width="801" alt="CukesRunner Web Test" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/1d282480-0bd5-4093-b568-75487eea36c5">
    - Mobile Web testi için 
      - 1- configuration.properties dosyası içerisinde  mobile.status'ün true olması gerekli ==> "mobile.status=true"
      - <img width="890" alt="mobilestatus true" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/ceea5728-b067-410e-9bf8-6d2872b2c905">
      - 2- CukesRunner Classı içerisinde ( tags ="" )   tags = "@mobileTest"
      - <img width="892" alt="CukesRunner mobileWeb Test" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/b423ced0-7909-4c05-9c91-dbb963f88dd9">


- Testleri Maven komutu ile terminalden koşturmak isterseniz;
   - Web testi için;
     - mvn clean verify "-DargLine=-Denvironment=web -Dcucumber.filter.tags='@webTest'"
     - <img width="920" alt="MavenWEbTestCommand" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/7063ec6a-cd90-4484-bd62-3f6ec99d2826">
   - Mobile Web testi için;
     - mvn clean verify "-DargLine=-Denvironment=mobile -Dcucumber.filter.tags='@mobileTest'"
     - <img width="950" alt="MavenMobileWebTestCommand" src="https://github.com/yunuskarahan/Hepsiemlak/assets/104788161/e8896906-6a00-4e69-9ede-7be6c4954c35">

bu komutları kopyalayıp yazmanız yeterli olacaktır.

