package com.example.cider.dao.impl;


import com.example.cider.DBConnection.ConnectionFactory;
import com.example.cider.dao.CidrBlockDao;
import com.example.cider.model.CidrBlock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by paul.hilsen on 5/29/2017.
 */

@Repository
public class CidrBlockDaoImpl implements CidrBlockDao{

    JdbcTemplate jdbcTemplate;

    CidrBlockDaoImpl(ConnectionFactory connectionFactory) {
        this.jdbcTemplate = new JdbcTemplate(connectionFactory.databaseConnection());
    }

    @Override
    public List<CidrBlock> getCidrBlocks( int vid) {

        String getAllCidrBlocks = "SELECT block FROM CidrBlock.UsedBlocks where VPC = ?";
        Object[] param = {vid};
        List<CidrBlock> cidrblocks = jdbcTemplate.query(getAllCidrBlocks, param, new CidrBlockDaoImpl.CidrBlockRowMapper());
        return cidrblocks;
    }

    //***Mapper for getCidrBlocks() Method getting information from the database ********
    public static final class CidrBlockRowMapper implements RowMapper {


        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {

            return rs.getString("block");
        }
    }



}
