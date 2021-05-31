package me.vkpower.butterflyblog.admin.service;

import me.vkpower.butterflyblog.admin.entity.BlogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import me.vkpower.butterflyblog.admin.vo.BlogInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xiayuancheng
 * @since 2021-05-28
 */
public interface BlogService extends IService<BlogEntity> {

    List<BlogEntity> selectAll();

    /**
     * 根据id查询blog
     * @param id
     * @return
     */
    BlogEntity selectOneById(String id);

    /**
     * 保存博客
     * @param blogInfoVo 博客信息
     * @return
     */
    boolean saveBlog(BlogInfoVo blogInfoVo);

    /**
     * 根据blog ID 删除blog
     * @param id
     * @return
     */
    boolean deleteBlodById(String id);
}
