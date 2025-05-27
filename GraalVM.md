• **JDK(Java Development Kit):** Java programlama diliyle yazılım geliştirmek için kullanılan bir araçtır. Java uygulamalarını yazmak, derlemek ve çalıştırmak için gerekli bileşenleri içerir;
- **Java Derleyici(javac):** Java kodlarını derleyerek byte kodlara çevirir.  İki gruba ayrılır;

> JIT(Just In Time) Derleme: Runtime da kodu derleyerek daha hızlı çalışmasını sağlayan VE JVM üzerinde çalışan bir mekanizmadır. Kodlar, byte kod çevirilir ve yorumlanarak çalıştılır ama sık kullanılan kod parçalarını makine koduna çevirerek CPU üzerinden doğrudan çalışmasını sağlar.Statik bir derleyici gibi kodu bir kere derleyip bırakmaz. Çalışma zamanı boyunca yapılan değişiklikleri de gözönünde bulundurur. 
> AOT(Ahead of Time): Runtime'dan önce uygulama makine koduna çevrilir. Uygulama çalıştırıldığında ek bir derleme süreci olmaz, optimize edilmiş makine kodu çalışır. Başlangıç hızını arttırır, hafıza kullanımını azaltır. 
- **JRE(Java Runtime Environment):** Java uygulamalarını çalıştırmak için gerekli olan kütüphaneleri ve sanal makineyi içerir.
- **JVM(Java Virtual Machine):** Java kodlarını çalıştıran sanal makinedir.
- **jdb(Hata Ayıklama Aracı):** Java programlarındaki hataları bulmak ve düzeltmek için kullanılır.
- **Java API Kütüphanesi:** Java'nın temel fonksiyonlarını sağlayan hazır bileşenlerdir.  

# GraalVM
• Hem java hem de başka dillerde yazılmış kodları hızlı ve verimli çalıştırmak için geliştirilmiş derleme platformudur. Yüksek performanslı JDK'dır. Farklı programlama dillerinde yazılmış kodları tek bir ortamda çalıştırabilir. Düşün ki bir python bir de java ile yazılmış programın var, birlikte çalıştırman gerekiyor ama sorun şu ki java JVM ile ile python interpreter ile çalışır. Bu noktada graalVM devreye giriyor. Farklı dilde yazılmış kodları tek bir çatı altında toplayarak çalıştırır.   
• Graal derleyicisini içerir. Graal derleyicisi kodu hızlı ve verimli çalışacak şekilde dönüştürür, daha az kaynak tüketmesini sağlar.     
• **Native Image**: Normalde Java programları JVM üzerinde çalışır; JVM açılır, sınıflar yüklenir...  Bu nedenle de program başlatıldığında geç açılır. GraalVM, Java programını doğrudan çalışan hızlı, bellek kullanımı düşük makineye özgü(native) binary bir dosyaya dönüştürebilir. Bu dosya JVM'e ihtiyaç duymaz. Açılış süresi çok kısadır. Bellek tüketimi çok düşüktür. Micro servisler için de çok avantajlıdır.  "java -jar" yerine ./program gibi çalıştırabiliriz.  Native image oluşturabilmek için gereksinimler;

- Java 17 veya 21 sürümünü destekleyen bir JDK kurulu olmalıdır.(GraalVM tabanlı olmalıdır)
- GraalVM kurulmalıdır -> https://www.graalvm.org
- Ortam değişkenleri ayarlanmalıdır
> export GRAALVM_HOME=/path/to/graalvm
> export PATH=$GRAALVM_HOME/bin:$PATH
- Native image, GraalVM içinde gelmez, kurulmalıdır;
> gu install native-image
- Maven/Gradle build işlemleri için
- Hava projesi oluşturulur;
> mvn archetype:generate -DgroupId=com.example -DartifactId=native-demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
- Basit bir class yazıyoruz;

