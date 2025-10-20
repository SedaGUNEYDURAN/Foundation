# TEMEL TERİMLER
• **Synchronization**, günlük kullanımda iki şeyin aynı anda yapılması anlamına gelir. Bilgisayar sistemlerinde ise bir olayın diğerinden önce, sonra veya aynı anda gerçekleşmesi gibi olaylar arasındaki ilişkileri ifade eder. Yani geliştiriciler için synchronization, **olayların doğru sırayla gerçeklemesini sağlama işidir**.       
  
  - Serialization: A olayı B'den önce olmalı       
  - Mutual Exclusion: A olayı B ile aynı anda gerçekleşmemeli      

• Bir olayın gerçekleşmesinin sıralamasını yaparken saate bakarak karar veririz ancak bilgisayar sistemlerinde olayların zamanını yeterince hassas ölçemeyebiliriz. Bunun yerine lock mekanizmalarını, semaforları, concurrent veri yapılarını, barrier'lar, message passing gibi teknikleri kullanırız.      
• **Paralel Sistemler**: Birden fazla işlem biriminin (işlemci, çekirdek, bilgisayar vs.) aynı anda çalışarak bir görevi birlikte yerine getirdiği bilgisayar sistemidir. Bu durumda hangi işlemcideki komutun önce çalıştığını bilmek zordur. Büyük bir görev, daha küçük parçalara ayrılarak farklı işlemcilere dağıtılır. Görevler aynı anda yürütülür. Bu da işlem süresini kısaltır. İşlem birimleri arasında veri alışverişi ve zamanlama koordinasyonu gerekir. Sisteme daha fazla işlemci ekleyerek sistem kapasitesi arttırılabilir yani ölçeklenebilirdir.         
• **Multithreating**: Tek işlemci birden fazla threadi sırasıyla çalıştırır. İşletim sistemi hangi threadin ne zaman çalışacağına karar verir. Yazılımcı bu sırayı kontrol edemez.   
• **Message Passing**: Bir threadin veya sürecin diğerine bilgi göndermesi için mesaj-veri paketi iletmesidir. Veriyi doğrudan paylaşmak yerine iletir.  Thread A, "işlem tamamlandı" mesajı gönderir. Thread B, bu mesajı alana kadar bekler ve sonra işleme başlar. Böylece A'nın B'den önce çalıştığı garanti edilir. Senkronizasyon sağlanmış olur.    
• Deterministic bir kod her çalıştığında aynı sonu verir. Non-deterministic bir kod ise, farklı çalıştırmalarda farklı sonuçlar verir. Concurrent programlar da non-deterministic davranışlar görterebilirler.     

• **Serialization problemi**: Threadler senkronize edilmezlerse, birden fazla threadin(multi-thread) çalıştığı programlarda veriye erişim sırasında tutarsızlıklar oluşabilir; mesela okuma işlemi yazma işleminden önce gerçekleşebilir.     
• count+=1 bu ifade tek bir işlem gibi gözükse de makine diline çevrildiğinde iki adıma bölünür; okuma ve yazma. Bu bir threadin, iki adımıdır. Bu iki adım arasına bir thread girerse yarış durumu(race condition) oluşur. Böyle bir durum ile karşılaşmamak için mutex(mutual exclusion) kullanılabilirdi ya da atomic veri yapı tipi ile tanımlanabilirdi, synchronized bloklar oluşturulabilirdi. Varsayalım ki 100 thread var ;    

```java
for i in range (100):
temp = count
count = temp + 1
```
Bu durumda en büyük ve en küçük olası değer nedir ?        
Tüm threadler synchronize çalışırsa **en büyük olası değer= 100 thread x 100 artış= 10.000**.   
En küçük değeri incelediğimiz, her artış çakışır yani her iki thread aynı anda count'u okur ve aynı değeri yazar. Bu durumda iki işlem sonucunda 1 geçerli artış olur. Böyle bir senaryoda 10.000 işlem yapmış ama 5000 geçerli artış yapmış oluruz. Ancak en kötü durum bu değil. Her thread sadece bir kere başarılı artış yapabilir, diğer 99 artış başka threadlerle çakışabilir ve etkisiz olabilir bu durumda.  Böylece **en küçük olası değer: 100 thread x 1 geçerli atış= 100**     

