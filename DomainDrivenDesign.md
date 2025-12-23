# Domain Driven Design 
- Karmaşık yazılım projelerini yönetmeek için kullanılan bir felsefe veya yöntemler bütünüdür. Amacı; yazılımı üzerinde çalıştığı domaine(iş alanına) göre şekillendirmektir. Yazılım sadece koddan oluşmamalıdır, işin gerçek hayattaki işleyişinin bir yansıması olmalıdır.Yazılımcının teknik dünyası ile product ownerın gerçek dünyası arasındaki uçurumu kapatmak.

  ## Temel Kavramlar 
  -  **Domain**: Yazılım ile çözmeye çalıştığımız işin kendisidir. Bankacılık yazılımı yaptığımızı varsayalım o zaman bizim domainimiz bankacılıktır.
  -  **Domain Expert**: Yazılımı yapan değil, o işi en iyi bilen kişidir.   
  -  **Model**: Gerçek hayatın basitleştirilmiş versiyonudur. Sadece yazılımın ihtiyacı olan kuralları içerir.
  -  **Entities**:Bir idetitysi olan nesnelerdir. Örneğin; Müşteri entityi, müşterinin soyadı değişse bile aynı müşteridir -> ID'si sabittir. Entityler yaşam süreleri boyunca izlenebilir olmalıdır. Entityler sadece veri torbaları yani DTO değildir. Kendi verilerini korumalı ve üzerinde işlem yapacak iş metotlarına yani davranışlara sahip olmalılardır.  
  -  **Value Objects**: Değişmez(immutable) yapılardır. Kimliği olmayan, sadece değeri olan şeylerdir. Eğer bir değer değişecekse,nesne güncellenmez; yenisi oluşturulur. Özellikler bir bütündür. Örneğin; Adres. Sokak, kapı no, şehir bilgileri bir arada tutulur bunlar birbirinden ayrılmaz parçalardır. İki value objectin eşit olup olmadığını anlamak için ID'lerine değil içindeki tüm özelliklere bakılır. İki adresin sokak, no gibi tüm bilgileri aynıysa bu iki nesne eşittir.**Entity sayısını azaltıp, value object sayısını arttırmak sistemi daha hafif, daha kolay test edilebilir ve daha az hata payı içeren bir hale getirir.**    
  -  **Domain Services**: Bazı işlemler ne bir entitye ne de bir value objecte aittir. Mesela; parayı A bankasından B bankasına transfer et işlemi bir servistir. Stateless yani durumsuzlardır. Servisler kendi içlerinde bir durum saklamazlar; bir veri alırlar, işlerler ve sonuç dönerler. Teknik bir servis değillerdir(veri tabanı bağlantısı gibi), business logicin bir parçasıdır, saf iş kuralı barındırırlar. 
  -  **Invariant**: bir iş kuralının her zaman doğru kalması gereken durumdur. Mesela; bir siparişin tutarı asla negatif olamaz. Bu bir invarianttır.     
  - **Factory**: Karmaşık nesnelerin oluşturulma mantığını saklayan yapılardır. Bir nesnenin yaratılması için çok fazla kural gerektiriyorsa bu nesnenin kendi içinde değil bir factory içinde tutulur. Böylece nesne sadece kendi işine odaklanır.    
  - **Repository**: veritabanı işlemlerini gizleyen interfaceler diyebiliriz. Nesnelerin veritabanına kaydedilmesi ve geri getirilmesini yöneten bir interfacedir. Sanki bellekteki bir collection'mış gibi davranmalıdır. Teknik veritabanı detayları(SQL sorguları vs) burada gizlenir. **Sadece aggregate root'lar için bir repository oluşturulur.**
  - **Domain Event**:İş akışından önemli bir şey olduğunda sistemin geri kalanına haber veren sinyallerdir. Sistemler arasındaki couplingi azaltır.           
 
