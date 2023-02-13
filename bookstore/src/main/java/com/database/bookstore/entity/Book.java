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
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @TableField("bname")
    private String bname;

    @TableField("author")
    private String author;

    @TableField("info")
    private String info;

    @TableField("pic")
    private String pic;

    @TableField("price")
    private Double price;

    @TableField("putTime")
    private LocalDateTime putTime;

    @TableField("number")
    private Integer number;

    @TableField("sales")
    private Integer sales;

    @TableField("ISBN")
    private Integer isbn;


}
