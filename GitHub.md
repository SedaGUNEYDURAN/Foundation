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
•  
```java
git 
```
•  
```java
git 
```












