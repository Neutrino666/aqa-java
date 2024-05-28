


## Lesson 2. Hamcrest и Junit5


**Горячие клавиши  intelijIDEA**

**Ctrl + /**       Однострочное комментирование / раскомментирование

**Ctrl + Shift + /** 	Многострочное комментирование / раскомментирование

**Ctrl + Alt + L** 	автоформатирование кода

**Ctrl + D** 	Дублирование строки

[Полный список hotkeys ](https://devcolibri.com/%D0%B3%D0%BE%D1%80%D1%8F%D1%87%D0%B8%D0%B5-%D0%BA%D0%BB%D0%B0%D0%B2%D0%B8%D1%88%D0%B8-intellij-idea/)


### Hamcrest 

Добавление в проект зависимостей
```groovy
dependencies {
    testImplementation 'org.hamcrest:java-hamcrest:2.0.0.0'
}
```
```java
    @Test
    void checkSoldItem(){

            given()
            .when()
            .get("https://petstore.swagger.io/v2/store/inventory")
            .then()
            .log().all()
            .statusCode(200)
            .assertThat()
            //Матчер на наличия ключа в json. 
            .body("$",Matchers.hasKey("sold"))
            //Матчер на присутствия значения для поля
            .body("sold",Matchers.notNullValue());
            }
```

Отличная статейка по [JsonPath](https://testerslittlehelper.wordpress.com/2019/01/20/jsonpath-in-rest-assured/)

```java
    @Test
    void hamcrestExamples()
            {
            // Сравнение 
            assertThat("word",Matchers.equalTo("word"));

            // Содержит подстроку
            assertThat("wordpress",Matchers.containsString("word"));

            // Логическое И
            assertThat("wordpress",Matchers.allOf(
            Matchers.containsString("word"),
            Matchers.containsString("press")));

            // Логическое ИЛИ
            assertThat("wordpress",Matchers.anyOf(
            Matchers.containsString("word"),
            Matchers.containsString("press")));

            }
```

Отличные статейки про Hamcrest

[Туториал по Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial)  
[Testing with Hamcrest](https://www.baeldung.com/java-junit-hamcrest-guide)

Примеры интересных матчеров:
```java

// colorfull Hamcrest
@Test
public void gequalToIgnoringCaseTest()
        {
         String a="JAVA";
         String b="java";
         assertThat(a,Matchers.equalToIgnoringCase(b));
        }

@Test
public void greaterThanOrEqualToTest()
        {
            assertThat(4,Matchers.greaterThanOrEqualTo(5));
        }
//.....

```

###Junit5
Добавление в проект зависимостей
```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-params:5.8.2'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
}

test {
    // Находит и выполняет тесты построенные на платформе Junit
    useJUnitPlatform()
}

```

###Junit5. ParameterizedTest

```java
//использование строки, в качестве аргумента тестовой функции
    @ParameterizedTest
    @ValueSource(strings = {"шалаш", "дом", "мадам"})
    void palindromes(String candidate) {
    assertTrue(StringUtils.isPalindrome(candidate));
    }

    //использование целого числа, в качестве аргумента тестовой функции
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }


    //использование возвращающегося значения метода, в качестве аргумента тестовой функции. Название метода идентично тестовому
    @ParameterizedTest
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("мясо", "рыба");
    }

    //использование возвращающегося значения метода, в качестве аргумента тестовой функции. Название метода отлично от тестового
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }

    //использование возвращающегося значения метода, в качестве аргументов тестовой функции. Метод возвращает несколько значении
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(1, str.length());
        assertTrue(num >= 1 && num <= 3);
        assertEquals(2, list.size());
    }


    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("mandarin", 1, Arrays.asList("s", "d")),
                arguments("qivi", 3, Arrays.asList("s", "f"))
        );
    }


    //использование csv значении, в качестве аргументов тестового метода
    @ParameterizedTest
    @CsvSource({
            "meat,        4",
            "qivi,        8",
            "'fish',       0xF1",
            "icecreame,    700_000"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    //использование csv значении, в качестве аргументов тестовой функции. Набор значении задается файлом с расшерением .csv в папке resources проекта
    @ParameterizedTest
    @CsvFileSource(resources = "/country-reference.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

    //использование csv значении, в качестве аргументов тестовой функции. Набор значении задается файлом с расшерением .csv в произвольном месте проекта
    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/ru/education/aqajava/tests/lessons/lesson4/food-price.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String food, int price) {
        assertNotNull(food);
        assertNotEquals(0, price);
    }
}
```

###Junit5. Assertions

```java

@Test
     void standardAssertions() {
         // assert на сравнение двух значений
        assertEquals(2, 1 + 1);

        // assert на сравнение двух значений с выводом сообщения в случае, если они не равны
        assertEquals(4, 2 * 2,
                "ожидаемое значение отлично от переданного");
        // assert на сравнение истинности условия
        assertTrue('a' < 'b');

        // assert на сравнение истинности условия с выводом  сообщения в случае ложного условия
        assertTrue('a' < 'b', "условие не истинно");
    }

    @Test
    void groupedAssertions() {
        //Выполнение всех ассертов без прерывания при неудачном одном из них. Репорт о падениях ассертов, если таковые имеются,происходит вместе
        assertAll("operations with numbers",
                () -> assertEquals(3, 2 + 65),
                () -> assertEquals(8, 4 * 5)
        );
    }


    //исключение соответствующего типа не было выброшено.Тест не пройден
    @Test
    public void exceptionDoesntThrown() {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    //исключение соответствующего типа было выброшено.Тест пройден
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    //assert на выполнение кода в течении заданного периода времени. Если по окончанию таймаута код не выполнился, тогда тест упадет
    @Test
    void timeoutNotExceeded() {

        assertTimeout(ofSeconds(1), () -> {
            TimeUnit.SECONDS.sleep(3);
            // какая-то логика
        });
    }

    //assert на выполнение кода в течении заданного периода времени. Если по окончанию таймаута код выполнился,можно вернуть как-либо значение
    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofSeconds(2), () -> {
            return "java" + " the best";
        });
        assertEquals("java the best", actualResult);
    }
```


###Junit5.Assumptions

```java
    // прерывает выполнение теста,если условие не истинно. В этом случае тест помечается как Aborted
    @Test
    void assumeTrueTest() {
        assumeTrue("Windows_NT".equals(System.getenv("OS")),
                "Aborting test");
        System.out.println("it is work");
    }

    @Test
    void assumeFalseTest() {
        assumeFalse("Linux".equals(System.getenv("OS")),
                "Aborting test");
        System.out.println("it is work");
    }

    // позволяет выполнить определенный участок кода, в зависимости от условия. Не прерывает выполнение теста
    @Test
    void testInAllOS() {
        assumingThat("Windows_NT".equals(System.getenv("OS")),
                () -> {
                    assertEquals(2, 3 - 1);
                    System.out.println("2");
                });


        assertEquals(40, 5 * 8);
        System.out.println("40");
    }
```

