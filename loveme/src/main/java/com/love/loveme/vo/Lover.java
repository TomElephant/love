package com.love.loveme.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zlx
 * @ClassName Lover.java
 * @Description TODO
 * @createTime 2021年11月05日 16:46:00
 */
@Data
public class Lover implements Serializable {
    private String name;
    private String attribute;
}
