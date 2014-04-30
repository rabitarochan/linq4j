package com.rabitarochan.linq4j;

import java.util.NoSuchElementException;

public class RangeIterator extends LinqIterator<Integer> {

  private int current;
  private final long stop;
  
  public RangeIterator(int start, int count) {
    this.current = start;
    this.stop = start + count;
  }
  
  @Override
  public boolean hasNext() {
    if (this.current >= this.stop) return false;
    
    return true;
  }

  @Override
  public Integer next() {
    if (this.current >= this.stop) throw new NoSuchElementException();
    
    return current++;
  }

}
