package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;

public class LoLBlockItem {
    int count, id;
    
    public static LoLBlockItem genBlockItem(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), new LoLBlockItem().getClass());
    }
}
