package com.laazer.lol.champion;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.laazer.common.JSONUtils;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;

public class LoLBlock extends LoLObject{
    List<LoLBlockItem> items;
    boolean recMath;
    String type;
    
    public LoLBlock genBlock(JSONObject obj) throws JSONException {
        LoLBlock lb = new LoLBlock();
        lb.items = JSONUtils.mappedList(obj.getJSONArray("items"), LoLUtils.toBlockItem);
        lb.recMath = obj.getBoolean("recmath");
        lb.type = obj.getString("type");
        return lb;
    }
}
