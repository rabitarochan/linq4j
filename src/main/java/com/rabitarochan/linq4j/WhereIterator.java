package com.rabitarochan.linq4j;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class WhereIterator<T> extends LinqIterator<T> {

  private final Iterator<T> _iterator;
  private final Predicate<T> _predicate;
  
  private T preValue = null;
  
  public WhereIterator(LinqIterator<T> xs, Predicate<T> predicate) {
    _iterator = xs;
    _predicate = predicate;
  }

  @Override
  public boolean hasNext() {
    while (_iterator.hasNext()) {
      preValue = _iterator.next();
      if (_predicate.test(preValue)) {
        return true;
      }
      
      preValue = null;
    }
    
    return false;
  }

  @Override
  public T next() {
    if (preValue != null) {
      T v = preValue;
      preValue = null;
      return v;
    }
    
    while (_iterator.hasNext()) {
      preValue = _iterator.next();
      if (_predicate.test(preValue)) {
        T v = preValue;
        preValue = null;
        return v;
      }
      
      preValue = null;
    }
    
    throw new NoSuchElementException();
  }

}

@FunctionalInterface
interface WhereFunction<T> {
  boolean f(T value);
}