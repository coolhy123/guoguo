package com.hydu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hydu.mapper.BrandMapper;
import com.hydu.pojo.Brand;
import com.hydu.pojo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created on 2019/11/5
 * @author heyong
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

   public PageResult<Brand> queryBrandByPageAndSort(Integer page,Integer size,String sortBy,boolean desc,String key){
        //开始分页
       PageHelper.startPage(page,size);
       //过滤
       Example example = new Example(Brand.class);

       if(StringUtils.isNotBlank(key)){
           example.createCriteria().andLike("name","%"+key+"%")
                   .orEqualTo("letter",key);
       }
       //排序
       if(StringUtils.isNotBlank(sortBy)){
           String orderByClause = sortBy + (desc ? " DESC" : " ASC");
           example.setOrderByClause(orderByClause);
       }
       //查询
       Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);


       return new PageResult<>(pageInfo.getTotal(),pageInfo);


   }

   public int deleteBrandById(Long id){
       Brand brand = new Brand();
       brand.setId(id);
      return  this.brandMapper.deleteByPrimaryKey(brand);
   }

}