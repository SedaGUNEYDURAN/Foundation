# Temel Bilgiler 
## CallBack   
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
 
•  **ChangeListener**, bir ObservableValue içerisindeki değişiklikleri dinlemek ve bu değişikliklere tepki vermek için kullanılır. ObservableValue'aki değişikliği dinler ve changed metodunu uygular. Changed metodu dinlenen değerde bir değişiklik olduğunda otomatik olarak çağırılır.    
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
•  JavaFX uygulamaları, "Applicatiın.class" kullanarak başlatılır. Bu class, uygulamanın başlangıç noktasıdır ve start() metodu çağırarak uygulamayı başlatır. Application classı, start() metodunun içinde "PlatformImpl" classına veya diğer ilgili sınıflara doğrudan erişmez. Bunun yerine, JavaFX'ın arkasındaki mekanizmelar start() metodu içinde otomatik olarak çalışır.   
•  JavaFX'in arkasındaki mekanizmaların bir kısmı, "PlatformImpl" classı tarafından yönetilir. PlatformImpl.class, JavaFX'in platforma özgü işlemlerini gerçekleştirir ve gerekli ön hazırlıkları yapar. Bu ön hazırlıklar arasında, uygulamanın çalıştığı platforma göre farklılık gösterebilecek işlemler yer alabilir.   
•  JavaFX uygulamaları, platform bağımsız olduğu için, JavaFX runtime'ın farklı işletim sistemleri için uygun olan platform özelliklerine erişebilmesi için bir yol sağlaması gerekir. Bu işlem, JavaFX uygulama threadinden ayrı bir thread'de gerçekleştirilir ve PlatformImpl.class tarafından yönetilir.  
•  Java'da "EventHandler" sınıfının "handle" metoduna **EventHandler.handler(new Event("Enter",null, null))** şeklinde bir parametre geçtiğimizde
- "Enter": Bu oluşturulan event nesnesi türünü temsil eder. Olay türü genellikle bir olayın ne olduğunu belirtmek için kullanılan bir dizedir. Örneğin, kullanıcı bir tuşa basarsa ve bu olayı temsil etmek istiyorsa "keyPress"" veya ""keyRelease" gibi olay türü kullanabiliriz.
- Birinci null: oluşturulan event nesnesinin kaynağını temsil eder. Olayın kaynağı, genellikle nerede meydana geldiğini belirtmek için kullanılır. Örneğin, bir butona tıklama olayını temsil ediyorsanız, buton nesnesini kaynak olarak belirtebiliriz.
- İkinci null: bu oluşturulan event nesnenin ilgili verilerini temsil eder.Olaya özgü veriler,olaytürüne bağlı oalrak farklı şekillerde olabilir. Örneğin, bir fare tıklama olayı için, tıklama koordinatlarını içeren bir "mouseEvent" nesnesi verilebilir.
  
•  **PlatformImpl.class**, JavaFX runtime'ın main thread'ini yönetir. JavaFX uygulama threadinden farklı thread'de çalışan işlevleri sağlar. Uygulamanın çıkış yapmasından önce sonlandırılır. 

•  **MVC(Model-View-Controller)** bir tasarım desenidir. Bu tasarım deseni, bir yazılım uygulamasını üç ana bileşene ayırarak, uygulamnın geliştirilmesini, bakımını ve test edilmesini kolaylaştırır.MVC mimarisi şu şekilde çalışır;   
  - **Model:** Uygulamanın verilerinin tutulduğu bileşendir. Veritabanı veya dosya gibi kalıcı veri kaynaklarına erişebilirler. E-ticaret uygulamasını ele alırsak; bu uygulamanın model bileşeni ürünlerin, müşterilerin, siparişlerin ve stokların verilerini tutar. Bu veriler, veritabanı veya dosya gibi kalıcıveri kaynaklarına depolanabilir. Model bileşeni verilerin doğru bir şekilde işlenmesinden ve yönetilmesinden sorumludur.     
  - **View:** Kullanıcının uygulamayı kullanarak gördüğü bileşendir. JavaFX bileşenleri(örneğin;label,button,textfield) kullanarak oluşturulur.    
  - **Controller:** Model ve View arasında bir bağlantı oluşturarak, kullanıcın yaptığı işlemleri işler.Controller bileşeni, kullanıcının yaptığı eylemleri alır ve Model bileşeninin verilerini güncellemek için kullanılır.Örneğin; kullanıcının bir ürünü sepete eklemesi durumunda, Controller bileşeni, Model bileşenindeki sepet verilerini günceller.
    
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

