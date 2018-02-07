package com.transen.tsconnect.service;

import com.transen.tsconnect.dao.JiraMapper;
import com.transen.tsconnect.model.HospitalVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2018/2/7
 */
@Service
public class JiraService {

    private final static Logger logger = LoggerFactory.getLogger(JiraService.class);

    @Autowired
    JiraMapper jiraMapper;

    public List<HospitalVo> selectHosList(){
        return jiraMapper.selectHosList();
    }


}
