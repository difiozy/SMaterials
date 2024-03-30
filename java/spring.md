# **Spring** - Framework, каркас, струкртура

Фреймворк - платформа, которая определяет структуру систумы (приложения) и облегчает разработку компонентов системы и из
интеграцию.

**Spring** - Framework, каркас, струкртура

Фреймворк - платформа, которая определяет структуру систумы (приложения) и облегчает разработку компонентов системы и из
интеграцию.

**Популярные фреймворки**

* Spring framework

* Node.js

* Django

* Ruby on Rails

* ASP.NET
  **Spring Framework**

Состоит из множества компонентов => облегчает множество аспектов разработки приложений на Java

* Контекст приложения (Application Context) и Внедрение Зависимостей (Dependency Injection)

* Удобный и эффективный доступ к БД (замена JDBC)

* Компонент для разработки Web - приложений на Java (Spring MVC)

* Множество других полезных компонентов (spring.io)

**Application Context & Dependency Injection**

Типичное Java приложение - это набор Java объектов, которые взаимодействуют друг с другом и ссылаются друг на друга.

Когда Java приложение запускается, все необходимые Java объекты создаются и помещаются в оперативную память. В ходе
работы приложения, объекты могут добавляться / удаляться. Также могут изменяться связи между объектами.

Большое количество объектов и связей между ними встречается в любос более - меннее сложном Java - приложении. Spring
помогает нам в работе с множеством объектов.

А можно ли без Spring?

можно но сложно...

* код становится очень запутанным (особенно в больших приложенмях), не прослеживается иерархия между объектами

* У подкласса тоже могут быть объекты, которые нужны ему для работы, и так далее

* много лишенего кода

**Паттерн Singleton**

объект database создавался макс 1 раз

Внедрить ссылку на объект database всем остальным объектам

**Appltcation Context & Dependebcy Injection**

Appltcation Context

1. Мы описываем объекты, которые необходимы для работы нашего приложения (которые должны создаваться при запуске
   приложения)

2. Spring сам создает эти объекты и берет на себя управление этими объектами (их жизненный цикл и многое другое)

Dependebcy Injection

3. Spring сам внедряет все необходимые зависимости в объекты (связывает объекты между собой). Нам необходимо только
   написать эту связь, Spring делает все остальное.
   **Удобный и эффективный доступ к БД**

Большинство приложений импользуют БД

* JDBC - примитивный и неудобный способ взаимодействия с БД

* JDBC не походит для сложных приложений. Он слишком низкоуровневый.

* **Spring предоставляет множество инструментов для взаимодействия с БД**

**Spring MVC**

* Компонент Spring Framework, который позволяет создавать Web - приложения

* Огромное количество Web - приложений в интернете работают на Spring MVC

* Помимо этого, Spring MVC часто используется в качестве backend - API для мобильных приложений

Spring MVC > Java EE Servlets
Други компоненты Spring Framework

* Spring Security

* Spring Boot

* Spring Webflow

* и множество других

Что подключать в maven
spring-core, spring-beans, spring-context

```java
package org.example;

public class TestBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

```java
package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        context.close();
    }
}
```

applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="testBean"
          class="org.example.TestBean">
        <constructor-arg value="Kirill"/>
    </bean>

</beans>
```

## Inversion Of Control (IoC)

инверсия управления
Проблемы

* Зависимость появляются очень часто в коде

испльзование абстракций

* объекты создаются пручную. мы хотим вынести эти детали в конфигурационный файл, а не лезить каждый раз в код для того,
  чтобы поменять.

* принцип IoC

**Bean**

* Это просто Java объект

* Когда Java объекты создаются с помощью Spring'a они называются бинами

* Бины создаются из Java классов (так же, как и обычные объекты)

