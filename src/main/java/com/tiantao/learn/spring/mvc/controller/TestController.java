package com.tiantao.learn.spring.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/testmvc")
public class TestController {

    public static final String HELLO = "hello";


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView(HELLO);

        modelAndView.addObject("time",new Date());

        return modelAndView;
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        return HELLO;
    }




    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    public String rest(){
        return "asdf";
    }

    @RequestMapping(value = "method",method = RequestMethod.GET)
    public String testMethod(){
        return "testMethod";
    }

    @RequestMapping(value = "testParams",params = {"username","age"})
    public String testHeads(){
        return HELLO;
    }

    @RequestMapping(value = "testAntPath/*/abc")
    public String testAntPath(){
        Map map = new HashMap<String,Object>();
        map.put("message","testAntPath OK!");
        return HELLO;
    }

    @RequestMapping(value = "testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("variable id is :" + id);
        return HELLO;
    }

    @RequestMapping(value = "testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("rest get id:" + id);
        return HELLO;
    }

    @RequestMapping(value = "testRest",method = RequestMethod.POST)
    public String testRestPost(){
        return HELLO;
    }

    @RequestMapping(value = "testRest/{id}",method = RequestMethod.DELETE)
    @ResponseBody()
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("rest delete  id:" + id);
        return HELLO;
    }

    @RequestMapping(value = "testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("rest put id:" + id);
        return HELLO;
    }




    /**
     *
     * @param name
     * @return
     *
     * required 表示是否必须传该参数 当参数类型设置成基础类型的时候 如果传则会报错，这时就需要设置默认值
     */
    @RequestMapping(value = "testParam")
    public String testParam(@RequestParam(value="name", required = false, defaultValue = "ddd") String name){
        System.out.println("testParam name:" + name);
        return HELLO;
    }

    @RequestMapping(value = "testRequestHeader")
    public String testRequestHead(@RequestHeader(value = "Accept-Language") String language){
        System.out.println("testRequestHeader header:" + language);
        return HELLO;
    }

    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String sessionName){

        System.out.println("testCookieValue cookieValue:" + sessionName);
        return HELLO;
    }
}
