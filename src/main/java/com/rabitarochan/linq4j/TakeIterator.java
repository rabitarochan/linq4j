package com.rabitarochan.linq4j;

import java.util.NoSuchElementException;

public class TakeIterator<T> extends LinqIterator<T> {

  private final LinqIterator<T> iterator;
  private int current = 0;
  private final int count;
  
  public TakeIterator(LinqIterator<T> iterator, int count) {
    this.iterator = iterator;
    this.count = count;
  }
  
  @Override
  public boolean hasNext() {
    if (current >= count) return false;
    
    return this.iterator.hasNext();
  }

  @Override
  public T next() {
    if (current >= count) throw new NoSuchElementException();
    
    this.current += 1;
    return this.iterator.next();
  }

}
