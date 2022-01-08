###Temporarily replace springfox-swagger2
   

I copied a separate lib to temporarily solve the problem of sorting according to the position attribute

Change your dependence

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>3.0.0</version>
</dependency>
```

to

```xml
<dependency>
    <groupId>com. github. shijingsh</groupId>
    <artifactId>knife4j-springfox-swagger2</artifactId>
    <version>3.0.0</version>
</dependency>
```

```java
public class UserVo implements java.io.Serializable {
   
    @ApiModelProperty(notes = "name",position = 1)
    private String name;
   
    @ApiModelProperty(notes = "mobile",position = 2)
    private String mobile;
    
    @ApiModelProperty(notes = "email",position = 3)
    private String email;

}

```