•  **Annotation:** Java diline ve Java komutlarına ek bilgi eklemek için kullanılan ifadelerdir. Eklenen bu ek bilgiler komutların çalışmasını değiştirmeyecektir. Ancak Java Reflection yapısı kullanılarak annotation bilgileri alınır ve işlem yapılabilir. Bildirim için @ eklenmesi yeterlidir. 
```java
public @interface AnnotationAdi{//bu şekilde annotation oluşturulur. 
veri-tipi adı();
} 
```

  - **@Override:** Derleyiciye metodun ezildiğini bildirir. 
  - **@Depricated:** Bir metodun kullanımdan kaldırıldığını bildirmek için kullanılır. 
  - **@SuppressWarnings:** Bu annocation derleyicinin bir uyarısını veya hatasını görmezden gelmesini sağlar. Bu bazı durumlarda programcıların, belirli bir uyarının önemsiz olduğunu ve dikkate alınmaması gerektiğini belirtmelerini sağlar. Bu uyarıya sebep olan kodun tür güvenliğini tehlikeye atmadığından eminsek @SupressWarnings("uncheched") notasyonu kullanılarak bu uyarıyı gizleyebiliriz. Kod uyarı vermeden derlenmiş olur. Ancak tür güvenliğini tehlikeye atıyorsa ClassCastException hatası fırlatır.
  -  **@FunctionalInterface:** Bu annotation, bir arayüzün fonksiyonel bir arayüz olduğunu belirtir. Bu Java8'den beri kullanılır. lambda ifadeleri ve diğer fonsiyonel programlama özellikleri gibi fonksiyonel arayüzlerin kullanımını kolaylaştırır. 

•  **()->**, java 8  ve sonraki sürümlerde sunulan bir fonksiyonel programlama özelliğidir. Java dilindeki fonksiyonel arayüzlerin (interface) kullanımını kolaylaştırır. _Bir lambda ifadesi, interface'in işlevselliğini tanımlayan küçük bir kod bloğudur._ Lambda ifadesi genellikle bir fonksiyonun işlevselliğini bir başka yöntem veya sınıf içine yazmak yerine doğrudan bir değişkene atamak veya bir metoda geçirmek için için kullanılır.Parametre listesi ve kod bloğundan oluşur. "->" lambda ifadesinin parametreleri ve kod bloğu arasında ayrım sağlar."()->" ifadesi hiçbir parametre almayan bir lambda ifadesidir. Kod bloğu boş olduğunda ()->{} yerine ()-> kullanılabilir. 
```java
List<String> liste=new ArrayList<>();
liste.add("elma");
liste.add("cilek");
liste.forEach((String meyve)->System.out.println(meyve));
```
  - Burada forEach metodu "Consumer" adında bir interface beklemektedir.("Consumer" interface'i, genellikle bir işlem yapmak için bir girdi değerine ihtiyaç duyudulduğunda kullanılır. Örneğin;listedeki her bir öğe için bir işlem yapmak istiyorsak "Consumer" interface'i kullanılabilir.)  
  - Consumer, bir girdi değeri alır ve herhangi bir değer döndürmez.forEach metodu,"Consumer" interface'ine sahip bir nesne bekler ve listedeki her öge için Consumer'ın abstractı "accept" metodunu çağırır.   

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
   
•  Yazılım mühendisliğinde design priciple ve design pattern aynı şeyler değildir. 
  
  - Design principle, daha iyi uygulamalar tasarlayabilemek için üst düzey kurallar sağlar.
  - Design pattern, yaygın olarak ortaya çı8kan nesne yönelimli problemlerin implementasyonu ile ilgili low-level çözümler sağlar. 
• **Atomic Integer**, java.util.concurrent.atomic paketinde bulunan bir sınıftır. Bu class multithreading programlarda paylaşılan bir integer'ın güvenli bir şekilde arttırılması veya azaltılması gerektiği durumlarda kullanılır.
```java
AtomicInteger counter=new AtomicInteger(0);
counter.incrementAndGet();//arttırma işlemi
counter.decrementAndGet();//azaltma işlemi
```

•  **Concrete Class(Somut Sınıf)**, doğrudan örneklenebilen yani new anahtar kelimesi kullanılarak bir instance'ının yani objesinin oluşturulabileceği anlamına gelir.  Bir obje yaratmak için constructor'a sahip olan ve doğrudan kullanılabilen bir sınıftır.   
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


•  **Software Development Life Cycle(SDLC)**: Yazılım projelerinin yönetimi ve geliştirilmesi için kullanılan, yapılandırılmış ve sistematik bir süreçtir.Temel aşamaları; planlama,gereksinim analizi, tasarım, geliştirme, test, dağıtım, bakım. Farklı projeler ve farklı gereksinimler için farklı SDLC modelleri bulunur;
>**Waterfall(Şelale) Modeli**; aşamaların sırasıyla ve birbirini takip ederek ilerlediği, geri dönüşün zor oldu modeldir.  
>**Agile(Çevik) Modeli**; esnek ve iteraktif bir yaklaşımla, sürekli geri bildirim ve iyileştirme sağlayan modeldir.  
>**Spiral Modeli**; risk analizi ve protiplemeye odaklanan, iteraktif ve döngüsel bir yaklaşımdır.  
>**V modeli**; test faaliyetlerinin geliştirme faaliyetleriyle paralel olarak yürütüldüğü modeldir.

