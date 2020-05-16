package com.xiajianle.contentcenter.controller;


import com.xiajianle.contentcenter.dao.contentCenter.ShareMapper;
import com.xiajianle.contentcenter.domain.entity.contentCenter.Share;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private ShareMapper shareMapper;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("test2")
    public List<ServiceInstance> getInstance()
    {
        return this.discoveryClient.getInstances("user-center");
    }
    @GetMapping("/addShare")
    public Share addShare()
    {
        Share share = new Share();
        share.setAuthor("xia");
        share.setBuyCount(1);
        share.setTitle("haokan");
        share.setDownloadUrl("baidu.com");
        share.setBuyCount(1);
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        shareMapper.insertSelective(share);
        return share;

    }
}
