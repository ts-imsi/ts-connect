package com.transen.tsconnect.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2018/2/7
 */
@Getter
@Setter
public class HospitalAnalysisVo {
    private Integer id;
    private Integer issue;
    private Integer customField;
    private String stringValue;
    private String pKey;
    private Integer project;
    private Integer issueType;
    private String summary;
    private String description;
    private String customValue;

}