• Multi-threaded programlamada threadlerin birbiri ile uyumlu ve güvenli bir şekilde çalışmasını sağlamak için kullanım senkronizasyon design patterleri vardır. Bunlar;

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
• Bu kavram Edsger Dijstra tarafından geliştirilmiştir. Semaphore, bir senkronizasyon mekanizmasıdır. Temel amacı; multi-thread veya process aynı anda çalışırken kritik bölgelere erişimi kontrol etmek ve veri tutarlılığını sağlamaktır.    
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
• Semafor oluştururken başlangıç değeri veririz. Sonrasında arttırma +1, azaltma -1 yapabiliriz. Ama değerini okuyamayız, yani semaforun anlık değerini bilemeyiz.       
• Azaltma sonucu semafor değeri negatifse(kavramsal olarak düşünüyoruz yoksa semaphore negatif değer olamaz) thread bloklanır. Yani bu thread durdurulur ve thread queue'ya beklemek üzere geçer. Başka bir thread semaforu artırana kadar devam edemez.Negatif değer kaç threadin queue'da beklediğini ifade eder.(Kavramsallık burada önemli. Diyelim ki anlık kuyrukta bekleyen sayısı 3 yani semaphore'u -3 olarak düşündün. 1 tane kaynak serbest kaldı -2 oldu, sıradaki threadlerden biri bu kaynağı alır semaphorun 0 olmasını beklemez, beklemesine gerek yoktur.) CPU kaynağı tüketmezler sadece beklerler. Queue'ya geçer dedik bekleyen ancak queue veri yapısı gibi FIFO prensibiyle çalışmaz. Ancak **new Semaphore(1,true)** şeklinde oluşturursak bekleyen threadler FIFO sırasına göre uyanır.     

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

Yukarıdaki örneği incelediğimizde görüyoruz ki Thread A'nın işi bitmeden B başlayamaz ve kodun sıralaması garanti altına alınır. Semaphore başlangıç değeri sıfır yani B threadi önce çalışsa bile acquire() threadi bloklar ve beklemeye geçer.Thread B artık  a1Done.acquire(); satırında bekliyor. Thread A çalışır işini yapar, bitirir ve kaynağı serbest bırakıp semaphore değerini bir arttırdığında B başlayabilir.    


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
• Paylaşılan bir veriye birden fazla thread'in erişmesini engeller. Aynı anda sadece bir thread belirli bir kod bloğuna erişmesini sağlayan mekanizmadır. Bu kod bloğuna critical section(kritik bölüm) denir. Race condition durumuna çözüm sunar. Java'da mutual exclusion için Semaphore kullanılabilir. 


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


• **Multiplex(çoklu geçiş) Problem:** Kritik bölgeye aynı anda en fazla n thread'in girmesine izin vermek için kullanılır. Eğer daha fazla thread gelirse kalan kısımı bekler. Bu sayıyıda Semaphore'un constracter'ın çağırırken parametre olarak verilir.    



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

## Reusable Barrier(Yeniden Kullanılabilir Bariyer)
• Barrierin birden fazla kez tekrarlanabildiği durumdur. Aynı barrier döngüsel işlemlerde tekrar tekrar kullanılabilir. 

```java
public class BarrierDemo {
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        ReusableBarrier barrier = new ReusableBarrier(THREAD_COUNT);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " bariyere geldi");
                barrier.rendezvous(); 
                System.out.println(Thread.currentThread().getName() + " bariyeri geçti");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}

```

```java
import java.util.concurrent.Semaphore;

class ReusableBarrier {
    private final int n; //barrierde beklemesi gereken thread sayısı
    private int count = 0; //kaç threadin geldiğini sayar
    private final Object mutex = new Object(); //count erişimini korur
    private final Semaphore turnstile1 = new Semaphore(0); //İlk geçiş; birlikte geçmesini sağlar.
    private final Semaphore turnstile2 = new Semaphore(1); // ikinci geçiş; threadlerin birikte çıkmasını sağlar

    public ReusableBarrier(int n) {
        this.n = n;
    }

    public void rendezvous() throws InterruptedException {
        // Phase 1: Thread’ler geliyor
        synchronized (mutex) {
            count += 1;
            if (count == n) {
                turnstile2.acquire(); // ikinci geçişi kapat
                turnstile1.release(); // ilk geçişi aç
            }
        }

        turnstile1.acquire(); // bekle
        turnstile1.release(); // diğerlerini geçir

        // Critical Point

        // Phase 2: Thread’ler çıkıyor
        synchronized (mutex) {
            count -= 1;
            if (count == 0) {
                turnstile1.acquire(); // ilk geçişi kapat
                turnstile2.release(); // ikinci geçişi aç
            }
        }

        turnstile2.acquire(); // bekle
        turnstile2.release(); // diğerlerini geçir
    }
}
```

main() içinde THREAD_COUNT kadar thread oluşturulur. Her thread task adlı işlemi çalıştırıyor. task içerisinde barrier.rendezvous() çağırılıyor. Bu method, her thread tarafından çağırılır. Threadler bariyere gelir. Şimdi bu durumu inceleyelim;

 - İlk thread(ThreadA) thread geldi count=1 oldu. count==n değil. Hiçbir semafor değişmez. **ThreadA turnstile1.acquire()'da bekler.** turnstile1=0 .       
 - İkinci thread(ThreadB) geldi count=2 oldu. count ==n değil. Hiçbir semafor değişmez. **ThreadB turnstile1.acquire()'da bekler.** turnstile1=0 .      
 - Üçüncü thread(ThreadC) geldi count=3 oldu. count ==n, bariyer doldu. turnstile2.acquire() ile ikinci geçiş kapatılır. turnstile2=0 olur.  turnstile1.release() ile ilk geçişi açar ve  turnstile1=1 olur.   
 - Şimdi bütün threadler turnstile1 geçişine geldiler. ThreadC,  turnstile1.acquire(); geçer. turnstile1=0 olur. turnstile1.release() → turnstile1 = 1 → diğerleri geçebilir.   
 - Thread-A → turnstile1.acquire() → geçer. turnstile1=0 olur. turnstile1.release() → turnstile1 = 1   
 - Thread-B → turnstile1.acquire() → geçer.  turnstile1=0 olur. turnstile1.release() → turnstile1 = 1   
 - Tüm threadler kritik noktaya ulaştı. Burada işlemler yapılır(boş bıraktık, programcı doldurur oraları)   
 - Threadler barrierden çıkış yapacak. ThreadC, geldi count=3'dü, count=2 oldu. count==0 değil semaforlar değişmez. Metotan çıkış yapar. ThreadC,  turnstile2.acquire()'a gelir. turnstile2=0'dı.  Bekler.     
 - ThreadA geldi, count=1 oldu. count==0 değil. Semaforlar değişmez.Metotdan çıkar. ThreadA,  turnstile2.acquire()'a gelir. turnstile2=0'dı.  Bekler.    
 - ThreadB geldi, count=0. count==0 koşulu sağlandı. En son turnstile1 = 1'di. ThreadB,  turnstile1.acquire()'ye gelir  turnstile1=0 olur ve geçer. İlk geçiş kapandı. turnstile2.release()'ye gelir. turnstile2 semaforunu en başta kapatmıştık. turnstile2=1 olur. Thread B geçer.  turnstile2.acquire()'a gelir. turnstile2=1'dı turnstile2=0 olur. Geçer ve  turnstile2.release()'e gelir. turnstile2=1 olur.   
 - ThreadC, turnstile2=1'di turnstile2.acquire()'den geçer. turnstile2=0 olur. turnstile2.release()'e gelir. turnstile2=1 olur.   
 - ThreadA turnstile2=1'di turnstile2.acquire()'den geçer. turnstile2=0 olur. turnstile2.release()'e gelir. turnstile2=1 olur.   
 - Tüm threadler barrieri terk etti ve barrier tekrar kullanılabilir hale geldi. Son durumda;  count=0, turnstile1=0, turnstile2=1 olur. Yeni bir grup thread geldiğinde aynı döngü tekrar edebilir.    

Phase 1 bölümünde;her thread geldiğinde count değeri arttırılır. Koşul sağlandığında (count==n) kaynak serbest bırakıldı (turnstile1). Buraya kadar her şey beklediğimiz gibi. Ama öncesinde ikinci geçişi(turnstile2) kapatıyoruz. Bunu neden yaptığımızı anlamak için adım adım gidelim;   
ThreadA girer -> count=1      
ThreadB girer -> count=2  burada bloktan çıkmadan bir interrupt olduğunu varsayalım ve bu durumda CPU diğer threade geçer.       
ThreadC girer -> count=3  ve turnstile1 kaynağı serbest bırakılır. ThreadB devam eder.Hala count=3, bu durumda ThreadB de turnstile1.release() çağırır. İki farklı thread count==n durumunu görür ve iki kez release() çağırılır. Bu da semaforun fazladan açılmasına neden olur ve barrier bozulur.       

• İki aşamalı barrierde hatalar özel ve nadirdir. Bu yüzden de hatalar test ile yakalanamaz, hataları tekrar üretmek çok zordur.     


### Problem 
• Her bir dans eşlemesi, bir leader+bir follower ile gerçekleşir. Birden fazla follower, birden fazla leader olabilir. Bir leader geldiğinde, bir follower onunla eşleşir ve dansa geçer. Bir follower geldiğinde, bir leader varsa eşleşir ve dansa geçer. Eşleşmeler 1:1 olur. Fazla gelen kişiler, karşı türden biri gelene kadar sırada bekler.    


```java
DanceFloor floor = new DanceFloor();

Runnable dance = () -> System.out.println(Thread.currentThread().getName() + " dans ediyor");

Runnable leader = () -> {
    try {
        floor.leaderArrives(dance);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};

Runnable follower = () -> {
    try {
        floor.followerArrives(dance);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};

// Örnek olarak birkaç leader ve follower başlatalım
for (int i = 0; i < 3; i++) {
    new Thread(leader, "Leader-" + i).start();
    new Thread(follower, "Follower-" + i).start();
}
```

```java
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DanceFloor {
    private final Semaphore leaderQueue = new Semaphore(0);
    private final Semaphore followerQueue = new Semaphore(0);
    private final ReentrantLock lock = new ReentrantLock(); //counterlara güvenli erişimi sağlar. 

    private int waitingLeaders = 0; //kaç leaderin beklediğini tutar
    private int waitingFollowers = 0; //kaç followerın beklediğini tutar. 

    public void leaderArrives(Runnable dance) throws InterruptedException {
        lock.lock();
        if (waitingFollowers > 0) {
            waitingFollowers--;
            followerQueue.release(); // eşleşen follower'ı uyandır
            lock.unlock();
        } else {
            waitingLeaders++;
            lock.unlock();
            leaderQueue.acquire(); // eşleşme yoksa bekle
        }

        // eşleşme sağlandı, dans başlasın
        dance.run();
    }

    public void followerArrives(Runnable dance) throws InterruptedException {
        lock.lock();
        if (waitingLeaders > 0) {
            waitingLeaders--;
            leaderQueue.release(); // eşleşen leader'ı uyandır
            lock.unlock();
        } else {
            waitingFollowers++;
            lock.unlock();
            followerQueue.acquire(); // eşleşme yoksa bekle
        }

        // eşleşme sağlandı, dans başlasın
        dance.run();
    }
}

```


