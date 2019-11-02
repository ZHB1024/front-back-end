package com.forever.zhb.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KeyValueVO<T,V> {
    
    private T key;
    private V value;
    
    public KeyValueVO() {
    }
    
    public KeyValueVO(T key,V value){
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public String toString() {
        return "key:" + this.key + ",value:" + this.value;
    }

}
