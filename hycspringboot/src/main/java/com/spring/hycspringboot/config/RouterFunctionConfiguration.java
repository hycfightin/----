package com.spring.hycspringboot.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring.hycspringboot.domain.User;
import com.spring.hycspringboot.repostry.UserRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

//定义路由  controller的路由 等同于定义了一个postmaping
@Configuration
//zhege 注解可以理解成为一个xml文件
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 定义请求对象 接口 ServletRequest 或者 HttpServletRequest
     * 定义返回对象 接口 ServletReponse 或者 HttpServletReponse
     * Spring 5.0以后重新定义了servlet的接口 重新的封装了一下
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 既可以支持Servlet也可以支持自定义 如 Netty web server  自定义endpoint  可以理解为一个rest的暴漏
     * 以本例子：定义了一个 GET 请求 返回所有的用户对象 URL:/person/find/all
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll (UserRepository userRepository) {
        //Collection<User> users= userRepository.findAll();
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Collection<User> users= userRepository.findAll();
                    //Mono<ServerResponse> reponse = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
//                    String []aa = new String[1];
//                    String sss = "我想今年好好学习 好好减肥 明年 能去阿里巴巴或者腾讯在成都的分部门 瘦瘦的再娶个成都的妹子";
//                    JSONObject ss = new JSONObject();
//                    ss.put("目标",sss);
//                    JSONArray NN =new JSONArray();
//                    NN.add(ss);
//                    Flux<JSONArray> WISH = Flux.fromIterable(NN);
//                    ServerResponse.ok().body(userFlux,User.class);
                    return ServerResponse.ok().body(userFlux,User.class);
                    //return ServerResponse.ok().body(WISH,JSONArray.class);
                });
    }

}
