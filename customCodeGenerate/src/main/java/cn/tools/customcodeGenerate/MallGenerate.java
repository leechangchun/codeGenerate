package cn.tools.customcodeGenerate;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallGenerate {
//    private final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private static final String URL = "jdbc:mysql://192.168.1.222:3306/shucong_mall?characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String packageName = "com.shucong.mall";
    private static final List<String> tables = Arrays.asList("carts","orders","orders_package","orders_package_detail"
            ,"product_attribute_values","product_attributes","product_sku","products");

    public static void main(String[] args) {
        GenerateUtil generateUtil = new GenerateUtil();
        Connection conn = generateUtil.getConnection(URL, USER, PASSWORD, DRIVER);

        tables.stream().forEach(tableName-> {
            List<Field> fields = generateUtil.getFields(conn, tableName);
            Map<String,Object> map = new HashMap<>();
            map.put("model", fields);
            generateUtil.geneFile("model.flt",packageName+".bean",tableName,"", map);
            generateUtil.geneFile("controller.flt",packageName+".controllers",tableName,"Controller", map);
            generateUtil.geneFile("mapper.flt",packageName+".mapper",tableName,"Mapper", map);
        });
    }
}
