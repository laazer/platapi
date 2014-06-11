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
    int id;
    boolean freeToPlay;
    String key, name, title, blurb, lore, partype;;
    List<String> allyTips, enemyTips, tags;
    LoLImage image;
    LoLInfo info;
    Box<LoLPassive> passive;
    List<LoLRecommended> recommended;
    List<LoLSkin> skins;
    List<Box<LoLChampSpell>> spells;
    LoLStats stats;
    
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
    
    private static Map<String, String> generateJson(int id, Box<String> args) {
        //TODO remove print lines
        JSONParser parser = new JSONParser();
        String myArgs = "";
        if (args.isFull()) myArgs = args.get();
        String url = LocURL + id + "?champData="+ myArgs + "&" + LoLObject.KEY;
        System.out.println(url);
        Map<String, String> map = (Map<String,String>) parser.parseJson(UrlManager.executeGet(url).get());
        System.out.println(map);
        return map;
    }
    
    private static String generateJsonAsString(int id) {
        String url = LocURL + id + "?champData=all&" + LoLObject.KEY;
        System.out.println(url);
        String jobj = UrlManager.executeGet(url).get();
        return jobj;
    }
    
    public static Box<LoLChampion> genChampion(JSONObject obj) {
        try {
            LoLChampion champ = new LoLChampion();
            champ.id = obj.getInt("id");
            champ.freeToPlay = /*obj.getBoolean("freetoplay");*/ false;
            champ.key = obj.getString("key"); champ.name = obj.getString("name");
            champ.title = obj.getString("title"); champ.blurb = obj.getString("blurb"); 
            champ.allyTips = JSONUtils.mappedList(obj.getJSONArray("allytips"), Functions.toString);
            champ.enemyTips = JSONUtils.mappedList(obj.getJSONArray("enemytips"), Functions.toString);
            champ.image = LoLImage.genImage(obj.getJSONObject("image")); 
            champ.lore = obj.getString("lore");
            champ.recommended = JSONUtils.mappedList(obj.getJSONArray("recommended"), LoLUtils.toRecommended);
            champ.passive = LoLPassive.genPassive(obj.getJSONObject("passive"));
            champ.partype = obj.getString("partype");
            champ.skins = JSONUtils.mappedList(obj.getJSONArray("skins"), LoLUtils.toSkin);
            champ.spells = JSONUtils.mappedList(obj.getJSONArray("spells"), LoLUtils.toChampSpell);
            champ.stats = LoLStats.genLoLStats(obj.getJSONObject("stats"));
            champ.tags = JSONUtils.mappedList(obj.getJSONArray("tags"), Functions.toString);
            return Box.fill(champ);
        } catch(JSONException e) {
            e.printStackTrace();
            return Box.EMPTY;
        }
        
    }
    
    public static Box<LoLChampion> genChampion(int id) {
        try {
            LoLChampion champ = new LoLChampion();
            Map<String, String> sobj = generateJson(id, Box.fill(simpleTypes));
            Map<String, String> lobj = generateJson(id, Box.fill(simpleLists));
            champ.id = id;
            //TODO freeToPlay isnt static data get later
            champ.freeToPlay = false;//Functions.toBoolean.apply((Object) sobj.get("freetoplay"));
            champ.key = sobj.get("key"); champ.name = sobj.get("name");
            champ.title = sobj.get("title"); champ.blurb = sobj.get("blurb"); 
            champ.allyTips = JSONUtils.safeJArrayToList(lobj.get("allytips")).get();
            champ.enemyTips = JSONUtils.safeJArrayToList(lobj.get("enemytips")).get();
            champ.image = LoLImage.genImage(generateJson(id, Box.fill(IMAGE)).get("image")); 
            champ.lore = sobj.get("lore");
//            champ.recommended = JSONUtils.mappedList(generateJson(id, Box.fill(RECOMMEDED)).getJSONArray("recommended"), LoLUtils.toRecommended);
//           champ.passive = LoLPassive.genPassive(generateJson(id, Box.fill(PASSIVE)).getJSONObject("passive"));
            champ.partype = sobj.get("partype");
//            champ.skins = JSONUtils.mappedList(generateJson(id, Box.fill(SKINS)).getJSONArray("skins"), LoLUtils.toSkin);
//            champ.spells = JSONUtils.mappedList(generateJson(id, Box.fill(SPELLS)).getJSONArray("spells"), LoLUtils.toChampSpell);
            champ.stats = LoLStats.genLoLStats(generateJson(id, Box.fill(STATS)).get("stats"));
            champ.tags = JSONUtils.safeJArrayToList(lobj.get("tags")).get();
            return Box.fill(champ);
        } catch(Exception e) {
            e.printStackTrace();
            return Box.EMPTY;
        }
    }
    
}
