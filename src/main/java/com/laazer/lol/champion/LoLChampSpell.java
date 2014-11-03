package com.laazer.lol.champion;
import java.util.DoubleSummaryStatistics;
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
    private List<List<Double>> effect;
    private List<String> effectBurn;
    private LoLImage image;
    private String key;
    private LoLLevelTip levelTip;
    private int maxrank;
    private String name;
    private Object range;
    private String rangeBurn, resource, sanitizedDescription, sanitizedTooltip, tooltip;
    private List<LoLSpellVars> vars;
    
    public LoLChampSpell() {}

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
    public List<List<Double>> getEffect() {return effect;}
    public List<String> getEffectBurn() {return effectBurn;}
    public LoLImage getImage() {return image;}
    public String getKey() {return key;}
    public LoLLevelTip getLevelTip() {return levelTip;}
    public int getMaxrank() {return maxrank;}
    public String getName() { return name;}
    public Box<List<Integer>> getRange() {
        return toRange(this.range);
    }
    public String getRangeBurn() {return rangeBurn;}
    public String getResource() {return resource;}
    public String getSanitizedDescription() {return sanitizedDescription;}
    public String getSanitizedTooltip() {return sanitizedTooltip;}
    public String getTooltip() {return tooltip;}
    public List<LoLSpellVars> getVars() {return vars;}

    private static Box<List<Integer>> toRange(Object range) {
        try {
           return Box.fill(ListUtils.toIntList.apply(range));
        } catch (Exception e) {
            return Box.EMPTY;
        }
    }

}

