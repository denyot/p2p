package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MailServiceImplTest {
    @Autowired
    private IMailService mailService;

    @Test
    public void sendMail() throws Exception {
        mailService.sendMail("huxinfeng66@gmail.com", "测试", "<a href='xxx'>点这里</a>");
    }

}