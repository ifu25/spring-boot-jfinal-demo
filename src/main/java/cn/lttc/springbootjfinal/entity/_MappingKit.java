package cn.lttc.springbootjfinal.entity;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * 数据库映射
 * 作者：xinggang
 * 邮箱：willcoo@qq.com
 * 网址：https://weiku.co
 * 日期：2019-08-14
 * 说明：
 */
public class _MappingKit {
    public static void mapping(ActiveRecordPlugin arp) {
        arp.addMapping("Article", "ID", Article.class);
    }
}
