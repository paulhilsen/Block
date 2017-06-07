package com.example.cider.controller;


import com.example.cider.NextIPBlockFactory.NextIpBlock;
import com.example.cider.dao.CidrBlockDao;
import com.example.cider.model.CidrBlock;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by paul.hilsen on 5/26/2017.
 */

@RestController
@RequestMapping("api/v1/")
public class CidrBlockController {


    CidrBlockDao cidrBlockDao;
    NextIpBlock nextIpBlock;

    CidrBlockController(CidrBlockDao cidrBlockDao , NextIpBlock nextIpBlock) {
        this.cidrBlockDao = cidrBlockDao;
        this.nextIpBlock = nextIpBlock;
    }



    //deployed locally, an example of the url is: http://localhost:8080/api/v1/vpc/1/tenants/3/cidrs?number=3&size=45&status=good
    @RequestMapping(value = "vpc/{vid}/tenants/{tid}/cidrs", method = RequestMethod.GET)
    public List<CidrBlock> list(@PathVariable int vid, @PathVariable int tid, @RequestParam int number, @RequestParam int size, @RequestParam String status) {

        return cidrBlockDao.getCidrBlocks(vid);


//                 ////Test Database Connection  (Need to change method to String type)
//                ConnectionFactory connectionFactory = new ConnectionFactory();
//                DatabaseCheck databaseCheck = new DatabaseCheck();
//                databaseCheck.setJdbcTemplate(connectionFactory.databaseConnection());
//                return databaseCheck.checkifExist(vid);


//        //// Test Returning static Json object
//        List<CidrBlock> cidrBlocks;
//         CidrBlockService cidrBlockService = new CidrBlockService();
//         cidrBlocks = cidrBlockService.getOpenCidrBlocks(vid,tid,number,size,status);
//        return cidrBlocks;
    }


    //Test some calls
    @RequestMapping(value = "d/{vid}/d/{tid}/cidrs", method = RequestMethod.GET)
    public List<CidrBlock> SortValues(@PathVariable int vid, @PathVariable int tid, @RequestParam int number, @RequestParam int size, @RequestParam String status) {



        return nextIpBlock.returnIp(vid, 1);



}

}
