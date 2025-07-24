# Object Oriented Kavramlar
•  **Polimorfizm**; aynı işlemin, farklı veri tipleri veya sınıflar üzerinde farklı şekillerde çalışabilmesini sağlar. Aynı isimdeki bir metoduni farklı classlar tarafından farklı şekillerde uygulanmasına olanak verir.  
•  **Concrete Class(Somut Sınıf)**, doğrudan örneklenebilen yani new anahtar kelimesi kullanılarak bir instance'ının yani objesinin oluşturulabileceği anlamına gelir.  Bir obje yaratmak için constructor'a sahip olan ve doğrudan kullanılabilen bir sınıftır.      
• Somut metotlarda, bir alt classta override edilebilir. Ancak bazı koşulları vardır. Eğer üst sınıftaki metot final olarak tanımlanmışsa bu metot override edilemez. Somut metot public ya da protected olarak tanımlanmış olmalı, return türleri aynı olmalı, metot imzaları(isim ve parametre sayısı) aynı olmalıdır.     
•  **Abstract Class (Soyut Sınıf)**, doğrudan örneklenemezler yani new anahtar kelimesi ile bir obje oluşturulamaz. Bu sınıflar başka sınıflar tarafından genişletilebilir(extends edebilir) ve örneklenebilir. Bir class'a sadece bir abstract inherit edilebilir. Static metodlar abstract olarak tanımlanamaz.     
•  **Interface**, doğrudan örneklenemezler, bir arayüzü kullanabilmek için bir classın bu interface'i implement etmesi gerekir. Bir sınıf arayüzü implement ettiğinde arayüzde tanımlanan ve  kullanılacak olan tüm metodları gerçekleştirmek zorundadır yani gereksinimlerine göre metodu doldurmalıdır. Genellikle metod imzalarını içerirler ve metodların gerçekleştirilmesini somut classlara bırakırlar.  Java 8 ile birlikte, interfacelerde default metodlar ve static metodlar tanıtıldı.Bu metodlar, interfacelerin metodları nasıl gerçekleştireceğine dair bilgi verir.    
```java
public interface Vehicle(){
  void startEngine();
}
public class Car implements Vehicle{
  @Override
  public void startEngine(){
    System.out.println("Engine started");
  }
}
public class Main(){
  public static void main(String[] args){
    Vehicle myCar=new Car();
    myCar.startEngine();
  }
}
```
>Metod İmzası: 3 bileşeni içerir; metod adı, dönüş tipi, parametre listesi.
>```java
>public class Example{
>  //bu metodun imzası: void greet(String name)
>  public void greet(String name){
>    System.out.println("Hello,"+name);
>}
>```
     -  Interface'ler classların implement etmesi gereken method signaturlarını ve canstant değerlerini tanımalmak için kullanlır. 
      Yani interfacedeki değişpkenler her zaman "public static final" olarak tanımlanır ve başka türde değişkenler kullanılamaz.   
```java   
      public interface MyInterface{
      int value1=5; //kısaca yazmak istersek bu şekilde yazabiliriz ancak public static final int value1=5 olarak kabul edilir
      public static final int value2=10; // iki versiyonda aynı anlama gelir ce derleyici tarafından aynı şekilde işlenir. 
      }
 ```
>public, değişkenlerin interface'i implement eden tüm sınıflar tarafından erişilebilir olduğu anlamına gelir.
>static, değişkenlerin classın bir instance'ına bağlı olmadığını, dolayısıyla interface'in kendisine ait olduğunu ifade ederler.
>final, değişkenin değerinin sadece bir kez atanabileceğini ve sonra değiştirilemeyeceğini ifade eder.   

     -  Bir class'a birden fazla interface implement edilebilir.
