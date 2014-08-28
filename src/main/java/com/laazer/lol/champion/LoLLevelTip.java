package com.laazer.lol.champion;

import java.util.List;
import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLLevelTip extends LoLObject{
    private List<String> effect;
    private List<String> lable;
    
    public static LoLLevelTip genLevelTip(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLLevelTip().getClass());
    }

    public List<String> getEffect() {return effect;}
    public List<String> getLable() {return lable;}
}
