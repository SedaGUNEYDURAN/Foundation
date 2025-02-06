### Spring Nedir
• Spring Java için uygulama geliştirme frameworküdür. Java'nın daha kolay kullanıma sahip olmasını sağlar. Javayı cloud-ready yapar. Hız, basitlik, üretkenlik, daha kolay, daha safe gibi özellikleri Spring'i, Java'da en fazla kullanılan framework yaptı. (**cloud-ready yazılım**: bulut platformalarının özelliklerinden yararlanacak şekilde geliştirilmiş olduğunu ifade eder.)   
• Spring dediğimizde bir çatıyı kastediyoruz, bir çok componenti kapsar; Spring Cloud, Spring Roo, Spring HATEOAS ...   
• Java Enterprise Edition, .Net'e ; Java SE ise C#'a karşılık geliyor gibi düşünebiliriz.  
• **EJBs(Enterprise JavaBeans)**, J2EE'nin ana taşıyıcı componentidir. Temelde iki tipi vardır:; session beans(business logic için), entity beans(database'e mapping için). EJB yazdığımız zaman içinde run edeceğimiz containerın -EJB containerların yani application serverların- çok pahalı olduğu için daha lightweight, ucuz yapılarla değiştirilmeye evrildi ve EJB'siz geliştirme yapabilmek için Java EE' de spring geliştirildi. 2003'de ilk versiyonu çıktı.    
• EJB, sunucu tarafında çalıştırılan uygulamalar için tasarlanmıştır.EJB, yazılımları bağımsız, küçük bileşenler halinde geliştirmemizi sağlar. Bu bileşenler yani beansler belirli işlevleri yerine getirir. Beansler bir araya getirilerek daha büyük ve karmaşık uygulamar oluşturur.  
• **Session Beans:** Kullanıcı ile sunucu arasındaki oturumları yönetir. Kullanıcılar sistemle etkileşime girdiğinde bu beansler devreye girer. İki ana türü vardır; stateless session beans(kullanıcı oturumuna bağlı değildir, istekler bağımsız olarak işlenir), stateless session beans(kullanıcı oturumuna bağlı olarak çalışır)   
• **Entity Beans:** Veritabanındaki verileri temsil eder.   
• **Message-driven Beans:** Mesaj tabanlı sistemlerde çalışmak için tasarlanmıştır. Örneğin bir kuyruğa gelen mesajları işlemek için kullanılır.     
• Spring ile javayı kullanmanın üç farklı kategorik yöntemi vardır;
>Spring enhance Java(Spring javanın özelliklerini geliştirir)   
>Spring complements Java(Spring javanın yetenkelerini tanımlar ve ona ekleme yapar)    
>Spring competes Java   


### Dependency İnjection
• Dependency injection'ını aslında spring çıkarmamıştır. Java EE'de vardı, spring çıkarken Java EE'den alıp standart Java SE ortamında kullanılacak hale getirildi.Şuan Java'nın Dependency injection'ı Spring'in Dependency injection'ınından daha güçlüdür, daha type safedir.     
• Aşağıdaki A,B,C durumları var diyelim. Buradaki dependcy durumuna bakabilmek için düşünmemiz gereken şudur; A değiştiğinde C değişir mi? Evet değişir bu durumda dependency vardır. A değiştiğinde B değişir mi diye baktığımızda ise değişmesinin gerekmediğini görüyoruz yani bir dependency söz konusu değildir aralarında. Ancak A ve B arasında coupling  bulunmaktadır.   

