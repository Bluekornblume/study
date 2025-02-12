package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {

    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);

    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);


    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
