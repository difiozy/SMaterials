# Java CORE
## Переменные и типы данных
### Примитивные типы данных
В состав примитивных типов (или просто примитивов) входят четыре подвида и восемь типов данных:

1) целые числа (byte, short, int, long);

2) числа с плавающей точкой (float, double);

3) логический (boolean);

4) символьный (char).

### Ссылочные типы данных
Ссылочные типы данных ещё называют ссылками. К ним относятся все классы, интерфейсы, массивы, а также тип данных String.

Хотя у примитивов и ссылок много общего, между ними есть существенные различия. И главное различие — в том, что именно в них хранится.
![javaCore_table_1.jpg](files%2Fstatic%2FjavaCore_table_1.jpg)

*Пример* использования примитивных и ссылочных типов данных

```java
int a = 5;
int b = a; //мы создали две переменных и два различных значения, которые содержат число 5

Cat barsik = new Cat(); //мы создали объект Cat, и переменной barsik присвоена ссылка на этот объект
Cat murka = barsik;     //создали две ссылки на один и тот же объект Cat
```
![javaCore_table_2.jpg](files%2Fstatic%2FjavaCore_table_2.jpg)

## Циклы
### WHILE
```java
while(условие до каких пор крутится цикл) {
    тело цикла;
}
```
### FOR
```java
for (int i = 0; i < n; i++) {
    System.out.println(i + " шаг цикла");
}
```
### DO WHILE
```java
do {
    действие
} while(условие);
```

### FOR EACH
For-each — это разновидность цикла for, которая используется, когда нужно обработать все элементы массива или коллекции. “For each” с английского так и переводится — “для каждого”. Собственно, само словосочетание foreach в этом цикле не используется. Его синтаксис следующий:

```java
for (Type itVar : array)
{
    Блок операторов;
}
```
Где type — тип итерационной переменной (совпадает с типом данных в массиве!), itVar — её имя, array — массив (тут также может быть другая структура данных, какая-нибудь коллекция, например, ArrayList), то есть объект, по которому выполняется цикл. Счётчик в такой конструкции не применяется, итерационная переменная перебирает элементы массива или коллекции, а не значения индекса.

## Оператор break и continue
Java поддерживает три оператора перехода — break, continue и return. Они передают управление в другую часть вашей программы. Рассмотрим каждый из операторов подробно.

Оператор break в Java используется в трех случаях. Во-первых, как вы уже видели, он заканчивает последовательность операторов в ветвях оператора switch. Во-вторых, его можно использовать для выхода из цикла. В-третьих, он может применяться как "цивилизованная" форма оператора безусловного перехода goto. В этом разделе объясняются два последних случая.

Использование break для выхода из цикла.

Используя break, вы можете форсировать немедленное завершение цикла, обходя условное выражение и любой остающийся код в теле цикла. Когда оператор break встречается внутри цикла, второй заканчивается и программное управление передается оператору, следующему за ним.

Оператор break может использоваться с любым из циклов Java, включая преднамеренно бесконечные циклы.

Использование оператора continue.

Иногда полезно начать очередную итерацию цикла пораньше. То есть нужно продолжить выполнение цикла, но прекратить обработку остатка кода в его теле для данной частной итерации. На самом деле это — goto-переход мимо следующих операций тела в конец блока цикла. Такое действие выполняет оператор continue. В циклах while и do while оператор continue вызывает передачу управления непосредственно условному выражению, которое управляет циклом. В цикле for управление переходит сначала к итерационной части оператора for и затем к условному выражению. Для всех трех циклов любой промежуточный код обходится.

## Условный оператор if

```java
if (условие) {
    действия
}
else if (ещё условие) {
    ещё действие
}
else {
    последнее условие
}
```
## Оператор switch
Аналог оператора if, но используется в том случае когда много условий которые нужно перебрать и не выстраивать сложную конструкцию из вложенных операторов if

