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


BigDecimalUtils示例代码
```java

// 比较两个数大小，元和分转换
System.out.println(ge(bg("10.00"), bg("10.01")));       // false
System.out.println(lt(bg("10.02"), bg("10.01")));       // false
System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_CEILING));  // 11
System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_UP));       // 11
System.out.println(yuan2fen(new BigDecimal("12.004")));         // 1200
System.out.println(yuan2fen(new BigDecimal("12.005")));         // 1201
System.out.println(fen2yuan(12004567));                      // 120045.67
```


WebUtils获取客户端真实IP.
```java

// 获取客户端真实IP地址
WebUtils.getIp();       // 
WebUtils.getIp(request, "x-real-ip", "remoteip", "x-forwarded-for", "some head name");    // 获取客户端真实IP地址
```


使用
```xml
<!-- https://mvnrepository.com/artifact/com.github.tangweixin/utils -->
<dependency>
    <groupId>com.github.tangweixin</groupId>
    <artifactId>utils</artifactId>
    <version>1.0.3</version>
</dependency>
```