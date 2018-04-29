package com.example.ninja.elazkar;

/**
 * Created by ninja on 19/02/2018.
 */

public class Pray {
    private String prayName;
    private String prayHead;

    public Pray() {
    }
    public Pray(String prayName, String prayHead) {
        this.prayName = prayName;
        this.prayHead = prayHead;

    }

    public String getPrayName() {
        return prayName;
    }

    public void setPrayName(String prayName) {
        this.prayName = prayName;
    }

    public String getPrayHead() {
        return prayHead;
    }

    public void setPrayHead(String prayHead) {
        this.prayHead = prayHead;
    }


}