```java
switch (ВыражениеДляВыбора) {
           case  (Значение1):
               Код1;
               break;
           case (Значение2):
               Код2;
               break;
...
           case (ЗначениеN):
               КодN;
               break;
           default:
               КодВыбораПоУмолчанию;
               break;
       }
```
## Массивы

Массив — это структура данных, в которой хранятся элементы одного типа. Его можно представить, как набор пронумерованных ячеек, в каждую из которых можно поместить какие-то данные (один элемент данных в одну ячейку).

В случае с Java массив однороден, то есть во всех его ячейках будут храниться элементы одного типа. Так, массив целых чисел содержит только целые числа (например, типа int), массив строк — только строки, массив из элементов созданного нами класса Dog будет содержать только объекты Dog. То есть в Java мы не можем поместить в первую ячейку массива целое число, во вторую String, а в третью — “собаку”.

![javaCore_table_3.jpg](files%2Fstatic%2FjavaCore_table_3.jpg)

```java
new typeOfArray [length]; //typeOfArray — это тип массива, а length — его длина

int[] myArray; // объявление массива
myArray = new int[10]; // создание, то есть, выделение памяти для массива на 10 элементов типа int

int[] myArray = new int[10]; // объявление и выделение памяти “в одном флаконе”
```
После создания массива с помощью new, в его ячейках записаны значения по умолчанию. Для численных типов (как в нашем примере) это будет 0, для boolean — false, для ссылочных типов — null.

## Многомерные массивы

В обобщённом виде многомерные массивы в Java выглядят так:
```java
Data_type[dimension1][dimension2][]..[dimensionN] array_name = new data_type[size1][size2]….[sizeN];
```
Где Data_type — это тип элементов в массиве. Может быть примитивным или ссылочным (классом).

Количество пар скобок с dimension внутри — размерность массива (в нашем случае — N).

array_name —  название массива

size1...sizeN — количество элементов в каждом из измерений массива.

Объявление многомерных массивов:

```java
int[][] twoDimArray; //двумерный массив
String[][][] threeDimArray; //трёхмерный массив
double[][][][][] fiveDimArray; // пятимерный массив
```
## Классы и объекты
Класс — это, по сути, шаблон для объекта. Он определяет, как объект будет выглядеть и какими функциями обладать. Каждый объект является объектом какого-то класса.

Имя класса начинается с заглавной буквы(как и каждое новое слово)
```java
public class Cat {

    String name;
    int age;

}
```
Переменные, которые мы создали в классе Cat - поля или же переменные экземпляра.

В названии, собственно, раскрыта вся их суть. Эти переменные будут у каждого экземпляра (объекта) класса Cat.
## Методы
Методы — это функционал твоего класса; то, что объекты этого класса умеют делать. С одним из методов мы уже знакомы — это метод main(). Но метод main, как мы помним, является статическим — то есть он принадлежит всему классу (логика такая же, как с переменными).

А обычные, нестатические методы, можно вызывать только на конкретных объектах, которые мы создали.

### Абстрация
Абстракция — один из четырех основных принципов объектно-ориентированного программирования. Он подразумевает выделение главных, наиболее значимых характеристик предмета, и наоборот — отбрасывание второстепенных, незначительных.

### Конструкторы
Конструктор — это, по сути, шаблон для объектов класса.

Теперь, когда в классе есть конструктор, компилятор Java знает, как должны выглядеть объекты, и не позволяет создавать объекты без указанных в нем аргументов.

Дефолтный конструктор исчезает из класса, когда ты создаешь какой-то конструктор с аргументами.
### Ключевое слово this
"this" по-английски — "этот, этого". То есть это слово указывает на конкретный предмет.
```java
public Cat(String name, int age) {
    this.name = name;
    this.age = age;
}
```
name для этого кота (которого мы создаем) = аргументу name, который указан в конструкторе.

age для этого кота (которого мы создаем) = аргументу age, который указан в конструкторе.

