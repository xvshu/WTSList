package sqlite;


import com.xs.java.dbs.sqlite.SqliteHelper;
import com.xs.java.dbs.utils.CreateSqlTools;
import com.xs.java.model.WebTables;
import com.xs.java.model.WebTablesRowMapper;

import java.util.List;

public class ModelTest {

    public static void main(String[] args)throws  Exception {
        testHelper2insert();
    }



    public static void testHelper2insert() throws Exception {
//        WebTables obj = new WebTables(4,"测试2","默认","TEST","http://localhost:8899/#/three");
//        String insertSql = CreateSqlTools.getInsertSql(obj);
//        SqliteHelper h = SqliteHelper.getInstance();
//        System.out.println(h.executeUpdate(insertSql));


    }

    public static void testHelper1query() throws Exception {

        WebTables webTables = new WebTables();
        String selectAllSql = CreateSqlTools.getSelectSql(webTables);
        List<WebTables> sList = new SqliteHelper().executeQuery(selectAllSql, new WebTablesRowMapper());
        System.out.println(sList.size());


    }
}
