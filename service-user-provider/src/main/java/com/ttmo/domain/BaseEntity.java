package com.ttmo.domain;

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
    Boolean deleted;

}
