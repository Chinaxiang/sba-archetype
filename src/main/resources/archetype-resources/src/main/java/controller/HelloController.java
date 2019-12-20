#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import ${package}.orm.dao.BaseDAO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanxiang.huang
 */
@Controller
@Slf4j
public class HelloController {

    @Value("${symbol_dollar}{spring.profiles.active}")
    private String profile;
    @Resource
    private BaseDAO baseDao;

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello(String name, HttpServletRequest request) {
        log.info("requestURL：{}", request.getRequestURL());
        log.info("queryString：{} ", request.getQueryString());

        Map<String, Object> map = new HashMap<>(3);
        map.put("code", 200);
        map.put("msg", "Hello:" + name);
        map.put("profile", profile);
        map.put("data", baseDao.findAll());
        log.info("map json:" + JSON.toJSONString(map, true));
        return map;
    }

}