![image](https://github.com/user-attachments/assets/a30ec4bd-840f-4b07-afea-d48cc3934442)  

• Dependency'nin üç temel tipi var;   
- **Abstraction**: Karmaşık sistemlerin basit temsilcilerini oluşturarak bileşenlerin daha kolay anlaşılmasını ve yönetilmesini sağlar. Örneğin; bir arayüz veya soyut sınıf bu tür bir bağımlılığa örnektir. Kullanıcılar sadece arayüz ile iletişime geçip nesnenin işlevlerine erişir, arka planda bu arayüzü gerçekleştiren farklı sınıflar olabilir.    
- **Realization**: Bir bileşenin belirli bir soyutlamayı somut bir biçimde nasıl uyguladığını tanımlar. Örneğin; bir arayüz tanımlandığında, o arayüzü gerçekleştiren sınıflar bu bağımlılık türünü oluşturur.   
- **Usage**: Bir bileşen diğer bileşenin işlevlerini veya özelliklerini çağırdığında veya kullanıldığında ortaya çıkar. Bir sınıfın başka bir sınıfın metodu çağırması durumu gibi.    

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

•  **Association:** Bir nesnenin başka bir nesneye sahip olma ilişkisidir.Yani bir sınıfta başka bir sınıfın referansının tutulması durumudur. **has-a ilişkisidir**. (objeyi oluştur, bir nesnenin objesi instance variable olarak ifade ediliyorsa -> has-a, bir classı extend ediyorsan -> is-a ) Association ilişkisi aynı zamanda iki nesne arasındaki bağlantının sayısını tanımlar. Association türleri;

- **Unidirectional**:Bir sınıf ya da nesne diğer sınıfla ilişki içerisindedir ancak ilişki yalnızca bir yönde gerçekleşmektedir. Diğer sınıf, ilişkili sınıf hakkında bilgi sahibi değildir.   
- **Bidirectional***:Her iki sınıf birbirleri hakkında bilgi sahibidir.   
- **Aggregation**: Diğer objeleri bir araya getirme, daha gevşek bir sahip olma ilişkisi. Yazar ve kitap classını örnek verebilirz.  
- **Composition**: Aggregation'ın daha güçlü halidir. Bir nesne başka bir nesneye sıkı bir şekilde bağlıdır ve diğeri olmadan var olamaz. Client yoksa service'de yoktur ilişkisidir.   

• **Wiring object:** Objeler arasındaki  dependencyleri giderecek bir şekilde objeleri birbirine geçmektir.  
• Spring sadece nesneleri oluşturmak ile kalmaz, objeler arasındaki wiring'i de sağlar. Dolayısıyla nesnelerin diğer nesnelere olan bağımlılığını injenctionlarla yönetir.   
• Component bitmiş bir yapıdır, son üründür. Sadece API'sini,interface'ini, kullanarak iç yapısını bilmeye gerek kalmadan componentten hizmet alırız.   
• Framework'ler bitmiş bir yapı, son ürün değildir. Semi-product, semi-completed application'dır. Tamamlanmaları lazım kullanılabilmek için. Tamamlanabilmek için de extend etmek gerekir. Extension dediğimiz  noktalara da **hook point** denir. Frameworkler farklı amaçlara sahip olabilir; Application development framework(Spring Security, JSF ...), Business domain framework(Acord)  
• **Inversion of Controller(IoC)**, bir application'ın sahip olduğu akış kontrolünü elinden bırakması, karşı tarafa vermesi temelde frameworkler tarafından uygulanan bir mekanizmadır. Framework bir application tarafından extend edildiği zaman, çalıştırılıp framework'ü ayağa kaldırdığımız zaman (framework'ü ayağa kaldırmazsak kontrol bizde, application'ın kendisinde) framework kontrolü kendisi ele alır ve kendi nesneleri ve bizim hook pointler ile sağladığımız nesneler üzerindeki metot çağrılarını ne zaman yapacağını, objeleri nasıl oluşturacağının, hangi objeler arasında dependencyler olduğunu ve onları nasıl yöneteceğini, hangi metotları çağıracağını, hangi exceptionları oluşturacağını ... bütün bunlara karar verir. Bu pattern'a, prensibe, yaklaşıma Inversion of Controller denir. **Kısaca framework akış kontrolünü ele aldığı zaman IoC olur, framework neyi ne zaman yapacağına karar verir. Application'ımız framework'ün componenti olur.** Bütün frameworkler IoC prensibi ile çalışır diyebiliriz.   
• IoC Container, objeleri  oluşturmak, lifecyclelarını yönetmek, dependencyleri yönetmek işini yapar. Spring'in IoC container'ı tarafından yönetilen objelere **bean** denir. Spring tarafından oluşturulmayan beanler, spring tarafından yönetilmezler. Bir beanden bir çok nesne oluşturabiliriz. Beanler birbirine referansta bulunabilirler.     
• JavaBean default constructor'a sahip olan, varsa bütün fieldları private olan, set() ve get() metotlarına sahip olan bean'i kastediyoruz. Ama buradaki beanlerin böyle bir zorunlulukları yoktur, default constructorları olmak zorunda değildir.    
• Spring IoC container'ına ulaşmakta kullanıdığımız temel interface; org.springframerwork.beans.BeanFactory   
• Şu bean'i bana getir dediğimizde eğer bulamazsa **NoSuchDefinitionException**, aynı isimde, birden fazla karşılık gelecek bean tanımlanmışsa **NoUniqueBeanDefinitionException** hatasını fırlatır. (Bean'in birden fazla ismi olabilir bunlara **alias** denir.) Aynı id'den birden fazla kullanıldığında **BeanDefinitionParsingException** exceptionı alırız,aynı bean ile birden fazla objeyi ifade edebiliriz.     

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

