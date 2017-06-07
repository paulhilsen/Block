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
        Collections.sort(existingCidrBlocks, (c1, c2) -> c2.getIPs3()-c1.getIPs3());

        //if IPs1 is not full yet
        if(existingCidrBlocks.get(0).getIPs3() < 240) {

            //Code to create new cider block
            CidrBlock cidrBlock = new CidrBlock();
            cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1());
            cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2());
            cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs3() + 16);
            cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28" );

            cidrBlockDao.insertNewCidrBlock(vid,cidrBlock.getIpBlock(),cidrBlock.getIPs1(),cidrBlock.getIPs2(),cidrBlock.getIPs3(),28);

            newCidrBlocks.add(cidrBlock);
            return newCidrBlocks;
        }

        //If IPs3 is full
        if(existingCidrBlocks.get(0).getIPs3() >= 240) {
            Collections.sort(existingCidrBlocks, (c1, c2) -> c2.getIPs2() - c1.getIPs2());

            if (existingCidrBlocks.get(0).getIPs2() < 255) {


                //Code to create new cider block
                CidrBlock cidrBlock = new CidrBlock();


                cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1());
                cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2() + 1);
                if(existingCidrBlocks.get(0).getIPs3() >= 240 ) {cidrBlock.setIPs3(0);}
                else{ cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs1());}
                cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28");

                cidrBlockDao.insertNewCidrBlock(vid, cidrBlock.getIpBlock(), cidrBlock.getIPs1(), cidrBlock.getIPs2(), cidrBlock.getIPs3(), 28);

                newCidrBlocks.add(cidrBlock);
                return newCidrBlocks;
            }
        }
            //if IPs2 is full
        if(existingCidrBlocks.get(0).getIPs3() >= 240) {
            Collections.sort(existingCidrBlocks, (c1, c2) -> c2.getIPs2() - c1.getIPs2());

            if (existingCidrBlocks.get(0).getIPs2() >= 255) {
                Collections.sort(existingCidrBlocks, (c1, c2) -> c2.getIPs1() - c1.getIPs1());

                if (existingCidrBlocks.get(0).getIPs1() < 255) {

                    //Code to create new cider block
                    CidrBlock cidrBlock = new CidrBlock();
                    cidrBlock.setIPs1(existingCidrBlocks.get(0).getIPs1() + 1);
                    cidrBlock.setIPs2(existingCidrBlocks.get(0).getIPs2());
                    cidrBlock.setIPs3(existingCidrBlocks.get(0).getIPs3());
                    cidrBlock.setIpBlock("10." + cidrBlock.getIPs1() + "." + cidrBlock.getIPs2() + "." + cidrBlock.getIPs3() + "/28");

                    cidrBlockDao.insertNewCidrBlock(vid, cidrBlock.getIpBlock(), cidrBlock.getIPs1(), cidrBlock.getIPs2(), cidrBlock.getIPs3(), 28);



                    if(existingCidrBlocks.get(0).getIPs1() == 255) {
                        //FLIP THE F OUT????
                    }


                    newCidrBlocks.add(cidrBlock);
                    return newCidrBlocks;
                }
            }
        }
        //???????????????
        ////RETURN ERROR IF NONE OF THE ABOVE WORK//////
        //???????????????
        return existingCidrBlocks;

    }


}
