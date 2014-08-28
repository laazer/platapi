package com.laazer.lol.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.laazer.common.Box;
import com.laazer.lol.RiotForge;
import com.laazer.lol.champion.LoLChampion;

public class LoLChampionSpec {

    String key = "f123e66a-3511-4219-bd29-71d8e315e603";
    RiotForge forge = new RiotForge(key);
    Box<LoLChampion> garen;
    Box<LoLChampion> soraka;
    Box<LoLChampion> nidalee;
    
    public void initGaren() {
        garen = forge.genCompleteChamp(86);
    }
    public void initSoraka() {
        soraka = forge.genCompleteChamp(16);
    }
    public void initNid() {
        nidalee = forge.genCompleteChamp(76);
    }
    
    @Test
    public void testGaren() {
        initGaren();
        assertTrue("garen is full", garen.isFull());
        assertTrue("garen's name is Garen", garen.get().getName().equals("Garen"));
        assertTrue("garen has spells (who knew)", garen.get().getSpells().isFull());
        assertTrue("garen has 4 spells", garen.get().getSpells().get().size() == 4);
    }
    
    @Test
    public void testSoraka() {
        initSoraka();
        assertTrue(soraka.isFull());
        assertTrue(soraka.get().getSpells().isFull());
        assertTrue(soraka.get().getSpells().get().size() == 4);
    }
    
    @Test
    public void testNid() {
        initNid();
        assertTrue(nidalee.isFull());
        assertTrue(nidalee.get().getSpells().isFull());
        assertTrue(nidalee.get().getSpells().get().size() == 4);
    }
    
    
}
