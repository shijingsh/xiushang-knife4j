# knife4j项目依赖


### swagger-models

<swagger-models.version>1.5.22</swagger-models.version>
<swagger2.version>1.5.22</swagger2.version>
<swagger3.version>2.1.2</swagger3.version>
```xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-common</artifactId>
            <version>${springfox.version}</version>
            <scope>compile</scope>
            <exclusions>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-models</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

### slf4j
<slf4j.version>1.7.28</slf4j.version>

```xml
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-api</artifactId>
                <version>${slf4j.version}</version>
            </dependency>
```

