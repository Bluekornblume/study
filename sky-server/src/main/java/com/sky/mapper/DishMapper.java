package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {

    @Insert("insert into dish (name, category_id, price, image, description, status, create_time, update_time, create_user, update_user) " +
            "values" +
            "(#{name},#{categoryId},#{price}, #{image}, #{description}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}) ")
    void creatDish(Dish dish);

    void update(Dish dish);

    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    Page<Dish> pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
