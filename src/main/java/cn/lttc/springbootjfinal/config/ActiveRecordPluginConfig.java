package cn.lttc.springbootjfinal.config;

import cn.lttc.springbootjfinal.entity._MappingKit;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.SqlServerDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

/**
 * ActiveRecord 插件配置
 * 作者：xinggang
 * 邮箱：willcoo@qq.com
 * 网址：https://weiku.co
 * 日期：2019-08-14
 * 说明：
 */
@Configuration
public class ActiveRecordPluginConfig {
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public ActiveRecordPlugin initActiveRecordPlugin() {

        DruidPlugin druidPlugin = new DruidPlugin(url, username, password);

        WallFilter wallFilter = new WallFilter();
        wallFilter.setDbType("sqlserver");
        druidPlugin.addFilter(wallFilter);
        druidPlugin.start(); //不同于JFinal项目，需要手动启动

        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
        arp.setDialect(new SqlServerDialect()); //配置SqlServer方言
        _MappingKit.mapping(arp);
        arp.setShowSql(false);
        arp.getEngine().setToClassPathSourceFactory();
        arp.start(); //不同于JFinal项目，需要手动启动

        return arp;
    }
}
