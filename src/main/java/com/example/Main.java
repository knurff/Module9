package com.example;

import com.example.map.Map;
import com.example.map.MyHashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new MyHashMap<>();
        System.out.println(map.put(5, "qqq"));
        System.out.println(map.get(5));
        System.out.println(map.remove(5));
    }
}
