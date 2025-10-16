# TEMEL TERİMLER
• **Synchronization**, günlük kullanımda iki şeyin aynı anda yapılması anlamına gelir. Bilgisayar sistemlerinde ise bir olayın diğerinden önce, sonra veya aynı anda gerçekleşmesi gibi olaylar arasındaki ilişkileri ifade eder. Yani geliştiriciler için synchronization, **olayların doğru sırayla gerçeklemesini sağlama işidir**.       
  
  - Serialization: A olayı B'den önce olmalı       
  - Mutual Exclusion: A olayı B ile aynı anda gerçekleşmemeli      

• Bir olayın gerçekleşmesinin sıralamasını yaparken saate bakarak karar veririz ancak bilgisayar sistemlerinde olayların zamanını yeterince hassas ölçemeyebiliriz. Bunun yerine lock mekanizmalarını, semaforları, concurrent veri yapılarını, barrier'lar, message passing gibi teknikleri kullanırız.      
• **Paralel Sistemler**: Birden fazla işlem biriminin (işlemci, çekirdek, bilgisayar vs.) aynı anda çalışarak bir görevi birlikte yerine getirdiği bilgisayar sistemidir. Bu durumda hangi işlemcideki komutun önce çalıştığını bilmek zordur. Büyük bir görev, daha küçük parçalara ayrılarak farklı işlemcilere dağıtılır. Görevler aynı anda yürütülür. Bu da işlem süresini kısaltır. İşlem birimleri arasında veri alışverişi ve zamanlama koordinasyonu gerekir. Sisteme daha fazla işlemci ekleyerek sistem kapasitesi arttırılabilir yani ölçeklenebilirdir.         
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

• Multi-threaded programlamada threadlerin birbiri ile uyumlu ve güvenli bir şekilde çalışmasını sağlamak içinkullanım senkronizasyon design patterleri vardır. Bunlar;

  - Mutex(Mutual Exclusion)    
  - Semaphore   
  - Barrier   
  - Reusable Barrier   
  - Rendezvous   
  - Readers - Writers   
  - Producer - Consumer (Buffer)   
  - Dining Philophers   
  - Thread Pool   
  - Condition Variables   



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

```java
import java.util.concurrent.Semaphore;

public class SignalingExample {
    // Başlangıç değeri 0 olan semaphore
    static Semaphore a1Done = new Semaphore(0);
    static String line;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            // statement a1: dosyadan satır okuma (simülasyon)
            line = "Merhaba dünya!";
            System.out.println("Thread A: Satır okundu.");
            
            // signal: a1Done semaphore'u artırılır
            a1Done.release();
        });

        Thread threadB = new Thread(() -> {
            try {
                // wait: a1Done semaphore'u 0 ise bekler
                a1Done.acquire();
                
                // statement b1: satırı ekrana yazdırma
                System.out.println("Thread B: Satır yazdırılıyor → " + line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadB.start(); // Önce B başlasa bile bekleyecek
        threadA.start(); // A sinyal gönderince B devam edecek
    }
}
```

Yukarıdaki örneği inceleyediğimizde görüyoruz ki Thread A'nın işi bitmeden B başlayamaz ve kodun sıralaması garanti altına alınır. Semaphore başlangıç değeri sıfır yani B threadi önce çalışsa bile acquire() threadi bloklar ve beklemeye geçer.Thread B artık  a1Done.acquire(); satırında bekliyor. Thread A çalışır işini yapar, bitirir ve kaynağı serbest bırakıp semaphore değerini bir arttırdığında B başlayabilir.    


## Rendezvous
• İki threadin belirli bir noktada buluşmasını ve her ikisinin de o noktaya ulaşmadan ilerlememelerini garanti etmek isteriz. Bu buluştukları noktaya rendezvous(buluşma noktası)  denir.  Böyle bir durum için iki tane semafor kullanmamız gerekebilir. Diyelim ki  elimizde iki thread var; ThreadA ve TheadB. ThreadA; statementA1 ve statementA2'den oluşuyor. ThreadB; statementB1 statementB2'den oluşuyor. Şu iki koşulu sağlamak istiyoruz ;

- A1 -> B2'den önce çalışmalı
- B1-> A2'den önce çalışmalı

Bu durumu incelediğimizde A1 ile B1'in birbirine göre çalışma sıralamasının bir önemi olmadığını anlıyoruz. 2 adet semafor kullanırız; 

- birinci semaphore aArrived, TreadA'nın buluşma noktasına ulaştığını belirtir.
- ikinci semaphore bArrived, TreadB'nin buluşma noktasına ulaştığını belirtir.  

```java
import java.util.concurrent.Semaphore;

public class RendezvousExample {
    static Semaphore aArrived = new Semaphore(0);
    static Semaphore bArrived = new Semaphore(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println("A: statement a1");
            aArrived.release();         // A geldiğini bildirir
            try {
                bArrived.acquire();     // B'nin gelmesini bekler
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A: statement a2");
        });

        Thread threadB = new Thread(() -> {
            System.out.println("B: statement b1");
            bArrived.release();         // B geldiğini bildirir
            try {
                aArrived.acquire();     // A'nın gelmesini bekler
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B: statement b2");
        });

        threadA.start();
        threadB.start();
    }
}
```

