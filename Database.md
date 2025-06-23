# SQL SORGULARI

•  Kullanıcıları listelemek için,
```SQL
	SELECT user,host FROM mysql.user;
```
•  Yeni kullanıcı oluşturmak için
```SQL
	CREATE USER 'kullanıcıadı'@'localhost' IDENTIFIED BY 'şifre';
```
•  Root olarak giriş yapmak için
```SQL
	mysql -u root -p 
```
•  Yeni bir kullanıcı yaratmak için(root olmalı ya da kullanıcının yetkileri olmalı)
```SQL
	CREATE USER "sedagd"@"localhost" IDENTIFIED BY "şifre";
```
•  Kullanıcıya veritabanına erişim izni vermek için
```SQL
	GRANT ALL PRIVILEGES ON *.* TO "sedagd"@"localhost";
```
•  Yapılan değişikliklerin uygulanması için
```SQL
	FLUSH PRIVILEGES;
```
•  Mysql kullanan kullanıcıları görmek için
```SQL
	SELECT user, host FROM mysql.user;
```
•  Mysql'de istediğimiz kullanıcıya geçmek için
```SQL
	mysql -u kullanıcıadı -p
```
•  Sadece belirli bir yerden bağlanan kullanıcıya geçmek için
```SQL
	mysql -u yeni_kullanıcı -p -h "localhost"
```
•  Database oluşturmak için
```SQL
	CREATE DATABASE database_name; 
```
11)Databaseleri görmek için
```SQL
	SHOW DATABASES;
```
•  Varolan bir database'i silmek için
```SQL
	DROP DATABASE database_name;
```
•  Üzerinde işlem yapacağın database'i seçmek için
```SQL
	USE database_name;
```
•  Bir table yaratmak için
```SQL
	CREATE TABLE students (
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	name VARCHAR(255) NOT NULL,
  	age INT NOT NULL
	);
```
•  Tabloları silmek için
```SQL
	SHOW TABLES FROM database_name;
```
•  Varolan bir table'ı silmek için(önce use ilen database seçilmeli)
```SQL
	DROP TABLE table_name;
```
•   	UNIQUE: Sütunda benzersiz değerler olmalıdır.   
	NOT NULL: Sütun boş bırakılamaz.   
	PRIMARY KEY: Sütun tablonun birincil anahtarıdır.   
	FOREIGN KEY: Sütun başka bir tablodaki bir sütuna başvurur.   
	CHECK: Sütuntaki değerlerin belirli bir koşulu karşılamasını sağlar.   
	DEFAULT: Sütun boş bırakılırsa varsayılan bir değer atar.   

•  Tablodaki sütunları görmek için
```SQL
	DESCRIBE table_name;
```
•  Tabloya sütun eklemek için(gender kolonu ekleyelim)
```SQL
	ALTER TABLE table_name ADD COLUMN gender VARCHAR(255);
```
•  Eklediğimiz gender sütununun değerine kısıtlama getirmek için (m ve f şeklinde)
```SQL
	ALTER TABLE table_name ADD CONSTRAINT gender CHECK (gender IN ('M', 'F'));
```
•  Tablonun adını değiştirmek için
```SQL
	ALTER TABLE students RENAME TO new_name;
```
•  Sütunun adını ve veri türünü değiştirmek için
```SQL
	ALTER TABLE table_name CHANGE old_column_name new_column_name data_type[constraints];
	ALTER TABLE students CHANGE name nameNew VARCHAR(100);
```
•  Sütundaki sadece veri türünü değiştirmek istersek
```SQL
	ALTER TABLE students MODIFY name VARCHAR(255);
```
•  Tablo oluştururken kullanılan mevcut yapıyı görmek için
```SQL
	SHOW CREATE TABLE students;
Bu ifade tablonun sütunlarını, veri türlerini, kısıtlamaları ve diğer özelliklerini içerir.    

•  ENGINE ifadesi tablonun hangi depolama motorunu kullandığını belirtir. 

•  Tabloya veri eklemek için
```SQL
	INSERT INTO students (name, age, gender) VALUES ('SEDA',27,'F');
