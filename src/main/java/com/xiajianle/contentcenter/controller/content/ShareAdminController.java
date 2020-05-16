package com.xiajianle.contentcenter.controller.content;

import com.xiajianle.contentcenter.domain.dto.ShareAuditDTO;
import com.xiajianle.contentcenter.domain.entity.contentCenter.Share;
import com.xiajianle.contentcenter.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ShareAdminController {

    @Resource
    private ShareService shareService;

    @PutMapping("/audit/{id}")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDTO auditDTO)
    {

        //TODO 认证 授权


        return this.shareService.auditById(id, auditDTO);
    }
}