•  **Inheritance**, nesne yönelimli programlamada bir sınıfın başka bir sınıfın özelliklerini ve davranışlarını devralmasıdır. Bu yeni bir class oluştururken mevcut bir sınıfın işlevselliğini yeniden kullanmayı ve genişletmeyi sağlar. Bu işlem **extends** anahtar kelimesi ile yapılır.
```java
public abstract class Animal {
  public abstract void makeSound();//abstract metod
  public void sleep(){//tamamlanmış metod
    System.out.println("Zzz...");
  }
}
public class Dog extends Animal{
  @Override
  public void makeSound(){//abstract metod gerçekleştiriyor
    System.out.println("Bark");
  }
}
public class Main(){
  public static void main(String[] args){
    Animal myDog = new Dog();
    myDog.makeSound();
    myDog.sleep();
  }
}
```
•  **super()**, bir classın subclassında(alt classından) constructorında, superclassının(üst classının) constructorını çağırmak için kullanılır.
```java
class Animal{
  Animal(){
    System.out.println("Animal constructor called");
  }
}
class Dog extends Animal(){
  Dog(){
    super();
    System.out.println("Dog constructor called");
  }
}
public class Main(){
  public static void main(String[] args){
    Dog dog=new Dog();
  }
}
```
>Çıktı;   
>Animal constructor called   
>Dog constructor called




# Threads
•  **Process**; word, excel veya herhangi başka bir uygulama henüz çalışmıyorken bir programdır. Programlar çalıştırıldığında process olarak nitelendirilir. Process'ler hayatlarına tek bir thread ile başlar ve bu thread'e main thread denilir. Diğer threadler ise programın çalışma esnasında sistem fonksiyonları tarafından yaratılmaktadır. 
•  **Multitasking**; bilgisayarın bir çok processi aynı anda çalıştırmasıdır.Örneğin web browser'ı çalıştırırken aynı anda spotifyın da açık olması.    
•  **Heap**; Java projeleri processe dönüştükleri zaman kendi memory space'ini yani heapini oluşturur. 
•  **Thread**; bir processin birden fazla işi aynı anda yapmasını sağlayan yapılara thread denir. Bir process bünyesinde bir ya da birden fazla thread barındırabilir.    Thread'ler aynı anda sadece tek bir işi yapabilir. Threadler processin içinde oluştuğu için processlerin olşturduğu bellek alanına direkt olarak erişim sağlayabilirler ve her threadin sadece kendisiniğn erişebileceği bir tane "thread stack"i bulunur.Threadler,in çalışma sırası jvm ve işletim sistemine bağlıdır.
> "Synchronized" anahtar kelimesini yazdığımızda o obje üstünden, o class üzerinden sadece tek bir anahtara(lock) sahip oluruz. Threatler anahtarla metoda giriyor gibi düşün ve anahtara da lock de. İki tane anahtar oluşturmak istediğinde
 ```java
public synchronized void metod1(){
  metod içeriği
}
 ```
yerine 
 ```java
public void metod1(){
 synchronized(lock1){
    metod içeriği
}
  
}
 ```

•  **Multithread**;bir process içinde bir çok thread oluşturup bir çok işi bir arada yapmaktadır.Wordde yazı yazarken aynı anda kelimelerin sayılması gibi  
•  **Concurency(eşzamanlılık)**; bir çok işimizi threadler yardımıyla paralel olarak yapabiliriz. Threadlerin paralel olarak çalışmasına concurency denir.
•  **Paralel programlama**; threadlerin çok çekirdekli işlemcilerde farklı çekirdeklerde eşzamanlı olarak çalıştırılmasıdır.
•  **Mutex(mutual exclusion)**; multithreaded  programlamada kullanılan bir senkronizasyon mekanizmasıdır. Aynı anda sadece bir thread'in belirli bir thread veya veri kaynağına erişmesini sağlar. Race Conditions(veri yarışı) ve tutarsız veri durumlarını önlemek için kullanılır. Bir thread mutex'i kitlediğinde(lock), diğer thread o mutex'i kitleyene kadar bekler. Thread işi bitiridğinde mutex'i serbest bırakır(unlock).Böylece başka bir thread bu kaynağa erişebilir. 
•  **Deadlock**; iki ya da daha fazla processin devam etmek için birbirlerinin bitmesini beklemesi ve sonuçta ikisinin de devam edememesi durumudur.   
•  **Semafor**;Birden fazla processin eş zamanlı çalışması durumunda birbirleri için risk teşkil ettikleri kritik zamanlarda birbirlerini beklemesini sağlayan mekanizmadır. 
•  **Cache**; önbellektir.Verilerin geçici olarak saklandığı, hızlı erişilebilen bir bellek alanıdır.    
•  **Memory Leak**; Artık kullanılmayan belleğin serbest bırakılmaması durumunda meydana gelir. Zamanla belleğin tükenmesine ve sistem performansının düşmesine neden olur. Birbirini işaret eden nesneler(referans döngüsü), garbage collector tarafından tespit edilemez ve bu nedenle serbest bırakılmazlar. Sonsuz döngülü işlemler memory leak'e neden olur. 
•  64 bit ve 32 bit, bir işlemcinin veya işletim sisteminin bellek adresleme kapasitesini tanımlar. 32 bitler adresleme kapasitesi 32 bittir yani 2^32 bayttır.Bu da yaklaşık olarak 4 GB'a karşılık gelir. 64 bit adresleme kapasitesi 64 bittir yani 2^64 bayttır.  








