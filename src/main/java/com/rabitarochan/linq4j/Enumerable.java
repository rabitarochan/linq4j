package com.rabitarochan.linq4j;

import java.util.ArrayList;
import java.util.List;

public class Enumerable {

  public static <T> LinqIterator<T> fromList(List<T> xs) {
    return new ListIterator<>(xs);
  }
  
  public static LinqIterator<Integer> range(int start, int count) {
    return new RangeIterator(start, count);
  }

  public static void main(String[] args) {
    List<String> xs = new ArrayList<>();
    xs.add("aaa");
    xs.add("bbbbb");
    xs.add("abba");
    
    List<String> it = Enumerable.fromList(xs)
                                .where(s -> s.startsWith("a"))
                                .take(1)
                                .toList();
    for (String s : it) {
      System.out.println(s);
    }
    
    Enumerable.range(1, 2147483646)
              .where(i -> i % 100 == 0)
              .take(10)
              .forEach(i -> System.out.println(i));
  }

}
