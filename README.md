# knife4j 自定义

本项目基于knife4j，实现一些自己需要的功能，以留自用

感谢 knife4j 作者
原仓库链接：https://gitee.com/xiaoym/knife4j

 - [knife4j 说明](README_OLD.md)
-  [knife4j 文档](https://doc.xiaominfo.com/)

### 实现功能
- 删除自定义底部
- 删除文档管理菜单
- 重写springfox-swagger2 实现 ApiModelProperty根据 position 字段排序


### ApiModelProperty根据position 排序


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
@Data
public class UserVo implements java.io.Serializable {
   
    @ApiModelProperty(notes = "name",position = 1)
    private String name;
   
    @ApiModelProperty(notes = "mobile",position = 2)
    private String mobile;
    
    @ApiModelProperty(notes = "email",position = 3)
    private String email;

}

```