## Ключевое слово static
Static — модификатор, применяемый к полю, блоку, методу или внутреннему классу. Данный модификатор указывает на  привязку субъекта  к текущему классу.

Модификатор static в Java напрямую связан с классом. Если поле статично, значит оно принадлежит классу, если метод статичный — аналогично: он принадлежит классу. Исходя из этого, можно обращаться к статическому методу или полю, используя имя класса.

Например, если поле count статично в классе Counter, значит, вы можете обратиться к переменной запросом вида: Counter.count.

При обозначении переменной уровня класса мы указываем на то, что это значение относится к классу. Если этого не делать, то значение переменной будет привязываться к объекту, созданному по этому классу.

Если переменная не статическая, то у каждого нового объекта данного класса будет своё значение этой переменной, меняя которое мы меняем его исключительно в одном объекте.

Есть два блока инициализации — обычный и статический.

Блок предназначен для инициализации внутренних переменных. Если блок обычный, то им инициализируют внутренние переменные объекта, если же статический, соответственно, им задают статические переменные (то есть переменные класса).

Статические методы отличаются от обычных тем, что они также привязаны к классу, а не к объекту.

Важным свойством статического метода является то, что он может обратиться только к статическим переменным/методам.

Статическим классом может быть только внутренний класс.

Опять же, этот класс привязан к внешнему классу, и если внешний наследуется другим классом, то этот не будет наследован. При этом данный класс можно наследовать, как и он может наследоваться от любого другого класса и имплементировать интерфейс.

По сути статический вложенный класс ничем не отличается от любого другого внутреннего класса за исключением того, что его объект не содержит ссылку на создавший его объект внешнего класса.

Тем не менее, благодаря этому статический класс наиболее похож на обычный не вложенный, ведь единственное различие состоит в том, что он упакован в другой класс. В некоторых случаях для нас это преимущество, так как с него у нас есть доступ к приватным статическим переменным внешнего класса.

Для использования статических методов/переменных/класса нам не нужно создавать объект данного класса.

Конечно, следует учитывать модификаторы доступа. Например, поля private доступны только внутри класса, в котором они объявлены. Поля protected доступны всем классам внутри пакета (package), а также всем классам-наследникам вне пакета.
### Важное о Statis
1. Вы НЕ можете получить доступ к НЕ статическим членам класса, внутри статического контекста, как вариант, метода или блока.
   Это одна из наиболее распространённых ошибок допускаемых программистами Java, особенно новичками.

2. В отличие от локальных переменных, статические поля и методы НЕ потокобезопасны (Thread-safe) в Java. На практике это одна из наиболее частых причин возникновения проблем связанных с безопасностью мультипоточного программирования. Учитывая что каждый экземпляр класса имеет одну и ту же копию статической переменной, то такая переменная нуждается в защите — «залочивании» классом. Поэтому при использовании статических переменных, убедитесь, что они должным образом синхронизированы (synchronized), во избежание проблем, например таких как «состояние гонки» (race condition).

3. Статические методы имеют преимущество в применении, т.к. отсутствует необходимость каждый раз создавать новый объект для доступа к таким методам. Статический метод можно вызвать, используя тип класса, в котором эти методы описаны. Именно поэтому, подобные методы как нельзя лучше подходят в качестве методов-фабрик (factory), и методов-утилит (utility). Класс java.lang.Math — замечательный пример, в котором почти все методы статичны, по этой же причине классы-утилиты в Java финализированы (final).

4. Другим важным моментом является то, что вы НЕ можете переопределять (Override) статические методы. Если вы объявите такой же метод в классе-наследнике (subclass), т.е. метод с таким же именем и сигнатурой, вы лишь «спрячете» метод суперкласса (superclass) вместо переопределения. Это явление известно как сокрытие методов (hiding methods). Это означает, что при обращении к статическому методу, который объявлен как в родительском, так и в дочернем классе, во время компиляции всегда будет вызван метод исходя из типа переменной. В отличие от переопределения, такие методы не будут выполнены во время работы программы.

