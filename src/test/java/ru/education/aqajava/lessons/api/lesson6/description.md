# Название урока

## План

- Использование java объектов в качестве тела для запросов и ответов(POJO)
- Добавление Lombok аннотации
- рассказать больше про ООП сетеры,гетеры,конструкторы

## Лекция

### Используя Lombok

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

**@Data** - генерация конструкторов, гетеров, сетеров, и методов унаследованных от Object

**@Setter** - только сетторы

**@Getter** - только гетторы

Про остальные аннотации подробнее [Lombok](https://projectlombok.org/features/)

### Вручную

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

### Используя IDEA

Alt+Insert hotkey and choose methods

#### Создание объекта, инициализация полей объекта значениями

```java
User userReq = new User();
userReq.setUsername("Гена");
userReq.setFirstName("Генадий");
userReq.setLastName("Трубогиб");
userReq.setEmail("gena2025@ma.ru");
```

передача объекта в метод

```java
apiHelper.post(Endpoints.USER, userReq, resp200);
```

Получить ответ в виде нужного объекта

```java
User userActual = apiHelper.get(Endpoints.USERNAME, resp200, userReq.getUsername()).as(User.class);
```

### Работа с properties

файл с properties лежит в папке resources

```java
public static Properties props;

InputStream is = ClassLoader.getSystemResourceAsStream("service.properties");
props = new Properties();
try {
    props.load(is);
} catch(IOException e) {
    e.printStackTrace();
}
```

## Самостоятельная работа

## Задания для самостоятельной работы

**Задание 1.** Java объекты, сетеры, гетеры

Написать автотест на проверку корректности работы метода

```petstore.swagger.io/v2/store/order```

- создать класс содержащий поля тела запроса и методы доступа к ним(сетеры и гетеры вручную)
- создать объект класса
- инициализировать поля объекта через сетеры
- передать объект в качестве тела запроса метода
- проделать несколько произвольных проверок ответа от сервера

**Дополнительное задание**

- создать анологичный класс содержащий поля тела запроса, но использовать Lombok аннотации @Setter @Getter для генерации
  сетеров, гетеров

**Задание 2.** Работа с properties файлами

- создать файл service.properties в папке resources
- перенести базовый url сервиса в проперти файл
- считать пропертя из файла в переменную в классе BaseTest
- использовать созданную перменную для задания базового url для автотестов

**Задание 3**

- Ознакомиться с материалами в секции "Ресурсы"

## Ресурсы

- [Properties](https://javarush.ru/quests/lectures/questcollections.level01.lecture09)
- [REST Assured Authentication](https://www.baeldung.com/rest-assured-authentication)
- [Lombok](https://projectlombok.org/features/)
