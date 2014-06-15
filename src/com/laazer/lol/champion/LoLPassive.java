package com.laazer.lol.champion;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.common.Box;
import com.laazer.lol.LoLObject;

public class LoLPassive extends LoLObject{
    String description;
    LoLImage image;
    String name;
    String sanitizedDescription;
    public LoLPassive() {}
    
    public static Box<LoLPassive> genPassive(JSONObject jobj) {
        try {
            LoLPassive pas = new LoLPassive();
            pas.description = jobj.getString("description");
            pas.image = LoLImage.genImage(jobj.getJSONObject("image"));
            pas.name = jobj.getString("name");
            pas.sanitizedDescription = jobj.getString("sanitizedDescription");
            return Box.fill(pas);
        }catch(JSONException e) {
            return Box.EMPTY;
        }
    }
}
