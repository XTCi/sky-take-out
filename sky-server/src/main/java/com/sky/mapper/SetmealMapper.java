package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {
    /**
     * 根据id查询套餐数量
     * @param id
     */
    @Select("select count(id) from setmeal where category_id = #{category_id}")
    Integer countGetById(Long id);
}
