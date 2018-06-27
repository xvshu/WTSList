package com.xs.java.model;

import com.xs.java.dbs.utils.annotation.FieldAnnotation;
import com.xs.java.dbs.utils.annotation.FieldType;
import com.xs.java.dbs.utils.annotation.TableAnnotation;

import java.sql.ResultSet;
import java.sql.SQLException;

@TableAnnotation(tableName="Web_Table")
public class WebTables {

    @FieldAnnotation(fieldName="ID",fieldType= FieldType.NUMBER,pk=true)
    private int ID;

    @FieldAnnotation(fieldName="ENV",fieldType=FieldType.STRING, pk = false)
    private String ENV;

    @FieldAnnotation(fieldName="TAG",fieldType=FieldType.STRING, pk = false)
    private String TAG;

    @FieldAnnotation(fieldName="NAME",fieldType=FieldType.STRING, pk = false)
    private String NAME;

    @FieldAnnotation(fieldName="URL",fieldType=FieldType.STRING, pk = false)
    private String URL;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getENV() {
        return ENV;
    }

    public void setENV(String ENV) {
        this.ENV = ENV;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public WebTables(){}

    public WebTables(int ID, String ENV, String TAG, String NAME, String URL) {
        this.ID = ID;
        this.ENV = ENV;
        this.TAG = TAG;
        this.NAME = NAME;
        this.URL = URL;
    }

    public static WebTables RowMapperToWorkCalendar(ResultSet rs)throws SQLException {
        WebTables wc= new WebTables(rs.getInt("ID"),
                rs.getString("ENV"),
                rs.getString("TAG"),
                rs.getString("NAME"),
                rs.getString("URL"));
        return wc;
    }
}
