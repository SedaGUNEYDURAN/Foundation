# Error Handling
• **throw** Program çalışırken bir exception oluşturmak ve onu fırlatmak için kullanılır. Program akışında bir şeyler ters giderse programı durdurur ve exceptionı üst seviyeye gönderir. sadece bir exception objes ile kullanılabilir. Fırlatılacak olan exception genellikle new ile yaratılır. Fırlatılan exception Throwable sınıfından türemiş olmalıdır. throw çalıştığında akış durur, programın geri kalan kısmı çalışmaz.     
• Exception'ı yakalayabilmek için **catch** ya da metot signatureda **throws** ile belirtilmelidir. 

## Exceptions
•	**java.lang.IllegalStateException**, form gönderimi sırasında Springin verileri bağlamak ve doğrulamak için ihtiyaç duyduğu objeleri bulamadığı anlamına gelir. Aşağıdaki kodda htmldeki modelAttribute niteliği gönderilen todo nesnesine bağlanabilmesi için modelAttribute adlandırılması aynı olmalıdır. Bu Spring MVC'nin BindingResult kullanarak doğrulama yapmasını sağlar.  
```html
		<form:form method="post" modelAttribute="todoPage">
```
```java
		ToDo todo= todoService.findById(idUpdate);
		model.addAttribute("todoPage", todo);
```
