package com.ecommerce.hospitalmanagementservice.dto.request.department;

import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateDto {

    @Size(max = 100, message = "Name's length must be at least 100")
    private String name;

    @Size(max = 200, message = "Description's length must be at least 100")
    @OnlyLetters(allowSpace = true)
    private String description;
}
