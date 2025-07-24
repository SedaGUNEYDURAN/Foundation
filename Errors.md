# Error Handling
• **throw** Program çalışırken bir exception oluşturmak ve onu fırlatmak için kullanılır. Program akışında bir şeyler ters giderse programı durdurur ve exceptionı üst seviyeye gönderir. sadece bir exception objes ile kullanılabilir. Fırlatılacak olan exception genellikle new ile yaratılır. Fırlatılan exception Throwable sınıfından türemiş olmalıdır. throw çalıştığında akış durur, programın geri kalan kısmı çalışmaz.     
• Exception'ı yakalayabilmek için **catch** ya da metot signatureda **throws** ile belirtilmelidir.    
• Java Reflection API kullanarak "method.invoke" metodu ile bir method çağırılır.Eğer çağırılan method bir exception fırlatırsa, bu exception doğrudan Reflection API tarafından fırlatılmaz. Bunun yerine InvocationTargetException exception'ını ile sarmalanır. Gerçek exception saklanmış olur. Asıl hataya neden olan exception **getCause()** methodu ile bulunur.    

## Exceptions
•	**java.lang.IllegalStateException**, form gönderimi sırasında Springin verileri bağlamak ve doğrulamak için ihtiyaç duyduğu objeleri bulamadığı anlamına gelir. Aşağıdaki kodda htmldeki modelAttribute niteliği gönderilen todo nesnesine bağlanabilmesi için modelAttribute adlandırılması aynı olmalıdır. Bu Spring MVC'nin BindingResult kullanarak doğrulama yapmasını sağlar.  
```html
		<form:form method="post" modelAttribute="todoPage">
```
```java
		ToDo todo= todoService.findById(idUpdate);
		model.addAttribute("todoPage", todo);
```


• **IndexOutOfBoundException**: arrayin ya da collection'ın geçerli index aralığının dışında bir indexe erişilmeye çalışıldığını gösterir.   
• **ClassCastException**: bir sınıfın bir nesneyi başka bir türe dönüştürmeye çalıştığı ve dönüşümün uygun olmadığı durumlarda alınır.  
• **InvocationTargetException**:Java Reflection API'ını kullanarak bir methodu çağırmaya çalışırken meydana gelir. Bir method "invoke"  methodu ile çağırıldığında bir exception atarsa exception  InvocationTargetException'ı ile sarmalanarak fırlatılır. 
• **IllegalArgumentException**: bir metodun argümanlarının geçersiz veya uygunsuz olduğu durumlarda fırlatılan bir exceptiondır. Bu hata tipik olarak bir metodun ön koşulların sağlanmadığı durumlarda kullanılır. 
• **CloneNotSupportedException**: klonlama sırasında alınır. İki durumda ortaya çıkar. Bir nesne klonlanmaya çalışıldığında, ancak bu nesnenin sınıfı Clonable interface'ini implement etmedeğinde ve Object classının clone() metodunu çağırırken super.clone() kullanılırken.  