5. Объявить статическим также можно и класс, за исключением классов верхнего уровня. Такие классы известны как «вложенные статические классы» (nested static class). Они бывают полезными для представления улучшенных связей. Яркий пример вложенного статического класса — HashMap.Entry, который предоставляет структуру данных внутри HashMap. Стоит заметить, также как и любой другой внутренний класс, вложенные классы находятся в отдельном файле .class. Таким образом, если вы объявили пять вложенных классов в вашем главном классе, у вас будет 6 файлов с расширением .class. Ещё одним примером использования является объявление собственного компаратора (Comparator), например компаратор по возрасту (AgeComparator) в классе сотрудники (Employee).

6. Модификатор static также может быть объявлен в статичном блоке, более известным как «Статический блок инициализации» (Static initializer block), который будет выполнен во время загрузки класса. Если вы не объявите такой блок, то Java соберёт все статические поля в один список и выполнит его во время загрузки класса. Однако, статичный блок НЕ может пробросить перехваченные исключения, но может выбросить не перехваченные. В таком случае возникнет «Exception Initializer Error». На практике, любое исключение возникшее во время выполнения и инициализации статических полей, будет завёрнуто Java в эту ошибку. Это также самая частая причина ошибки «No Class Def Found Error», т.к. класс не находился в памяти во время обращения к нему.

7. Полезно знать, что статические методы связываются во время компиляции, в отличие от связывания виртуальных или не статических методов, которые связываются во время исполнения на реальном объекте. Следовательно, статические методы не могут быть переопределены в Java, т.к. полиморфизм во время выполнения не распространяется на них. Это важное ограничение, которое необходимо учитывать, объявляя метод статическим. В этом есть смысл, только тогда, когда нет возможности или необходимости переопределения такого метода классами-наследниками. Методы-фабрики и методы-утилиты хорошие образцы применения модификатора static. Джошуа Блох выделил несколько преимуществ использования статичного метода-фабрики перед конструктором, в книге «Effective Java», которая является обязательной для прочтения каждым программистом данного языка.

8. Важным свойством статического блока является инициализация. Статические поля или переменные инициализируются после загрузки класса в память. Порядок инициализации сверху вниз, в том же порядке, в каком они описаны в исходном файле Java класса. Поскольку статические поля инициализируются на потокобезопасный манер, это свойство также используется для реализации паттерна Singleton. Если вы не используется список Enum как Singleton, по тем или иным причинам, то для вас есть хорошая альтернатива. Но в таком случае необходимо учесть, что это не «ленивая» инициализация. Это означает, что статическое поле будет проинициализировано ещё ДО того как кто-нибудь об этом «попросит». Если объект ресурсоёмкий или редко используется, то инициализация его в статическом блоке сыграет не в вашу пользу.

9. Во время сериализации, также как и transient переменные, статические поля не сериализуются. Действительно, если сохранить любые данные в статическом поле, то после десериализации новый объект будет содержать его первичное (по-умолчанию) значение, например, если статическим полем была переменная типа int, то её значение после десериализации будет равно нулю, если типа float – 0.0, если типа Object – null. Честно говоря, это один из наиболее часто задаваемых вопросов касательно сериализации на собеседованиях по Java. Не храните наиболее важные данные об объекте в статическом поле!

10. И напоследок, поговорим о static import. Данный модификатор имеет много общего со стандартным оператором import, но в отличие от него позволяет импортировать один или все статические члены класса. При импортировании статических методов, к ним можно обращаться как будто они определены в этом же классе, аналогично при импортировании полей, мы можем получить доступ без указания имени класса. Данная возможность появилась в Java версии 1.5, и при должном использовании улучшает читабельность кода. Наиболее часто данная конструкция встречается в тестах JUnit, т.к. почти все разработчики тестов используют static import для assert методов, например assertEquals() и для их перегруженных дубликатов.