- Bir nesne Factory ile doğar. Aggregate sınırları içerisinde iş kurallarını uygulayarak yaşar. Repository aracılığı ile saklanır veya uyandırırlır.   
- Herkesin yani yazılımcının da product ownerında business analistinde anladığı ortak bir dil oluşturulur. Buna **ubiquitous language** denir. Productowner diyelim ki bu işlem gerçekleştiğinde müşteri pasife alınsın diyor. Kodda bu durumu gerçekleştiren metot ismi MusteriyiPasifeAl olmalıdır. StatusUpdate(0) gibi teknik şeyler kullanılmaz.
- Büyük projeleri yönetmek için parçala ve yönet mantığı kullanılır. Burada da karşımıza **bounded context** terimi çıkıyor. Büyük bir sistemde bir kelimenin farklı yerlerde farklı anlamlara gelmesi olarak açıklayabiliriz. Ürün denildiğinde satış birimi bunu fiyatı olan şey olarak görürken lojistik birimi ağırlığı olan şey olarak görür. Eğer bu sınırları çizmezsek kodlar birbirineaşırı bağımlı tightly coupled yani aşırı bağımlı olur. İşte DDD bunları birbirinen ayırır.Her birim kendi bağlamında, kendi evreninde çalışır. Bu küçük şeylerin de birbiriyle nasıl konuştuğunu gösteren haritaya **context map** deriz. Farklı bağlamların birbiriyle nasıl veri alışverişi yapacağının stratejisidir.
- Büyük ve karmaşık domain yönetilebilir parçalara bölünerek subdomainler elde edilir. Subdomainleri, üç ana başlık altında inceleyebiliriz;
  - **Core Subdomain**: Şirketi rakiplerinden ayıran, para kazandıran, özgün kısımdır. En karmaşık mantık bu bölümde bulunur. Özel olarak kodlanan kısımdır.
  - **Supporting Subdomain**: Core domainin çalışması için gerekli ama tek başınada mesela Amazonu amazon yapan şey değildir. İşimize özeldir ama yıkıcı bir rekabet avantajı da sağlamaz. Dışarıdan birine yaptırılabilir ya da mevcut kütüphanelerle geliştirilebilir. Mesela stok takip sistemi. Stok takip sistemi olmadan satış yapamazyız ama her stok takip sistemi kullanan da amazon olamaz.
  - **Generic Subdomain**: İşimize özgü hiçbir tarafı olmayan, neredeyse her şirkette aynı şekilde çalışan kısımlardır. Genellikle hazır bir yazılım satın alınır veya açık kaynaklı çözümler kullanılır.Mesela; ödeme altyapısı(iyizico, PayPal gibi).
