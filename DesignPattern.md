# Cohesion(Birliktelik )
•  Tek bir amaca sorumluluğa odaklanır(single responsibility). Bir fonksiyon/metot ne kadar az iş yaparsa birlikteliği o kadar yüksek olur. Çeşitleri vardır;  

  - Gelişigüzel(Coincidental): Bir araya getirilmiş ilgisiz yapılardır. Örneğin; util classları  
  - Mantıksal(Logital):Gerçekte farklı tabiatta  olmalarına rağmen tek bir şey ile ilgili olduğu düşünülen bir araya getirilmiş yapılardır. Örneğin; Cutter class’ında cutHair() cutTalk() metodunun bulunması gibi.  
  - Zamansal(Temporal): Zamansal birliktelikten dolayı bir araya getirilmişlerdir.  
  - Prosedürel(Procedural):Bir konu ile ilgili işlerin yukarıdan aşağıya doğru fonksiyonel olarak ayrılması ve hepsinin bir sınıfta bir araya getirilmesi. Örneğin; dosya açmakla ilgili her şeyi yapan, dosya erişimini ve gerekli belleği kontrol eden, dosyayı açıp kaydedip e-mail olarak gönderen bir class.  
  - İletişimsel(Communicational/Informational): Aynı veri üzerinde çalışan yapıların bir araya getirilmesidir. Veri işlemenin öne çıktığı durumlarda görülür.   
  - Ardışıl(Sequential): Class seviyesinde birinin çıktısının diğerini beslediği, pipe şeklinde çalışan fonksiyonları bir araya getiren claslardır.   
  - Fonksiyonel(Functional): En iyi birlitelik durumudur. Tek, çok iyi tanımlanmış ve olabildiğince küçük bir işe ya da sorumluluğa yönelik oloarak bir araya getirilmiş yapılardır.

• **Ivar Jacobson’ın nesne sınıflandırması**; Boundary nesneleri controller nesnelerini, controller nesneleri entityleri kullanırlar.
  - Boundary: Sistemin aktörleriyle olan iletişimini yöneten nesnelerdir, interface nesneleri de denir. (MVC’de karşılığı view)
  - Controller: İş süreçlerini yöneten ve ilgili kuralları bilen nesnelerdir. Çoğunlukla service olarak bilinirler. (MVC’de karşılığı controller)
  - Entity: İş alanı(business domain) nesneleridir. (JPA, EntityFramework vb. frameworklerin ürettiği ve sadece veri tabanı tablolarına karşı gelen nesneler bu anlamda entity değildir çünkü davranışa sahip değillerdir.) (MVC’de karşılığı model)
      
• **Hexagonal(Altıgen, Soğan) Mimari**; soğan gibi katmanlı bir yapıdır. Merkezde business rolelarını yöneten entityler vardır. Bir üst katmanda application lojikler yani uygulama kuralları bulunur. Interface adapter (Controller, presenters, gateways) farklı devicelarla, farklı sistemlerle iletişimde tutar, gerekli veri formatı dönüşümlerini de yönetirler. Frameworks ve Drivers en az kod yazılan ve daha çok tool cinsinden yapılardır. Akış,  Controllerdan başlar ve Use Case ile ilerleyip Presenterda son bulur. Bağımlılıklar dışarıdan içeriye doğru ilerler. 

