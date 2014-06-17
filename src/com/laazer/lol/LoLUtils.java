package com.laazer.lol;

import com.laazer.common.Box;
import com.laazer.common.UniFunction;
import com.laazer.common.JSONUtils;
import com.laazer.lol.champion.*;

public class LoLUtils extends LoLObject{
    
    public static UniFunction<Object, LoLRecommended> toRecommended = new ToRecommended();
    public static UniFunction<Object, LoLSkin> toSkin = new ToSkin();
    public static UniFunction<Object, LoLSpellVars> toSpellVar = new ToSpellVars();
    public static UniFunction<Object, Box<LoLChampSpell>> toChampSpell = new ToChampSpell();
    public static UniFunction<Object, LoLImage> toImage = new ToImage();
    public static UniFunction<Object, LoLBlockItem> toBlockItem = new ToBlockItem();
    
    private static class ToRecommended implements UniFunction<Object, LoLRecommended> {
        public LoLRecommended apply(Object value) {
            return LoLRecommended.genLoLRecommened(value.toString());
        }
    }
    
    private static class ToSkin implements UniFunction<Object, LoLSkin> {
        public LoLSkin apply(Object value) {
            return LoLSkin.genLoLSkin(value.toString());
        }
    }
    
    private static class ToSpellVars implements UniFunction<Object, LoLSpellVars> {
        public LoLSpellVars apply(Object value) {
            return LoLSpellVars.genSpellVars(value.toString());
        }
    }
    
    private static class ToChampSpell implements UniFunction<Object, Box<LoLChampSpell>> {
        public Box<LoLChampSpell> apply(Object value) {
            return LoLChampSpell.genChampSpell(value.toString());
        }
    }
    
    private static class ToImage implements UniFunction<Object, LoLImage> {
        public LoLImage apply(Object value) {
            return LoLImage.genImage(value.toString());
        }
    }
    
    private static class ToBlockItem implements UniFunction<Object, LoLBlockItem> {
        public LoLBlockItem apply(Object value) {
            return LoLBlockItem.genBlockItem(value.toString());
        }
        
    }
    
}
