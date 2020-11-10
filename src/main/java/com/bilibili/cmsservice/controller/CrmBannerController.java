package com.bilibili.cmsservice.controller;


import com.bilibili.cmsservice.entity.CrmBanner;
import com.bilibili.cmsservice.service.CrmBannerService;
import com.bilibili.commonutils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author bilibili
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/cmsservice/banner")
//@CrossOrigin({"http://localhost:9528","http://localhost:3005"})
@Api(value = "crmBannerController",tags = {"轮播图操作接口"})
public class CrmBannerController {

    @Autowired
    private CrmBannerService crmBannerService;




    @ApiOperation(value = "获取轮播图列表")
    @GetMapping("selectBanner")
    public Result selectBanner(){
        List<CrmBanner> list = crmBannerService.selectBanner();
        return Result.ok().data("banners",list);
    }
}

