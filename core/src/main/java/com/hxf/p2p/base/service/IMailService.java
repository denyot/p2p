package com.hxf.p2p.base.service;

/**
 * 发送邮件
 */
public interface IMailService {
    /**
     * @param target  对方邮箱
     * @param title   邮件标题
     * @param content 邮件内容
     */
    void sendMail(String target, String title, String content);
}
