package com.twu.biblioteca.item;

public enum ItemType {
    BOOK, MOVIE, INVALID;

    public static ItemType lookup(String type){
        if(type == null){
            return INVALID;
        }
        try{
            return ItemType.valueOf(type.toUpperCase());
        }
        catch (IllegalArgumentException e){
            return INVALID;
        }
    }
}
