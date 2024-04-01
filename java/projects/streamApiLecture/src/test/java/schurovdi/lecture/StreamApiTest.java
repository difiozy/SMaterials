package schurovdi.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamApiTest {

    List<Integer> intList;

    @BeforeEach
    void setUp() {
        intList = createIntList();
    }

    @Test
    void forEachPrint() {
        intList.forEach(System.out::println);
    }

    @Test
    void calculateSum() {
        Integer reduceResult = intList.stream()
                .reduce(0, Integer::sum);

        int accumulate = 0;
        for (Integer integer : intList) {
            accumulate += integer;
        }

        assert reduceResult == accumulate;
    }

    @Test
    void findFirst() {
        Optional<Integer> first = intList.stream()
                .findFirst();
        System.out.println(first);
    }

    @Test
    void filter() {
        List<Integer> result = intList.stream()
                .filter(el -> el > 5)
                .toList();
        System.out.println(result);
    }

    @Test
    void filterWithFindFirst() {
        Optional<Integer> first = intList.stream()
                .filter(el -> el > 5)
                .findFirst();
        System.out.println(first);
    }

    @Test
    void flatMap() {
        List<List<Integer>> list = Stream.iterate(1, el -> el + 1)
                .limit(5)
                .map(el -> createIntList())
                .toList();

        System.out.println("First list");
        list.forEach(System.out::println);


        List<Integer> flatMapStream = Stream.iterate(1, el -> el + 1)
                .limit(5)
                .map(el -> createIntList())
                .flatMap(Collection::stream)
                .toList();

        System.out.println("\nSecond list");
        System.out.println(flatMapStream);
    }

    @Test
    void listToMap() {
        Random random = new Random();
        Map<Integer, Integer> collect =
                createIntList().stream()
                        .collect(
                                Collectors.toMap(
                                        el -> el,
                                        el -> random.nextInt(200)
                                ));
        System.out.println(collect);
    }

    @Test
    void distinct() {
        List<Integer> exampleMap = Stream.iterate(1, el -> el + 1)
                .limit(5)
                .map(el -> createIntList())
                .flatMap(Collection::stream)
                .toList();
        System.out.println(exampleMap);

        List<Integer> resultList = Stream.iterate(1, el -> el + 1)
                .limit(5)
                .map(el -> createIntList())
                .flatMap(Collection::stream)
                .distinct()
                .toList();
        System.out.println(resultList);
    }

    private List<Integer> createIntList() {
        return Stream.iterate(1, el -> el + 1)
                .limit(10)
                .toList();
    }

}