package com.laazer.lol.champion;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import com.laazer.common.Box;
import com.laazer.common.Functions;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.lol.LoLObject;
import com.laazer.common.UniFunction;
import com.laazer.lol.LoLUtils;

public class LoLChampSpell extends LoLObject{
    List<LoLImage> altImages;
    List<Double> cooldown;
    String coolDownBurn;
    String costBurn;
    String costType;
    String description;
    List<List<Integer>> effect;
    List<String> effectBurn;
    LoLImage image;
    String key;
    LoLLevelTip levelTip;
    int maxrank;
    String name;
    Box<Integer> range;
    String rangeBurn;
    String resource;
    String sanitizedDescription;
    String sanitizedTooltip;
    String tooltip;
    List<LoLSpellVars> vars;
    
    public LoLChampSpell() {}
    
    public static Box<LoLChampSpell> genChampSpell(JSONObject obj) {
      try {
            LoLChampSpell cs = new LoLChampSpell();
            cs.altImages = JSONUtils.mappedList(obj.getJSONArray("altimages"), LoLUtils.toImage);
            cs.cooldown = JSONUtils.mappedList(obj.getJSONArray("cooldown"), Functions.toDouble);
            cs.coolDownBurn = obj.getString("cooldownburn");
            cs.costBurn = obj.getString("costburn");
            cs.description = obj.getString("description");
            cs.effect = JSONUtils.mappedList(obj.getJSONArray("effect"), ListUtils.toIntList);
            cs.effectBurn = JSONUtils.mappedList(obj.getJSONArray("effectburn"), Functions.toString);
            cs.image = LoLImage.genImage(obj.getJSONObject("image"));
            cs.key = obj.getString("key");
            cs.levelTip = new LoLLevelTip().genLevelTip(obj.getJSONObject("leveltip"));
            cs.maxrank = obj.getInt("maxrank");
            cs.name = obj.getString("name");
            cs.range = JSONUtils.safeUnpack(obj, "range", Functions.toInt);
            cs.rangeBurn = obj.getString("rangeburn");
            cs.resource = obj.getString("resources");
            cs.sanitizedDescription = obj.getString("sanatizeddescription");
            cs.sanitizedTooltip = obj.getString("sanatizedtooltip");
            cs.tooltip = obj.getString("tooltip");
            cs.vars = JSONUtils.mappedList(obj.getJSONArray("vars"), LoLUtils.toSpellVar);
            return Box.fill(cs);
      } catch(JSONException e) {
          return Box.EMPTY;
      }
        
    }
    
    
}