•  **Plastik Software Configuration Management**, bir yazılım konfigürasyon yönetim aracıdır(Git, SVN gibi düşün ). Dağıtık(distributed) ve merkezi(centralized) sürüm kontrol sistemlerinin avantajlarını birleştirerek yüksek performanslı ve ölçeklenebilir bir çözüm sunar.Conflictleri tespit eder ve çözer.   
•  **Asana**, ekiplerin projelerini ve görevlerini planmasına, izlemesine ve yönetmesine yardımcı olan bir proje yönetim yazılımıdır(Jira gibi).  
•  **DOORS(Dynamic Object-Oriented Requirements System)**, gereksinim yönetimi için güçlü ve kapsamlı bir çözümdür. Gereksinimlerin toplanması, izlenmesi, değişiklik yönetimi ve işbirliği gibi kritik süreçlerde etkinlik sağlar.   
•  Neden veri yapıları kullanırız? Veri yapıları bilgisayar bilimlerinin temellerini oluşturur. Verinin etkin bir şekilde yönetilmesini, işlenmesini ve analiz edilmesi için önemlidir. Yazılım geliştiriciler doğru veri yapılarını kullanrak uygulamaların performansını ve verimliliğini arttırabilir.    
•  **Stack**, LIFO(Last In, First Out) prensibi ile çalışır.Dizi ve linked list mantığın ile oluşturulabilirler.Stack işlemleri;     
 > Push: stack'e eleman ekleme işlemi yapar, yeni eklenen eleman top olur.  
 > Pop: stack'ten eleman çıkarır, top elemanı çıkarır.  
 > Peek: kullanıcıya veri ödndürür, top elemanını döndürür.

•  **Queues**, FIFO(First In, First Out) prensibi ile çalışır. poll() metodu kuyruktaki en alttaki öğeyi yani en önce giren ögeyi döndürür ve sile. Kuyruk boş olduğunda bir exception fırlatmaz, null değeri döndürür.    
•  **HashMap**, Key-Value çiftlerini hızlıca aramak için kullanılır. Her key'e karşılık gelen bir değer bulunur. Anahtar unique'tir, bir değer birden fazla olabilir. Elemanları ekleme sorasına göre depolamaz. 
•  **Linked HashMap**, gönderilen değerler ekleme sırasına göre eklenir.   
•  **TreeMap**, gönderilen değerler keylerine göre küçükten büyüğe doğru sıralanarak depolanır.   
•  **Concurrent HashMap**, birden fazla thread herhangi bir bir komplikasyon olmadan tek bir nesne üzerinde çalışabilir. Bir anahtar veya değer olarak boş nesneler eklemek mümkün değildir. ConcurrentHashMap nesnesini kitlemeden bir okuma işlemi için herhangi bir sayıda thread uygulanabilir. Ancak obje güncellemek için thread'in, thread'in çalışmak istediği belirli segmenti kitlemesi gerekir. Bu tür locking mekanizmasına "segment lockig"  or "bucket locking" denir. ConcurrentHashMap nesnesi, concurrency levela göre bir dizi segmente bölünür. Varsayılan concurrency level'ı 16'dır. Bu nedenle bir seferde 16 update işlemi threadler tarafından gerçekleştirilir. 
>Concurrency Level; eşzamanlı olarak mapi güncelleyen thread sayısı.  

•  **Binary Search Tree(İkili Arama Ağacı)**, ilk önce kök düğüm oluşturulur. Sadece sağ ve sol çocuklar eklenir. Sol çocuklar daima parenttan küçük olmalıdır. Sağ çocuklar parent'tan büyük olmalıdır. Her eklenen düğüm leaf durumundadır(leaflerin çocuğu olmaz). Arama yapıldığında karşılaştırılmaya roottan başlanır. Karmaşıklığı Big O(logn). Delete ve insert işlemlerinin maaliyetleri yüksektir. Denge sorunu vardır.    
  
  -isLeaf();Bir ağaç veri yapısında belirli bir düğümün yaprak düğüm olup olmadfığını kontrol etmek için kullanılır. Yaprak düğümler, hiçbir alt düğüme sahip olamyan son düğümlerdir.
  
•  **Heap**, binary tree üzerine kuruludur. Full complete tree doldurma yapmaktır amaç(yukarıdan aşağıya, soldan sağa doldurma işlemi yapılır.). İki türü vardır;
>Max heap: parent düğümü child düğümünden büyük ya da eşit olmalıdır.   
>Min heap ; parent düğümü child düğümünden küçük ya da eşit olmalıdır.
 
