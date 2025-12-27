# Domain Driven Design 
- Karmaşık yazılım projelerini yönetmek için kullanılan bir felsefe veya yöntemler bütünüdür. Amacı; yazılımı üzerinde çalıştığı domaine(iş alanına) göre şekillendirmektir. Yazılım sadece koddan oluşmamalıdır, işin gerçek hayattaki işleyişinin bir yansıması olmalıdır.Yazılımcının teknik dünyası ile product ownerın gerçek dünyası arasındaki uçurumu kapatmak.

  ## Temel Kavramlar 
  -  **Domain**: Yazılım ile çözmeye çalıştığımız işin kendisidir. Bankacılık yazılımı yaptığımızı varsayalım o zaman bizim domainimiz bankacılıktır.
  -  **Domain Expert**: Yazılımı yapan değil, o işi en iyi bilen kişidir.   
  -  **Model**: Gerçek hayatın basitleştirilmiş versiyonudur. Sadece yazılımın ihtiyacı olan kuralları içerir.
  -  **Entities**:Idetitysi(ID) olan nesnelerdir. Örneğin; Müşteri entityi, müşterinin soyadı değişse bile aynı müşteridir -> ID'si sabittir. Entityler yaşam süreleri boyunca izlenebilir olmalıdır. Entityler sadece veri torbaları yani DTO değildir. Kendi verilerini korumalı ve üzerinde işlem yapacak iş metotlarına yani davranışlara sahip olmalılardır.  
  -  **Value Objects**: Değişmez(immutable) yapılardır. Kimliği olmayan, sadece değeri olan şeylerdir. Eğer bir değer değişecekse,nesne güncellenmez; yenisi oluşturulur. Özellikler bir bütündür. Örneğin; Adres. Sokak, kapı no, şehir bilgileri bir arada tutulur bunlar birbirinden ayrılmaz parçalardır. İki value objectin eşit olup olmadığını anlamak için ID'lerine değil içindeki tüm özelliklere bakılır. İki adresin sokak, no gibi tüm bilgileri aynıysa bu iki nesne eşittir.**Entity sayısını azaltıp, value object sayısını arttırmak sistemi daha hafif, daha kolay test edilebilir ve daha az hata payı içeren bir hale getirir.**    
  -  **Domain Services**: Bazı işlemler ne bir entitye ne de bir value objecte aittir. Mesela; parayı A bankasından B bankasına transfer et işlemi bir servistir. Stateless yani durumsuzlardır. Servisler kendi içlerinde bir durum saklamazlar; bir veri alırlar, işlerler ve sonuç dönerler. Teknik bir servis değillerdir(veri tabanı bağlantısı gibi), business logicin bir parçasıdır, saf iş kuralı barındırırlar. 
  -  **Invariant**: bir iş kuralının her zaman doğru kalması gereken durumdur. Mesela; bir siparişin tutarı asla negatif olamaz. Bu bir invarianttır.     
  - **Factory**: Karmaşık nesnelerin oluşturulma mantığını saklayan yapılardır. Bir nesnenin yaratılması için çok fazla kural gerektiriyorsa bu nesnenin kendi içinde değil bir factory içinde tutulur. Böylece nesne sadece kendi işine odaklanır.    
  - **Repository**: veritabanı işlemlerini gizleyen interfaceler diyebiliriz. Nesnelerin veritabanına kaydedilmesi ve geri getirilmesini yöneten bir interfacedir. Sanki bellekteki bir collection'mış gibi davranmalıdır. Teknik veritabanı detayları(SQL sorguları vs) burada gizlenir. **Sadece aggregate root'lar için bir repository oluşturulur.**
  - **Domain Event**:İş akışından önemli bir şey olduğunda sistemin geri kalanına haber veren sinyallerdir. Sistemler arasındaki couplingi azaltır.           
 
