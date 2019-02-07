package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<String,LibraryItem> checkedOutItems;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(){
        this.checkedOutItems = new HashMap<>();
    }

    public Customer(PredefinedUsers user){
        this.checkedOutItems = new HashMap<>();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void addItemToCollection(ItemType type, LibraryItem item){
        this.checkedOutItems.put(this.getKey(type,item.getTitle()),item);
    }

    public int getNumBooksCheckedOut(){
        return this.checkedOutItems.size();
    }

    public void removeItemFromCollection(ItemType type, String title){
        this.checkedOutItems.remove(this.getKey(type,title));
    }

    public boolean hasItem(ItemType type, String title){
        return this.checkedOutItems.containsKey(this.getKey(type,title));
    }

    private String getKey(ItemType type, String title){
        return String.valueOf(type)+title;
    }

    public static Customer login(String libraryNumber, String password){
        PredefinedUsers result = PredefinedUsers.lookup(libraryNumber);
        if(result == null){
            System.out.println("Incorrect library number");
            return null;
        }
        if(result.passwordMatch(password)){
            return new Customer(result);
        }
        System.out.println("Incorrect password");
        return null;

    }

    public void listBooks(){
        this.checkedOutItems.forEach(
                (title,item)-> {
                    item.displayInfo();
                }
                );
    }

}