•  **Linked List**, Saklanan veriler kendisinden sonra gelen veriyi işaret etmek zorundadır. Her düğüm 2 değer tutar: içinde tutacağı değer ve sonraki düğümü gösteren pointer-referans değer. Dinamik bir yapısı vardır, istediğimiz kadar eleman ekleyebiliriz. Eleman ekleme ve silme işlemleri kolaydır. Random erişim yoktur, baştan başlamak zorundayız.Array List ile karşılaştırdığımızda eleman eklemek istediğimizde Array List'in performansı Linked List'e göre kötüdür çünkü elemanlarının hepsi yer değiştirmek zorunda kalır(2. indexle 3. index, 3.indexle 4. index gibi ..). Linked List eleman eklemek istediğimizde sadece iki tane objenin yerini değiştiririz.Hafıza bakımından karşılaştırdığımızda Linked List daha fazla yer kaplar;pointer tuttuğu için ekstra hafıza tutar. Üç çeşittir:
> Tek yönlü bağlı listeler(singly linked list): Son düğümün pointerı NULL.  
> Dairesel bağlı liste(Circular linked list): son düğüm ilk düğümün pointerını tutar.  
> Çift yönlü bağlı listeler(Doubly linked list ): Sonraki ve önceki elemanın olmak üzere iki pointer tutar.

•  Bir queue'yu sadece stack yapısı kullanarak nasıl çalıştırabiliriz? İki stack ile bunu sağlayabiliriz. Birinci stack eklemek için ikinci stack çıkarmak için kullanılır.  
 ```java
public class QueueUsingStacks<T>{
  private Stack<T> stack1;
  private Stack<T> stack2;
  public QueueUsingStacks(){
    stack1=new Stack<>();
    stack2=new Stack<>();
  }
  public void enqueue(T item){
    stack1.push(item);
  }
  public T dequeue(){
    if(stack2.isEmpty()){
      if(stack1.isEmpty()){
        throw new RuntimeException("Queue is empty");
      }
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }
  public boolean isEmpty(){
    return stack1.isEmpty()&&stack2.isEmpty(); 
  }
  public T peek(){
    if(stack2.isEmpty()){
      if(stack1.isEmpty()){
        throw new RuntimeException("Queue is empty");
      }
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }
}
```
•  **Algoritma Complexity**: Bir algoritmanın performansını, ölçmek için kullanılan kavramdır. Algoritmanın performansı ne kadar hızlı çalıştığına, ne kadar kaynak yani bellek, zaman tükettiğine bakılarak hesaplanır.Asimptotik olarak Big-O notasyonu ile ifade edilir.

      •  O(1): sabit zamanlıdır. Giriş verisinin büyüklüğünden bağımsızdır.  
         O(n): doğrusal zamanlıdır. Giriş verisinin büyüklüğü ile doğru orantılıdır.   
         O(n^2): kare zamanlıdır.Giriş verisinin büyüklüğünün karesi ile orantılıdır.  
         O(logn): logaritmik zamanlıdır. Giriş verisinin büyüklüğünün logaritması ile orantılıdır.   
      •  İki türü vardır;  
      
           •  Time Complexity: algoritmanın çalışmasını tamamlamak için ihtiyaç duyduğu süredir.    
           •  Space Coplexity: algortimanın çalışması sırasında ihtiyaç duyduğu bellek miktarıdır.     
