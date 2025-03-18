# Temeller

• Temelde baktığımızda javada new kullanmadan obje oluşturamayız. Ancak Stringler, Arrayler, Wrapperlar, Enumlar oluştururken new kullanmadan obje oluşturabiliriz. Bu durumu reflectionlarla da sağlayabiliyoruz. Kısaca javada new anahtar kelimesi kullanmadan da obje oluşturulabilir.    
• **JavaBeans**, Java programlama dilinde yazılmış ve belirli bir standart yapıya uyan, yeniden kullanılabiliğr bileşenlerdir. Genellikle veri taşıma nesneleri(DTO) olarak veya GUI bileşenleri olarak kullanılır.    
 
  - Her java en az bir parametresiz constructor'a sahip olmalıdır.
  - Private alanlara sahip olmalıdır. Bu alanlara erişim için getter/setter metodları kullanılır. Encapsulation'ı destekler.  
  - "java.io.Serializable" interface'ini kullanarak stream'e yazılabilir hale getirir. Bu da nesnelerin dosyaya kaydedilmesini ve ağ üzerinden iletilmesini sağlar.  
  - Fields tanımlar; uygulama ve kullanıcı arabirimleri ile etkileşim için.  
    
• **Stream**; Java'da veri akışlarını temsil eden yapılardır. Veri okuma, yazma işlemlerini çaşitli kaynaklardan hızlı ve verimli bir şekilde gerçekleştirmek için kullanılır. Java streamleri verilere üst düzey erişim sağlar ve farklı veri biçimlerine kolayca uyum göstermesini sağlar.    
• **Serileştirme**; bir nesnenin durumunu(state) byte dizisine dönüştürme işlemidir. Nesneleri dosya sistemine kaydetmek, ağ üzerinden göndermek için kullanılır. ObjectOutputStream, nesneyi bir streame yazmak için kullanılır ve wriObject metodu, nesneyi streame dönüştürüp bir dosyaya kaydeder.ObjectInputStream ise serileştirilmiş nesneyi stream'den readObject metodu ile geri okuyarak tekrar bir Java nesnesine dönüştürür.     

• **var**: Local değişkenlerin türünü otomatik olarak belirlemek için kullanılır. Java 10 ile gelen bir özelliktir. var kullanarak bir değişken tanımladığımızda Java derleyicisi atanan değer üzerinden değişkenin değerini belirler. "var" sadece yerel değişkenlerde kullanılabilir, sınıf değişkenlerinde kullanılamaz. 
 
 - var ile null değeri atanması derleyici hatası verir, çünkü null durumu belirli bir türü ifade etmez. 

```java
public class VarExample {
    public static void main(String[] args) {
        var sayi = 10; // int türünde
        var pi = 3.14; // double türünde
        var isim = "Java"; // String türünde
        var dizi = new int[] {1, 2, 3}; // int dizisi
    }
}
```

• **Stateful**, bir nesnenin ya da bileşenin durumunu yani state'ini muhafaza eden ve bu durumu birden fazla işlem boyunca koruyan bir kavramdır. Bu sayede nesne bir sürecin tamamı boyunca tutarlı bir şekilde çalışabilir.  Stateful bir bileşen kullanıcı veya uygulama için özel oturum bilgilerini, verileri ve parametreleri tutarak durum bilgisini saklar.    
• **Stateless**, hiçbir durum bilgisini saklamaz. Her işlem bağımsızdır ve kendi bağlamında değerlendirili. Örneğin; RESTful API  genellikle stateless bir yapıya sahiptir, çünkü her istek kendi başına eline alınır.      

## Stream
• **Stream**: Bir veri kaynağından elde edilen sıralı bir veri akışıdır. Streamler lazy'dir. Yani veriler üzerinde işlem yapmadan önce işlem dizisi oluşturulur ve bu dizi ihtiyaç duyulduğunda çağırılır. Böylece kaynakların kullanımının daha verimli olması sağlanır. Stream API; koleksiyonlar üzerinde filtrelemeler, dönüşümler ve işlemler yapmayı daha kolay ve okunabilir hale getirir. 
   
   - Aşağıdaki örnek kodda filter metodu streamdeki öğeleri belirli bir koşula göre filtreler. this::isValidSet, bir metod referansıdır. isValidSet metodunun her öğeye uygulanacağı anlamına gelir. isValidSet metodundan true döndüren öğeler streamde kalır. forEach(set->{...}) ise streamde kalan her bir set için belirtilen işlemi uygular.    
       