• En az bir yada daha fazla bean tanımına sahip yapıya **configuration metadata** denir. Configuration metadata'yı göstermenin springde üç tane yolu var; XML, Java annotations, Java code. XML ve Java annotationları aynı anda kullanabiliriz ancak **xml her zaman annotationları ezer**. XML tabanlı metada <beans/>  isimli bir kök elementin içinde beanlerden ibarettir. xml dosyasının nasıl oluşturulduğuna dair daha fazla bilgi için; https://www.springframework.org/schema/beans/spring-beans.xsd

• Bir projede birden fazla xml dosyası kullanılabilir.     
• Aşağıdaki xml dosyasının ifade ettiği; Guney classının bir instance'ı yaratılacak ve bu nesne id ile tanımlanan beanA ismi ile Spring container'ında yönetilecek.name anahtar kelimesi ile bean için alternatif referans isimleri sağlar ve bu isimler kullanılarak bean'e erişim kolaylaşır.  

```java
<beans>
    <bean id="beanA" name="beanAa, beanAAA" class="org.seda.domain.Guney"/>
</beans>
```

• name attribute olmasına rağmen alias bir attribute değildir,ayrı bir xml elementidir. Bir id'ye ait olan name'ler birbirlerinin aliaslarıdır. Yani alias var olan bir name'ine alternatif bir isim sağlamaktadır, bir bean'e birden fazla isim atamak için kullanılır. Aynı beans içerisinde idler, aliaslar, nameler unique olmalıdır. Aksi taktirde **BeanDefinitionParsingException** hatasını fırlatır. 

```java
<beans>
    <bean id="beanA" name="beanAa, beanAAA" class="org.seda.domain.Guney"/>
    <alias name="beanA" alias="a" />
    <alias name="beanA" alias="aa" />
    //beanA'ya a ve aa aliasları ile erişilebilir
</beans>
```
•    **class**: class attribute'ında fully qualified class name(classın tam adı) belirtilir. Spring'in bean örneğini oluşturabilmesi için hangi sınıfın kullanılacağını belirtir. Classın içerisinde abstract olmadığı sürece oluşturulacak olan class'ın tipini class attribute'ünde vermemiz gerekir. Bir classın abstract olarak tanımlanması, o sınıfın doğrudan örneğinin oluşturulamayacağı anlamına gelir. Eğer bir bean tanımında class attribute'u bir abstract sınıfı belirtirse Spring bu classın bir örneğini oluşturamaz.  XML yapılandırma dosyasında abstract class'a değil concrete classa referası verilir.

•    **parent**: Inheritance ilişkisini parent attribute'u ile gösterebiliriz.
•    Bean'in üzerinde default constructor çağrısı yapmasını önleyip static factory method ile sağladığımız instance'ı çağırabiliriz.(Constructorlar çok fazla parametre alıyorsa çok meşakatli olduğu için bu yöntem kullanılabilir). Abstract factory pattern'ını kullanacağım dersek; abstract factory'nin üzerindeki metotlar static değildir, instance metotlarıdır, factory objeleri oluşturulmalıdır.

```java
<bean id="beanStaticFactory" class="org.seda.domain.Guney" factory-method="create" />
  <property name="beanB" ref="beanB">
</bean> 
<bean id="beanFactory" factory-bean="beanAFactory" factory-method="create">
  <property name="beanB" ref="beanB"/>
</bean>

```

**factory-method**, Guney sınıfında create adında bir statik metot vardır ve bu metot çağırılarak bean oluşturulacaktır. 
**factory-bean=beanAFactory**,  beanAFactory bean'inden bir nesne oluşturmak için kullanılacak olan fabrikanın kimliğidir. beanAFactory adında bir bean var ve bu bean beanFactory idli beani oluşturulacaktır. 
**factory-method="create"**, beanAFactory beaninden bir nesne oluşturmak için create metodu kullanılacaktır. beanAFactory create metodunu çağıracak beanFactory bean'i oluşturulacak. 


