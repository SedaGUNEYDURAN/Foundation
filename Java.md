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
