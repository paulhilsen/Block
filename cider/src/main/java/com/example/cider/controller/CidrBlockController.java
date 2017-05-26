package com.example.cider.controller;


import com.example.cider.model.CidrBlock;
import com.example.cider.service.CidrBlockService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul.hilsen on 5/26/2017.
 */

@RestController
@RequestMapping("api/v1/")
public class CidrBlockController {

    //deployed locally, an example of the url is: http://localhost:8080/api/v1/vpc/1/tenants/3/cidrs?number=3&size=45&status=good
    @RequestMapping(value = "vpc/{vid}/tenants/{tid}/cidrs", method = RequestMethod.GET)
    public List<CidrBlock> list(@PathVariable int vid, @PathVariable int tid, @RequestParam int number, @RequestParam int size,  @RequestParam String status)
    {

        List<CidrBlock> cidrBlocks =new ArrayList<>();

        CidrBlockService cidrBlockService = new CidrBlockService();
        cidrBlocks = cidrBlockService.getOpenCidrBlocks(vid,tid,number,size,status);

        return cidrBlocks;
    }

}
