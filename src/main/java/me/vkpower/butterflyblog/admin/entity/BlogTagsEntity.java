package me.vkpower.butterflyblog.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiayuancheng
 * @since 2021-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog_tags")
@ApiModel(value="BlogTagsEntity对象", description="")
public class BlogTagsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long blogsId;

    private Long tagsId;


}
