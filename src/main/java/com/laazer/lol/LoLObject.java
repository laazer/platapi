package com.laazer.lol;

import com.google.gson.Gson;


public abstract class LoLObject {
    protected final static String URL = "https://prod.api.pvp.net/api/lol/";
    
    public LoLObject generate(Object obj) {
        Gson gson = new Gson();
        return gson.fromJson(obj.toString(), this.getClass());
    }

    
}

@SuppressWarnings("serial")
class BadLoLConversionException extends Exception
{
      //Parameterless Constructor
      public BadLoLConversionException() {}

      //Constructor that accepts a message
      public BadLoLConversionException(String message)
      {
         super(message);
      }
 }

