package com.laazer.lol.champion;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.json.parsers.JSONParser;
import com.laazer.common.Box;
import com.laazer.common.Functions;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.lol.LoLObject;
import com.laazer.common.UniFunction;
import com.laazer.lol.LoLUtils;

public class LoLChampSpell extends LoLObject{
    public List<LoLImage> altImages;
    public List<Double> cooldown;
    public String coolDownBurn, costBurn, costType, description;
    public List<List<Integer>> effect;
    public List<String> effectBurn;
    public LoLImage image;
    public String key;
    public LoLLevelTip levelTip;
    public int maxrank;
    public String name;
    public Box<Integer> range;
    public String rangeBurn, resource, sanitizedDescription, sanitizedTooltip, tooltip;
    public List<LoLSpellVars> vars;
    
    public LoLChampSpell() {}
    
    public static Box<LoLChampSpell> genChampSpell(String obj) {
        try {
              Map<String, Object> lobj = new JSONParser().parseJson(obj);
              LoLChampSpell cs = new LoLChampSpell();
              cs.altImages = ListUtils.map(ListUtils.toList.apply(lobj.get("altimages")), LoLUtils.toImage);
              cs.cooldown = ListUtils.map(ListUtils.toList.apply(("cooldown")), Functions.toDouble);
              cs.coolDownBurn = lobj.get("cooldownburn").toString();
              cs.costBurn = lobj.get("costburn").toString();
              cs.description = lobj.get("description").toString();
              cs.effect = ListUtils.map(ListUtils.toList.apply(lobj.get("effect")), ListUtils.toIntList);
              cs.effectBurn = ListUtils.toStringList.apply(lobj.get("effectburn"));
              cs.image = LoLImage.genImage(lobj.get("image").toString());
              cs.key = lobj.get("key").toString();
              cs.levelTip = LoLLevelTip.genLevelTip(lobj.get("leveltip").toString());
              cs.maxrank = Functions.toInt.apply(lobj.get("maxrank"));
              cs.name = lobj.get("name").toString();
              cs.range = Box.fill(lobj.get("range")).map(Functions.toInt);
              cs.rangeBurn = lobj.get("rangeburn").toString();
              cs.resource = lobj.get("resources").toString();
              cs.sanitizedDescription = lobj.get("sanatizeddescription").toString();
              cs.sanitizedTooltip = lobj.get("sanatizedtooltip").toString();
              cs.tooltip = lobj.get("tooltip").toString();
              cs.vars = ListUtils.map(ListUtils.toList.apply(lobj.get("vars")), LoLUtils.toSpellVar);
              return Box.fill(cs);
        } catch(IllegalArgumentException e) {
            return Box.EMPTY;
        }
          
      }
    
    
}

