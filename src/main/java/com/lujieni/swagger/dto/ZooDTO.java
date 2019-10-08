package com.lujieni.swagger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel("动物园DTO")
public class ZooDTO {
    @ApiModelProperty(value = "动物园名称",required = true)//required = true显示有红*,但没强制作用
    @NotBlank(message = "动物园名称不能为空")
    private String name;

    @ApiModelProperty(value = "日期",required = true)
    //@NotBlank
    //@Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}$",message = "日期字段必须为yyyy-MM-dd格式")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


}
