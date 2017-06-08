package com.example.cider.NextIPBlockFactory;

import com.example.cider.dao.CidrBlockDao;
import com.example.cider.model.CidrBlock;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by paul.hilsen on 5/30/2017.
 */

@Repository
public class NextIpBlock {

     CidrBlockDao cidrBlockDao;

     NextIpBlock(CidrBlockDao cidrBlockDao) {
        this.cidrBlockDao = cidrBlockDao;
    }


    public List<CidrBlock> returnIp(int vid, int requestedNumber) {

        List<CidrBlock> existingCidrBlocks = cidrBlockDao.getSectionCidrBlocks(vid);
        List<CidrBlock> newCidrBlocks = new ArrayList<>();

        //Sort by IPs1 address to get the largest number
        Collections.sort(existingCidrBlocks, (c1, c2) -> (c2.getFullIntIp().compareTo(c1.getFullIntIp())));


        //if IPs1 is not full yet
        if(existingCidrBlocks.get(0).getIPs3() < 240) {

            //Code to create new cider block
            CidrBlock cidrBlock = new CidrBlock();
            cidrBlock.setVid(vid);
            cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1());
            cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2());
            cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs3() + 16);
            cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28" );
            cidrBlock.setFullIntIp(String.format("%03d",cidrBlock.getIPs1()) + "." + String.format("%03d", cidrBlock.getIPs2()) + "." + String.format("%03d",cidrBlock.getIPs3())); // need to concatenate values

            cidrBlockDao.insertNewCidrBlock(vid,cidrBlock.getIpBlock(),cidrBlock.getIPs1(),cidrBlock.getIPs2(),cidrBlock.getIPs3(),28,cidrBlock.getFullIntIp());

            newCidrBlocks.add(cidrBlock);
            return newCidrBlocks;
        }

        //If IPs3 is full
        if(existingCidrBlocks.get(0).getIPs3() >= 240) {
            Collections.sort(existingCidrBlocks, (c1, c2) -> (c2.getFullIntIp().compareTo(c1.getFullIntIp())));

            if (existingCidrBlocks.get(0).getIPs2() < 255) {


                //Code to create new cider block
                CidrBlock cidrBlock = new CidrBlock();
                cidrBlock.setVid(vid);
                cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1());
                cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2() + 1);
                if(existingCidrBlocks.get(0).getIPs3() >= 240 ) {cidrBlock.setIPs3(0); }  // if its getting too full, reset to 0;
                else{ cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs1());}
                cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28");
                cidrBlock.setFullIntIp(String.format("%03d",cidrBlock.getIPs1()) + "." + String.format("%03d", cidrBlock.getIPs2()) + "." + String.format("%03d",cidrBlock.getIPs3())); // need to concatenate values

                //Insert New block into DB
                cidrBlockDao.insertNewCidrBlock(vid, cidrBlock.getIpBlock(), cidrBlock.getIPs1(), cidrBlock.getIPs2(), cidrBlock.getIPs3(), 28,cidrBlock.getFullIntIp());

                newCidrBlocks.add(cidrBlock);
                return newCidrBlocks;
            }
        }
            //if IPs2 is full
        if(existingCidrBlocks.get(0).getIPs3() >= 240) {
            Collections.sort(existingCidrBlocks, (c1, c2) -> (c2.getFullIntIp().compareTo(c1.getFullIntIp())));

            if (existingCidrBlocks.get(0).getIPs2() >= 255) {
                Collections.sort(existingCidrBlocks, (c1, c2) -> (c2.getFullIntIp().compareTo(c1.getFullIntIp())));

                if (existingCidrBlocks.get(0).getIPs1() < 255) {

                    //Code to create new cider block
                    CidrBlock cidrBlock = new CidrBlock();
                    cidrBlock.setVid(vid);
                    cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1() + 1);
                    if(existingCidrBlocks.get(0).getIPs2()>= 255 ) {cidrBlock.setIPs2(0); cidrBlock.setIPs3(0); }  //DIDNT SEEM TO WORK???
                    else{cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2());}
                    cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs3());
                    cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28");
                    cidrBlock.setFullIntIp(String.format("%03d",cidrBlock.getIPs1()) + "." + String.format("%03d", cidrBlock.getIPs2()) + "." + String.format("%03d",cidrBlock.getIPs3())); // need to concatenate values

                    //Insert new block into DB
                    cidrBlockDao.insertNewCidrBlock(vid, cidrBlock.getIpBlock(), cidrBlock.getIPs1(), cidrBlock.getIPs2(), cidrBlock.getIPs3(), 28,cidrBlock.getFullIntIp());



                    if(existingCidrBlocks.get(0).getIPs1() == 255) {
                        //FLIP THE F OUT????
                    }


                    newCidrBlocks.add(cidrBlock);
                    return newCidrBlocks;
                }
            }
        }
        //???????????????
        //RETURN ERROR IF NONE OF THE ABOVE WORK//////
        //???????????????
        return existingCidrBlocks;

    }



}
