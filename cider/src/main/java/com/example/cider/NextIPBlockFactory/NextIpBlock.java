package com.example.cider.NextIPBlockFactory;

import com.example.cider.dao.CidrBlockDao;
import com.example.cider.dao.impl.CidrBlockDaoImpl;
import com.example.cider.model.CidrBlock;

import java.util.List;

/**
 * Created by paul.hilsen on 5/30/2017.
 */
public class NextIpBlock {



    CidrBlockDao cidrBlockDao;

    NextIpBlock(CidrBlockDao cidrBlockDao) {
        this.cidrBlockDao = cidrBlockDao;
    }



    public List<CidrBlock> returnIp(int vid, int requestedNumber) {

        List<CidrBlock> existingCidrBlocks;

        for (int i=1; i<requestedNumber; i++) {

            existingCidrBlocks = cidrBlockDao.getCidrBlocks(vid);




        }



        return cidrBlockDao.getCidrBlocks(vid); //the return is just for kicks right now

    }

}
