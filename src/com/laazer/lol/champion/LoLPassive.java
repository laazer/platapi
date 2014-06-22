package com.laazer.lol.champion;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.json.parsers.JSONParser;
import com.laazer.common.Box;
import com.laazer.lol.LoLObject;

public class LoLPassive extends LoLObject{
    private String description;
    private LoLImage image;
    private String name, sanitizedDescription;
    public LoLPassive() {}
    
    public static Box<LoLPassive> genPassive(String jobj) {
        try {
            Map<String, Object> lobj = new JSONParser().parseJson(jobj);
            LoLPassive pas = new LoLPassive();
            pas.description = lobj.get("description").toString();
            pas.image = LoLImage.genImage(lobj.get("image").toString());
            pas.name = lobj.get("name").toString();
            pas.sanitizedDescription = lobj.get("sanitizedDescription").toString();
            return Box.fill(pas);
        }catch(IllegalArgumentException e) {
            return Box.EMPTY;
        }
    }

    public String getDescription() { return description;}
    public LoLImage getImage() {return image;}
    public String getName() {return name;}
    public String getSanitizedDescription() {return sanitizedDescription;}
    
}
