package com.laazer.lol.champion;

import java.util.List;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLSpellVars extends LoLObject{
    List<Double> coeff;
    String dyn, key, link, ranksWith;
    public LoLSpellVars() {}
    
    public static LoLSpellVars genSpellVars(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), new LoLSpellVars().getClass());
    }
    
}
