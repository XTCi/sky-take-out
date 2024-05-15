package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "分类管理接口")
@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @ApiOperation("新增菜品分类接口")
    @PostMapping
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增菜品分类{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }
    @ApiOperation("分类分页查询接口")
    @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.page(categoryPageQueryDTO);
        return Result.success(pageResult);

    }
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类接口")
    public Result startOrStop(@PathVariable Integer status, Long id){
        categoryService.startOrStop(status,id);
        return Result.success();
    }
    @ApiOperation("修改分类")
    @PutMapping
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }
    @ApiOperation("根据Id删除分类")
    @DeleteMapping
    public Result deleteById(Long id){
        log.info("删除分类{}",id);
        categoryService.deleteById(id);
        return Result.success();

    }
    @ApiOperation("根据类型查询商品接口")
    @GetMapping("/list")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }











}
