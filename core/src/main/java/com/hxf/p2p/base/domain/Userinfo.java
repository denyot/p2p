package com.hxf.p2p.base.domain;

import com.hxf.p2p.base.util.BitStatesUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * 个人资料
 */
@Getter
@Setter
public class Userinfo {
    private Long id;

    private Integer version;//版本号

    private Long bitState;//用户状态码

    private String realName;//真实姓名

    private String idNumber;//身份证号

    private String phoneNumber;//手机号

    private String email;//邮箱

    private Systemdictionaryitem incomeGrade;//收入

    private Systemdictionaryitem marriage;//婚姻情况

    private Systemdictionaryitem kidCount;//子女情况

    private Systemdictionaryitem educationBackground;//学历

    private Systemdictionaryitem houseCondition;//居住状况

    /**
     * 是否绑定手机
     *
     * @return
     */
    public Boolean getIsBindPhone() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BIND_PHONE);
    }

    /**
     * 是否绑定邮箱
     *
     * @return
     */
    public Boolean getIsBindEmail() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BIND_EMAIL);
    }

}