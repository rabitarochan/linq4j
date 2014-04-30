package com.rabitarochan.linq4j;

import java.util.Iterator;
import java.util.List;

public class ListIterator<T> extends LinqIterator<T> {

  private final Iterator<T> iterator;
  
  public ListIterator(List<T> xs) {
    iterator = xs.iterator();
  }
  
  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public T next() {
    return iterator.next();
  }

}