•   Dependency injection dediğimiz şey bean'in bütün collaborator'ını bean'e inject edilmesidir. 2 çeşit injection; setter, constructor. **İki injection çeşidi de depended olunan şey bir bean ise ref attribute'unu kullanırlar, bean değilse(bir primitive değer ya da string geçeceksek) value attribute'unu kullanırlar.** Contructor injection için <constructor-arg/>, setter injection için <property/> kullanılır. ref kullanarak bir başka bean'e referans geçeceksek id, name ya da aliaslardan biri ref'e değer olarak geçilmesi lazım. Injectionon türüne göre <constructor-arg/> veya <property/> argümanında ref kullanılır. 

•   **< constructor-arg/>** , öncelikle uygun bir constructor olmalıdır. ref argümanı id, name, alias'ı ile geçilir. Resolve etmesi argümanın tipi ile olur. Type, index, name ile birden fazla aynı tipte objeyi inject etmeyi de sağlayabiliriz. **Beanlerin immutable olması gereken durumlarda constructor injection tercih edilmelidir. Zorunlu olan fieldlar için(nullpointerexception fırlatması söz konusu olan dependencyler varsa onların inject edildiğinden emin olmamız gerekeir.) kullanılır.**

```java
<bean id="render1" class="org.seda.domain.Guney"
    <constructor-arg name="greetingProvider" ref="helloProvider"/>
</bean> 

or

<bean id="render1" class="org.seda.domain.Guney"
    <constructor-arg name="greetingProvider" ref bean="hello_provider"/> //name'ini geçiyor
</bean> 

```
•   **< property/>**, önecelikle uygun bir setter'ın ıolması gerekir. ref argümanı id, name veya alias'ı ile geçilir. 

```java
<bean id="selamProvider" class="org.seda.domain.Guney"
    <property name="greeting" value="Selammmm"/> 
</bean> 

```

•  **Inner bean**: id veya name olmadan <bean/> tagi ile kullanılır. 

```java
<bean id="renderer" class="org.seda.domain.Guney"
    <constructor-arg name="greetingProvider">
      <bean class="org.seda.domain.Duran" <property name="greeting" value="Hi Everybody" /> //inner Bean
  
      </bean>
</bean> 
```
### Autowire
• Spring IOC konteynırının dependencylerini bulup otomatik olarak yerine getirmesini sağlar. (Depended beanler hala xml içerisinde tanımlanmalıdır. )< property/> ve <constructor-arg> taglarını gerek kalmadığı için daha temiz bir XML dosyası olmasını sağlar. autowire değerinin defaultu değeri no'dur. Üç değer ile bulur;constructor, byName(setter'ına name ile inject eder), byType(argumanın setter metodunun argumanına uyan setter metoduna inject eder). Autowire byName olarak ayarlandıysa Spring container'ı "renderer" beaninin içinde ihtiyaç duyulan bağımlılıkları bean'in ismine göre karşılar.

```java
<bean id="renderer" autowire="byName" class="org.seda.domain.Guney">
</bean>
```

renderer adında bir bean oluşturacağını ve bunun org.seda.domain.Guney sınıfından bir nesne olacağını söyler. Bu class şu şekilde tanımlanmış olsun;

```java
public class Guney {
    private GreetingProvider greetingProvider;

    // constructor and other methods...
}
```
Spring, Guney classının kullanımda olan bir örneğini(beanini) oluşturmak için classı inceler. Sınıfın tanımına bakar ve içinde tanımlanmış olan alanları (private GreetingProvider greetingProvider) kontrol eder. Bu alana bağlı olan bağımlılık greetingProvider nesnesidir. Spring uygulama konfigürasyonundaki ve containerda tanımlanan tüm beanlerin id'lerini kontrol eder. Eğer greetingProvider isimli bir bean mevcutsa bu bean ile alan arasındaki eşleşmeyi sağlar. Yani  **private GreetingProvider greetingProvider alanına otomatik olarak greetingProvider beani enjekte eder.**
```java
<bean id="greetingProvider" class="org.seda.services.HelloProvider" />
<bean id="renderer" autowire="byName" class="org.seda.domain.Guney" />
```
Eğer burada böyle bir bean yoksa Spring byName yöntemi nedeniyle bu alanı null olarak bırakır. 


