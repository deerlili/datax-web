package com.wugui.datax.admin.tool.meta;

/**
 * MySQL数据库 meta信息查询
 *
 * @author zhouhongfa@gz-yibo.com
 * @ClassName MySQLDatabaseMeta
 * @Version 1.0
 * @since 2019/7/17 15:48
 */
public class DorisDatabaseMeta extends BaseDatabaseMeta{

    private volatile static DorisDatabaseMeta single;

    public static DorisDatabaseMeta getInstance() {
        if (single == null) {
            synchronized (DorisDatabaseMeta.class) {
                if (single == null) {
                    single = new DorisDatabaseMeta();
                }
            }
        }
        return single;
    }

    @Override
    public String getSQLQueryComment(String schemaName, String tableName, String columnName) {
        return String.format("SELECT COLUMN_COMMENT FROM information_schema.COLUMNS where TABLE_SCHEMA = '%s' and TABLE_NAME = '%s' and COLUMN_NAME = '%s'", schemaName, tableName, columnName);
    }

    @Override
    public String getSQLQueryPrimaryKey() {
        return "select column_name from information_schema.columns where table_schema=? and table_name=? and column_key = 'PRI'";
    }

    @Override
    public String getSQLQueryTables() {
        return "show tables";
    }

    @Override
    public String getSQLQueryColumns(String... args) {
        return "select column_name from information_schema.columns where table_schema=? and table_name=?";
    }

    /**
     * 在mysql中 scheme与database同义词。
     * 如果需要schema 则return "show databases";
     *
     * @param args
     * @return
     */
    @Override
    public String getSQLQueryTableSchema(String... args) {
        return "show databases";
    }
}