package com.example.cider.service;

import com.example.cider.model.CidrBlock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul.hilsen on 5/26/2017.
 */

@Service
public class CidrBlockService {

    //currently a test method
    public List<CidrBlock> getOpenCidrBlocks(int vid, int tid, int number, int size, String status ) {

        //create some example cidrblocks to see if we can access stuff like vpc/tid
        CidrBlock cidrBlock = new CidrBlock(Long.valueOf(vid), String.valueOf(tid), String.valueOf(number), status, size);
        CidrBlock cidrBlock1 = new CidrBlock(1l, "10.0.0.0/16", "AppleDate", "BananaDate", 42);

        List<CidrBlock> cidrBlocks = new ArrayList<CidrBlock>();
        cidrBlocks.add(cidrBlock);
        cidrBlocks.add(cidrBlock1);

     return cidrBlocks;
    }




}
