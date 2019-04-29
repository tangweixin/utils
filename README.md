# utils

A common Java library

这是一个通用的Java类库.


>  基于FastJson的JsonUtils工具
>  
>  基于Gson的GsonUtils工具
>


```java

    String json = "[{name: 'Thomas', age: 10, x: null, money: 100.009, birth: '2019-04-30'}, {name: 'Bruce', age: 18, x:null, money: 100.009, birth: '2019-04-30'}]";
    List<User> list = JsonUtils.fromJsonList(json, User.class);

```
