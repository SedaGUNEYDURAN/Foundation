# TEMEL TERİMLER
• Synchronization, günlük kullanımda iki şeyin aynı anda yapılması anlamına gelir. Bilgisayar sistemlerinde ise bir olayın diğerinden önce, sonra veya aynı anda gerçekleşmesi gibi olaylar arasındaki ilişkileri ifade eder. Yani geliştiriciler için synchronization, olayların doğru sırayla gerçeklemesini sağlama işidir.       
  
  - Serialization: A olayı B'den önce olmalı       
  - Mutual Exclusion: A olayı B ile aynı anda gerçekleşmemeli      

• Bir olayın gerçekleşmesinin sıralamasını yaparken saate bakarak karar veririz ancak bilgisayar sistemlerinde olayların zamanını yeterince hassas ölçemeyebiliriz. Bunun yerine lock mekanizmalarını, semaforları, concurrent veri yapılarını, barrier'lar, message passing gibi teknileri kullanırız.      
• **Paralel Sistemler**: Birden fazla işlemci aynı anda farklı komutları çalıştırabilir. Bu durumda hangi işlemcideki komutun önce çalıştığını bilmek zordur.     
• **Multithreating**: Tek işlemci birden fazla threadi sırasıyla çalıştırır. İşletim sistemi hangi threadin ne zaman çalışacağına karar verir. Yazılımcı bu sırayı kontrol edemez.   
• **Message Passing**: Bir threadin veya sürecin diğerine bilgi göndermesi içi mesaj-veri paketi iletmesidir. Veriyi doğrudan paylaşmak yerine iletir.  Thread A, "işlem tamamlandı" mesajı gönderir. Thread B, bu mesajı alana kadar bekler ve sonra işleme başlar. Böylece A'nın B'den önce çalıştığı garanti edilir. Senkronizasyon sağlanmış olur.    
• Deterministic bir kod her çalıştığında aynı sonu verirç Non-deterministic ise aynı kod, farklı çalıştırmalarda farklı sonuçlar verir. Concurrent programlarda non-deterministic davranışlar görterebilirler.     