•  **Process**; word, excel veya herhangi başka bir uygulama henüz çalışmıyorken bir programdır. Programlar çalıştırıldığında process olarak nitelendirilir. Process'ler hayatlarına tek bir thread ile başlarve bu thread'e main thread denilir. Diğer threadler ise programın çalışma esnasında sistem fonksiyonları tarafından yaratılmaktadır.  
•  **Heap**; Java projeleri processe dönüştükleri zaman kendi memory space'ini yani heapini oluşturur.  
•  **Multitasking**; bilgisayarın bir çok processi aynı anda çalıştırmasıdır.Örneğin web browser'ı çalıştırırken aynı anda spotifyın da açık olması.     
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
•  **Paralel programlama**; threadlerin çok çekirdekli işlemcilerde farklı çekirdeklerde eşzamanlı olarak çalıştırılmasıdır.    
•  **Multithread**;bir process içinde bir çok thread oluşturup bir çok işi bir arada yapmaktadır.Wordde yazı yazarken aynı anda kelimelerin sayılması gibi   
•  **Concurency(eşzamanlılık)**; bir çok işimizi threadler yardımıyla paralel olarak yapabiliriz. Threadlerin paralel olarak çalışmasına concurency denir.  
•  **Deadlock**; iki ya da daha fazla processin devam etmek için birbirlerinin bitmesini beklemesi ve sonuçta ikisinin de devam edememesi durumudur.   
•  **Semafor**;Birden fazla processin eş zamanlı çalışması durumunda birbirleri için risk teşkil ettikleri kritik zamanlarda birbirlerini beklemesini sağlayan mekanizmadır. 
•  **Mutex(mutual exclusion)**; multithreaded  programlamada kullanılan bir senkronizasyon mekanizmasıdır. Aynı anda sadece bir thread'in belirli bir thread veya veri kaynağına erişmesini sağlar. Race Conditions(veri yarışı) ve tutarsız veri durumlarını önlemek için kullanılır. Bir thread mutex'i kitlediğinde(lock), diğer thread o mutex'i kitleyene kadar bekler. Thread işi bitiridğinde mutex'i serbest bırakır(unlock).Böylece başka bir thread bu kaynağa erişebilir.    
•  **Cache**; önbellektir.Verilerin geçici olarak saklandığı, hızlı erişilebilen bir bellek alanıdır.    
•  **Memory Leak**; Artık kullanılmayan belleğin serbest bırakılmaması durumunda meydana gelir. Zamanla belleğin tükenmesine ve sistem performansının düşmesine neden olur. Birbirini işaret eden nesneler(referans döngüsü), garbage collector tarafından tespit edilemez ve bu nedenle serbest bırakılmazlar. Sonsuz döngülü işlemler memory leak'e neden olur. 
•  **Polimorfizm**; aynı işlemin, farklı veri tipleri veya sınıflar üzerinde farklı şekillerde çalışabilmesini sağlar. Aynı isimdeki bir metoduni farklı classlar tarafından farklı şekillerde uygulanmasına olanak verir.  
•  64 bit ve 32 bit, bir işlemcinin veya işletim sisteminin bellek adresleme kapasitesini tanımlar. 32 bitler adresleme kapasitesi 32 bittir yani 2^32 bayttır.Bu da yaklaşık olarak 4 GB'a karşılık gelir. 64 bit adresleme kapasitesi 64 bittir yani 2^64 bayttır.   
• **Java Reflection API**, Java programının runtimeda classları, metodları ve alanları inceleyerek bunlar üzerinde dinamik olarak işlem yapabilmesine olanak sağlayan mekanizmadır. Class'ın yapısını (method, constructor) runtime'da öğrenmek için kullanılır. 

## Cohesion(Birliktelik )
•  Tek bir amaca sorumluluğa odaklanır(single responsibility). Bir fonksiyon/metot ne kadar az iş yaparsa birlikteliği o kadar yüksek olur. Çeşitleri vardır;  

  - Gelişigüzel(Coincidental): Bir araya getirilmiş ilgisiz yapılardır. Örneğin; util classları  
  - Mantıksal(Logital):Gerçekte farklı tabiatta  olmalarına rağmen tek bir şey ile ilgili olduğu düşünülen bir araya getirilmiş yapılardır. Örneğin; Cutter class’ında cutHair() cutTalk() metodunun bulunması gibi.  
  - Zamansal(Temporal): Zamansal birliktelikten dolayı bir araya getirilmişlerdir.  
  - Prosedürel(Procedural):Bir konu ile ilgili işlerin yukarıdan aşağıya doğru fonksiyonel olarak ayrılması ve hepsinin bir sınıfta bir araya getirilmesi. Örneğin; dosya açmakla ilgili her şeyi yapan, dosya erişimini ve gerekli belleği kontrol eden, dosyayı açıp kaydedip e-mail olarak gönderen bir class.  
  - İletişimsel(Communicational/Informational): Aynı veri üzerinde çalışan yapıların bir araya getirilmesidir. Veri işlemenin öne çıktığı durumlarda görülür.   
  - Ardışıl(Sequential): Class sevğiyesinde birinin çıktısının diğerini beslediği, pipe şeklinde çalışan fonksiyonları bir araya getiren claslardır.   
  - Fonksiyonel(Functional): En iyi birlitelik durumudur. Tek, çok iyi tanımlanmış ve olabildiğince küçük bir işe ya da sorumluluğa yönelik oloarak bir araya getirilmiş yapılardır.
      
      
• **Ivar Jacobson’ın nesne sınıflandırması**; Boundary nesneleri controller nesnelerini, controller nesneleri entityleri kullanırlar.
  
  -Boundary: Sistemin aktörleriyle olan iletişimini yöneten nesnelerdir, interface nesneleri de denir. (MVC’de karşılığı view)
  -Controller: İş süreçlerini yöneten ve ilgili kuralları bilen nesnelerdir. Çoğunlukla service olarak bilinirler. (MVC’de karşılığı controller)
  -Entity: İş alanı(business domain) nesneleridir. (JPA, EntityFramework vb. frameworklerin ürettiği ve sadece veri tabanı tablolarına karşı gelen nesneler bu anlamda entity değildir çünkü davranışa sahip değillerdir.) (MVC’de karşılığı model)
      