- **Bir nesne Factory ile doğar. Aggregate sınırları içerisinde iş kurallarını uygulayarak yaşar. Repository aracılığı ile saklanır veya uyandırırlır.**   
- Herkesin yani yazılımcının da product ownerında business analistinde anladığı ortak bir dil oluşturulur. Buna **ubiquitous language** denir. Productowner diyelim ki bu işlem gerçekleştiğinde müşteri pasife alınsın diyor. Kodda bu durumu gerçekleştiren metot ismi MusteriyiPasifeAl olmalıdır. StatusUpdate(0) gibi teknik şeyler kullanılmaz.
- Büyük projeleri yönetmek için parçala ve yönet mantığı kullanılır. Burada da karşımıza **bounded context** terimi çıkıyor. Büyük bir sistemde bir kelimenin farklı yerlerde farklı anlamlara gelmesi olarak açıklayabiliriz. Ürün denildiğinde satış birimi bunu fiyatı olan şey olarak görürken lojistik birimi ağırlığı olan şey olarak görür. Eğer bu sınırları çizmezsek kodlar birbirine tightly coupled yani aşırı bağımlı olur. İşte DDD bunları birbirinen ayırır.Her birim kendi bağlamında, kendi evreninde çalışır. Bu küçük şeylerin de birbiriyle nasıl konuştuğunu gösteren haritaya **context map** deriz. Farklı bağlamların birbiriyle nasıl veri alışverişi yapacağının stratejisidir.
- Büyük ve karmaşık domain yönetilebilir parçalara bölünerek subdomainler elde edilir. Subdomainleri, üç ana başlık altında inceleyebiliriz;
  - **Core Subdomain**: Şirketi rakiplerinden ayıran, para kazandıran, özgün kısımdır. En karmaşık mantık bu bölümde bulunur. Özel olarak kodlanan kısımdır.
  - **Supporting Subdomain**: Core domainin çalışması için gerekli ama tek başınada mesela Amazonu amazon yapan şey değildir. İşimize özeldir ama yıkıcı bir rekabet avantajı da sağlamaz. Dışarıdan birine yaptırılabilir ya da mevcut kütüphanelerle geliştirilebilir. Mesela stok takip sistemi. Stok takip sistemi olmadan satış yapamayız ama her stok takip sistemi kullanan da amazon olamaz.
  - **Generic Subdomain**: İşimize özgü hiçbir tarafı olmayan, neredeyse her şirkette aynı şekilde çalışan kısımlardır. Genellikle hazır bir yazılım satın alınır veya açık kaynaklı çözümler kullanılır.Mesela; ödeme altyapısı(iyizico, PayPal gibi).
