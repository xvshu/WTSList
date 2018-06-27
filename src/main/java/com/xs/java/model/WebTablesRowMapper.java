package com.xs.java.model;

import com.xs.java.dbs.sqlite.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WebTablesRowMapper implements RowMapper<WebTables> {
    @Override
    public WebTables mapRow(ResultSet rs, int index) throws SQLException {
        return WebTables.RowMapperToWorkCalendar(rs);
    }
}
