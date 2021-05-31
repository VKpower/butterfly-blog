package me.vkpower.butterflyblog.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
@TableName("t_blog")
@ApiModel(value="BlogEntity对象", description="")
public class BlogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Boolean appreciation;

    private Boolean commentabled;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published;

    private Boolean recommend;

    private Boolean shareStatement;

    private String title;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;


}
