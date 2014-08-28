package com.laazer.lol.champion;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laazer.common.Box;
import com.laazer.lol.LoLObject;

public class LoLPassive extends LoLObject{
    private String description;
    private LoLImage image;
    private String name, sanitizedDescription;
    public LoLPassive() {}
    
    public static Box<LoLPassive> genPassive(Map<String, Object> lobj) {
        try {
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

    public static LoLPassive generate(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new LoLPassive().getClass());
    }

    public String getDescription() { return description;}
    public LoLImage getImage() {return image;}
    public String getName() {return name;}
    public String getSanitizedDescription() {return sanitizedDescription;}
    
}