• **JavaBeans**, Java programlama dilinde yazılmış ve belirli bir standart yapıya uyan, yeniden kullanılabiliğr bileşenlerdir. Genellikle veri taşıma nesneleri(DTO) olarak veya GUI bileşenleri olarak kullanılır.    
 
  - Her java en az bir parametresiz constructor'a sahip olmalıdır.
  - Private alanlara sahip olmalıdır. Bu alanlara erişim için getter/setter metodları kullanılır. Encapsulation'ı destekler.  
  - "java.io.Serializable" interface'ini kullanarak stream'e yazılabilir hale getirir. Bu da nesnelerin dosyaya kaydedilmesini ve ağ üzerinden iletilmesini sağlar.  
  - Fields tanımlar; uygulama ve kullanıcı arabirimleri ile etkileşim için.  


## Java'da Temel Kavramlar    
• Temelde baktığımızda javada new kullanmadan obje oluşturamayız. Ancak Stringler, Arrayler, Wrapperlar, Enumlar oluştururken new kullanmadan obje oluşturabiliriz. Bu durumu reflectionlarla da sağlayabiliyoruz. Kısaca javada new anahtar kelimesi kullanmadan da obje oluşturulabilir.    
• Java'da bütün sınıflar lazy loading olarak yüklenir, ihtiyaç olmadığı sürece yüklenmez. 
• Mutuable; bir nesnenin ya da veri yapısının içeriğinin veya durumunun daha sonra değiştirilebilir olduğu anlamına gelir. İmmutable nesneler, bir kez oluşturulduktan sonra değiştirilemeyen nesnelerdir. 
Java'da mutuable nesneler; 
> ArrayList, HashMap, Vustom Mutuable Class
Java'da immutable nesneler;
> String, Wrapper Classes(Integer, Boolean, Double, vb.), LocalDate, LocalTime(java.time)
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
• **Stateless**, hiçbir durum bilgisini saklamaz. Her işlem bağımsızdır ve kendi bağlamında değerlendirilir. Örneğin; RESTful API  genellikle stateless bir yapıya sahiptir, çünkü her istek kendi başına eline alınır.   Stateless(durumsuz) yapı, client ile server veya hizmetler arasında gerçekleşen her bir etkileşimin birbirinden bağımsız olduğunu ve oturum veya bağlam bilgisi taşımadığını ifade eder. Herhangi bir bağımsız işlemin veya isteğin bağımsız bir şekilde çalışabilmesi, sistemlerin daha esnek, ölçeklenebilir ve yönetilebilir bir şekilde çaluışabilmesi, sistemlerin daha esnek, ölçeklenebilir ve yönetilebilir olmasını sağlar. HTTP, stateless bir protokoldür. Bu her HTTP isteğinin bağımsız olduğu ve sunucunun önceki istekler hakkında bilgi tutmadığı anlamına gelir. RESTful Servisler, rest(Representational State Transfer) mimarisi, stateless yapı üzerine kuruludur. Her bir RESTful API isteği, gerekli yetkilendirme bilgilerini ve diğer gerekli verileri taşır.   