```
•  Birden fazla satırı aynı anda eklemek için
```SQL
	INSERT INTO students (name, age, gender) VALUES 
	('SEDA', 27, 'F'),
	('FURKAN', 27, 'M');
```
•  Kolona bütün verileri gireceksek(id,name,age,city,gender)
```SQL
	INSERT INTO students VALUES(3,'Azize',49,'ZONGULDAK','F');
```
•  Tablodaki verileri getirmek için
```SQL
	SELECT name, age FROM students;
	SELECT * FROM students;
```
•  WHERE komutu yalnızca belirli koşullara uyan satırları döndüğrmek için kullanılır.
```SQL
	SELECT * FROM table_name WHERE id=1;
```
•  Tablodaki bir veriyi(id'si 2 olan veriyi) güncellemek için
```SQL
	UPDATE table_name SET surname='yeni_veri' WHERE id=2;
```
•  Tablodaki belirli idlerdeki bir kolondaki verileri güncellemek için
```SQL
	UPDATE students SET surname='new_value' WHERE id IN (2,3,4);
```
•  Tablodaki belirli idlerde(3 ve 6 idli) belirli kolonlardaki verileri güncellemek için
```SQL
	UPDATE table_name SET age=new_age, city='new_city_name' WHERE id IN (3,6);
```
•  Tablodaki belirli idler(2,3,4,5,6) arasındaki kolonlardaki verileri güncellemek için
```SQL
	UPDATE table_name SET surname='new_surname' WHERE id BETWEEN 2 AND 6;
```
•  MySQL sunucusunun dinlediği port numarasınını öğrenmek için;
```SQL
	SHOW VARIABLES LOKE 'port';
```
•  MySQL sunucusuna bağlandıktan sonra mevcut bağlantının host adı veya IP adresini öğrenmek için ;
```SQL
	SELECT CONNECTION_ID(), USER(), CURRENT_USER(), @@hostname;
```



# Bağlantılar
•  Programlar database ile konuşmak için SQL komutlarını kullanır. Komutu Java kodunun içinde çalıştırmak istersek veritabanına bir bağlantı kurulur ve komutu göndeririz. Komutun gönderimi için Statement veya PreparedStatement kullanırız.    
• **Statement(Güvensiz Yöntem)**; SQL sorgusu direkt metin olarak yazıldığı için dışarıdan gelen verilerle birleştirildiğinde tehlikeli olabilmekte.   

```java
Statement statement=connection.createStatement();
ResultSet re=statement.executeQuery("SELECT * FROM MESSAGE WHERE ID=5");
```

• **PreparedStatement**; SQL sorgularını önceden derleyip parametreli bir şekilde çalıştırmamızı sağlar. Java'da veritabanı işlemleri için kullanılan JDBC(Java Database Connectivity) API'sinin bir parçasıdır. SQL injection yapılamaz, kod daha temiz ve okunaklı olur, sorgular önceden derlendiüği için daha hızlı çalışır.   

```java
PreparedStatement pStatement=connection.preparedStatement("SELECT * FROM MESSAGE WHERE ID=?");  //? bir placeholder'dır(yer tutucu)
pStatement.setLong(1,5); // ilk ? placeholder'ı yerine 5 sayısını koyar. 
ResultSet re=pStatement.executeQuery();
```

• **Örnek bir bağlantı;**

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Veritabanı bağlantı adresi
        String user = "your_username"; // Veritabanı kullanıcı adı
        String password = "your_password"; // Veritabanı şifresi
	long userId = 1; // örnek değer
   try (
	 // Veritabanına bağlan
        Connection connection = DriverManager.getConnection(url, user, password);
	//Sorguyu çalıştır
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usersb WHERE id=?");
	){
		//parametreyi yerleştir
     		ps.setLong(1, userId);
		//sorguyu çalıştır
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			String name = resultSet.getString("name");
                	String email = resultSet.getString("email");
                	System.out.println("Ad: " + name + ", E-posta: " + email);;	
		}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

```SQL
CREATE DATABASE testdb;
USE testdb;
CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
INSERT INTO users(is,name,email) VALUES
(1,'Seda Güney Duran', 'seda2guney@gmail.com'),
(2,'Furkan Duran', 'furkanduran@gmail.com');

```



