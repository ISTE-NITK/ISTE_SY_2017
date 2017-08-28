package com.nitk.iste.scotlandyard;

public class ItemObject {

    private int Photo;
    private String DocName;
    private String Address;

    public ItemObject(int photo, String docname, String address) {
        this.Photo = photo;
        this.DocName = docname;
        this.Address = address;
    }

    public int getPhoto() {
        return Photo;
    }

    public String getDocName() {
        return DocName;
    }

    public String getDocAddress() {
        return Address;
    }
}
