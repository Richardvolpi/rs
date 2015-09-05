/*
 *      DataTable.java
 *
 *      A thread safe hashmap like collection. 
 *
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 *     THIS IS AN EPIC FAIL, DO NOT USE!!!!!!!
 */

package org.apello.util;

import java.util.ArrayList;

public class DataTable<KEY, VAL> {
    public DataTable(){        
        keys = new ArrayList<KEY>();
        values = new ArrayList<VAL>();
    }
    
    private ArrayList<KEY> keys;
    private ArrayList<VAL> values;
    
    public int size(){
        return keys.size();
    }
    
    public KEY[] getKeys(){
        return size() > 0 ? (KEY[])keys.toArray() : null;
    }
    
    public KEY getKey(int idx){
        if(idx < 0 || idx > keys.size())
            return null;
        return keys.get(idx);
    }

    public VAL get(KEY k){
        for(int i = 0; i < keys.size(); i++)
            if(keys.get(i).equals(k))
                return values.get(i);
        return null;
    }
    
    public VAL[] getValues(){
        return size() > 0 ? (VAL[])values.toArray() : null;
    }
    
    public boolean add(KEY k, VAL o){
        synchronized(keys){
            synchronized(values){
                int idx = keys.indexOf(k);
                if(idx > -1){
                    try{
                        keys.set(idx, k);
                        values.set(idx, o);
                        return true;
                    }catch(Exception e){
                        return false;
                    }
                }else{
                    keys.add(k);
                    return values.add(o);
                }
            }
        }
    }
    
    public VAL remove(KEY k){
        if(k == null)
            return null;
        return remove(k, get(k));
    }
    
    public VAL remove(KEY k, VAL o){
        if(k ==  null || o == null || !containsKey(k) || !containsVal(o))
            return null;
        synchronized(keys){
            synchronized(values){
               keys.remove(k);
               values.remove(o); 
               return o;
            }
        }
    }
    
    public boolean containsKey(KEY k){
        return keys.contains(k);
    }
    
    public boolean containsVal(VAL v){
        return values.contains(v);
    }
}
