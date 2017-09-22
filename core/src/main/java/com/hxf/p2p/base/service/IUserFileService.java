package com.hxf.p2p.base.service;

import com.hxf.p2p.base.domain.Userfile;

import java.util.List;

public interface IUserFileService {
    void apply(String fileName);

    /**
     * 列出用户没有选择资料类型的资料
     * @param logininfoId
     * @return
     */
    List<Userfile> listUnTypeFiles(Long logininfoId);
}
