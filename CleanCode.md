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



# Coupling (Bağlılık )
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
    
