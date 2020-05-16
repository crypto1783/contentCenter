package com.xiajianle.contentcenter.service.content;
import com.xiajianle.contentcenter.domain.dto.ShareAuditDTO;
import com.xiajianle.contentcenter.domain.dto.ShareDTO;
import com.xiajianle.contentcenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.xiajianle.contentcenter.domain.entity.contentCenter.Share;
import com.xiajianle.contentcenter.feignclient.UserCenterFeignClient;
import com.xiajianle.contentcenter.dao.contentCenter.ShareMapper;
import com.xiajianle.usercenter.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;


@Service
@Slf4j
public class ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Resource
    private RestTemplate restTemplate;


    //@Resource
    //private DiscoveryClient discoveryClient;
    @Resource
    private UserCenterFeignClient userCenterFeignClient;

    @Resource
    private RocketMQTemplate roctetMQTemplate;

    public ShareDTO findById(Integer id)
    {
        Share share =  shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();

        //List<ServiceInstance> instances = discoveryClient.getInstances("user-center");

        /**
         * stream
         * lambda表达式
         * functional 函数式编程
         */
        /*String targetURL = instances.stream()
                .map( instance-> instance.getUri().toString() +"/users/{id}")
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("当前没有实例"));*/
        /*List<String> targetURLList = instances.stream()
                .map( instance-> instance.getUri().toString() +"/users/{id}")
                .collect(Collectors.toList());
        int i = ThreadLocalRandom.current().nextInt(targetURLList.size());
        UserDTO user = restTemplate.getForObject(targetURLList.get(i), UserDTO.class, id);*/


        //UserDTO user = restTemplate.getForObject("http://user-center/users/{id}", UserDTO.class, id);
        UserDTO user = this.userCenterFeignClient.findById(userId);
        System.out.println("user = " + user);
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(user.getWxNickname());
        return shareDTO;
    }

    public Share auditById(Integer id, ShareAuditDTO auditDTO) {
        //1.查询share是否存在 不存在或者当前stauts != NOT_YET 抛出异常
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (null == share)
        {
            new IllegalArgumentException("参数非法，该分享不存在");
        }

        if (!Objects.equals("NOT_YET", share.getAuditStatus()))
        {
            new IllegalArgumentException("参数非法，该分享已经审核通过或者拒绝");

        }

        //2.审核资源 将状态设置为PASS REJECT
        share.setAuditStatus(auditDTO.getAuditStatusEnum().toString());
        this.shareMapper.updateByPrimaryKey(share);
        //3.设置为PASS 那么为发布人添加积分
        this.roctetMQTemplate.convertAndSend("add-bonus",
                UserAddBonusMsgDTO.builder()
                .userId(share.getUserId())
                .bonus(50)
                .build()
        );



        return null;
    }

    /* public static void main(String[] args) {
   *//*     UserDTO user = restTemplate.getForObject("http://localhost:8080/users/{id}}", UserDTO.class, 1);
        System.out.println("user===" + user);*//*

    }*/
}