- Subdomain ile bounded contextin farkı ne diyecek olursak; subdomain iş dünyasındaki bölümlerdir; lojistik, finans, satış gibi. Bounded context, iş bölümlerinin koddaki karşılığıdır.    

    ## Layered Architecture
  - DDD'nin sağlıklı bir şekilde çalışabilmesi için Separation of Concerns prensibi uygulanmalıdır. DDD, dört katmanlı bir yapıda uygulanır;      
    -   User Interface: Kullanıcının gördüğü ekranlar.    
    -   Application Layer: Business adımlarını koordine eder. İş kuralı, mantığı içermez. Sadece şunu al, şuraya ver der yani domain nesnelerini görevlendirir.      
    -   Domain Layer: Sistemin kalbidir. Tüm iş kuralları, entities, value objects burada yaşar. Hiçbir katmana bağımlı olmamalıdır.      
    -   Infrastructure Layer: Veritabanına bağlanmak, e-posta göndermek gibi teknik detayların bulunduğu yerdir.


   ## Relational Pattern
  
    ### Anti-Corruption (ACL)
    -  Yeni, temiz bir DDD sistemi, legacy ve kötü tasarlanmış bir sistem ile konuşacaksa araya bir proxy, facade, translator koyulmalıdır. Bu eski sistemdeki kötü modellemenin yeni sisteme sızması engellenir.

    ### Conformist
    - İki farklı bounded context arasındaki ilişkiyi tanımlar ve genellikle güç dengesizliği durumunda ortaya çıkar. Bu ilişkikide bir taraf (Downstream-Alıcı) diğer tarafın(Upstream-Sağlayıcı) modelini olduğu gibi hiç değiştirmeden kabul eder.
    - Normalde DDD, ACL kullanmamızı önerir. Ancak pazar gücü yüksek Paypal gibi bir sistemi entegre ediyorsak Paypal bizim için modelini değiştirmez, olduğu gibi kullanmamız gerekir. Bu gibi durumlarda conformist ilişki kurulur.

    ### Customer/Supplier
    - Bu ilişkide iki taraf vardır;
      - Upstream(Supplier-Tedarikçi):Veriyi veya servisi sağlayan taraftır. Diğer tarafın çalışması için gerekli olan çıktıları üretir.
      - Downstream(Customer-Müşteri): Supplierdan gelen çıktıları kullanan tarafır. Supplier'a bağımlıdır. 
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
  - Bir transaction başladığında sadece bir aggregate güncellenmelidir. Bu sistemin ölçeklenebilirliğini arttırır ve deadlock sorunlarını önler. 
  - Vaugh Vernon'un Kuralları;
    - Küçük tutulmalıdır. Büyük kümeler performans sorunlarına ve veritabanı kilitleme hatalarına yol açar. Sadece beraber değişmesi gereken, minimum nesne kümeye dahil edilmelidir.
    - Bir aggregate başka bir aggregate'e referans verecekse bunu nesne olarak değil, ID üzerinden yapmalıdır.
    - Bir değişiklik başka bir kümede güncelleme gerektiriyorsa anlık değil Domain Events kullanarak zaman içinde yani asenkron olarak yapılmalıdır.

  - Kısaca her şey her şeye bağlanmamalıdır, nesneleri küçük ve korunaklı aggregateler içine hapsedip bunların önünde de bir nöbetçi yani aggregate root bulunmalı.  

   ## Repository
  -  Veritabanı işlemlerini gizleyen interfaceler diyebiliriz. Nesnelerin veritabanına kaydedilmesi ve geri getirilmesini yöneten bir interfacedir. Sanki bellekteki bir collection'mış gibi davranmalıdır. Teknik veritabanı detayları(SQL sorguları vs) burada gizlenir.   
  -   **Sadece aggregate root'lar için bir repository oluşturulur.** Order bir aggregate root ise OrderRepository olmalıdır. OrderDate bir root değilse ona eirşmek için bir repository olmamalıdır, ona her zaman Order nesnesi üzerinden ulaşılmalıdır.
  -   Veritabanından gelen ham veriyi(satırları ve sütunları), iş kuralları ve durumuyla birlikte bir Domain Entity haline getirir.
  -   Repository interface'i domain layer içerisinde tanımlanırken bu interface'in gerçek SQL kodlarını içeren uygulaması Infrastructure Layer içerisinde yer alır. Bu sayede business logic, veritabanına bağımlı olmaz aksine veritabanı katmanı iş katmanının tanımladığı arayüze hizmet eder. -> Dependency Inversion    
  -    DAO(Data Access Object), genellikle veritabanı tablolarının bir yansımasıdır(data centric). CRUD(Create-Read-Update-Delete) odaklıdır. Repository ise domain yani iş odaklıdır. Sadece business biriminin ihtiyacı olan sorguları ve işlemleri barındırır. Ubiquitous language kullanır.    
         
    ### Anemic Domain Model
    - Eğer sınıflarımızda sadece getter ve setter varsa ve tüm business logic servislerin içindeyse bu gerçek bir DDD değildir. Nesneler akıllı olmalıdır ve kendi kuralllarını kendileri yönetmelidir. 
