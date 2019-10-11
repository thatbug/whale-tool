package org.thatbug.whale.core.develop;

import org.thatbug.whale.core.develop.support.WhaleCodeGenerator;

/**
 * 代码生成器
 *
 * @author qzl
 * @date 11:10 2019/9/18
 */
public class CodeGenerator {

    /**
     * 数据据url
     */
    public static String DATASOURCE_URL="jdbc:mysql://localhost:3306/whale?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&tinyInt1isBit=false&serverTimezone=GMT%2B8";

    /**
     * 需要生成的表名(两者只能取其一)
     */
    public static String[] INCLUDE_TABLES = {};


    /**
     * 是否包含基础业务字段
     */
    public static Boolean HAS_SUPER_ENTITY = Boolean.TRUE;

    /**
     * 基础业务字段
     */
    public static String[] SUPER_ENTITY_COLUMNS = {"create_time", "create_user", "update_time", "update_user", "status", "is_deleted"};


    /**
     * 代码生成的包名
     */
    public static String PACKAGE_NAME = "org.thatbug.whale.test";

    /**
     * 代码所在服务名
     */
    public static String SERVICE_NAME = "whale-system";

    /**
     * 代码生成的模块名
     */
    public static String CODE_NAME = "应用管理";


    /**
     * 有包装类
     */
    public static Boolean HAS_WRAPPER = Boolean.TRUE;

    /**
     * 需要去掉的表前缀
     */
    public static String[] TABLE_PREFIX = {""};

    /**
     * 需要排除的表名(两者只能取其一)
     */
    public static String[] EXCLUDE_TABLES = {};




    /**
     * RUN THIS
     */
    public static void run() {
        WhaleCodeGenerator generator = new WhaleCodeGenerator();
        generator.setUrl(DATASOURCE_URL);
        generator.setCodeName(CODE_NAME);
        generator.setServiceName(SERVICE_NAME);
        generator.setPackageName(PACKAGE_NAME);
        generator.setTablePrefix(TABLE_PREFIX);
        generator.setIncludeTables(INCLUDE_TABLES);
        generator.setExcludeTables(EXCLUDE_TABLES);
        generator.setHasSuperEntity(HAS_SUPER_ENTITY);
        generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        generator.setHasWrapper(HAS_WRAPPER);
        generator.run();
    }

}

