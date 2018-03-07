package cn.tools.customcodeGenerate;

import com.sun.xml.internal.ws.util.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateUtil {
    /**获取数据库连接*/
    public Connection getConnection(String URL,String USER,String PASSWORD,String DRIVER){
        try {
            Class.forName(DRIVER);
            Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**根据表名取出字段*/
    public List<Field> getFields(Connection connection,String tableName) {
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
            List<Field> fields = new ArrayList<>();
            while (resultSet.next()) {
                Field field = new Field();
                field.setName(resultSet.getString("COLUMN_NAME"));
                field.setType(sqlType2javaType(resultSet.getString("TYPE_NAME")));
                fields.add(field);
            }
            return fields;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sqlType2javaType(String sqlType) {
        switch (sqlType) {
            case "VARCHAR":
            case "TEXT":
                return "String";
            case "INT":
                return "int";
            case "DECIMAL":
                return "double";
            default:
                return sqlType;
        }
    }
    /**生成类文件*/
    public void geneFile(String templateFileName,String packageName, String tableName, Map<String, Object> dataMap) {
        try {
            dataMap.put("packageName", packageName);
            dataMap.put("tableName", getDomainName(tableName));
            String fileName = "./customCodeGenerate/src/main/java/" + packageName.replace('.', '/');

            File file1 = new File(fileName);
            file1.mkdirs();
            FileWriter out = new FileWriter(file1.getPath() + "/" + getDomainName(tableName) + ".java");

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            String file = getClass().getResource("/").getFile();
            cfg.setDirectoryForTemplateLoading(new File(file));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            Template tmp = cfg.getTemplate(templateFileName, "UTF-8");
            tmp.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**将表名转换为实体类名*/
    public String getDomainName(String tableName){
        StringBuffer sb = new StringBuffer();
        sb.append(tableName);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }
}