## Ключевое слово final
Для класса это означает, что класс не сможет иметь подклассов, т.е. запрещено наследование. Это полезно при создании immutable (неизменяемых) объектов, например, класс String объявлен, как final.

Следует также отметить, что к абстрактным классам (с ключевым словом abstract), нельзя применить модификатор final, т.к. это взаимоисключающие понятия.

Для метода final означает, что он не может быть переопределен в подклассах. Это полезно, когда мы хотим, чтобы исходную реализацию нельзя было переопределить.

Для переменных примитивного типа это означает, что однажды присвоенное значение не может быть изменено.

Для ссылочных переменных это означает, что после присвоения объекта, нельзя изменить ссылку на данный объект. Это важно! Ссылку изменить нельзя, но состояние объекта изменять можно.

С java 8 появилось понятие — effectively final. Применяется оно только к переменным (в том числе аргументам методов). Суть в том, что не смотря на явное отсутствие ключевого слова final, значение переменной не изменяется после инициализации. Другими словами, к такой переменной можно подставить слово final без ошибки компиляции. effectively final переменные могут быть использованы внутри локальных классов (Local Inner Classes), анонимных классов (Anonymous Inner Classes), стримах (Stream API).

1. Что можно сказать про массив, когда он объявленfinal?

Т.к. массив – это объект, то final означает, что после присвоения ссылки на объект, уже нельзя ее изменить, но можно изменять состояние объекта.

2. Известно, что класс String — immutable, класс объявлен final, значение строки хранится в массиве char, который отмечен ключевым словом final.

Да, можно. Ключевой момент – это понимание использования колючего слова final с объектами. Для подмены значения использует ReflectionAPI.

Важно, что если бы мы попытались изменить подобным образом финальную переменную примитивного типа, то ничего бы не вышло.

## StringBuilder
Строки в Java — это неизменяемые объекты (immutable). Так было сделано для того, чтобы класс-строку можно было сильно оптимизировать и использовать повсеместно. Например, в качестве ключей у коллекции HashMap рекомендуется использовать только immutable-типы.

Однако часто возникают ситуации, когда программисту все же было бы удобнее иметь String-класс, который можно менять. Который не создает новую подстроку при каждом вызове его метода.

Например, у нас есть очень большая строка и мы часто дописываем что-то в ее конец. В этом случае даже коллекция символов может быть эффективнее, чем постоянное пересоздание строк и конкатенации объектов типа String.

Именно поэтому в язык Java все же добавили тип String, который можно менять. Называется он StringBuilder.

Чтобы создать объект StringBuilder на основе существующей строки, нужно выполнить команду вида:
```java
StringBuilder имя = new StringBuilder(строка);
```
Чтобы создать пустую изменяемую строку, нужно воспользоваться командой вида:

```java
StringBuilder имя = new StringBuilder();
```
Класс StringBuilder имеет два десятка полезных методов, вот самые важные из них:


StringBuilder append(obj) - Преобразовывает переданный объект в строку и добавляет к текущей строке

StringBuilder insert(int index, obj) - Преобразовывает переданный объект в строку и вставляет в текущую строку

StringBuilder replace(int start, int end, String str) - Заменяет часть строки, заданную интервалом start..end на переданную строку

StringBuilder deleteCharAt(int index) - Удаляет из строки символ под номером index

StringBuilder delete(int start, int end) - Удаляет из строки символы, заданные интервалом

int indexOf(String str, int index) - Ищет подстроку в текущей строке

int lastIndexOf(String str, int index) - Ищет подстроку в текущей строке с конца

char charAt(int index) - Возвращает символ строки по его индексу

String substring(int start, int end) - Возвращает подстроку, заданную интервалом

StringBuilder reverse() - Разворачивает строку задом наперед.

