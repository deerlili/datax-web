package com.wugui.datax.admin.tool.datax.writer;

/**
 * mysql writer构建类
 *
 * @author zhouhongfa@gz-yibo.com
 * @ClassName MysqlWriter
 * @Version 1.0
 * @since 2019/7/30 23:08
 */
public class DorisWriter extends BaseWriterPlugin implements DataxWriterInterface {

    @Override
    public String getName() {
        return "doriswriter";
    }
}
