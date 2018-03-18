package com.itcast.basic.jdk.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by qfl on 2018/3/18.
 */
public class StreamClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into StreamClient");
            List<Person> list = Arrays.asList(new Person[]{
                    new Person("admin", 20, 10000, 1),
                    new Person("treey", 10, 2000000000, 2),
                    new Person("lily", 55, 30000000, 3),
                    new Person("lucy", 33, 4000000, 4),
                    new Person("root", 45, 55555555555l, 5),
                    new Person("root", 15, 7878896497972546794l, 6),
                    new Person("root", 24, 8914579274981254l, 7),
                    new Person("root", 27, 4979749797979797l, 8),
                    new Person("root", 66, 999999999999999999l, 9),
                    new Person("root", 66, 999999999999999999l, 9)
            });

            Person min = list.stream().min((Person source, Person target) -> (source.getAge() - target.getAge())).get();
            Person max = list.stream().max((Person source, Person target) -> (source.getAge() - target.getAge())).get();

            long size = list.stream().distinct().count();
            System.out.println("min=" + min + " max=" + max + " size=" + size);

            boolean isEqu = new Person("root", 66, 999999999999999999l, 9).equals(new Person("root", 66, 999999999999999999l, 9));
            System.out.println("isEqu=" + isEqu);

            long total = list.stream()
                    .distinct()
                    .map(person -> person.getAmount())
                    .reduce((result, amount) -> result + amount).get();
            System.out.println("total=" + total);

            list.stream()
                    .sorted((Person source, Person target) -> (source.getAge() - target.getAge()))
                    .filter(person -> person.getAge() > 5)
                    .map(person -> person.getName())
                    .skip(1)
                    .limit(5)
                    .peek((String s) -> System.out.println("name=" + s))
                    .collect(Collectors.toList());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
