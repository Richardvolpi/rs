/*
 *      Queue.java
 *
 *      A thread safe collection to temp collect data.
 */

package org.apello.util;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    // create a queue which can hold an unlimited number of objects.
    public Queue(){
        this(0);
    }
    
    //create a queue with a max number of objects, 0 for infinite.
    public Queue(int maxS){
        queue = new ArrayList<T>();    
        maxSize = maxS;
    }
    
    private ArrayList<T> queue;
    private int maxSize = 0;
    
    //add object of type T to queue
    public void add(T s){
        if(maxSize > 0 && size() > maxSize)
            return;
        synchronized(queue){
            queue.add(s);
        }
    }
    
    //the number of objects currently in this Queue
    public int size(){
        return queue.size();
    }
    
    // return the queue current collection, and clear the queue
    public List<T> getQueue(){
        List<T> tmpList;
        if(size() == 0)
            return (List<T>)(new ArrayList<T>()); 
        synchronized (queue) {
            tmpList = (List<T>)queue.clone();
            queue.clear();
        }
        return tmpList;
    }
}
