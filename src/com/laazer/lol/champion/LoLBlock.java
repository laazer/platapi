package com.laazer.lol.champion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laazer.common.*;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;

public class LoLBlock extends LoLObject{
    private List<LoLBlockItem> items;
    private boolean recMath;
    private String type;
    
    public static Box<LoLBlock> genBlock(String obj) {
       try { 
            Map<String, Object> lobj = new Gson().fromJson(obj, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            LoLBlock lb = new LoLBlock();
            lb.items = ListUtils.map(ListUtils.toList.apply(lobj.get("items")), LoLUtils.toBlockItem);
            lb.recMath = Functions.toBoolean.apply(lobj.get("recmath"));
            lb.type = lobj.get("type").toString();
            return Box.fill(lb);
       }catch (IllegalArgumentException e) {
           e.printStackTrace();
           return Box.EMPTY;
       }
    }

    public List<LoLBlockItem> getItems() {return items;}
    public boolean isRecMath() {return recMath;}
    public String getType() {return type;}
    
}
