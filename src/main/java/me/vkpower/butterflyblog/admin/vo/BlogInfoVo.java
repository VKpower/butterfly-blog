package me.vkpower.butterflyblog.admin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="BlogInfoVo对象", description="保存博客所需要的信息")
public class BlogInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "博客是否可以打赏")
    private Boolean appreciation;
    @ApiModelProperty(value = "是否可以评论")
    private Boolean commentabled;
    @ApiModelProperty(value = "博客内容")
    private String content;
    @ApiModelProperty(value = "对内容简短的描述")
    private String description;
    @ApiModelProperty(value = "博客首页的图片")
    private String firstPicture;
    @ApiModelProperty(value = "博客所属的标签")
    private String flag;
    @ApiModelProperty(value = "博客是否发布")
    private Boolean published;
    @ApiModelProperty(value = "是否在首页推荐此篇博客")
    private Boolean recommend;
    @ApiModelProperty(value = "转载形式")
    private Boolean shareStatement;
    @ApiModelProperty(value = "博客标题")
    private String title;
    @ApiModelProperty(value = "博客所属分类类型")
    private Long typeId;
    @ApiModelProperty(value = "博客作者")
    private Long userId;
}
