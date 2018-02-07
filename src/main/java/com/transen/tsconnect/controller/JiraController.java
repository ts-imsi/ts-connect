package com.transen.tsconnect.controller;

import cn.trasen.core.entity.Result;
import com.transen.tsconnect.model.HospitalVo;
import com.transen.tsconnect.service.JiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2018/2/7
 */
@RestController
@RequestMapping(value="/jira")
public class JiraController {
    private final static Logger logger = LoggerFactory.getLogger(JiraController.class);

    @Autowired
    JiraService jiraService;

    @PostMapping(value="/selectHosList")
    public Result selectHosList(){
        Result result=new Result();
        try{
            List<HospitalVo> hospitalVoList=jiraService.selectHosList();
            result.setObject(hospitalVoList);
            result.setSuccess(true);
        }catch (Exception e){
            logger.error("数据查询失败"+e,e.getMessage());
            result.setMessage("医院数据查询失败");
            result.setSuccess(false);
        }
        return result;
    }
}
