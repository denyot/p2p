package com.hxf.p2p.mgrsite.base.listener;

import com.hxf.p2p.base.service.ILogininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitAdminListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ILogininfoService logininfoService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logininfoService.initAdmin();
    }
}
