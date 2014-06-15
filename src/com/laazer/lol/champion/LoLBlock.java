package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;

import com.json.parsers.JSONParser;
import com.laazer.common.*;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;

public class LoLBlock extends LoLObject{
    public List<LoLBlockItem> items;
    public boolean recMath;
    public String type;
    
    public static Box<LoLBlock> genBlock(String obj) {
       try { 
            Map<String, Object> lobj = new JSONParser().parseJson(obj);
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
}
