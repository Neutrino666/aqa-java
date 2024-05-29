## Задания для самостоятельной работы

**Задание А**

**Case 1** _Параметризация тестов, валидация полей_

Разработчики добавили возможность добавлять имена питомцев в любом регистре и на любых языках

Проверьте эту функциональность. Корректно ли создаются питомцы, где имена могут быть в любом регистре и на любых языках

``
метод покрытия: https://petstore.swagger.io/v2/pet
``

Пример вариантов имен

```shell
Busya
BUSYA
busya
BuSyA
Буся
БУСЯ
буся
БуСя
```

**!**
Для валидации полей используйте матчеры Hamcrest

**Case 2** _Использование Junit ассертов_

Проверьте корретно ли отрабатывает метод создания заказа

метод покрытия:`` https://petstore.swagger.io/v2/store/order``

Используйте assert'ы Junit для проверок

- значения поля  **petId** соответствует созданному id питомца ранее
- значения поля  **status** соответствует одному из значений [ placed, approved, delivered ]
- значения поля  **complete** соответствует типу boolean
- значения поля  **shipDate** не пустое(имеет какое-либо значение)

**Case 3** _работа с JSONObject (вложенными полями)_

Сформируйте тело запроса с использованием JSONObject

Проверьте, корретно ли отрабатывает метод добавления питомца

``https://petstore.swagger.io/v2/pet``

**Задание В**

- Ознакомиться с материалами в секции "Ресурсы"

## Ресурсы

- Про параметризацию
  тестов[Parameterized Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
  или [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

- Подробнее про параметризацию на Baeldung](https://www.baeldung.com/parameterized-tests-junit-5)


- Про Assumptions
  [JUnit 5 Assumptions](https://howtodoinjava.com/junit5/junit-5-assumptions-examples/)

- Про Асерты (Assertions)
  [Assertions habr](https://habr.com/ru/post/591587/)
  или [Writing Assertions With JUnit 5 Assertion API](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-junit-5-api/)
  ,

- [Junit5 на Baeldung](https://www.baeldung.com/junit-5)
- [jetbrains jUNIT5](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/)

