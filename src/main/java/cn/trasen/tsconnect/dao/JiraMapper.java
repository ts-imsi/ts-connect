package cn.trasen.tsconnect.dao;

import cn.trasen.tsconnect.model.HospitalAnalysisVo;
import cn.trasen.tsconnect.model.UserVo;
import cn.trasen.tsconnect.model.HospitalVo;
import cn.trasen.tsconnect.util.MyMapper;

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