or
```java
<bean id="renderer" autowire="byType" class="org.seda.domain.Guney">
</bean>
or
<bean id="renderer" autowire="constructor" class="org.seda.domain.Guney">
</bean>
```
 • Örnek kod;
Spring'in ApplicationContext objesi oluşturulur ve belirtilen XML konfigürasyon dosyası yüklenir. XML dosyası, içinde olan tüm beanleri yükler ve başlatır. 

```java
package org.seda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.seda.domain.Guney;

public class Main {
    public static void main(String[] args) {
        // Spring konteynerini oluştur
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Guney bean'ini al
        Guney renderer = (Guney) context.getBean("renderer");

        // greet methodunu çağır
        renderer.greet();
    }
}
```

<bean id="greetingProvider" class="org.seda.services.GreetingProvider" /> burada greetingProvider bean'i tanımlanıyor yani GreetingProvider classından greetingProvider nesnesi oluşturuluyor. GreetingProvider'da bir contructor parametresi olmadığı için default constructor ile bir obje yaratılır.    
  <bean id="renderer" autowire="byName" class="org.seda.domain.Guney" /> burada renderer bean'i tanımlanıyor yani Guney classından renderer objesi oluşturuluyor. 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- GreetingProvider Bean -->
    <bean id="greetingProvider" class="org.seda.services.GreetingProvider" />

    <!-- Guney (Renderer) Bean -->
    <bean id="renderer" autowire="byName" class="org.seda.domain.Guney" />

</beans>
```

<bean id="renderer" autowire="byName" class="org.seda.domain.Guney" /> ifadesindeki byName Guney classındaki   private GreetingProvider greetingProvider; ifadesini gördüğünde bu alanı inject edeceğini anlar. greetingProvider adını kullanarak, XML konfigürasyon dosyasında bu isme sahip başka bir bean olup olmadığını kontrol eder. <bean id="greetingProvider" class="org.seda.services.GreetingProvider" /> da greetingProvider bean'ini bulur. private GreetingProvider greetingProvider;'daki greetingProvider nesnesine xml'deki greetingProvider bean'i inject edilir. byName olduğu için bu enjeksiyon setter inject ile yapılacaktır. Bu inject için setGreetingProvider() metodunu kullanır, böylece greetingProvider value'sunu GreetingProvider objesine atanır. 

```java
package org.seda.domain;

import org.seda.services.GreetingProvider;

public class Guney {
    private GreetingProvider greetingProvider;

    // Setter Injection
    public void setGreetingProvider(GreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    public void greet() {
        System.out.println(greetingProvider.getGreeting());
    }
}
```

```java
package org.seda.services;

public class GreetingProvider {
    public String getGreeting() {
        return "Hello, Spring!";
    }
}
```

Main classındaki aşağıdaki kod parçası renderer beanin bir instance'ını almak için kullanılır. Guney classının ilgili objesini döndür. rendere artık GreetingProvider nesnesine erişme yeteneğine sahiptir. 
```java
Guney renderer = (Guney) context.getBean("renderer");
```

greet() metodu çağırıldığında Guney classındaki greet() metodu çağırılır ve greetingProvider.getGreeting() ekrana bastırılır(Hello, Spring!). 
```java
 renderer.greet();
```


--> Constructor ile injection yapılsaydı; 
```java
package org.seda.domain;

import org.seda.services.GreetingProvider;

public class Guney {
    private GreetingProvider greetingProvider;

    // Constructor Injection
    public Guney(GreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    public void greet() {
        System.out.println(greetingProvider.getGreeting());
    }
}
```

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- GreetingProvider Bean -->
    <bean id="greetingProvider" class="org.seda.services.GreetingProvider" />

    <!-- Guney Bean -->
    <bean id="renderer" class="org.seda.domain.Guney" autowire="constructor" />
</beans>
```

