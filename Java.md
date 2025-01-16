## Temeller

• Temelde baktığımızda javada new kullanmadan obje oluşturamayız. Ancak Stringler, Arrayler, Wrapperlar, Enumlar oluştururken new kullanmadan obje oluşturabiliriz. Bu durumu reflectionlarla da sağlayabiliyoruz. Kısaca javada new anahtar kelimesi kullanmadan da obje oluşturulabilir.    
• **JavaBeans**, Java programlama dilinde yazılmış ve belirli bir standart yapıya uyan, yeniden kullanılabiliğr bileşenlerdir. Genellikle veri taşıma nesneleri(DTO) olarak veya GUI bileşenleri olarak kullanılır.    
 
  - Her java en az bir parametresiz constructor'a sahip olmalıdır.
  - Private alanlara sahip olmalıdır. Bu alanlara erişim için getter/setter metodları kullanılır. Encapsulation'ı destekler.  
  - "java.io.Serializable" interface'ini kullanarak stream'e yazılabilir hale getirir. Bu da nesnelerin dosyaya kaydedilmesini ve ağ üzerinden iletilmesini sağlar.  
  - Fields tanımlar; uygulama ve kullanıcı arabirimleri ile etkileşim için.  
    
• **Stream**; Java'da veri akışlarını temsil eden yapılardır. Veri okuma, yazma işlemlerini çaşitli kaynaklardan hızlı ve verimli bir şekilde gerçekleştirmek için kullanılır. Java streamleri verilere üst düzey erişim sağlar ve farklı veri biçimlerine kolayca uyum göstermesini sağlar.    
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
• **Stateless**, hiçbir durum bilgisini saklamaz. Her işlem bağımsızdır ve kendi bağlamında değerlendirili. Örneğin; RESTful API  genellikle stateless bir yapıya sahiptir, çünkü her istek kendi başına eline alınır.   

• **Stream**: Bir veri kaynağından elde edilen sıralı bir veri akışıdır. Streamler lazy'dir. Yani veriler üzerinde işlem yapmadan önce işlem dizisi oluşturulur ve bu dizi ihtiyaç duyulduğunda çağırılır. Böylece kaynakların kullanımının daha verimli olması sağlanır. Stream API; koleksiyonlar üzerinde filtrelemeler, dönüşümler ve işlemler yapmayı daha kolay ve okunabilir hale getirir. 
   
   - Aşağıdaki örnek kodda filter metodu streamdeki öğeleri belirli bir koşula göre filtreler. this::isValidSet, bir metod referansıdır. isValidSet metodunun her öğeye uygulanacağı anlamına gelir. isValidSet metodundan true döndüren öğeler streamde kalır. forEach(set->{...}) ise streamde kalan her bir set için belirtilen işlemi uygular.    
       
```java
sets.stream.filter(isValidSet).forEach(set->{...});
```
  -  **InStream** yalnızca int değerlerle işlem yapar ve tüm veriler üzerinde çeşitli işlemler gerçekleştirmememizi sağlar. Bu yapı ile toplama(aggregation), filtreleme, dönüştürme(mapping), diziler ile çalışma yapılabilir. **IntStream.range(int startInclusive, int endExclusive)** metodu belirli bir başalama ve bitiş değeri arasında bir IntStream oluşturur(startInclusive, streamdeki ilk(dahil) değer; endExclusive, streamdeki son(hariç) değer).
  -  **mapToObj(...)**, her bir int'i bir objeye dönüştüren bir obnksiyon uygular, her bir tam sayı içinm çıktının türünü değiştirmek için kullanılır. Burada Object türüne dönüştürür. Bu ifadede sets listesinden i ve i+1 indeksindeki ögeleri alarak Object dizilerini oluşturur. 
  -  **filter(pair-> ..)** ifadesi mapObj ile oluşturulan Object dizilerini temsilen kullanılır lambda ifadesi ile pair üzerinde belirtilen koşulu kontrol eder. Eğer koşul true ise pair streamde kalır; değilse streamden çıkarılır.
        
```java
 IntStream.range(0, sets.size()-1).mapToObj(i->new Object[]{sets.get(i),sets.get(i+1)}).filter(pair->"SEDA".equals(((ISet)pair[0]).getName()) && "GUNEY DURAN".equals(((ISet)pair[1]).getName()).forEach(pair-> createMethod((ISet)pair[0], (ISet)pair[1]));
```





