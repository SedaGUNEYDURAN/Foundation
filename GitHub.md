• Kullanıcı adımızı ve e-posta adresimizi yapılandırmalıyız. 
```java
git config --global user.name "KullaniciAdi"
```
```java
git config --global user.email "email@example.com"
```
• Bulunduğumuz konumda git repository oluşturmak için;
```java
git init . 
```
ya da 
```java
git init dosyaAdı 
```
•  Uzak repository eklemeliyiz(remote repository adımızı origin verdik burada);
```java
git remote add origin https://github.com/kullaniciadi/repo-adi.git
```
•  Local depomuza eklenmiş olan tüm remote repository bağlantılarını ve bunlarınm URL'lerini görmek için;
```java
git remote -v
```
• Local'e repository'i çekmek için;
```java
git clone https://github.com/kullaniciadiniz/repo-adi.git
```
• Yaptığımız değişiklikleri Git'e eklemek commit etmeliyiz ama önce eklemeliyiz;
```java
git add . 
```
• Yaptığımız değişiklikleri Git'e eklemek istediğimizde ancak sadece bir classı commitlemek istediğimizde pathini vermeliyiz, sonra aynı şekilde commitlemeliyiz;
```java
git add path/to/your/NewClass.java 
```
• Değişiklikleri commit etmek için;
```java
git commit -m "First Commit"
```
• local üzerinde yaptığımız değişiklikleri GitHub'daki repoya gönderebilmek için(parola sorduğunda token girmelisin); 
```java
git push remoteRepositoryAdı branchAdimiz
```
•  Remote repositorydeki değişiklikleri local branch'e çekmek için;
```java
git pull remoteRepositoryAdı branchAdimiz
```
• Local brancleriğ listelemek için(bulunduğumuz branch * ile işaretlidir);
```java
git branch
```
• Remote repository üzerindeki mevcut branchleri görmek için;
```java
git branch -r
```
• Hem local hem de remote repository'deki branchleri tek komut ile görmek için; 
```java
git branch -a
```
• Yeni bir branch oluşturmak için;
```java
git branch yeniBranchİsmi
```
• Başka bir branch'e geçmek istersek;
```java
git checkout branchİsmi
```
• Yeni bir branch oluşturup o branch'e geçmek için;
```java
git checkout -b branchİsmi
```
• Bir branch'i silmek için(merge edilmişse);
```java
git branch -d branchİsmi
```
•  Branch'i zorla silmek için(merge edilmemiş olsa bile);
```java
git branch -D branchAdı
```
•  Bulunduğumuz branche belirtilen branch'teki değişiklikleri birleştirmek için(iki branchi birleştirmeye çalışırken bir çakışma olursa git branch açar Çakışmaları çözmek için ilgili dosyaalrı düzenledikten sonra add dedikten sonra commitlemeliyiz);
```java
git merge branchAdı
```
• Bulunduğumuz branchi belirtilen branchin üstüne yeniden yerleştirmek için;
```java
git rebase branchAdı
```
Rebase; bir branch'i başka bir branchin üzerine yeniden yerleştirmektir.Bu işlemle mevcut branchimizdeki değişiklikler, hedef branch üzerindeki son commitlerin üzerine eklenir, bunu yaparken rebase mevcut commitleri yeni bir temel(base) üzerine taşır. Rebase işlemi, geçerli branchteki tüm commitleri alır. Bu commitler hedef branchin en son commitinin üzerine uygulanır. 
•  Branchleri ve commitleri gösmek için; 
```java
git show-branch
```
•  Tüm branchlerin commit geçmişini grafiksel bir formatta görebilmek için;
```java
git log --oneline --graph --decorate --all
```
•  Bulunduğumuz branch için bir upstream branch ayarlamak için 
```java
git branch --set-upstream-to=remoteRepositoryName/branchAdı
```
**Upstream**; bir branchin ana kaynağını tanımlamak için kullanılan bir terimdir.  Genellikle, bir branch üzerinde çalışırken o branchin ilişkili olduğu remote reporitory branchi ile bağlantısını ifade eder. Bir dalın bağlı olduğu uzak daldır. Genellikle, local branchimizin değişikliklerini göndermek(push) veya remote repository ile güncellemler almak(pull) için hangi referansı alacağını belirtir.
**Downstream**; remote repository'nin local kopyalarındaki değişiklikleri yansıtan branchtir.

