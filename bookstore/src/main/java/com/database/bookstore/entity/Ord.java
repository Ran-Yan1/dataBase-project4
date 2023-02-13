package com.database.bookstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author RanYan&&ChenPan
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    @TableField("orderTime")
    private LocalDateTime orderTime;

    @TableField("state")
    private Integer state;

    @TableField("uid")
    private Integer uid;

    @TableField("bid")
    private Integer bid;

    @TableField("bnumber")
    private Integer bnumber;

    @TableField("totalPrice")
    private Double totalPrice;


}
