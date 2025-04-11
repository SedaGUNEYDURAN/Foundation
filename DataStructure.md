## Binary Search Tree
• Binary search tree sadece elemanlar sıralı olduğunda çalışır. Şimdi aklından 1-240.000 arasında bir sayı tuttuğunu ve her tahminde az, çok diye yönlendirme verdiğimi düşün ve bunların sıralı oladuğunu düşün. En kötü durumda tek tek 1,2,3,4,5... şeklinde bulursun. Ama yarıya böle böle tahmin edersen (120.000-yüksek dediğimde sayıların sayısını elemiş olduk, 60.000- yüksek sayılarını 4'te 3 ünü elemiş olduk) işte bu şekilde aramaya binary search denir. En kötü durumda (worst case) logndir. 2 tabanında 240000 dersek bunun sonucu nedir ? 18  (240.000->120.000->60.000->30.000->15.000->7500->3750->1875->938->469->235->118->59->30->15->8->4->2->1 toplam 18 adım)
## Array & Linked List
• Array'de tüm elemanlar bitişik-yanyana olarak depolanır. Bilgisayarı çekmeceli bir dolap gibi düşünelim. Her çekmecenin bir adresi vardır. Bir çekmeceye bir şey koymak istediğimizde bu çekmecenin bir adresi olduğunu düşünelim. Bunu gibi bir eleman eklemek istediğimizde de bilgisayar bize bir adres verir oraya ekleriz elemanımızı. Şemsiyemizi bir çekmeceye koyduk yanındaki çekmeceye de eldivenlerimizi koymak istiyoruz ama yan çekmece dolu ikisinin de bir arada durmasını istediğimiz için iki eşyayı da yan yana boş olan başka çekmecelere taşımamız gerekir. Ya da ya taraftaki dolu çekmeceyi sornaki çekmeceye onun içindeki sonrakini diyerek bütün elemanların yerini değiştirmemiz gerekir. Arrayden eleman silmek için de aynı durum geçerlidir. Random access'e izin verdiği için arraylar sıklıkla tercih edilir.  
• Linked Listye eleman eklemek istediğimizde  bilgisayardan biraz alan isteriz, bilgisayarda bize bir bir adres verir. Her bir eleman kendinden sonraki elemanın adresini verir. Yer değiştirmek zorunda olmadığımız için de eleman eklemek kolaydır. Diyelim ki ortaya eleman eklemek istiyoruz önceki elemanın gösterdiği adresi değiştirmemiz gerekir ve yeni eklediğimiz elemana bir sonraki eleamnın adresini eklemeliyiz. Ancak son elemana ulaşmak istiyorsun diyelim bunun için 1. eleman 2. elemanı 2. eleman 3. elemanın adresini gösterir ve son elemana kadar bu şekilde ilerlemek zorunda kalırsın. Kısaca sadece sequential access ile elemanlara erişilir. 
• Array'de her item'in addressini biliyoruz. Şöyle düşün 5. elemanını arıyorsun bu durumda array indeksi 0'dan başladığına göre 4. indekste 5. elemanın bulunuyor. Ancak linkedListte elemanlar yanyana dizili olmadığı için böyle bir tahmin söz konusu değil tek tek gezmen gerekecek.
• Bu durumda ne olur; 

- Bir elemanı arrayde bulmak O(1), LinkedList'te bulmak O(n) karmaşıklığa sahip olur. 
- Bir eleman eklemek/çıkarmak arraye O(n), LinkedList'te ise O(1) karmaşıklığa sahip olur.

 • ArrayListin sonuna eklemek O(1) karmaşıklığa sahip gibi düşünülebilir ancak sabit boyutlu bir dizide tüm elemanları kopyalayıp daha büyük bir dizi üretmemiz gerekir bu da O(n) karmaşıklığa sahiptir. ArrayLis dinamik de olabilir, bu durumda da boyut genişletmemiz gerektiği için tüm elemanlar yine kopyalanır ve O(n) karmaşıklığa sahip olur 
 • Arrayler ve Listler diğer veri yapılarını uygulamak için kullanılır.

 ## Stack
 • LIFO(Last In, First Out) prensibi ile çalışır.Dizi ve linked list mantığın ile oluşturulabilirler. Bir eleman eklendiğinde en tepeye eklenir, bir eleman okudunduğunda en tepedeki okunur ve stackten çıkarılır. İki temel aksiyonu vardır; push(insert), pop(read and delete).    

 - Push: stack'e eleman ekleme işlemi yapar, yeni eklenen eleman top olur.
 - Pop: stack'ten eleman çıkarır, top elemanı çıkarır.
 - Peek: kullanıcıya veri ödndürür, top elemanını döndürür.
    
• ProgramLAR run timeda metot ve fonksiyon çağrılarını izlemek için **call stack** kullanır.Her metot çağırıldığında call stacke, stack frame eklenir. Stack frame metodun local değişkenlerini, parametrelerini, geri dönüş adresini(metotlar arasında gezinirken, hangi metoda dönülerek programın devam edileceğini) içerir. Java'nın JVM'i bu işlemi gerçekleştirir ve metot çağrıları sırasında stack'i yönetir.    
## Queue
• Stack gibidir, rastgele elemanlara erişemezsin. Yalnızca iki işlem vardır; kuyruğa alma ve kuyruktan çıkarma. Listeye iki öğe eklersek ilk eklediğimiz son eklediğimizden önce çıkar; FIFO(First in First out) prensibi ile çalışır.   
![image](https://github.com/user-attachments/assets/0c621ace-4285-46ae-8b3a-2e6e9692c9ad)

## Hash Table
• Değerleri key ve value olarak depolar. Her key'e karşılık gelen bir tane değer bulunur. Bir anahtar bir kez var olabilir;bir değer biden fazla olabilir. **Ekleme sırasına göre depolama yapmaz.** Oldukça hızlıdır; search, insert, delete time complexity'si O(1)'dir.Worst case durumda ise search,insert, delete time complexity'si O(n)'e gider. Worst case durum; hash tablosundaki bütün itemlar aynı slottadır.  
![image](https://github.com/user-attachments/assets/15603aae-a349-47e5-9f19-dcf7ba7941d5)


 - HashMap'e gönderilen değerler sırasız,
 - LinkedHashMap'e gönderilen değerler ekleme sırasına göre,
 - TreeMap'e gönderilen değerler keylerine göre küçükten büyüğe doğru sıralanarak depolanır.
   
•  Hash map, map, dictionariy, associative array'ler olarak da bilinirler.
• Verileri depolamak için bir dizi kullandıklarından ve arama yapması arrayler gibi hızlıdır. 
• Python'da yeni bir hash tablosu oluşturmak için shortcut vardır. 

```java
phone_book={} <---- same as phone_book=dict()
```

• Diyelim ki http://adit.io adresine gitmek istiyoruz url'i yazdığımızda 173.255.248.55 IP adresine gidiyor. Buna DNS resolution deniyor ve hashmap ile işlem yapıyor.  
• Birden fazla elemanın aynı hash tablosunda aynı slotu gösterdiği durumlarda hash çakışmaları(hash collisions) olur. Bu hash fonksiyounun zayıf olduğunu veya tabloda çok fazla veri olduğunu gösterir. İyi bir hash tablosunda collision az olmalıdır. Bunun çözümü için farklı yöntemler vardır;  

 - **Seperate Chaining**; Her çakışma sonucu elemanlar bir linked liste eklenir. Worst case senaryoda zincirdeki eleman sayısı n'e gider ve elemanın yerini bulmak veya eklemk için listenin sonuna kadar gitmek gerekir. Bu durumda karmaşıklığı O(n)'e gider.
 - **Open Addressing**; Lineer probing(H(x)+i ile hesaplanır,H(x) modudur. Çakışma olduğuğunda moda 1 ekelnerek indisi bulunur.Sınırı vardır.Hash tablosu dolduktan sonra devam edilmez. ), quadratic probic(H(x)+i^2 ile hesaplanır, çok sıkışık durumlarda kullanılır) veya double hashing ile çakışmaları çözmek için boş bir yer aranır. Eğer tablonun doluluk oranı(load factor) çok yüksekse ve uygun b,r yer bulmak zorlaşırsa, bu arama işlemi tablonun tamamını dolaşmayı gerektirebilir. Bu durumda ekleme işleminin karmaşıklığı O(n)'e gider.

• **Load Factory**;Hash tablosundaki item sayısı / total slot sayısıdır. Diyelim ki 5 slotu bulunan bir hash tablomuz var. Bu 5 slotta toplam 2 eleman var. Bu hash tablosunun load factor'si 2/5'dir. Yani load factory'nin 1'den büyük olması array'deki slotlardan daha fazla sayıda item olduğu anlamına gelir. Böyle durumlarda tablo yeniden boyutlandırılmalıdır(resizing). Ve genellikle size iki katına çıkarılır yani slot sayısı. Genel kurala göre load factory **0.75** 'den büyükse tablo boyutlandırılmalıdır. Resizing pahalıdır buyüzden da genellikle yapmak istemeyiz ama hash tabloları yeniden boyutlandırmayla bile O(1) complexitye sahiptir.  

• **Caching** veri ve işlemlere daha hızlı erişim sağlamak için kullanılan bir optimizasyon yöntemidir. Sıkça erişilen veya yeniden kullanılan verilerin geçici bir depolama alanında(cache) tutulmasıdır. Böylece, bu verilere erişim gerektiğinde daha yavaş bir kaynaktan(veritabanı, remote server vs.) almak yerine doğrudan cache'den hızlı bir şekilde alınabilir. Cache'de tutulan veri, hash fonksiyonu ile bir anahtar değere dönüştürülerek bir hashtable'da tutulur. 

 - **Cache Kontrol**, Bir veriye ihtiyaç duyulduğunda önce cache kontrol edilir.
 - **Cache Hit**, eğer istenen veri cache'de mevcutsa bu veriye hızlıca erişilir.
 - **Cache Miss**, eğer veri cache'de yoksa, daha yavaş kaynaktan veri alınır ve cache eklenir. 
• **ConcurrentHashMap**; Thread ortamlarında kullanılmak üzere tasarlanmış bir thread safe veri yapısıdır.Hashmap birden fazla thread tarafından eşzamanlı olarak kullnıldığında tutarsızlık sorunları yaşanabilir, ConcurrentHashMap ile birden çok iş parçacığının yani threadın aynı anda güvenli bir şekilde herhangi bir komplikasyon olmadan tek bir nesne üzerinde çalışabilir.Hashtable tread safe olsa da tüm işlemleri tamamen senkronize eder. Bu durumda bir thread çalışırken diğer thread beklemek zorundadır, bu da performansı düşürür. ConcurrentHashmap'de kilit segmentasyonu yaklaşımı kullanılır, böylece yalnızca gerekli bölümler (bucketlar) kitlenir. Bu da kilitlenmelerin kapsamını daraltır ve performansı artırır.
• HashMap, null bir anahtar eklenmesine izin verir, bu durumda hash fonksiyonu null için özel bir muamele yapar. Ancak ConcurrentHashMap buna izin vermez.ConcurrentHashMap value olarak da null değer alamaz. Bu multithread durumlarda olası belirsizlikleri önlemektedir. 

## Graph
•  Bir graph algoritmasıdır.Graph bir dizi bağlantıyı modeller. Nodelardan ve edgelerden oluşur. Bir node birden çok mode ile bağlantılı olabilir ve bu nodelara neighbor denir. 
![image](https://github.com/user-attachments/assets/cb48b1eb-79ed-4b92-9d30-a97e1223c868)  
• İki çeşittir; undirected ve directed. Undirected graphlar oklara sahip değildir ve her iki düğüm birbirinin komşusudur. Bazı düğümleri de işaret eden oklar vardır ancak onların işaret ettikleri oklarla nodelar yoktur, bunlar directed'dır.    
![image](https://github.com/user-attachments/assets/77df6825-161b-44bb-9ba7-46a4b3ec8935)

• Tree, graph'ın hiçbir kenarı geri işaret etmediği özel bir türüdür.     
• **BFS(Breadth First Search):**  İki şey arasındaki en kısa mesafeyi bulmamızı sağlar.  nodeları ekleme sırasına göre kontroln etmek gerekir. Bu yüzdende queue kullanılabilir. FIFO prensibi ile çalıştığı için. Bir düğüğm kontrol edildikten sonra tekrar kontrol edilmemelidir, algoritma sonsuz döngüye girebilir. Bunu önlemek için bir düğüm gezildiğinde kaydedilmeli, visited set veya liste tutulmalıdır.  

## Recursion
 • Bir fonksiyonun kendisini çağırmasıdır. Her recursion fonksiyonun iki durumu vardır; base case and recursive case.   
 • Normal recursive fonksiyonda bir metot kendini çağırır, bu işlemler diğer işlemler yapılmadan önce yapılır. Bu ne anlama gelir dersek her çağrı stack frame oluşturur ve hafızada yer kaplar. İşlemler çağrı tamamlandıktan sonra devam eder. Her recursive çağrı stacke bir frame ekler.  normalRecursiveFactorial(5) çağrılır ve stacke frame eklenir.  
normalRecursiveFactorial(4) çağırılır ve yeni bir stack frame eklenir.   
normalRecursiveFactorial(3) çağrılır ve stack frame eklenir.  
Bu normalRecursiveFactorial(0) çağrılana kadar devam eder. Her recursive çağrıda, önceki çağrıların yürütme durumu stacktedir. Fonksiyon tamamlandığında; stack, frameleri birer birer kaldırır ve geri dönüş işlemlerini yapar. 
 ```java
public int normalRecursiveFactorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * normalRecursiveFactorial(n - 1);
}

```
 • **Tail Recursion**: Rekürsif çağrı en son işlem olarak yapılır. Bu metodun döndürülen değeri doğrudan rekürsif metodu içerir, başka bir işlem yapılmaz. Bu ne demek oluyor dersek stack'in derinliği artmaz ve mevcut stack frame yeniden kullanılabilir.Ancak Javada JVM tail recursion optimizasyonu(TRO) yapmaz. 
 ```java
public int tailRecursiveFactorial(int n, int result) {
    if (n == 0) {
        return result;
    }
    return tailRecursiveFactorial(n - 1, n * result);
}
 ```
## Simple Search Algoritması
 • Belirli bir öğeyi bulabilmek için lineer arama yöntemidir. Time complexity:O(n) 
 
## Travelling Saleperson Problem (TSP)
 • Bir optimizasyon problemidir. Problemin çözümü için en verimli algoritmanın bilinmediği durumdur. Tüm olası çözümleri denemek için gerekir bu durumda time complexity;O(n!)'dür. Bİr gezginin belirli bir dizi şehri ziyaret ederek her birini tam bir kez geçmesi ve toplam yolculuk mesafesini minimumda tutması gereken bir optimizasyon problemidir. 
## Selection Sort
 • Şimdi 5 elemanı sıralayacağımızı düşünelim.(67,12,56,4,24). İlk eleman 67 bütün eleamnlarla karşılaştırılır. Kendisinden büyük bir sayı olmadığı için birinci sırada olur, bu işlem için 4 karşılaştır yapılır. 2. elemana geçilir ve karşılaştırılır.12, 56'dan küçük bu durumda 56 ile karşılaştırmaya devam edilir.Totelde 4 karşılaştır yapıldıktan sonra 2. sayının 56 olduğu belli olur. Bu şekilde bir bir azalarak sıralama yapılır. ilk elamnı bulmada n, ikinci elemanı bulmada n-1, üçüncü elemanı bulmada n-2 ... işlem yapılır. Bu durumda n(n+1)/2 işlem yapılır. Bu ne demek (n^2+n)/2 sabit sayılar bigO notasyonunda gösterilmediğine göre O(n^2) karmaşıklığa sahiptir. 

## Divide & Conquer
 • Euclid’s algorithm; İki pozitif tam sayının en büyük ortak böleninin bulunması(EBOB).   
 • **QuickSort algoritması** divide&conquer mantığı ile çalışır ve oldukça hızlıdır. Pivot seçimi yapılarak iki parçaya bölünür;pivottan küçük olanlar pivotun solunda ve pivottan büyük olanlar pivotun sağında Bu işlem rekürsif olarak bölerek sağlanır. Bestcase'de ek alan kullanımı yapmaz space complexity(1), time complexity: O(n*logn). 
 
 - Pivot seçimi dengeli olduğunda; her bölme adımında, her eleman pivotla bir kez karşılaştırılır bu durumda her bölme adımında  O(n) zaman harcanır, Rekürsif ya da iteratif olarak yaklaşık logn derinliğinde alt listeler oluşturulur bu durumda karmaşıklığı O(n*logn) olur. 
 - İşleme pivot seçimi yapılarak başlanır ancak pivot seçimi dengeli yapılmazsa worst case'de time complexity:  O(n^2)'ye gider. Pivot her seferinde listenin en büyük ya da en küçük elemanı seçilirse bu durumda bir taraf boş kalacağı için n,n-1,n-2,n-3....,1 elemanla işlem yapılması gerekir.Bu da  n(n+1)/2 tane işlem yapmamız anlamına gelir bunun karmaşıklı da O(n^2)'dir.
 - Eğer rekürsif yaklaşım(call stack) ile yazılırsa bu durumda her rekürsif çağrı stackte yer kaplar. Bu durumda pivot seçiminin dengeli olmasına göre space complexity worst case'de O(n)'e, best casede ise O(logn)'e gider. Ek bir liste kullanmadan liste üzerinde hareket edersek(in-place) space complexity  O(1)'dir.   
 

 ![image](https://github.com/user-attachments/assets/8987afbc-fbc3-4667-baa8-8b914eee0367)

 • **MergeSort algoritması** divide&conquer mantığı ile çalışır ve oldukça hızlıdır. Veri setini önce küçük parçalara ayırır sonrasında birleştirirken sıralama işlemi yapılır. Eğer bölme sırasında 3 eleman kalırsa 2'ye 1 şekilnde bölüm yapılır. Her durumda time complexity; O(nlogn). Ekstra bellek gerektirir, space complexity; O(n). Çünkü parçaları birleştirmek için geçici bir alan kullanır.   

 
## Big O Notation
Big O notasyonu işlem sayısını karşılaştırmamızı sağlar. Düşük karmaşıklıktan yüksek karmaşıklığa;  
• O(1): sabit zaman  
• O(logn): log time olarak bilir. Örnek; binary search   
• O(n): n boyutunda bir listemiz varsa ve tek tek bütün elemanlar kontrol ediliyorsa n kere işlem yapmak gerekir. Örnek; linear time olarak bilinir. Örnek: Simple search   
• O(n*logn): Örnek: Hızlı sıralama algortimalarıdır. Quicksort gibi   
• O(n^2): Örnek: Yavaş sıralama algoritması. Selection sort gibi    
• O(2^n):  
• O(n!): yavaş algoritma. Buna travelling saleperson problem denir.   