```java
sets.stream.filter(isValidSet).forEach(set->{...});
```
  -  **InStream** yalnızca int değerlerle işlem yapar ve tüm veriler üzerinde çeşitli işlemler gerçekleştirmememizi sağlar. Bu yapı ile toplama(aggregation), filtreleme, dönüştürme(mapping), diziler ile çalışma yapılabilir. **IntStream.range(int startInclusive, int endExclusive)** metodu belirli bir başalama ve bitiş değeri arasında bir IntStream oluşturur(startInclusive, streamdeki ilk(dahil) değer; endExclusive, streamdeki son(hariç) değer).
  -  **mapToObj(...)**, her bir int'i bir objeye dönüştüren bir obnksiyon uygular, her bir tam sayı içinm çıktının türünü değiştirmek için kullanılır. Burada Object türüne dönüştürür. Bu ifadede sets listesinden i ve i+1 indeksindeki ögeleri alarak Object dizilerini oluşturur. 
  -  **filter(pair-> ..)** ifadesi mapObj ile oluşturulan Object dizilerini temsilen kullanılır lambda ifadesi ile pair üzerinde belirtilen koşulu kontrol eder. Eğer koşul true ise pair streamde kalır; değilse streamden çıkarılır.
        
```java
IntStream.range(0, sets.size()-1).
mapToObj(i->new Object[]{sets.get(i),sets.get(i+1)}).
filter(pair->"SEDA".equals(((ISet)pair[0]).getName()) && "GUNEY DURAN".equals(((ISet)pair[1]).getName()).
forEach(pair-> createMethod((ISet)pair[0], (ISet)pair[1]));
```
• **anyMatch()**: Stream içindeki herhangi bir elemanın belirli bir koşulu sağlayıp sağlamadığını kontrol etmek için kullanılır. Herhangi bir eleman koşulu sağlıyorsa true sağlamıyorsa false döner. 
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);

        System.out.println(hasEven);  // true
    }
}

