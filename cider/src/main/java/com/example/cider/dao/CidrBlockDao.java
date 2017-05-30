package com.example.cider.dao;

import com.example.cider.model.CidrBlock;

import java.util.List;

/**
 * Created by paul.hilsen on 5/29/2017.
 */
public interface CidrBlockDao {

    List<CidrBlock> getCidrBlocks(int vid);

}
