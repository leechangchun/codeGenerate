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
    private static final List<String> tables = Arrays.asList("topics");

    public static void main(String[] args) {
        GenerateUtil generateUtil = new GenerateUtil();
        Connection conn = generateUtil.getConnection(URL, USER, PASSWORD, DRIVER);

        tables.stream().forEach(tableName-> {
            Map<String,Object> map = new HashMap<>();
            map.put("model", generateUtil.getFields(conn, tableName));

            generateUtil.geneJava("model.flt",packageName+".entity",tableName,"", map);
            generateUtil.geneJava("controller.flt",packageName+".controllers.api",tableName,"Controller", map);
            generateUtil.geneJava("manageController.flt",packageName+".controllers.manage",tableName,"Controller", map);
            generateUtil.geneJava("mapper.flt",packageName+".mapper",tableName,"Mapper", map);

            generateUtil.geneMappers("mapperXml.flt",packageName+".mappers",tableName,"Mapper", map);

            generateUtil.geneTemp("list.flt","",tableName,"", map);
            generateUtil.geneTemp("add.flt","",tableName,"", map);
            generateUtil.geneTemp("update.flt","",tableName,"", map);

        });
    }
}
