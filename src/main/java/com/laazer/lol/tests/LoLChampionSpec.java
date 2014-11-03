package com.laazer.lol.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.laazer.common.Box;
import com.laazer.lol.champion.LoLChampion;
import com.laazer.common.FileUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class LoLChampionSpec {

    String resPath = this.getClass().getResource("/champRes").getPath();
    Box<LoLChampion> garen;
    Box<LoLChampion> soraka;
    Box<LoLChampion> nidalee;
    
    public void initGaren() {
        String js = FileUtils.safeReadFile(resPath + "/garenReg.txt", StandardCharsets.UTF_8).get();
        garen = LoLChampion.genCustomChamp(js);
    }
    public void initSoraka() {
        soraka = LoLChampion.genCustomChamp(FileUtils.safeReadFile(resPath + "/rakaReg.txt", Charset.defaultCharset()).get());
    }
    public void initNid() {
        nidalee = LoLChampion.genCustomChamp(FileUtils.safeReadFile(resPath + "/nidReg.txt", Charset.defaultCharset()).get());
    }
    
    @Test
    public void testGaren() {
        initGaren();
        assertTrue("garen is full", garen.isFull());
        assertTrue("garen's name is Garen", garen.get().getName().equals("Garen"));
        assertTrue("garen has spells (who knew)", garen.get().getSpells().isFull());
        assertTrue("garen has 4 spells", garen.get().getSpells().get().size() == 4);
        assertTrue("check that garen's self cast is empty", garen.get().getSpells().get().get(1).getRange().isEmpty());
        assertTrue("check that garen's ult cast is empty", garen.get().getSpells().get().get(3).getRange().isFull());
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
