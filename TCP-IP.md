# Temel Tanımlar  

•**Protokol;** bir işi düzenleyen kurallar dizisidir.Ağ protokolleri de ağlar 
arası bağlantı ve iletişimi düzenler.   
• **IP(Internet Protocol**),ABD'nin savunma amaçlı geliştirdiği bir 
protokoldür.Bilgisayarların felaket anında ayakta kalabilmesini, birbirleriyle iletişim 
halinde olabilmesini amacıyla oluşturuldu.   
 
• **RFC(Request for Comment):** 1969 yılından günümüze kadar ortaya konulan 
standartların saklandığı döküman arşividir.Her internet protokolü ve mekanizması 
için bu protokolü ve mekanizmayı tanımlayan bir RFC vardır.  
• Bilgisayarları birbirleriyle konuşturabilmek için ağ protokolleri kullanırız.En 
yaygın olarak kullanılanları; NetBEUI, IPX/SPX, TCP/IP   
• NetBUI kurulması en kolay olandır ve en hızlı protokoldür. Fakat 
yönlendirilebilir bir protokol değildir.Oluşturulan paketler routerın diğer tarafına 
geçemez.(Microsoft ve IBM' in birlikte kendi bilgisayarları için geliştirdikleri bir 
protokoldür.)   
• IPX/SPX hem yönlendirilebilir hem de TCP/IP'ye göre daha hızlı ve kurulması 
kolaydır.Fakat bir sahibi vardır.(Sahibi bile şu an TCP/IP protokolünü 
kullanmaktadır.)  
• **TCP/IP(Transmission Control Protocol/Internet Protocol);** bir protokol 
kümesidir.Yavaştır ve kurulumu oldukça zordur.Bir sahibi yoktur.TCP/IP ile kurulan 
bilgisayar ağında bilgisayarı üç parametre ile tanımlarız.Bu üç parametreyi 
kullanarak bilgisayarları birbirine bağlar:  
  - **Bilgisayar Adı:** İşletim sistemi yüklenirken bilgisayara verilen addır.   
  - **IP adresi:** Dört bölümden oluşur.Nokta ile ayrılan bölümler 0-255 değerler 
alabilir.  
 - **MAC adresi(Media Access Control):** Bilgisayarlardaki ağ kartlarına ya da 
benzer ağ cihazlarının içine değiştirilmez bir şekilde yerleştirilmiş adrestir. 
Hexadecimal rakamlardan oluşur.Ağ üzerinde iletişim yalnızca MAC adresleri 
ile gerçekleşir.Çünkü IP adresi TCP/IP protokolüne özeldir,bilgisayar adları da 
sistemden sisteme değişiklik gösterebilir.Bütün protokollerde değişmeden 
kalan tek şey MAC adresidir.Alt düzey ağ teknolojilerinin kullanıldığı bir 
adrestir(ethernet, token-ring gibi). Donanım adresi(hardware address) ya da 
fiziksel adres(physical address) de denir.
   
•  **Ethernet Protokolü:** Yerel ağdaki(LAN) uç cihazların(hostların)birbirleriyle 
haberleşmesi için en çok kullanılan protokoldür.OSI'nin 1. ve 2. katmanında yani 
fiziksel ve veri bağlantısı katmanında çalışır.  
Ağlar büyüklüklerine göre karşımıza iki türde çıkar; LAN ,WAN  
•  **LAN(Local Area Network):** Sınırlı bir alandaki kullanıcılara hizmet sunar.Uç 
cihazlara erişim imkanı veren ağ yapısıdır.Uç cihazlar ethernet kablosu ile ethernet switch üzerinden birbirleriyle haberleşerek internete çıkabilirler.Temel 
bileşenleri;uç cihazlar(hostlar),uç cihazları birbirine bağlayan ara ağ cihazları ve 
bunları birbirine bağlayan medyalar(IP adresi alan her nesne artık bir host olarak 
adlandırılır.)  
• **WAN(Wide Area Network ):** Farklı LAN'ları birbirine bağlamak için kullanılır.
İletişim için bilgisayar adları IP adreslerine IP adresleri de MAC adreslerine 
çevrilir.      
•  **ARP(Adress Resolution Protocol):** IP adresini MAC adresine çevirir.TCP/IP 
protokolünün bir üyesidir.İletişime geçilecek olan bilgisayarın IP adresinin bile 
bilgisayar ARP protokolü ile "bu IP adresi kiminse bana MAC adresini versin " 
mesajını broadcast eder yani ağdaki tüm bilgisayarlara gönderir.Bilgisayarlar bu 
mesajı eğer IP kendilerine ait değilse çöpe atarlar eğer kendilerine aitse "Bu IP 
bana ait ve benim MAC adresim şu" şeklinde cevap verirler.Artık broadcast 
yapmadan mesajlarını doğrudan gönderebilirler.     
•  IP adresler manuel olarak girilebilir ya da otomatik olarak dağıtılır.Otomatik 
olarak dağıtım **DHCP(Dynamic Host Configuration Protocol)** ile yapılır.Bu 
protokolde bir bilgisayar DHCP server olarak tanımlanır ve IP dağıtımı bu sunucu 
üzerinden yapılır. Üzerine bir IP havuzu tanımlanır.IP adresi almamış bir bilgisayar 
"ben yeni açıldım benim bir IP adresim yok bana DHCP serverı bir IP adresi 
tanımlasın" mesajını broadcast eder.DHCP server bu mesajı gördüğünde IP 
havuzundaki boşta olan bir adresini bilgisayara gönderir. IP gönderirken yanında 
bazı bilgiler de gönderir. Bu yolla client'ın tüm yapılandırılması DHCP ile 
gerçekleşir.DHCP'den IP adisi alan bilgisayarlar WINS serverının adresini de 
öğreniyorlar.  
•  Bilgisayar dünyasında bilgisayarların iki adı vardır:NetBIOS,host
NetBIOS en çok 15 karakter içerebilir,"SEDA" şeklinde ad verilebilir. Host adı 
en çok 255 karakter içerebilir.Adı "bilgisayar adı+domain" şeklindedir.Bu şekilde 
tanımlanmış host adına FQN (Fully Qualified Name ) denir. "seda.guney.com.tr" 
şeklinde olur.Host adındaki ilk parametre internet domainindeki bilgisayarın 
adıdır"seda".Geriye kalan bölge internet domainini tanımlar.WINS(Windows 
Internet Name Service ) , NetBIOS adlarını IP'ye çevirir.DNS(Domain Name 
System), host adlarını IP'ye çevirir.   
• Bir bilgisayar WINS serverı olarak tanımlanır ve bütün bilgisayarlar bu server 
giderek IP adreslerini bildirir. WINS serverı bu bilgileri toplayarak bir veritabanı 
oluşturur.Böylece NetBIOS adını bildimiz zaman broadcast yapmak yerine WINS 
sunucusuna gidilir.   
• Internette bilgisayar adı - IP eşleştirmesinde DNS kullanılır.   

