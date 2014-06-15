package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.json.parsers.*;
import com.laazer.common.Box;
import com.laazer.common.UniFunction;
import com.laazer.common.Functions;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.common.UrlManager;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;
import com.laazer.lol.Region;
import java.lang.Class;

public class LoLChampion extends LoLObject{
    final static String LocURL = LoLObject.URL + "static-data/"+ Region.NA +"/v1.2/champion/";
    public int id;
    public String key, name, title, blurb, lore, partype;;
    public List<String> allyTips, enemyTips, tags;
    public LoLImage image;
    public LoLInfo info;
    public Box<LoLPassive> passive;
    public List<LoLRecommended> recommended;
    public List<LoLSkin> skins;
    public List<Box<LoLChampSpell>> spells;
    public LoLStats stats;
    
    LoLChampion() {}
    
    private static String simpleTypes = "blurb,lore,partype";
    private static String simpleLists = "allytips,enemytips,tags";
    private static String IMAGE = "image";
    private static String INFO = "info";
    private static String PASSIVE = "passive";
    private static String RECOMMEDED = "recommended";
    private static String SKINS = "skins";
    private static String SPELLS = "spells";
    private static String STATS = "stats";
    
    private static Map<String, Object> generateJson(int id, Box<String> args) {
        //TODO remove print lines
        JSONParser parser = new JSONParser();
        String myArgs = "";
        if (args.isFull()) myArgs = args.get();
        String url = LocURL + id + "?champData="+ myArgs + "&" + LoLObject.KEY;
        Map<String, Object> map = (Map<String,Object>) parser.parseJson(UrlManager.executeGet(url).get());
        return map;
    }
    
    private static String generateJsonAsString(int id) {
        String url = LocURL + id + "?champData=all&" + LoLObject.KEY;
        return UrlManager.executeGet(url).get();
    }
        
    public static Box<LoLChampion> genChampion(int id) {
        try {
            LoLChampion champ = new LoLChampion();
            Map<String, Object> sobj = generateJson(id, Box.fill(simpleTypes));
            Map<String, Object> lobj = generateJson(id, Box.fill(simpleLists));
            champ.id = id;
            champ.key = sobj.get("key").toString(); champ.name = sobj.get("name").toString();
            champ.title = sobj.get("title").toString(); champ.blurb = sobj.get("blurb").toString(); 
            champ.allyTips = ListUtils.map(ListUtils.toList.apply(lobj.get("allytips")), Functions.toString);
            champ.enemyTips = ListUtils.map(ListUtils.toList.apply(lobj.get("enemytips")), Functions.toString);
            champ.image = LoLImage.genImage(generateJson(id, Box.fill(IMAGE)).get("image").toString()); 
            champ.lore = sobj.get("lore").toString();
//            champ.recommended = JSONUtils.mappedList(generateJson(id, Box.fill(RECOMMEDED)).getJSONArray("recommended"), LoLUtils.toRecommended);
//            champ.passive = LoLPassive.genPassive(generateJson(id, Box.fill(PASSIVE)).getJSONObject("passive"));
            champ.partype = sobj.get("partype").toString();
//            champ.skins = JSONUtils.mappedList(generateJson(id, Box.fill(SKINS)).getJSONArray("skins"), LoLUtils.toSkin);
//            champ.spells = JSONUtils.mappedList(generateJson(id, Box.fill(SPELLS)).getJSONArray("spells"), LoLUtils.toChampSpell);
            champ.stats = LoLStats.genLoLStats(generateJson(id, Box.fill(STATS)).get("stats").toString());
            champ.tags = ListUtils.map(ListUtils.toList.apply(lobj.get("tags")), Functions.toString);
            return Box.fill(champ);
        } catch(Exception e) {
            e.printStackTrace();
            return Box.EMPTY;
        }
    }
    
    //TODO make a quick and dirty method for freeToPlay (joking about the dirty part)
    public Boolean freeToPlay() {return false;}
    
}