```


## Garbage Collector
• **Garbage Coellector**:Common Language Runtime(CLR)'da otomatik bellek yöneticisi olarak çalışır. Bir uygulama için belleğin tahsisini ve serbest bırakılmasını yönetir. CLR ayağa kalktıktan sonra managed heap oluşur. Garbage collector , managed heap üzerindeki ensneleri yaşam durumuna göre bellekten siler. Stack'te tutulan değişkenler herhangi bir işlemi beklemeden kullanıldak sonra bellekten direkt silinir. Heap için ise devreye GC girer. 

- **Memory Leak(Bellek Sızıntısı)**: new ile bir nesneyi allocate edip sonra silmeyi unuttuğumuzda karşılaşırız
- **Memory Corruption(Bellek Bozulması)**: silinmiş bir nesneye erişmek istediğimizde karşılaşırız.
- **Memory Error(Bellek Hatası):** bellekte henüz allocate olmamış bir nesneyi silmeye çalıştığımızda karşılaşırız

• **Stack:**  local değişkenlerin, parametrelerin ve dönüş değerlerinin tuttulduğu bellek bölgesidir. Bir metod çağrısı meydana geldiğinde, stack frame adından metotla ilgili her şeyi tutan bir blok oluşturur. Her metot çağrısında o metoda özel stack frameler son çağırılan metodun stack frame'i üzerine biner(LIFO-Last In First Out). Stack sadece primitive tipleri değil, referans tiplerin referanslarını da tutabilir. Referans tipleri, stackte sadece referansları yani adresleri tutulabilir. Heapte gerçek nesneyi tutar. Metot çağrısı bittiği zaman o stack içindeki verilerle stackten otomatik olarak silinir. En üstteki stack frame her zaman çalıştırılan metodu gösterir. Metotların bu şekilde üst üste binip stackin limitini aşması durumunda **StackOverFlowException** fırlatır. Primitive tipler(byte, int, double, char, decimal, struct vb.) genellikle stackte tutulur. 

• **Heap:** Referans tiplerin(class, interface, string vb.) tutulduğu belleğin diğer bir bölgesidir. Bu nesneler asla stackte tutulmaz. Stackte oluşan stack frameler içerisindeki referans tipler heapte bir alanı gösterir. Bu referans tiplerden genellikle new anahtar kelimesi ile yeni bir nesne yaratıldığında stack üzerinde değişkeni tutulurken, nesnenin kendisi heapte tutulur. Stack'ten stack frame silindiğinde heapte ilişkili olduğu yani referans verdiği nesneler silinmez ve nesne referanssız kalır.GC nesnelerin heapte alokasyonlarını kaldırır ve temizler. Temizlemeye başladığı durumlarda heap sınıdırı dolduğu zaman **OutOfMemoryException** fırlatır. 
     - boxing-> stackten heap'e 
     - unboxing -> heapten stack'e
```java
class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}       
```
```java
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice");
        changeName(p);
    }
    static void changeName(Person person) {
        person.name = "Bob";
    }
}
```

 Yukarıdaki kodda new Person("Alice") ifadesi çalıştırıldığında bir Person nesnesi oluşturulur. Bu nesne heap bellek alanında yer alır. Oluşturulan p variable'ı Person sınıfına ait bir referans değişkenidir. Bu değişken heap'te oluşturulan Person nesnesinin referansını yani adresini içerir. p variable'ı stackte saklanır.  person.name = "Bob"; ifadesi ise heap'teki Person nesnesinin name özelliğini Bob olarak değiştirir.  

 this.name="Bob" şeklinde bir ifade bulunsaydı; this, mevcut nesne instance'ını temsil eder. Yani this, heapteki nesneyi işaret eder. Heapteki Person nesnesinin name özelliğini Bob olarak değiştirir.  Stack belleğindeki referanslar, bu heap nesnesine işaret ettiği için, yapılan değişiklikler bu nesne üzerinde etkili olur. 

 
• **Garbage Collector nesneleri nasıl temizler :** Bir nesneye erişiminin olup olmadığına bakarak çalışır. Eğer bir nesneye ya da referansa ulaşımı yoksa onu çöp olarak değerlendirir ve bellekten temizler. 

```java
public class Main {
    public static void main(String[] args) {
        // Bir String dizisi oluşturuyoruz
        String[] words = new String[5]; // Heap'te bir nesne oluşturuldu
        words[0] = "Hello";
        words[1] = "World";
        words[2] = "Java";
        words[3] = "Programming";
        words[4] = "Language";

        // Dizinin bazı elemanlarını null yapıyoruz
        words[0] = null; // 0. indeks null oluyor
        words[3] = null; // 3. indeks null oluyor

        // Dizinin içeriklerini yazdırıyoruz
        printArray(words);

        // Garbage Collector bu aşamada devreye girmez
    }