## Mutex(Mutual Exclusion) 
• Paylaşılan bir veriye birde fazla thread'in erişmesini engeller. Aynı anda sadece bir thread belirli bir kod bloğuna erişmesini sağlayan mekanizmadır. Bu kod bloğuna critical section(kritik bölüm) denir. Race condition durumuna çözüm sunar. Java'da mutual exclusion için Semaphore kullanılabilir. 


```java
import java.util.concurrent.Semaphore;

public class MutexExample {
    static int count = 0;
    static Semaphore mutex = new Semaphore(1); // 1: sadece bir thread geçebilir

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                mutex.acquire(); // mutex'i al
                count = count + 1;
                System.out.println("Thread A: count = " + count);
                mutex.release(); // mutex'i bırak
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                mutex.acquire(); // mutex'i al
                count = count + 1;
                System.out.println("Thread B: count = " + count);
                mutex.release(); // mutex'i bırak
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
```

- **Symmetric Solution:** Thread'lerin aynı kodu veya aynı davranışı kalıbını izlediği senkronizasyon yapısıdır. Genellkle daha kolay genelleştirilebilir ve daha az hata içerir. 
- **Asymmetric Solution:** Her thread'in farklı görevler üstlendiği ve senkronizasyonunun bu farklılıklara göre kurulduğu yapıdır. Doğruluğunu kanıtlamak zordur, genellikle karmaşıktır.


• **Multiplex(çoklu geçiş) Problem:** Kritik bölgeye aynı anda en fazla n thread'in girmesine izin vermek için kullanılır. Eğer daha fazla thread gelirse kalan kısımm bekler. Bu sayıyıda Semaphore'un constracter'ın çağırırken parametre olarak verilir.    



## Barrier   
• Amacımız tüm threadler belirli bir noktaya yani rendezvous ulaşmadan hiçbirinin bir sonraki adım olan critical point'i geçmemesini sağlamaktır. Yani n tane threadimiz var diyelim, n-1 thread geldiğinde bekleyecek n. thread geldiğinde hepsi birlikte devam edecek. 

```java
import java.util.concurrent.Semaphore;

public class BarrierExample {
    static final int n = 5; // Toplam thread sayısı
    static int count = 0;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore barrier = new Semaphore(0);

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                // RENDEZVOUS
                mutex.acquire();
                count++;
                if (count == n) {
                    for (int i = 0; i < n - 1; i++) {
                        barrier.release();
                    }
                    mutex.release();
                } else {
                    mutex.release();
                    barrier.acquire();
                }

                // CRITICAL POINT
                System.out.println(Thread.currentThread().getName() + " kritik noktaya ulaştı.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < n; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
```

Yukarıdaki kodda her thread geldiğinde count değişkenini arttırır. İlk n-1 thread barrier.acquire() ile bekler. n. thread geldiğinde count==n koşulu gerçekleşir ve n-1 kez barrier.release() çağrılır. Böylece bekleyen threadler serbest kalır ve tüm threadler critical point'e aynı anda geçebilir. Burada   mutex için release(); ve acquire() kullanmamamızın nedeni; count değişkenine birden fazla thread aynı anda erişirse race condition durumu oluşmasını engellemektir. 

## Turnstile(Turnike Deseni)
• Birden fazla threadin belirli bir noktaya kadar ilerlemesini durdurup sonrasında geçmelerini sağlamayan bir senkronizasyon mekanizmasıdır. Barrier'den sonra threadlerin birer birer geçmesini sağlar. Turnstile birbiri ile karıştırılabilir. Buyüzden 
aralarındaki farklara gözatalım;

- Barrier, tüm threadlerin belirli bir noktaya kadar gelip birlikte devam etmesini sağlar. Turstile ise threadlerin sırayla geçmesini sağlar.   
- Barrier genellikle bir kerelik veya reusable'dır. Turnstile ise genellikle thread geçtikten sonra sıradakine izin verir.   
- Barrierde, threadler gelir ve son gelen barrieri açar. Turnstile başlangıçta kilitlidir, bir thread açar.    
- Barrierde tüm threadler aynı anda geçer. Turnstile'de, her thread geçtikten sonra kaynağı serbest bırakarak sonrakini geçirir.    
- Barrier yapısı ->  count == n olduğunda barrier.signal()  , Turnstile yapısı -> semaphore.acquire() → işlem → semaphore.release()    
- Barrier, threadlerin senkronize şekilde ilerlemesi gereken durumlarda kullanılır.  Turnstile, threadlerin sırayla işlem yapması gereken durumlarda kullanılır.     

```java
import java.util.concurrent.Semaphore;

public class TurnstileExample {
    private static final int THREAD_COUNT = 5;
    private static final Semaphore turnstile = new Semaphore(0); // Başlangıçta kilitli

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    // Turnstile'de bekleme
                    turnstile.acquire();
                    System.out.println("Thread " + id + " geçti.");

                    // Sıradaki thread'e geçiş izni ver
                    turnstile.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // İlk thread'e geçiş izni ver
        turnstile.release();
    }
}
```

