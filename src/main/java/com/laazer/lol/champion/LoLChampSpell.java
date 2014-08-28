package com.laazer.lol.champion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.laazer.common.Box;
import com.laazer.common.Functions;
import com.laazer.common.ListUtils;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;

public class LoLChampSpell extends LoLObject{
    private List<LoLImage> altImages;
    private List<Double> cooldown;
    private String coolDownBurn, costBurn, costType, description;
    private List<List<Integer>> effect;
    private List<String> effectBurn;
    private LoLImage image;
    private String key;
    private LoLLevelTip levelTip;
    private int maxrank;
    private String name;
    private String range;
    private String rangeBurn, resource, sanitizedDescription, sanitizedTooltip, tooltip;
    private List<LoLSpellVars> vars;
    
    public LoLChampSpell() {}
    
    public static Box<LoLChampSpell> genChampSpell(String obj) {
        try {
              Map<String, Object> lobj = new Gson().fromJson(obj, new TypeToken<HashMap<String, Object>>(){}.getType());
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
              cs.range = lobj.get("range").toString();
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

    public static LoLChampSpell generate(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new LoLChampSpell().getClass());
    }

    public List<LoLImage> getAltImages() {return altImages;}
    public List<Double> getCooldown() { return cooldown;}
    public String getCoolDownBurn() {return coolDownBurn;}
    public String getCostBurn() {return costBurn;}
    public String getCostType() {return costType;}
    public String getDescription() {return description;}
    public List<List<Integer>> getEffect() {return effect;}
    public List<String> getEffectBurn() {return effectBurn;}
    public LoLImage getImage() {return image;}
    public String getKey() {return key;}
    public LoLLevelTip getLevelTip() {return levelTip;}
    public int getMaxrank() {return maxrank;}
    public String getName() { return name;}
    public String getRange() {return range;}
    public String getRangeBurn() {return rangeBurn;}
    public String getResource() {return resource;}
    public String getSanitizedDescription() {return sanitizedDescription;}
    public String getSanitizedTooltip() {return sanitizedTooltip;}
    public String getTooltip() {return tooltip;}
    public List<LoLSpellVars> getVars() {return vars;}
    
}

