package com.laazer.lol.champion;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLLevelTip extends LoLObject{
    List<String> effect;
    List<String> lable;
    
    public LoLLevelTip genLevelTip(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), this.getClass());
    }
}
