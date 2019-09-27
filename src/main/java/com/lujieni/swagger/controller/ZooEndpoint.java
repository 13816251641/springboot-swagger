package com.lujieni.swagger.controller;

import com.lujieni.swagger.dto.ZooDTO;
import com.lujieni.swagger.entity.ZooEntity;
import com.lujieni.swagger.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "动物园下的接口信息")
@RestController
@RequestMapping("/api/v1/zoo")
public class ZooEndpoint {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    private final List<ZooEntity> list = new ArrayList<>();
    {   
        list.add(new ZooEntity("浦东野生动物园"));
        list.add(new ZooEntity("西郊动物园"));
    }

    @GetMapping(value = "/by_name")
    @ApiOperation(value="根据name查询动物园")
    public R<ZooDTO> queryZoo(@ApiParam(value = "动物园名字")@RequestParam String name){
        for (ZooEntity zooEntity : list) {
            if(zooEntity.getName().equals(name)) {
                return R.ok(dozerBeanMapper.map(zooEntity, ZooDTO.class));
            }
        }
        return  R.ok();
    }

    @PostMapping(value = "/add")
    @ApiOperation(value="创建动物园")
    public R create(@Valid @RequestBody ZooDTO zooDTO){
        System.out.println("hello");
        ZooEntity zooEntity = dozerBeanMapper.map(zooDTO, ZooEntity.class);
        list.add(zooEntity);
        return R.ok();
    }
}
