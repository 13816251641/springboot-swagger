package com.lujieni.swagger.controller;

import com.lujieni.swagger.dto.ZooDTO;
import com.lujieni.swagger.entity.ZooEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ZooDTO queryZoo(String name){
        for (ZooEntity zooEntity : list) {
            if(zooEntity.getName().equals(name)) {
                return dozerBeanMapper.map(zooEntity, ZooDTO.class);
            }
        }
        return  null;
    }

    @PostMapping(value = "/zoo")
    @ApiOperation(value="创建动物园")
    public void create(@RequestBody ZooDTO zooDTO){
        System.out.println("hello");
        ZooEntity zooEntity = dozerBeanMapper.map(zooDTO, ZooEntity.class);
        list.add(zooEntity);
        System.out.println(zooEntity);
        System.out.println("创建成功");
    }




}
