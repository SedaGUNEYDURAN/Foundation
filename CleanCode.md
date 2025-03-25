# Clean Code 
• Temiz kod, orijinal yazarından başka developer tarafından okunabilir ve geliştirilebilir. Birim ve kabul testlerine sahiptir. Anlamlı isimleri vardır. Bir şeyi yapmanın pek çok yolundan ziyade tek bir yolunu sağlar. Açık-seçik olarak tanımlanmış minimal bağımlılıklara sahiptir ve temiz ve minimal bir API sunar. Kod okunabilir olmalıdır, çünkü sadece programlama diline bağlı kalınırsa, her türlü gerekli bilgi kodda açık bir şekilde ifade edilemez.  
• Kod temiz değilse kötüdür(dirt code) ve code smell'e yani kötü kokuya sahiptir. Karmaşıktır, bakımı zordur, zor anlaşılır, değiştirilmesi maliyetlidir, karmaşıklığı çığ gibi büyür.  
• Temiz kodun 4 temel özelliği vardır;  
• **Basitlik**; anlaşılır, kısa koddur. Kodun basitleştirilmesine, iyileştirilmesine refactoring denir. Bir metotta yapılacak işi bir cümlede yapma. Basit bir kod aynı zamanda odaklı bir koddur yani bir yerde sadece bier şeyi yapmayı hedefler. Mimariye uygun geliştirilir. Anlaşılır isimler kullanılır. Kısa anlamsız isimlendirmelerdense uzun, okunması zaman alan ama anlamlı isimlendirmeler tercih edilmelidir. Aslolan anlaşılır olmaktır, kısa olmak adına anlaşılır olmaktan fedakarlık edemeyiz.İsimlendirmeler soyut ve kapsayıcı olmalıdır. Tutarlıdır. 
  
  - Gerektiği kadar anlaşılmaya yardım edilecek kadar dokümante edilmiştir. Eğer bir kodun anlaşılması için dokümantasyona ihtiyaç duyuluyorsa bunun çözümü öncelikle dokümantasyon değildir. Bir kod dokümante edilerek clean code haline gelmez. Öncelikle refaktöring yapılmalıdır; sınıfı bölüp parçalamak, metot sayısını azaltmak bazen çözüm olabilir. Kod içi dokümantasyonu, açık olanı, görüneni değil iyi isimlendirmeye rağmen görünmeyeni , açık olmayını açıklamalıdır. 
  - Kod dökümantasyonun iki türünden bahsedilebilir; kod içi dokümantasyon ve API dokümantasyonu. Kod içi dokümantasyonu ihtiyaca bağlı olarak //, /* */ şeklinde yapılır. API dokümantasyonu ise kodun arayüzünün dokümantasyonudur.
    
• **Odaklılık**; tekrarsız, tek hedefli. Odaklılık basit olmaya hizmet eder ama kedni başına önemlidir.   Odaklı kod, framework, bileşeni arayüz, paket, sınıf, metot, değişkeni her ne olursa olsun sadece bir şeyi halletmelidir.
• **Tamlık**; olması gerekeni yapan, olabilecek olana karşı önlemini alan, olmaması gerekeni önleyen koddur.     
• **Doğruluk**; kendi başına doğrulanmış ve çevresiyle birlikte entegre edilmiş koddur. Bir kodun kendi başına doğruluğu ancak unit test ile sınanabilir. Bir kodun çevresindeki diğer kod parçalarıyla birlikte doğru çalıştığı ise entegrasyon testleriyle anlaşılır. Bu testler TDD yaklaşımı ile yapılırsa doğruluk ve tamlık konusunda daha iyi seviyelere gelinebilir.    
İsimlendirme yapılırken genelde 

  - **Camel Case**: Kelimeleri birleştirirken her bir kelimenin ilk harfinin büyük diğer harflerin küçük olduğu yazım biçimidir. (Lower Camel Case: myVariableName; Upper Camel Case: MyVariableName)
  - **Sneak Case**: Kelimeler arasına alt çizgi ekleyerek ve tüm harfleri küçük tutarak yazılır. (my_variable_name)
  - **Kabab Case**: Kelimeleri ayırmak için - kullanılır ve tüm karakterler küçüktür.Genellikle web geliştirme ve URL yapılarında kullanılır.(kabab-case-example) 
  
