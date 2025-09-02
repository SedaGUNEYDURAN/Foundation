# Clean Code 
• Temiz kod, orijinal yazarından başka developer tarafından okunabilir ve geliştirilebilir. Birim ve kabul testlerine sahiptir. Anlamlı isimleri vardır. Bir şeyi yapmanın pek çok yolundan ziyade tek bir yolunu sağlar. Açık-seçik olarak tanımlanmış minimal bağımlılıklara sahiptir ve temiz ve minimal bir API sunar. Kod okunabilir olmalıdır, çünkü sadece programlama diline bağlı kalınırsa, her türlü gerekli bilgi kodda açık bir şekilde ifade edilemez.  
• Kod temiz değilse kötüdür(dirt code) ve code smell'e yani kötü kokuya sahiptir. Karmaşıktır, bakımı zordur, zor anlaşılır, değiştirilmesi maliyetlidir, karmaşıklığı çığ gibi büyür.  
• Temiz kodun 4 temel özelliği vardır;  
• **Basitlik**; anlaşılır, kısa koddur. Kodun basitleştirilmesine, iyileştirilmesine refactoring denir. Bir metotta yapılacak işi bir cümlede yapma. Basit bir kod aynı zamanda odaklı bir koddur yani bir yerde sadece bier şeyi yapmayı hedefler. Mimariye uygun geliştirilir. Anlaşılır isimler kullanılır. Kısa anlamsız isimlendirmelerdense uzun, okunması zaman alan ama anlamlı isimlendirmeler tercih edilmelidir. Aslolan anlaşılır olmaktır, kısa olmak adına anlaşılır olmaktan fedakarlık edemeyiz.İsimlendirmeler soyut ve kapsayıcı olmalıdır. Tutarlıdır. 
  
  - Gerektiği kadar anlaşılmaya yardım edilecek kadar dokümante edilmiştir. Eğer bir kodun anlaşılması için dokümantasyona ihtiyaç duyuluyorsa bunun çözümü öncelikle dokümantasyon değildir. Bir kod dokümante edilerek clean code haline gelmez. Öncelikle refaktöring yapılmalıdır; sınıfı bölüp parçalamak, metot sayısını azaltmak bazen çözüm olabilir. Kod içi dokümantasyonu, açık olanı, görüneni değil iyi isimlendirmeye rağmen görünmeyeni , açık olmayını açıklamalıdır. 
  - Kod dökümantasyonun iki türünden bahsedilebilir; kod içi dokümantasyon ve API dokümantasyonu. Kod içi dokümantasyonu ihtiyaca bağlı olarak //, /* */ şeklinde yapılır. API dokümantasyonu ise kodun arayüzünün dokümantasyonudur.
    
• **Odaklılık**; tekrarsız, tek hedefli. Odaklılık basit olmaya hizmet eder ama kedni başına önemlidir.   Odaklı kod, framework, bileşeni arayüz, paket, sınıf, metot, değişkeni her ne olursa olsun sadece bir şeyi halletmelidir.   
• **Tamlık**; olması gerekeni yapan, olabilecek olana karşı önlemini alan, olmaması gerekeni önleyen koddur.     
• **Doğruluk**; kendi başına doğrulanmış ve çevresiyle birlikte entegre edilmiş koddur. Bir kodun kendi başına doğruluğu ancak unit test ile sınanabilir. Bir kodun çevresindeki diğer kod parçalarıyla birlikte doğru çalıştığı ise entegrasyon testleriyle anlaşılır. Bu testler TDD yaklaşımı ile yapılırsa doğruluk ve tamlık konusunda daha iyi seviyelere gelinebilir.    
İsimlendirme yapılırken genelde 

  - **Camel Case**: Kelimeleri birleştirirken her bir kelimenin ilk harfinin büyük diğer harflerin küçük olduğu yazım biçimidir. (Lower Camel Case: myVariableName; Upper Camel Case: MyVariableName)
  - **Sneak Case**: Kelimeler arasına alt çizgi ekleyerek ve tüm harfleri küçük tutarak yazılır. (my_variable_name)
  - **Kabab Case**: Kelimeleri ayırmak için - kullanılır ve tüm karakterler küçüktür.Genellikle web geliştirme ve URL yapılarında kullanılır.(kabab-case-example) 
  
• Yazılımın büyümesi var olan bileşenlerin büyümesiyle değil yeni orijinal bileşenlerin eklenmesiyle gerçekleşir. Yazılımın bileşenleri arasındaki ilişkiler de doğrusal(lineer) değildir.
• Bir işin yapısı üç parçadan oluşur; işin ürettiği çıktılar(products), iş için gerekli işlemler yada davranışlar(required acts), iş için gerekli bilgi girdisi(information cues). Bunu yazılıma uyguladığımızda iki karmaşıklık oluşuyor;Component complexity(bileşen karmaşıklığı, ayrık işlemlerin karmaşıklığı, bilgi girdileriin karmaşıklığı), Coordinate complexity(ilişkisel karmaşıklı, işlemler arasındaki ilişkilerin karmaşıklığı)


### Cohesion(Birliktelik)
• Tek bir amaca sorumluluğa odaklılıktır. Bileşen karmaşıklığı alt parçaların ne kadar birlikte olduğunun bir ölçüsüdür buna da cohesion denir. Single responsibility, cohesionun ne kadar düşük ya da ne kadar yüksek olduğunun bir ölçüsüdür. 
• Birlikteliği yüksek yani cohesionları yüksek bileşenlerin karmaşıklığı düşük, bakım maaliyetleri düşük ve tekrar kullanıma yatkınlardır.(High cohesion-strong cohesion, low cohesion-weak cohesion)   Çeşitleri vardır;  

  - Gelişigüzel(Coincidental): Bir araya getirilmiş ilgisiz yapılardır. Nesne soyutlamasının eksik ya da hiç olmadığı durumlarda sıklıkla görülür. Örneğin; util classları  
  - Mantıksal(Logical):Gerçekte farklı tabiatta  olmalarına rağmen tek bir şey ile ilgili olduğu düşünülen bir araya getirilmiş yapılardır. Örneğin; Cutter class’ında cutHair() cutTalk() metodunun bulunması gibi.  
  - Zamansal(Temporal): Zamansal birliktelikten dolayı bir araya getirilmişlerdir.  
  - Prosedürel(Procedural):Bir konu ile ilgili işlerin yukarıdan aşağıya doğru fonksiyonel olarak ayrılması ve hepsinin bir sınıfta bir araya getirilmesi. Örneğin; dosya açmakla ilgili her şeyi yapan, dosya erişimini ve gerekli belleği kontrol eden, dosyayı açıp kaydedip e-mail olarak gönderen bir class.  
  - İletişimsel(Communicational/Informational): Aynı veri üzerinde çalışan yapıların bir araya getirilmesidir. Veri işlemenin öne çıktığı durumlarda görülür. (Ortak bir veri yapısı vardı; birisi onu okur birisi onu işler gibi)  
  - Ardışıl(Sequential): Class seviyesinde birinin çıktısının diğerini beslediği, pipe şeklinde çalışan fonksiyonları bir araya getiren classlardır.   
  - Fonksiyonel(Functional): En iyi birliktelik durumudur, büyümeye karşı direnebilir. Tek, çok iyi tanımlanmış ve olabildiğince küçük bir işe ya da sorumluluğa yönelik olarak bir araya getirilmiş yapılardır. Yazılım geliştirme sürecinde detaylar arttıkça diğer birliktelik türlerinde yapılar gittikçe büyüme eğiliminde olurken fonksiyonel birliktelikte bölüp parçalama yoluyla odağın korunmasına çalışılır. Çünkü detay arttıkça iş ya da sorumluğun tanımı değişir buyüzden de her iş farklı ve küçük işlere bölünür.

•  Aşağıdaki iki sınıfın metotlarının da atomik olduğunu varsayarsak hangisini cohesionu(birlikteliği) daha yüksektir? B sınıfının birlikteliği daha yüksektir.Çünkü A sınıfındaki her metotu farklı classlara bölebilirz ancak B sınıfı için bu söz konusu değil. 
 
