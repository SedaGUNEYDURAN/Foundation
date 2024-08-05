# Cohesion(Birliktelik )
•  Tek bir amaca sorumluluğa odaklanır(single responsibility). Bir fonksiyon/metot ne kadar az iş yaparsa birlikteliği o kadar yüksek olur. Çeşitleri vardır;  

  - Gelişigüzel(Coincidental): Bir araya getirilmiş ilgisiz yapılardır. Örneğin; util classları  
  - Mantıksal(Logital):Gerçekte farklı tabiatta  olmalarına rağmen tek bir şey ile ilgili olduğu düşünülen bir araya getirilmiş yapılardır. Örneğin; Cutter class’ında cutHair() cutTalk() metodunun bulunması gibi.  
  - Zamansal(Temporal): Zamansal birliktelikten dolayı bir araya getirilmişlerdir.  
  - Prosedürel(Procedural):Bir konu ile ilgili işlerin yukarıdan aşağıya doğru fonksiyonel olarak ayrılması ve hepsinin bir sınıfta bir araya getirilmesi. Örneğin; dosya açmakla ilgili her şeyi yapan, dosya erişimini ve gerekli belleği kontrol eden, dosyayı açıp kaydedip e-mail olarak gönderen bir class.  
  - İletişimsel(Communicational/Informational): Aynı veri üzerinde çalışan yapıların bir araya getirilmesidir. Veri işlemenin öne çıktığı durumlarda görülür.   
  - Ardışıl(Sequential): Class sevğiyesinde birinin çıktısının diğerini beslediği, pipe şeklinde çalışan fonksiyonları bir araya getiren claslardır.   
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


