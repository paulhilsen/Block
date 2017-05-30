package com.example.cider.model;

/**
 * Created by paul.hilsen on 5/25/2017.
 */



public class CidrBlock {

    Long id;
    int vid;
    String ipBlock;
    int number;
    String dateEntered;
    String dateUpdated;


    public CidrBlock() {}

    public CidrBlock(Long id, int vid, String ipBlock, String dateEntered, String dateUpdated, int number) {
        this.id = id;
        this.vid = vid;
        this.ipBlock = ipBlock;
        this.dateEntered = dateEntered;
        this.dateUpdated = dateUpdated;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpBlock() {
        return ipBlock;
    }

    public void setIpBlock(String ipBlock) {
        this.ipBlock = ipBlock;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int getVPC() {
        return vid;
    }

    public void setVPC(int VPC) {
        this.vid = VPC;
    }
}


