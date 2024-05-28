# Возможности Junit5

tags: junit5, parametrized

## План

- Основные аннотации Junit5 для работы;
    - Test;
    - ParametrizedTest;
    - Assumptions
- Подробнее про параметризованные тесты;
    - @ValueSource;
    - @CsvSource;
    - @MethodSource;
- Методы жизненного цикла теста (before, after...);

## Лекция

Junit умеет
находить автотесты в проекте



Добавить в файл build.gradle:

```
test {
    useJUnitPlatform()
}
```
 и в секцию dependencies добавить необходимые зависимости
```
 testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
 testImplementation 'org.junit.jupiter:junit-jupiter-params:5.8.2'
 testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
```

## Ресурсы
- Про Assumptions
[JUnit 5 Assumptions](https://howtodoinjava.com/junit5/junit-5-assumptions-examples/) ,[Полный список Assumptions](https://junit.org/junit5/docs/5.0.0/api/org/junit/jupiter/api/Assumptions.html)

- Про Асерты (Assertions)
[Assertions habr](https://habr.com/ru/post/591587/) или [Writing Assertions With JUnit 5 Assertion API](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-junit-5-api/),
  
  [Полный список Асертов.Class Assertions](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html)

- Про TestInstance [@TestInstance Annotation](https://www.baeldung.com/junit-testinstance-annotation)
- Про LifeCycle methods [LifeCycle JUnit 5](https://howtodoinjava.com/junit5/junit-5-test-lifecycle/)
- Про параметризацию тестов[Parameterized Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
или [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
  
[Junit5 на Baeldung](https://www.baeldung.com/junit-5)  
[Подробнее про параметризацию на Baeldung](https://www.baeldung.com/parameterized-tests-junit-5)  

## Самостоятельная работа

Перенести создание и удаление заказа в методы before и after all.  
Тест должен просто проверять наличие заказа с определенным параметром. 