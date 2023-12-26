package com.ouc.lenovoshop.utils.generate;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import static com.ouc.lenovoshop.utils.generate.CodeGenerator.*;

/**
 * 生成数据库表对应的实体类
 */
public class EntityGenerator {

    /**
     * 生成实体类
     *
     * @param tableName 表名称
     */
    public static void generate(String tableName) {
        Table table = getTableColumns(tableName);  // 获取数据库表和字段信息
        String className = getEntityClassName(tableName);
        StringBuilder builder = StrUtil.builder()
                .append("package ").append(basePackageName).append(".entity;").append("\n\n");
        // 生成导包
        builder.append("import java.io.Serializable;").append("\n");
        if (table.getTableColumns().stream().anyMatch(tableColumn -> tableColumn.getJavaType().equals("date"))) {
            builder.append("import java.util.Date;").append("\n");
        }
        if (table.getTableColumns().stream().anyMatch(tableColumn -> tableColumn.getJavaType().equals("BigDecimal"))) {
            builder.append("import java.math.BigDecimal;").append("\n");
        }
        builder.append("\n");
        // 生成注释
        builder.append("/**\n").append(" * ").append(table.getTableComment()).append("\n").append("*/\n");
        // 生成class
        builder.append("public class ").append(className).append(" implements Serializable").append(" {\n");
        // 生成字段
        builder.append(getSpace(4)).append("private static final long serialVersionUID = 1L;\n\n");
        for (TableColumn tableColumn : table.getTableColumns()) {
            builder.append(getSpace(4)).append("/** ").append(tableColumn.getComment()).append(" */\n");
            builder.append(getSpace(4)).append("private ").append(tableColumn.getJavaType()).append(" ").append(StrUtil.toCamelCase(tableColumn.getName())).append(";\n");
        }
        builder.append("\n");
        // 生成getter和setter
        for (TableColumn tableColumn : table.getTableColumns()) {
            String camelName = StrUtil.toCamelCase(tableColumn.getName());
            builder.append(getSpace(4)).append("public ").append(tableColumn.getJavaType()).append(" get")
                    .append(StrUtil.upperFirst(camelName)).append("() {\n")
                    .append(getSpace(8)).append("return ").append(camelName).append(";\n")
                    .append(getSpace(4)).append("}\n\n");

            builder.append(getSpace(4)).append("public void").append(" set")
                    .append(StrUtil.upperFirst(camelName)).append("(")
                    .append(tableColumn.getJavaType()).append(" ").append(camelName).append(") {\n")
                    .append(getSpace(8)).append("this.").append(camelName).append(" = ")
                    .append(camelName).append(";\n").append(getSpace(4)).append("}\n\n");
        }
        builder.append("}");
        // 把字符串写出到文件
        FileUtil.writeString(builder.toString(), javaFilePath + packageToPath() + "/entity/" + className + ".java", "UTF-8");
        System.out.println(className + ".java 生成成功");
    }

}
