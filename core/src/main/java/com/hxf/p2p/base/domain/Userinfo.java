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

    private Long bitState = 0l;//用户状态码
    private Long realAuthId;//实名认证id

    private String realName;//真实姓名

    private String idNumber;//身份证号

    private String phoneNumber;//手机号

    private String email;//邮箱

    private Integer authScore;//认证分数

    private Systemdictionaryitem incomeGrade;//收入

    private Systemdictionaryitem marriage;//婚姻情况

    private Systemdictionaryitem kidCount;//子女情况

    private Systemdictionaryitem educationBackground;//学历

    private Systemdictionaryitem houseCondition;//居住状况

    /**
     * 移除状态码
     */
    public void removeState(Long state) {
        setBitState(BitStatesUtils.removeState(this.bitState, state));
    }


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

    /**
     * 是否填写用户资料
     */
    public Boolean getIsBaseInfo() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BASE_INFO);
    }

    /**
     * 是否身份认证
     *
     * @return
     */
    public Boolean getIsRealAuth() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_REAL_AUTH);
    }

    /**
     * 是否视频认证
     *
     * @return
     */
    public Boolean getIsVedioAuth() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_REAL_AUTH);
    }

    /**
     * 是否有借款流程
     *
     * @return
     */
    public Boolean getHasBidrequstProcess() {
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_HAS_BIDREQUST_IN_PROCESS);
    }


}