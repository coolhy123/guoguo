package com.hydu.service;

import com.hydu.mapper.CategoryMapper;
import com.hydu.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created on 2019/10/12
 * @author heyong
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByParentId(Long id){
        Category record = new Category();
        record.setParentId(id);
        return this.categoryMapper.select(record);

    }
}