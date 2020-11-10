package com.bilibili.cmsservice.service;

import com.bilibili.cmsservice.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author bilibili
 * @since 2020-11-02
 */
public interface CrmBannerService extends IService<CrmBanner> {

    /**
     * 查询轮播图 limit 3
     * @return 返回轮播图列表
     */
    List<CrmBanner> selectBanner();
}
