package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;

public interface DishService {

    void creatDish(DishDTO dishDTO);

    void startOrStop(Integer status, Long id);

    void update(DishDTO dishDTO);

    Dish getById(Long id);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