![spring_pict_1.png](files%2Fstatic%2Fspring_pict_1.png)
![spring_pict_2.png](files%2Fstatic%2Fspring_pict_2.png)
Программируем на уровне интерфейсов
![spring_pict_3.png](files%2Fstatic%2Fspring_pict_3.png)
![spring_pict_4.png](files%2Fstatic%2Fspring_pict_4.png)

**Spring можно конфигурировать с помощью:**

* XML файла конфигурации (старый способ)

* Java аннотаций и немного XML

* Вся конфигурация нат Java коде

## Dependency Injection (DI)

внедрение зависимостей

**Типичные шаги в работе со Spring**

* Создаем Java - классы (будующие бины)

* Создаем и связываем бины с помощью Spring (аннотации, XML или Java код)

* При использовании, все объекты (бины) берутся из контейнера Spring

**Способы внедрения зависимостей**

* через конструктор

* через setter

* есть множество конфигураций того, как внедрять (scope, factory method и т.д.)

* можно внедрять через XML, аннотации или Java - код

* процесс внедрения можно автоматизировать (Autowiring)

```xml

<xml>
    <bean id="musicBean"
          class="org.example.ClassicalMusic">
    </bean>
    <bean id="musicPlayer"
          class="org.example.MusicPlayer">
        <constructor-arg ref="musicBean">
    </bean>
</xml>
```

```java
MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
musicPlayer.

playMusic();
```

Spring читает эти файлы, и когда дошел до бинов сам создал объекты и внедряет зависимости

**Внедрение зависимостей через setter**

```java
public void setMusic(Music music) {
    this.music = music;
}
```

```xml

<xml>
    <bean id="musicPlayer"
          class="org.example.MusicPlayer">
        <property ref="musicBean">
    </bean>
</xml>
```

**Внедрение простых знаений**

```java
private String name;
private int Volume;

public void setName(String name) {
    this.name = name;
}

public void setVolume(String volume) {
    this.volume = volume;
}
```
```xml
<xml>
    <property name="name" value="Some name"/>
    <property name="volume" value="50"/>
</xml>
```

**Внедрение значения из внешних файлов**

* Не хотим каждый раз лезть в applicationContext.xml

* Хотим все простые значения указать в одном файле

```text
//musicPlayer.properties файл
musicPlayer.name=Some name
musicPlayer.volume=60
```
```xml
<xml>
    <context:property-placeholder location="classpath:musicPlater.properties"/>
    <property name="name" value="${musicPlayer.name}"
    <property name="volume" value="${musicPlayer.volume}"
</xml>
```
```xml
<xml>
    <bean id="musicBean1"
          class="org.example.ClassicalMusic">
    </bean>
    <bean id="musicBean2"
          class="org.example.RockMusic">
    </bean>
    <bean id="musicBean3"
          class="org.example.MyFavoriteMusic">
    </bean>

    <bean id="musicPlayer"
          class="org.example.MusicPlayer">
        <property name="musicList">
            <list>
                <ref bean="musicBean1"/>
                <ref bean="musicBean2"/>
                <ref bean="musicBean3"/>
            </list>
        </property>

        <property name="volume" value="${musicPlayer.volume}"/>
    </bean>
</xml>
```
**Scope**

область видимости бинов

Scope задает то, как spring будет создавать ваши бины

```xml
<xml>
    <bean id="musicBean3"
          class="org.example.MyFavoriteMusic">
    </bean>
</xml>
```

* По умолчанию создается один объект(он создается до вызова метода getBean())

* При всех вызовах getBean() возвращаается ссылка на уже созданный объект

![spring_pict_5.png](files%2Fstatic%2Fspring_pict_5.png)
Scope Singleton чаще всего используется тогда, когда у нашего бина нет изменяемых состояний (stateless).

Потому что если будем изменять состояние у Singleton бина, столкнемся с проблемой явно

