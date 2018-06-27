package com.xs.java.service;

import com.xs.java.dbs.sqlite.ResultSetExtractor;
import com.xs.java.dbs.sqlite.SqliteHelper;
import com.xs.java.dbs.utils.CreateSqlTools;
import com.xs.java.dbs.utils.annotation.FieldAnnotation;
import com.xs.java.dbs.utils.annotation.FieldType;
import com.xs.java.dbs.utils.annotation.TableAnnotation;
import com.xs.java.model.MaxId;
import com.xs.java.model.WebTables;
import com.xs.java.model.WebTablesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class WebTablesService {

    @Autowired
    private SqliteHelper sqliteHelper;

    public List<WebTables> getAll(){

        try {
            WebTables webTables = new WebTables();
            String selectAllSql = CreateSqlTools.getSelectAllSql(webTables);
            System.out.println(selectAllSql);
            List<WebTables> sList = sqliteHelper.executeQuery(selectAllSql, new WebTablesRowMapper());
            return sList;
        }catch ( Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public void save(WebTables webTables){
        try {
            String insertSql = CreateSqlTools.getInsertSql(webTables);
            System.out.println(insertSql);
            sqliteHelper.executeUpdate(insertSql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public WebTables findById(int id){
        WebTables result = null;
        try {
            WebTables webTables = new WebTables();
            webTables.setID(id);

            String selectOneSql = CreateSqlTools.getSelectSql(webTables);
            System.out.println(selectOneSql);
            List<WebTables> sqlresult  =sqliteHelper.executeQuery(selectOneSql,new WebTablesRowMapper());
            if(sqlresult!=null && sqlresult.size()>=1){
                result = sqlresult.get(0);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public synchronized int findMaxId(){
        if(MaxId.Max!=null){
            MaxId.Max=MaxId.Max+1;
            return MaxId.Max;
        }else{
            String findMaxSql = " SELECT max(ID) as max FROM Web_Table;";
            try {
                int maxIdResult  =sqliteHelper.executeQuery(findMaxSql, new ResultSetExtractor<Integer>(){

                    @Override
                    public Integer extractData(ResultSet rs)  {
                        Integer result = 0;
                        if(rs!=null){
                            try {
                                result = Integer.valueOf(rs.getInt("max"));
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                        return result;
                    }
                });
                MaxId.Max=maxIdResult+1;
            }catch (Exception ex){
                ex.printStackTrace();
                MaxId.Max=null;
            }
        }
        return MaxId.Max;
    }

    public void edit(WebTables webTables){
        try {
            String updateSql = CreateSqlTools.getUpdateSql(webTables,true);
            System.out.println(updateSql);
            sqliteHelper.executeUpdate(updateSql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            WebTables webTables = new WebTables();
            webTables.setID(id);
            String deleteSql = CreateSqlTools.getDeleteSql(webTables,true);
            System.out.println(deleteSql);
            sqliteHelper.executeUpdate(deleteSql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
