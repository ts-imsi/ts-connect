package cn.trasen.tsconnect.model;

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
public class UserVo {
    private String id;
    private String userName;
    private String lastName;
    private String emailAddress;
    private String pwd;
}