```xml
<xml>
    <bean id="musicBean3"
          class="org.example.MyFavoriteMusic"
          scope="singleton">
    </bean>
</xml>
```
```java
public class Lesson7Singleton {
    // В этой статической(!) переменной будет хранится единственный объект класса Lesson7Singleton
    private static Lesson7Singleton instance;

    // Скажем, что у нашего единственного объекта должно быть поле value
    private String value;

    // Метод getter для поля value
    public String getValue() {
        return value;
    }

    // ВАЖНО: Конструктор должен быть приватным
    // Мы не хотим, чтобы пользователь мог создавать новые объекты класса Lesson7Singleton
    private Lesson7Singleton(String value) {
        this.value = value;
    }

    // Вот этот статический метод будет вызывать пользователь, чтобы получить объект класса Lesson7Singleton
    public static Lesson7Singleton getInstance(String value) {
        // если ранее не был создан единственный объект
        if (instance == null) {
            // код здесь выполняется только в момент первого вызова метода getInstance()

            // создаем объект один раз
            instance = new Lesson7Singleton(value);
        }

        // все остальные вызовы метода getInstance() пользователю возвращается тот же самый объект
        return instance;
    }
}

// Тестируем
class SingletonTest {
    public static void main(String[] args) {
        Lesson7Singleton first = Lesson7Singleton.getInstance("Hello!");
        Lesson7Singleton second = Lesson7Singleton.getInstance("Goodbye!");

        // true
        System.out.println(first == second);

        // Hello!
        System.out.println(first.getValue());

        // Hello!
        System.out.println(second.getValue());
    }
}
```

Prototype

Scope, который каждый раз создает новый объект при вызове getBean()

request
session
global-session

### Жизненный цикл бина - Bean Lifecycle
![spring_pict_6.png](files%2Fstatic%2Fspring_pict_6.png)

**init-method & destroy-method**

ini-method

* Метод, который запускается в ходе инициализации бина

* Инициализация ресурсов, обращение к внешним файлам, запуск БД

destroy-method

* Метод, который запускается в ход уничтожения бина (при завершении приложения)

* Очищение ресурсов, закрытие потоков ввода-вывода, закрытие досупа к БД

```xml
<bean id="musicBean"
        class="org.example.MyFavoriteMusic"
        init-method="doMyInit"
        destroy-method="doMyDestroy">
</bean>
```

Методы doMyInit и doMyDestroy создаются в классе бина MyFavoriteMusic

**Тонкости init и destroy методов**

* **модификатор доступа**

у этих методов может быть любой модификатор доступа (public, protected, private)

* **Тип возвращаемого значения**

может быть любой, но чаще всего используется void (так как нет возможности получить возрашаемое значение).

* **Название метода**

название может быть любым

* **Аргументы метода**

Эти методы не должны принимать на вход какие -либо аргументы

Для бинтв со scope "prototype" Spring **не вызвается destroy метод**

Spring не берет на себя полный жизненный цикл бинов со scope "prototype". Spring отдает prototype бины клиенту и больше о них не заботится (в отличии от singleton бинов).

**Factory-method**

Фабричный метод - это паттерн программирования.

Вкратце: паттерн "Фабричный метод" поедлагает создавать объекты не напрямую, используя оператор **new**, а через вызов особого **фабричного метода**. Объекты все равно будут создаваться при помощи **new**, но делать это будет фабричный метод (иногда это бывает полезно).

```xml
<bean id="musicBean"
        class="org.example.MyFavoriteMusic"
        factory-method="getClassicalMusic">
</bean>
```
ограничить создание new

приватный конструктор

**Что такое Java Аннотации?**

Java Аннотации - это специальный тип комметариев в вашим коде с помощью которых можно:

* Передавать какие-либо инструкции для Java компилятора (@Override)

* Передавать какие-либо инстурукции для анализаторов исходного кода

* **Передавать метаданные, которые могут быть использованы либо вашим Java приложением (с помощбю рефлексии), либо другими приложениями или фреймворками (Spring Franework)**
  **Зачем использовать аннотации?**

