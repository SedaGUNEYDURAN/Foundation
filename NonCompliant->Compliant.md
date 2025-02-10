• Common pattern;
```java
int messageId=mesagge.getId();
if(hashMap.get(messageId)==null){
  hashMap.put (messageId,new HashMap<>());
}

```
Yukarıdaki kodda gürüldüğü gibi mapte null kontrolü ya da containsKey() kontrolü yaygın olarak kullanılır. Ancak Map  API'si computeIfAbsent() or computeIfPresent() gibi daha temiz alternatifler sunmaktadır;

```java
int messageId=mesagge.getId();
hashMap.computeIfAbsent(messageId, k-> new HashMap<>());
```