    public static void printArray(String[] arr) {
        for (String word : arr) {
            System.out.print(word + " "); // null değerler olduğu için "null" yazacaktır
        }
    }
}
```
Buradaki kodda String[] words = new String[5]; heapte bir String dizisi oluşturur. String dizisi başlangıçta tüm elemanları için null değerine sahiptir.  Array'in elemanlarına değer atadıktan sonra indexleri heapteki nesnselerini işaret eder.   words[0] = null; ve  words[3] = null; artık herhangi bir String nesnesini işaret etmez. Ama diğerleri hala işaret etmektedir. Bu durumda garbage collector nesneyi temizlemez, çünkü hala başka referanslar var. words[0] ve words[3] elemanlarındaki nesnelere olan referans kaldırıldığı içim garbage collector tarafından bunlar silinir. Dizi hala varlığını sürdürmeye devam eder , belirtilen indexler null değerine sahip olur. 

```java
public class Main {
    public static void main(String[] args) {
        // Bir dizi oluşturuyoruz ve bellek alanında yer tahsis ediyoruz
        int[] numbers = new int[5]; // Heap'te bir dizi nesnesi oluşturuldu
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        // Dizi üzerinde bazı işlemler yapabiliriz
        printArray(numbers);

        // Diziye olan referans yok ediliyor
        numbers = null; // Bu noktada diziye olan referans kayboldu
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

Yuklarıdaki kodda ise  numbers = null; ile dizinin referansına null atanmıştır. numbers değişkenin artık nesneye erişimi kalmadı demektir, bu array çöp olarak işaretlenir.  Garbage collector'un yaptığı işlemler;
 - Mark; garbage collector heapte yaşayan yani referansı olan tüm nesneleri işaretler
 - Sweep; işaretlenmeyen yani referansı olamayan nesneler bellekten silinir.
 - Compact; silinen nesnelerin yerine referansı var olan nesneler kaydırılır, sıkıştırma işlemi yapılmış olur.

Bu işlemlerin de olumsuz tarafı vardır. Garbage collector her döngüsünde heapte yaşayan nesnelerin referansı var mı yok mu diye kontrol eder. Heap'te çok fazla nesnemiz olursa donmalar meydana gelir, verimsizdir. Bu verimsizliğin önüne geçilmesi için Generational Garbage Collector'a geçilmiştir.    

• **Generational garbage collector**: heap gen:0, gen:1, gen:2 olmak üzere üç tane generation'a sahiptir. İlk allocatede nesneler için gen:0'da yer allocate edilir. Garbage collectorün ilk döngüsünde mark, sweep, compact işlemlerini gerçekleştirir. Bu işlemlerden sonra hayatlarına devam eden nesneler gen 1'e taşınır gen:1'e taşınan nesneye yeni bir eleman atadığımızı düşünürsek yeni eleman için gen:0'da yer allocate edilir. GC ikinci döngüyü gerçekleştirir. Bu generarion yapısı gen:0'da olan nesneleri sınırlamaya yardımcı olur. Her döngüde gen:0 tüm nesnelerden temizlenir. Bir sonraki döngüde önceki döngüden sonra oluşan yeni nesneleri kontrol eder. Garbage collector bir nesneyi gen:2'ye taşımışsa o nesneyi long-lived bir nesne olarak kabul eder, gen:1 ve gen:2'yi çok fazla kontrol etmez ve daha az döngü gerçekleştirir. Long-lived nesneler garbage collector'ün iki döngüsünden geçip iki tane mark, sweep, compact, move işlemlerini gerçekleştirir. Nesnelerin büyüklüğüne göre bu kopyalama işlemi performansı çok etkiler. Generational garbage collector'in performans sorununa karşılık iki çözüm; small object(SOH) ve large object heap(LOH) denilen iki ayrı heap yapısı.  

- SOH, üç generationlı yapıda kalmaya devam eder. LOH, SOH'daki gen:2 ile senkronize çalışan tek generationlı yapıdır. SOH'taki gen:2'de garbage collector döngüsü başladığında LOH'da da aynı döngü başlatılır. LOH'ta compact işlemi gerçekleştirilmez. Hangisine gideceği 85 kb değer ile belirlenir. Nesneler bu değere eşit veya büyükse LOH,değilse SOH. Böylece ekstra kopyalama işlemi yapılmaz ve performans yükselir.
  
• **Memory Allocate'i iyi yapmak için**;

- StringBuilder kullanmalıyız,
- Unboxing ve boxingten kaçınmalıyız,
- list, hashmap, dictionary gidi koleksiyonlara değer vermeliyiz,
- long-short lived diziler için ArrayPool sınıfını kullanabiliriz
- Dispose pattern kullanmalıyız. 

• **@Retention** annotation, Java Reflection API'si kullanılarak çaluışma zamanında erişilebilecek anotasyonları belirtmek için kullnılır. Bir Anotasyonun ne kadar süreyle saklanacağını belirtir. 3 farklı;  
 
 - **Source**: Anotasyon yalnızca kaynak kodda saklanır, derleme sırasında atılır.  
 -  **Class**: Anotasyon derleme sırasında saklanır, ancak çalışma zamanında kullanılmaz.   
 -  **Runtime**: Anotasyon çalışma zamanında saklanır ve kullanılır. Java Reflection API'si ile bu anotasyona erişebileceği anlamına gelir.      
 
• **@interface**: Anotasyon tanımlamak için kullanılır. Anotasyonlar meta-veri eklemek ve bu meta veriyi runtimeda ya da derleme zamanında kullanmak için kullanılır. 

```java
//Anotasyonun oluşturulması
public @interface MyCustomAnnotation {
    String value();
}
```
```java
//Anotasyonun kullanımı
@MyCustomAnnotation(value = "example")
public class ExampleClass {
    // Sınıf içeriği
}
```
Bu örnekte MyCustomAnnotation adında bir anotasyon tanımlanmıştır ve value adluı parametreye sahiptir.   


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
 • Belirli bir öğeyi bulabilmek için lineer arama yöntemidir. Time complexity:O(N) 
 
## Travelling Saleperson Problem (TSP)
 • Bir optimizasyon problemidir. Problemin çözümü için en verimli algoritmanın bilinmediği durumdur. Tüm olası çözümleri denemek için gerekir bu durumda time complexity;O(n!)'dür. Bİr gezginin belirli bir dizi şehri ziyaret ederek her birini tam bir kez geçmesi ve toplam yolculuk mesafesini minimumda tutması gereken bir optimizasyon problemidir. 
## Selection Sort
 • Şimdi 5 elemanı sıralayacağımızı düşünelim.(67,12,56,4,24). İlk eleman 67 bütün eleamnlarla karşılaştırılır. Kendisinden büyük bir sayı olmadığı için birinci sırada olur, bu işlem için 4 karşılaştır yapılır. 2. elemana geçilir ve karşılaştırılır.12, 56'dan küçük bu durumda 56 ile karşılaştırmaya devam edilir.Totelde 4 karşılaştır yapıldıktan sonra 2. sayının 56 olduğu belli olur. Bu şekilde bir bir azalarak sıralama yapılır. ilk elamnı bulmada n, ikinci elemanı bulmada n-1, üçüncü elemanı bulmada n-2 ... işlem yapılır. Bu durumda n(n+1)/2 işlem yapılır. Bu ne demek (n^2+n)/2 sabit sayılar bigO notasyonunda gösterilmediğine göre O(n^2) karmaşıklığa sahiptir. 

## Divide & Conquer
 • Euclid’s algorithm; İki pozitif tam sayının en büyük ortak böleninin bulunması(EBOB).
 • QuickSort algoritması divide&conquer mantığı ile çalışır ve oldukça hızlıdır. EKalan kullnımı yapmaz space complexity(1), time complexity: O(n*logn) . iŞLEME pivot seçimi yapılarak başlanır ancak pivot seçimi dengeli yapılmazsa worst case'de time complexity:  O(n^2)'ye gider. Pivot her seferinde listenin en büyük ya da en küçük elemanı seçilirse bu durumda bir taraf boş kalacağı için n,n-1,n-2,n-3....,1 elemanla işlem yapılması gerekir.Bu da  n(n+1)/2 tane işlem yapmamız anlamına gelir bunun karmaşıklı da O(n^2)'dir. 


 ![image](https://github.com/user-attachments/assets/8987afbc-fbc3-4667-baa8-8b914eee0367)

## Big O Notation
Big O notasyonu işlem sayısını karşılaştırmamızı sağlar. Düşük karmaşıklıktan yüksek karmaşıklığa;  
• O(1)  
• O(logn): log time olarak bilir. Örnek; binary search   
• O(n): n boyutunda bir listemiz varsa ve tek tek bütün elemanlar kontrol ediliyorsa n kere işlem yapmak gerekir. Örnek; linear time olarak bilinir. Örnek: Simple search   
• O(n*logn): Örnek: Hızlı sıralama algortimalarıdır. Quicksort gibi   
• O(n^2): Örnek: Yavaş sıralama algoritması. Selection sort gibi    
• O(2^n):  
• O(n!): yavaş algoritma. Buna travelling saleperson problem denir.   
