package com.lujieni.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("动物园DTO")
public class ZooDTO {
    @ApiModelProperty(value = "动物园名称")
    @NotBlank(message = "动物园名称不能为空")
    private String name;
}
