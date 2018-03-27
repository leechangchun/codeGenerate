package cn.tools.customcodeGenerate;

import com.sun.xml.internal.ws.util.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public List<String> getTableNames(Connection connection){
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet rs = databaseMetaData.getTables(connection.getCatalog(), "%", "%", new String[]{"TABLE"});
            while(rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**根据表名取出字段*/
    public List<Field> getFields(Connection connection,String tableName) {
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            ResultSet resultSet = databaseMetaData.getColumns(connection.getCatalog(), "%", tableName, "%");
            List<Field> fields = new ArrayList<>();
            while (resultSet.next()) {
                Field field = new Field();
                field.setColumn(resultSet.getString("COLUMN_NAME"));
                field.setName(getFileName(field.getColumn()));
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
            case "CHAR":
            case "DATETIME":
            case "TIMESTAMP":
                return "String";
            case "INT":
            case "TINYINT":
            case "BIT":
                return "Integer";
            case "DECIMAL":
                return "Double";
            case "BIGINT":
                return "Long";
            default:
                return sqlType;
        }
    }
    /**生成类文件*/
    public void geneJava(String templateFileName, String packageName, String tableName, String classFix, Map<String, Object> dataMap) {
        gene(1,templateFileName,packageName,tableName,classFix, dataMap);
    }

    /**生成映射文件*/
    public void geneMappers(String templateFileName,String packageName, String tableName,String classFix, Map<String, Object> dataMap) {
        gene(2,templateFileName,packageName+".mappers",tableName,classFix, dataMap);
    }

    public void geneTemp(String templateFileName, String packageName, String tableName, String classFix, Map<String, Object> dataMap) {
        gene(3,templateFileName,packageName+".mappers",tableName,classFix, dataMap);
    }

    /**生成类文件*/
    public void gene(int type,String templateFileName,String packageName, String tableName,String classFix, Map<String, Object> dataMap) {
        try {
            String domainName = getDomainName(tableName);
            if(domainName.endsWith("s")){
                domainName = domainName.substring(0,domainName.length()-1);
            }
            dataMap.put("packageName", packageName);
            dataMap.put("tableName", tableName);
            dataMap.put("domainName", domainName);

            String fileName,floder;

            if(type==1) {
                floder = "./app/src/main/java/" + packageName.replace('.', '/');
                fileName = domainName + classFix + ".java";
            } else if (type==2){
                floder = "./app/src/main/resources/mybatis/mapper/";
                fileName = domainName.toLowerCase() + ".xml";
            } else {
                floder = "./app/src/main/resources/templates/manage/"+domainName.toLowerCase();
                fileName = templateFileName.substring(0,templateFileName.indexOf('.'))  +  ".ftl";
            }

            File file = new File(floder);
            file.mkdirs();
            FileWriter out = new FileWriter(file.getPath() + "/" + fileName);

            Template tmp = getTemplate(templateFileName);
            tmp.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**获取模板*/
    private Template getTemplate(String templateFileName) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        String file = getClass().getResource("/").getFile();
        cfg.setDirectoryForTemplateLoading(new File(file));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg.getTemplate(templateFileName, "UTF-8");
    }

    public String getFileName(String src) {
        return lowerName(getDomainName(src));
    }

    //首字母大写
    public static String lowerName(String name) {
        char[] cs=name.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);

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
