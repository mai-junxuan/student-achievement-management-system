package edu.zhku.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author MJX
 */
@TableName(value ="account")
@Data
@ApiModel("登录信息")
@AllArgsConstructor
public class Account {

    @TableId
    @ApiModelProperty("工号")
    private Long id;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("角色")
    private Integer role;

}
