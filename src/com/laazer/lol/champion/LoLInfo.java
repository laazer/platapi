package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLInfo extends LoLObject{
    int attack;
    int defense;
    int difficulty;
    int magic;
    
    public static LoLInfo genLoLSkin(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), new LoLInfo().getClass());
    }
}
