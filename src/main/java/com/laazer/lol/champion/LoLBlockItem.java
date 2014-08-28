package com.laazer.lol.champion;

import com.google.gson.Gson;

public class LoLBlockItem {
    private int count, id;
    
    public static LoLBlockItem genBlockItem(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLBlockItem().getClass());
    }

    public int getCount() {return count;}
    public int getId() {return id;}
}