• **Atomic Integer**, java.util.concurrent.atomic paketinde bulunan bir sınıftır. Bu class multithreading programlarda paylaşılan bir integer'ın güvenli bir şekilde arttırılması veya azaltılması gerektiği durumlarda kullanılır.
```java
AtomicInteger counter=new AtomicInteger(0);
counter.incrementAndGet();//arttırma işlemi
counter.decrementAndGet();//azaltma işlemi
```
•  **()->**, java 8  ve sonraki sürümlerde sunulan bir fonksiyonel programlama özelliğidir. Java dilindeki fonksiyonel arayüzlerin (interface) kullanımını kolaylaştırır. _Bir lambda ifadesi, interface'in işlevselliğini tanımlayan küçük bir kod bloğudur._ Lambda ifadesi genellikle bir fonksiyonun işlevselliğini bir başka yöntem veya sınıf içine yazmak yerine doğrudan bir değişkene atamak veya bir metoda geçirmek için için kullanılır.Parametre listesi ve kod bloğundan oluşur. "->" lambda ifadesinin parametreleri ve kod bloğu arasında ayrım sağlar."()->" ifadesi hiçbir parametre almayan bir lambda ifadesidir. Kod bloğu boş olduğunda ()->{} yerine ()-> kullanılabilir. 
```java
List<String> liste=new ArrayList<>();
liste.add("elma");
liste.add("cilek");
liste.forEach((String meyve)->System.out.println(meyve));
```
  - Burada forEach metodu "Consumer" adında bir interface beklemektedir.("Consumer" interface'i, genellikle bir işlem yapmak için bir girdi değerine ihtiyaç duyudulduğunda kullanılır. Örneğin;listedeki her bir öğe için bir işlem yapmak istiyorsak "Consumer" interface'i kullanılabilir.)  
  - Consumer, bir girdi değeri alır ve herhangi bir değer döndürmez.forEach metodu,"Consumer" interface'ine sahip bir nesne bekler ve listedeki her öge için Consumer'ın abstractı "accept" metodunu çağırır.

  - •  **ChangeListener**, bir ObservableValue içerisindeki değişiklikleri dinlemek ve bu değişikliklere tepki vermek için kullanılır. ObservableValue'aki değişikliği dinler ve changed metodunu uygular. Changed metodu dinlenen değerde bir değişiklik olduğunda otomatik olarak çağırılır.    
•  **BooleanProperty**, JavaFX kütüphanesindeki bir abstract classtır. Boolean tipinde bir değeri temsil eder ve binding, dinleyici eklem gibi özellikleri vardır. Abstract bir class olduğu için doğrudan kullanılamaz. Bunun yerine impleBooleanProperty gibi somut classları(concrete class) kullanır. 

•  **SimpleBooleanProperty**, JavaFX kütüphanesinde yer alan bir boolean değerini temsil eden ve yönetmek için kullanılan bir sınıftır. Bir checkbox'ın etkinlik durumunu , bir textfieldın içeriğinin boş olup olmadığını, bir ilerleme çubuğunun ilerleme durumunu takip etmek için ve veri bağlamak için(bind) kullanılabilir. Değer değişikliklerini dinleyen bir dinleyiciye sahiptir.    
```java
addListener(ChangeListener <? super Boolean> listener)
```
Dinleyiciyi kaldırmak için;  
```java
removeListener(ChangeListener <? super Boolean> listener)
``` 
Veri bağlamak için;   
```java
bind(Binding <? super Boolean> observable)
``` 
•  **Unsafe.class:** Java programlama dilinde bellek yönetimi ve diğer güvenliği atlanabilecek olan fonksiyonları içerir. Bu sınıf genellikle güvenli olmayan ve performansı artırmak isteyen uygulamalar için kullanılır. Ancak bu class'ın kullanımı güvenlik açıklarına ve program hatalarına neden olabilir.   
•  **SwingUtilities.invokeLater**: Java'da Swing GUI uygulamaları için kullanılan bir metoddur. Bu metod, GUI komponentlerinin ekranda görüntülenmesi ve güncellenmesi gerektiğinde kullanılır. Swing GUI uygulamaları, **Java event dispatch thread(EDT)** üzerinde çalışır. EDT, Swing komponentlerinin oluşturulması, görüntülenmesi ve güncellenmesi gibi görevleri yerine getirmek için tasarlanmıştır. Ancak, GUI komponentleri güncellendiğinde veya yeniden çizildiğinde, bir başka thread tarafından oluşan verileri kullanmak isteyebiliriz. Bu durumda, SwingUtilities.invokeLater metodu kullanılabilir. _Bu metod, verilerin Java event dispatch tarafından kullanılabilir hale gelmesini bekler ve bu verileri kullanarak GUI komponentlerini güncellemimizi sağlar._   
•  Java Swing, GUI bileşenlerinin işletim sistemi arayüzüne erişmek için özel bir thread kullanır. Bu thread, Swing olaylarını işlemek, bileşenlerin çizimlerini güncellemek, kullanıcı etkileşimlerini işlemek gibi görevleri yönetir. Ancak bu thread, main thread'den ayrı bir threaddir. Bu nedenle thread güvenliği sorunları ortaya çıkabilir._**InvokeLaterDispatch class'ı ** bu sorunları önlemek için tasarlanmıştır. Bu class, Swing bileşenlerinin main thread'e erişimini yönetir ve bu bileşenlerin sadece main thread üzerinde çalışmasını sağlar._ Böylece Swing bileşenlerinin işletim sistemi arayüzüne erişimi, doğru bir şekilde koordine edilerek yapılır ve thread güvenliği sağlanır.  **SwingUtilities.invokeLater()** metodu, arayüz bileşenlerinin işlemlerini main thread2e gönderir.    
•  **Platform.runLater**: JavaFX uygulamalarında kullanılan bir yöntemdir ve belirtilen işlevi JavaFX uygulama threadinden farklı bir zaman diliminde çalıştırmak için kullanılır. Bu yöntem, bir olay veya işlem nedeniyle uygulamanın main thread üzerinde yavaşlamalarveya donmalar yaşanmasını önlemek için kullanılır. _Platform.runLater yöntemi, belirtilen işlevi JavaFX uygulama threadindeki sonraki boş bir zaman diliminde çalıştırmak için bir istek sırasına yerleştirir._ Bu nedenle, Platform.runLater yöntemi çağırıldığında belirtilen işlev hemen çalıştırılmaz, ancak bir sonraki fırsatta çalıştırılır. 
```java
Platform.runLater(()->{
//Bu kod bloğu, JavaFX uygulama threadinde çalıştırılır. Yavaşlatıcı işlemler bu blog içerisinde gerçekleştirilmemelidir. 
});
```

