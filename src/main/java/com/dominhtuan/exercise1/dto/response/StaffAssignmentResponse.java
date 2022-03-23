package com.dominhtuan.exercise1.dto.response;

import com.dominhtuan.exercise1.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffAssignmentResponse extends BaseDTO {
    private String fullName;
    private String checked = "";

    public StaffAssignmentResponse(Long id, String fullName, String checked) {
        super(id);
        this.fullName = fullName;
        this.checked = checked;
    }
}
