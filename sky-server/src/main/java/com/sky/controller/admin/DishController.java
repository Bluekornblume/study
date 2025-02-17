package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
@Api(tags = "料理管理")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("料理を増加")
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("新しい料理を増加:{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @PostMapping("/stauts/{status}")
    @ApiOperation("料理の状態変更")
    public Result startOrStop(@PathVariable("status") Integer status, Long id) {
        log.info("料理の状態変更:{}, {}", status, id);
        dishService.startOrStop(status, id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("料理の情報編集")
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("料理の情報編集:{}", dishDTO);
        dishService.update(dishDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("idでサーチ")
    public Result<Dish> getById(@PathVariable Long id) {
        log.info("idでサーチ:{}", id);
        Dish dish = dishService.getById(id);
        return Result.success(dish);
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("page query")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO ) {
        log.info("菜品分页:{}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 菜品批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("料理を削除delete dish")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("菜品批量删除:{}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
}