```java
public class App{
    public static void main(String[] args){
      System.out.println("Native Image");  
    }
}
```
- Maven plugin eklenir. (pom.xml'e)

```xml
  <profiles>
    <profile>
        <id>native</id>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.graalvm.buildtools</groupId>
                    <artifactId>native-maven-plugin</artifactId>
                    <version>0.10.5</version>
                    <extensions>true</extensions>
                    <executions>
                        <execution>
                            <id>build-native</id>
                            <goals>
                                <goal>compile-no-fork</goal>
                            </goals>
                            <phase>package</phase>
                        </execution>
                    </executions>
                    <configuration>
                        <mainClass>com.java.MyApp</mainClass>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </profile>
</profiles>
```
- Image oluşturulur, ilk derleme uzun sürebilir Başırı olursa eğer target/native-demo adında bir çalıştırılabilir dosya oluşturur;
  > mvn package
- Dosya çalıştırılır;
  > ./target/native-demo 
- native image ile uyumsuz olabilecek kütüphanelere dikkat edilmelidir(reflection yoğun kullanımı, dynamic proxy,JNI, classpath scanning ...). Eğeruyumsuz durumlar varsa bunlar için ek olarak configürasyon dosyaları gerekir.
> java -agentlib:native-image-agent=config-output-dir=./META-INF/native-image -jar yourapp.jar  
**agentlib:native-image-agent=**; (ajan)Runtimeda reflection, proxylerin ve diğer özel durumların kullanılmasını takip eder.   
**config-output-dir=./META-INF/native-image**; Elde edilen configürasyon dosyalarını bu klasöre yazar. Configürasyon dosyaları ./META-INF/native-image   
**-jar yourapp.jar**; Uyugulamyı başlatır ve arkadan ajan gerekli bilgileri toplar.   
- Native image oluşturmak fazla CPU ve RAM tüketir, en az 8 GB RAM önerilir.


• **Helidon**, açık kaynaklı Java tabanlı bulut uygulamaları oluşturmayı kolaylaştıran frameworktür. Hızlı başlatma süresi, düşük bellek tüketimi, GraalVM desteği gibi avantajları vardır.   
• **Micronaut**, Spring ve Grails gii frameworklere benzer ancak onlardan daha hızlı başlatma süresi ve bellek kullanımına sahiptir. GraalVM desteği sunar. AWS Lambda, Google Cloud Functions, Microsoft Azure gibi cloud hizmetleriyle entegredir. Dependency Injection runtimeda değil compile time da, bu da performansı arttırır.   
 
## Quarkus
    • Cloud tabanlı, container dostu Java uygulamaları geliştirmek için bir frameworktür.Özellikler mikroservisler ve serverless mimariler için uygundur.  
    •**Quarkus**, GraalVM'in native image derleme işleminden faydalanarak Java'nın AOT derleme yönetemi ile çalıştırabilir.Bu sayede uygulamalar daha hızlı başlar, daha düşük bellek tüketir ve performans artar.   
• 



### Performansı Etkileyen Başka Faktörler
•  **Dinamik Linkleme**: Programın derleme aşamasında tüm kütüphaneleri dahil etmek yerine çalıştırılması sırasında ihtiyaç duyulan kütüphanelerin yüklenmesini sağlar. Bu da bellek kullanımını optimize eder. Ayrıca kütüphaneler bağımsız olarak güncellenebilir böylece programın yeniden derlenmesine gerek kalmaz. Kütüphaneler hariç tutulduğu için programın exe dosyasının boyutu küçük olur. Ancak dezavantajları da vardır; run time da kütüphanelerin yüklenmesi fazla zaman alabilir, programın çalışması için gerekli kütüphanelerin sistemde bulunması gerekir. Bellek yönetimi ve güncellenebilirlikden dolayı tercih edilir.     
•  **Statik Linkleme**: Programın derlenmesi aşamasında bütün kütüphaneler dahil edilir. Dosya boyutu dinamik belleğe göre daha büyüktür. Güncellenebilimesi için uygulamanın tekrar derlenmesi gerekir. Runtimeda uygulama daha hızlı çalışır. Bağımsız ve taşınabilir uygulamalar için tercih edilir. 
