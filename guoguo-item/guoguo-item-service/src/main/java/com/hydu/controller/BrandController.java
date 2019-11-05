package com.hydu.controller;

import com.hydu.pojo.Brand;
import com.hydu.pojo.Category;
import com.hydu.pojo.PageResult;
import com.hydu.service.BrandService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/11/5
 * @author heyong
 */

@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandservice;

    /**
     * @param page 第几页
     * @param size 每页显示多少条
     * @param sortBy 根据某个字段排序
     * @param desc 倒序排序
     * @param key  根据key来查询
     * @return
     */
    @RequestMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                                              @RequestParam(value = "rows", defaultValue = "5")Integer size,
                                                              @RequestParam(value = "sortBy", required = false) String sortBy,
                                                              @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
                                                              @RequestParam(value = "key", required = false) String key){

        PageResult<Brand> result = this.brandservice.queryBrandByPageAndSort(page,size,sortBy,desc,key);
        if(result == null && result.getItems().size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<PageResult<Brand>> deleteBrandById(@RequestParam(value = "id")Long id){
        int num = this.brandservice.deleteBrandById(id);
        if(num<0){
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}