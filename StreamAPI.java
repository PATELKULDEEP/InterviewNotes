import java.util.*;
import java.util.stream.Collectors;

public record StreamAPI() {
    public static void main(String[] args) {
        System.out.println("Stream API Questions");
        FilterEvenNumber();
        SqueareEachNumber();
        FindFirstGreaterElementThan3();
        CountElementGreaterThan3();
        FindMaxMin();
        RemoveDuplicateElement();
        SumOfAllNumber();
        FindSecondHighestNumber();
        GroupWordsByLength();
        FindFrequencyByCharacters();
    }

    public static void FilterEvenNumber(){
        System.out.println("Filter Even Number");
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        //list.stream().filter(value -> value % 2 == 0).forEach(System.out::println);
        list.stream().filter(value -> value % 2 == 0).forEach(value -> System.out.println(value));
    }

    public static void SqueareEachNumber(){
        System.out.println("Squeare Each Number");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //list.stream().map(value -> value*value).forEach(value -> System.out.println(value));
        List<Integer> result = list.stream().map(value -> value * value).toList();

        System.out.println(result);
    }

    public static void FindFirstGreaterElementThan3(){
        System.out.println("Find the First Greater Element Than 3");
        List<Integer> list = List.of(1,2,3,4,5,7);

        Optional<Integer> answer = list.stream().filter(value -> value > 3).findFirst();
        answer.ifPresent(System.out::println);
        //list.stream().filter(value -> value > 3).findFirst().ifPresent(value -> System.out.println(value));
    }

    public static void CountElementGreaterThan3(){
        System.out.println("Count Element Greater Than 3");

        List<Integer> list = List.of(3,4,5,6,7,2);

        long answer = list.stream().filter(value -> value > 3).count();

        System.out.println(answer);
    }

    public static void FindMaxMin(){

        List<Integer> list = List.of(2,3,4,5,6,9);

        //int max = list.stream().max(Integer::compareTo).get();
        int max = list.stream().max((a,b) -> a.compareTo(b)).get();
        //int min = list.stream().min(Integer::compareTo).get();
        int min = list.stream().min((a,b) -> a.compareTo(b)).get();
        System.out.println(max + " "+ min);
    }

    public static void RemoveDuplicateElement(){
        List<Integer> list = List.of(2,2,4,5,7,8,7);

        List<Integer> unique = list.stream().distinct().toList();

        System.out.println(unique);
    }

    public static void SumOfAllNumber(){
        List<Integer> list = List.of(2,3,4,1);

        //int sum = list.stream().reduce(0,Integer :: sum);
        int sum = list.stream().reduce(0, (a,b) -> a + b);
        System.out.println(sum);
    }

    public static void FindSecondHighestNumber(){
        List<Integer> list = List.of(2,3,5,7,1,9,8);

        int secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(secondHighest);
    }

    public static void GroupWordsByLength(){
        List<String> words = List.of("java","Kuldeep","temp","cost","Learning","InProgress");

        Map<Integer,List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    public static void FindFrequencyByCharacters(){
        String str = "banana";

        Map<Character, Long> freq = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(freq);
    }

}
