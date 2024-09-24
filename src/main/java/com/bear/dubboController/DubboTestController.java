package com.bear.dubboController;

import com.bear.dubboclient.HelloService;
import com.bear.dubboclient.RPCService;
import com.bear.mapper.TestMapper;
import com.bear.model.QddArticle;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author LiuShanshan
 * @version V1.0
 * @Description
 */
@RestController
@RequestMapping("/dubbo/test")
public class DubboTestController {

    // 加入这个注解，告诉这个是dubbo远程服务调用
    @DubboReference
    private RPCService rpcService;


    @GetMapping("/test")
    public void saveOrUpdateArticle() {
        String helllo = rpcService.sayHelllo("你好");
        System.out.println(helllo);
    }

}
