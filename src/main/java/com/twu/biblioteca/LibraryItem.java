package com.twu.biblioteca;

public abstract class LibraryItem {
    private String title;
    private boolean available;

    public LibraryItem(String title){
        this.title = title;
        this.available = true;
    }
    public String getTitle(){
        return this.title;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean availability){
        this.available = availability;
    }

    abstract void displayInfo();
}
