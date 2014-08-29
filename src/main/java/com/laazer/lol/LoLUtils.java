package com.laazer.lol;

import com.google.gson.Gson;
import com.google.common.base.Function;
import com.laazer.lol.champion.*;

public class LoLUtils extends LoLObject{

    private static Gson gson = new Gson();
    public static Function<Object, LoLRecommended> toRecommended = new ToRecommended();
    public static Function<Object, LoLSkin> toSkin = new ToSkin();
    public static Function<Object, LoLSpellVars> toSpellVar = new ToSpellVars();
    public static Function<Object, LoLChampSpell> toChampSpell = new ToChampSpell();
    public static Function<Object, LoLImage> toImage = new ToImage();
    public static Function<Object, LoLBlockItem> toBlockItem = new ToBlockItem();
    
    private static class ToRecommended implements Function<Object, LoLRecommended> {
        public LoLRecommended apply(Object value) {
            return LoLRecommended.genLoLRecommened(value.toString());
        }
    }
    
    private static class ToSkin implements Function<Object, LoLSkin> {
        public LoLSkin apply(Object value) {
            return LoLSkin.generate(gson.toJson(value));
        }
    }
    
    private static class ToSpellVars implements Function<Object, LoLSpellVars> {
        public LoLSpellVars apply(Object value) {
            return LoLSpellVars.generate(gson.toJson(value));
        }
    }
    
    private static class ToChampSpell implements Function<Object, LoLChampSpell> {
        public LoLChampSpell apply(Object value) {
            return LoLChampSpell.generate(gson.toJson(value));
        }
    }
    
    private static class ToImage implements Function<Object, LoLImage> {
        public LoLImage apply(Object value) {
            return LoLImage.generate(gson.toJson(value));
        }
    }
    
    private static class ToBlockItem implements Function<Object, LoLBlockItem> {
        public LoLBlockItem apply(Object value) {
            return LoLBlockItem.generate(gson.toJson(value));
        }
    }
    
}
