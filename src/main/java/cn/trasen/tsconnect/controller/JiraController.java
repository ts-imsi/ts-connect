package cn.trasen.tsconnect.controller;

import cn.trasen.core.entity.Result;
import cn.trasen.tsconnect.model.HospitalAnalysisVo;
import cn.trasen.tsconnect.model.HospitalVo;
import cn.trasen.tsconnect.model.UserVo;
import cn.trasen.tsconnect.service.JiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            logger.error("数据查询失败"+e.getMessage(),e);
            result.setMessage("医院数据查询失败");
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping(value="/selectUserList")
    public Result selectUserList(){
        Result result=new Result();
        try{
            List<UserVo> userVoList=jiraService.selectUserList();
            result.setObject(userVoList);
            result.setSuccess(true);
        }catch (Exception e){
            logger.error("用户数据查询失败"+e.getMessage(),e);
            result.setSuccess(false);
            result.setMessage("用户数据查询失败");
        }
        return result;
    }

    @PostMapping(value="/selectAnalysisListByHos")
    public Result selectAnalysisListByHos(@RequestBody Map<String,String> param){
        Result result=new Result();
        try{
            HospitalAnalysisVo hospitalAnalysisVo=new HospitalAnalysisVo();
            if(param.isEmpty()){
                result.setMessage("参数错误");
                result.setSuccess(false);
            }else{
                Optional<String> cusOp=Optional.ofNullable(param.get("customValue"));
                Optional<String> strOp=Optional.ofNullable(param.get("stringValue"));
                if(cusOp.isPresent()) hospitalAnalysisVo.setCustomValue(cusOp.get());
                if(strOp.isPresent()) hospitalAnalysisVo.setStringValue(strOp.get());

                List<HospitalAnalysisVo> hospitalAnalysisVos=jiraService.selectAnalysisListByHos(hospitalAnalysisVo);
                result.setObject(hospitalAnalysisVos);
                result.setSuccess(true);
            }
        }catch (Exception e){
            logger.error("医院查询需求失败"+e.getMessage(),e);
            result.setMessage("医院查询需求失败");
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping(value = "/selectAanlyByPrefix")
    public Result selectAanlyByPrefix(@RequestBody Map<String,String> param){
        Result result=new Result();
        try{
            if(param.isEmpty()){
                result.setSuccess(false);
                result.setMessage("参数错误");
            }else{
                Optional<String> preOp=Optional.ofNullable(param.get("prefix"));
                Optional<String> verOp=Optional.ofNullable(param.get("version"));
                if(!preOp.isPresent()||!verOp.isPresent()){
                    result.setSuccess(false);
                    result.setMessage("参数错误");
                    return result;
                }
                List<HospitalAnalysisVo> hospitalAnalysisVos=jiraService.selectAanlyByPrefix(param);
                result.setObject(hospitalAnalysisVos);
                result.setSuccess(true);
            }
        }catch (Exception e){
            logger.error("数据查询失败"+e.getMessage(),e);
            result.setSuccess(false);
            result.setMessage("数据查询失败");
        }
        return result;
    }
}
