package com.bilibili.cmsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bilibili.cmsservice.entity.CrmBanner;
import com.bilibili.cmsservice.mapper.CrmBannerMapper;
import com.bilibili.cmsservice.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author bilibili
 * @since 2020-11-02
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Autowired
    private RedisTemplate redisTemplate;
    //Raw use of parameterized class 'RedisTemplate'

    /**
     * 查询轮播图 limit 3
     *
     * @return 返回轮播图列表
     */
//    @Override
//    public List<CrmBanner> selectBanner() {
//        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id").last("limit 3");
//        return baseMapper.selectList(queryWrapper);
//    }

    /**
     * 查询轮播图 limit 3
     *
     * @return 返回轮播图列表
     */
    @Override
    public List<CrmBanner> selectBanner() {

        List<CrmBanner> banners = (List<CrmBanner>) redisTemplate.opsForValue().get("banners");
        if (banners==null){
            QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("id").last("limit 3");
            List<CrmBanner> list = baseMapper.selectList(queryWrapper);
            redisTemplate.opsForValue().set("banners",list);
            return list;
        }else {
            return banners;
        }

    }
}
