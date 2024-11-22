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

• Wiring object:Objeler arasındaki  dependencyleri giderecek bir şekilde objeleri birbirine geçmektir.  
• Spring sadece nesneleri oluşturmak ile kalmaz, objeler arasındaki wiring'i de sağlar. Dolayısıyla nesnelerin diğer nesnelere olan bağımlılığını injenctionlarla yönetir.   
• Component bitmiş bir yapıdır, son üründür. Sadece API'sini,interface'ini, kullanarak iç yapısını bilmeye gerek kalmadan componentten hizmet alırız.   
• Framework'ler bitmiş bir yapı, son ürün değildir. Semi-product, semi-completed application'dır. Tamamlanmaları lazım kullanılabilmek için. Tamamlanabilmek için de extend etmek gerekir. Extension dediğimiz  noktalara da **hook point** denir. Frameworkler farklı amaçlara sahip olabilir; Application development framework(Spring Security, JSF ...), Business domain framework(Acord)  
• **Inversion of Controller(IoC)**, bir application'ın sahip olduğu akış kontrolünü elinden bırakması, karşı tarafa vermesi temelde frameworkler tarafından uygulanan bir mekanizmadır. Framework bir application tarafından extend edildiği zaman, çalıştırılıp framework'ü ayağa kaldırdığımız zaman (frameworjk'ü ayağa kaldırmazsak kontrol bizde, application'ın kendisinde) framework kontrolü kendisi ele alır ve kendi nesneleri ve bizim hook pointler ile sağladığımız nesneler üzerindeki metot çağrılarını ne zaman yapacağını, objeleri nasıl oluşturacağının, hangi objeler arasında dependencyler olduğunu ve onları nasıl yöneteceğini, hangi metotları çağıracağını, hangi exceptionları oluşturacağını ... bütün bunlara karar verir. Bu pattern'a, prensibe, yaklaşıma Inversion of Controller denir. Kısaca framework akış kontrolünü ele aldığı zaman IoC olur, framework neyi ne zaman yapacağına karar verir. Application'ımız framework'ün componenti olur. Bütün frameworkler IoC prensibi ile çalışır diyebiliriz.   
• IoC Container, objeleri  olupturmak, lifecyclelarını yönetmek, dependencyleri yönetmek işini yapar. Spring'in IoC container'ı tarafından yönetilen objelere **bean** denir. Spring tarafından oluşturulmayan beanler, spring tarafından yönetilmezler. Bir beanden bir çok nesne oluşturabiliriz. Beanler birbirine referansta bulunabilirler. 
• JavaBean default constructor'a sahip olan, varsa bütün fieldları private olan, set() ve get() metotlarına sahip olan bean'i kastediyoruz. Ama buradaki beanlerin böyle bir zorunlulukları yoktur, default constructorları olmak zorunda değildir.    
• Sprinf IoC container'ına ulaşmakta kullanıdığımız temel interface; org.springframerwork.beans.BeanFactory   
• Şu bean'i bana getir dediğimizde eğer bulamazsa **NoSuchDefinitionException**, aynı isimde, birden fazla karşılık gelecek bean tanımlanmışsa **NoUniqueBeanDefinitionException** hatasını fırlatır. (Bean'in birden fazla ismi olabilir bunlara **alias** denir.) Aynı id'den birden fazla kullanıldığında BeanDefinitionParsingException exceptionı alırız,aynı bean ile birden fazla objeyi ifade edbiliriz.     

```java
<bean id="beanC" alias="a"/>
<bean id="beanC" alias="aa"/> //BeanDefinitionParsingException
<bean id="beanD" alias="aa"/>
```

• org.springframework.beans.factory.ListableBeanFactory, enumeration yetkinliği verir.ListableBeanFactory interface'i içinde bulunan beanleri listeleme yeteneğine sahiptir. Belirli bir bean adı veya türüne göre sorgulamayı sağlar.     
• org.springframework.context.ApplicationContext, interface'i farklı türden resourceları yükleme yeteneğine sahiptir.  
• getBeanFactory() metodu ile bean xml dosyasını yükleriz.   

```java
private static BeanFactory getBeanFactory(){
  BeanFactory beanFactory=new ClassPathXmlApplicationContext("org/java/spring...../beanFactory/res  ources/beans.xml");
  return beanFactory;
}
```

• beanFactory'de isimle aldığımızda obje döneceği için cast etmeliyiz ,aynı ismi birden fazla bean için kullanamayacağımız yani unique olacağı için,  unique bir bean'i alıyoruz ama getBean ile aldığımızda class geçersek 

```java
beanA=(BeanA) beanFactory.getBean("BEAN_A"); //unique
beanA=beanFactory.getBean(BeanA.class);
boolean b=beanFactory.containsBean("a"); // a ismi ile oluşan bir bean'i container'ında tutuyor musun?
String[] aliases=beanFactory.getAliases("beanA"); //beanA'nın aliaslarını getirir.
String[] beanNamesForBeans=beanFactory.getBeanNamesForType(BeanA.class);//BeanA classından kaç tane bean var?
```  
 
• ApplicationContext, containerı beanFactory'den daha yetkin bir şekilde temsil eden interface'in ismidir. Eğer dosya setConfigLocation() ile yüklenirse refresh edilmesi gereklidir. 
```java
ApplicationContext context=new ClassPathXmlApplicationContext("org/java/spring/beans.xml");
ApplicationContext context=new FileSystemXMLApplicationContext("file:/Users/seda/beans.xml");

FileSystemXMLApplicationContext context=new FileSystemXMLApplicationContext();
context.setConfigLocation("file:/Users/seda/beans.xml");
context.refresh();
```

• En az bir yada daha fazla bean tanımına sahip yapıya **configuration metadata** denir. Configuration metadata'yı göstermenin springde üç tane yolu var; XML, Java annotations, Java code. XML ve Java annotationları aynı anda kullanabiliriz ancak xml her zaman annotationları ezer. XML tabanlı metada <beans/>  isimli bir kök elementin içinde beanlerden ibarettir. xml dosyasının nasıl oluşturulduğuna dair daha fazla bilgi için; https://www.springframework.org/schema/beans/spring-beans.xsd

• Bir projede birden fazla xml dosyası kullanılabilir. 
• Aşağıdaki xml dosyasının ifade ettiği; Guney classının bir instance'ı yaratılacak ve bu nesne id ile tanımlanan beanA ismi ile Spring container'ında yönetilecek.name anahtar kelimesi ile bean için alternatif referans isimleri sağlar ve bu isimler kullanılarak bean'e erişim kolaylaşır.  

```java
<beans>
    <bean id="beanA" name="beanAa, beanAAA" class="org.seda.domain.Guney"/>
</beans>
```

• name attribute olmasına rağmen alias bir attribute değildir. 
