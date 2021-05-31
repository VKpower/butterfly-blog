package me.vkpower.butterflyblog.admin.controller;


import me.vkpower.butterflyblog.admin.entity.BlogEntity;
import me.vkpower.butterflyblog.admin.results.R;
import me.vkpower.butterflyblog.admin.service.BlogService;
import me.vkpower.butterflyblog.admin.service.TagService;
import me.vkpower.butterflyblog.admin.service.TypeService;
import me.vkpower.butterflyblog.admin.util.ReactiveRequestContextHolder;
import me.vkpower.butterflyblog.admin.vo.BlogInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Xiayuancheng
 * @since 2021-05-28
 */
@RestController
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;


    /**
     * 查询所有博客
     *
     * @return 博客集合
     */

    @GetMapping("/blogs")
    public R viewBlogs() {
         ReactiveRequestContextHolder.getRequest().map(request -> request.getURI().toString())
         .subscribe(System.out::println);
        List<BlogEntity> blogs = blogService.selectAll();
        return R.ok().data("data", blogs);
    }

    /**
     * 更具id查询单个blog
     *
     * @param id 博客id
     * @return 博客
     */
    @GetMapping("/blog/{id}")
    public R viewBlog(@PathVariable("id") String id) {
        BlogEntity blog = blogService.selectOneById(id);
        return R.ok().data("data", blog);
    }

    /**
     * 保存博客
     * @param blogInfoVo 博客信息
     * @return
     */
    @PostMapping("/blog")
    public R saveBlog(@RequestBody BlogInfoVo blogInfoVo){
        boolean flag =  blogService.saveBlog(blogInfoVo);
        if(!flag){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 根据id 删除blog
     * @param id
     * @return
     */

    @DeleteMapping("/blog/{id}")
    public R deleteBlogs(@PathVariable("id")String id){
       boolean flag =  blogService.deleteBlodById(id);
       if(!flag){
           return R.error();
       }
       return R.ok();
     //  return flag?R.ok():R.error();
    }
}
