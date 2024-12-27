1)Kullanıcıları listelemek için,
```SQL
	SELECT user,host FROM mysql.user;
```
2) Yeni kullanıcı oluşturmak için
```SQL
	CREATE USER 'kullanıcıadı'@'localhost' IDENTIFIED BY 'şifre';
```
3) Root olarak giriş yapmak için
```SQL
	mysql -u root -p 
```
4) Yeni bir kullanıcı yaratmak için(root olmalı ya da kullanıcının yetkileri olmalı)
```SQL
	CREATE USER "sedagd"@"localhost" IDENTIFIED BY "şifre";
```
5)Kullanıcıya veritabanına erişim izni vermek için
```SQL
	GRANT ALL PRIVILEGES ON *.* TO "sedagd"@"localhost";
```
6) Yapılan değişikliklerin uygulanması için
```SQL
	FLUSH PRIVILEGES;
```
7)Mysql kullanan kullanıcıları görmek için
```SQL
	SELECT user, host FROM mysql.user;
```
8)Mysql'de istediğimiz kullanıcıya geçmek için
```SQL
	mysql -u kullanıcıadı -p
```
9)Sadece belirli bir yerden bağlanan kullanıcıya geçmek için
```SQL
	mysql -u yeni_kullanıcı -p -h "localhost"
```
10)Database oluşturmak için
```SQL
	CREATE DATABASE database_name; 
```
11)Databaseleri görmek için
```SQL
	SHOW DATABASES;
```
12)Varolan bir database'i silmek için
```SQL
	DROP DATABASE database_name;
```
13)Üzerinde işlem yapacağın database'i seçmek için
```SQL
	USE database_name;
```
14)Bir table yaratmak için
```SQL
	CREATE TABLE students (
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	name VARCHAR(255) NOT NULL,
  	age INT NOT NULL
	);
```
15)Tabloları silmek için
```SQL
	SHOW TABLES FROM database_name;
```
16)Varolan bir table'ı silmek için(önce use ilen database seçilmeli)
```SQL
	DROP TABLE table_name;
```
17) 	UNIQUE: Sütunda benzersiz değerler olmalıdır.
	NOT NULL: Sütun boş bırakılamaz.
	PRIMARY KEY: Sütun tablonun birincil anahtarıdır.
	FOREIGN KEY: Sütun başka bir tablodaki bir sütuna başvurur.
	CHECK: Sütuntaki değerlerin belirli bir koşulu karşılamasını sağlar.
	DEFAULT: Sütun boş bırakılırsa varsayılan bir değer atar.

18)Tablodaki sütunları görmek için
```SQL
	DESCRIBE table_name;
```
19)Tabloya sütun eklemek için(gender kolonu ekleyelim)
```SQL
	ALTER TABLE table_name ADD COLUMN gender VARCHAR(255);
```
20)Eklediğimiz gender sütununun değerine kısıtlama getirmek için (m ve f şeklinde)
```SQL
	ALTER TABLE table_name ADD CONSTRAINT gender CHECK (gender IN ('M', 'F'));
```
21)Tablonun adını değiştirmek için
```SQL
	ALTER TABLE students RENAME TO new_name;
```
22)Sütunun adını ve veri türünü değiştirmek için
```SQL
	ALTER TABLE table_name CHANGE old_column_name new_column_name data_type[constraints];
	ALTER TABLE students CHANGE name nameNew VARCHAR(100);
```
23)Sütundaki sadece veri türünü değiştirmek istersek
```SQL
	ALTER TABLE students MODIFY name VARCHAR(255);
```
24)Tablo oluştururken kullanılan mevcut yapıyı görmek için
```SQL
	SHOW CREATE TABLE students;
Bu ifade tablonun sütunlarını, veri türlerini, kısıtlamaları ve diğer özelliklerini içerir. 

25)ENGINE ifadesi tablonun hangi depolama motorunu kullandığını belirtir. 

26)Tabloya veri eklemek için
```SQL
	INSERT INTO students (name, age, gender) VALUES ('SEDA',27,'F');
```
27)Birden fazla satırı aynı anda eklemek için
```SQL
	INSERT INTO students (name, age, gender) VALUES 
	('SEDA', 27, 'F'),
	('FURKAN', 27, 'M');
```
28)Kolona bütün verileri gireceksek(id,name,age,city,gender)
```SQL
	INSERT INTO students VALUES(3,'Azize',49,'ZONGULDAK','F');
```
29)Tablodaki verileri getirmek için
```SQL
	SELECT name, age FROM students;
	SELECT * FROM students;
```
30)WHERE komutu yalnızca belirli koşullara uyan satırları döndüğrmek için kullanılır.
```SQL
	SELECT * FROM table_name WHERE id=1;
```
31)Tablodaki bir veriyi(id'si 2 olan veriyi) güncellemek için
```SQL
	UPDATE table_name SET surname='yeni_veri' WHERE id=2;
```
32)Tablodaki belirli idlerdeki bir kolondaki verileri güncellemek için
```SQL
	UPDATE students SET surname='new_value' WHERE id IN (2,3,4);
```
33)Tablodaki belirli idlerde(3 ve 6 idli) belirli kolonlardaki verileri güncellemek için
```SQL
	UPDATE table_name SET age=new_age, city='new_city_name' WHERE id IN (3,6);
```
34)Tablodaki belirli idler(2,3,4,5,6) arasındaki kolonlardaki verileri güncellemek için
```SQL
	UPDATE table_name SET surname='new_surname' WHERE id BETWEEN 2 AND 6;
```
35) MySQL sunucusunun dinlediği port numarasınını öğrenmek için;
```SQL
	SHOW VARIABLES LOKE 'port';
```
36) MySQL sunucusuna bağlandıktan sonra mevcut bağlantının host adı veya IP adresini öğrenmek için ;
```SQL
	SELECT CONNECTION_ID(), USER(), CURRENT_USER(), @@hostname;
```














