## Lesson 7. use POJO class to generate data

- with Lombock

Добавление в проект зависимостей

```groovy
dependencies {
    testImplementation 'org.projectlombok:lombok:1.18.20'
    testAnnotationProcessor 'org.projectlombok:lombok:1.18.20'
}
```

```java

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

}
```

**@Data** - генерация конструкторов, гетеров,сетеров, и методов унаследованных от Object

**@Setter** - только сетторы

**@Getter** - только гетторы

Про остальные аннотации подробнее [Lombock](https://projectlombok.org/features/)

- manual

```java

public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}



```

- generate with IDEA

Alt+Insert hotkey and choose methods

###Создание объекта, инициализация полей объекта значениями

```java
User userReq = new User();
userReq.

setUsername("Гена");
userReq.

setFirstName("Генадий");
userReq.

setLastName("Трубогиб");
userReq.

setEmail("gena2025@ma.ru");
```

передача объекта в метод

```java
apiHelper.post(Endpoints.USER, userReq, resp200);
```

Получить ответ в виде нужного объекта

```java
User userActual = apiHelper.get(Endpoints.USERNAME, resp200, userReq.getUsername()).as(User.class);
```

### Work with properties file

файлик с пропертями лежит в папке resources

```java

public static Properties props;

InputStream is = ClassLoader.getSystemResourceAsStream("service.properties");
props =new

Properties();
        try{
                props.

load(is);
        }catch(
IOException e){
        e.

printStackTrace();
        }
```
