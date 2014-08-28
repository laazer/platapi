package com.laazer.lol;

import com.laazer.common.Box;
import com.laazer.lol.champion.LoLChampVal;
import com.laazer.lol.champion.LoLChampion;

public class RiotForge {
    String key;
    public RiotForge(String key){
        this.key = key;
    }
    
    /**
     * Tries to generate a simple a <code>Box</code> filled with a 
     * <code>LoLChampion</code> with the given id number.
     * If an error occurs during the creation process the <code>Box</code> will be empty.
     * Simple <code>LoLChampion</code>s will only have their id, key, name and
     * title.
     * @param id a given <code>int</code>
     * @return A <code>Box</code> that contains either a <code>LoLChampion</code>
     * or is Empty
     */
    public Box<LoLChampion> genSimpleChamp(int id) {
        return this.genComplexChamp(id);
    }
    
    /**
     * Tries to generate a simple a <code>Box</code> filled with a 
     * <code>LoLChampion</code> with the given id number.
     * If an error occurs during the creation process the <code>Box</code> will be empty.
     * A Complex <code>LoLChampion</code> has all fields of a Simple <code>LoLChampion</code>
     * as well as any <code>LoLChampVal</code>s added.
     * @param id a given <code>int</code>
     * @param args any number of <code>LoLChampVal</code>s
     * @return  A <code>Box</code> that contains either a <code>LoLChampion</code>
     * or is Empty
     */
    public Box<LoLChampion> genComplexChamp(int id, LoLChampVal... args) {
        return LoLChampion.genComplexChamp(id, key, args);
    }
    
    /**
     * Tries to generate a simple a <code>Box</code> filled with a 
     * <code>LoLChampion</code> with the given id number.
     * If an error occurs during the creation process the <code>Box</code> will be empty.
     * A Complex <code>LoLChampion</code> has all fields of a Simple <code>LoLChampion</code>
     * as well as any <code>LoLChampVal</code>s added.
     * @param id a given <code>int</code>
     * @param args any number of <code>LoLChampVal</code>s
     * @return  A <code>Box</code> that contains either a <code>LoLChampion</code>
     * or is Empty
     */
    public Box<LoLChampion> genCompleteChamp(int id) {
        return this.genComplexChamp(id, LoLChampVal.ALL);
    }
}
