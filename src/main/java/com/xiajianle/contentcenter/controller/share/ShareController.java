package com.xiajianle.contentcenter.controller.share;

import com.xiajianle.contentcenter.domain.dto.ShareDTO;
import com.xiajianle.contentcenter.service.content.ShareService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Resource
    private ShareService shareService;

    @GetMapping ("/{id}")
    public ShareDTO getShareId(@PathVariable Integer id){
        return shareService.findById(id);
    }

}
