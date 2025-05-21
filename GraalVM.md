• **JDK(Java Development Kit):** Java programlama diliyle yazılım geliştirmek için kullanılan bir araçtır. Java uygulamalarını yazmak, derlemek ve çalıştırmak için gerekli bileşenleri içerir;
- **Java Derleyici(javac):** Java kodlarını derleryerek byte kodlara çevirir.
- **JRE(Java Runtime Environment):** Java uygulamalarını çalıştırmak için gerekli olan kütüphaneleri ve sanal makineyi içerir.
- **JVM(Java Virtual Machine):** Java kodlarını çalıştıran sanal makinediğr.
- **jdb(Hata Ayıklama Aracı):** Java programlarındaki hataları bulmak ve düzeltmek için kullanılır.
- **Java API Kütüphanesi:** Java'nın temel fonksiyonlarını sağlayan hazır bileşenlerdir.  

## GraalVM
• Hem java hem de başka dillerde yazılmış kodları hızlı ve verimli çalıştırmak için geliştirilmiş derleme platformudur. Yüksek performanslı JDK'dır. Farklı programlama dillerinde yazılmış kodları tek bir ortamda çalıştırabilir. Düşün ki bir python bir de java ile yazılmış programın var, birlikte çalıştırman gerekiyor ama sorun şu ki java JVM ile ile python interpreter ile çalışır. Bu noktada graalVM devreye giriyor. Farklı dilde yazılmış kodları tek bir çatı altında toplayarak çalıştırır.
• Graal derleyicisini içerir. Graal derleyicisi kodu hızlı ve verimli çalışacak şekilde dönüştürür, daha az kaynak tüketmesini sağlar.  
• **Native Image**: Normalde Java programları JVM üzerinde çalışır; JVM açılır, sınıflar yüklenir...  Bu nedenle de program başlatıldığında geç açılır. GraalVM, Java programını doğrudan çalışan bir dosyaya dönüştürebilir. Bu dosya JVM'e ihtiyaç duymaz. Açılış süresi çok kısadır. Bellek tüketimi çok düşüktür. Micro servisler için de çok avantajlıdır.  "java -jar" yerine ./program gibi çalıştırabiliriz.  
