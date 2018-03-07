package cn.tools.customcodeGenerate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name", "Dog");
        String str  = new Main().geneFileStr("testFreeMarker.flt", map);
        Optional.ofNullable(str).ifPresent(System.out::println);
        try {
            new Main().generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate() throws Exception {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getColumns(null, "%", "book", "%");

        while(resultSet.next()){
            //id字段略过
            System.out.println(resultSet.getString("COLUMN_NAME"));
        }

    }
    public Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public String geneFileStr(String templateFileName, Map<String, Object> propMap)  {
        try {
            File file1 = new File("./customCodeGenerate/src/main/java/cn/out/");
            file1.mkdirs();
            FileWriter out = new FileWriter(file1.getPath()+"/out.java");
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            String file = getClass().getResource("/").getFile();
            cfg.setDirectoryForTemplateLoading(new File(file));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            Template tmp = cfg.getTemplate(templateFileName,"UTF-8");
            tmp.process(propMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "";
    }
}