 • Injectionlarda bean yerine istersek null geçebiliriz. 

```java
package Greet;
public class Guney {
	private GreetingProvider greetingProvider;

  public Guney(GreetingProvider greetingProvider) {
	this.greetingProvider = greetingProvider;
	}
  public void render() {
    	if(greetingProvider==null) {
    		throw new RuntimeException("Bean'e null injection yapıldı: "+Guney.class.getName());
    	}
  }
  public void greet() {
      System.out.println(greetingProvider.getGreeting());
  }
}

```
```java
package Greet;
public class GreetingProvider {
	 public String getGreeting() {
	        return "Hello, Spring!";
	    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- GreetingProvider Bean -->
    <bean id="greetingProvider" class="Greet.GreetingProvider" />

    <!-- Guney (Renderer) Bean -->
    <!-- <bean id="renderer" autowire="constructor" class="Greet.Guney" /> -->
    <bean id="renderer" class="Greet.Guney" >
    <constructor-arg name="greetingProvider">
    	<null/>
    	</constructor-arg>
    </bean>

</beans>
```
```java
package Greet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	 public static void main(String[] args) {
	        // Spring konteynerini oluştur
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        // Guney bean'ini al
	       Guney renderer = (Guney) context.getBean("renderer");
	        renderer.render();
	    }
}
```

•  Set metoduyla resolve edebilmesi için property injectionda value inject edebilmek için name geçmek zorundayız. Constructor'a value inject ederken bir parametreyi eksik inject edersek ya da property injectionda olmayan bir property'i inject etmeye çalışırsak hata fırlatır; **org.springframework.beans.factory.UnsatisfiedDependencyException** 


```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = (MyService) context.getBean("myService");
        myService.displayInfo();  // Bilgileri ekrana yazdırır.
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myService" class="com.example.MyService">
        <constructor-arg value="Hello, Constructor Injection!" />
        <constructor-arg value="10" /> <!-- Integer type -->
        <constructor-arg value="99.99" /> <!-- Double type -->
    </bean>

</beans>
```
```java
package com.example;

public class MyService {
    private String message;
    private int count;
    private double price;

    // Constructor Injection
    public MyService(String message, int count, double price) {
        this.message = message;
        this.count = count;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Message: " + message);
        System.out.println("Count: " + count);
        System.out.println("Price: " + price);
    }
}
```
•  Hem constructor hem de Property injection ile value injection yaparsak;

```java
package com.example;

public class MyService {
    private String message;
    private int count;
    private double price;

    // Constructor
    public MyService(String message) {
        this.message = message;
    }

    // Setter metodları
    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Message: " + message);
        System.out.println("Count: " + count);
        System.out.println("Price: " + price);
    }
}
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myService" class="com.example.MyService">
        <constructor-arg value="Hello, Constructor Injection!" />
        
        <!-- Property injection -->
        <property name="count" value="10" />
        <property name="price" value="99.99" />
    </bean>

</beans>

```
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = (MyService) context.getBean("myService");
        myService.displayInfo();  // Bilgileri ekrana yazdırır.
    }
}
```

•  Array , List, Set ister values ister bean referansları geçeriz ama Map key value pairları aldığı için enty elementini mapin içinde kullanırız.

```java
package com.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyService {
    private String[] arrayValues;
    private List<String> listValues;
    private Set<String> setValues;
    private Map<String, Integer> mapValues;

    // Getter ve Setter metodları
    public void setArrayValues(String[] arrayValues) {
        this.arrayValues = arrayValues;
    }

    public void setListValues(List<String> listValues) {
        this.listValues = listValues;
    }

    public void setSetValues(Set<String> setValues) {
        this.setValues = setValues;
    }

    public void setMapValues(Map<String, Integer> mapValues) {
        this.mapValues = mapValues;
    }

    public void displayInfo() {
        System.out.println("Array Values: ");
        for (String value : arrayValues) {
            System.out.println(value);
        }

        System.out.println("List Values: " + listValues);

        System.out.println("Set Values: " + setValues);

        System.out.println("Map Values: ");
        for (Map.Entry<String, Integer> entry : mapValues.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myService" class="com.example.MyService">
        <!-- Array Injection -->
        <property name="arrayValues">
            <list>
                <value>Value 1</value>
                <value>Value 2</value>
                <value>Value 3</value>
            </list>
        </property>

        <!-- List Injection -->
        <property name="listValues">
            <list>
                <value>List Item 1</value>
                <value>List Item 2</value>
                <value>List Item 3</value>
            </list>
        </property>

        <!-- Set Injection -->
        <property name="setValues">
            <set>
                <value>Set Item 1</value>
                <value>Set Item 2</value>
                <value>Set Item 3</value>
            </set>
        </property>

        <!-- Map Injection -->
        <property name="mapValues">
            <map>
                <entry>
                    <key>Key 1</key>
                    <value>1</value>
                </entry>
                <entry key="Key 2" value-ref="2" />
                <entry>
                    <key>Key 3</key>
                    <value>3</value>
                </entry>
            </map>
        </property>
    </bean>

</beans>
```

```java
```