•  Java'da "EventHandler" sınıfının "handle" metoduna **EventHandler.handler(new Event("Enter",null, null))** şeklinde bir parametre geçtiğimizde
- "Enter": Bu oluşturulan event nesnesi türünü temsil eder. Olay türü genellikle bir olayın ne olduğunu belirtmek için kullanılan bir dizedir. Örneğin, kullanıcı bir tuşa basarsa ve bu olayı temsil etmek istiyorsa "keyPress"" veya ""keyRelease" gibi olay türü kullanabiliriz.
- Birinci null: oluşturulan event nesnesinin kaynağını temsil eder. Olayın kaynağı, genellikle nerede meydana geldiğini belirtmek için kullanılır. Örneğin, bir butona tıklama olayını temsil ediyorsanız, buton nesnesini kaynak olarak belirtebiliriz.
- İkinci null: bu oluşturulan event nesnenin ilgili verilerini temsil eder.Olaya özgü veriler,olaytürüne bağlı oalrak farklı şekillerde olabilir. Örneğin, bir fare tıklama olayı için, tıklama koordinatlarını içeren bir "mouseEvent" nesnesi verilebilir.
  
•  **PlatformImpl.class**, JavaFX runtime'ın main thread'ini yönetir. JavaFX uygulama threadinden farklı thread'de çalışan işlevleri sağlar. Uygulamanın çıkış yapmasından önce sonlandırılır. 



•  **Dispatcher(Dağıtım) Mekanizması:** Belirli bir isteğin veya olayın yönlendirilmesi ve işlenmesi ile ilgili bir mekanizmadır. MVC mimarisinden dispatch, istemciden gelen bir isteğin doğru   Controller'ı veya işlem birimini bulup işlemesini sağlamak için kullanılan terimdir. İstemci isteği, Dispatcher'a gelir. Dispatcher, isteği analiz eder ve hangi Controller'ın çağırılması gerektiğine karar verir. Controller isteği işler ve uygun komutu(genelde Command pattern ile) çağırır. Controller, iş mantığını çalıştıktan sonra Model ile güncelleme yapar ve uygun View'i render eder.      
    


