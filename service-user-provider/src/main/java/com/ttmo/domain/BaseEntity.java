package com.ttmo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共实体类
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@Data
public abstract class BaseEntity implements Serializable {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 更新时间
     */
    Date updateTime;

    /**
     * 是否已删除
     */
    @TableField(value = "is_deleted")
    Boolean deleted;

}
