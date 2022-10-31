package com.lqj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqj.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author lqj
 * @Date 2022-10-25 9:19
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long id);
}
