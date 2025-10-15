# TEMEL TERİMLER
• **Synchronization**, günlük kullanımda iki şeyin aynı anda yapılması anlamına gelir. Bilgisayar sistemlerinde ise bir olayın diğerinden önce, sonra veya aynı anda gerçekleşmesi gibi olaylar arasındaki ilişkileri ifade eder. Yani geliştiriciler için synchronization, **olayların doğru sırayla gerçeklemesini sağlama işidir**.       
  
  - Serialization: A olayı B'den önce olmalı       
  - Mutual Exclusion: A olayı B ile aynı anda gerçekleşmemeli      

• Bir olayın gerçekleşmesinin sıralamasını yaparken saate bakarak karar veririz ancak bilgisayar sistemlerinde olayların zamanını yeterince hassas ölçemeyebiliriz. Bunun yerine lock mekanizmalarını, semaforları, concurrent veri yapılarını, barrier'lar, message passing gibi teknikleri kullanırız.      
• **Paralel Sistemler**: Birden fazla işlemci aynı anda farklı komutları çalıştırabilir. Bu durumda hangi işlemcideki komutun önce çalıştığını bilmek zordur.     
• **Multithreating**: Tek işlemci birden fazla threadi sırasıyla çalıştırır. İşletim sistemi hangi threadin ne zaman çalışacağına karar verir. Yazılımcı bu sırayı kontrol edemez.   
• **Message Passing**: Bir threadin veya sürecin diğerine bilgi göndermesi içi mesaj-veri paketi iletmesidir. Veriyi doğrudan paylaşmak yerine iletir.  Thread A, "işlem tamamlandı" mesajı gönderir. Thread B, bu mesajı alana kadar bekler ve sonra işleme başlar. Böylece A'nın B'den önce çalıştığı garanti edilir. Senkronizasyon sağlanmış olur.    
• Deterministic bir kod her çalıştığında aynı sonu verir. Non-deterministic bir kod ise, farklı çalıştırmalarda farklı sonuçlar verir. Concurrent programlar da non-deterministic davranışlar görterebilirler.     

• **Serialization problemi**: Threadler senkronize edilmezlerse, birden fazla threadin(multi-thread) çalıştığı programlarda veriye erişim sırasında tutarsızlıklar oluşabilir; mesela okuma işlemi yazma işleminden önce gerçekleşebilir.     
• count+=1 bu ifade tek bir işlem gibi gözükse de makine diline çevrildiğinde iki adıma bölünür; okuma ve yazma. Bu bir threadin iki adımıdır. Bu iki adım arasına bir thread girerse yarış durumu(race condition) oluşur. Böyle bir durum ile karşılaşmamak için mutex(mutual exclusion) kullanılabilirdi ya da atomic veri yapı tipi ile tanımlanabilirdi, synchronized bloklar oluşturulabilirdi. Varsayalım ki 100 thread var ;    

```java
for i in range (100):
temp = count
count = temp + 1
```
Bu durumda en büyük ve en küçük olası değer nedir ?        
Tüm threadler synchronize çalışırsa **en büyük olası değer= 100 thread x 100 artış= 10.000**.   
En küçük değeri incelediğimiz, her artış çakışır yani her iki thread aynı anda count'u okur ve aynı değeri yazar. Bu durumda iki işlem sonucunda 1 geçerli artış olur. Böyle bir senaryoda 10.000 işlem yapmış ama 5000 geçerli artış yapmış oluruz. Ancak en kötü durum bu değil. Her thread sadece bir kere başarılı artış yapabilir, diğer 99 artış başka threadlerle çakışabilir ve etkisiz olabilir bu durumda.  Böylece **en küçük olası değer: 100 thread x 1 geçerli atış= 100**     

## Semaphore    
• Bu kavram Edsger Dijstra tarafından geliştirilmiştir. Semaphore bir seknronizasyon mekanizmasıdır. Temel amacı; multi-thread veya process aynı anda çalışırken kritik bölgelere erişimi kontrol etmek ve veri tutarlılığını sağlamaktır.    
• Java'da semaforlar, java.util.concurrent paketinde yer alan Semaphore sınıfı ile sağlanır.     

```java
import java.util.concurrent.Semaphore;

Semaphore fred = new Semaphore(3); // Başlangıç değeri 3
```

• Teknik olarak bir veri yapısı değildir ancak veri yapıları kullanılarak uygulanır. İki bileşen ile temsil edilir;

- bir counter(integer), paylaşılan kaynakların sayısını tutar. 
- bir queue, bekleyen threadleri sıraya koyar.
  
• Semafor kullanımı problemlerin çözümü için tek yol değildir. Ancak semaphore kullanmak kodun güvenliğini, doğruluğunu, taşınabilirliğini arttırır.      
 
 - Hataları önleyici kısıtlamalar getirir -> güvenilirlik
 - Semapforlarla oluşturulmuş algoritmaların doğru çalıştığını matematiksel olarak göstermek daha kolaydır. -> doğruluk   
 - Donanım seviyesinde veya işletim sistemi çekirdeğinde desteklenebilir. Hızlı ve kaynak dostudurlar. ->taşınabilir    

### Semaphore Durumları
• Semafor oluştururken başlangıç değeri veririr. Sonrasında arttırma +1, azaltma -1 yapabiliriz. Ama değerini okuyamayız, yani semaforun anlık değerini bilemeyiz.       
• Azaltma sonucu semafor değeri negatifse thread bloklanır. Yani bu thread durdurulur ve thread queue'ya beklemek üzere geçer. Başka bir thread semaforu artırana kadar devam edemez.Negatif değer kaç threadin queue'da beklediğini ifade eder. CPU kaynağı tüketmezler sadece beklerler. Queue'ya geçer dedik bekleyen ancak queue veri yapısı gibi FIFO prensibiyle çalışmaz. Ancak **new Semaphore(1,true)** şeklinde oluşturursak bekleyen threadler FIFO sırasına göre uyanır.     

```java
fred.acquire(); // Semaforu azaltır, gerekirse thread'i bloklar
```

 - acquire() metodu InterruptException fırlatır. Bu yüzden try-catch bloğu ile korunur.
 -  Aynı anda iki thread gelirse , aynı anda iki thread semophoru azaltamaz; **Semaphore işlemleri atomictir. Semaforun acquire() işlemi işletim sistemi tarafından kilitlenerek yapılır.**       
    
• Bir thread semaforu arttırırsa, queue'da bekleyen başka thread varsa bunlardan bir tanesi uyanır(unblock) ancak hangi threadin uyanacağı belli değildir.   

```java
fred.release(); // Semaforu arttırır, gerekirse bekleyen thread'i uyandırır
```

• Diyelim ki semafor değerimiz 1. İki thread aynı anda geldi.İlk thread semaforu 1 azaltır. Semaphore 0 oldu. Bloklanmaz ve bu thread çalışır. İkinci thread semaphoru 1 azaltır. Semaphore -1 oldu. Bu durumda thread bloklanır, beklemeye geçer. 
• Bir thread semaforu azaltmadan önce bloklanıp bloklanmayacağını bilemeyiz. Özel durumlarda önceden tahmin edilebilir.        
• Semaforu arttırdığımızda, bekleyen bir thread olup olmadığını bilemeyiz -> bazen kimse uyanmaz.    