• **Hexagonal(Altıgen, Soğan) Mimari**; soğan gibi katmanlı bir yapıdır. Merkezde business rolelarını yöneten entityler vardır. Bir üst katmanda application lojikler yani uygulama kuralları bulunur. Interface adapter (Controller, presenters, gateways) farklı devicelarla, farklı sistemlerle iletişimde tutar, gerekli veri formatı dönüşümlerini de yönetirler. Frameworks ve Drivers en az kod yazılan ve daha çok tool cinsinden yapılardır. Akış,  Controllerdan başlar ve Use Case ile ilerleyip Presenterda son bulur. Bağımlılıklar dışarıdan içeriye doğru ilerler. 

![image](https://github.com/user-attachments/assets/27010d43-9516-4c73-9636-314786ea3a5b)

• **Mixed-Instance Cohesion**: Bir sınıfın bazı özellikleri bazı nesneleri için geçerli bazı nesneleri için geçerli değildir.    Bir class, farklı yazılım alanlarının(domain) nesnelerinin özelliklerini bir araya getirir.  Nesneler, alanlarına has olmalıdır, birden fazla alan tek bir nesneden temsil edilmemelidir.

  -Application Domain: Use caseleri gerçekleştirecek şekilde entityleri manipüle eden service nesneleri ;eventler,eventHandlerlar, workflowlar. Tekrar  kullanımları düşüktür.   
  -Business Domain: Objeler, entityler, enum ve interface nesneleridir.    
  -Architecture Domain: MVC, DAO(Data Access Object)  vb. mimari stiller, transaction, cache, UI/GUI mekanizmaları, web servis, Spring, JPA vs.   
  -Foundation Domain: primitives ve wrapper nesneleri, String, date, time, thread vb. müdahale edilemeyecek  sınıflardır.   

> Application --> Business --> Architecture --> Foundation

• **Mixed-Role Cohesion**: Aynı alan içerisinde olduğu halde farklı rollere sahip nesnelerin özelliklerinin tek bir nesnede toplandığı durumdur. Özellikle entity nesnelerinde çok sık görülür.  
• **Proxy**: Sakladığı nesne ile aynı interface’e sahip olan nesnedir. MVC’deki Controller bir Proxy değildir çünkü controllerın bir nesne tutma gibi bir amacı yoktur. Controllerın interface’i model ile aynı değildir.  

## Coupling (Bağlılık )
• Koordinasyon karmaşıklığı, bir işin kendi başına ifade edilebilirliğinin ya da diğerleriyle ne kadar ilgili(relatedness) olduğunun ölçüsüdür. İlgililik, bağlılıktır(coupling) ve bağımlılığı düşük olan bileşenlerin karmaşıklığı da düşüktür. Olabilecek en iyi coupling; veriler üzerinden değil davranışlar üzerinden olandır. 

  - **Low/loose/weak  coupling**: Bir classın başka bir classa olan bağımlılığı mümkün olduğunca azdır. Classlar arasındaki 
      etkileşim interfaces veya abstracts yolula gerçekleştirilir. 
  - **Tight coupling**: Bir classın bir classa bağımlılığı fazladır. Bir classsın iç detayları diğer classlar tarafından çok 
      fazla kullanılıyorsa vardır. Bakımı zordur ve kötü tasarımın işaretidir.  

• En kötüsünden en iyisine doğru coupling tipleri;

  - İçerik(Content): Yapıların birbirlerinin iç yapılarına, gerçekleştirmelerine (implementation) bağımlı olduğu durumlardır. 
      Yanlış soyutlama temel sebeptir. Doğrudan alan erişimi ya da set/get metotları yoluyla veri alışverişi en sık görülendir. 
      Birlikte değiştirme sorunu oluşturur.   
  - Common(Coupling):Global veri ve değişkenleri kullanan yapılar arasındaki bağımlılıktır. Sabitler, statik özelliklr ve 
      davranışlar yanında Singleton gibi kalıplarda görülür.   
  - Dışsal(External):Yapıları arasında, ortak kullandıkları dış bir bileşen ya da sistemin format, arayüz, veri yapısı vb.
      dayatmasından kaynaklanan bağımlılıktır. Façade ve Repository gibi kalıplarla azaltılabilir.   
  - Control: Yapıların flag geçerek birbirlerinin akışlarını kontrol ettikleri bağımlılıktır. İçerik bağımlılığının özel bir 
      halidir.  
  - Veri yapısı bağımlılığı: Yapıların birbirlerine karmaşık veri yapısı geçerek oluşturdukları bağımlılıktır. Geçilen nesne
      değil veri yapısıdır.  Örneği;
 ```java
interface Stack<E> {
    void push(E element);
    E pop();
    boolean isEmpty();
    boolean contains(E element);
}

class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    
    public void push(E element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }
    
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E element = elements[--size];
        elements[size] = null; // Avoid memory leaks
        return element;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    private void resize() {
        E[] newElements = (E[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}

class Set<E> {
    private Stack<E> stack;
    
    public Set(Stack<E> stack) {
        this.stack = stack;
    }
    
    public void add(E element) {
        if (!stack.contains(element)) {
            stack.push(element);
        }
    }
    
    public boolean contains(E element) {
        return stack.contains(element);
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        Set<Integer> set = new Set<>(stack);
        
        set.add(1);
        set.add(2);
        set.add(1); // Duplicate, should not be added
        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(3)); // false
    }
}
 ```
      
  - Veri bağımlılığı: Yapıların birbirlerine basit/ilkel/atomik veri geçerek oluşturdukları bağımlılıktır. Veri yapısı 
      bağımlılığının daha basit halidir.   
  - Mesaj:Interface bilgisi dışında başka hiçbir bilgi gerektirmeyen şeklidir. Olması gereken en sağlıklı bağımlılıktır. 
      Metotlar, sınıflar, modüller, katmanlar ve sistemler arasında uygulanabilir.   
  - Sıfır bağımlılık(no coupling): sistem olabilmek için mümkün olmayan bağımlılıktır.  
      
• Nesne-merkezli dillerde farklı bağımlılık türleri vardır:

  - **Miras bağımlılığı(Inheritance coupling)**: Üst yapı ile ondan türetilen yapı arasındaki bağımlılıktır.  
  - **Soyut bağımlılık(abstract coupling)**: Soyut olan üst yapılara olan bağımlılıktır. Soyut bağımlılıkta, gerçekleştirme
      mirası(implementation inheritance) ile arayüz mirası(interface inheritance) kullanılır. Mesaj bağımlılığının bir üst,
      daha iyi halidir. Abstract couplingte nesneler birbirlerinin interfacelerini belirleyen üst tipi belirler, gerçek tipi bilmez.
      Dependency Inversion(DI) ile elde edilir.
    
• **Cohesion ile coupling arasındaki fark**; Coupling;İki veya daha fazla modül arasındaki ilişkiye odaklanır. Cohesion: bir modül içindeki öğelerin birbirleriyle ne derece ilgili olduğuna odaklanır. Yüksek cohesion, düşük coupling istenen durumdur. Genel olarak yazılımda istenen şey kod geliştirmeye açık, değiştirilmeye kapalı yazılmalıdır.  
• **Anemic Domain Model**; iş alanını temsil eden nesnelerin(domain object), iş alanıyla ilgili sadece veriyi taşıyıp herhangi bir davranışa sahip olmadığı durumdur. Dolayısıyla nesneler arasındaki bağımlılık, arayüzlerindeki davranışlar yerine, doğrudan erişerek ya da set/get metotlarıyla veri üzerindedir.  İş davranışları servis nesnelerine yığılmakta ve orada prosedürel bir şekilde Fowler’ın Transaction Script olarak adlandırdığı anti pattern gerçekleştirilmektedir.   
• **Fowler Transaction Script**: İş mantığı tasarım desenidir. Özellikle veri odaklı uygulamalarda sıkça uygulanır. Her işlem tek bir betik ya da metodda bulunur. Bu betik, doğrudan veritabanı işlemleri ya da diğer business logic adımlarını içerir. Business logic, genellikle bir veri kaynağından verileri alır, işler ve sonuçları kaydeder. Her bir betik belirli bir iş süresini kapsar ve genellikle tek bir işlem(transaction) içinde çalışır.   
• **Data Driven(veri odaklı)**: Karar verme ve stratejik geliştirme süreçlerinde verilerin aktif bir şekilde kullanılması anlamına gelir. Yazılımda bu yaklaşımdan olabildiğince kaçımayız. Veri odaklı değil davranış odaklı olmaya gayret etmeliyiz.     
• **Data TransferObject(DTO)**:Bir sistemde veri taşıma amacı ile kullanılan basit bir nesnedir. Genellikle yalnızca fields içeren, business logic ve davranışlar barındırmayan, hafif veri kapsayıcılardır. Yalnızca fieldslar içerdikleri için genellikle getter/setter metodları ile verilere erişim sağlanır. Ana işlevleri veri katmanı ile business logic katmanı veya kullanıcı arayüzü (UI) katmanı arasında veri taşımaktır.Uygulama katmanları arasında (örneğin; veri erişim katmanı ve business logic katmanı arasında) veri aktarımını izole etmek ve bağımsızlığını korumak için DTO’lar kullanılır.  Web API’lerinde veya web servislerinde, DTO’lar genellikle istemciden alınan veya istemciye gönderilen verileri temsil etmek için kullanılır. DTO’lar JSON, XML gibi formatlara serileştirilebilir.
• **Data Access Object(DAO-Veri Erişim Nesnesi)**: Genellikle veri tabanlarına veya diğer kalıcı depolama mekanizmalarına erişim ve bu mekanizmadan veri alma işlemlerini yönetmek için kullanılan design pattern. Uygulama içerisindeki veri erişim katmanını soyutlayarak diğer kısımların veriye bağımlılığını engeller.  
•Litaratürde çeşitli prensipler vardır; SOLID, GRASP


## SOLID
•**Single Responsibility Principle**: : Bir sınıfın değişmesi için asla birden fazla sebep olmamalıdır. Bir classın fonksiyonel birlikteliğe sahip olması gerektiğini ifade eder. Bir sınıf öyle odaklı olmalıdır ki değişmesi için birden fazla sebep olmamalıdır. Bir sınıf sadece bir şeyi soyutlamalı ve sadece ona odaklanmalı, onunla ilgili veriye sahip olmalı ve sorumluluları yerine getirmelidir. Dolayısıyla da bir sınıf sadece bir soyutlamayla ilgili Sebeplerden dolayı değişebilir. **Separation of Concerns** prensibinin bir uygulaması olarak görülebilir.

  - **Separation of Concerns**: Sorunları ayrılmasıdır. Yazılım geliştirme sürecinde karmaşıklığı azaltmak ve yazılımın daha esnek, sürdürülebilir ve ölçeklenebilir olmasını sağlamak amacıyla kullanılır. Katmanlı mimari, MVC, Mikroservisler bu prensibin uygulandığı bazı yaklaşımlardır.   
  - **DRY(Don't Repeat Yourself)**: Eğer bir statement ya da bloğun birden fazla yerde bulunması gerekiyorsa, bu ifade bir metoda dönüştürülmelidir. Hiç bir kod parçası asla tekrar etmemelidir ve sistemde sadece bir yerde bulunmalıdır.
  - Bazen sınıfların birden fazla arayüzü yerine getirerek, pek çok role sahip olduğu görülür. Özerllikle yetkinlik kazandırmak amacıyla bir API'nin parçası olan arayüzleri yerine geiren ama aynı zamanda bir rolü olan nesnelerde bu durum yaygındır. Böyle sınıflar **composite/aggregate(bileşik/küme sınıf) olarak adlandırılır. Böyle arayüzler fat, pollued olarak adlandırılır ve code smell oluşturur.           
      
•**Open-Closed Principle**: Yazılım yapıları(classlar, modülleri, fonksiyonlar, metodlar ) genişletilmeye açık ama değişime kapalıdır.  Burada genişletmek kasıt; yapının en baştan itibaren, değişimi göz önüne alacak şekilde, değişebilecek kısımların, değişmeyecek kısımlardan yalıtılarak kurgulanması, dolayısıyla yeniliklerin var olan yapıları değiştirmeden yapılması, kaçınılmaz bağımlılıkların olabildiğince soyutlamalar üzerinden yapılması, gerçekleştirmelere bağımlılık oluşturulmamasıdır.  Sonucunda var olan tiplerin farklı amaçlara hizmet edecek şekilde alt sınıflarının oluşturulması ve sahip olduğu davranışları override(ezmesi) ile farklılaştırılması söz konusudur. Düşük birliktelikli yapılardan, iç yapılara bağımlılıktan, somut tiplere bağımlılıktan, global değişkenler, run time type identification gibi durumlardan kaçınılmalıdır. 
•**Liskov Substitution Principle**: Taban sınıflara işaretçi ya da referans kullanılan fonksiyonlar türetilen sınıfların nesnelerini de (gerçek tiplerini) bilmeden kullanabilmelidir.   
•**Interface Segregation Principle**: İstemciler kullanmadıkları arayüzlere bağımlı olmaya zorlanmamalıdır.    
•**Dependency Inversion Principle** : Yüksek seviyeli modüller aşağı seviyeli modüllere bağımlı olmamalıdır. İkisi de soyutlamalara bağımlı olmalıdır.   
•**Granularity Principle**:




 
## Exceptions
• **IndexOutOfBoundException**: arrayin ya da collection'ın geçerli index aralığının dışında bir indexe erişilmeye çalışıldığını gösterir.   
• **ClassCastException**: bir sınıfın bir nesneyi başka bir türe dönüştürmeye çalıştığı vwe dönüşümün uygun olmadığı durumlarda alınır.  
• **InvocationTargetException**:Java Reflection API'ını kullanarak bir methodu çağırmaya çalışırken meydana gelir. Bir method "invoke"  methodu ile çağırıldığında bir exception atarsa exception  InvocationTargetException'ı ile sarmalanarak fırlatılır. 

  • Java Reflection API kullanarak "method.invoke" metodu ile bir method çağırılır.
  • Eğer çağırılan method bir exception fırlatırsa, bu exception doğrudan Reflection API tarafından fırlatılmaz. Bunun yerine InvocationTargetException exception'ını ile sarmalanır. Gerçek exception saklanmış olur.
  • Asıl hataya neden olan exception getCause() methodu ile bulunur. 