# SOLID
•**Single Responsibility Principle**: : Bir sınıfın değişmesi için asla birden fazla sebep olmamalıdır. Bir classın fonksiyonel birlikteliğe sahip olması gerektiğini ifade eder. Bir sınıf öyle odaklı olmalıdır ki değişmesi için birden fazla sebep olmamalıdır. Bir sınıf sadece bir şeyi soyutlamalı ve sadece ona odaklanmalı, onunla ilgili veriye sahip olmalı ve sorumluluları yerine getirmelidir. Dolayısıyla da bir sınıf sadece bir soyutlamayla ilgili Sebeplerden dolayı değişebilir. **Separation of Concerns** prensibinin bir uygulaması olarak görülebilir.

  - **Separation of Concerns**: Sorunları ayrılmasıdır. Yazılım geliştirme sürecinde karmaşıklığı azaltmak ve yazılımın daha esnek, sürdürülebilir ve ölçeklenebilir olmasını sağlamak amacıyla kullanılır. Katmanlı mimari, MVC, Mikroservisler bu prensibin uygulandığı bazı yaklaşımlardır.   
  - **DRY(Don't Repeat Yourself)**: Eğer bir statement ya da bloğun birden fazla yerde bulunması gerekiyorsa, bu ifade bir metoda dönüştürülmelidir. Hiç bir kod parçası asla tekrar etmemelidir ve sistemde sadece bir yerde bulunmalıdır.
  - Bazen sınıfların birden fazla interface'i implement ederek, pek çok role sahip olduğu görülür. Özellikle yetkinlik kazandırmak amacıyla bir API'nin parçası olan interfaceleri yerine getiren ama aynı zamanda bir rolü olan nesnelerde bu durum yaygındır. Böyle sınıflar **composite/aggregate(bileşik/küme sınıf) olarak adlandırılır. Böyle interfacelere fat, pollued olarak adlandırılır ve code smell oluşturur.
  - Eğer single responsibility prensibi ihlal edilirse fat classlar ortaya çıkar. Fat class; yazılım geliştirmede fazla büyük ve karmaşık hale gelmiş classları tanımlar. Çok fazla sorumluluğa sahiplerdir.            
      
•**Open-Closed Principle**: Yazılım yapıları(classlar, modülleri, fonksiyonlar, metodlar ) genişletilmeye açık ama değişime kapalıdır.  Burada genişletmek kasıt; yapının en baştan itibaren, değişimi göz önüne alacak şekilde, değişebilecek kısımların, değişmeyecek kısımlardan yalıtılarak kurgulanması, dolayısıyla yeniliklerin var olan yapıları değiştirmeden yapılması, kaçınılmaz bağımlılıkların olabildiğince soyutlamalar üzerinden yapılması, gerçekleştirmelere bağımlılık oluşturulmamasıdır.  Sonucunda var olan tiplerin farklı amaçlara hizmet edecek şekilde alt sınıflarının oluşturulması ve sahip olduğu davranışları override(ezmesi) ile farklılaştırılması söz konusudur. Düşük birliktelikli yapılardan, iç yapılara bağımlılıktan, somut tiplere bağımlılıktan, global değişkenler, run time type identification gibi durumlardan kaçınılmalıdır.     
•**Liskov Substitution Principle**: Taban sınıflara(base class) işaretçi ya da referans kullanılan fonksiyonlar türetilen sınıfların nesnelerini de (gerçek tiplerini) bilmeden kullanabilmelidir.  Yani türetilmiş sınıf, temel sınıfın her türlü davranışını korumalıdır.  LSP tasarlanan yapının o yapıyı kullanacak istemciler açısından doğrulanması gerektiğini ifade eder. Kurulan modeller ilk bakışta anlamlı ve tutarlı olsa bile aslolan istemcilerin o modeli nasıl kullanacağıdır. İstemcilerin üst arayüzler hakkında yaptıkları kabuller ve sahip oldukları beklentiler, alt arayüzler tarafından da karşılanmalıdır.    
•**Interface Segregation Principle**: İstemciler kullanmadıkları interfacelere bağımlı olmaya zorlanmamalıdır. SRP'nin yüksek birliktelik(cohesion) amacıyla arayüzlere uygulanmış halidir. ISP karşıtı durumun tipik iki göstergesi vardır:

  - Farklı istemcilerin aynı interface üzerindeki farklı metotları çağırması,
  - Interface'in alt tipi olan sınıfların bazı metodlara gerçekleştirme vermekte zorlanması.

Bu durumda bu arayüz bölümelidir. İstemciler sadece ilgilendikleri metotları görmelidir. Alt sınıflar da sadece ihtiyacı olan metotları devralıp gerçekleştirmelidir.   
•**Dependency Inversion Principle** : Yüksek seviyeli modüller aşağı seviyeli modüllere bağımlı olmamalıdır. İkisi de soyutlamalara bağımlı olmalıdır. Soyutlamalar detaylara bağımlı olmamalı, detaylar soyutlamalara bağımlı olmalıdır.(Yüksek seviyeli modül/iş ile kastedilen, uygulamayı oluşturan temel soyutlamalardır. Süreçler ve onları yöneten(süreçsel metotlar) yapılar bu türdendir. Alt seviyeli modül/iş ile kastedilen ise detaylardır. Atomik iş yapan işçi metotlar ve sınıfları bu türdendir.)

  -Somut yapılar arasındaki bağımlılıkların tamamen soyut bağımlılıklara donüşecek şekilde tersine çevrilmelidir. Bu amaçla her somut yapının soyut bir üst tipi oluşturulmalı ve yukarı seviyeli iş yapan yapıların bağımlılıkları soyut tiplere çevrilmelidir. Bu şekilde üst seviyeli soyut yapılar ile onların detayları arasına  soyutlama tabakası konarak, değişimin yayılması önlenmelidir.    
•**Granularity Principle**:  
•**YAGNI(You Arent Gonna Need It) Prensibi**: Geliştiricilere ve ekiplerine gelecekte ihtiyaç duyulacağı tahmin edilen ama şuanda gereksiz olan işlevleri veya özellikleri eklemekten kaçınmayı öğütler. Genellikle Agile yazılım geliştirme metodolojisinde kullanılır. Sadece şuanda gerçekten gerekli olan işlevler üzerine çalışmasılmasına teşvik eder.        
•**Design By Contact**:Yazılım bileşenleri için formal, kesin(precise) ve doğrulunabilir(verifiable) arayüzlerin tasarlanması gerektiğini ifade eder. 
Temel olarak yazılım bileşenlerinin birbiri ile olan etkileşimlerini bir sözleşme çerçevesinde tanımlar. Bu contractlar, bileşenlerin nasıl etkileşime gireceğini açıklayan, ön koşullar(preconditions), son koşullar(postconditions) ve sınıf veya metod değişmezlerini(invariants) içerir. Ön şartlar metodun istemcisi tarafından çağırılması için gereklidir. Son şartlar ise metodun çalışmasını bitirdiğinde oluşacak durum ile ilgilidir. Alt tiplerön şartları(require) zayıflatabilir ve son şartları(ensure) sıkılaştırabilir.  Alt tipler üst tiplerin kabul etmediğini kabul edebilir ve daha iyi daha özel bir hale getirebilir. 
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
  
  - Information Expert: Temel nesne tanımını(encapsulation) vurgular ve bağımlılıklarını ortadan karldırmayı amaçlar. Bir sorumluluğun bir nesneye atanması, o nesnenin bu sorumluluğu yerine getirmek için gereken bilgiyi veya erişimi en iyi şekilde sağlayabilmesidir. 
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

• Buna ek olarak bir çözüm yöntemi daha geliştirilmiştir; private static inner class yani Bill Pugh Singleton Design geliştirildiBu yöntem hem lazy initialization yapar(Java'da bütün sınıflar lazy loading olarak yüklenir, ihtiyaç olmadığı sürece yüklenmez, burada da inner class lazy loading) hem de thread-safe olarak oluşturulur. 

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

    // Diğer metotlarınızı buraya ekleyebilirsiniz
    public void someMethod() {
        // Çalıştırılacak kod
    }
}
 ```



# Factory Method
•Nesne yaratmayı soyutlamak    
# Abstract Factory
•Nesne ailesi yaratmayı soyutlamak    
# Builder:
•Karmaşık nesne yaratma sürecini kurgulamak    
# Prototype: 
•Bir örnek nesneden kopyalamayla  yeni nesneler türetmek     
# Dependency Injection:**  
