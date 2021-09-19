package com.finalwork.common.bussiness.entity.user;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    private String photo;

    private String mobile;

    private String remark;
}
