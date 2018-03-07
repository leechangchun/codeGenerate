package cn.tools.customcodeGenerate;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallGenerate {
    private final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String packageName = "com.shucong.mall";
    private final List<String> tables = Arrays.asList("book");

    public static void main(String[] args) {
        new MallGenerate().generate();
    }

    public void generate() {
        GenerateUtil generateUtil = new GenerateUtil();
        Connection conn = generateUtil.getConnection(URL, USER, PASSWORD, DRIVER);

        tables.stream().forEach(tableName-> {
            List<Field> fields = generateUtil.getFields(conn, tableName);
            Map<String,Object> map = new HashMap<>();
            map.put("model", fields);
            generateUtil.geneFile("model.flt",packageName+".model","book", map);
        });
    }
}
