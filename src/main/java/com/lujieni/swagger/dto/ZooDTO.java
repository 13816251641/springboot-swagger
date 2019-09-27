package com.lujieni.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("动物园DTO")
public class ZooDTO {
    @ApiModelProperty(value = "动物园名称")
    private String name;
}