void setCharAt(int index, char) - Изменяет символ строки, заданный индексом на переданный

int length() - Возвращает длину строки в символах
Есть еще один класс — StringBuffer — это аналог класса StringBuilder, только его методы имеют модификатор synchronized. А это значит, что к объекту StringBuffer можно одновременно обращаться из нескольких потоков.

Зато он работает гораздо медленнее, чем StringBuilder. Такой класс может вам понадобиться, когда вы начнете активно изучать многопоточность в квесте Java Multithreading.

### Форматирование строк

![javaCore_table_4.jpg](files%2Fstatic%2FjavaCore_table_4.jpg)

### Класс object и метод toString()
Методы, которые есть у Object’а, есть вообще у всех классов.
![javaCore_table_5.jpg](files%2Fstatic%2FjavaCore_table_5.jpg)

## Модификаторы доступа public, private, protected, default
Модификаторы доступа — это чаще всего ключевые слова, которые регулируют уровень доступа к разным частям твоего кода. Почему «чаще всего»? Потому что один из них установлен по умолчанию и не обозначается ключевым словом.

Всего в Java есть четыре модификатора доступа. Перечислим их в порядке от самых строгих до самых «мягких»:

1. private;

2. protected;

3. default (package visible);

4. public.

Private — наиболее строгий модификатор доступа. Он ограничивает видимость данных и методов пределами одного класса.

Ограничение доступа к полям и реализация геттеров-сеттеров — самый распространенный пример использования private в реальной работе.

Следующий по строгости модификатор доступа — protected.

Поля и методы, обозначенные модификатором доступа protected, будут видны:

1. в пределах всех классов, находящихся в том же пакете, что и наш;

2. в пределах всех классов-наследников нашего класса.

Модификатор package visible
Дальше у нас по списку идет модификатор default или, как его еще называют, package visible. Он не обозначается ключевым словом, поскольку установлен в Java по умолчанию для всех полей и методов.

И последний по списку, но не по значимости — модификатор public.

public создан для того, чтобы отдавать что-то пользователям. Например, интерфейс твоей программы.

Если привести пример из жизни, private — это все процессы, происходящие внутри телевизора, когда он работает, а public — это кнопки на пульте телевизора, с помощью которых пользователь может им управлять. При этом ему не нужно знать как устроен телевизор и за счет чего он работает. Пульт — это набор public-методов: on(), off(), nextChannel(), previousChannel(), increaseVolume(), decreaseVolume() и т.д.

## ООП
### Инкапсуляция
Значение слова «инкапсуляция» в программировании — объединение данных и методов работы с этими данными в одной упаковке («капсуле»).

В Java в роли упаковки-капсулы выступает класс. Класс содержит в себе и данные (поля класса), и методы для работы с этими данными.

С сокрытием данных нам помогают:

1. модификаторы доступа (private, protected, package default);

2. геттеры и сеттеры.

Использование инкапсуляции дает нам несколько важных преимуществ:

1. Контроль за корректным состоянием объекта. Примеры этому сеттеры и модификатор private, мы можем обезопасить нашу программу.

2. Удобство для пользователя за счет интерфейса. Мы оставляем «снаружи» для доступа пользователя только методы. Ему достаточно вызвать их, чтобы получить результат, и совсем не нужно вникать в детали их работы.

3. Изменения в коде не отражаются на пользователях. Все изменения мы проводим внутри методов. На пользователя это не повлияет. А то, что мы поменяли что-то в работе метода для него останется незаметным: он, как и раньше, просто будет получать нужный результат.

### Наследование
Наследование (inheritance) — механизм, который позволяет описать новый класс на основе существующего (родительского). При этом свойства и функциональность родительского класса заимствуются новым классом.

Какие выгоды это нам дает? Прежде всего — сокращение объема кода.

Вынесение общих полей и методов (еще говорят — «состояния» и «поведения») в класс-родитель позволит нам сэкономить кучу времени и места.

