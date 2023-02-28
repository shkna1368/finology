package com.finology.car.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {

    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)

    private Long id;

    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer version;

    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Date createdDate;
    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)

    private String createdBy;

    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)

    private Date lastModifiedDate;

    @Schema(hidden = true,requiredMode = Schema.RequiredMode.NOT_REQUIRED)

    private String lastModifiedBy;
}
