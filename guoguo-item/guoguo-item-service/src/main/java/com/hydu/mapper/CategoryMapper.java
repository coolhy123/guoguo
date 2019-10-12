package com.hydu.mapper;

import com.hydu.pojo.Category;
import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * Created on 2019/10/12
 *
 * @author heyong
 */

public interface CategoryMapper extends Mapper<Category> {
}
