package com.ebay.utils.freemaker;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xienan on 2016/1/10.
 */
public class Generator {
    private static String url = "jdbc:mysql://10.172.17.191:3306/eby_test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
    private static String user = "ebyrtest";
    private static  String password = "sxYioke1OOtest00";
    private static  String tableName = "eby_pay_merchant";
    private static String modelName = "payMerchant";
    private static String packageName = "com.ebaoyang";

    private static String ID = "id";

    /* 获取数据库连接的函数*/
    public static Connection getConnection(String url, String user, String password) {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

            con = DriverManager.getConnection(url, user, password);// 创建数据连接

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

    public static List<String> findAllColumns(Connection conn, String tableName) {
        List<String > columns = new ArrayList<String>(10);
        try {
            String sql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = \"" + tableName + "\"";     // 查询数据的sql语句
            Statement st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            while (rs.next()) { // 判断是否还有下一个数据
                String columnName = rs.getString(1);
                if (columnName.equals(ID))
                    continue;
                columns.add(columnName);
            }
            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("查询数据失败");
        }
        return columns;
    }

    public static void generateSource(List<String> columns){

        String ModelName = Character.toUpperCase(modelName.charAt(0)) + modelName.substring(1);//
        List<Bean> fieds = new ArrayList<Bean>();
        for (String column : columns) {
            fieds.add(new Bean(column, Gen.field_solve(column)));
        }

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("packageName", packageName);
        root.put("ModelName", ModelName);
        root.put("modelName", modelName);
        root.put("fieds", fieds);
        root.put("tableName", tableName);
        root.put("SPTJ", Gen.SPTJ);

        String res;
        res = FreeMarkertUtil.getTemplate("template.ftl", "utf-8", root);
        System.out.println(res);

        res = FreeMarkertUtil.getTemplate("dao.ftl", "utf-8", root);
        System.out.println(res);

        res = FreeMarkertUtil.getTemplate("service.ftl", "utf-8", root);
        System.out.println(res);

        res = FreeMarkertUtil.getTemplate("model.ftl", "utf-8", root);
        System.out.println(res);
    }

    public static void main(String[] args){

        Connection connection = getConnection(url, user, password);
        List<String> columns = findAllColumns(connection, tableName);
        generateSource(columns);
    }
}