![image](https://github.com/user-attachments/assets/eb463b75-6746-48e9-bce1-53f78f5ffcc1)


• Ivar Jacobson’ın nesne sınıflandırması; Boundary nesneleri controller nesnelerini, controller nesneleri entityleri kullanırlar.

Boundary: Sistemin aktörleriyle olan iletişimini yöneten nesnelerdir, interface nesneleri de denir. (MVC’de karşılığı view) Pencereler ya da düğmeler gibi UI/GUI bileşenleri, socket bağlantısı yapan nesneler, web servisler bu tipten nesnelerdir.
Controller: İş süreçlerini yöneten ve ilgili kuralları bilen nesnelerdir. Çoğunlukla service olarak bilinirler. (MVC’de karşılığı controller)
Entity: İş alanı(business domain) nesneleridir. (JPA, EntityFramework vb. frameworklerin ürettiği ve sadece veri tabanı tablolarına karşı gelen nesneler bu anlamda entity değildir çünkü davranışa sahip değillerdir.) (MVC’de karşılığı model)

• Aynı roldeki nesneler birbirlerini kullanabilirler.Yani Boundary nesneleri boundary nesneleri, control nesneleri control nesnelerini kullanabilirler.Bunun duşındaki bağımlılıklar içten dışa doğrudur; Boundary nesneleri -> Controller nesneleri-> Entity nesnelerini kullanılar.  Bu kısımda Boundary'nin controllerı atlayarak entity nesnesine ulaşması tavsiye edilmez. Böyle bir  durum gerektiğinde DTO(Data Transfer Objects) kullanılır. (Entity nesnelerinin durumunu temsil etmek için veriyi uygulama üzerinde gezdirmek için). Ya da veriye ulaşabilir ama davranışını değiştiremez bu durumda get setlere ulaşarak yapılabilir. Davranışlara ulaşmaz çünkü davranışlara ulaşan controllerd ır, boundary davranışlara ulaşmaya başlayınca bu sefer boundary nesnesi controller gibi çalışmaya başlar.  

• **Hexagonal(Altıgen, Soğan) Mimari**; soğan gibi katmanlı bir yapıdır. Merkezde business rolelarını yöneten entityler vardır. Bir üst katmanda application lojikler yani uygulama kuralları bulunur. Interface adapter (Controller, presenters, gateways) farklı devicelarla, farklı sistemlerle iletişimde tutar, gerekli veri formatı dönüşümlerini de yönetirler. Frameworks ve Drivers en az kod yazılan ve daha çok tool cinsinden yapılardır. Akış,  Controllerdan başlar ve Use Case ile ilerleyip Presenterda son bulur. Bağımlılıklar dışarıdan içeriye doğru ilerler. 

![image](https://github.com/user-attachments/assets/27010d43-9516-4c73-9636-314786ea3a5b)

• Birliktelik karşıtı kalıpları(cohesion anti pattern) genelde nesnelerin mimarideki ve fonksiyonel yapıdaki rollerini karıştırmaktır, aralarındaki farkları gözetmemekten kaynaklanır.3 yaygın çeşiti vardır; mixes-role cohesion, mixed-domain cohesion, mixed-role cohesion. 

  -  **Mixed-Role Cohesion**: Aynı alan içerisinde olduğu halde farklı rollere sahip nesnelerin özelliklerinin tek bir nesnede toplandığı durumdur. Özellikle entity nesnelerinde çok sık görülür.
  -  **Mixed-Domain Cohesion**: Bir sınıf yazılım alanlarının (domain) nesnelerinin özelliklerini bir araya getirir. (Yazılım alanları; uygulama alanı(application domain), iş alanı(business domain), mimari alanı(architecture domain), temel alan(foundation domain))
 > **Application Domain:** Use caseleri gerçekleştirecek şekilde entityleri manipüle eden service nesneleri ;eventler,eventHandlerlar, workflowlar. Tekrar  kullanımları düşüktür.  
>  **Business Domain:** Objeler, entityler, enum ve interface nesneleridir.   
> **Architecture Domain:** MVC, DAO(Data Access Object)  vb. mimari stiller, transaction, cache, UI/GUI mekanizmaları, web servis, Spring, JPA vs.  Tekrar kullanımı iş alanından ve uygulamadan bağımsızdır ve yüksektir.   
>  **Foundation Domain:** En temel nesneleri içerir. primitives ve wrapper nesneleri, String, date, time, thread vb. müdahale edilemeyecek  sınıflardır.  Tekrar kullanımı çok yüksektir.    

**Application --> Business --> Architecture --> Foundation**


  - **Mixed-Instance Cohesion**: Bir sınıfın bazı özellikleri bazı nesneleri için geçerli bazı nesneleri için geçerli değildir.    Bir class, farklı yazılım alanlarının(domain) nesnelerinin özelliklerini bir araya getirir.  Nesneler, alanlarına has olmalıdır, birden fazla alan tek bir nesneden temsil edilmemelidir.



### Coupling (Bağlılık )
• Koordinasyon karmaşıklığı, bir işin kendi başına ifade edilebilirliğinin ya da diğerleriyle ne kadar ilgili(relatedness) olduğunun ölçüsüdür. İlgililik, bağlılıktır(coupling) ve bağımlılığı düşük olan bileşenlerin karmaşıklığı da düşüktür.Aslolan şey veri alışverişi değil hizmet alışverişidir. **Olabilecek en iyi coupling; veriler üzerinden değil davranışlar üzerinden olandır.**

  - **Low/loose/weak  coupling**: Bir classın başka bir classa olan bağımlılığı mümkün olduğunca azdır. Classlar arasındaki 
      etkileşim interfaces veya abstracts yoluyla gerçekleştirilir. 
  - **Tight coupling**: Bir classın bir classa bağımlılığı fazladır. Bir classsın iç detayları diğer classlar tarafından çok 
      fazla kullanılıyorsa vardır. Bakımı zordur ve kötü tasarımın işaretidir.  
![image](https://github.com/user-attachments/assets/1d17e8c3-e133-42cc-b682-6617e283ac0d)

• En kötüsünden en iyisine doğru coupling tipleri;

  - İçerik(Content): Yapıların birbirlerinin iç yapılarına, gerçekleştirmelerine (implementation) bağımlı olduğu durumlardır. 
      Yanlış soyutlama temel sebeptir. Doğrudan alan erişimi ya da set/get metotları yoluyla veri alışverişi en sık görülendir. 
      Birlikte değiştirme sorunu oluşturur.   
  - Common(Coupling):Global veri ve değişkenleri kullanan yapılar arasındaki bağımlılıktır. Sabitler, statik özellikler ve 
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
      
• Literatürde anlam bağımlılığı (semantic coupling) gibi farklı isim ve içerikte bağımlılıklar da vardırç. Nesne-merkezli dillerde farklı bağımlılık türleri:

  - **Miras bağımlılığı(Inheritance coupling)**: Üst yapı ile ondan türetilen yapı arasındaki bağımlılıktır. is-a bağımlılığıdır.Miras ile üst tipten neyin devralındığına göre iki temel çeşidi vardır:
    > **Interface Inheritance:** sadece interface devralındığından bağımlılık mesaj seviyesindedir. Sağlıklı bir bağımlılıktır.    
    > **Implementation Inheritance:** Üst tip ile alt tip arasında içerik bağımlılığı kurulur.Yapısal tip benzerliği olan durumlarda dışında kullanmamak tavsiye edilir. Classları extend etmektir. Bundan kaçınmak için bazı patternler bile geliştirilmiştir; decorator gibi  
  - **Soyut bağımlılık(abstract coupling)**: Soyut olan üst yapılara olan bağımlılıktır.Hem is-a hem has-a ilişkisinde kullanır. Soyut bağımlılıkta, gerçekleştirme
      mirası(implementation inheritance) ile arayüz mirası(interface inheritance) kullanılır. Mesaj bağımlılığının bir üst,
      daha iyi halidir. Abstract couplingte has-a halinde nesneler birbirlerinin interfacelerini belirleyen üst tipi belirler, gerçek tipi bilmez(polymorphism).
      Dependency Inversion(DI) ile elde edilir. Burada hem is-a hem de has-a bağımlılıkları soyuttur. 
    ![image](https://github.com/user-attachments/assets/d857b78c-7cc7-4ea9-a6da-5c2bb115c429)

• **Cohesion ile coupling arasındaki fark**; Coupling;İki veya daha fazla modül arasındaki ilişkiye odaklanır. Cohesion: bir modül içindeki öğelerin birbirleriyle ne derece ilgili olduğuna odaklanır. **Yüksek cohesion, düşük coupling istenen durumdur.** Genel olarak yazılımda istenen şey kod geliştirmeye açık, değiştirilmeye kapalı yazılmalıdır.      
•  Şimdi şöyler düşün MessageController classın var ve bu classta variableların var. MessageController bir iş yapmıyor ve EditMessageController bu MessageControllerın nesnesine erişerek her işlemi uyguluyor. Buna çözüm setter/getter metotları yazmak değildir. Burada veri bağımlılığı vardır, setter/getter yazmak bu veri bağımlılığını önlemez(aynı şeyin laciverti olur setter/getter yazarsak) ama codumuzun clean code olması için bizim istediğimiz durum davranış bağımlılığıdır. Bu durumda content coupling ve semantic couplic vardır. Duruma yaklaşımımızı değiştirmeliyiz. Davranışlara odaklanmalıyız. Message için neler yapılır? Mesaj oluşturulur, mesaj yazılır, mesaj gönderilir, mesaj silinir... Bunlar için bir interface oluşturmalıyız. Sorumluluklara ve davranışlara odaklan her zaman. Davranışlara odaklandığımızda kodumuz daha esnek geliştirmeye açık, değişikliğe kapalı hale gelir. 
• Nesnelerin varlık sebebi sorumluluklardır. Encapsulation, sorumlulukları yerine getirecek şekilde davranış ve veriyi biraraya getirmektir, veri ile davranılşı bir yerde tutup onu dılşarıdan saklamaktır. Veri davranış için vardır, davranış yoksa veri de yoktur. Veri, mümkün olduğunda en yakın yerde işlenmeli, sistem içerisinde işlenmek üzere dağıtılmamalıdır.   
• **Anemic Domain Model;** Procedural bir design şeklidir. İş alanını temsil eden nesnelerin(domain object), iş alanıyla ilgili sadece veriyi taşıyıp herhangi bir davranışa sahip olmadığı durumdur. Dolayısıyla nesneler arasındaki bağımlılık, arayüzlerindeki davranışlar yerine, doğrudan erişerek ya da set/get metotlarıyla veri üzerindedir. İş davranışları servis nesnelerine yığılmakta ve orada prosedürel bir şekilde Fowler’ın **Transaction Script** olarak adlandırdığı anti pattern gerçekleştirilmektedir. 

  - Örneği; Objenin üzerinde bilgileri tutar. Account objemiz var diyelim; id, balance gibi verileri tutuyor ama bu bilgilerle ilgili davranışlar başka yerde(çoğunlukla bizim service dediğimiz objelerde). Dolasıyla service bu nesne üzerinden davranışlarla hizmet almak yerine ya doğrudan erişerek (çoğunlukla set/get metotları ile)  veriye ulaşır. Veriyi alır, veriye ulaşır ve tekrar set eder. Serviceler implementain detaylarını alıyorlar, implemente edip geriye döndürüyorlar.




## SOLİD
• **Single Responsibility Principle:**  Bir sınıfın değişmesi için asla birden fazla sebep olmamalıdır, tek sorumluluğa sahip olmalıdır.Dijkstra'nın Separation of Concerns prensibi bir uygulamasıdır. SRP'yi yukarıdan aşağıya doğru tanımlamak için; 

- Paket:birlikte release edilen yapılar aynı pakette olmalıdır
- Class:sadece bir şeyi soyutlamalı ve sadece o şeyle ilgili veri ve davranışa sdahip olmalı
- Metot: Sınıfın soyutladığı şeyle ilgili tekrar kullanılabilecek bölünemez tek bir iş yapmalıdır. Metıtlar dört tipe ayrılır.   
  • Constructors, nesne oluşturma ve initialization. Burada nesne oluşturma haricinde başka bir iş yapmamaya dikkat etmeliyiz.
Nesnenin karmaşıklıüğına göre çok parametre alabilirler. Ancak dikkat etmeliyiz ki çok fazla parametre kötü tasarlanmış bir classında göstergesidir.Bu durumun önüne geçmek için kurucuları daha az parametre alacak hale getirip diğer geçilmesi gereken parametreleri statick factory metotlarıyla geçebiliriz. Parametrelerin oluşturulması gerektiği durumlar istemciler için problemdir. Böyle duumlarda yaratımsal kalıplar(creational patterns) kullanımalıdır. İstemcinin hem nesne yaratması hem de parametre oluşturup geçmesi gerektiği durumlardan kaçınmalıyız. 



  Constructorlarda sıklıkla init(), initialization() vb isimlere sahip, initialization yapan metotların çağırıldığı görülür. Bu tür metotlar yerine nesne başlatma bloklarını kullanmayı tercih etmeliyiz.
   > **Instance Initialization Blocks(Nesne Başlatma Blokları);** constructorlardan bağımsız olarak kullanılan kod bloklarıdır. Bir nesne için belirli initialization işlemlerini ortak bir şekilde yapmaktır. {} içinde tanımlanır, constructordan önce veya sonra tanımlanabilir. Classın bir nesnesi oluşturulduğunda bu bloklar **her zaman**  constructordan önce otomatik olarak çağırılır.(Nesne oluştulmuşsa constructor çok çağırılmış demek değil midir? 
 Bir nesne oluşturulurken "new ClassName()" dediğimizde derleyici ilk olarak classı yükler ve bellekte yer ayırma işlemleri yapar. Nesne başlatma blokları yürütülür böylece gerekli olan ön hazırlıklar yapılır sonrasında constructor çağırılır ve  nesneyle ilgili son düzenlemeler yapılarak oluşturulur.  )

  ```java
   public class Example {
    // Nesne başlatma bloğu
    {
        System.out.println("Bu bir nesne başlatma bloğudur.");
    }

    // Constructor
    public Example() {
        System.out.println("Constructor çalıştırıldı.");
    }

    public static void main(String[] args) {
        Example obj = new Example();
    }
}
```


 - Set/Get, bilgi alıp verme
 - toString, equals(),java.lang.Object gibi devralınan metotlar yüksek birlikteliğe sahiplerdir -> hr sorumlulukları bellidir hem de uygun arayüzleri vardır. 
 - İşi yapan metotlar, ikiye ayrılırlar; atomic/worker metotlar(yaptıkları işler daha alt parçalara bölünemez), yöneten/yönetsel/koordinative metotlar(bir süreci yerine getirirler yani birden fazla atomic metodun çalışmasını koordine ederler, bir sürü atomic metodu bir arada götüren(atomic metotları ayrı olarak atomic olarak yazmamış) metotlar yönetsel ya da atomic metot değillerdir).
> Block: metot seviyesine çıkamamış dolayısıyla da tekrar kullnımı söz konusu olmayan ama ya hep ya hiç şeklinde çalışan bir grup cümle olmalıdır.
> Statement: Bir metodun ya da bir bloğun parçası olarak bir işin tek bir adımını rahat anlaşılır şekilde gerçekleştirmelidir. Bir satırda sadece bir statement olmalıdır ve sadece bir adımı yerine getirmelidir. Tek bir cümlelelik karmaşık ifadelerin hiç bir alt parçası başka yerde tekrar kullnılmamalıdır. Eğer aynı blokta ya da metotta kullanılacaksa bu alt parçalara ayrı bir cümle olmalı ve sonucu local bir değişkende saklanıp tekrar kullanılmalıdır.

```java
double w=a+ ++b *c/a+b+2*c/a;
```

```java
//Öncelik sıralaması;parantez > artırma-eksiltme operatörleri > çarpma-bölme > toplama-çıkarma  
//w=a+ (++b *c/a)+b+(2*c/a); çöcelikleri parantez olarak gösterdik
double w=0.0;
++b;
double d=b*c/a
double f=d*c/a
w=a+d+b+f 
```

Yüksek ifade gücüne sahip yapılar SRP'ye tersmiş gibi görünebilir ama bu ifadeler bağlamsaldır ve kültürel bir normdur.Buna güzel bir örnek Builder kalıbıdır.  Aşağıdaki kodda aynı objeyi döndürdüğü için yeni metot çağrıları yapmakta bir problem yoktur.

```java
return Response.status(Response.Status.OK).entity(message).type(MediaType.TEXT_PLAIN).build();
```
Fonksiyonel stilde stream ile veri işlemede(average'a kadar hep stream döndürür); 

```java
Arrays.stream(array).filter(x->x%2==0).map(n->n*n).average().ifPresent(System.out::println);
```

Aynı satorda farklı nesneler üzerindeki çağrıları zincirleyen ifadeler kullanılmamalıdır. Aşağıdaki gibi örneklerde null gelmesi gibi problemler de taşır;

```java
//nesneler; ShoppingCard / List<Item> / Item / List<Customer> / int
shoppingCard.getItemList().get(0).recommendedBy().size();
```
```java
//olması gerektiği şekil
List<Item> listItem= shoppingCard.getItemList().get(0);
int remommendedBySize= listItem.recommendedBy(),size();
```
> 
>
> 



## İsimlendirme

• İsimlendirme yaparken neden var olduğunu, ne yaptığını, nasıl kullanıldığını anlatmalıdır. İyi isimlendirme comment satırı istemez.      
• Aşırı benzer adlandırmalardan kaçınmak gerekir. Bize zaman kaybettirebilir;  XYZControllerForEfficientHandlingOfStrings ve XYZControllerForEfficientStorageOfStrings gibi.        
• İsimlendirme yaparken küçük harf L ve büyük harf O kullanımına dikkat etmelisin. (o ve 1'e benzedikleri için)       
• Noise words gereksizdir. Variable tanımlarken variable adında variable geçmemelidir(piVariable). Table tanımlarken table ile adlandırmak saçmadır. NameString diye bir adlandırma olabilir mi ? Name integer olamayacağına göre String olarak belirtmeye gerek yoktur. Ayrıca ileride variable'ın tipini değiştirirsek adını da değiştirmek zorunda kalırız.      
• Adlandırmalar telafuz edilebilir şekilde olmalıdır. Biri ile konuşurken bahsedebileceğimiz anlaşılabilecek şekilde olmalıdır. Gereksiz yere kısaltarak anlaşılırlıktan fedakarlık edilmemelidir.      
• Clean Code kitabının yazarı Martin Fowler, interface adlandırması yaparken kullanıcıya verdiği interfacein interface oldupunu kullanıcıya çaktırmak istemediğini söylüyor bunun(IShapeFactory) yerine ShapeFactoryImp, CShapeFactory ifadelerini kullanımayı tercih ettiğini söylüyor. (Bence IShapeFactory'nin kullanımı çok daha açık) . Interface'i implemente eden metodun isminin ShapeFactoryImp olması daha açık bir ifade olur baktığımızda bu classın bu interface'i implemete ettiğini direkt olarak anlarız.    
• Method isimleri bir fiil olmalıdır, eylem belirtmelidir. (postPayment, deletePage)     
• Constructorlar aşırı yüklendiğinde (overloaded), argümanları tanımlayan adlara sahip static factory metotları kullanılır.    
**Complex fulcrumPoint=Complex.FromRealNumber(23.0); ** şeklinde yazmak Complex fulcrumPoint= new Complex(23.0);  şeklinde yazmaktan daha iyidir.      


• Metot yazarken tek bir işi yapmasına odaklanmalıyız, uzun anlaşılması zor, variableların her yerde kullanıldığı ve birden çok işin yapıldığı metotlar gelişime açık değildir. Bir değişiklik olduğunda bütün yapısını değiştirmek zorunda kalabiliriz.       
Bu metot birden çok işi bir arada yapıyor,single responsibility ilkesine uymuyor, variablelar her yere saçılmış durumda.      

```java
private void printGuessStatistics(char candidate, int count) {
 String number;
 String verb;
 String pluralModifier;
 if (count == 0) {
 number = "no";
 verb = "are";
 pluralModifier = "s";
 } else if (count == 1) {
 number = "1";
 verb = "is";
 pluralModifier = "";
 } else {
 number = Integer.toString(count);
 verb = "are";
 pluralModifier = "s";
 }
 String guessMessage = String.format(
 "There %s %s %s%s", verb, number, candidate, pluralModifier
 );
 print(guessMessage);
 }
```


Aşağıdaki ise kodda ise okunabilirlik artmıştır. GuessStatisticsMessage classı bir yazdırma metodu olmaktan çıkıp daha genel bir mesaj hazırlama aracı haline geliyor. Değişime açık.   

```java
public class GuessStatisticsMessage {
 private String number;
 private String verb;
 private String pluralModifier;
 public String make(char candidate, int count) {
 createPluralDependentMessageParts(count);
 return String.format(
 "There %s %s %s%s",
 verb, number, candidate, pluralModifier );
 }
 private void createPluralDependentMessageParts(int count) {
 if (count == 0) {
 thereAreNoLetters();
 } else if (count == 1) {
 thereIsOneLetter();
 } else {
 thereAreManyLetters(count);
 }
 }
 private void thereAreManyLetters(int count) {
 number = Integer.toString(count);
 verb = "are";
 pluralModifier = "s";
 }
 private void thereIsOneLetter() {
 number = "1";
 verb = "is";
 pluralModifier = "";
 }
 private void thereAreNoLetters() {
 number = "no";
 verb = "are";
 pluralModifier = "s";
 }
}
```



## Fonksiyonlar
• Bir satır 150 karakterden uzun olmamalıdır. Bir fonksiyon ise 100 satırdan daha uzun olmamalıdır. Bir fonksiyon için 20 satır idealdir. Fonksiyonun girintisi 2'den daha fazla olmamalı ve sadece tek bir iş yapmalıdır.       
• Metotlardan null döndürmemeye dikkat etmeliyiz.      
• Fonksiyonun parametre almaması istenen durumdur ama gerekli durumlarda 1,2 parametre alabilir. Ancak 3 ve daha fazlası özel durumlar gerektirir, kullanmayı tercih etmemeliyiz. Geçtiğimiz argüman sistemin durumunda değişiklik yapmak amaçlı olmalıdır.Örneğin bir dosya açık ve metot ile bu dosyayı kapatmak istiyoruz. Açık olan dosyayı argüman olarak geçeriz fonksiyona.    
• Bir metoda flag'i argüman olarak geçmek çok tercih edilmemesi gereken çirkin bir görüntüdür.    
•  Birden çok argüman geçmek yerine bazı arghümanlardan nesne yaratarak argüman sayısını azaltmak aslında daha mantıklıdır.      

> Circle makeCircle(double x, double y, double radius) yerine;
> Circle makeCircle(Point center, double radius);
 
• Daha sade ve anlaşılır kod için hata işleme ile ana işlemler birbirinden ayrılmalıdır. Aşağıdaki kodda delete metodu hata işleme görevini icra etmektedir. deletePageAndAllReferences ise silme işlemlerini gerçekleştirmektedir. Bu ayrım kodu okuyan kişinin hata işlevini bir kenara bırakıp sadece ana işlevi anlayabilmesine olanak sağlamaktır. Eğer bir metotta try varsa metotun ana odağının buradda olduğu anlaşılmalı, metodun başında olmalı. catch veya finally'den sonra herhangi bir işlem yapılmamalı. Fonksiyonun hata işleme amaçlı olduğu bu şekilde açık bir şekilde görelebilir.     

```java

public void delete(Page page) {
 try {
 deletePageAndAllReferences(page);
 }
 catch (Exception e) {
 logError(e);
 }
 }

```

```java
 private void deletePageAndAllReferences(Page page) throws Exception {
 deletePage(page);
 registry.deleteReference(page.name);
 configKeys.deleteKey(page.name.makeKey());
 }
```

```java
 private void logError(Exception e) {
 logger.log(e.getMessage());
 }
```


• Bazı programcılar Edsger Dijkstra’s kuralları ile oluşturulmmuş yapıyla yazar. Bu kurala göre bir fonksiyon içindeki her bloğun bir girişi bir de çıkışı olmalıdır. Fonksiyonda bir return ifadesi olması gerektiğini; break, continue, goto gibi ifadelerin hiçbir zaman olmaması gerektiği anlamına gelir.    
• Fonksiyonlar bir dilin fiilidir, classlar isimleridir gibi düşünmelisin.


## Comments
• Yorumlar aslında kendimizi ifade edemediğimizde kullanılır yani hatalı olduğumuz durumların telafisidir. Hatalı olduğumuz durumlar diyoruz çünkü koda bakan ilk anda ne yaptığımızı anlayamamaktadır. Clean code değil yani yazdığımız kod.   
• Kod gelişir ve değişir zaman ile. Ancak programcılar genellikle bu gelişimi yorumlara yansıtmazlar ve yorumlar eski kalır, kodu ifade etmez hale gelir zamanla.  
• Bir metodun ne yaptığını ne yapacağını bir yprumla bilgiyle vermektense adı ile anlatmaya çalışnmalıyız ne yaptığını adı belirtmeli  
• Bir API yazarken yorumlarla desteklemekten çok iyi tanımlamayla desteklemeliyiz. Diyelim ki büyük genel bir API yazıyoruz o zaman javadoc kullanmalıyız.    
 
 ### Javadoc
  •  Java programlama dilinde yazılmış class, interface, metotların ve fieldların dokümantasyonunu oluşturmak için kullanılan bir araçtır. Java ile gelir. Source kod üzerindeki özel commentlerden HTML formatında otomatik dokümantasyon üretilebilir. API yazdığını düşün, kullanananın nasıl kullanacağını, metodun ne yaptığını anlatan bölümler yazmamıza olanak verir. Çağırdığımız metodun üstüne geldiğimizde mouse ile açıklaması parametrelerini ve return olarak ne döndüğü gibi bilgileri yazabilir. (HTML formatında üretiliyor diye kalkıp da bunu HTML kodu ile süslemeye-paragraf girintisi, başlık, h1,h2 falan fistan- çalışma, yazılımcının işi değil bu, dosyadan sorumlu olan kişi, işi bu olan kişi yapsın bunu)  
• Öncelikle sınıf, metot ve alanlara Javadoc yorumları eklemeliyiz. İlgili alana gelip /** yazıp Enter'a basarsak eclipse otomatik olarak Javadoc şablonu oluşturur. 
 
```java
/**
* Bu class matematiksel işlemler içerir
* @author Seda GÜNEY DURAN
* @version 1.1
*/
public class Matematik(){
  /**
   *İki sayıyı toplar
   *@param a birinci sayı
   *@param b iklinci sayı
   *@return a ve b'nin toplamı
  */
    public int topla(int a, int b){
      return a+b;
    }
} 
*/
```

Bu dosyanın HTML çıktısını oluşturabilmek için; **javadoc -d doc className.java** (Yazılımcının bilmesine pek de gerek yok)

> **@param**: metoda gönderilen parametreyi açıklar.  
> **@return**: metodun geri dönüş değerini açıklar.  
> **@throws** ve **@exception**: metodun fırlatabileceği istisnaları açıklar.  
> **@author**: yazarı belirtir.  
> **@version**:sürüm bilgisi  
> **@see**:ilgili başka bir class/metoda yönlendirir.  
> **@since**: hangi sürümden itibaren mevcut olduğunu belirtir.   


• İç içe çok fazla try-catch olduğunda bunun acısını commentlerle çıkarmamalıyız. Son try-catch'i farklı bir fonksiyona yönlendirerrek karmaşık görüntüden kaçınabiliriz. 

```java
private void startSending(){
  try{
    doSending();
  } catch(SocketException e){
    // normal. someone stopped the request.
  } catch(Exception e){
      try{
        response.add(ErrorResponder.makeExceptionString(e));
        response.closeAll();
      } catch(Exception e1) {
        //Give me a break! 
      }
  }
}
```

Bu duruma çözüm olarak ;

```java
private void startSending(){
  try{
     doSending();
  } catch(SocketException e){
     // normal. someone stopped the request.
  } catch(Exception e){
     addExceptionAndCloseResponse(e);
  }
}
private void addExceptionAndCloseResponse(Exception e){
  try{
    response.add(ErrorResponder.makeExceptionString(e));
    response.closeAll();
  } catch(Exception e1) {
  }
}
```

• Fonksiyonlarla ya da variablelara atayarak açıklayabileceğin şeyler için yorum yazarak olayı karmaşıklaştırma şimdi aşağıdaki koda bakalım ; 

```java
// does the module from the global list <mod> depend on the
// subsystem we are part of?
if (smodule.getDependSubsystems().contains(subSysMod.getSubSystem()))
```
Açıkçası ben böyle kodlarda yorum satırlarını başta ignorluyorum her yazılımcı gibi. Ancak ilk başta bakıldığında da kod anlaşılmıyor. Ne yapmış, nerden ne gelmiş, ne içeriyor diye bakıyor bir süre insan. Ama kodu aşağıdaki gibi yazsaydık; 

```java
ArrayList moduleDependees = smodule.getDependSubsystems();
String ourSubSystem = subSysMod.getSubSystem();
if (moduleDependees.contains(ourSubSystem))
```
Karmaşık tamamen gitti, açık sade anlaşılır bir kod oluştu. Gereksiz yorumlar da yok. 

• Sıklıkla kullanılan position markerlar redundanttır. Genellikle bazı işlevleri bir arada yapan kod parçaları için kullanılır(Kervan yolda da düzülür kafasıyla başladığım kodlarda yoldayken bu çok uzun oldu buna ayrı bir class açmak lazım diye düşündüğüm durumlarda kullanıyorum ama kullanmamalıyım (kötü yazılımcı alert!)) Aşağıdaki gibi;

```java
// COI-VOCI //////////////////////////////////

```

• Koda ekleme yapan kişilerin yorum satırı ile kimin eklemeyi yaptığını yazması, uzun kodlarda }'dan sonra yorum satırı olarak neyin kapandığını belirtilmesi(//try gibi)   tamamen gereksizdir.    
• Gereksiz olan bütün commentler silinmeli, kendimize hatırlatıcı olarak tuttuğumuz şeyleri commitlememeliyiz, bizden sonra gelenler onların çok önemli olduğunu düşünüp silmekten korkabilirler oysaki onlar birer çöp.   
• İlla comment yazmak zorundaysak genel yorum yazılmamalı (classın başında)   


## Formatting
• Amacı ; açık olmaktır. Team ile ortak belirlenen kurallara hareket edilmelidir. Bireysel kurallar karmaşıklık yaratır.          
• Class isimleri basit ve açık olmalıdır. Kodda aşağıdaya indikçe detay artmalıdır.  
• Yakın ilişkili olan variablelar olabildiğince class bazında korunmalıdır bunlara dışarıdan ulaşımı oldukça azaltmalıyız. Dışarıdan bir göz baktığında kodu anlamak için class class gezmek zorunda kalmamalı.   
• Variable bildirimleri mümkün olduğunca en üstte olmalı, mümkün olduğunca da kullanımına yakın yerlerde tanımlanmalıdır. (Olabildiğince global olmamalı variablelar)    
• Instance variablelar(bir classın instance'ı tarafından oluşturulan nesneye özgü variablelar), classın en üstünde bildirilmelidir. (Çünkü classın çoğu metodu kullanır)   
• Bir metot diğerini çağırıyorsa çağırılan metot, çağıran metodun hemen altında olmalıdır, okunabilirliğin arttırılması için.    
• Conceptual Affinity(Kavramsal Yakınlık) durumlarında da olabildğince yakında tanımlanmaları gerekir illa birbirini çağırmaları gerekmez. Aşağıdaki kod parçasında fonksiyonlar birbirilerini çağırmıyor ancak aynı görevin farklı varyasyonlarını gerçekleştiriyorlar ve metot adlandırmaları da kavramsal olarak yakın hatta aynıdır. Okuyucunun kafasının karışmaması için bu metotlar arka arkaya tanımlanmalıdır.   


```java
static public void assertFalse(String message, boolean condition) {
assertTrue(message, !condition);
}
static public void assertFalse(boolean condition) {
assertFalse(null, condition);
}
```

• Bir satır okurken olabildğince scroll hareket ettirmeden okunabilecek sekilde yazılmış olmalıdır(en fazla 150 karakterden oluşsun ben satır)   
• Atama operatörlerini vurgulamak için sağ ver sol taraflarına boşluklar bırakırız buna **white space** denir. Fonsiyonlar ile argümanlar yakından ilişkili olduğu için aralarında boşluk olmamalıdır parantez ile fonksiyon adlandırması arasında boşluk olmalıdır. 

```java
 private void measureLine(String line) {
 lineCount++;
 int lineSize = line.length();
 totalChars += lineSize;
 lineWidthHistogram.addLine(lineSize, lineCount);
 recordWidestLine(lineSize);
 }
```


## Objects and Data Structures
• Aşağıdaki Concrete (Somut) Point kodunu inceleyelim;

```java
public class Point {
    public double x;
    public double y;
}

```
Bu kodu incelediğimizde x, y koordinatlarının kulanımını gördüğümüz için kartezyen koordinat sisteminin kullanıldığını söyleyebiliyoruz. x, y değişkenlerine doğrudan erişilebiliyor(public). Verinin nasıl tutulduğu ve işlendiği açıkta. Değişkenler private olsaydı da get, set metotları ile erişilseydi de uygulamanın iç yapısı hala açık olurdu. Manipülasyona açık çünkü x ve y birbirinden bağımsız olarak değiştirilebiliyor. 

• Aşağıdaki Abstract (Soyut) Point kodunu inceleyelim;

```java
public interface Point {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```

Bu kodu incelediğimizde koordinatlar kartezyen mi polar mı bilmiyoruz, bilmek zorunda da değiliz. Yapı hangi sistemin kullanıldığını gizliyor.Veriyi tek tek değiştiremiyoruz, bir bütün olarak(atomik) değiştirmemiz zorunlu(setCartesian(double x, double y), setPolar(double r, double theta)  ) Bu yapı bize esneklik de sağlıyor. İleride koordinat sistemini değiştirmek istersek sınıfı değiştirmeden yapabiliriz, interface'i implemente eden sınıfı değiştirmemiz yeterli olur. **Abstract yapı ne yapılabileceğini tanımlar, nasıl yapıldığını söylemez.**    

•  Yazılımcı duruma göre prosedürel ya da nesne yönelimli yaklaşım kullanır. 

Aşağıdaki Prosedürel kodu inceleyelim;

```java
public class Square {
 public Point topLeft;
 public double side;
}
public class Rectangle {
 public Point topLeft;
 public double height;
 public double width;
}
public class Circle {
 public Point center;
 public double radius;
}
public class Geometry {
 public final double PI = 3.141592653589793;
 public double area(Object shape) throws NoSuchShapeException 
 {
 if (shape instanceof Square) {
 Square s = (Square)shape;
 return s.side * s.side;
 }
 else if (shape instanceof Rectangle) {
 Rectangle r = (Rectangle)shape;
 return r.height * r.width;
 }
 else if (shape instanceof Circle) {
 Circle c = (Circle)shape;
 return PI * c.radius * c.radius;
 }
 throw new NoSuchShapeException();
 }
}
```
Veri yapıları(circle, square...) pasif yapıdadır. Geometri classı tüm şekillerin işlemlerini gerçekleştiriyor. Yeni metot eklemek kolaydır. Mevcut şekil sınıflarına dokunmadan sadece Geometry classı ile eklenir.  Dezavantajı ise yeni bir şekil türü eklendiğinde (triangle vs) bütün fonksiyonları güncellemek gerekir. Çünkü her şekil için ayrı ayrı işlem tanımı yapmak gerekir. Prosedürel yaklaşımda veriler pasif, işlemler aktiftir.       
Aşağıdaki Polymorphic kodu inceleyelim;


```java
public class Square implements Shape {
 private Point topLeft;
 private double side;
 public double area() {
 return side*side;
 }
}
public class Rectangle implements Shape {
 private Point topLeft;
 private double height;
 private double width;
 public double area() {
 return height * width;
 }
}
public class Circle implements Shape {
 private Point center;
 private double radius;
 public final double PI = 3.141592653589793;
 public double area() {
 return PI * radius * radius;
 }
}
```

Classların hepsi Shape classını implemente ediyor yani ortak bir türü temsil ediyorlar.  Her şeklin area() metodu var ama her şekil kendi alanını kendi formülüne göre hesaplıyor. Yani area() metodu polimorfik çalışıyor. Object oriented programlamada yeni bir tür (burada şekil) eklemek kolaydır, yeni bir class açarsın override ederek metotlarını tanımlarsın. Ancak yeni fonksiyon eklemek biraz zordur çünkü her sınıfa bu fonksiyonu eklemek gerekir. Object oriented(nesne yönelimli yaklaşımda) classlar merkezi unsurdu. Her class kendi davranışını barındırır. 

•  Yeni veri türleri(şekil, kullanıcı rolü, ürün tipi vs.) sıklıkla ekleniyorsa, yani sistem zaman içerisinde genişliyorsa ve tür çeşitliliği artıyorsa **Object Oriented  Yaklaşım** daha uygun olur. Çünkü yeni sınıf eklemek kolaydır ve mevcut kodu bozmaz.       
•  Eğer veri türleri sabit kalıyor ancak veriler üzerine sıklıkla yeni işlemler geliştiriliyorsa **Prosedürel(işlem odaklı) Yaklaşım** daha uygun olur.     
### Law of Demeter (LoD-Demeter Yasası)
• Bir programın(başka bir yazılımcı API'yını kullanıyor gibi düşün) manipüle ettiği objenin yani nesnenin iç yapısını bilmemesi gerektiğini söyler. Classlar arasında low coupling olması gerektiğini belirtir, bağımlılıkları azaltır. Böylece daha kolay test edilebilir hale gelir. Her sınıfın kendi sorumluluğuna odaklanmasını sağlar, bakımı kolaydır.(talk to friends, not to strangers)   A classının b metodu yalnızca şu nesnelerin metotlarını çağırabilmelidir;

- Kendi sınıfının (A sınıfının) diğer metotlarını
- b metodu tarafından oluşturulan bir nesneyi
- b metoduna parametre olarak geçilen nesneleri
- Classın instance variable olarak tuttuğu nesneleri   

Yapılamaması gereken durumlar;

- Zincirleme çağrılar yapılamamalıdır(k.getA().getB().getC().do() ). Bu gibi durumlara **train wreck** denilmektedir. Böyle bir durumda k nesnesi üzerinden, kendi doğrudan tanımadığı nesnelerin iç yapısına müdahale edilebiliyor.
 
 ```java   
final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
```
Yukarıdaki kod yerine aşağıdaki kod tercih edilmelidir. 

 ```java 
Options opts = ctxt.getOptions();
File scratchDir = opts.getScratchDir();
final String outputDir = scratchDir.getAbsolutePath();
```

- Hibrit(melez) yapılardan kaçınılmalıdır. Kodda bazen bir yapının hem davranışı yani fonksiyonları oluyor hem de içindeki veriler public oluyor. Bu tür yapılar, ne tam anlamıyla nesne ne de data structure olabiliyor. Fonksiyon eklemek zorlaşıyor çünkü bu yapılar zaten davranış içeriyor ve içi de dışarıya açık olduğu için kontrol zorlaşıyor. Herkes yapıya erişebildiği, değiştirebildiği için yeni veri eklemek zorlaşıyor çünkü bir şey değiştiğinde her şey bozulabiliyor. Veriyi mi koruyacağım yoksa davranışımı ikilemi yüzünden kod karmaşıklaşıyor. **Nesne davranış içeriyorsa veriler private olmalı, dışarısıyla sadece fonksiyonlar üzerinden etkileşim kurulabilmelidir.** **Eğer bir yapı sadece veri yapısı içeriyorsa(DTO, struct..) davranış ekleme.**

> **Nesneye ne istediğimizi söylemeliyiz ne yapılacağını değil**
> **Nesneler veri değil davranış sağlar**

• Bir data structure'ın en temel biçimi metotları olmayan classtır. Sadece veri taşıyan bu classlara **DTO(Data Transfer Object)- Veri Taşıma Nesnesi** denir. Genellikle veritabanı ile uygulama arasında veri aktarırken, bir mesajı soket üzerinden gönderirken, API'lar arası veri taşırken kullanılırlar. Amacı bir veriyi bir yerden başka bir yere taşımaktır, veriyi işlemek değil.    
• private olarak tanımladığımız variablelara getter ve setter üzerinden dolaylı olarak eriştiğimiz yapılara quasi-encapsulation(sözde kapsüllemem) denir. Bu erişim biçimi gerçek kapsülleme sağlamaz. Sadece veriye erişmenin yolu farklıdır.   

## Error Handling 
• Bir try-catch-finally ifadesinin try bölümü kod çalıştırdığımızda, yürütmenin herhangi bir noktasında sonlandırılabileceğini ve catch'ten devam edebileceğini ifade eder. Catch ise programımızın try bölümünde ne olursa olsun yani hata yakalansa bile programın mantığı bozulmamalı, veriler tutarsız hale gelmemelidir, yarım kalan işlemler düzgün bir şekilde tamamlanmalı, nesne durumları(state) beklenen halde bırakılmalıdır.     
• Her bir exception hatanın kaynağını ve konumunu belirlemek için yeterli bilgi sağlamalıdır. Stack trace alınabilir ancak işlemin amacını bize söylemez.    
• **Checked Exceptions:** Derleyici bu exceptionların mutlaka ele alınmasını ister, try/catch ile yakalanmalı ya da throws ile metot signature' bildirilmelidir. Genellikle dış ssitemlerle iletişim kurarken (dosya yazma, okuma, ağ işlemleri..) kullanılır.      


 ```java
import java.io.*;

public class CheckedExample {
    public static void readFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName); // IOException fırlatabilir
        reader.read();
        reader.close();
    }

    public static void main(String[] args) {
        try {
            readFile("dosya.txt");
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
}
 ```

 - Checked exception kullanımı Open/closed Principle ile çelişir Diyelim ki A metodu checked exception(IOException) fırlatıyor. Bu hatayı gerçekten yakalan kod C kodunda, yani 3 seviye yukarıda A->B->C. Bu durumda hata potansiyeli taşıdığı için B metodu bu hatayı throws ile belirtmeli. Yani kodun alt seviyesinden yapılmış bir değişiklik yukarıdaki tüm katmanların metot imzalarını etkilemek zorunda kalır. Ama Open/Closed ilkesine göre kodu değiştirmeden yenidavranış ekleyebilmeliyiz. 

• **Unchecked Exceptions:** Derleyici, bu istisnaların ele alınıp alınmadığını kontrol etmez. try/catch, throw ile belirtmek zorunda değiliz.Genellikle programın mantıksal hatalarıyla ilgilidir.(null referans, bölme hataları vb.) 

 ```java
public class UncheckedExample {
    public static void divide(int a, int b) {
        int result = a / b; // ArithmeticException oluşabilir
        System.out.println("Sonuç: " + result);
    }

    public static void main(String[] args) {
        divide(10, 0); // Sıfıra bölme hatası ArithmeticException
    }
}
 ```

• **Exception Wrapping**: Alt seviyede oluşan hatayı daha genel ve üst seviyeye uygun bir exception türü ile paketlemektir. Orijinal hatayı kaybetmeyiz, içine gömeriz. Alt seviyelerdeki hatalar üst seviyelerde anlamsız olabilir, kodun her yerine IOException,SQLException dağılmaması için uygulamaya özel bir exception ile sararız. Sade ,merkezi, okunabilir hale gelir.  

 ```java
public class Uygulama {
    public static void main(String[] args) {
        DosyaServisi servis = new DosyaServisi();

        try {
            String veri = servis.oku("veri.txt");
            System.out.println("Dosya içeriği: " + veri);
        } catch (DosyaOkumaHatasi e) {
            System.out.println("Hata: " + e.getMessage());
            // Orijinal hataya ulaşmak istersen:
            e.getCause().printStackTrace();
        }
    }
}

 ```
 ```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DosyaServisi {
    public String oku(String yol) {
        try {
            return new String(Files.readAllBytes(Paths.get(yol)));
        } catch (IOException e) {
            // Burada teknik hatayı kendi uygulama hatamıza sarıyoruz
            throw new DosyaOkumaHatasi("Dosya okunamadı: " + yol, e);
        }
    }
}

 ```
 ```java
public class DosyaOkumaHatasi extends RuntimeException {
    public DosyaOkumaHatasi(String mesaj, Throwable neden) {
        super(mesaj, neden);
    }
}
 ```

• Null değeri döndürmemeye dikat etmeliyiz. Bunun yerine ya exception fırlatmalıyız ya da special case object döndürmeliyiz.Mesela bir liste ile ilgili bir durum olduğunda **Collection.emptyList()** döndürebiliriz. Bu metot bize boş ama güvenli bir liste verir.    

• Null döndürmekten daha kötüsü metoda null geçmektir. Bunu önlemek için **assert** ifadesini kullanabiliriz. Ancak bu yöntemde runtimeda hata almamızın önene geçmez. Metoda null değeri geçilmesini yasaklamalıyız.    
 
 -**assert**: Programın belirli bir noktada doğru olduğunu varsaydığımız bir koşulu test etmek için kullanılır. Eğer bu koşul yanlışsa Assert Error fırlatılır. Geliştirme ve test aşammalarında hataların erken farkedilmesi için kullanılır. Java assert default olarak devre dışıdır. Programı çalıştırabilmek için; **java -ea ProgramAdi** . -ea aneble assertions anlamına gelir.     
 
 ```java
int age = 15;
assert age >= 18 : "Yaş 18'den küçük, oy kullanamaz!"; // age 18 den küçükse runtimeda AssertionError fırlatır ve hata mesajını gösterir. 
 ```



## Boundaries
• Provider of third-party bir çok ortamda çalışabilecek geniş kitleye hitap etmeyi amaçlar, kullanıcılar ise kendi ihtiyaçlarına özel bir interface ister.    
• **Boundary Interface**,  bir sistemin veya bileşenin dış dünyayla nasıl iletişim kurduğunu tanımlayan interfacedir. Diğer classların veya sistemlerin eriştiği public metotlara ve veri yapılara sahiptir.   

 ```java
Map<String, Sensor> sensors = new HashMap<>();
Sensor s = sensors.get(sensorId);
 ```
Bu kodda Map veri yapısı doğrudan sistemin diğer parçalarına gösteriliyor. Yani Map boundary interfacedir çünkü başka yerler onun metotlarına direkt erişiyor(get, put vs.). İyi tasarım bu mudur ? Değildir Geniş ve kontrolsüz interfaceleri diğer yerlere yaymamalıyız. Bunun yerine bir classın içinde encapsulation yapılmalı.   

 ```java
public class Sensors {
   private Map sensors = new HashMap();
   public Sensor getById(String id) {
     return (Sensor) sensors.get(id);
   }
}
 ``` 
Burada ise Map interface'i gizlendi sadece getById() metodu dışarıya açık Map artık **internal implementation detail** oldu. Artık Boundary interface, sadece Sensors classının public metodudur.    
• Third-party kütüphanelerini uygulamaya entegre etmek karışıktır. Bunu daha güvenli hale getirmek için learning tests yöntemi önerilir.    
• **Learning Tests(Öğrenme Testleri)**:Third party bir kütüphane kullanıldığında o kütüphanenin nasıl çalıştığını anlamak için yazılan testlerdir. Birim testlerden farkı; amaç hata yakalamak değil kütüphaneyi tanımaktır. Aşamaları;İlgili third-party kütüphane uygulamaya eklenir. Dokümantasyona kısaca göz atılabilir bakılmadan da geçilebilir(bazen dokumantasyon uzun ve karışık olduğu için hiçbir şey anlaşılmayabilir.)API'ın kullanmak istediğimiz temel davranışı test edilir. Kod çalışmaz ya da eksik çalışırsa dokümantasyon incelenerek eksikler tamamlanır. Bu şekilde işlem devam eder. Kütüphaneye dair öğrenilenler bu kütüphanede saklanmış olur ve gelecekte kullanmak için referans olur.   
• Bilinmeyen ile bilinen arasından boundary;  henüz tamamlanmamış bir sistemle çalışmamız gereken durumlarda karşımıza çıkar. Bilinmeyen bir sistemin API'si henüz tanımlanmadığı için projemize bağlayabilmemiz mümkün değildir. Bunun çözümü olarak geliştiriciler hayali bir interface ile ilerler. İhtiyaç duyduğumuz bir şekilde interface tanımlarız. Kodun geri kallanından ayrıdı ve modülerdir. Kodun geri kalanından ayrıdır ve geliştiriciye ait olduğu için de kontrol altındadır. Gerçek interface tanımlandığında ise gerçek API ile hayali interfaceimiz arasında bir adapter yazarız. Böylece mevcut kodumuz değişmez. API değişikliklerinde tek bir noktadan müdahale edebilir.z Bu tasarım bize kodda testler için **seam** yani dikiş yeri oluşturur.   


<img width="443" height="200" alt="sdkhsjk" src="https://github.com/user-attachments/assets/25fee6ec-dbe9-4e35-8051-c0e3b62abf2a" />

Bir radyo iletişim sistemi tasarladığımızı varsayalım .Transmitter adlı alt sistem henüz tanımlanmamış, nasıl çalışacağı bilinmiyor ancak sistemin geri kalanının geliştirilmesi gerekiyor. Biz Transmitter adında bir interface  tanımlıyoruz Bu interfacede transmit(frequency, stream) gibi bir metodumuz var. Bu metot aslında ileride gelecek olan API'nin nasıl çalışmasını istediğimizi gösteriyor. Communication Control classı, sistemin iletişim kontrolünü sağlıyor. Transmitter interface'ini kullanarak çalışıyor yani gerçek API'ya bağlı değil. FakeTransmitter adından fake bir classımız var. Bu class Transmitter classını implemente ediyor. Bu sayede gerçek API'a gerek kalmadan sistem test edilebiliyor. TransmitterAdapter, gerçek API geldiği zaman API ile sistem arasında köprü kurar. API değişirse de sadece TransmitterAdapter değişir ve diğer kodlar etkilenmez.   

```java
public interface Transmitter {
    void transmit(double frequency, InputStream dataStream);
}

```
```java
public class CommunicationsController {
    private final Transmitter transmitter;

    public CommunicationsController(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public void sendData(double frequency, InputStream dataStream) {
        // İş mantığı burada
        transmitter.transmit(frequency, dataStream);
    }
}
```
```java
public class FakeTransmitter implements Transmitter {
    @Override
    public void transmit(double frequency, InputStream dataStream) {
        System.out.println("FakeTransmitter: Transmitting on frequency " + frequency);
        // Test amaçlı veri işleme simülasyonu
    }
}

```
```java
public class CommunicationsControllerTest {
    @Test
    public void testSendData() {
        Transmitter fake = new FakeTransmitter();
        CommunicationsController controller = new CommunicationsController(fake);

        InputStream dummyStream = new ByteArrayInputStream("Test data".getBytes());
        controller.sendData(101.1, dummyStream);
    }
}

```
```java
public class RealTransmitterAPI {
    public void keyOn(double frequency) {
        // Gerçek donanımı aktive eder
    }

    public void sendAnalog(InputStream stream) {
        // Veriyi gönderir
    }
}

```
```java
public class TransmitterAdapter implements Transmitter {
    private final RealTransmitterAPI realAPI;

    public TransmitterAdapter(RealTransmitterAPI realAPI) {
        this.realAPI = realAPI;
    }

    @Override
    public void transmit(double frequency, InputStream dataStream) {
        realAPI.keyOn(frequency);
        realAPI.sendAnalog(dataStream);
    }
}
```
FakeTransmitter geliştirme ve test aşamasında kullanılır, simüle etmemizi sağlar. Testlerin hızlı ve bağımsız olarak yapılabilmesine olanak sağlar. TransmitterAdapter ise gerçek API ile bağlantı kurar yani gerçek sistemle çalışır, işlemi gerçekleştirir. Sistemi gerçek API'ye bağlar.  

## Unit Tests
### TDD (Test Driven Development-Test Güdümlü Geliştirme)
• **Önce test et sonra kod.**  Bu yaklaşıma göre koddan önce test yazılır. Kodun doğruluğunu ve tasarım kalitesini artırmayı hedefler.Bu yaklaşım sadece bir test yazmaktan ibaret değildir, aynı zamanda bir tasarım yaklaşımıdır.   
• **TDD'nin üç kuralı**

- Başarısız bir unit test yazmadan kod yazamazsınız. Kod yazmaya başlanmadan önce, kodun ne yapması gerektiği test ile tanımlanmalıdır.
```java
@Test
public void testAddTwoNumbers() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(2, 3)); // Bu test başarısız olur çünkü add() metodu yok
}
```

-  Test yazılırken gereksiz detaylara girilmemelidir. Sadece testin başarısız olmasını sağlayacak kadar yazılmalıdır. Test derlenmiyor(mesela metot yoksa) başarısızlıktır ve yeterlidir.
 ```java
assertEquals(5, calc.add(2, 3));
assertEquals(7, calc.add(4, 3));
assertEquals(0, calc.add(0, 0)); // Bunlar henüz gereksiz
```
-  Yalnızca mevcut testi geçecek kadar yazılmalıdır. Fazladan mantık, ekstra özellik, tahminsel kod yasaktır. 


Önce bir test yazılır ve bu başarısız olur bu aşamada kod yoktur. Sonrasında testi geçecek basit bir kod yazılır. Kod iyileştirilir. Kod testle doğduğu için hatalar erken yakalanır, modülerlik artar . 

 ```java
public int add(int a, int b) {
    // Gelecekte negatif sayılarla uğraşacağım, o yüzden ekstra kontrol ekleyeyim. 
    if (a < 0 || b < 0) {
        throw new IllegalArgumentException("Negatif sayı yok!");
    }
    return a + b;
}
 ```

Sonuç olarak TDD yaklaşımı benimsenmiş kod aşağıdaki gibi gözükür. 

```java
// 1. RED: Test yazılır
@Test
public void testAdd() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(2, 3)); // Bu test başarısız olur çünkü add() yok
}

// 2. GREEN: Testi geçecek kod yazılır
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// 3. REFACTOR: Kod sadeleştirilir, test geçmeye devam eder
// (Bu örnekte refactor gerekmedi ama daha karmaşık durumlarda olur)
```

•  Test edilebilir tasarım, kodun daha küçük bağımsız birimlerden oluşmasını sağlar. Mock ve stub kullanımı ile dış bağımlılıkları izole edilir. Classlar genellikle interface üzerinden test edilir. Refactor sonrası testler sayesinde bozulma riski azalır.     
• **Test double**, yazılım testlerinde gerçek nesnelerin yerine kullanılan sahte nesneleri ifade eder. Amaç, testin izole, hızlı, kontrollü ve tahmin edilebilir olmasını sağlamaktır. Çeşitli test double türleri vardır; dummy, stub, spy, mock, fake.   

- **Dummy**: Sadece parametre olarak geçilir, testte kullanılmaz. Genellikle null olmayan zorunlu parametreler için kullanılır. Nesne gereklidir ama aktif rol oynamaz.    

```java
class Logger {
    public void log(String message) {
        // Gerçek loglama
    }
}

class PaymentProcessor {
    private Logger logger;

    public PaymentProcessor(Logger logger) {
        this.logger = logger;
    }

    public boolean process() {
        // logger kullanılmaz
        return true;
    }
}

// Dummy Logger
class DummyLogger extends Logger {
    public void log(String message) {
        // hiçbir şey yapmaz
    }
}
```

- **Stub**: Test edilen kodun bağımlı olduğu bir bileşenin sabit, önceden tanımlanmış cevaplar vermesini sağlar. Davranış kontrolü yapılmaz, sadece veri döner. Gerçek nesnenin yerine geçer ama pasif roldedir.    

```java
class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUserName(int id) {
        User user = repo.findById(id);
        return user.getName();
    }
}

// Stub
class StubUserRepository implements UserRepository {
    public User findById(int id) {
        return new User(id, "Alice");
    }
}
```

Burada StubUserRepository,findById çağrısına sabit bir veri döner. Testin amacı UserService'in davranışını kontrol etmektir.  
    
- **Fake**: Basitleştirilmiş versiyonunun gerçek mantığını içerir. Genellikle bellek içi veri yapıları kullanılır. Gerçek davranışın simülasyonu istendiğinde ama tam sistem kullanılmak istenmediğinde(In-memory database, sahte e-posta servisleri )  

```java
class FakeUserRepository implements UserRepository {
    private Map<Integer, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(int id) {
        return users.get(id); // gerçek mantık ama basit
    }
}
```

- **Spy**: Gerçek nesne gibi davranır ama çağrılar izlenebilir. Hem veri sağlar hem de davranış kontrolü yapılabilir. Gerçek davranışın korunmak istendiği aynı zamanda da çağrıların izlenmesi gerektiği durumlarda kullanılır.   

```java
UserRepository realRepo = new FakeUserRepository();
UserRepository spyRepo = spy(realRepo);

spyRepo.findById(1);
verify(spyRepo).findById(1); // çağrı kontrolü
```

- **Mock**: test edilen kodun bağımlı olduğu bileşenin çağırılma şekli ve sıklığı gibi davranışlarını kontrol eder. Aktif bir roldedir; hem davranış hem de veri dönebilir.    

```java
@Test
void testUserService() {
    UserRepository mockRepo = mock(UserRepository.class);
    when(mockRepo.findById(1)).thenReturn(new User(1, "Alice"));

    UserService service = new UserService(mockRepo);
    String name = service.getUserName(1);

    assertEquals("Alice", name);
    verify(mockRepo).findById(1); // çağrıldı mı kontrolü
}
```


> JUnit, test yazmak   
> Mockito, mock nesneler oluşturmak   
> AssertJ, daha okunabilir assertionlar    
> Hamcrest, matcher bazlı testler    

• Kodumuzu esnek, sürdürülebilir tutan birim testlerdir. Çünkü test ne kadar kapsamlı olursa kodda değişiklik yapmaktan o kadar az korkarız. Test olmadan yapılan her değişiklik olası bir bugdır.    
• Clean test yazmanın en önemli kriteri readabilitydir. Testi okuyan kişi kodun ne yaptığını hızlıca anlayabilmelidir. Karmaşık testler, hataları gizler ve güveni azaltır.    
• **Build-Operate-Check** patterni temiz ve okunabilir test yazımı için kullanılan bir yapıdır. Test mantığını üç aşamaya ayırarak hem yazan hem de okuyan için anlaşılır hale getirir.    

- **Build**: Test verisi hazırlanır. Gerekli nesneler, durumlar oluşturulur.   
- **Operate**: Test edilen işlem gerçekleştirilir. Yani sistem üzerinde bir eylem yapılır.   
- **Check**: Sonuçlar doğrulanır. Beklenen çıktılarla karşılaştırma yapılır.  


```java
  @Test
void shouldReturnDiscountedPrice() {
    // BUILD
    Product product = new Product("Laptop", 1000);
    DiscountService discountService = new DiscountService();

    // OPERATE
    double discountedPrice = discountService.applyDiscount(product, 0.1);

    // CHECK
    assertEquals(900, discountedPrice);
}

```

• **Domain Specific Language(DSL)**: Belirli bir domaine özgü olarak tasarlanmış, o alanın ihtiyaçlarını karşılamak için optimize edilmiş bir dil veya API'dır. Java, python gibi genel diller her şeyi yapabilirken DSL'ler sadece belirli bir şeyi çok iyi yapar. JUnit test API'si, Kotlin DSL, SQL, HTML, regular expression ...    

• **A Dual Standard**: Test kodları ile production kodları aynı temizlik ve okunabilirlik standartlarına sahip olmalı ama verimlilik gibi bazı kriterlerde farklılık gösterebilir.  Normal şartlarda mental mappingten kaçınmak önerilir ancak testlerde kontrollü şekilde bu durum esnetilebilir(Mental mapping: Kodun okunması için okuyucunun kafasında bir şeyleri eşleştiriyor olması gerektiği durumdur. Bir harfin ne anlama geldiğini anlamak gibi. Hata yapma ihtimalini arttırır, okunabilirlik azalır. )    

• **One Assert per Test**: Her testte tek assert olmalıdır görüşü vardır. Bu görüşe göre her test fonksiyonu tek bir sonucu doğrular. Bu durum okunabilirliği artttırır, hata tespitini kolaylaştırır, amaç netleşir, refactoring kolaylaşır. Ancak tek bir assert kullanımı yapabilmemiz için test karmaşık olmamalı, tek bir davranışı kapsamalı. Tek bir assert kullanarak yazamadığımız testlerde ne yapmalıyız? Arka arkaya assert kullanımı okunabilirliği düşürmekte buyüzden testi parçalamalıyız. Testi parçaladığımızda ise given ve when metotlarında kod tekrar sorunu oluşur..  

-**Given-When-Then** : Testlerin okunabilirliğini arttırmak için kullanılan yaygın bir yapıdır.    
>**given:** Testin başlagıç durumu   
>**when:** eylem   
>**then:** beklenen sonuç     

```java
public void testGetPageHierarchyAsXml() throws Exception {
  givenPages(...);
  whenRequestIsIssued(...);
  thenResponseShouldBeXML(); // sadece format kontrolü
}

public void testGetPageHierarchyHasRightTags() throws Exception {
  givenPages(...);
  whenRequestIsIssued(...);
  thenResponseShouldContain(...); // sadece içerik kontrolü
}

```

Bu kod tekrarını iki yöntem ile çözebiliriz: Template Method Pattern, @BeforeEach    

- **Template Method Pattern:** Behavioral patterndir. Bir algoritmanın iskeleti bir abstract classta tanımlanır ve bazı adımların detaylarını sub classlara bırakır. Given ve when ortaktır ve bir base classa konulur, her test sınıfı then bölümünü tanımlar. (Bakınız: https://github.com/SedaGUNEYDURAN/Foundation/blob/main/DesignPattern.md#template-method )            
- **@BeforeEach:** JUnit'te bu notasyon, her testten önce çalışacak bir metodu tanımlar. Ortak hazırlık adımları @BeforeEach metoduna alınır. Her @Test sadece kendi assertini içerir. Her doğrulama için ayrı bir test classı oluştururuz.   


```java
public abstract class BasePageHierarchyTest {

    protected Response response;

    @BeforeEach
    public void setup() throws Exception {
        givenPages("PageOne", "PageOne.ChildOne", "PageTwo");
        response = whenRequestIsIssued("root", "type:pages");
    }

    protected void givenPages(String... pageNames) {
        // Sayfaları oluştur
    }

    protected Response whenRequestIsIssued(String root, String query) {
        // İstek gönder ve yanıtı döndür
        return sendRequest(root, query);
    }
}

```

```java
public class PageHierarchyXmlTest extends BasePageHierarchyTest {

    @Test
    public void shouldReturnXmlFormat() {
        assertTrue(response.isXml());
    }
}

```

```java
public class PageHierarchyTagTest extends BasePageHierarchyTest {

    @Test
    public void shouldContainExpectedTags() {
        assertTrue(response.contains("<name>PageOne</name>"));
        assertTrue(response.contains("<name>PageTwo</name>"));
        assertTrue(response.contains("<name>ChildOne</name>"));
    }
}

```

• Clean test yazmanın 5 altın kuralı vardır:   
 - Fast : Developer, yavaş testleri sıksık çalıştırmaz. Bu da hataların geç farkedilmesine neden olur.     
 - Independent: Her test kendi başına çalışabilmelidir, birbirini etkilememelidir. Bir testin başarısız olması diğer testi etkilememelidir.    
 - Repetable: Testler çevrimdışı bile çalışabilmelidir. Her ortamda çalışabilmelidir. Ortam bağımlılıkları(saat, tarih, dosya sistemi, ağ bağlantısı gibi faktörler) testin güvenirliğini azaltır.    
 - Self Validating: Testin sonucu net olmalıdır. Manuel okuma, log karşılaştırma yapılmamalıdır.    
 - Timely: Test kodu,production koddan önce yazılmış olmalıdır.    


## Classes
• Kodun okunabilirliğini ve bakımını kolaylaştırmak için classlar, variable listesi ile başlamalıdır. Değişkenleri de belirli bir sıraya göre yazarsak anlaşılır bir kod yapısı oluşur;

- public static constants(public static final int MAX_SIZE = 100;)  
- private static variables(private static int counter = 0;)  
- private instance variables(private String name;)

  Dikkat edersek sıralamada public variablelar yok. Public değişkenler encapsulation ilkesine aykırı olduğu için önerilmezler. Değişkene doğrudan erişilmesi, kontrolsüz veri değişimine yol açabilir, kodun bakımı ve test edilmesi zorlaşabilir. Setter/getterlarla(çok önerilmese de) erişmek daha sağlıklıdır.
      
• Değişkenlerdn sonra fonksiyonlar gelmelidir. Öncelikle public method sonrasında ise private method gelir. Bu düzenleme şekline **stepdown rule(aşağıya doğru adım kuralı)** denir. Private methodlar genellikle public methodların bir parçasıdır. Yani önce public method ile bilgi sonrasında private metot ile detay gelir.    
• Değişkenleri ve utility yani yardımcı fonksiyonları genelde private yaparız. Ancak test yazarken ihtiyaç durumununda protected veya package-private erişime açabiliriz. Ama önceliğimiz her zaman gizliliği korumaktır. Erişimi gevşetmek her zaman son çare olarak ele alınmalıdır.   
• Bazı kütüphaneler(Guava gibi) @VisibleForTesting gibi notsyonlar sunarak private olan bir metodun test için görünür.olmasını sağlar.   
•  Bir classın sorumlulukları net, sınırlı ve iyi tanımlanmış olması gerekir. Eğer bir sınıfa net, kısa ve anlamlı bir isim veremiyorsak; bu o sınıfın çok fazla işi bir arada yaptığını gösterir. Processor, Manager, Handler, Super gibi isimlendirmeler çok fazla sorumluluğun toplandığını gösterir. Sınıfı 25 harf ile ve  if , and, or, but gibi kelimeler kullanmadan adlandırabilmeliyiz. Bu tarz kelimeler birden fazla sorumluluğa işaret eder. Bu da SRP(single responsibility principle) ilkesine aykırıdır.     
 
 ### Single Responsibility Principle
 • Bir sınıfın değişmesi için asla birden fazla sebep olmamalıdır.   
 • Bir classın fonksiyonel birlikteliğe sahip olması gerektiğini ifade eder.
 • Sınıf öyle odaklı olmalıdır ki değişmesi için birden fazla sebep olmamalıdır. Bir sınıf sadece bir şeyi soyutlamalı ve sadece ona odaklanmalı, onunla ilgili veriye sahip olmalı ve sorumluluları yerine getirmelidir. Dolayısıyla da bir sınıf sadece bir soyutlamayla ilgili sebeplerden dolayı değişebilir. Separation of Concerns prensibinin bir uygulaması olarak görülebilir.   

- **Separation of Concerns:** Sorunları ayrılmasıdır. Yazılım geliştirme sürecinde karmaşıklığı azaltmak ve yazılımın daha esnek, sürdürülebilir ve ölçeklenebilir olmasını sağlamak amacıyla kullanılır. Katmanlı mimari, MVC, Mikroservisler bu prensibin uygulandığı bazı yaklaşımlardır.   
- **DRY(Don't Repeat Yourself):** Eğer bir statement ya da bloğun birden fazla yerde bulunması gerekiyorsa, bu ifade bir metoda dönüştürülmelidir. Hiç bir kod parçası asla tekrar etmemelidir ve sistemde sadece bir yerde bulunmalıdır.
- Bazen sınıfların birden fazla interface'i implement ederek, pek çok role sahip olduğu görülür. Özellikle yetkinlik kazandırmak amacıyla bir API'nin parçası olan interfaceleri yerine getiren ama aynı zamanda bir rolü olan nesnelerde bu durum yaygındır. Böyle sınıflar **composite/aggregate(bileşik/küme sınıf) olarak adlandırılır. Böyle interfacelere fat, pollued olarak adlandırılır ve code smell oluşturur.   
- Eğer single responsibility prensibi ihlal edilirse fat classlar ortaya çıkar. Fat class; yazılım geliştirmede fazla büyük ve karmaşık hale gelmiş classları tanımlar. Çok fazla sorumluluğa sahiplerdir.
     
 ### Cohesion
 • Bir classın veya modülün  tek bir sorumluluğa ne kadar odaklandığını ölçer. Yüksek cohesion durumunda classta bulunan tüm metotlar aynı amaca odaklanır. Mesela InvoiceCalculater classındaki bütün metotlar sadece fatura hesaplama ile ilgilenir. Düşük cohesion durumunda ise metotlar farklı ve birbiri ile ilgisizdir. Cohesion çeşitleri; 
 
  - **Gelişigüzel(Coincidental):** Bir araya getirilmiş ilgisiz yapılardır. Nesne soyutlamasının eksik ya da hiç olmadığı durumlarda sıklıkla görülür. En kötü seviye cohesiondur.  Örneğin; util classları   
  - **Mantıksal(Logical)**:Gerçekte farklı tabiatta olmalarına rağmen tek bir şey ile ilgili olduğu düşünülen bir araya getirilmiş yapılardır. Örneğin; Cutter class’ında cutHair() cutTalk() metodunun bulunması gibi. İşler benzer ama amaçlar farklı   
  - **Zamansal(Temporal):** Zamansal birliktelikten dolayı bir araya getirilmişlerdir.   
  - **Prosedürel(Procedural):** Bir konu ile ilgili işlerin yukarıdan aşağıya doğru fonksiyonel olarak ayrılması ve hepsinin bir sınıfta bir araya getirilmesi. Örneğin; dosya açmakla ilgili her şeyi yapan, dosya erişimini ve gerekli belleği kontrol eden, dosyayı açıp kaydedip e-mail olarak gönderen bir class.  
  - **İletişimsel(Communicational/Informational):** Aynı veri üzerinde çalışan yapıların bir araya getirilmesidir. Veri işlemenin öne çıktığı durumlarda görülür. (Ortak bir veri yapısı vardır; birisi onu okur birisi onu işler gibi)
  - **Ardışıl(Sequential):** Class seviyesinde birinin çıktısının diğerini beslediği, pipe şeklinde çalışan fonksiyonları bir araya getiren classlardır.
  - **Fonksiyonel(Functional):** En iyi birliktelik durumudur, büyümeye karşı direnebilir. Tek, çok iyi tanımlanmış ve olabildiğince küçük bir işe ya da sorumluluğa yönelik olarak bir araya getirilmiş yapılardır. Yazılım geliştirme sürecinde detaylar arttıkça diğer birliktelik türlerinde yapılar gittikçe büyüme eğiliminde olurken fonksiyonel birliktelikte bölüp parçalama yoluyla odağın korunmasına çalışılır. Çünkü detay arttıkça iş ya da sorumluğun tanımı değişir buyüzden de her iş farklı ve küçük işlere bölünür.   

• Yüksek cohesion için;
- Az sayıda instance variable kullanılmalıdır. Variable sayısı arttıkça; sınıfın karmaşıklığı artar ve sorumluluklar bulanıklaşır.
- Her metodun classın en az bir instance variable'ını kullanması beklenir. Bir method ne kadar çok instance variable'ı anlamlı şekilde kullanıyorsa, o metodun classa olan cohesion'u o kadar yüksektir.
• Her metodun, sınıftaki tüm değişkenleri kullanması maksimum cohesion'dur. Ancak bu teorik olarak mümkün olsa da pratikte hem zor hem de gereksizdir. Sınıf içersinde birbirinden kopuk, ilgisiz metotlar ve değişkenler varsa bu düşük cohesiondur ve fazla sorumluluk işaretidir.
• Eğer bazı değişkenler sadece belirli metotlar tarafından kullanılıyorsa; bu metotlar ve değişkenlerin aslında başka bir classın parçası olması gerektiğini gösterir.

 