# TCP/IP’nin Yapısı
• TCP/IP dört katmanlı bir yapıya sahiptir.

## Ağ (network) katmanı
• Veri paketlerinin ağa iletilmesinden ve ağdan 
çekilmesinden sorumludur. Ana fonksiyonu kaynak makineden hedef makineye paketlerin yönlendirilmesidir. Tanımlanan adresler yönlendirilmiş protokol ile tanımlanır. Kaynak cihazdan hedef cihaza göndermek için kullanılan protokollere yönlendirme protokolü denir.
 •**Router(Yönlendiriciler)**, IP dünyasında gateway olarak adlandırılır ve mantıksal ağları birbirine bağlamakta kullnılır. LAN'ların Wanlara veya uzaktaki diğer LAN'lara bağlantısında kullanılır. Paketlerin gönderen ve alan düğüm arasında birden fazla yol varsa en uygun yolun seçilmesi ana görevleridir. Metrik değere göre paketler yönlendirilir; yol uzunluğu, güvenirlik, gecikme, band genişliği
 • Yönlendirme tablosu, en uygun yolun belirlenmesi için kullanılan parametrelerin tutulduğu bir matristir. Her protokol için birer yönlendirme tablosu tutulur. 
 • **Statik Yönlendirme**: IP ağlarda özel ağı belirten bir gösterici olarak tanımlanır. Arıza durumlarında kendisini güncellemez, optimum yok uzunluğu kullanmaz, yüksek seviyede güvenlik sağlar. Herbir statik router kendi router tablosunu korumakla yükümlüdür. Bu sayede bir saldırı olup router etkisiz kalırsa diğer routerlar bundan etkilenmez.
 • Ağ içerisindeki konumuna göre routerlar ikiye ayrılır;
    - Merkez: Daha güçlü donanıma ve daha iyi router algoritmasına ihtiyaç duyarlar.Port yoğunluğu ve paket işleme başarımı yüksek olur. Şaşeli üretilirler; farklı türde WAN portunu destekleyebilmek ve standartını desteklemek, esnek çözüm sunmak için. 
    - Kenar: Basit, işlem gücü fazla olmayan algortimalarla işlemlerini gerçekleştirirler. 1, 2 LAN'ın WAN!a veya uzak ofislerin merkezi LAN'a bağlanmasında kullanılır. 
 • ROS; ağ yöneticisine konfigürasyonun yapılması için bir arayüz sunar. Routerlara ağ katmanı protokolüne uygun ROS yüklenmelidir. 
 •  Router algoritmaları, tabloların dinamik olarak güncellenmesi için kullanılır. Router algoritmaları;
  - **En etkili kural** yönlendiricinin ağdaki diğer routerlara ulaşabildiği en az hop sayısının olduğudur. Her yönlendirici için bir derinlik ağacı belirlenir. Ağacın derinliği en az olacak şekilde ayarlanır.
  - **En kısa yol yönlendirmesi**, ağ içerisindeki herhangi bir router ağın tüm topolojisine sahiptir ->Dijkstra algoritması. Her router kendisine komşu olan düğümleri listeler. Kendisinden bir yönlendirici daha ilerleyerek bu işlem tekrarlanır. Böylece tüm ağ topolojisinin bilgileri toplanır. Yönlendirme tablosu yol durumuna göre kendini yeniler, günceller.
  - **Sel yönlendirmesi**, gelen paketler, paketin geldiği yol hariç diğer bütün yönlendirilebilen yollara gönderilmesidir. Paketler sürekli olarak ağda dolaşır. Bunu önlemek için; paket başlığına hop sayacı kullanılır. Routerların gönderdikleri paketleri paketleri bir saklayıcıda saklamasıdır.
  - **Uzaklık vektöre algoritması**, uzaklık bilgisini veya atlama sayısını metrik olarak kullanır. Uzaklık vektörü, routerların hemen komşusu olan routerlara göre hesaplanır. Router tablosu bilgisi yayma yoluyla bildirilir ve her router kendisine gelen yeni durumları tuttuğu tabloya yansıtır. Kendi router tablolarını bağlı oldukları routerlara bakarak dinamik şekilde oluştururlar. Router bilgisi ikinci el bilgi olduğu içinm doğruluğu hiçbir zaman kanıtlanamaz, bu güvenlik açığıdır.
  - **Bağlantı durumu algoritması**, daha çok merkez routerlarla kullanılmaktadır. En uygun yolun bulunabilmesi için metrik değer+uzaklık bilgisi+ routerların yapmış olduğu bağlantılar. Ağ içindeki bir yönlendirici ağın tüm topolojisi hakkında bilgi sahibidir. Herhangi bir router kendisinden olan bağlantıda bir değişiklik algılandığı zaman tüm ağa yayma yoluyla bildirir->yalnızca algılanan değişikliği. Paketleme sıra numarası verilir. Router'a ait daha güncel yani daha büyük sıra numaralı paket geldiğinde eski paket yok edilir. Tablolar güncellenirken birinci el bilgiler kullanılır. Hatayı elimine eder, buluşma zamanını azaltarak sıfıra yaklaştırır.
 •  Router protokolleri; router üzerinde koşan ve tablonun güncellenmesini sağlayan kurallardır. İç ve dış olmak üzere iki sınıfa ayrılır. İç; büyük olmayan özel ağ içindeki yönlendiriciler arasında. Dış; birbirinden bağımsız ve geniş ağlar arasındaki yönlendiriciler
