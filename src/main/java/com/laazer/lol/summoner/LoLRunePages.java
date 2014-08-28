package com.laazer.lol.summoner;

import com.laazer.lol.LoLObject;
import java.util.Set;

public class LoLRunePages extends LoLObject {
    Set<LoLRunePage> pages;
    Long summonerId;
}

class LoLRunePage extends LoLObject {
    boolean cuurent;
    Long id;
    String name;
    Set<LoLRuneSlot> slots;
}

class LoLRuneSlot extends LoLObject {
    int runeId;
    int runeSlotId;
}

