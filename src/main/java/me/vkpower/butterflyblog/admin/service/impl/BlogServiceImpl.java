package me.vkpower.butterflyblog.admin.service.impl;

import com.baomidou.mybatisplus.extension.api.Assert;
import me.vkpower.butterflyblog.admin.dto.BlogDto;
import me.vkpower.butterflyblog.admin.entity.BlogEntity;
import me.vkpower.butterflyblog.admin.mapper.BlogMapper;
import me.vkpower.butterflyblog.admin.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.vkpower.butterflyblog.admin.vo.BlogInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiayuancheng
 * @since 2021-05-28
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogEntity> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 查询所有博客
     * @return
     */
    @Override
    public List<BlogEntity> selectAll() {
        List<BlogEntity> blogEntities = blogMapper.selectList(null);
        return blogEntities;
    }

    /**
     * 根据ID查询blog
     * @param id
     * @return
     */
    @Override
    public BlogEntity selectOneById(String id) {
        BlogEntity blogEntity = blogMapper.selectById(id);
        return blogEntity;
    }

    /**
     * 保存博客
     * @param blogInfoVo 博客信息
     * @return
     */
    @Override
    public boolean saveBlog(BlogInfoVo blogInfoVo) {
        BlogDto blogDto = new BlogDto();
        BlogEntity blogEntity = new BlogEntity();
        BeanUtils.copyProperties(blogInfoVo,blogDto);
        blogDto.setViews(0);
        BeanUtils.copyProperties(blogDto,blogEntity);
        int count = blogMapper.insert(blogEntity);
        if(count>0){
            //todo 其他业务
            return true;
        }
        return false;
    }

    /**
     * 更具blog ID 删除blog
     * @param id
     * @return
     */
    @Override
    public boolean deleteBlodById(String id) {
        int count = blogMapper.deleteById(id);
        if(count>0){
            //todo 其他业务
            return true;
        }
        return false;
    }
}
