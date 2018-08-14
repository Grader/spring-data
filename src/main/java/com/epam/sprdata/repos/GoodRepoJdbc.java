package com.epam.sprdata.repos;

import com.epam.sprdata.domain.Good;
import com.epam.sprdata.domain.GoodRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GoodRepoJdbc {

    private static final Logger log = LoggerFactory.getLogger(GoodRepoJdbc.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable("goods")
    public List<Good> findAll() {
        simulateSlowService();
        log.info("Execute method findAll");
        return jdbcTemplate.query("select * from good",
                new GoodRowMapper());
    }

    public Good findGoodById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from good where id=?",
                new Object[]{id}, new GoodRowMapper());
    }

    private void simulateSlowService() {
        try {
            long time = (5000L);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public Good create(final Good good) {
        final String sql = "insert into good (cat,tag,price,img) values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, good.getCat());
                ps.setString(2, good.getTag());
                ps.setString(3, good.getPrice());
                ps.setString(4, good.getImg());
                return ps;
            }
        }, keyHolder);
        return good;
    }

    public List<Good> findByTagContaining(String tag) {
        return jdbcTemplate.query("select * from good where tag like ?",
                new GoodRowMapper(), "%" + tag + "%");
    }
}
