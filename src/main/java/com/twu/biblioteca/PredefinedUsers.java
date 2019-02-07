package com.twu.biblioteca;

public enum PredefinedUsers {

    USER1("Adam", "123-4567", "password1", "adam@email.com", "123-456-7890" ),
    USER2("David", "098-7654", "password2", "david@email.com", "098-765-4321"),
    GUEST("Guest", "", "", "", "");


    private final String name;
    private final String libraryNumber;
    private final String password;
    private final String email;
    private final String phoneNumber;

    PredefinedUsers(String name, String libraryNumber, String password, String email, String phoneNumber){
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static PredefinedUsers lookup(String libraryNumber){
            for(PredefinedUsers user : values()){
                if(user.libraryNumber.equals(libraryNumber)){
                    return user;
                }
            }
        return null;
    }

    public boolean passwordMatch(String password){
        return this.password.equals(password);
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


}