- Subdomain ile bounded contextin farkı ne diyecek olursak; subdomain iş dünyasındaki bölümlerdir; lojistik, finans, satış gibi. Bounded context, iş bölümlerinin koddaki karşılığıdır.    

    ## Layered Architecture
  - DDD'nin sağlıklı bir şekilde çalışabilmesi için Separation of Concerns prensibi uygulanmalıdır. DDD, dört katmanlı bir yapıda uygulanır ve her katman kendinden üstteki katmana hizmet verir. Katmanlara ayırarak karmaşıklığı yönetir;      
    -   User Interface: Kullanıcının gördüğü ekranlar. Kullanıdan gelen istekleri alır, sonuçları gösterir.    
    -   Application Layer: Business adımlarını koordine eder. İş kurallarını çağırır ama iş mantığı içermez. Sadece şunu al, şuraya ver der yani domain nesnelerini görevlendirir.      
    -   Domain Layer: Sistemin kalbidir. Tüm iş kuralları, entities, value objects, aggregatelr burada yaşar. Hiçbir katmana bağımlı olmamalıdır böylece iş kuralları teknik detaylardan etkilenmez. Domain drive designın en kritik bölümüdür.     
    -   Infrastructure Layer: Veritabanına bağlanmak, e-posta göndermek gibi teknik detayların bulunduğu yerdir.
  - Spring Bootta;

    > Controller --> Presentation Layer   
    > Service -->  Application/Domain Layer   
    > Repository --> Infrastructure Layer  

   ## Hexagonal Architecture
    **TODO**

   ## Clean Architecture
    **TODO**
  
   ## Relational Pattern
   - Farklı bounded contextler arasındaki ilişkileri tanımlayan stratejik tasarım kalıplarıdır.   
    ### Anti-Corruption (ACL)
    -  Yeni, temiz bir DDD sistemi, legacy ve kötü tasarlanmış bir sistem ile konuşacaksa araya bir proxy, facade, translator koyulmalıdır. Bu eski sistemdeki kötü modellemenin, yeni sisteme sızması engellenir.

    ### Conformist
    - İki farklı bounded context arasındaki ilişkiyi tanımlar ve genellikle güç dengesizliği durumunda ortaya çıkar. Bu ilişkikide bir taraf (Downstream-Alıcı) diğer tarafın(Upstream-Sağlayıcı) modelini olduğu gibi hiç değiştirmeden kabul eder.
    - Normalde DDD, ACL kullanmamızı önerir. Ancak pazar gücü yüksek Paypal gibi bir sistemi entegre ediyorsak Paypal bizim için modelini değiştirmez, olduğu gibi kullanmamız gerekir. Bu gibi durumlarda conformist ilişki kurulur.

    ### Customer/Supplier
    - Bu ilişkide iki taraf vardır;
      - Upstream(Supplier-Tedarikçi):Veriyi veya servisi sağlayan taraftır. Diğer tarafın çalışması için gerekli olan çıktıları üretir.
      - Downstream(Customer-Müşteri): Supplierdan gelen çıktıları kullanan taraftır. Supplier'a bağımlıdır. 
    - Customer, ihtiyaçlarını supplier'a iletir. Supplier, customerın taleplerini backloga alır ve planlamasını buna göre yapar. Customer, supplier'ın sunduğu modelin gelişiminde söz sahibidir.  

     ### Partnership
    - DDD'deki en yüksek iş birliğini temsil eden context mapping patternidir. Alt-üst ilişkisi yoktur, tam bir eşittir(peer) ilişkisi vardır. İki sistemin birbirinden ayrılamayacak kadar iç içe geçtiği durumlarda tercih edilir.

     ### Shared Kernel
    - DDD'de iki veya daha fazla Bounded Context arasındaki en riskli ama bazen de en pratik olan ilişki modelidir. İki ekibin domain modelinin belirli bir parçasını (kod, veritabanı vb.) fiziksel olarak paylaşması anlamına gelir.
    - Eğer iki farklı ekip tamamen aynı business logic geliştiriyorsa kod tekrarını(DRY) önlemek için tercih edilebilir. Veya iki sistemin veriyi çok hızlı ve sık takas etmesi gerekiyorsa ortak bir veri modeli üzerinden konuşmak entegrasyon maliyetini düşürür.    


   ## Aggregate
  - Birbiri ile sıkı sıkıya bağlı nesneler grubudur(entity ve value object gruplarıdır). Veri bütünlüğünü sağlamak için bir grup nesnenin tek bir kök(aggregate root) üzerinden yönetilmesidir.
  - Aggregate root, veri tutarlılığını(consistency) sağlamak için gruba tek bir giriş noktası sağlar. Dışarıdan kimse içeriye dokunamaz, sadece kök üzerinde işlem yapılır.
  - Kodun herhangi bir yeride invariants kuralı bozacak bir işlem yapılmasını engellemek için nesneleri aggregate dediğimiz korumalı gruplara hapsederiz.  Mesela Order bir aggregate rootdur. OrderItem'sa dışarıdan erişilemez, her şey ana Order nesnesi üzerinden yönetilir.
  - Eğer bir aggregate içinde sub-entity varsa, ona da erişim agregate root üzerinden gerçekleşir yani sub-entitye de doğrudan erişilemez. Eğer erişilebilir bir yapı tasarladıysak bu aggregate bütünlüğünü bozar.
  - Bir transaction başladığında sadece bir aggregate güncellenmelidir. Bu sistemin ölçeklenebilirliğini arttırır ve deadlock sorunlarını önler. 
  - Vaugh Vernon'un Kuralları;
    - Küçük tutulmalıdır. Büyük kümeler performans sorunlarına ve veritabanı kilitleme hatalarına yol açar. Sadece beraber değişmesi gereken, minimum nesne kümeye dahil edilmelidir.
    - Bir aggregate başka bir aggregate'e referans verecekse bunu nesne olarak değil, ID üzerinden yapmalıdır.
    - Bir değişiklik başka bir kümede güncelleme gerektiriyorsa anlık değil Domain Events kullanarak zaman içinde yani asenkron olarak yapılmalıdır.

  - Kısaca her şey her şeye bağlanmamalıdır, nesneleri küçük ve korunaklı aggregateler içine hapsedip bunların önünde de bir nöbetçi yani aggregate root bulunmalı.  

   ## Repository
  -  Veritabanı işlemlerini gizleyen interfaceler diyebiliriz. Nesnelerin veritabanına kaydedilmesi ve geri getirilmesini yöneten bir interfacedir. Sanki bellekteki bir collection'mış gibi davranmalıdır. Teknik veritabanı detayları(SQL sorguları vs) burada gizlenir.   
  -   **Sadece aggregate root'lar için bir repository oluşturulur.** Order bir aggregate root ise OrderRepository olmalıdır. OrderDate bir root değilse ona erişmek için bir repository olmamalıdır, ona her zaman Order nesnesi üzerinden ulaşılmalıdır.
  -   Veritabanından gelen ham veriyi(satırları ve sütunları), iş kuralları ve durumuyla birlikte bir Domain Entity haline getirir.
  -   Repository interface'i domain layer içerisinde tanımlanırken bu interface'in gerçek SQL kodlarını içeren uygulaması Infrastructure Layer içerisinde yer alır. Bu sayede business logic, veritabanına bağımlı olmaz aksine veritabanı katmanı iş katmanının tanımladığı arayüze hizmet eder. -> Dependency Inversion    
  -    DAO(Data Access Object), genellikle veritabanı tablolarının bir yansımasıdır(data centric). CRUD(Create-Read-Update-Delete) odaklıdır. Repository ise domain yani iş odaklıdır. Sadece business biriminin ihtiyacı olan sorguları ve işlemleri barındırır. Ubiquitous language kullanır.    

  ## Spring Data JPA 
