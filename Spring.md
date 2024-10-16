### Spring Nedir
• Spring Java için uygulama geliştirme frameworküdür. Java'nın daha kolay kullanıma sahip olmasını sağlar. Javayı cloud-ready yapar. Hız, basitlik, üretkenlik, daha kolay, daha safe gibi özellikleri Spring'i, Java'da en fazla kullanılan framework yaptı.    
• Spring dediğimizde bir çatıyı kastediyoruz, bir çok componenti kapsar; Spring Cloud, Spring Roo, Spring HATEOAS ...   
• Java Enterprise Edition, .Net'e ; Java SE ise C#'a karşılık geliyor gibi düşünebiliriz.  
• EJBs(Enterprise JavaBeans), J2EE'nin ana taşıyıcı componentidir. Temelde iki tipi vardır:; session beans(business logic için), entity beans(database'e mapping için). EJB yazdığımız zaman içinde run edeceğimiz containerın -EJB containerların yani application serverların- çok pahalı olduğu için daha lightweight, ucuz yapılarla değiştirilmeye evrildi ve EJB'siz geliştirme yapabilmek için Java EE' de spring geliştirildi. 2003'de ilk versiyonu çıktı. 
• Spring ile javayı kullanmanın üç farklı kategorik yöntemi vardır;
>Spring enhance Java
>Spring complements Java
>Spring competes Java


### Dependency İnjection
• Dependency injection'ını aslında spring çıkarmamıştır. Java EE'de vardı, spring çıkarken Java EE'den alıp standart Java SE ortamında kullanılacak hale getirildi.Şuan Java'nın Dependency injection'ı Spring'kinden daha güçlüdür, daha type safedir. 
• Aşağıdaki A,B,C durumları var diyelim. Buradaki dependcy durumuna bakabilmek için düşünmemiz gereken şudur; A değiştiğinde C değişir mi? Evet değişir bu durumda dependency vardır. Adeğiştiğinde B değişir mi diye baktığımızda ise değişmesinin gerekmediğini görüyoruz yani bir dependency söz kojnusu değildir aralarıda. Ancak A ve B arasında coupling  bulunmaktadır.   

![image](https://github.com/user-attachments/assets/a30ec4bd-840f-4b07-afea-d48cc3934442)  

• Dependency'nin üç temel tipi var;   
- **Abstraction**: Karmaşık sistemlerin basit temsilcilerini oluşturarak bileşenlerin daha kolay anlaşılmasını ve yönetilmesini sağlar. Örneğin; bir arayüz veya soyut sınıf bu tür bir bağımlılığa örnektir. Kullanıcılar sadece arayüz ile iletişime geçip nesnenin işvevlerine erişir, arka planda bu arayüzü gerçekletiren farklı sınıflar olabilir.    
- **Realization**: Bir bileşenin belirli bir soyutlamayı somut bir biçimde nasıl uyguladığını tanımlar. Örneğin; bir arayüz tanımlandığında, o arayüzü gerçekleştiren sınıflar bu baüğımlılık türünü oluşturur.   
- **Usage**: Bir bileşen diğer bileşenin işlevlerini veya özelliklerini çağırdığında veya kullanıldığında ortaya çıkar Bir sınıfın başka bir sınıfın metodu çağırması durumu gibi.    

```java
public class A extends P implements I{ //P-> abstraction, I-> realization  
  private B b;//usage ve association
  public void f(C c){//usage
    ...
  }
  public D g(){
    return new D(); //usage
  }
}
```

•  Association: Bir nesnenin başka bir nesneye sahip olma ilişkisidir.Yani bir sınıfta başka bir sınıfın referansının tutulması durumudur. has-a ilişkisidir. (objeyi oluştur, bir nesnenin objesi instance variable olarak ifade ediliyorsa -> has-a, bir classı extend ediyorsan -> is-a ) Association ilişkisi aynı zamanda iki nesne arasındaki bağlantının sayısını tanımlar. Association türleri;

- **Unidirectional**:Bir sınıf ya da nenes diğer sınıfla ilişki içerisindedir ancak ilişki yalnızca bir yönde gerçekleşmektedir. Diğer sınıf, ilişkili sınıf hakkında bilgi sahibi değildir.   
- **Bidirectional***:Her iki sınıf birbirleri hakkında bilgi sahibidir.   
- **Aggregation**: Diğer objeleri bir araya getirme, daha gevşek bir sahip olma ilişkisi. Yazar ve kitap classını örnek verebilirz.  
- **Composition**: Aggregation'ın daha güçlü halidir. Bir nesne başka bir nesneye sıkı bir şekilde bağlıdır ve diğeri olmadan var olamaz. Client yoksa service'de yoktur ilişkisidir.   

• 