•  Router protokolleri dinamik yönlendirme tablosu oluşturmak için ;RIP,OSPF,EGP gibi protokoller
•  Router protokolleri;IP, IPX, DECnet ..
   






  
- **Internet katmanında** iletim katmanından gelen paketler internet paketleri halini 
alır, paketlerin yönlendirilmesi yapılır.Bu katmanda 4 adet protokol çalışır; 
  ✓ **ARP:** IP adreslerini MAC adreslerine çevirir.Elde edilen MAC adresi ARP 
kaşesinde saklanır.Arp kaşesinde iki türlü kayıt bulunur; dinamik, statik. 
Dinamik kayıtlar boardcast ile bulunan adresleri gösterir. Kaşede sonsuza 
kadar kalmazlar. Kayıtlara saat bilgisi eklenir.2 dakika içerisinde kullanılmazsa 
silinir. 2 dakika içinde kullanılırsa bu sefer 10 dakika içerisinde silinir. 2 ile 10 
dakikalık sürelerden önce ayrılan alan dolarsa eski kayıt silinip yeni kayıtlara yer 
açılır.Bu registry ile değiştirilir. Statik kayıtlar elle girilir(bir adresi ARP kaşesine elle giriyorsak MAC 
adresinin her bir bitı tire ile ayrılmalıdır.) ve bilgisayar kapatılıncaya kadar saklanır. 
Statik kayıtlar bilgisayar kapatılıp açılarak, arp -d komutu ile ve farklı bir donanım 
adresi içeren ARP boarcast alınırsa silinir. Kaşede bulunan kayıtları görmek için 
arp - g, kaşeye kayıt girmek için arp -s IPadresi MACadresi ( arp -s 
192.168.0.5 00-e0-06-09-78-87 ), statik veya dinamik bir kayıt silmek için arp 
-d IPadresi komutları girilir.  
 ✓  **ICMP(Internet Control Message Protocol):** Kontrol mesajları göndererek 
paketin gidip - gitmediği hakkında feedback sağlar.   
 ✓  **IGMP(Internet Group Management Protocol):** Gruplamadan ve gruba mesaj 
