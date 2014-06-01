package com.laazer.lol.summoner;

import java.util.Set;
import java.util.List;
import com.laazer.lol.LoLObject;

public class LoLMasteryPages implements LoLObject{
    Set<LoLMasteryPage> pages;
    Long summonerId;
}

class LoLMasteryPage implements LoLObject {
    boolean current;
    Long id;
    List<LoLMastery> masteries;
    String name;
}

class LoLMastery implements LoLObject {
    int id, rank;
}