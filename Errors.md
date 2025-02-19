## Exceptions

•	**java.lang.IllegalStateException**, form gönderimi sırasında Springin verileri bağlamak ve doğrulamak için ihtiyaç duyduğu objeleri bulamadığı anlamına gelir. Aşağıdaki kodda htmldeki modelAttribute niteliği gönderilen todo nesnesine bağlanabilmesi için modelAttribute adlandırılması aynı olmalıdır. Bu Spring MVC'nin BindingResult kullanarak doğrulama yapmasını sağlar.  
```html
		<form:form method="post" modelAttribute="todoPage">
```
```java
		ToDo todo= todoService.findById(idUpdate);
		model.addAttribute("todoPage", todo);
```