Возможность повторного использования кода — главное преимущество наследования.

Для программиста очень важно не писать лишний объем кода.

Крайне важную вещь: в Java нет множественного наследования. Каждый класс наследуется только от одного класса.

Механизмы композиции и агрегирования между ними заключается в «строгости» связей.

Композиция — более строгий тип связи. При использовании композиции объект не только является частью какого-то объекта, но и не может принадлежать другому объекту того же типа.

Самый простой пример — двигатель автомобиля. Двигатель является частью автомобиля, но не может быть частью другого автомобиля.

### Полиморфизм
Полиморфизм – это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта.

Подход ООП подразумевает построение Java-программы на основе взаимодействии объектов, которые базируются на классах. Классы – это заранее написанные чертежи (шаблоны), по которым будут созданы объекты в программе. Причем класс всегда имеет определенный тип, который при хорошем стиле программирования своим названием «подсказывает» о своем предназначении.

Можно отметить, что поскольку Java относится к строго типизированным языкам, в программном коде всегда нужно указать тип объекта при объявлении переменных. К этому добавим, что строгая типизация повышает безопасность кода, и надежность программы и позволяет еще на стадии компиляции предотвратить ошибки несовместимости типов (например, попытку разделить строку на число). Естественно, компилятор должен «знать» объявляемый тип – это может быть класс из JDK или созданный нами собственноручно.

При работе с программным кодом мы можем использовать не только объекты типа, который мы назначили при объявлении, но и его наследников. Это важный момент: мы можем работать со многими типами, как с одним (при условии, что эти типы являются производными от базового типа). Также это значит, что, объявив переменную типа суперкласса, мы можем присвоить ей значение одного из наследников.

Пример использования полиморфизма в Java:

```java
Dancer breakDanceDancer = new BreakDankDancer("Алексей", 19);
Dancer electricBoogieDancer = new ElectricBoogieDancer("Игорь", 20);
```
Мы объявили переменную типа суперкласса, а присвоили ей значение одного из наследников.

Почему компилятор не будет «ругаться» на несоответствие типов, объявленных слева и справа от знака присваивания, ведь в Java строгая типизация?

Тут работает восходящее преобразование типов — ссылка на объект интерпретируется, как ссылка на базовый класс. Причем компилятор, встретив в коде такую конструкцию, делает это автоматически и неявно.

На основе кода примера можно показать, что тип класса, объявленный слева от знака присваивания Dancer, имеет несколько форм (типов), объявленных справа BreakDankDancer, ElectricBoogieDancer. Каждая из форм может иметь собственное уникальное поведение для общей функциональности, определенной в суперклассе — метод dance. То есть метод, объявленный в суперклассе, может быть по-разному реализован в наследниках. В данном случае мы имеем дело с переопределением метода, а это именно то, что создает многообразие форм (поведений).

Если не использовать переопределение в наследниках, то мы не получим различного поведения.

Под полиморфизмом Java подразумевается то, что программе необязательно знать какого именно типа будет объект главное, что он — потомок класса.

И если рассуждать о потомках, следует заметить, что наследование в Java — это не только extends, но и implements.

В Java не поддерживается множественное наследование — каждый тип может иметь одного родителя (суперкласс) и неограниченное количество наследников (подклассов). Поэтому для добавления нескольких функциональностей в классы используются интерфейсы.

Интерфейсы уменьшают связанность объектов с родителем по сравнению с наследованием и используются очень широко. В Java интерфейс является ссылочным типом, поэтому в программе может быть объявлен тип переменой типа интерфейса.

Результат выполнения полиморфного метода, определенного в интерфейсе, позволяет нам увидеть различия в поведении типов, реализующих этот интерфейс. Они заключаются в разных результатах выполнения метода.

