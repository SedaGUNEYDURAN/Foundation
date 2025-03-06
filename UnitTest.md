# Unit Test
• Yazılım geliştirme sürecinde yazdığımız kodun doğru çalışıp çalışmadığını kontrol etmek için yazılan testlere unit test denir. Test edilen birim genellikle bir metotdur.    
• Test classı oluştururuz, genellikle test edilen sınıfın adı ile aynı ada sahip olur. Controller.java -> ControllerTest.java   
• Her test belirli bir metotu test eder ve @Test anotasyonu ile işaretlenir. Eğer işaretlenmez JUnit gibi test frameworkler metotları tanımazve bu metotlar test olarak çalıştılmaz.    
• Test metotlarında, sonuçların beklenen değerlerle aynı olup olmadığını konrol etmek için **assert** kullanılır. JUnit'te yaygın olarak kullanılan assert ifadesi **assertEquals**'dir.   
