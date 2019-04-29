# utils

## A common Java library

### 这是一个通用的`Java`类库，提供一些常用的快捷操作方法. 

> 仅限个人使用，不提供技术支持和文档，请谨慎使用！


Json示例代码
```java

// 基于FastJson的JsonUtils工具
String json = "[{name: 'Thomas', age: 10, x: null, money: 100.009, birth: '2019-04-30'}, {name: 'Bruce', age: 18, x:null, money: 100.009, birth: '2019-04-30'}]";
List<User> list = JsonUtils.fromJsonList(json, User.class);


// 基于Gson的GsonUtils工具
String json = "{name: 'Thomas', age: 100, x: null, money: 100.009, birth: '2019-04-30'}";
User user = GsonUtils.fromJson(json, User.class);

```


UUID示例代码
```java

// 生成随机UUID
System.out.println(UUID.next8());       // pkwCiIID
System.out.println(UUID.next16());      // xMSqhNdENrppgbwP
System.out.println(UUID.next32());      // fd7903bc450f45f6a1ae93608a4f46ca
System.out.println(UUID.next(10));      // d56w98ShrZ

```