- Geleneksel Spring uygulamalarında veritabanı işlemleri için; her entity sınıfı için bir DAO interface'i ve bu interface'i implemente eden bir class yazılırdı. Bu classlarda sürekli tekrar eden entityManager.persist(), entityManager.find() gibi kodlar bulunurdu. Spring Data ile bunlar ortadan kalktı. Artık class yazmamıza gerek yok sadece interface tanımlıyoruz ve spring runtimeda bu interface'in implementasyonunu otomatik olarak oluşturur.(Temel CRUD işlemlerini otomatik olarak bize sunuyor)    
- Spring Data JPA kullanmak için projemize bir bağımlılık eklememiz gerekiyor;        

 ```java  
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>  
 ```

  - Spring Boot kullanıyorsak konfigürasyonu spring otomatik olarak yapar ama manuel konfigürasyonda, Spring'e repository interface'ini nerede arayacağını söylememiz gerekir.

    ```java
    @Configuration
    @EnambleJpaRepositories(basePackages="com.example.repository")
    public class PersistenceConfig{
      //Veritabanı ayarları
    }
    ```

  - Product adında bir entitymiz olduğunu farzedelim.Spring Data ile erişmek için;

    ```java
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface ProductRepository extends JpaRepository<Product, Long>{
    //Bu bölümde hiçbir metot yazmasak bile save(), findById(), findAll(), delete() gibi metotlar hazır gelir 
    }
    ```

    JpaRepository<Product, Long>; Buradaki ilk parametre yani Product üzerinde işlem yapılacak olan Entitydir. İkinci parametre Long, o entitynin @Id yani primary key alanının veri tipidir.        
  -  Spring Data JPA kullanırken JpaRepository extend ediyoruz ama arka planda daha derin bir hiyerarşi mevcut. Hiyerarşiden en yukarıdan aşağıya doğru;   
    - **Repository<T,ID>:** En üstteki boş interfacedir. Hiçbir metot içermez.Sadece tipi belirlemek için kullanılır.   
    - **CrudRepository<T,ID>:** Temel create, read, update, delete işlemlerini sağlar.(save, findById, delete vb)   
    - **PagingAndSortingRepository<T,ID>:** CrudRepository'e ek olarak verileri sayfalama(pagination) ve sıralama(sorting) yapabilmeyi sağlar.findAll(Sort sort), findAll(Pageable pageable)    
    - **JpaRepository<T,ID>:** PagingAndSortingRepository'e ek olarak JPA'e özgü flush()(değişiklikleri hemen yansıtma), deleteBatch() gibi performans odaklı metotlar sunar.   
      > **flush():** bellekteki değişiklikler(insert, update, delete vs)  SQL olarak veritabanına gönderilir ama transaction commit edilmeden değişiklikler kalıcı hale gelmez. Transaction rollback olursa geri alınır işlemler.      
      > **deleteInBatch():**  Verilen entity listesi için tek birSQL sorgusu üreterek siler. DELETE FROM Product WHERE ID in(1,2,3,4,5,.....,100) gibi bir SQL sorgusu üretir. Yani 100 satırı tek komut ile siler. Tüm çöpleri bir torbaya koyup tek seferde attık    
      > **deleteAllInBatch()** Verilen entity yani tablodaki tüm satırları siler. DELETE FROM Product gibi bir SQL sorgusu üretir. Çöp kutusunu komple boşalttık.
      
      ```java
      @Service
      public class ProductService{
        @Autowired
        private ProductRepository productRepository;
 
        public void demoMethods(){
          Product p=new Product("Laptop", 15000.0);
      
          productRepository.save(p); // save, hem insert hem de update için kullanılır. Eğer objenin ID'si null ise insert, doluysa update yapar.
          // Genelde transactional bir yapıda, hibernate'in "dirty checking" mekanizması sayesinde metot bitene kadar veritabanına yazma yapmayabilir.
          //saveAndFlush(), değişikliği anında veritabanına gönderir, commit etmez ama SQL'i hemen tetikler. Veritabanı triggers kullanıldığında kritik olabilir. 

          Optional<Product> found=productRepository.findById(1); //find, Optional döner. Böylece NullPointerException riskini azaltır. 
          found.ifPresent(product-> System.out.println(product.getName());
 
          boolean exist=productRepository.existsById(1); //exists, veritabanında o ID ile kayıt var mı kontrol eder. Performanslıdır.
 
          long count = productRepository.count(); // count, toplam kaç kayıt olduğunu döner.
 
          productRepository.deleteById(1); //delete
 
          List<Product> sortedProduct=productRepository.findAll(Sort.by("name").ascending()); //isme göre alfabetik sıralama
 
          Pageable pageable=PageRequest.of(0,10, Sort.by("price").descending());// Sayfalama, 0. sayfayı getir, her sayfada 10 kayıt olsun. 
          Page<Product> productPage=productRepository.findAll(pageable);  
          List<Product> content= productPage.getContent();//10 adet ürün
          long totalItems=productPage.getTotalElements();//veritabanındaki toplam ürün sayısı 
        }
      }
      ```
  -  Spring Data JPA, yazdığımız metot ismini parse eder ve arkada otomatik olarak bunu SQL/JPQL(Java Persistence Query Language) sorugusuna dönüştürür. Buna **Query Derivation** denir.  Bir sorgu metodu üç temel parçadan oluşur;

      - Prefix; find...By, read..By, query..By, count...By, get..By gibi   
      - Property; entity içindeki değişken ismi, Name, Price gibi
      - Keywords; And, Or, Between, LessThan, Like, Containing, IgnoreCase  gibi
        
   Bu sorgular üretilirken camelCase dikkate alınmalı yani kelimelerin ilk harfi büyük yazılmalıdır. Diyelim ki private String productName olarak tanımladık bunu nasıl yazacağız? findByProductName olarak. Tek bir sonuç bekliyorsak Entity tipini(Product); birden fazla sonuç bekliyorsak List<Product>, Set<Product>, Stream<Product> dönebiliriz.Tek sonuç beklerken birden fazla sonuç dönerse IncorrectResultSizeDataAccessException fırlatır.  
   
      ```java
      public interface ProductRepository extends JpaRepository<Product, Long>{

        List<Product> findByName(String  name); // SELECT * FROM Product WHERE name=?
        List<Product> findByAndPriceGreaterThan(String name, Double price); // SELECT * FROM Product WHERE name=? AND price>?
        List<Product> findByContaining(String partOfName) // SELECT * FROM Product WHERE name LIKE %phone%
        List<Product> findByActiveTrue(); // SELECT * FROM Product WHERE active=true
        List<Product> findByNameIgnoreCase(String name); // SELECT * FROM Product WHERE UPPER(name)=UPPER(?)
        List<Product> findByPriceLessThanOrderByNameDesc(Double price); // SELECT * FROM Product WHERE price<? ORDER BY name DESC

      }
       
  -  Bazen query derivatin ile çözemeyeceğimiz karmaşık sorgularımız olabilir.  Bu durumda Query anotasyonunu kullanırız. Spring Data JPA bize iki farklı dil sunar;     

      - **JPQL(Java Persitence Query Language):** Veritabanı tabloları ile değil Java entity classları ile konuşur. Veritabanından bağımsızdır. Runtimeda SQL'e çevrilip çalıştırılır.

      ```java
     public interface ProductRepository extends JpaRepository<Product, Long>{
        @Query("SELECT p FROM Product p WHERE p.price> :minPrice AND p.active=true")  // p Product classını temsil eder, price ise sınıfın alanıdır.
        List<Product> findExpensiveActiveProducts(@Param("minPrice") Double minPrice);  //@Param metod parametresini sorgudaki isimle eşleştirir. Yani buradaki minPrice parametresini sorgudaki :minPrime ile eşleştirir.   
      }
       ```

     ```java
      @Entity
      @Table(name="movies")
      @NamedQueries({
          @NamedQuery(name = "Movie.yillaraGoreAra", //JPQL sorgusunu önceden tanımlayıp isim veriyor.
                      query = "select m from Movie m where m.year = :year"),
          @NamedQuery(name = "Movie.birdenFazlaYonetmenliFilmler",
                      query = "select m from Movie m join m.directors d " +
                              "group by m.id having count(d) > 1")
      })
      public class Movie { ... }
       ```
      
      - **Native SQL**: Veritabanına özgü(PostgreSQL gibi) fonksiyonları kullanmamız gerektiğinde standart SQL yazabiliriz.

      ```java
       public interface ProductRepository extends JpaRepository<Product, Long>{
        @Query(value="SELECT * FROM Product WHERE price <?1 AND stock_count>0", nativeQuery=true)  //nativeQuery=true, sorgunun JPA tarafından parse edilmeden veritabanına gönderilmesini sağlar.Eğer false olsaydı JPQL kullanılırdı.
       // ?1, metot parametresinin sırasını belirtir.price <?1 -> price<minPrice anlamına gelir 
        List<Product> findCheapInStock(Double minPrice);  // 
      }
      ```
     
  -  @Query sadece veri çekmek için kullanılmaz. Güncellemeler için de kullanılır ama **@Modifiying** anotasyonununda kullanılması gerekir. JPA normalde sorguları sadece SELECT olmasını bekler. Buyüzden INSERT, DELETE,UPDATE gibi özel sorgular yapacağımızda bunu belirtmemiz gerekir. Belirtmezsek; **InvalidDataAccessApiUsageException** fırlatır.  

     ```java
      public interface ProductRepository extends JpaRepository<Product, Long>{
       @Modifiing
       @Transactional
       @Query("UPDATE Product p Set p.price=p.price*1.1 WHERE p.category=:category") 
       int increasePriceByCategory(@Param("category") String category);
      ```
  - Custom Repository'de oluşturabiliriz istersek. Namig Convention sayesinde Spring Data kendi yazdığımız sınıfları otomatik olaak mevcut repository ile birleştirebilir. Peki bu custom repository'yi nasıl yazacağız?

    - İlk olarak interface'imizi tanımlamalıyız ;

       ```java
      public interface ProductRepositoryCustom{
        void refreshPriceUsingComplexLogic(Long id);
      } 
      ```
      
    - Interface'i implemente eden bir class yazarız. Ama bu classın adlandırmasını yaparken dikkat etmemiz gereken bir nokta var; sınıf ismi orijinal repository adının sonuna Impl eklenmelidir.

      ```java
      @Repository
      public class ProductRepositoryImpl implements ProductRepositoryCustom{
        @PersistenceContext //EntityManger nesnesini dependency injection yapar. Persistence Context; entitylerin yaşam döngüsünü ve veritabanı ile senkronizasyonunu yönetir. 
        private EntityManager entityManager;

        @Override
        public void refreshPriceUsingComplexLogic(Long id){
          //Bu kısımda QueryDSL, Criteria API veya direkt native işlemler yapabiliriz. 
          Product p=entityManager.find(Product.class,id);
          p.setPrice(newPrice);
          entityManager.merge(p);
      
        }
      }
      ```
    - Ana repositoryde bunları birleştiririz.

      ```java
      public interface ProductRepository extends JPARepository<Product,Long>, ProductRepositoryCustom{
        //hem hazır metotlarımız hemde kendi yazdığımız özel metotlarımızı aynı yerden çağırabiliriz. 
      }
      ```
     
  - Veritabanı işlemlerinde ya hep ya hiç kuralı geçerlidir. Diyelim ki üç tabloya kayıt yapıyoruz, 2. tabloya kayıt yaparken elektrikler kesildi, hata oluştu vs. Bu durumda ilk kaydın da geri alınması yani rollback gerekir.   Sadece veri okuyorsak **@Transactional(readOnly=true)** kullanarak performans artışı sağlayabiliriz.
  - **Transaction propagation**, bir transactional metod başka bir transactional metot tarafından çağrıldığında,  transactionların nasıl davranacağını belirler. Default olarak Requireddır(@Transactional(propagation = Propagation.REQUIRED)). Yani mevcut transaction vardsa katılır yoksa yeni başlatır.         

    ## NOTLAR
   - **Anemic Domain Model**:Eğer sınıflarımızda sadece getter ve setter varsa ve tüm business logic servislerin içindeyse bu gerçek bir DDD değildir. Nesneler akıllı olmalıdır ve kendi kuralllarını kendileri yönetmelidir.    
   - **Criteria API:** JPA'in sunduğu bir API'dir. Sorguları kod ile tanımlamamızı sağlar.   

     ```java
     CriteriaBuilder cb=em.getCriteriaBuilder(); //Sorgu elemanlarını(Predicate, Expression, CriteriaQuery) oluşturan fabrika sınıfıdır. EntityManager üzerinden alınır.
     CriteriaQuery<Employee> cq=cb.createQuery(Employee.class); // Sorgunun tanımını temsil eder; SELECT, WHERE, ORDER BY gibi
     Root<Employee> employee=cq.from(Employee.class); //sorgulanacak entity tanımlanır. FROM ifadesine karşılık gelir.
     Predicate condition=cb.greaterThan(employee.get("salary"), 5000); //Sorgu koşullarını temsil eder yani WHERE ifadesine karşılık gelir.
     cq.select(employee).where(condition);//sorguya koşul ekleniyor.
     List<Employee> results=em.createQuery(cq).getResultList();//sorgu çalıştırılıyor
     
     ```
   -   
   