## Annotation
• Java diline ve Java komutlarına ek bilgi eklemek için kullanılan ifadelerdir. Eklenen bu ek bilgiler komutların çalışmasını değiştirmeyecektir. Ancak Java Reflection yapısı kullanılarak annotation bilgileri alınır ve işlem yapılabilir. Bildirim için @ eklenmesi yeterlidir. 
```java
public @interface AnnotationAdi{//bu şekilde annotation oluşturulur. 
veri-tipi adı();
} 
```

  - **@Override:** Derleyiciye metodun ezildiğini bildirir. 
  - **@Depricated:** Bir metodun kullanımdan kaldırıldığını bildirmek için kullanılır. 
  - **@SuppressWarnings:** Bu annocation derleyicinin bir uyarısını veya hatasını görmezden gelmesini sağlar. Bu bazı durumlarda programcıların, belirli bir uyarının önemsiz olduğunu ve dikkate alınmaması gerektiğini belirtmelerini sağlar. Bu uyarıya sebep olan kodun tür güvenliğini tehlikeye atmadığından eminsek @SupressWarnings("uncheched") notasyonu kullanılarak bu uyarıyı gizleyebiliriz. Kod uyarı vermeden derlenmiş olur. Ancak tür güvenliğini tehlikeye atıyorsa ClassCastException hatası fırlatır.
  -  **@FunctionalInterface:** Bu annotation, bir arayüzün fonksiyonel bir arayüz olduğunu belirtir. Bu Java8'den beri kullanılır. lambda ifadeleri ve diğer fonsiyonel programlama özellikleri gibi fonksiyonel arayüzlerin kullanımını kolaylaştırır. 


## MVC Mimarisi 
•  **MVC(Model-View-Controller)** bir tasarım desenidir. Bu tasarım deseni, bir yazılım uygulamasını üç ana bileşene ayırarak, uygulamnın geliştirilmesini, bakımını ve test edilmesini kolaylaştırır.MVC mimarisi şu şekilde çalışır;   
  - **Model:** Uygulamanın verilerinin tutulduğu bileşendir. Veritabanı veya dosya gibi kalıcı veri kaynaklarına erişebilirler. E-ticaret uygulamasını ele alırsak; bu uygulamanın model bileşeni ürünlerin, müşterilerin, siparişlerin ve stokların verilerini tutar. Bu veriler, veritabanı veya dosya gibi kalıcıveri kaynaklarına depolanabilir. Model bileşeni verilerin doğru bir şekilde işlenmesinden ve yönetilmesinden sorumludur.     
  - **View:** Kullanıcının uygulamayı kullanarak gördüğü bileşendir. JavaFX bileşenleri(örneğin;label,button,textfield) kullanarak oluşturulur.    
  - **Controller:** Model ve View arasında bir bağlantı oluşturarak, kullanıcın yaptığı işlemleri işler.Controller bileşeni, kullanıcının yaptığı eylemleri alır ve Model bileşeninin verilerini güncellemek için kullanılır.Örneğin; kullanıcının bir ürünü sepete eklemesi durumunda, Controller bileşeni, Model bileşenindeki sepet verilerini günceller.**Kısaca Controller bileşeni istemciden gelen istekleri(request) işlemek amacıyla kullanır**. Dispatcher mekanizması, Controller'ın arkasında yer alarak gelen istekleri uygun iş mantığına -genellikle Command pattern ile tanımlanan- yönlendirmede önemli bir rol oynar. Bu noktada, Command pattern'ı kullanmak, işlemlerin soyutlanmasına ve bakımın kolaylaştırılmasına yardımcı olur.

## Callback 
•  **CallBack interface**,  bir işlemin tamamlanmasının ardından belirli bir kodun çalıştırılmasını sağlar. Belirli bir girdiyi alıp belirli bir çıktıyı döndüren fonksiyonel arayüzdür.
```java
public interface Calback<InputType, OutputType>{
  OutputType call(InputType param);
}   
```  
•  **call()**, her hücre için bir Cell nesnesi oluşturur ve geri döndürür.  public ListCell<String> call(ListView<String> listView) böümünde her hücre için ListCell<String> nesnesi oluşturur ve döndürür.     
•  **Synchronous Callback**;ana işlem tamamlanana kadar bekler sonra callback fonksiyonunu çağırır.CallBack fonksiyonu çağırılana kadar ana işleme devam edilmez ve işlem sırası bloklanır.    
•  **Asynchronous Callback**; ana işlem devam ederken başlatılır ve callback fonksiyonu işlemin tamamlanmasından sonra çağrılır. Ana işlem callback fonksiyonunun tamamlanmasını beklemez.   
•  **SetCellFactory()**, liste, tablo veya ağaç veri yapılarında hücrelerin nasıl görüntüleneceğini ve davranacağını özelliştirmek için kullanılır. ListView, TableColumn vs. öğesinin hjücrelerini özelleştirmek için setCellFactory, Callback interface'ini kullanır. Bötylece her ListCell, TableCell ... nesnesinin  nasıl oluşturulacağını ve güncelleneceğini tanımlar.
```java
listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>(){
  @Override
  public ListCell<String> call(ListView<String> listView){
    return new ListCell<String>(){
      @Override
      protected void updateItem(String item, boolean empty){//Hücre içeriği burada güncellenir.
                                                            //item hücre içeriği, empty hücrenin boş olup
                                                            //olmadığını belirten boolean değer
        super.updateItem(item,empty);
        if(item!=null){
        ...
        } else {
        ...
        }
      }
    }
});
```
 
