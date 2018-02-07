package com.transen.tsconnect.service;

import com.transen.tsconnect.dao.JiraMapper;
import com.transen.tsconnect.model.HospitalAnalysisVo;
import com.transen.tsconnect.model.HospitalVo;
import com.transen.tsconnect.model.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return  jiraMapper.selectHosList();
    }

    public List<UserVo> selectUserList(){
        return jiraMapper.selectUserList();
    }

    public List<HospitalAnalysisVo> selectAnalysisListByHos(HospitalAnalysisVo hospitalAnalysisVo){
        return jiraMapper.selectAnalysisListByHos(hospitalAnalysisVo);
    }

    public List<HospitalAnalysisVo> selectAanlyByPrefix(Map<String,String> param){
        return jiraMapper.selectAanlyByPrefix(param);
    }



}
