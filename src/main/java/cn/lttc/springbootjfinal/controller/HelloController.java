package cn.lttc.springbootjfinal.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试控制器
 * 作者：xinggang
 * 邮箱：willcoo@qq.com
 * 网址：https://weiku.co
 * 日期：2019-08-14
 * 说明：
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public List<Record> index() {

        List<Record> list = Db.find("select * from Article");

        return list;
    }

    @RequestMapping("/hello")
    public String hello() {

        Record list = Db.findFirst("select * from sys_user where password='111'");

        return list.get("userName");
    }
}