## Stream
• **Stream**: Bir veri kaynağından elde edilen sıralı bir veri akışıdır. Streamler lazy'dir. Yani veriler üzerinde işlem yapmadan önce işlem dizisi oluşturulur ve bu dizi ihtiyaç duyulduğunda çağırılır. Böylece kaynakların kullanımının daha verimli olması sağlanır.  Veri okuma, yazma işlemlerini çaşitli kaynaklardan hızlı ve verimli bir şekilde gerçekleştirmek için kullanılır. Java streamleri verilere üst düzey erişim sağlar ve farklı veri biçimlerine kolayca uyum göstermesini sağlar.  Stream API; koleksiyonlar üzerinde filtrelemeler, dönüşümler ve işlemler yapmayı daha kolay ve okunabilir hale getirir. 
   
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

• **Atomic Metotlar;** genellikle entitylerin içindedir. Birden fazla atomic metodu koordine eden yapılar bir üst katmanda olabilirdi. 

## Diğer Teknolojiler Hakkında Bilgiler 
 •  **Tomcat**: Apache Tomcat veya Tomcat Jva tabanlı web uygulamalarını yayınlamak için kullanılan web sunucusudur. Java Servlet, JavaServer Pages(JSP), Java Expression Language, Java Standart Tag Library(JSTL) gibi teknolojileri destekler. _Tomcat'in temel görevi, web uygulamalarının istemcilere sunulmasını sağlamaktır._ Bu uygulamalar, bir web sunucusuna yüklenir ve Tomcat'in çalışması sayesinde istemciler tarafından tarayıcılarda görüntülenebilir hale gelir. Tomcat, bir çook platformda çalışabilir ve Java tabanlı olduğu için Java Virtual Machine(JVM) üzerine çalışır.   
•  **Hibernate**: Java programlama dili için geliştirilmiş bir ORM(Object Relational Mapping) aracıdır. ORM, nesne yönelimli(OOP) ve ilişkisel veritabanı arasındaki farklılıkları ortadan kaldırmak için kullanılır. Hibernate, veritabanı işlemlerin OOP prensipleri ile gerçekleştirmeyi sağlar. 
  
  - Veritabanı işlemlerinin programlama düzeyinde yapılandırılmasına izin verir. Nesneler arasındaki ilişkiler, Hibernate tarafından veritabanında uygun şekilde saklanır. 
  - Veritabanı işlemlerini gerçekleştirmek için SQL sorguları oluşturur, veritabanı işlemlerini tamamlanır.
  - Veritabanı işlemlerindeki tekrarları azaltır ve böylece geliştiricilerin daha az kod yazmalarına olanak tanır.
  - Açık kaynak kodlu bir yazılımdır ve Java için kullanılabilir.
  - Veritabanındaki kaynak kodlu bir yazılımdır ve Java için kullanabilir.
  - Veritabanındaki tablolar ile classları eşleştirir.Classlar üzerinden veritabanındaki nesneleri map ederek(ilişkilendirerek) verileri hızlıca insert, update, delete ve select edebilmemizi sağlar.   

•  **JDBC(Java Database Connective)**: Java programlama dilinde veritabanlarına erişmek ve bu veritabanlarıyla etkileşim kurmak için kullanılan bir API'dir.JDBC,SQL sorgularını çalıştırabilen ve sonuçlarını alma yeteneği olan bir ara birim sağlar. 
   
   -Java Application --> JDBC --> Oracle Driver       --> DB(Oracle, MySql)
                                  Sql Server Driver
   -JDBC, bir veritabanı driver app'yı sağlar ve bu veritabanı driver'ı belirli bir veritabanı sistemine özgü olan kodları içerir. Bu nedenle, JDBC farklı veritabanı bağlanmak için aynı API'yı kullanarak darklı driverlar kullanabilir. 
