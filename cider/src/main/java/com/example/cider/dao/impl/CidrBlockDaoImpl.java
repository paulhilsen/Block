package com.example.cider.dao.impl;


import com.example.cider.DBConnection.ConnectionFactory;
import com.example.cider.dao.CidrBlockDao;
import com.example.cider.model.CidrBlock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by paul.hilsen on 5/29/2017.
 */

@Repository
public class CidrBlockDaoImpl implements CidrBlockDao {

    JdbcTemplate jdbcTemplate;

    CidrBlockDaoImpl(ConnectionFactory connectionFactory) {
        this.jdbcTemplate = new JdbcTemplate(connectionFactory.databaseConnection());
    }

    @Override
    public List<CidrBlock> getCidrBlocks(int vid) {

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

    @Override
    public List<CidrBlock> getSectionCidrBlocks( int vid) {

        String getPartsCidrBlocks = "SELECT IPs1, IPs2, IPs3 FROM CidrBlock.UsedBlocks where VPC = ?";
        Object[] param = {vid};
        List<CidrBlock> cidrblocks = jdbcTemplate.query(getPartsCidrBlocks, param, new CidrBlockDaoImpl.CidrBlockPartsRowMapper());
        return cidrblocks;
    }

    //***Mapper for getCidrBlocks() Method getting information from the database ********
    public static final class CidrBlockPartsRowMapper implements RowMapper {


        @Override
        public CidrBlock mapRow(ResultSet rs, int rowNum) throws SQLException {
            CidrBlock cidrBlock = new CidrBlock();
            cidrBlock.setIPs1(rs.getInt("IPs1"));
            cidrBlock.setIPs2(rs.getInt("IPs2"));
            cidrBlock.setIPs3(rs.getInt("IPs3"));


            return cidrBlock;
        }
    }


    @Override
    public int insertNewCidrBlock( int vid, String block, int IPs1, int IPs2, int IPs3, int bits) {

        String insertCidrBlock = "INSERT INTO CidrBlock.UsedBlocks (VPC,block,IPs1,IPs2,IPs3,bits)\n" +
                                         "Values (?,?,?,?,?,?)";

        Object[] param = {vid, block, IPs1, IPs2, IPs3, bits};
       int[] types = {Types.INTEGER,Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER};


        return jdbcTemplate.update(insertCidrBlock, param,types);
    }

}
