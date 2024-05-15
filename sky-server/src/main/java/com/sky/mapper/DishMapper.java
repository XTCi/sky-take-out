package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     * 根据id查询菜品数量
     * @param id
     */
    @Select("select count(id) from dish where category_id = #{category_id}")
    Integer countGetById(Long id);
}
