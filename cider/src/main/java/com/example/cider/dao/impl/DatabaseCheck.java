package com.example.cider.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by paul.hilsen on 5/30/2017.
 */
public class DatabaseCheck {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }





    public String checkifExist (int id) {

         String sql= "SELECT block FROM CidrBlock.UsedBlocks where id = ?";

         Object[] params = {id};
         List<String> result = jdbcTemplate.query(sql, params, new ExistRowMapper());


         return result.get(0);
    }


    public class ExistRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return  rs.getString("block");


        }
    }







}
