# Domain Driven Design 
- Karmaşık yazılım projelerini yönetmeek için kullanılan bir felsefe veya yöntemler bütünüdür. Amacı; yazılımı üzerinde çalıştığı domaine(iş alanına) göre şekillendirmektir. Yazılım sadece koddan oluşmamalıdır, işin gerçek hayattaki işleyişinin bir yansıması olmalıdır.Yazılımcının teknik dünyası ile product ownerın gerçek dünyası arasındaki uçurumu kapatmak.

  ## Temel Kavramlar 
  -  **Domain**: Yazılım ile çözmeye çalıştığımız işin kendisidir. Bankacılık yazılımı yaptığımızı varsayalım o zaman bizim domainimiz bankacılıktır.
  -  **Domain Expert**: Yazılımı yapan değil, o işi en iyi bilen kişidir.   
  -  **Model**: Gerçek hayatın basitleştirilmiş versiyonudur. Sadece yazılımın ihtiyacı olan kuralları içerir.
  -  **Entities**:Bir idetitysi olan nesnelerdir. Örneğin; Müşteri entityi, müşterinin soyadı değişse bile aynı müşteridir -> ID'si sabittir.
  -  **Value Objects**: Değişmez(immutable) yapılardır. Kimliği olmayan, sadece değeri olan şeylerdir. Örneğin; Adres. İki adresin sokak, no gibi tüm bilgileri aynıysa bunlar aynı kabul edilir.
  -  **Services**: Bazı işlemler ne bir entitye ne de bir value objecte aittir. Mesela; parayı A bankasından B bankasına transfer et işlemi bir servistir.
  -  **Invariant**: bir iş kuralının her zaman doğru kalması gereken durumdur. Mesela; bir siparişin tutarı asla negatif olamaz. Bu bir invarianttır.     
  - **Aggregates**: Birbiri ile sıkı sıkıya bağlı nesneler grubudur. Veri bütünlüğünü sağlamak için bir grup nesnenin tek bir kök(aggregate root) üzerinden yönetilmesidir. Dışarıdan kimse içeriye dokunamaz, sadece kök üzerinde işlem yapılır. Kodun herhangi bir yeride invariants kuralı bozacak bir işlem yapılmasını engellemek için nesneleri aggregate dediğimiz korualı gruplara hapsederiz.   
  - **Factory**: Karmaşık nesnelerin oluşturulma mantığını saklayan yapılardır. 
  - **Repository**: Verilerin kaydedildiği ya da geri getirildiği kapılardır, veritabanı işlemlerini gizleyen interfaceler de diyebiliriz.          
 
- Herkesin yani yazılımcının da product ownerında anladığı ortak bir dil oluşturulur. Buna **ubiquitous language** denir. Productowner diyelim ki bu işlem gerçekleştiğinde müşteri pasife alınsın diyor. Kodda bu durumu gerçekleştiren metot ismi MusteriyiPasifeAl olmalıdır. StatusUpdate(0) gibi teknik şeyler kullanılmaz.
- Büyük projeleri yönetmek için parçala ve yönet mantığı kullanılır. Burada da karşımıza **bounded context** terimi çıkıyor. Büyük bir sistemde bir kelimenin farklı yerlerde farklı anlamlara gelmesi olarak açıklayabiliriz. Ürün denildiğinde satış birimi bunu fiyatı olan şey olarak görürken lojistik birimi ağırlığı olan şey olarak görür. Eğer bu sınırları çizmezsek kodlar birbirineaşırı bağımlı tightly coupled yani aşırı bağımlı olur. İşte DDD bunları birbirinen ayırır.Her birim kendi bağlamında, kendi evreninde çalışır. Bu küçük şeylerin de birbiriyle nasıl konuştuğunu gösteren haritaya **context map** deriz. Farklı bağlamların birbiriyle nasıl veri alışverişi yapacağının stratejisidir.
- Büyük ve karmaşık domain yönetilebilir parçalara bölünerek subdomainler elde edilir. Subdomainleri, üç ana başlık altında inceleyebiliriz;
  - **Core Subdomain**: Şirketi rakiplerinden ayıran, para kazandıran, özgün kısımdır. En karmaşık mantık bu bölümde bulunur. Özel olarak kodlanan kısımdır.
  - **Supporting Subdomain**: Core domainin çalışması için gerekli ama tek başınada mesela Amazonu amazon yapan şey değildir. İşimize özeldir ama yıkıcı bir rekabet avantajı da sağlamaz. Dışarıdan birine yaptırılabilir ya da mevcut kütüphanelerle geliştirilebilir. Mesela stok takip sistemi. Stok takip sistemi olmadan satış yapamazyız ama her stok takip sistemi kullanan da amazon olamaz.
  - **Generic Subdomain**: İşimize özgü hiçbir tarafı olmayan, neredeyse her şirkette aynı şekilde çalışan kısımlardır. Genellikle hazır bir yazılım satın alınır veya açık kaynaklı çözümler kullanılır.Mesela; ödeme altyapısı(iyizico, PayPal gibi).
- Subdomain ile bounded contextin farkı ne diyecek olursak; subdomain iş dünyasındaki bölümlerdir; lojistik, finans, satış gibi. Bounded context, iş bölümlerinin koddaki karşılığıdır.    

    ### Layer Architecture
  - DDD, dört katmanlı bir yapıda uygulanır;      
    -   User Interface: Kullanıcının gördüğü ekranlar.    
    -   Application Layer: Business adımlarını koordine eder iş kuralı, mantığı içermez. Sadece şunu al, şuraya ver der.   
    -   Domain Layer: Sistemin kalbidir. Tüm iş kuralları, entities, value objects burada yaşar.    
    -   Infrastructure Layer: Veritabanına bağlanmak, e-posta göndermek gibi teknik detayların bulunduğu yerdir.    
