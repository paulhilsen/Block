package com.example.cider.model;

/**
 * Created by paul.hilsen on 5/25/2017.
 */



public class CidrBlock {

    Long id;
    int vid;
    String ipBlock;
    int number;
    int IPs1;
    int IPs2;
    int IPs3;
    String dateEntered;
    String dateUpdated;
    String fullIntIp;


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

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getIPs1() {
        return IPs1;
    }

    public void setIPs1(int IPs1) {
        this.IPs1 = IPs1;
    }

    public int getIPs2() {
        return IPs2;
    }

    public void setIPs2(int IPs2) {
        this.IPs2 = IPs2;
    }

    public int getIPs3() {
        return IPs3;
    }

    public void setIPs3(int IPs3) {
        this.IPs3 = IPs3;
    }


    public String getFullIntIp() {
        return fullIntIp;
    }

    public void setFullIntIp(String fullIntIp) {
        this.fullIntIp = fullIntIp;
    }
}


