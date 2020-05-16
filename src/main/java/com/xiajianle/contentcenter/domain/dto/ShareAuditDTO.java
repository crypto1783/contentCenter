package com.xiajianle.contentcenter.domain.dto;

import com.xiajianle.contentcenter.domain.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareAuditDTO {

    private AuditStatusEnum auditStatusEnum;

    private String reason;

}
