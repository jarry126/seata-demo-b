package com.bear.controller;

import com.bear.mapper.TestMapper;
import com.bear.model.QddArticle;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author LiuShanshan
 * @version V1.0
 * @Description
 */
@RestController
@RequestMapping("/article")
public class ArticleTestController {
    @Resource
    private TestMapper testMapper;

    @PostMapping("/QddArticle/saveOrUpdateArticle")
    @GlobalTransactional(name = "insertGlobal",rollbackFor = Exception.class)
    public void saveOrUpdateArticle(@RequestBody QddArticle qddArticle) {
        System.out.println("事务id是"+ RootContext.getXID());
        testMapper.insertData();
        System.out.println("保存成功");
    }

}
