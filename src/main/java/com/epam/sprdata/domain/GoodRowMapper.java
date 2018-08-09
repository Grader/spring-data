package com.epam.sprdata.domain;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodRowMapper implements RowMapper<Good> {

    @Override
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();
        good.setId(rs.getLong("id"));
        good.setCat(rs.getString("cat"));
        good.setTag(rs.getString("tag"));
        good.setPrice(rs.getString("price"));
        good.setImg(rs.getString("img"));
        return good;
    }
}