о позднем (динамическом) связывании. Под связыванием понимают установление связи между вызовом метода и его конкретной реализацией, в классах. По сути, определяется код, какого из методов, определенных в классах, будет выполнен. В Java по умолчанию используется позднее связывание (на стадии выполнения программы, а не во время компиляции, как в случае с ранним связыванием). Это значит, что при компиляции кода компилятор еще не знает, код из какого класса он будет использовать. Это определится только при выполнении программы благодаря механизму динамической диспетчеризации — проверки типа объекта во время выполнения программы и выбора нужной реализации метода для этого типа.

При загрузке и инициализации объектов JVM строит таблицы в памяти, и в них связывает переменные с их значениями, а объекты — с их методами. Причем если объект наследуется или имплементирует интерфейс, в первую очередь проверяется наличие переопределенных методов в его классе. Если таковые есть, они привязываются к этому типу, если нет – ищется метод, определенный в классе на ступень выше (в родителе) и так вплоть до корня при многоуровневой иерархии.

Рассуждая о полиморфизме в ООП и его реализации в программном коде, отметим, что хорошей практикой является использование абстрактных описаний для определения базовых классов с помощью абстрактных классов, а также интерфейсов. Эта практика основана на использовании абстракции — выделении общего поведения и свойств и заключении их в рамки абстрактного класса, или выделении только общего поведения – в таком случае мы создаем интерфейс.

Построение и проектирование иерархии объектов на основе интерфейсов и наследовании классов является обязательным условием для выполнения принципа полиморфизма ООП.

При создании абстрактных классов и интерфейсов, начиная с Java 8, есть возможность написания дефолтной реализации абстрактных методов в базовых классах с помощью ключевого слова default.

Требованиях к объявлению методов в базовых классах, чтобы не нарушался принцип полиморфизма. Эти методы не должны быть static, private и final. Рrivate делает метод доступным только в классе, и вы не сможете его переопределить в наследнике. Static делает метод достоянием класса, а не объекта, поэтому всегда будет вызываться метод суперкласса. Final же сделает метод неизменяемым и скрытым от наследников.

Что нам даёт полиморфизм в Java?

1. Позволяет подменять реализации объектов. На этом основано тестирование.

2. Обеспечивает расширяемость программы — становится гораздо легче создавать задел на будущее. Добавление новых типов на основе существующих — наиболее частый способ расширения функциональности программ, написанных в ООП стиле.

3. Позволяет объединять объекты с общим типом или поведением в одну коллекцию или массив и управлять ими единообразно.

4. Гибкость при создании новых типов: вы можете выбирать реализацию метода из родителя или переопределить его в потомке.

### Интерфейсы
Интерфейсы в Java определяют некоторый функционал, не имеющий конкретной реализации, который затем реализуют классы, применяющие эти интерфейсы. Один класс может применить множество интерфейсов.

Все, к чему пользователь имеет доступ — это интерфейс.

Создание интерфейса очень похоже на создание обычного класса, только вместо слова class мы указываем слово interface.

Интерфейс описывает поведение, которым должны обладать классы, реализующие этот интерфейс. «Поведение» — это совокупность методов.

Вместо того, чтобы указывать конкретный класс, мы просто упоминаем, что он есть. Какой именно — определится в ходе работы программы.

Интерфейс описывает поведение, а не реализует его.

Например, в твоем интерфейсе есть 10 методов. 9 из них реализованы по-разному в разных классах, но один реализован одинаково у всех. Раньше, до выхода Java8, методы внутри интерфейсов вообще не имели реализации: компилятор сразу выдавал ошибку.
![javaCore_table_6.jpg](files%2Fstatic%2FjavaCore_table_6.jpg)
На этой схеме ты можешь увидеть одну особенность: интерфейсы могут быть унаследованы друг от друга. Интерфейс SortedMap унаследован от Map, а Deque наследуется от очереди Queue. Это нужно, если ты хочешь показать связь интерфейсов между собой, но при этом один интерфейс является расширенной версией другого.