package com.transen.tsconnect.dao;

import com.transen.tsconnect.model.HospitalAnalysisVo;
import com.transen.tsconnect.model.HospitalVo;
import com.transen.tsconnect.model.UserVo;
import com.transen.tsconnect.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2018/2/7
 */
public interface JiraMapper extends MyMapper<HospitalVo> {
    List<HospitalVo> selectHosList();

    List<UserVo> selectUserList();

    List<HospitalAnalysisVo> selectAnalysisListByHos(HospitalAnalysisVo hospitalAnalysisVo);

    List<HospitalAnalysisVo> selectAanlyByPrefix(Map<String,String> param);
}