* Короче, чем XML конфигурация

* Удобнее, чем XML конфигурация

* Код становится более читабельным

**Как работает конфигурация с помощью аннатоаций?**

* Spring сканирует все ваши классы

* Находит классы со специальными аннотациями и **автоматически создает бины** из этих классов

![spring_pict_7.png](files%2Fstatic%2Fspring_pict_7.png)

**Аннотация @Component**

* Помечаем ей класс, если хотим, чтобы Spring Franework **создал бин** из этого класса

* Именно **эту** англьацтя Spring Framework ищет, когда сканирует все ваши классы

* Можно указать **id** дл ясоздаваемого бина, можно не указывать (тогда название будет *название_класса_с*маленькой_буквы*)

```xml
<context:component-scan base-package="org.example"/>
```
**Аннотация @Autowired**

Мы больше не внедряем зависимость вручную, Spring сам ищет  подзодящий бин и автоматически внедряет его

**Как работает аннотация @Autowired**

* В данном примере в бин musicPlayer необходимо внедрить бин, который реализует инрфейс Music.

@Autowired
public MusicPlayer(Music music) {this.music = music}

* Spring сканирует все классы с аннтацией @Component и создает бины для этих классов

* Spring сканирует все созданные бины и проверяет, подходит ли хотя бы один бин в качестве зависимости там, где мы указали аннотация @Autowired

* Eсли находится один подходящий бин, он внедряется в качестве зависимости

* Если не находится ни одного бина - ошибка

* Если несколько бинов подходят - неоднозначность

```java

@Autowired
public MusicPlayer(Music music) {this.music = music}

@Autowired
public MusicPlayer(ClassicalMusic  classicalMusic) {this.classicalMusic = classicalMusic}

// подбирает подходящие бины по их типу (класс или интрфейс)

// можно использовать на полях, сеттерах и конструкторах

// внедрит зависимость в приватное поле даже если нет конструктора или сеттера.
// Делает она это с помощью Рефлексии
```
**Проблема**

music <- rockMusic, classiclasMusic

**Аннотация @Qualifier**
уточнитель

* Указваем **id** того бина, который хотим внедрить

```java
@Autowired
@Qualifier("rockMusic")
private Music music;
```
**Необычный синтаксис**

Когда внедрение производится с помощью **конструктора** для уточнения зависимостей необходимо использовать такой синтаксис:
```java
@Autowired
public MusicPlayer(@Qualifier("rockMusic") Music music1,
                   @Qualifier("classicalMusic") Music music2) {
                      this.music1 = music1;
                      this.music2 = music2;
                   }
```
![spring_pict_9.png](files%2Fstatic%2Fspring_pict_9.png)
![spring_pict_10.png](files%2Fstatic%2Fspring_pict_10.png)
![spring_pict_11.png](files%2Fstatic%2Fspring_pict_11.png)
![spring_pict_12.png](files%2Fstatic%2Fspring_pict_12.png)\
![spring_pict_13.png](files%2Fstatic%2Fspring_pict_13.png)

```java
@Value("${musicPlayer.name}")
private String name;

@PostConstruct
public void doMyInit() {
    System.out.println("Doing my initialization");
}

@PreDestroy
public void doMyDestroy() {
    System.out.println("Doing my destruction");
}
```

![spring_pict_14.png](files%2Fstatic%2Fspring_pict_14.png)
![spring_pict_15.png](files%2Fstatic%2Fspring_pict_15.png)
![spring_pict_16.png](files%2Fstatic%2Fspring_pict_16.png)
![spring_pict_17.png](files%2Fstatic%2Fspring_pict_17.png)
![spring_pict_18.png](files%2Fstatic%2Fspring_pict_18.png)
![spring_pict_19.png](files%2Fstatic%2Fspring_pict_19.png)
![spring_pict_20.png](files%2Fstatic%2Fspring_pict_20.png)