gönderip almadan sorumludur.   
(Mesaj 3 farklı şekilde gönderilebilir; broadcast mesaj(bütün makinelere), 
multicast(bir gruba) , bir makineye(unicast-directed) gönderilebilir.   
  ✓ **IP:** Paketlerin adresleme ve yönlendirme işlemlerini yapar. Bağlantısız 
(connectionless) bir protokoldür. Yani mesajların yerde ulaşıp ulaşılmadığı 
kontrol edilmez.

- **İletim katmanında** bilgisayarlar arası iletişim için oturumlar düzenlenir. TCP ve 
UDP bu katmanda çalışır.    
    ✓  **TCP:** Connection-oriented (bağlantılı) ve güvenilir iletişimi sağlar. 
Bağlantılıdan kasıt bilgisayarlar iletişime geçmeden önce aralarında oturum 
açılıyor ve bu oturumu açarken birbirlerine iletişim parametrelerini iletilmesidir. 
Güvenilir iletişimden kasıt ise mesajı karşı tarafa ulaşıp ulaşmadığının kontrol edilmesidir.(Eğer paketin ulaştığına dair bir mesaj gelmezse paket tekrar 
gönderilir.) Bu durum veri iletimi performansını -hızını- düşürür.   
İletilmek istenen veriler segmentlere ayrılır ve bu segmentlere sıra numarası 
verilir.Segmentler belirli bir sayıdaki gruplar halinde topluca gönderilir. Bu gruplara 
window denir. Bir veri onarlı segmentler halinde window şeklinde gönderildiğini 
düşünelim . TCP segmenti iki kısımdan oluşur; header, data . Header kısmı da ; source 
port, destination port , sequence number, acknowledgment number(istenilen bir 
sonraki paketin numarası ), data length , reserved,flags(segmentin içeriğine dair 
bilgi ), window(TCP penceresinde ne kadar yer kaldığını gösterir) , checksum, 
urgent pointer(acil veri gösterimi) bulunur.    
Veri gönderimi sırasında segmentlerden 17. için onay gelmediğini düşünelim. 
Bu durumda windowslarımız eskiden 1-10,11-20 şeklindeyken artık 17-26 şeklinde 
olur.Window sumuzda kayma gerçekleşti. Bu yönteme kayan pencereler anlamına 
gelen sliding windows yöntemi denir.     
  ✓ **UDP(User Datagram Protocol):** Bağlantısız ve güvenilir olmayan bir 
protokoldür. Güvenilir olmaması yani mesajın gidip gitmediğini kontrol etmemesi 
ve mantıksal bağlantı kurmaması bize hız kazandıran bir durumdur. UDP’ sin 
sağlayamadığı güvenilirliği daha yukarılarda bulunan programlar sağlayabilir. 
UDP paketinin heder kısmında ; source port , destination port , mdessage 
lenght, chechsum bulunur.(Ses ve video uygulamalarının hepsi UDP kullanır.)

- **Uygulama katmanı** FTP,DNS,WINS gibi uygulamaların bulunduğu katmandır.
Ağ işlevleri içeren bir uygulama geliştirmek için iki spesifikasyonumuz vardır; 
NetBIOS, Windows Sockets.        
**NetBIOS:** Microsoft ile IBM’in birlikte geliştirmiştir. Bu spesifikasyon ile yazılan 
program sadece microsoft işletim sistemleriyle çalışır.  
**Windows Sockets(WinSock):** İnternet ortamındaki sockets’in windows 
uyarlamasıdır.Bu spesifikasyon ile yazılan programlar her işletim sisteminde 
çalışır.   
Bir soket uygulaması üç şey ile tanımlanır; Bilgisayarın IP adresi, hizmet 
tipi(TCP,UDP), kullanılan port .  
Port numaraları 0 - 65535 yer alır.0-1023 port adresleri well-known port 
number olarak adlandırılır ve internet ortamındaki standart hizmetler tarafından 
kullanılır.    
Program bir başka bilgisayarda bulunan program ile iletişime geçmek 
istediğinde bir soket yaratır ve iletişim sürecince bu soketi kullanır.  
**TTL(Time to Live):** Paketlerin sonsuza kadar dolaşmayıp silinmesini sağlar. 
Her IP paketinin bir TTL değeri vardır. Paket bir yönelticiye ulaştığından TTL 
değeri en az bir düşürülür ve eğer TTL değeri sıfır olmuşsa paket yöneltici 
tarafından silinir.

## IP Adresleme

• **IP adresi = bilgisayarın dahil olduğu ağ + bilgisayarın o ağ içindeki adresi
 = network ID + host ID**
• 32 bitten oluşur.(IPv6 128 bit kullanıyor.) İkilik düzendeki 0 ve 1 rakamlarından 
oluşur. Bizim gördüklerimiz ise 4 oktete ayrılıp her oktetin onluk düzene 
çevrilmiş halidir.    
• IP adresleri beş sınıfa bölünmüştür; 
 
 - **A Sınıfı:** İlk okteti 0 ile 126 arasındadır. Network ID ilk oktet ile belirlenir. 
Geriye kalan üç oktet o ağdaki bir bilgisayarı(host ID) gösterir. İlk oktet ile 
network ID belirlediğimize göre ve ilk oktette 8 bit bulunduğuna göre 28 ‘den 
256 farklı network ID kullanabiliriz. Ama A sınıfı belirtmek için en soldaki bit 
sıfır yapılıyor. Bu yüzden 28 değil 27 olarak hesaplıyoruz. 126 farklı A sınıfı 
network ID ve 16 milyon bilgisayar bulunabilir(3x8=24, 224=16 milyon).(IBM)
 - **B Sınıfı:** İlk okteti 128 ile 191 arasındadır. Network ID ilk iki oktet ile 
belirlenir. Geriye kalan iki oktet o ağdaki bir bilgisayarı (host ID) gösterir. 
16.000 B sınıfı network ID ve B sınıfı bir adresimiz varsa 65 bin bilgisayarı 
tanımlayabiliriz.
 - **C Sınıfı:** İlk okteti 192 ile 223 arasındadır. Network ID ilk üç oktet ile 
belirlenir. Geriye kalan bir oktet de o ağdaki bir bilgisayarı (host ID) gösterir. 2 
milyon C sınıfı network ID ve C sınıfı bir adresimiz var ise 254 bilgisayar 
tanımlayabiliriz.
 - **D Sınıfı:** İlk okteti 224 ile 239 arasındadır. Grup adreslerini içerir.IGMP’nin 
kullandığı adresler Sınıfı adresleridir. Bizim tarafımızdan verilemezler.
 - **E Sınıfı:** İlk okteti 240 ile 254 arasındadır. Testler için ayrılmıştır. Bu sınıftaki 
adreslerin çoğunluğu kullanılmamaktadır. Bizim tarafımızdan verilemezler.
  
• İnternet genelinde IP adres dağıtımını **IANA ( Internet Assigned Number 
Authority - İnternet Numara Atama Merkezi )**   
• **NAT(Network Adress Translation):** Ev ve iş ağlarının internetten yalıtılmasını 
sağlar. İç ağdaki bilgisayarların az sayıda IP’den çıkıyor.  
Ethernet ağ teknolojilerinin bir sonucu olarak bir bilgisayar yalnızca kendisiyle 
aynı fiziksel ağdaki bilgisayar ile doğrudan iletişime geçebilir. Kendi ağımızda 
olmayan bir bilgisayarla dolaylı olarak (router ile) iletişime geçebiliriz.   
• **Router(yöneltici):** Farklı bilgisayar ağlarını birbirlerine bağlamak için 
kullanılırlar. Bir ağdan diğerine gidecek olan veri paketini alıp hedefine 
ulaştırmak,yönlendirmektir.  
• Bilgisayarlar birbirleri ile iletişime geçerken aynı adreste olup olmadıklarını IP 
adreslerinin network ID’sine bakarak anlarlar. Bir bilgisayar IP adresinin hangi 
bölümünün ağı (network ID ) hangi bölümünün bilgisayarı (host ID) 
tanımladığını subret mask bilgisi ile IP adresini mantıksal ve işlemine sokarak 
anlar. (Subnet mask IP gibi dört bölümden oluşur . ) VE işlemine soktuğumuzu 
söyledik bu durumda subnet maskın 1 değerine sahip olan kısımları bize IP’mizin karşılaştırılan değerini verir.0 var ise 0’ı verir. Kolaylık olması açısından 
genellikle 255 ve 0 sayıları subnet mask olarak kullanılır. IP adresimiz ile 
subnet maske mantıksal ve kapısına sokulduğunda bize verilen değerden 
geriye kalan kısım bizim ağ içindeki adresimizi verir.  
• Eğer ağ adresleri aynı değilse veri router’a yollanacak o da gelen paketteki 
adrese bakıp hedeflenen bilgisayarı anlayacak ve ilgili bacağından veriyi o 
bilgisayara aktaracak.  
• Subnet maskeyi elimizle girdiğimizde yanlış girebiliriz. Böyle durumlarda bazı 
bilgisayarlara erişebilir bazılarına erişemeyebiliriz. 
195.134.67.0 gibi bir adresi hiçbir bilgisayara veremeyiz. Çünkü bu adres ağın 
adresidir.   
• IP Adresleme kuralları:
 
 - Hem network ID hem de host ID kısmı 255 olamaz.  
- Hem network ID hem de host ID kısmı 0 olamaz.  

Bu durumda **bir ağda tanımlanabilecek IP adresi sayısı= 2n-2** dir.  
• Ağ adreslerinin gösterimi genellikle 192.168.64.0/24 gibi şekillerdedir . Bu 
gösterimdeki /24 ifadesi ağda bulunan subnet maskesinin 24 adet 1 içerdiğini 
gösterir. Bu da bize IP adresi alanında / kısmında yer alan rakam kadar biti 
sabit bırakmamızı ve bu sabit bırakılan alan network ID ‘mizi gösterir.  
• **Alt ağlara ayırma (Subnetting)** , verilen bir adres aralığını bölümlemek ve yeni 
network ID’ler türetmek demektir. Subnetting broadcast etki alanını daraltır. 
Böylece tüm networkteki cihazlar yoğun bir boardcast mesaj trafiğine maruz 
kalmazlar. Bu da ağ performansını arttırır.   
• Üç farklı bölgedeki ağları toparlamak istediğimizde üç ayrı ağ
bölümü(segmenti) gerekir ve bu ağları router ile birbirlerine bağlamalıyız . 
Router ile birbirine bağlanan ağların her biri için ayrı bir network ID gerekir ve 
routerlar arasında kalan alanda ayrı bir ağ sayılır. Şimdi bize beş adet ağ
bölümü gerekli ama elimde sadece bir tane ağ tanımlayıcı var. Bu durumda alt 
ağlara bölmeliyim. Bunun içinde benim yetkime bırakılan oktette (c sınıfı için 
son oktette) yapmalıyım işlemi. Son oktette sekiz bit var. Beş adet alt ağ
kurmak istediğimi düşünürsek 2n-2=6’dan en az üç bir gerekli(6 bizim için fazla 
ama n 2 olduğu durumda da yeterli ağ kuramıyoruz). Bu durumda son oktetteki 
3 biti alt ağ tanımı için ayırırım .Geriye kalan 5 bit her bir ağ içerisindeki 
bilgisayarları tanımlamak için kullanılır. Bu kurduğumuz alt ağlar için artık c 
sınıfının subnet maskesini(255.255.255.0) kullanamayız. Bu maskeyi bütün 
bilgisayarlar tek bir bölümde bulunsaydı kullanmaya devam edebilirdik. Ama 
şuan bize başka bir subnet makesi gerekiyor çünkü bilgisayarlarımızın network 
ID’si ilk üç oktetle değil ilk 3 oktet ve son oktetin ilk 3 biti ile belirleniyor. Bu 
durumda IP adresinde kaç biti kullanarak alt ağa ayırma işlemi yapıyorsak 
subnet maskesinde de o kadar biti 1 yapmalıyız. Yeni subnet maskemiz 
255.255.255.224 oldu(son bit leri 11100000=224)   
• Burada unutulmamalı ki routerın her bacağına network ID verdik. Bu durumda 
routerların her bir bacağına bir IP adresi verilmelidir. Router’ın bacağına adres 
verirken o ağdaki ilk adresi veririz.  


## IP Yönlendirme
• Microsoft işletim sistemlerinde 
Server işletim sistemlerini router 
olarak yapılandırıyoruz ama diğer 
işletim sistemlerinde router 
olarak yapılandırabilmek için 
registry’de değişiklik yapmak ya da 
özel programlar kullanmak 
gerekiyor.    
• Router kurulduğunda bilgisayarların bundan haberi yoktur. TCP/IP 
yapılandırma kısmındaki default gateway parametresi ağdaki router’ın IP 
adresini verir. Yerel ağda olmayan bir adrese ulaşmaya çalıştığımızda bize 
router’ın adresini gösteriri.  
• Teorik olarak TCP/IP yüklü her aygıt router yapılabilir. Makinenin remote 
access rolüyle router olarak çalıştırılabilmesi ve NAT,VPN gibi hizmetler 
verebilmesini sağlar.  
• Routing table’ı görebilmek için route print komutunu kullanırız .Eğer tabloya 
ekleme yapmak istiyorsak; route add ağadresi mask ağmaskesi 
gatewayaddress metric metric degeri (route add 205.56.78.0 mask 
255.255.255.0 195.194.34.10 metric 2) Bu komut verildiğinde 205.56.78.0 
ağındaki bir makineye paket göndermek istersen paketi 195.194.34.10 
adresinden router’a gönder demiş oluruz. Temel ilkemiz istemcilerle değil ana 
bilgisayarlarla ya da aygıtlarla işem yapmak. Tek tek istemcilerle uğraşmak 
yerine router’lara komut vermeliyiz(çünkü sayıca daha azlardır).  
• Route komutu ile eklenen yol bilgileri bilgisayar kapatılana kadar geçerlidir. 
Bilgisayarı kapattığımızda eklenen yol bilgisi de silinir. Route komutunun kalıcı 
olmasını istiyorsak route add komutuna -p anahtarını eklemeliyiz(route add -p 
….)  
 • Route tablo üç kısımdan oluşur; interface list, IPv4 route table , IPv6 route 
table  
![image](https://github.com/user-attachments/assets/20a76913-3169-45b3-b825-99db93023541)

• **Interface List:** Burada bilgisayarın ağ bağlantıları görülüyor. Üçüncü ISATAP 
bağlantısını gösteriyor. ISATAP arabirimi IPv4 üzerinden bazı IPv6 
işlemlerinin yapılabilmesini sağlıyor.    
• **IPv4 Route Table:** Tablodaki satırlar bir ağ adresini ve ağa ulaşılma şeklini 
gösteriyor.  

- **Gateway:** Ağa bakan yönelticinin adresi
- **Metric:** Bu ağın uzaklığının bir ölçüsüdür. Genellikle bu ağa ulaşmak için 
katedilmesi gereken router sayısına eşittir. (router sayısı+1) 
- **Interface:** Ağa ulaşmak için bilgisayarımızda kullanılan IP. (Bilgisayarda 
birden fazla ağ kartı olabilir her birine farklı IP verileceği gibi bir ağ kartı 
birden fazla IP’ de alabilir.) 
• Eğer paketleri göndereceğimiz IP adresimiz kendi ağımıza ait değilse 
-yönlendirme bilgisi yoksa- gateway’e gidilir. İlk alanda 0.0.0.0 ağ adresi var . 
Bu kendi adresimiz dışında her türlü adres demektir. Gateway bize bizim 
ağımızda olmayan IP adresleri için 10.1.0.1 adresine gidileceğini söylüyor. 
İkinci satırda network destination ile ınterface IP adresinin aynı ağda 
olduğunu görüyoruz. Gateway’de yer alan on-link ifadesi bu ağa doğrudan 
ulaşılabildiğini bir gateway’e, router’a ihtiyaç olmadığını gösterir.
Üçüncü satırdaki network destination bilgisayarımızın kendi IP adreslerinden 
biri .Bu ağa gönderilen paketler yine kendimize yönelticek.
Dördüncü satırdaki network destination (10.1.255.255) yerel yayın yapılacak 
paketi 10.1.0.177 adresinden çıkartabileceğimizi gösterir. 
Beşinci sattırdaki adres özel test adresidir. TCP/IP yüklendiğinde otomatik 
olarak oluşturulur. 127 ile başlayan bir IP adresi ile karşılaştığımızda paketi 
127.0.0.1 adresine göndereceğimiz anlamına gelir.   
• Altıncı ve yedinci satırdaki adresler 127 ile başlayan adresleri değil tek bir 
adresi gösteriyor.
•  10.1.0.225 gibi bir IP görseydik bu kendi ağımızdaki broadcast adresimiz 
olurdu. Bulunduğumuz ağda tüm makinelere giden bir paket göndereceğimiz 
zaman paketi bu adrese yollarız.  
• Sekizinci, dokuzuncu satırdaki adresler multicast adresleridir.
Onuncu, on birinci satırdaki adresler genel broadcast adresleridir.
Yayın adresleri iki çeşittir; yerel yayın adresleri, genel yayın adresleri 

- **Yerel yayın adresi:** Tek bir ağdaki tüm bilgisayarları gösterir 
(10.255.255.255 gibi). Yerel yayın 
adresi üzerinde bulunduğumuz 
bilgisayarın IP adresinden üretilir. 
- **Genel yayın adresleri:** Tüm 
ağlardaki tüm bilgisayarları 
hedefler. Bu adreslere **Internet 
Yayın Adresi(Internet Broadcast 
Address)** de denir. İnternet yayın 
adresi bir tanedir: 
**255.255.255.255** 
Bilgisayarımızda bir IP adresi 
olmasa bile bu adres vardır ve kullanılabilir

![image](https://github.com/user-attachments/assets/db2c0c50-6819-4a49-b419-e2fba89e980a)

• DHCP internet yayın adresini kullanır. Çünkü DHCP bilgisayarın IP adresi 
almasını sağLarken bilgisayar IP adresine sahip değildir. Yani bir yerel yayın 
adresi yoktur.   
• **IPv6 Route Table:** If interface demek. İlk satır IPv4’daki local loopback 
adresine benzer. İkinci satır bulunduğumuz IPv6 ağını gösterir. Dördüncü ve 
beşinci satırdaki adresler iki ağ kartımızın adreslerine karşılık geliyor. Altıncı 
ve yedinci adresler link-local adrestir. Sekizinci,dokuzuncu ve onuncu adres 
multicast adresleridir.  
•  **PING süresi;** bilgisayarımız ile karşıdaki sunucu arasında bir veri paketinin 
iletilmesi esnasında geçen süredir. PING komutu ile verilen IP adresine sahip 
bilgisayarla aramızda sağlıklı bir TCP/IP iletişimi olup olmadığını öğrenebilir ve 
ona ne kadar sürede ulaşıldığını görebiliriz. Yazımı ping IPadresi veya ping 
Localhost . Localhost kendi adımıza karşılık gelir ve **127.0.0.1** adresine 
dönüştürülür. Pıngleyebilmemiz bize karşı bilgisayarın ayakta olduğunu, sağlıklı 
bir iletişim kurulabiliğini gösterir. Fakat bir adresi pingleyememek karşı 
bilgisayarın ayakta olmadığını veya onunla iletişim kuramadığımızı göstermez. 
Tracert (trace route’dan gelir) komutu bir IP’ ye ulaşırken kullandığımız yolu 
gösterir,yolu izler. Bu komutu verdiğimizde girilen IP adresine çeşitli paketler 
gönderilir ve bu paketlerin karşı tarafa hangi router üzerinden gittiğini 
görüntüler.      
•  Pathping komutu ping ile tracert komutunun birleşimi gibidir. Hem karşı taraf 
ile sağlıklı bir iletişim olup olmadığını anlamaya yarar hem de karşı tarafa 
giderken geçtiğimiz yolu gösterir.   
•  Yönelticilere elle bilgi girmek yerine bu bilgilerin otomatik olarak 
güncellenmesi için yönlendirme protokolleri(routing protocol) kullanırız. Routing 
protokolleri sayesinde routerlar yol bilgilerini birbirleri ile paylaşırlar ve bu 
bilgileri güncel tutarlar. Routing protocol; RIP , OSPF  

- **RIP(Routing Information Protocol):** Uzaklık vektör algoritması ile çalışan ve 
yönlendirme hesaplamak için Bellman-Ford algoritmasını kullanan bir 
protokoldür. RIP yönlendiriciler en iyi yol seçimini yaparken sadece geçtiği 
cihaz sayısına(hop) bakar. RIP en fazla 15 hop kabul eder. Bu sayı 
aşıldığında destination unreachable hatasını verir.Yani RIP büyük ağlarda 
kullanılamaz.Kolay yapılandırılabilir,fazla trafik üretir, yavaş
yakınsar(Yakınsama:Ortamdaki yönelticilerin ortamdaki tüm ağlardan 
haberdar olma durumudur). Kısaca; belirli zaman aralıklarında sahip 
oldukları network bilgilerini komşu routerlarına gönderir.Aynı şekilde komşu 
routerlarıdan da aynı bilgileri alır. En çok beş dakika içerinde bu bilgiler 
güncellnemezse RIP ile gelen bilgi silinir.  
- **OSPF(Open Shortest Path Information Protocol):** Büyük ağlar için uygundur. 
Zor yapılandırılır, hızlı yakınsar. Ağdaki iki nokta arasında bulunan tüm 
yolların bilgisine ulaştıktan sonra SPF(shortest path first) algoritmalarını 
kullanarak hangi yolun daha iyi olduğuna karar verir ve link-state refresh(hat 
durumu güncellemesi) 30 dakikada bir güncellemeler gönderir. Uzaklık 
vektörü protokolleri gibi metric değer kullanmazlar. Routerlarda komşu routerlar tanımlanır. Routerlar yönlendirme tablosu bilgilerini yalnızca komşu 
routerlara gönderir ve bunu yayın şeklinde değil noktadan noktaya (point to 
point ya da unicast) bir trafikle yaparlar.İlk trafik dışında birbirlerine yalnızca 
değişiklikleri gönderirler.     
•  Ethernet teknolojisi üzerinde yer alan ağ protokolleri ile ilgilenmez. Bu 
protokolleri ilişkin veriler Ethernet paketinin data bölümünde yer alır. 
Ethernet framework;

![image](https://github.com/user-attachments/assets/25262c57-d8c3-4563-b68f-067372019ceb)

(Ağımızda bağlantıyı sağlamak için bir ethernet hub’ı kullanıyorsak paket tüm 
makinelere ulaştırılır ama sadece MAC adresi belirtilen makine paketi işler. 
Ağımızda Ethernet anahtarı (switch) kullanıyorsak paket yalnızca MAC adresi 
belirtilen makineye gönderilir.) 
Makineler aynı ağda değilse paket doğrudan gönderilemez. A’dan çıkan ve 
farklı bir ağdaki C makinesini hedefleyen Ethernet çerçevesinde IP adresinden 
yer alan aıcı adresi C’yi Ethernet bölümündeki alıcı adresine baktığımızda 
paketin routera gittiğini görüyoruz.  

![image](https://github.com/user-attachments/assets/32b476ce-0220-45ce-a732-b8603f9128d5)

• Router kendisini hedeflemeyen bir paket geldiğinde yönlendirme tablosundaki 
bilgileri kullanarak bu paketin hangi bacağına bağlı ağda olduğunu anlar. 
Paketin vuracağı C adresinin MAC adresini bulur ve paketi o bacaktan ağa 
çıkartır. Router IP paketinin alıcı ve gönderen IP adresleri kısmına dokunmaz. 
Değişen tek şey MAC adresidir;

![image](https://github.com/user-attachments/assets/7446d610-8fbb-4b59-9820-fa6824e672e1)

• **NAT(Network Address Translation):** Bir ağda bulunan bilgisayarın kendi ağı 
dışında başka bir ağa veya internete çıkarken farklı bir IP adresi kullanabilmesi 
için geliştirilmiş bir internet protokolüdür. NAT mekanizmasında bir içi(private) 
ağ ve bir dış (public) ağ vardır. NAT , yönlendiriciler gibi bu iki ağa da doğrudan 
bağlıdır. NAT kendisine iç ağdan gelen paketi alır. Paketteki gönderen IP 
adresini silip kendisinin dışa bakan bacağının IP adresini yazar. Bu arada 
paketin içeride hangi makinenin hangi portundan gelen paket , dışarıdaki hangi 
makinenin hangi portuna gittiğine dair bir tabloya yazar. NAT’tan C’ye giden 
paket;

![image](https://github.com/user-attachments/assets/c99d2866-7b57-498f-bba9-f679a5d76c63)




• Paket C’ye ulaştığında C makinesi bu paketin A’dan geldiğini anlayamaz. 
Çünkü pakette A’ nın adresi bulunmamakta.C m. akinesi cevap verecekti 
NAT’ın dış bacağındaki IP adresine verir. NAT gelen pakete bakar ve 
tablosundan mesajın iç ağda hangi makineye gideceğine karar verir. İç ağdaki 
makineler NAT’ın iç ağdaki bacağının adresini kendilerine default gateway olara 
tanımlarlar. Onlar bu makinenin router mı yoksa NAT mı olduğunu bilmezler, 
bilmelerine de gerek yoktur.  
• NAT makinesini DHCP server gibi çalıştırıp iç ağdaki makinelere IP adresi 
dağıtmasını, DNS proxy(iç ağdaki makineler NAT’ı DNS server olarak görür) 
gibi çalışmasını sağlayabiliriz. NAT kendisi DNS server olmasada kendisine 
istemcilerden gelen DNS sorgularını başka DNS sunuculardan bilgi alarak 
yanıtlar.   
• NAT iç ağın adresini dış ağdan yalıtmaktadır. İç ağda rezerv edilmiş adresleri 
bile kullanabilmemizi sağlamaktadır. Bu da IP adresi sıkıntısını büyük ölçüde 
azaltmaktadır. Binlerce makineyi tek bir IP adresi üzerinden Internet’e 
çıkartabiliriz.NAT’ın bir başka yararı da dış ağda yet alanların içi ağa 
erişememeleridir.  
•  Bazı internet protokollerinin ve uygulamalarının çalışması için kaynak ve 
hedef IP adresine ihtiyaç duyar. Sayısal imza gibi uygulamalar NAT tarafından 
kaynak IP değiştirildiği için , NAT kullanılan yerel ağda çalışmazlar . Bazen 
static NAT kullanılarak bu sorun ortadan kaldırılabilir.   
•  NAT’ın dış bacağına gelen istekleri iç ağdaki makinelere yönlendirebiliriz. 
Buna server publishing(sunucu yayınlamak) denir.  
• **VPN(Virtual Private Network):** Özel bir ağdır. Bilgisayarınız ile uzaktaki bir ağ
arasındaki, başkalarının erişemeyeceği bir ağdır. Sanaldır , gerçekte böyle bir 
ağ yoktur. Bağlantı herkese açık internet üzerinden yapılır. İnternet gibi halka 
açık ağlar üzerinden güzenli bir şekilde kullanıcıların kendi kurum kaynaklarına 
erişmelerini sağlayan bir ağ teknolojisidir. VPN ağı kurduğumuz 
bilgisayarımızda iki IP adresi oluşur ;

- bilgisayarımızın normalde sahip olduğu IP adresi 
- VPN bağlantısı için aldığı bağlantı adresi
  
•  **PPP(Point to Point Protocol) :** Microsoft tarafından yaratılan iki bilgisayarı 
çevirmeli ağ üzerinden birbirine bağlamaya yarar.  
VPN, Internet üzerinden bir tünel açar. Bu tünellemeyi sağlayan iki protocol 
bulunur;

- **PPTP(Point to Point Tunneling Protocol):** Microsoft tarafından üretilmiş ve 
yapılandırılması otomatiktir, kullanımı kolaydır. Kendi içinde şifreleme 
(encryption) özelliği taşır, iletilen veriler otomatik olarak şifrelenir. 
- **L2TP(Layer 2 Tunneling Protocol):** Microsoft ve Cisco tarafından üretilmiştir. 
Yapılandırılması zordur, şifreleme işlevi yoktur. Şifreleme için IPSec kullanılır. 
IPSec ağ katmanında çalışarak IP paketlerinin IPSec aygıtları arasında 
korunmasını ve kimlik denetiminin gerçekleşmesini sağlar. Ağ katmanında 
çalıştığı için uygulamadan bağımsız olarak her veriyi şifreler ve sonrasında 
oluşturduğu başlık ile verinin İnternette rahatlıkla yolculuk etmesini sağlar.
 








