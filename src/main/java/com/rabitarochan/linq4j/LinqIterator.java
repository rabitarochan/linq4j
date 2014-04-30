package com.rabitarochan.linq4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public abstract class LinqIterator<T> implements Iterator<T>, Iterable<T> {

  public LinqIterator<T> where(Predicate<T> predicate) {
    return new WhereIterator<T>(this, predicate);
  }
  
  public LinqIterator<T> take(int count) {
    return new TakeIterator<>(this, count);
  }
  
  public List<T> toList() {
    List<T> xs = new ArrayList<>();
    for (T value : this) {
      xs.add(value);
    }
    return xs;
  }
 
  @Override
  public Iterator<T> iterator() {
    return this;
  }
}
