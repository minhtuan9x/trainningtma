package com.dominhtuan.exercise1.dto.response;

import com.dominhtuan.exercise1.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse extends BaseDTO {
    private String code;
    private String name;
    private String checked = "";
}