• **Java Reflection API**, Java programının runtimeda classları, metodları ve alanları inceleyerek bunlar üzerinde dinamik olarak işlem yapabilmesine olanak sağlayan mekanizmadır. Class'ın yapısını (method, constructor) runtime'da öğrenmek için kullanılır. 
•  Yazılım mühendisliğinde design priciple ve design pattern aynı şeyler değildir. 
  
  - Design principle, daha iyi uygulamalar tasarlayabilemek için üst düzey kurallar sağlar.
  - Design pattern, yaygın olarak ortaya çı8kan nesne yönelimli problemlerin implementasyonu ile ilgili low-level çözümler sağlar. 

•  JavaFX uygulamaları, "Application.class" kullanarak başlatılır. Bu class, uygulamanın başlangıç noktasıdır ve start() metodu çağırarak uygulamayı başlatır. Application classı, start() metodunun içinde "PlatformImpl" classına veya diğer ilgili sınıflara doğrudan erişmez. Bunun yerine, JavaFX'ın arkasındaki mekanizmelar start() metodu içinde otomatik olarak çalışır.   
•  JavaFX'in arkasındaki mekanizmaların bir kısmı, "PlatformImpl" classı tarafından yönetilir. PlatformImpl.class, JavaFX'in platforma özgü işlemlerini gerçekleştirir ve gerekli ön hazırlıkları yapar. Bu ön hazırlıklar arasında, uygulamanın çalıştığı platforma göre farklılık gösterebilecek işlemler yer alabilir.   
•  JavaFX uygulamaları, platform bağımsız olduğu için, JavaFX runtime'ın farklı işletim sistemleri için uygun olan platform özelliklerine erişebilmesi için bir yol sağlaması gerekir. Bu işlem, JavaFX uygulama threadinden ayrı bir thread'de gerçekleştirilir ve PlatformImpl.class tarafından yönetilir.  

•  **JSF(JavaServer Faces):** Kullanıcı arayüzü bileşenlerini oluşturmak için kullanılan bir frameworktür. MVC mimarisini kullanarak, geliştiricilere web uygulamalarının hızlı bir şekilde geliştirilmesine yardımcı olur. Hibernate ve spring gibi teknolojilerle birlikte çalışabilmektedir. JSF nasıl çalışır;

  -  **Controller:**  Gelen istekleri controller katmanında yer alanservlet arayüzünü uygulayan-implement eden javax.faces.webapp.facesServlet sınıfı tarafından yönetilir.JSF sayfları genellikle .xhtml ve .jsf uzantısı ile hazırlanır.JSF sayfalarının işlenmesi için web.xml ayarı ile JavaServlet tarafından yönetileceği belirtilir. Gelen istekler eşleştikten sonra JSF sayfalarının yer aldığı view katmanı derlenerek istemciye gönderilir. 
```html
<servlet>
  <sevlet-name>Faces Servlet</servlet-name>
  <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
  <load-on-startup>1</load-on-startup>
</servlet>
```
  - **View:** View katmanında web sayfalarını oluşturmak için çeşitli JSF bileşenleri etiketleri kullanılır. JSF etiketlerini HTML etiketlerinden ayıran en önemli özellik; Model katmanında yer alan ve Managed Bean olarak adlandırılan Java komutları ile bağlantı kurmayı sağlamasıdır.
  - **Model:** Bu katmanda sınıflar bazı kuralları olan sıradan Java sınıflarıdır. 
>Parametresi constructor'ı olmalıdır.  
>Serializable arayüzünü uygulamalıdır.  
>Her bir sınıf özelliğine ait get ve set metodu olmalıdır.  
>View katmanı ile bağlantı için @Named annocation veya XML ayarları kullanılmalıdır.    


## Diğer Kavramlar 
• **Specification:** Bir yazılım bileşeninin veya sisteminin ne yapması gerektiğini tanımlayan bir belgedir. Geliştirilen yazılımın hedeflerini, özelliklerini ve davranışlarını belirler. Kullanıcı ihtiyaçlarını anlamak ve geliştirme sürecine rehberlik etmek için kullnılır. 
• **Implementation:** Yazılımın nasıl oluşturulduğunu ve kodlarını ifade eder. Spesifikasyonun belirtilen gereksinimlerin somut, çalışır durumdaki bir yazılım ürününe dönüşmesini sağlar. 