![image](https://github.com/user-attachments/assets/27010d43-9516-4c73-9636-314786ea3a5b)

• **Mixed-Instance Cohesion**: Bir sınıfın bazı özellikleri bazı nesneleri için geçerli bazı nesneleri için geçerli değildir.    Bir class, farklı yazılım alanlarının(domain) nesnelerinin özelliklerini bir araya getirir.  Nesneler, alanlarına has olmalıdır, birden fazla alan tek bir nesneden temsil edilmemelidir.

  - Application Domain: Use caseleri gerçekleştirecek şekilde entityleri manipüle eden service nesneleri ;eventler,eventHandlerlar, workflowlar. Tekrar  kullanımları düşüktür.   
  - Business Domain: Objeler, entityler, enum ve interface nesneleridir.    
  - Architecture Domain: MVC, DAO(Data Access Object)  vb. mimari stiller, transaction, cache, UI/GUI mekanizmaları, web servis, Spring, JPA vs.   
  - Foundation Domain: primitives ve wrapper nesneleri, String, date, time, thread vb. müdahale edilemeyecek  sınıflardır.   

> Application --> Business --> Architecture --> Foundation

• **Mixed-Role Cohesion**: Aynı alan içerisinde olduğu halde farklı rollere sahip nesnelerin özelliklerinin tek bir nesnede toplandığı durumdur. Özellikle entity nesnelerinde çok sık görülür.  
• **Proxy**: Sakladığı nesne ile aynı interface’e sahip olan nesnedir. MVC’deki Controller bir Proxy değildir çünkü controllerın bir nesne tutma gibi bir amacı yoktur. Controllerın interface’i model ile aynı değildir.  

# Coupling (Bağlılık )
• Koordinasyon karmaşıklığı, bir işin kendi başına ifade edilebilirliğinin ya da diğerleriyle ne kadar ilgili(relatedness) olduğunun ölçüsüdür. İlgililik, bağlılıktır(coupling) ve bağımlılığı düşük olan bileşenlerin karmaşıklığı da düşüktür. Olabilecek en iyi coupling; veriler üzerinden değil davranışlar üzerinden olandır. 

  - **Low/loose/weak  coupling**: Bir classın başka bir classa olan bağımlılığı mümkün olduğunca azdır. Classlar arasındaki 
      etkileşim interfaces veya abstracts yolula gerçekleştirilir. 
  - **Tight coupling**: Bir classın bir classa bağımlılığı fazladır. Bir classsın iç detayları diğer classlar tarafından çok 
      fazla kullanılıyorsa vardır. Bakımı zordur ve kötü tasarımın işaretidir.  

• En kötüsünden en iyisine doğru coupling tipleri;

  - İçerik(Content): Yapıların birbirlerinin iç yapılarına, gerçekleştirmelerine (implementation) bağımlı olduğu durumlardır. 
      Yanlış soyutlama temel sebeptir. Doğrudan alan erişimi ya da set/get metotları yoluyla veri alışverişi en sık görülendir. 
      Birlikte değiştirme sorunu oluşturur.   
  - Common(Coupling):Global veri ve değişkenleri kullanan yapılar arasındaki bağımlılıktır. Sabitler, statik özelliklEr ve 
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
    
• **Cohesion ile coupling arasındaki fark**; Coupling;İki veya daha fazla modül arasındaki ilişkiye odaklanır. Cohesion: bir modül içindeki öğelerin birbirleriyle ne derece ilgili olduğuna odaklanır. **Yüksek cohesion, düşük coupling istenen durumdur.** Genel olarak yazılımda istenen şey kod geliştirmeye açık, değiştirilmeye kapalı yazılmalıdır.    
• **Anemic Domain Model**; iş alanını temsil eden nesnelerin(domain object), iş alanıyla ilgili sadece veriyi taşıyıp herhangi bir davranışa sahip olmadığı durumdur. Dolayısıyla nesneler arasındaki bağımlılık, arayüzlerindeki davranışlar yerine, doğrudan erişerek ya da set/get metotlarıyla veri üzerindedir.  İş davranışları servis nesnelerine yığılmakta ve orada prosedürel bir şekilde Fowler’ın Transaction Script olarak adlandırdığı anti pattern gerçekleştirilmektedir.     
• **Fowler Transaction Script**: İş mantığı tasarım desenidir. Özellikle veri odaklı uygulamalarda sıkça uygulanır. Her işlem tek bir betik ya da metodda bulunur. Bu betik, doğrudan veritabanı işlemleri ya da diğer business logic adımlarını içerir. Business logic, genellikle bir veri kaynağından verileri alır, işler ve sonuçları kaydeder. Her bir betik belirli bir iş süresini kapsar ve genellikle tek bir işlem(transaction) içinde çalışır.     
• **Data Driven(veri odaklı)**: Karar verme ve stratejik geliştirme süreçlerinde verilerin aktif bir şekilde kullanılması anlamına gelir. Yazılımda bu yaklaşımdan olabildiğince kaçımayız. Veri odaklı değil davranış odaklı olmaya gayret etmeliyiz.          
• **Data TransferObject(DTO)**:Bir sistemde veri taşıma amacı ile kullanılan basit bir nesnedir. Genellikle yalnızca fields içeren, business logic ve davranışlar barındırmayan, hafif veri kapsayıcılardır. Yalnızca fieldslar içerdikleri için genellikle getter/setter metodları ile verilere erişim sağlanır. Ana işlevleri veri katmanı ile business logic katmanı veya kullanıcı arayüzü (UI) katmanı arasında veri taşımaktır.Uygulama katmanları arasında (örneğin; veri erişim katmanı ve business logic katmanı arasında) veri aktarımını izole etmek ve bağımsızlığını korumak için DTO’lar kullanılır.  Web API’lerinde veya web servislerinde, DTO’lar genellikle istemciden alınan veya istemciye gönderilen verileri temsil etmek için kullanılır. DTO’lar JSON, XML gibi formatlara serileştirilebilir.     
• **Data Access Object(DAO-Veri Erişim Nesnesi)**: Genellikle veri tabanlarına veya diğer kalıcı depolama mekanizmalarına erişim ve bu mekanizmadan veri alma işlemlerini yönetmek için kullanılan design pattern. Uygulama içerisindeki veri erişim katmanını soyutlayarak diğer kısımların veriye bağımlılığını engeller.  
•Litaratürde çeşitli prensipler vardır; SOLID, GRASP  


# SOLID
•**Single Responsibility Principle**: : Bir sınıfın değişmesi için asla birden fazla sebep olmamalıdır. Bir classın fonksiyonel birlikteliğe sahip olması gerektiğini ifade eder. Bir sınıf öyle odaklı olmalıdır ki değişmesi için birden fazla sebep olmamalıdır. Bir sınıf sadece bir şeyi soyutlamalı ve sadece ona odaklanmalı, onunla ilgili veriye sahip olmalı ve sorumluluları yerine getirmelidir. Dolayısıyla da bir sınıf sadece bir soyutlamayla ilgili Sebeplerden dolayı değişebilir. **Separation of Concerns** prensibinin bir uygulaması olarak görülebilir.  

  - **Separation of Concerns**: Sorunları ayrılmasıdır. Yazılım geliştirme sürecinde karmaşıklığı azaltmak ve yazılımın daha esnek, sürdürülebilir ve ölçeklenebilir olmasını sağlamak amacıyla kullanılır. Katmanlı mimari, MVC, Mikroservisler bu prensibin uygulandığı bazı yaklaşımlardır.     
  - **DRY(Don't Repeat Yourself)**: Eğer bir statement ya da bloğun birden fazla yerde bulunması gerekiyorsa, bu ifade bir metoda dönüştürülmelidir. Hiç bir kod parçası asla tekrar etmemelidir ve sistemde sadece bir yerde bulunmalıdır.  
  - Bazen sınıfların birden fazla interface'i implement ederek, pek çok role sahip olduğu görülür. Özellikle yetkinlik kazandırmak amacıyla bir API'nin parçası olan interfaceleri yerine getiren ama aynı zamanda bir rolü olan nesnelerde bu durum yaygındır. Böyle sınıflar **composite/aggregate(bileşik/küme sınıf) olarak adlandırılır. Böyle interfacelere fat, pollued olarak adlandırılır ve code smell oluşturur.  
  - Eğer single responsibility prensibi ihlal edilirse fat classlar ortaya çıkar. **Fat class**; yazılım geliştirmede fazla büyük ve karmaşık hale gelmiş classları tanımlar. Çok fazla sorumluluğa sahiplerdir.               
      
•**Open-Closed Principle**: Yazılım yapıları(classlar, modülleri, fonksiyonlar, metodlar ) genişletilmeye açık ama değişime kapalıdır.  Burada genişletmek kasıt; yapının en baştan itibaren, değişimi göz önüne alacak şekilde, değişebilecek kısımların, değişmeyecek kısımlardan yalıtılarak kurgulanması, dolayısıyla yeniliklerin var olan yapıları değiştirmeden yapılması, kaçınılmaz bağımlılıkların olabildiğince soyutlamalar üzerinden yapılması, gerçekleştirmelere bağımlılık oluşturulmamasıdır.  Sonucunda var olan tiplerin farklı amaçlara hizmet edecek şekilde alt sınıflarının oluşturulması ve sahip olduğu davranışları override(ezmesi) ile farklılaştırılması söz konusudur. Düşük birliktelikli yapılardan, iç yapılara bağımlılıktan, somut tiplere bağımlılıktan, global değişkenler, run time type identification gibi durumlardan kaçınılmalıdır.       
•**Liskov Substitution Principle**: Taban sınıflara(base class) işaretçi ya da referans kullanılan fonksiyonlar türetilen sınıfların nesnelerini de (gerçek tiplerini) bilmeden kullanabilmelidir.  Yani türetilmiş sınıf, temel sınıfın her türlü davranışını korumalıdır.  LSP tasarlanan yapının o yapıyı kullanacak istemciler açısından doğrulanması gerektiğini ifade eder. Kurulan modeller ilk bakışta anlamlı ve tutarlı olsa bile aslolan istemcilerin o modeli nasıl kullanacağıdır. İstemcilerin üst arayüzler hakkında yaptıkları kabuller ve sahip oldukları beklentiler, alt arayüzler tarafından da karşılanmalıdır.   Örnek;  

```java
abstract cclass Bird{
  //Genel bir kuş davranışı burada olur
}
class FlyingBird extends Bird{
  public void fly(){
    System.out.println("Uçuyorum!");
  }
}
class Sparrow extends FlyingBird{
  @Override
  public void fly(){
    System.out.println("Serçe Uçuyor!");
  }
}
class Penguin extends Bird{
 //Penguenlere özgü davranış burada olabilir
}
```

Eğer genel davranış yani fly() metodu Bird classında tanımlansaydı; Penguen uçamadığı için hata atacaktı ve  bu Liskov Subsitutide Prinsibinin ihlaline neden olucaktı.      
•**Interface Segregation Principle**: İstemciler kullanmadıkları interfacelere bağımlı olmaya zorlanmamalıdır. SRP'nin yüksek birliktelik(cohesion) amacıyla arayüzlere uygulanmış halidir. ISP karşıtı durumun tipik iki göstergesi vardır:    

  - Farklı istemcilerin aynı interface üzerindeki farklı metotları çağırması,  
  - Interface'in alt tipi olan sınıfların bazı metodlara gerçekleştirme vermekte zorlanması.  

Bu durumda bu arayüz bölünmelidir. İstemciler sadece ilgilendikleri metotları görmelidir. Alt sınıflar da sadece ihtiyacı olan metotları devralıp gerçekleştirmelidir.     
•**Dependency Inversion Principle** : Yüksek seviyeli modüller aşağı seviyeli modüllere bağımlı olmamalıdır. İkisi de soyutlamalara bağımlı olmalıdır. Soyutlamalar detaylara bağımlı olmamalı, detaylar soyutlamalara bağımlı olmalıdır.(Yüksek seviyeli modül/iş ile kastedilen, uygulamayı oluşturan temel soyutlamalardır. Süreçler ve onları yöneten(süreçsel metotlar) yapılar bu türdendir. Alt seviyeli modül/iş ile kastedilen ise detaylardır. Atomik iş yapan işçi metotlar ve sınıfları bu türdendir.) Bu prensibe ihlal edildiği örnek; OrderService classı doğrudan CreditCardPaymentProcessor classına bağımlı. CreditCardPaymentProcessor classında bir değişiklik olursa bundan OrderService classının da değiştirilmesi gerekir.  

```java
class CreditCardPaymentProcessor{
  public void processPayment(double amount){
    System.out.println("Kredi kartı ile ödeme işlemi:"+amount);
  }
}

class OrderService{
  private CreditCardPaymentProcessor paymentProcessor;
  public OrderService(){ //constructor
    this.paymentProcessor=new CreditCardPaymentProcessor();
  }
  public void placeOrder(double amount){
      paymentProcessor.processPayment(amount);
  }
}
public class Main(){
  public static void main(String[] args){
    OrderService orderService=new OrderService();
    orderService.placeOrder(100.0);
  }
}
```
Dependency Inversion Principle'a uygun olarak yazılırsa;

```java

interface PaymentProcessor{
  void processPayment(double amount);
}
class CreditCardPaymentProcessor implements PaymentProcessor{
  @Override
  public void processPayment(double amount){
    System.out.println("Kredi kartı ile ödeme işlemi:"+amount);
  }
}
class PayPalProcessor implements PaymentProcessor{
  @Override
  public void processPayment(double amount){
    System.out.println("Paypal iloe ödeme işlemi:"+amount);
  }
}
class OrderService{
  private PaymentProcessor paymentProcessor;
  public OrderService(PaymentProcessor paymentProcessor){
    this.paymentProcessor=paymentProcessor;
  }
}
public class Main(){
  public static void main(String[] args){
    PaymentProcessor creditCardProcessor=new CreditCardPaymentProcessor();
    OrderService orderService=new OrderService(creditCardProcessor);
    orderService.placeOrder(100.0);

    PaymentProcessor payPalProcess=new PaymentProcessor();
    OrderService orderService=new OrderService(payPalProcess);
    orderService.placeOrder(200.0);
  }
}
```

  -Somut yapılar arasındaki bağımlılıkların tamamen soyut bağımlılıklara donüşecek şekilde tersine çevrilmelidir. Bu amaçla her somut yapının soyut bir üst tipi oluşturulmalı ve yukarı seviyeli iş yapan yapıların bağımlılıkları soyut tiplere çevrilmelidir. Bu şekilde üst seviyeli soyut yapılar ile onların detayları arasına  soyutlama tabakası konarak, değişimin yayılması önlenmelidir.    
•**Granularity Principle**:  Bağımsız sorumlulukların doğru bir şekilde belirlenmesi ve bu sorumlulukların uygun büyüklükteki(granülerlikte) bileşenlere dağıtılması gerektiğini savunur. 

  - İnce taneli(Fine-Grained) Bileşenler:Her bileşen ya da class, tek bir sorumluluk üstlenir.Esnektir, kolay test edileBilir amcak karşıklığı arttırır ve yönetimi zorlaştırır.
  - Kalın taneli(Course-Grained) Bileşenler: Her bileşen veya class, birden fazla sorumluluk üstlenir ve daha geniş kapsamlı bir işlevi yerine getirir. Değişikliklerin etkisi yüksek olur ve test edilmesi zordur, anlaması ve yönetilmesi kolaydır.
         
•**YAGNI(You Arent Gonna Need It) Prensibi**: Geliştiricilere ve ekiplerine gelecekte ihtiyaç duyulacağı tahmin edilen ama şuanda gereksiz olan işlevleri veya özellikleri eklemekten kaçınmayı öğütler. Genellikle Agile yazılım geliştirme metodolojisinde kullanılır. Sadece şuanda gerçekten gerekli olan işlevler üzerine çalışmasılmasına teşvik eder.        
•**Design By Contact**:Yazılım bileşenleri için formal, kesin(precise) ve doğrulunabilir(verifiable) arayüzlerin tasarlanması gerektiğini ifade eder. 
Temel olarak yazılım bileşenlerinin birbiri ile olan etkileşimlerini bir sözleşme çerçevesinde tanımlar. Bu contractlar, bileşenlerin nasıl etkileşime gireceğini açıklayan, ön koşullar(preconditions), son koşullar(postconditions) ve sınıf veya metod değişmezlerini(invariants) içerir. Ön şartlar metodun istemcisi tarafından çağırılması için gereklidir. Son şartlar ise metodun çalışmasını bitirdiğinde oluşacak durum ile ilgilidir. Alt tiplerin şartları(require) zayıflatabilir ve son şartları(ensure) sıkılaştırabilir.  Alt tipler üst tiplerin kabul etmediğini kabul edebilir ve daha iyi daha özel bir hale getirebilir. 
  - Miras aslen bir genelleştirme/özelleştirme(generalization/specialization) ilişkisidir. Üstte daha genel altta daha özel tipler bulunmalıdır. Yani bir metodumuz var diyelim Rectangle ve Square alanlarını hesaplayacağız. Override ederken ön koşulu parametre gibi düşün rectangle üst, square ise alt class diyelim. Hesaplama metodunda tür olarak square veremeyiz bu prensibe göre çünkü ön koşul rectangle gibi daha geniş olmalıdır.  Son koşuldaysa durum tam tersidir. Parent metodunda List dönerken subda override ederken arrayList dönebilir bu son şarttır.
  - Parent'ın fırlatmadığı exception'ı sub tipteki class fırlatamaz.   Diyelim ki Calculator adında bir classımız var ve bu classta bir add metodumuz var. Bu Calculater'ı extend eden PositiveCalculature var ve bu classında bir add metodu var.  Eğer Calculator metodu Exception exceptionını fırlatmıyorsa PositiveCalculater classındaki add metodu da bu exceptionı fırlatamaz(public void add throws Exception şeklinde yazılamaz).
       
•**RTTI(Run Time Type Information)**:Java ve diğer bazı programlama dillerinde, çalışma zamanı sırasında nesnelerin türleri hakkında bilgi sahibi olmayı sağlar. Bu özellik nesnelerin türünü bilmediğimizde veya türün sadece çalışma zamanında belirlendiği durumlarda kullanışlıdır. Java'da RTTI, "instanceof" anahtar kelimesi ve classlar kullanılarak gerçekleştirilir.    
•**Defensive Programming**: Yazılım geliştirme sürecinde olası hataları, kötü verileri veya beklenmedik durumları önceden tahmin edip ele almak için kullanılan bir yaklaşımdır. Mesela "assert" keyini kullanarak, loglama yaparak vs. sağlanabilir.     
•**Law of Demeter/Priciple of Least Knowledge**:Bir nesne olabildiğince az sayıda nesneyi bilmelidir. Bu prensibe göre bir nesnenin metotlarında, kendisi üzerinde metot çağrısı yapabileceği nesneler;

  - O nesnenin instance variableları
  - O nesnenin metotlarına geçilen nesneler
  - O nesnenin o metotunda oluşturulan nesneler
```java
public class A{
  private B b;
  public void f(C c){
    b.g();     //yapılabilir
    c.u();     //yapılabilir
    D d=new D();
    d.v();     //yapılabilir
    E e=c.w(); //YAPILMAMALI
    e.z();     //E'den iş isteme, C'den, E'den iş istemesini talep et.
  }
}
 ```
# GRASP
• GRASP(General Responsibility Assignment Software Patterns):Yazılım tasarımında belirli sorumlulukları ve görevleri nesneler arasında dağıtmak için kullanılır. 
  
  - Information Expert: Temel nesne tanımını(encapsulation) vurgular ve bağımlılıklarını ortadan kaldırmayı amaçlar. Bir sorumluluğun bir nesneye atanması, o nesnenin bu sorumluluğu yerine getirmek için gereken bilgiyi veya erişimi en iyi şekilde sağlayabilmesidir. 
  - Creator: Bir nesnenin, başka bir nesnenin örneklerini(instance) oluşturma sorumluluğu alıp almayacağını belirler. A,B'yi kullanıyorsa, A'ya B'yi yaratma sorumluluğu verilebilir. 
  - High Cohesion: Fonksiyonel birlikteliği vurgular. Bir nesnenin sorumluluklarının birbirine ne kadar bağlı ve tüm parçalarının bir amacı yerine getirip getirmediğini değerlendirir. Yüksek bağlılık, sorumlulukların iyi organize edilmiş ve ilişkili olduğu anlamına gelir. 
  - Low Coupling: Nesneler arasındaki bağımlılıkların en aza indirilmesi prensibidir. Bu sistemde bağımlılıklar azaltılır ve değişikliği daha kolay yönetebilir hale getirir.
  - Controller: Genel veya önemli bir işlevi handle eden bir nesne belirler. Tipik olarak, kullanıcı ile etkileşimi kontrol eden nesnedir. Her use case yapısını(eventleri olan yapı) yöneten yapıdır. Kötü bir şekilde dizayn edilmiş controllerın cohesion'u düşük olacaktır. Çünkü çok fazla şeyi yeri getirir. Buna bloated controller denir.Örneğin; bir controller classı olup bütün sistem eventlerini bu classın alması.
  - Polymorphism:İlgili göreceli işlemlerin, farklı veri türlerinin üzerindeki işlemler olarak tanımlanmasına ve bu işlemler olarak tanımlanmasına ve bu işlemlerin aynı ada sahip olmasına izin verir(genellikle taban sınıf ve türetilmiş sınıflar arasında bir yöntem adı paylaşımıdır.)
  - Pure Fabrication: Genelde domain modeli içinde bulunmayan ama sistem ihtiyaçları gereğince yaratılan bir sınıftır. Bu sınıf, gerçek dünya nesnelerine karşılık gelmeyen ve soyut işlemleri taşıyan bir sınıftır. 
  - Indirection:İki nesne arasında bir ilişki olması lazım ama doğrudan coupling ile yapmak istemediğimizde araya intermediate objeler konur. 
  - Protected Variable: Değişimlere karşı bir modelin veya sistemin esnekliğini artırmak için değişim noktalarını ve kararsızlıkları bir koruyucu katman ile izole edilir. Bu sayede diğer bölümler bu değişimden etkilenmez.

# Designs Pattern
•Design Pattern, nesne yaratmayı soyutlar ve nesne yaratma kodlarının etrafa dağılmasını önler.  
## Singleton
•Kısaca bir classtan sadece bir nesne yaratmaktır. Bir sınıftan bir tane nesne olmasından kasıt ise, herkesin istediği zaman bu sınıfın bir nesnesini oluşturmaya çalışmaması, oluşturamaması, var olan tek nesneyi kullanmasıdır. Singleton class oluşturmanın en az iki yolu vardır; 
  
  - Nesne yaratmayı kontrol etmek
  - Enumeration kullanarak:bu daha basit ve sıkıntısı az olan çözümdür. 

• Classtan tek bir nesne oluşturulabilmesini sağlamak için constructor'ın private olması gerekir ki istenen yerde istendiği gibi new ile bir nesne oluşturulamasın. Bu durumda new A() çağrısı sadece A classında yapılır.  Nesneyi oluştururken nesnenin classa ait olması için static olarak oluşturulur. Ama bu durumda da şöyle bir sorun oluşuyor; class çok büyük olabilir ve static nesneler program çalışır çalışmaz ilk oluşturulan şeylerdir bu durumda çok büyük bir yük olabilir. Bu durumda singleton nesnenin yaratılması için yaratılmasına ihtiyaç oluncaya kadar geciktirilmelidir. Yani **lazy loading(sonradan yüklemeli)** olmalıdır.
```java
 public class Singleton { //Lazy Loading
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

• Lazy Loaded singletonun problemi ise multi-threaded ortamlarda probleme yol açmasıdır. null kontrolünü aynı anda birden fazla kanalın yapması, birden fazla singleton nesnesinin oluşmasına sebep olur. Bu durumda thread safety sağlanamabilmesi için getInstance() metodunun aynı anda sadece bir tek kanal tarafından çağırılabileceğinden emin olmak gereklidir.Bunun için de mutex lock kullanılmalıdır. getInstance() metodunda Java'da synchronized, C#'da lock ile tüm metodun ya da belirlenen kapsamın(scope) aynı anda sadece bir kanal tarafından çalıştırılmasını sağlar. Ancak bu durumda da null kontrolünü synchronized olarak yapmak pahalıdır, performans açısından sorunludur. Çünkü mutex lock sadece singleton obje oluşturuluncaya kadar gereklidir, sonrasında referans null olmaktan çıktığından if kontrolü hiçbir zaman true dönmez. Ama run time'da tüm null kontrolleri mutex lock ile yapılır. Bu durumun önüne geçmek için de Double-Cheched Locking yapılır. Singleton nesneye olan referansın null olup olmadığının, birisi kilitli blokta diğeri ise öncesinde olmak üzere iki defa kontrol edildiği çözüme **Double-Cheched Locking** kalıbı denir. Mutex lock null kontrolü, singleton nesne oluşuncaya kadar çalışır. Singleton obje thread-safe olarak çalıştırıldıktan sonra çalışma ilk null kontrolü true döndürecğinden bir daha mutex lock alanına girmez. Bu da performans kazanımı sağlar. Ancak bu durumda da Java 1.5'de fixlenen bir memory bugından dolayı Double-Cheched Locking Pattern'i bu şekilde düzgün çalışmamaktadır. Threadler ayrı stackleri olan yapılardır. Her threadin ayrı local memory'si vardır. Local memory'e heapteki memoryden objeleri kopyalar, local memorysinde işi halleder, sonrasında geriye synchronized eder. İlk thread singleton referansını not null yapsa bile hala heapdeki ortak memorydeki singleton referansı null olarak kalmaya devam edebiliyor. Objeyi oluşturup referansını not null yaptığı halde ana memorye synchronize etmesi zaman alıyor o sırada ana memorydeki singleton referansı hala not null göründüğü için birden fazla thread locklamaya rağmen kırılıyor. Bu problemin çözümü olarak da singleton nesne de volatile kullanılmalıdır. Bu durumda nesneyi ilk defa oluşturma şansı elde eden kanalın yerel(local) belleğindeki bu durum, volatile tanımlamasından dolayı, bütün kanalların ulaştığı ortak belleğe aktarılır ve bir başka kanal artık null olmayan singleton referansından haberdar olur.

 ```java
 public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

• Buna ek olarak bir çözüm yöntemi daha geliştirilmiştir; private static inner class yani Bill Pugh Singleton Design geliştirildi.Bu yöntem hem lazy initialization yapar(Java'da bütün sınıflar lazy loading olarak yüklenir, ihtiyaç olmadığı sürece yüklenmez, burada da inner class lazy loading) hem de thread-safe olarak oluşturulur. 

 ```java
 public class Singleton {
 
    private Singleton() {}// Private constructor
    private static class SingletonHelper {  // Singleton Helper: statik iç sınıf
        // SingletonHelper sınıfı yüklendiğinde bu tek örnek oluşturulur.
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() { // Singleton örneğine küresel erişim noktası
        return SingletonHelper.INSTANCE;
    }
}
```

• Singleton nesne oluşturmayı ulaşılamayan, private kurucu ile yapmak çoğu zaman problemdir. Bu tür çözümler reflection ve serialization ile kırılabilir, birden fazla singleton yaratılabilir. Java ve C#'da constructor private olsa bile reflection ile sınıfların nesneleri oluşturulabilir. Serialize edilmiş singleton nesne birden fazla kere okunarak belleğe farklı nesneler olarak yüklenebilir. Bunlar yerine Enum yönteminin kullanılması daha sağlıklıdır. 

 ```java
public enum Singleton {
    INSTANCE;
    public void someMethod() {
        // Çalıştırılacak kod
    }
}
 ```
• Singleton nesne güncellenebilir bir duruma(mutable state) sahipse multi-threaded ortamda mutex lock ile kontrol gerekir. Kullanım kolaylığı açısından singleton nesnenin durumunu değişmez(final/readonly) yapmak ya da en azından gerekiyorsa sadece tek istemci tarafından güncellenecek şekilde kullanmak önemlidir.    
• Singleton'ı anti-pattern görme eğilimi vardır. Çünkü tek olan nesne erişim kolaylığından dolayı global bir değişkene dönüşmektedir. Singleton pattern ile hem durumu(state) hem de davranışı(behavior) global yapman imkanı vardır. Bu ise singleton nesneye ciddi bir bağımlılık oluşturmaktadır. Singleton nesne, hem uygulamanın her tarafından erişilebilir durumdadır hem de muhtemelen uygulama boyunca bellekte kalmaya devam eder. Bu durumda singleton nesne memory leak'e neden olabilir eğer çok büyükse.    
• Singleton pattern, inheritance(miras) prensibine terstir. Tüm kurucuları private olduğu için Singleton class'ın alt sınıfları olamaz. Ama ASingleton miras devralabilir. Yani Singleton, bir arayüzden ya da sınıftan miras devralabilir, devraldığı metotlara yeni gerçekleştirmeler vererek onları ezebilir(override).    
• Singleton nesneler statik de tanımlanabilir ancak statik metodlar override edilemezler, sadece nesne metotları override edilebilir.    
• Singleton sınıfının nesnelerinin sayısı değişebilir, benzer yöntemler sayısı kontrol edilebilen nesneler oluşturulabilir.    
• Bazı patternlerin gerçekleştirilmesinde Singleton pattern kullanılır; Abstract Factory, Builder, Prototype.    

# Factory Method
• Kısaca nesne yaratmayı soyutlamaktır. Bir nesne yaratmak için bir arayüz tanımlanır, fakat hangi sınıfın nesnesinin oluşturulacağını alt sınıflar karar verir. Factory method bir sınıfın nesne oluşturmasını alt sınıflara ötelenmesine izin verir,nesne oluşturma işlemini istemciden soyutlayarak. Böylece istemcinin hangi tür nesne oluşturacağını bilmeden nesne oluşturmasına olanak tanır.  

 ```java
public interface Factory{
  public Employee create(String name);
 }
public class EmployeeFactory implements Factory{
  @Override
  public Employee create(String name){
    Employee employee=new Employee(name,28);
    return employee;
  }
}
public class ManagerFactory implements Factory{
  @Override
  public Employee create(String name){
    Employee employee=new Manager(name,IT,28);
    return employee;
  }
}
 ```

• Nesneler arasında bir ilişki yoksa farklı factory merthod interfaceleri kullanılmalıdır. Eğer nesneler farklı parametrelerle oluşturuluyorsa ortak bir create() metodu dolayısıyla ortak bir ata interface kullanılamaz. Her nesne için ayrı bir interface ve farklı create() metotları oluşturulur. 

 ```java
public interface EmployeeFactory{
  public Employee create(String name);
 }
public interface ManagerFactory{
  public Employee create(String name, String department, Integer age);
 }
public class EmployeeFactory implements Factory{
  @Override
  public Employee create(String name){
    Employee employee=new Employee(name,28);
    return employee;
  }
}
public class ManagerFactory implements ManagerFactory{
  @Override
  public Employee create(String name String department, Integer age){
    Employee employee=new Manager(name,IT,28);
    return employee;
  }
}
 ```
• Birden fazla factory metodunu tek bir classta toplamak içinoluşturulan nesnelerin bir nesne ailesinin parçası olması gereklidir.--> Abstaract Factory
• Factory method, abstract bir yapı olmalı ki extend edilebilsin olabildiğince az parametre geçmeliyiz ki bir yerde bir iş yapsın. Aslolan Factory Method'ın nesne yaratmayı soyutlamasıdır, nesnenin nasıl yaratılacağı ayrı bir konudur ve nesneye bağlıdır.  
• Bloch çözümünde; constructorlar yerine static metotları tavsiye eder. createNewEmployee(int,String,String), createNewTemporarayEmploye(int,String) constructorlarını bir class içerisinde tanımlayamayız. Ama static olarak tanımlarsak isimli kurucu(named constructors) haline gelir. Bu çözümde her sınıf kendi nesnesinin üreticicisidir, bundan dolayı ayrı ayrı arayüz ve gerçekleştirmelerine ihtiyaç duyulmaz. Factory methodla burada ayrışmaktadır.Factory method ile ilgili bir örnek daha; 

 ```java
public interface Transport {
    void deliver();
}
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Kara yoluyla teslimat yapılıyor.");
    }
}
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deniz yoluyla teslimat yapılıyor.");
    }
}
public abstract class Logistics {
    // Factory Method
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
public class AirLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}


public class Main {
    public static void main(String[] args) {
        // Kara yolu lojistiği
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();
        
        // Deniz yolu lojistiği
        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
        
    }
}

 ```
Bu örnekte main metodu çalışır. Logistics türünden RoadLogistics nesnesi oluşturulur.  roadLogistics.planDelivery() metodu çağırılır. planDelivery() metodu içinde RoadLogistics içinde override edilmiş olan createTransport() metodu çağırılır.Burada  createTransport() metodu Logistics sınıfının abstract bir metodu olmasına rağmen roadLogistics nesnesi RoadLogistic sınıfında tanımlı createTransport metodu çalıştırılır. RoadLogistic nesnesi RoadLogistics.createTransport() metodu bir Truck nesnesi döndürür. 
transport.deliver() Truck nesnesi üzerinden deliver() metodunu çağırır. Track.deliver() metodu Kara yoluyla teslimat yapılıyor. mesajını ekrana bastırır.n
# Abstract Factory
• Temel amacı nesne ailesi yaratmayı soyutlamaktır. Birbiriyle ilgili ya da bağımlı nesne ailelerini, nesnelerin somut sınıflarını belirtmeden yaratmak için bir interface sağlamaktır.     
• Abstract  Factory, tek nesne yerine, nesne ailesi oluşturmak üzere kullanılan bir kalıptır. Abstract Factory bir sınıftır, Factory Method ise bir metottur. Factory Method tek bir objenin, Abstract Factory birden fazla objenin yaratılmasını soyutlar. Bu nedenle Abstaract Factory birden fazla Factory Methoda sahiptir.    
• Factory method tek bir nesneyi yaratmaktan sorumludur. Yaratılan nesne bir değil birden çok ise yapılacak şey birden fazla Factory method kullanmaktır. Bu durumda farklı Factory Methodlar farklı interfacelerde bulunur. Çünkü objeler arasında bir ilgi ya da bağımlılık yoktur. Benzer şekilde her bir obje için interface'i gerçekleştiren dolayısıyla da Factory Method'u ezen sınıflar oluşturulur. Elimizdeki nesneler , bir nesne ailesi oluşturuyorsa yani bu nesneler birbirleriyle ilgili nesnelerse, her birisi için ayrı ayrı oluşturulan ve farklı sınıflara konan Factory Method'larını bir araya toplayan sınıfın birlikteliğini düşürmez. Bu classa Abstract Factory denilir. **Kısaca abstract factory, birden fazla factory method kullanılarak oluşturulur.**   
• Birlikte kullanılacak nesnelerin , birden fazla ortam/platform için yaratılmaları söz konusu Abstract Factory interface'ini her ortam/platform için farklı bir gerçekleştirmesi de olabilir. Her abstract factory gerçekleştirmesinde ailenin her ferdi için ayrı bir factory method kullanılır.   
• Abstract factory'de factory methodu yanında Builder ve Protype da kullanılabilir.   

 ```java
public class Client {

    public static void main(String[] args) {
        // Modern mobilya seti oluştur
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        
        modernChair.sitOn();
        modernTable.use();
        
        // Klasik mobilya seti oluştur
        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        Chair classicChair = classicFactory.createChair();
        Table classicTable = classicFactory.createTable();

        classicChair.sitOn();
        classicTable.use();
    }
}
 ```

 ```java
// Abstract Factory Arayüzü
public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}
 ```

 ```java
public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

// Klasik Mobilya Fabrikası
public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public Table createTable() {
        return new ClassicTable();
    }
}
 ```

 ```java
// Sandalye için arayüz
public interface Chair {
    void sitOn();
}

// Masa için arayüz
public interface Table {
    void use();
}
 ```

 ```java
// Modern Sandalye
public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

// Modern Masa
public class ModernTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a modern table");
    }
}

// Klasik Sandalye
public class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a classic chair");
    }
}

// Klasik Masa
public class ClassicTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a classic table");
    }
}
 ```

Burada ModernFurnitureFactory classından FurnitureFactory nesnesi yaratır(modernFactory). modernFactory nesnesi createChair() metodunu çağırır ve ClassicChair nesnesi yaratılır, bu nesne modernChair'a atanır.modernChair nesnesi  sitOn() metodunu çağırır ve  ekrana Sitting on a classic chair bastırır . 

# Builder
• Amaç karmaşık nesne yaratma sürecini kurgulamaktır. Proje karmaşıklıklaştıkça veya aynı nesne için farklı konfigürasyonlar söz konusu olduğunda nesne de karmaşıklaşır. Constructor çağrısı yaparak builder pattern'i ile bir süreç içinde yapılır. Bu kalıpta yaratmak(create) yerine inşa söz konusudur. Bu sebeple builder kelimesi ile süreçsellik vurgusu yapılmıştır.  
• Bir nesnenin karmaşık olduğunun en temel göstergesi, çok parametre alan constructorlardır. -> Telecoping constructor anti-pattern(uzun kurucu anti pattern'i) Constructora geçilen parametrelerin de oluşturulması gerektiği düşünüldüğünde, bu sürecin soyutlanması gerektiği açıktır.  
• Varsayılan constructor ve set metotları, uzun constructor problemini başka bir probleme çevirmektedir. Pek çok set metodunun çağrılmasının yanında yapılacak yanlışların, oluşturlan nesnenin durumunda problemlere yol açması da mümkündür. Ayrıca bu yaklaşım nesnnenin durumunu değişebilir yani mutable halde bırakmaktadır.  
• Bu kalıpta vurgulanan şey, nesnenin nerede yaratılacağı değil nesnenin yaratılma sürecidir. Nesnenin inşa edilme süreci bir arayüzün farklı gerçekleştirmeleri olarak kurulur. Bir interface'i gerçekleştiren Builder classının metotları, oluşturulacak nesneyi bir süreç içinde inşa eder. **En basit haliyle** builder, nesnenin varsayılan kurucusunu çağırıp sonrasında set metotlarıyla nesneyi inşa eder ve oluşan nesneyi istemciye geri döndürür.   
• Nesneyi inşa etme sürecindeki metotlar hep aynı inşa edici nesnneyi yani builder nesnesini döndürülerse inşa eden kod süreci bir zincir şekilnde yazılabilir.    
• **Zincirleme(Chaining) Yöntemi**: Bir nesne üzerinde birden fazla metot çağrısı yaparken, metotların birbirini zincir şeklinde bağlanarak çağrılmasını sağlar. Bu her metot çağrısının ardından aynı nesnenin döndürülmesi ile gerçekleştirilir. Bu yöntem kullanılarak bir nesne adım adım yapılandırılabilir. 


 ```java
public HouseBuilder setGarden(boolean hasGarden) {
    this.hasGarden = hasGarden;
    return this;
}

public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
    this.hasSwimmingPool = hasSwimmingPool;
    return this;
}

 ```
Bu kodda, her bir metot HouseBuilder nesnesini this döner, yani çağrıyı yapan HouseBuilder nesnesini döner. Bu da o metodu çağıran kodun, başka bir metodu hemene ardından  aynı nesne üzerinden çağıralabilmesini sağlar. 

• Nesnesi inşa eden builder, nesnenin içinde, örneğin bir iç sınıf (inner/nested class) olarak konumlandırılırsa nesnenin set metotlarından kurtulmak mümkündür. Böylece oluşturulan nesnenin durumunun daha sonra değiştirilmesinin önüne geçilir ve immutable nesne elde edilir. Bu durumda builder nesne, temel nesneden alınır. Yani nesne kendi builder nesnesini constructor metoduna(factory method) sahip olur.  
•  İnşa sürecinde nesnenin gerçekten oluşturulduğu an, en son build() çağrısı yapılıncaya kadar geciktirilebilir. build() çağrısı yapılmadığında hiçbir nesne oluşturulmaz. Bu şekilde lazy-loaded bir süreç oluşturulur. Yani builder nesnesi inşa ettiği nesnenin durumuyla ilgili bilgi tutmalıdır ve build() çağrısında bu bilgilere göre nesneyi oluşturmalıdır.   
• Nesneyi inşa etme sürecinde farklı safhalar söz konusu ve bu safhalar arasında bir sıra varsa bu durumda farklı builder nesneleri kullanılabilir. 

 ```java
public class Main {
    public static void main(String[] args) {
        House house = new House.HouseBuilder("Beton", "Çelik")
                .setGarden(true)
                .setSwimmingPool(false)
                .setGarage(true)
                .build();

        System.out.println(house);
    }
}

class House {
    // Zorunlu özellikler
    private final String foundation;
    private final String structure;
    
    // Opsiyonel özellikler
    private final boolean hasGarden;
    private final boolean hasSwimmingPool;
    private final boolean hasGarage;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarage = builder.hasGarage;
    }

    public static class HouseBuilder {
        // Zorunlu özellikler
        private final String foundation;
        private final String structure;

        // Opsiyonel özellikler - Varsayılan değerler
        private boolean hasGarden = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarage = false;

        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House{" +
               "foundation='" + foundation + '\'' +
               ", structure='" + structure + '\'' +
               ", hasGarden=" + hasGarden +
               ", hasSwimmingPool=" + hasSwimmingPool +
               ", hasGarage=" + hasGarage +
               '}';
    }
}
 ```

Burada House classının içinde, constructor ve zorunlu alanları içerir. HouseBuilder inner classının constructorı zorunlu parametreleri alır. Opsiyonel özellikler için setter benzeri metodları sağlar ve her bir metot HouseBuilder nesnesini döenr. build() metodu sonunda House nesnesini oluşturur. HouseBuilder inner classı static olarak tanımlanmıştır bu sayede HouseBuilder'ın instance'ın yaratmadan doğradan bu metotları kullanabildik. 

# Prototype 
•Bir örnek nesneden kopyalamayla  yeni nesneler türetmektir.Karmaşık nesneleri sıfırdan yaratmak yerine, hali hazırda elde var olan nesnelerden kopyalayarak(clone) elde etmek yoluna gidilebilir. Durumu kopyalanarak çoğaltılan nesne **prototip** ya da örnek nesnedir. Diyelim ki elimizde bir Account nesnesi var ama bunun da tipleri var frozenAccount, normalAccount, negativeAccount. Account nesnesi çok fazla parametre istediğinde nesne oluşturmak çok olur. Aşağıdaki gibi bir durumda parametre geçmesi oldukça zor ve karışıktır. 

 ```java
Account frozenAccount= new Account("1",34,21,333,"Ayşe","Tez",32);
Account normalAccount= new Account("5",32,12,32,"Zeynep","Hane",87);
Accoutn negativeAccount=new Account("2",3444,32,11,"Hakan","Çalı",455);
 ```

• Account nesnesini de yaratmak için sürekli constructor çağrısı yapmak yerine var olan bir Account nesnesini prototip ya da örnek olarak elde tutup, diğer Account nesnelerinin bu prototipten kopyalanarak üretilmesi sağlanabilir. Prototip olarak oluşurulan nesne, aynı sınıftan diğer nesneler için bir başlangıç noktası olur. Dolayısıyla, yeni nesneleri oluşturmaya var olan prototipi kopyalayarak(cloning) başlayabiliriz. Kopyalamayla elde edilen nesnenin durumu, prototiple aynıdır.Ancak yeni nesnenin kendine has duruma sahip olması gereklidir. Bu yüzden, prototip ile yeni nesnenin olması gereken durumu arasındaki farklılık, yeni nesne üzerinde set metotları çağrılarak giderilir.     

• Cloneable Interface'i, Java'da bir nesnenin klonlanabileceğini belirtir. bu interface herhangi bir metot tanımlamaz, sadece bir işaret arayüzü yani marker interfacedir, yani bir classta implement edildiğinde klonlanabilir olduğunu belirtir.   
• clone() metodu, "Object" classında yer alır ve bu metot, bir nesnenin yüzeysel kopyasını(swallow copy) oluşturur.   

>swallow copy: Nesnenin ilk seviyedeki alanlarının kopyalandığı ancak bu alanların eğer referans türündeyse orijinal nesneleri referans ettiği kopyadır.   
>deep copy: Nesnenin tüm seviyedeki alanlarının özgün olarak kopyalandığı durumu ifade eder.   

• Prototype örneği; 

 ```java
public class Client {
    public static void main(String[] args) {
        // İlk rapor nesnesini oluştur
        Report originalReport = new Report("Prototip", "Prototip nesne");

        // Raporu klonla
        Report clonedReport = (Report) originalReport.clone();

        // Klonlanmış raporun başlığını ve içeriğini değiştir
        clonedReport.setTitle("Cloned ");
        clonedReport.setContent("Content cloned ");

        // Sonuçları yazdır
        System.out.println("Original Report: " + originalReport);
        System.out.println("Cloned Report: " + clonedReport);
    }
}
public interface Document extends Cloneable {
    Document clone();
    void setTitle(String title);
    void setContent(String content);
}
public class Report implements Document {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Report) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report [title=" + title + ", content=" + content + "]";
    }
}
 ```

Burada ilk olarak Report classından bir obje oluşturulur ve parametreleri geçilir. originalReport.clone(), clone() metodu çağrısı yapılır.clone() metodunda, (Report) super.clone() döner. Bu ne demek? klonlama işlemini "Object" sınıfındaki clone() metodundan çağırır. Bu da Cloneable interface'ini uygulayan nesnenin yani originalReport nesnesinin bir kopyası(swallow) oluşturulur. Clonable interface'i uygulanamıyorsa CloneNotSupportedException hatası fırlatılır. Oluşturulan kopya Object classında oluşturuldupu için Object tipindedir. Uygun tipe dönüştürülmesi için (Report) super.clone() şeklinde yazılır ve döndürülür.   
• Prototype kalıbı nesnelerin nasıl üretileceğini çözer. Prototype kalıbı nesnelerin nerede oluşturulacağı ile ilgilenmez dolayısıyla nesne yaratmayı soyutlamaz.  Protipten yeni nesne ürütmeyi bir factory metodunun ardına koymak çok daha uygundur. Factory metoduna parametre geçilerek, nesne olması gereken haliyle geriye döndürülebilir.   

# Dependency Injection
• Avantajı, tanım tabanlı(declarative) bir yapı sunmasıdır. Bu şekilde nesnelerin birbirlerine olan bağımlılıkları ifade edilir ama bağımlılıkların nasıl yerine getireleceği Dependency Injection altyapısı tarafından gerçekleştirilir. Bu da karmaşıklığı azaltır ve değişimi kolaylaştırır.   
• Dependency Injection bir kalıp olmakla birlikte genelde teknolojik destek ile gerçekleşir. 
• Dependency Injection, nesnelerin bağımlılıklarını doğrudan inşa etmek ve yönetmek yerine bu bağımlılıkları dışarıdan alarak yani enjekte ederek bağımlılıkların daha esnek ve test edilebilir olmasını sağlayan bir patterndir. (Loose couplingini güçlendirir. ) Üç temel yolla gerçekleşir.
  
  - **Constructor Injection**:Bağımlılıkların bir nesnenin constructorı aracılığı ile enjekte edilmesini sağlar. Bu yöntemle, classın ihtiyaç duyduğu tüm bağımlılıklar, nesne oluşturulurken constructor!a parametre olarak geçilir. Bu sayede bağımlılıklar sınıfın dışarıdan sağlanan bileşenleridir ve sınıf kendi başına bağımlılıkları yaratmaktan sorumlu değildir.

 ```java
public class Main {
    public static void main(String[] args) {
        // Bağımlılıkları oluştur
        Service service = new Service();

        // Client nesnesini, bağımlılığı ile birlikte oluştur
        Client client = new Client(service);

        // Client üzerinde bir işlem yap
        client.doSomething();
    }
}
public class Service {
    public void serve() {
        System.out.println("Servis çalışıyor.");
    }
}

public class Client {
    private final Service service;

    // Constructor Injection
    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}
 ```

  -  **Setter Injection**: Bağımlılıkların nesneye setter metotları ile enjekte edilmesini sağlar. Sınıfın bağımlılıkları nesne oluşturulduktan sonra setter metotları kullanılarak ayarlanır.
 
 ```java
public class Main {
    public static void main(String[] args) {
        // Bağımlılıkları oluştur
        Service service = new Service();
        
        // Client nesnesini oluştur
        Client client = new Client();
        
        // Bağımlılığı Client'e enjekte et
        client.setService(service);
        
        // Client üzerinde bir işlem yap
        client.doSomething();
    }
}


public class Service {
    public void serve() {
        System.out.println("Servis işlevi gerçekleştirilmiştir.");
    }
}

public class Client {
    private Service service;

    // Setter Injection nesne injekt edildi
    public void setService(Service service) {
        this.service = service;
    }

    public void doSomething() {
        if (service != null) {
            service.serve();
        } else {
            System.out.println("Service dependency is not set.");
        }
    }
}
 ```


  
  -  **Interface Injection**: Bağımlılığın sağlanacağı sınıf ve bağımlılığın kendisi, ortak bir interface'i kullanarak iletişim kurar. Bu arayüz genellikler bağımlılığı sağlamak için bir metot tanımlar. Kullanımı çok yaygın değildir. 
  
 ```java
public class Main {
    public static void main(String[] args) {
        // Bağımlılığı oluştur
        Service service = new ConcreteService();
        
        // Client nesnesini oluştur
        Client client = new Client();
        
        // Bağımlılığı Client'e enjekte et
        client.setService(service);
        
        // Client üzerinde bir işlem yap
        client.doSomething();
    }
}

public interface Service {
    void serve();
}

public class ConcreteService implements Service {
    @Override
    public void serve() {
        System.out.println("Servis işlevi gerçekleştirilmiştir.");
    }
}

public interface ServiceInjector {
    void setService(Service service);
}

public class Client implements ServiceInjector {
    private Service service;

    @Override
    public void setService(Service service) {
        this.service = service;
    }

    public void doSomething() {
        if (service != null) {
            service.serve();
        } else {
            System.out.println("Service dependency is not set.");
        }
    }
}
 ```


![Ekran Alıntısı](https://github.com/user-attachments/assets/4b3eaeee-f8ed-40e8-ab78-735072d7b2e7)



# Structural Pattern(Yapısal Kalıplar)
• Yapısal kalıplar,sınıflar ve nesnelerin daha büyük yapılar oluşturmak üzere nasıl bir araya geldikleriyle ilgilidir. Kalıtım(inheritance ya da is-a) ve birleştirme(composition ya da has-a)  yapısal ilişkidir. Yapısal kalıplarda var olan interfaceleri, classları ve objeleri, kalıtım ve composition yoluyla bir araya getirerek yeni fonksiyonel yapılar oluşturulur.

## Flyweight
• Amacı;nesneleri paylaşarak, nesne sayısını azaltmaktır .   
• Flyweight object, farklı bağlamlarda ortak olarak kullanılabilen nesnedir. Nesne farklı bağlamlar tarafından ortaklaşa kullanılır ancak nesne her bağlamda bağımsız olarak davranır. 500 sayfalık bir kitap düşünelim her sayfa için ayrı bir nesne oluşturmak çok maliyetli olacaktır. Bunun yerine bir sayfa nesnesi oluşturup tekrar tekrar kullanıbilmelidir. 4. sayfayı gösterirken 4. sayfa nesneye yüklenmeli, 7. sayfa gösterilirken nesneninin içini boşaltıp 7. sayfa yüklenmelidir.      
• Nesnelerin durumu ikiye ayrılır; 

  - İçsel durum(intrinsic state), flyweight objenin temsil ettiği asıl durumdur.Paylaşılan durumdur ve nesne tarafından ortak bir şekilde kullanılır. Değişmez ve bağımsızdır. Tüm örneklerde aynıdır, bu nedenle tek bir yerden yönetilebilir. Örneğin; renk, bir pikselin içsel durumudur çünkü renk bir çok piksel tarafından paylaşılabilir. Bellek tasarrufu sağlar.
  - Dışsal durum(extrinsic state), içinde bulunduğu bağlam tarafından belirlenen durumdur. Farklı  çok sayıda objeye ihtiyaç duyulur.  Dışsal durum ne kadar basitse Flyweight objenin kullanımı o kadar kolaydır. Paylaşılan ve bağımsız olmayan durumdur. Değişken ve dinamik olarak nesneye özgü sağlanır. Her nesne örneği için farklı olabilir ve bu nedenle dışarıdan sağlanır. Örneğin; pikselin koordinatları(x,y) dışsal bir durumdur çünkü her pikselin koordinatı farklıdır ve dinamik olarak paylaşılır. Nesne örneklerinin bağımsızlığını sağlar. Az sayıda nesne dışsal bağımlılığı arttrır. 

• Factory method yardımı ile oluşturulurlar.     
• Java'da primitive türlerin wrapper classları ve referans değerlerin bazıları Flyweight patternini kullanır. Belirli aralıklarda yapılan önbellekleme, bellek kullanımı düşürür, performansı yükseltir ve eşzamanlılık sorunlarını azaltır. 

  - Byte, Short, Integer, Long ->-128 ile 127 aralığında; Character classı, 0 ile 127(ASCII karakterleri olarak) aralığında yer alan değerler cache'e alınır ve aynı nesne kullanılır. 
  - Float ve Double classları önbellekleme mekanizmasını bulunmamaktadır. Bu türlerde her yeni atama için yeni bir nesne oluşturulur.

  
 ```java
public class WrapperCacheDemo {
    public static void main(String[] args) {
        // Byte için uç örnekler
        Byte byte1 = 127;
        Byte byte2 = 127;
        System.out.println(byte1 == byte2); // true

        // Short için örnekler
        Short short1 = 127;
        Short short2 = 127;
        System.out.println(short1 == short2); // true

        // Integer için örnekler
        Integer int1 = 127;
        Integer int2 = 127;
        System.out.println(int1 == int2); // true

        // Long için örnekler
        Long long1 = 127L;
        Long long2 = 127L;
        System.out.println(long1 == long2); // true

        // Character için örnekler
        Character char1 = 127;
        Character char2 = 127;
        System.out.println(char1 == char2); // true

        // Integer fakat aralık dışında değerler için
        Integer int3 = 128;
        Integer int4 = 128;
        System.out.println(int3 == int4); // false

        // Float ve Double için örnekler
        Float float1 = 127.0f;
        Float float2 = 127.0f;
        System.out.println(float1 == float2); // false

        Double double1 = 127.0;
        Double double2 = 127.0;
        System.out.println(double1 == double2); // false
    }
}
  
 ```

  - String classı içsel olarak Flyweight desenine benzer bir mekanizma kullanır. String pool Java tarafından yönetilen ve aynı karakter dizisine sahip string nesnelerini paylaştıran bir havuzdur. String pool sayesinde, aynı karakter dizilerini içeren string nesneleri bellekten tasarruf etmek için yeniden kullanılır. intern(), bir string nesnesinin string poolda bulunmasını sağlar.  Java String classının intern() metodu, String poolun bir parçası olarak işlev görür. Eğer bir string literal(string nesnesi oluştururken doğrudan çift tırnak "" içinde bir karakter dizisi kullanmaktır.) olarak tanımlanırsa veya intern() metodu kullanılarak havuza eklenirse, aynı karakter dizisine sahip başka string nesneleri yeniden kullanılacaktır. 

  
 ```java
 public class StringFlyweightExample {
    public static void main(String[] args) {
        // String literal - havuza otomatik olarak eklenir
        String str1 = "Hello";
        String str2 = "Hello";

        // `new` ile oluşturulmuş String - havuza otomatik olarak eklenmez
        String str3 = new String("Hello");

        // `intern()` kullanımı - manuel olarak havuza eklenir
        String str4 = str3.intern();

        // Literaller - aynı nesneyi paylaşır
        System.out.println(str1 == str2); // true

        // `new` ile oluşturulmuş ama havuza eklenmemiş - farklı nesne
        System.out.println(str1 == str3); // false

        // `intern()` kullanımı sonucu - aynı nesneyi paylaşır
        System.out.println(str1 == str4); // true
    }
}
  
 ```

• Her nesne havu flyweight nesne değildir, flyweight nesne farklı bağlamlarda tekrar tekrar kullanılıyor olmalıdır.  
 
## Adapter
• Bir classın interface'in, bir başka sınıfın beklediği interface'e çevirir. Adaptör, uyumsuz arayüzleri sebebiyle çalışamayacak classların bir arada çalışmasını sağlar. Bir adaptör classı kullanarak uyumsuz classların interfacelerini uyumlu hale getirir.    
• Adapter classı, uyumsuz class ile istemcinin kendisi ile çalışmasını bildiği interface arasına girer ve uyumsuz classı, o interface ile uyumlu hale getirir. Yani işimize yarayan çağırmasını bildiğimiz arayüze sahip olmayan nesneyi kullanılabilir yapar. İstediğimiz arayüze sahip olmayan nesnenin arayüzüne dokunmadan, onu adaptör yardımıyla sarmalayarak gerçekleşir. Uyumsuz nesnenin yeni arayüzü adaptör tarafından belirlenmiş oluyor. Adaptor, uyumsuz nesnenin wrapperı olmuş oluyor.  

 ```java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Türk cihazımız
        TurkishPlug turkishDevice = new TurkishDevice();
        
        // Türk cihazını doğrudan çalıştırıyoruz
        turkishDevice.provideElectricity();
        
        // Türk cihazını ABD prizinde çalıştırmak için adaptör kullanıyoruz
        USPlug adapter = new TurkishToUSAdapter(turkishDevice);
        adapter.providePower();
    }
}

// Türkiye'deki adaptörler için Interface
interface TurkishPlug {
    void provideElectricity();
}

// Türkiye adaptörü (bununla uyumlu bir cihaz)
class TurkishDevice implements TurkishPlug {
    @Override
    public void provideElectricity() {
        System.out.println("Türkiye prizinden elektrik sağlanıyor.");
    }
}

// ABD'deki adaptörler için Interface
interface USPlug {
    void providePower();
}

// ABD adaptörü (bununla uyumlu bir cihaz)
class USDevice implements USPlug {
    @Override
    public void providePower() {
        System.out.println("ABD prizinden güç sağlanıyor.");
    }
}

// Adaptör sınıfı: TurkishPlug'u USPlug ile uyumlu hale getiriyor
class TurkishToUSAdapter implements USPlug {
    private TurkishPlug turkishPlug;

    public TurkishToUSAdapter(TurkishPlug turkishPlug) {
        this.turkishPlug = turkishPlug;
    }

    @Override
    public void providePower() {
        // TurkishPlug'un metodunu çağırarak uyum sağlar
        turkishPlug.provideElectricity();
    }
}

 ```

Bu kodda turkishDevice objesi oluşturuluyor. Bu obje ile türk cihazı doğrudan çalıştırılıyor ve ekrana "Türkiye prizinden elektrik sağlanıyor." bastırılıyor. Sonrasında TurkishToUSAdapter  classının bir instance'i oluşturuluyor ve turkishDevice(TurkishPlug interface'i türünden) nesnesini alarak USPlug interface'ine uyarlıyor ve bu nesne adapter nesnemiz. adapter.providePower() metodu çağırıldığında providePower() metodu çağırılır o da içinde  turkishPlug.provideElectricity() metodunu çağırır ve ekrana "Türkiye prizinden elektrik sağlanıyor." bastırır. (Dikkat edersen constructor injection yapılıyor)

• Eğer ikiyönlü bir adaptöre ihtiyacımız varsa iki interface'i de implement etmeliyiz;

 ```java
class BidirectionalAdapter implements TurkishPlug, USPlug {
    private TurkishPlug turkishPlug;
    private USPlug usPlug;

    // İki adet constructor var
    public BidirectionalAdapter(TurkishPlug turkishPlug) {
        this.turkishPlug = turkishPlug;
    }

    public BidirectionalAdapter(USPlug usPlug) {
        this.usPlug = usPlug;
    }

    // TurkishPlug arayüzündeki metodu implemente ediyor
    @Override
    public void provideElectricity() {
        if (usPlug != null) {
            usPlug.providePower();
        }
    }

    // USPlug arayüzündeki metodu implemente ediyor
    @Override
    public void providePower() {
        if (turkishPlug != null) {
            turkishPlug.provideElectricity();
        }
    }
}
 ```

• Entegrasyon katmanlarında da sıklıkla Adaptor kalıbından faydalanılır. 

## Composite
• Bütün parça ilişkisini birbirlerinden ayırmaktır amacı. Parça bütün ilişkisini göstermek için nesneleri ağaç yapılarında ifade edilir. Composite nesne, istemcilerin tekil nesneleri ve bu nesnelerin compositelerini(bileşiklerini) aynı şekilde işlemesine izin verir.  Composite nesnenin kullanımının istemciye fazladan yük getirmemesini sağlar.   
• Composite kalıbında, parçalar ile bütünün ortak bir arayüze sahip olması sağlanır. Böylece istemci composite nesneyi de parçaları da aynı şekilde kullanır. Sonrasında bileşik nesne ile parçalar arasındaki ilişki düzenlenir. Bu amaçla composite nesnenin bir collection interface'ine sahip olması sağlanır. Dolayısıyla istemci, bütün-parça ilişkisinin karmaşıklığından uzak tutulur ve parçalar ile uğraşmayıp sadece bütün ile iletişimde olur.  
• Parça bütün ilişkisinin olduğu yerlerde composite kalıbı kullanılabilir. Composite nesnede aynı zamanda parçadır. Composite nesnelerdeki metotların iterative olması gerekebilir. 
 
 ```java
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Dosya ve dizin oluşturma
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        Directory directory1 = new Directory("Directory1");
        directory1.addComponent(file1);
        directory1.addComponent(file2);

        File file3 = new File("File3.txt");
        Directory directory2 = new Directory("Directory2");
        directory2.addComponent(file3);
        directory2.addComponent(directory1); // Directory1'i Directory2'ye ekliyoruz

        // Yapıyı göster
        directory2.showDetails();
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
           System.out.println(" burada  ");
	         component.showDetails();
	         System.out.println(" bitiyor  ");
        }
    }
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}
 ```
> Ekran çıktısı:  
Directory: Directory2   
 burada     
File: File3.txt   
 bitiyor     
 burada     
Directory: Directory1   
 burada    
File: File1.txt   
 bitiyor     
 burada     
File: File2.txt   
 bitiyor     
 bitiyor     

 Burada bir bileşen ağacında hem tek bir nesneyi(leaf) hem de grup nesnesini(composite) tek bir FileSystemComponent interface'i  ile yönetmeyi sağladık. Böylece istemci, bileşenleri aynı şekilde işlemesi için bir standart sağlanmış oldu. Yani FileComponentInterface'i sayesinde, bu bileşenlerin hepsi aynı şekilde işlenir yani, File veya bir Directory nesnesi olmasına bakılmaksızın hepsine aynı metod ile erişim sağlanır. Facade bir alt sistemin sağladığı hizmetleri tek ve basit bir arayüz (API) üzerinden sunmanın yoludur. 
 
• 

## Façade
• Karmaşık bir alt sistemi kullanmayı kolaylaştırmayı amaçlar.Bir altsistemdeki arayüzlere bileşik bir arayüz sağlar. Buradaki arayüz terimi Java'daki interface ile karıştılmamalıdır, burada söz konusu olan API(Application Programming Interface). API, kullanıcıların veya diğer sistemlerin belirli işlevleri veya veri yapılarını nasıl kullanabileceklerini tanımlar ve karmaşık sistemlerin daha anlaşılır bir şekilde kullanılabilmesini sağlar.      
• Sistemlerin karmaşıklığını yönetmek için parçalayark alt sistemlere bölebiliriz. Bu durumda alt sistemler birbirinin istemcisi durumuna gelir. Alt sistemler arasındaki bağımlılıkların da olabildiğince asgari düzeyde tutmak gerekir.    
• Facade alt sistemlere bir giriş noktası sağlar, alt sistemlerin interface'i olur. Pek çok ince(fine-grained) interfaceden oluşan bir sistemi, kalın(coarsa-grained) bir arayüze dönüştürür.    
• Facade'ın birlikteliği(cohesion) düşük, bağımlılığı(coupling) yüksek olma eğilimindedir.    
• Facade'ın metotları süreci başlatan, yönlendiren ve sonlandıran nitelikte olur. Bu yüzden de metotları fazla sayıda parametre alma eğilimindedir. Facade nesneleri genelde stateless(durumsuz nesnelerdir). Aksi taktirde stateful nesneler Facade nesnelerinin sayısı istemci sayısına paralel olarak artar ve bu da ölçeklenebilir(scalability) problemlerini ortaya çıkarır.     
• Kurumsal uygulamalardaki katmanlar(tiers/layers) arasındaki ilişkiyi basitleştiren en temel yapıdır.    
• Facade ile Adapter arasındaki fark nedir? Facade karmaşık arayüzleri basit olanla değiştirir, Adapter ise uyumsuz arayüzü uyumlu hale getirir.    

 ```java
public class Client {
    public static void main(String[] args) {
        MediaFacade mediaFacade = new MediaFacade();

        // Bir medya dosyası oynatma
        mediaFacade.playMedia("song.mp3", "movie.mp4", "subtitles.srt");
    }
}
class MediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private SubtitleManager subtitleManager;

    public MediaFacade() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        subtitleManager = new SubtitleManager();
    }

    public void playMedia(String audioFile, String videoFile, String subtitleFile) {
        audioPlayer.playAudio(audioFile);
        videoPlayer.playVideo(videoFile);
        subtitleManager.loadSubtitles(subtitleFile);
    }
}
class AudioPlayer {
    public void playAudio(String fileName) {
        System.out.println("Playing audio: " + fileName);
    }
}

class VideoPlayer {
    public void playVideo(String fileName) {
        System.out.println("Playing video: " + fileName);
    }
}

class SubtitleManager {
    public void loadSubtitles(String fileName) {
        System.out.println("Loading subtitles from: " + fileName);
    }
}

 ```

## Proxy
• Amaç bir nesneye erişimi kontrol etmektir. Ona olan erişimi kontrol etmek amacıyla bir başka nesne için geçiş(surrogate) ya da ara nesne(gerçeği yerine geçen(sahte) nesne) sağlar. Bu nesneye Proxy denir. İstemci olabildiğince kısıtlardan haberadr olmamalı, sanki asıl nesne ile çalışıyormuş gibi, normal çalışmasına devam etmelidir. Geçiş nesnesinin arayüzü, saklanan nesne ile aynı olursa istemci bu durumdan haberdar olmaz, asıl nesne ile aradaki nesneyi ayırt edemez.    
• Proxy nesne istemciyi asıl nesneden yalıtır ve asıl nesneye olan bağımlılığı ortadan kaldırır. Proxy nesne kısıtları yöneterek asıl nesnenin birlikteliğini yükseltmeye da yardımcı olur.    
• Proxy'nin kullanıldığı yaygın durumlar; lazy loading, güvenlik, önbellekleme ve ağ erişimi.    

 ```java
// Subject Interface:Proxy ve gerçek nesnelerin uygulaması gereken bir
//interface veya classtır
interface President {
    void giveSpeech();
}

// RealSubject: Asıl nesne Proxy'nin erişimi kontrol ettiği asıl nesne
class RealPresident implements President {
    private String name;

    public RealPresident(String name) {
        this.name = name;
    }

    @Override
    public void giveSpeech() {
        System.out.println(name + " is giving a speech.");
    }
}

// Proxy: Gerçek nesneye erşimi kontrol eden class.Genellikle yapılan çağrıları
//gerçek nesneye yönlendirir.  
class ProxyPresident implements President {
    private RealPresident realPresident;
    private String name;

    public ProxyPresident(String name) {
        this.name = name;
    }

    @Override
    public void giveSpeech() {
        if (isAuthorized()) {
            if (realPresident == null) {
                realPresident = new RealPresident(name);
            }
            realPresident.giveSpeech();
        } else {
            System.out.println(name + " is not authorized to give a speech.");
        }
    }

    private boolean isAuthorized() {
        // Burada, yetkilendirme kontrolü yapılabilir.
        // Örneğin, belirli bir koşul veya kullanıcı durumu.
        // Şu an için tüm başkanlar yetkili kabul edelim.
        return true; // Yetkili
    }
}

// Test
public class ProxyPatternDemo {
    public static void main(String[] args) {
        President president1 = new ProxyPresident("Alice");
        President president2 = new ProxyPresident("Bob");

        // Başkan vekilini kullanarak konuşma yapmayı deneyelim
        president1.giveSpeech(); // Alice konuşma yapıyor
        president2.giveSpeech(); // Bob konuşma yapıyor
    }
}

 ```
• Proxy ile Adapter arasındaki fark; proxynin sakladığı nesne ile proxy nesnesi aynı interface implement eder. Adapter ise farklı interfacededir.    
• Proxy ile Facade arasındaki fark; proxynin sakladığı nesne ile proxy aynı arayüzdedir. Facade, farklı arayüzleri basitleştirerek bir yerde toplamaktadır. Facade olduğunda clienların durumdan haberi olurken proxyde clientların durumdan haberi yoktur.      

## Decorator
• Amaç;nesneye dinamik olarak yeni özellikler kazandırmaktır. 
• Sıklıkla, yeni sorumluluğu/yetkinliği tüm sınıfa değil, nesnelere eklemek isteriz. Sorumlulukları sınıfa eklemek için tipik olarak mirası kullanırız. Sınıflara yetkinlik eklemek için inheritance kullanılmasının en temel problemi, inheritance'ın bir derleme zaman(compile time) yapısı olmasıdır. Her yeni yetkinlik için kod değişikliği ve tekrar derleme(recompalition) gerekir. Böyle çok yetkinliğin ve kombinasyonların söz konusu olduğu hallerde, hem derin hem de geniş nesne hiyerarşileri oluşur hem de çoklu miras(multiple inheritance) kullanılmak zorunda kalınır. (n farklı sorumluluk için n! alt sınıfa ihtiyaç olabilir.) **Bunun yerine miras (inheritance) ile is-a ilişkisi yerine nesne bileşimi(object composition) ile has-a ilişkisi kullanılmadır.** Yeni sorumlulukları yeni alt sınıflarla yerine getirmektense -alt sınıf ihtiyacını doğuran şeyi bir dekorasyon/bezeme malzemesi- nesnesi olarak görmek ve sınıfın nesnelerine eklemek daha sağlıklıdır. Decorator pattern; nesne bileşimini(composition) sınıf kalıtımına(inheritance'a) tercih eder.  
•  Sınıf kalıtımı, bir derleme zamanı yapısıdır ve çalışma zamanında değişmez. Nesne birleştirmesi(object composition) çalışma zamanı yapısı olduğu için değişiklik yapılabilir. Yani inheritance statik, compositıon dinamik bir yapıdır. Bu sebeple composition, çok sayıda farklı durumu ifade etmede esnekli sağlar. 
• Builder ile decorator arasındaki fark;Builder bir nesneyi sıfırdan build eder. Decorator ise composite bir nesneyi yolda ekleye ekleye build ediyor. 
• java.io'da decorator pattern'ı kullanılır. FileInputStream aslında bir InputStream'dir. FileInputStream kendi cinsinden constructor'ına obje alır. Bu demek oluyor ki filedan okursun zipleyen stream'e geçersin(filedan okuduğunu zipler yani).  
• Web yapılarındaki filtreler de decorator pattern'ı kullanılır.Web uygulamalarında istemciden gelen isteğin ya da ona döndürülen cevabın önce farklı konularda işlenmesine ihtiyaç duyulur. Örneğin; oluşturulan cevap önce XML'e çevrilir sonra XSLT transformasyonuyla bezenir, sonra ziplenir en son olarak da şifrelenir. Bu işlemlerin tam tersi gelen istekler için yapılır. 
• Decorator kalıbının Composite'den farkı, decoratorde sorumluluk decorator nesnelerinde, compositede ise composite nesnede olmasıdır. Composite'de bileşik nesneye eklenen nesneleri yönetmek bileşik nesnenin sorumluluğundayken Decorator kalıbında sorumluluk dekoratör nesnelerindedir. **Yani decarotor kalıbında bütün-parça ilişkisi yoktur, nesnenin süreç içinde donatılması söz kosudur.** Dekoratörleri bir araya getirerek composite bir obje oluşturmuyoruz, object composition'ı kullanarak dekoratörleri oluşturuyoruz. 

 ```java
// Kahve arayüzü
interface Coffee {
    String getDescription();
    double cost();
}

// Temel Kahve sınıfı
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double cost() {
        return 2.00; // Basit kahvenin fiyatı
    }
}

// Dekoratör sınıfı
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription(); // Dekoratör, dekoratörünün tanımını sağlar.
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost(); // Dekoratör, dekoratörünün fiyatını sağlar.
    }
}

// Vanilya şurubu dekoratörü
class VanillaSyrupDecorator extends CoffeeDecorator {
    public VanillaSyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Vanilla Syrup";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost(); // Vanilya şurubu ekleme maliyeti 0
    }
}

// Krema dekoratörü
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        // Krema maliyeti, eğer üstte bir VanillaSyrupDecorator varsa bedava
        if (decoratedCoffee instanceof VanillaSyrupDecorator) {
            return decoratedCoffee.cost(); // Krema bedava
        } else {
            return decoratedCoffee.cost() + 5.00; // Krema fiyatı 5 lira
        }
    }
}

// Ana program
public class Main {
    public static void main(String[] args) {
        Coffee myCoffee = new BasicCoffee(); // Temel kahve
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        // Vanilya şurubu eklenmiş kahve
        myCoffee = new VanillaSyrupDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        // Krema eklenmiş, vanilya şurubu varsa bedava
        myCoffee = new WhippedCreamDecorator(myCoffee); // Vanilya şurubu var
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        // Yeni bir temel kahve oluşturarak krema ekliyoruz ama vanilya şurubu yok
        Coffee anotherCoffee = new BasicCoffee();
        anotherCoffee = new WhippedCreamDecorator(anotherCoffee); // Vanilya şurubu yok
        System.out.println(anotherCoffee.getDescription() + " $" + anotherCoffee.cost());

        // Süt eklenmiş kahve
        anotherCoffee = new MilkDecorator(anotherCoffee);
        System.out.println(anotherCoffee.getDescription() + " $" + anotherCoffee.cost());
    }
}
 ```

## Bridge
• Amaç soyutlama ile gerçekleştirilmesini birbirinden ayırarak birbirinden bağımsız olarak değiştirilebilmesini sağlar.Temelde iki prensibi alır; değişen ile değişmeyen ksıımları ayırmak ve composition'ı kalıtıma tercih etmektir.    
• Normalde soyutlamalar ile gerçekleştirilmeleri birbirinden ayrı değildir aralarında kalıtım yani is-a ilişkisi vardır. Soyutlama arayüzü, farklı alt tipleri ise arayüzün farklı gerçekleştirmelerini belirler. 
  
• Kalıtımda gerçekleştirme, soyutlamadan hem arayüz hem de gerçekleştirme devalabilir. Kalıtım interface birliği sağlar, gerçekleştirmeler asgari halde soyutlamalarla aynı interface'e sahiptir. Ama soyutlamanın tipine, sınıf ya da arayüz olmasına ve gerçekleştirmenin neyi devraldığına ve ne kadar metot ezdiğine göre farklı miktarda gerçekleştirme devralması söz konusudur. Soyutlamalar ile implamention arasındaki ilişki is-a olarak ifade  edildiğinde iki tarafı da kısıtlayan bir durum oluşur. Soyutlama değişirse gerçekleştirmeler de değişmek zorunda kalır. Bazen de implementationların soyutlamalara uyma zorunluluğu, onların rahatça geliştirilmelerini önler.   
• Soyutlamalar ile onların implementationları arasındaki ilişki is a olarak görülmek zorunda değil, bazen has-a olarak gösterilebilir. is a olan ilişki has a'ye döndürüldüğünde gerçekleştirmelerin soyutlamalara olan bağımlılığı azalır, çünkü devralmak değil kullanmak söz konusudur ve bundan dolayı soyutlamalardaki değişiklikler, gerçekleştirmeleri etkilemez. Soyutlamalar rahatça değiştirilebilir. Arayüzleri değiştirilmez çünkü istemciler kırılır ama gerçekleştirme detayları rahatça değiştirilebilir, soyutlamaları gerçekleştiren sınıflar bundan etkilenmez. Implementationlar rahatlıkla değiştirilebilir çünkü hem arayüz hem de implementation detayı olarak kendisine uymak zorunda olduğu soyutlamalar yoktur ya da vardır ama aralarındaki ilişkideki uyumluluk problemli değildir çünkü ilişki is a değil has a'dir.   
• **Bridge kalıbı, soyutlamalar ile onların implementaionları arasında var olan is a ilişkisini has a ilişkisine çevirir.** Bu durumda soyutlamalar ve gerçekleştirmeler ayrı hiyerarşilerde tutulur. Aralarında has-a ilişkisi olur, bridge adlandırılan kısım aslında bu kısımdır. Bu şekilde iki tarafın arasındaki bağımlılığı azaltmayı hedefler.   
• **Soyutlama(abstraction)** kullanıcının etkileşime bulunduğu yüksek seviyeli bir arayüze sahiptir. Bu işlevselliği temsil eder fakat detaylarına inmez. **Gerçekleştirme(implementation)** soyutlamanın gerçekleştirilmesidir. Gerçek işlevselliğin uygulandığı yerdir.   
• Abstract factory ile arasındaki fark; abstract factoryde amaç nesne üretmektir. Bride'de ise amaç hig couplingiden low couplinge geçirmektir.   
• Karmaşıklığı arttırmak pahasına esneklik sağlar.   
 
 ```java
// Implementation
interface Color {
    void applyColor();
}

// Concrete Implementation A
class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red color applied.");
    }
}

// Concrete Implementation B
class Green implements Color {
    @Override
    public void applyColor() {
        System.out.println("Green color applied.");
    }
}

// Abstraction
abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

// Refined Abstraction A
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Circle drawn with ");
        color.applyColor();
    }
}

// Refined Abstraction B
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Square drawn with ");
        color.applyColor();
    }
}

// Client Code
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape greenSquare = new Square(new Green());

        redCircle.draw();    // Circle drawn with Red color applied.
        greenSquare.draw();  // Square drawn with Green color applied.
    }
}
 ```


# Davranışsal Kalıplar(Behavioral Pattern)
• Davranışsal kalıplar , algoritmalar ve sorumlulukları sınıflara atamak ile ilgilir. Sadece sınıflar ve nesnelerle değil aynı zamanda onların arasıbndaki haberleşmeyle de ilgilidir. 
• Davranışsal sınıf kalıpları kalıtımı kullanırken, davranışsal nesneler kalıpları composition kullanır. Yani hem has a hem de is a ilişkisi bulunur. 

## Strategy   
•   Amaç; bir işi yapmanın farklı yollarını, o işi isteyen istemciden bağımsız ve birbiri yerine geçebilecek şekilde ifade eder.   
• Durum kontrolleri yapılırken kullanır gibi düşün; if-else if yapısının  ya da switch-case yapısının bir dalı olarak ifade ederek algoritma aile gerçekleştirilir. Ancak bu çözüm uzun vadeli değildir ve çoğunlukla tek bir algoritma olduğu düşüncesine dayanır, değişimi göz önüne almaz. Algoritmanın farklı iki implementationını aynı yerde birbirini etkileyecek aralarında coupling oluşturacak şekilde implement etmemeliyiz. İstemci algoritmalardan bağımsız olmalıdır.  istemci algoritmaları yapmamalı, algoritmalardan hizmet istemeli.    
• Farklı algoritmaları istemciden bağımsız bir şekilde kendilerine has farklı yerlerde gerçekleştirmek ve onları birbiri yerine geçebilecek şekilde kullanmalıyız. Bu durumda hem algoritmalar birbirinden ayrılacak ve aralarında gelişigüzel bağımlılıklar oluşmayacak hem de istemci bu algoritmaları gerçekleştirenlere doğrudan bağımlı olmayacaktır. **Kısacası strategy kalıbının çözümü bir arayüzü gerçekleştiren kardeş sınıflardır.** Her kardeş sınıf ayrı bir algoritmayı yerine getirir.  Hangi sınıfın kullanılacağını ise bir başka nesne, çoğunlukla bağlam karar verir.   
• Bu yapıda istemci ile algoritmalar arasında soyut bağımlılık vardır. Bu şekilde istemci farklı davranışlara, stratejilere sahip bir yapı haline gelir. Stratejiler hem istemciden hem de birbirinden bağımsız olarak değişebilir. Yeni stratejiler kolayca eklenebilir ve istemci zengin davranışlara sahip olabilir. İstemci böylelikler SRP VE OCP'ye uygun hale gelir.     
• Ne zaman bir şeyi hesaplamanın farklı yollarıyla karşılaşırsak bir iş kuralının bir faktöre göre değşen şekilleri vs. varsa Strategy kalıbı kullanılmalıdır. O anda tek bir yol olsa bile bu yapılmalı ileride iş evrildikçe birden fazla yolu çıkacaktır.    
• Negatif yönü ise her algroritma farklı sınıf ile ifade edildiğinde sınıf ve nesne sayısı artar.    
• Abstract factory bir nesne ailesini oluştururken Strategy algoritma ailesini yönetir. Strategy ve Proxy yapısal olarak birbirine benzese de farklı çözümlerdir. Proxy'de saklanan nesne ile onun vekili bir algoritmanın farklı gerçekleştirmeleri değildir. Strategy, Command'in özel bir hali olarak görülebilir.    

 ```java
public class Client {
    public static void main(String[] args) {
        SortingStrategyFactory factory = new SortingStrategyFactory();

        int[] smallArray = {34, 7, 23, 32, 5, 62}; // 6 eleman
        int[] mediumArray = new int[200]; // 200 eleman
        int[] largeArray = new int[1000001]; // 1,000,001 eleman

        // Rastgele sayılar ile doldur
        for (int i = 0; i < mediumArray.length; i++) {
            mediumArray[i] = (int) (Math.random() * 10000); // 0-9999 arası rastgele sayı
        }

        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 10000); // 0-9999 arası rastgele sayı
        }

        System.out.println("Sorting small array using factory:");
        SortingStrategy smallArrayStrategy = factory.getSortingStrategy(smallArray);
        smallArrayStrategy.sort(smallArray);

        System.out.println("Sorting medium array using factory:");
        SortingStrategy mediumArrayStrategy = factory.getSortingStrategy(mediumArray);
        mediumArrayStrategy.sort(mediumArray);

        System.out.println("Sorting large array using factory:");
        SortingStrategy largeArrayStrategy = factory.getSortingStrategy(largeArray);
        largeArrayStrategy.sort(largeArray);
    }
}

public class SortingStrategyFactory {
    public SortingStrategy getSortingStrategy(int[] array) {
        int length = array.length;

        if (length < 100) {
            return new BubbleSort();
        } else if (length >= 100 && length < 1000000) {
            return new QuickSort();
        } else {
            return new ArraysSort();
        }
    }
}

public interface SortingStrategy {
    void sort(int[] array);
}

public class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted using Bubble Sort");
    }
}

public class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println("Array sorted using Quick Sort");
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
import java.util.Arrays;

public class ArraysSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
        System.out.println("Array sorted using Arrays.sort");
    }
}
 ```

## Command   
•  Amaç; istekte bulunan istemci  ile isteği yeribne getiren arasındaki bağımlılığı azaltmak ve metot seviyesinde ifade edilen isteği nesne seviyesinde soyutlayarak ek yetkinlikler kazandırmatır. 
•   

## Iterator   
•   Amaç; collectionlardaki birden fazla nesneye sıralı erişim için bir yol sağamaktır. 
•

## Mediator 
•  Amaç; cok sayıda nesnenin birbiriyle haberleşmesini ve koordinasyonunu sağlamaktır. 
•  

## Template Method  
•   Amaç;bir algoritmanın genel yapısını ifade edip, değişecek adımları içi doldurulacak şekilde bırakmaktır.
• 

## Observer  
•   Amaç; bir nesnenin durumundaki değişikliklerden haberdar olmaktır.  
•   

## Memento  
•   Amaç; sarmalamayı bozmadan, sonra ulaşmak üzere bir nesnenin durumunu saklamaktır.
•  

## Chain of Responsibility  
•   Amaç;istekte bulunan istemci ile isteği yerine getiren arasındaki bağımlılığı azaltmaktır. 
•   

## Visitor    
• Amaç; bir işi birden çok nesneye, o nesnelerin arayüzlerini değiştirmeden yaptırmayı sağlamaktır.      
• 

## State  
•   Amaç; bir nesnenin karmaşık durumlarına bağlı olan davranışlarını ifade etmektir. 
•  

## Interpreter  
•   Amaç; bir dildeki cümleleri yorumlamak amacıyla yorumlayıcı tanımlamaktır. 
•   