•  Çalışma dizinindeki doyaların değişiklikleri kontrol etmek için; 
```java
git status
```
•  Çalışma dizinindeki değişiklikleri görmek için(staging area'ya eklenmeyenleri);
```java
git diff
```
•  Hem staging area'ya eklenen hem de henüz eklenmemiş değişiklikleri görmek için;
```java
git diff --cached
```
•  Git pull iki adımlı işlemi otomatik olarak gerçekleştirir, remote repositorydeki en son değişiklikleri lokal depomuza getirri ve fetch sırasında alınan değişiklikleri mevcut branch ile birleştirir yani merge eder. Aşağıdaki komut varsayılan remote repositoryden ve mevcut branchteki  branchteki remote branchten güncellemeleri çeker, birleştirir. Remote repository; C1-C2-C3 Local repository; C4-C5;   
```java
  C1 - C2 - C3
           \
            M (merge commit)
           /
  C4 - C5
```
```java
git pull
```
•  Belirli bir remote repositoryden çekmek için;
```java
git pull remoteRepository
```
• Belirli bir banch'i çekmek için;
```java
git pull remoteRepository branchAdi
```
•  Sadece remote değişiklikleri görmek istiyorsak ama birleştirmek istemiyorsak;
```java
git fetch remoteRepository
```
•  Local değişiklikleri remote değişikliklerin üzerine almak istiyorsak ;
```java
git pull --rebase
```
Bu işlem önce fetch işlemi yapar. Sonrasında ise rebase işlemi yapar, uzaktaki commitleri alır local commitlerin önüne alarak yeni bir commit geçmişi oluşturur. (Remote repository; C1-C2-C3 Local repository; C4-C5  git pull --rebase remoteRepository branchAdi dediğimizde C1-C2-C3-C4-C5 ŞEKİLNDE OLUR COMMİTLER )
•   Tüm commit geçmişini görüntülemek için; 
```java
git log 
```
•  Belirli bir sayıdaki son commiti görmek için;
```java
git log -görmekIstediğimizCommitSayısı
```
•  Belirli bir tarihten itibaren commitleri görmek için;
```java
git log --since=="2023-01-01"
```
•  Belirli bir tarihten önceki commitleri görmek için;
```java
git log --until="2023-12-31"
```
•  Commit bilgilerini özelleltirilmiş bir formatta gösterir.Her commit bir satırda gösterilir. **--pretty** komutu;çıktının görünüm şeklini yani formatını özelliştirmemi<i sağlar. **oneline** komutu; commit hashinin kısaltılmış halini ve sade ilk satırdaki commit mesajını verir ve her commit tek satırda görülür
```java
git log --pretty=oneline
```
•  Commit hash'ini kısa bir formatte görmek için;
```java
git log --abbrev-commit
```
•  Commit geçmişini grafiksel bir formatte görebilmek için;
```java
git log --graph
```
•  Commitin hangi dosyaları etkilediğini ve bu dosyalardaki değişikliklerin kısa bir özeti için;
```java
git log --stat
```
• Belirli bir yazar tarafından yapılmış commitleri görmek için;
```java
git log --author="SedaGUNEYDURAN"
```
•  Belirli bir dosyaya ait commitleri görmek için;
```java
git log dosyaAdı
```
•  Her commit için hangi değişikliklerin yapıldığı(diff) detaylı bir formatta bilgi almak için;
```java
git log -p
```
•  Belirli bir commite hash'i ile dönemk için ;
```java
git checkout hashCodu
```
•  Belirli bir commitin ayrıntılarını hash'i ile görebilmek için;
```java
git show hashCode
```
•  Diyelim ki bugfix için açtık bugfix21543 olsun adı. Ama değişiklikleri yanlışlıkla master branch'te yaptık, commitlemiş de olabilir yanlışlıkla. Bu durumda tek tek elle bugfix branchine taşımamıza gerek yok kodumuzu. Öncelikle açtığımız bugfix21543 branchini silmeliyiz(Eğer aynı adı kullanmak istiyorsak branchimizde)  
```java
git checkout -b bugfix21543
```

Bu komutla masterdaki değişiklikleri bugfix21543 adında yeni bir branch açıp ona taşıyoruz ve bugfix21543 brancgine geçiyoruz. 
```java
git checkout master
```

Master branch'e geçtik 

```java
git reset --hard origin/master
```
Localdeki master branchin commit geçmişini siler ve remotedaki(origin/master) branchi ile localdaeki branchimizi aynı hale getirir. 

• Pushlamadığın commitlerini görmek için
```java
git log origin/master..HEAD --oneline --graph
```

**origin/master** : remote sunucudaki master branchin   
**HEAD** : içinde bulunduğun branchin lokaldeki en güncel hali   
**origin/master..HEAD** --> Benim local master branchimde olup da henüz Github'a gönderilmemiş yani push edilmemiş commitler nelerdir   
**HEAD..origin/master** --> git pull yapmadığımızda ortaya çıkar. Githubda olup benim localimde olmayan neler var diye bakmak istersek   

