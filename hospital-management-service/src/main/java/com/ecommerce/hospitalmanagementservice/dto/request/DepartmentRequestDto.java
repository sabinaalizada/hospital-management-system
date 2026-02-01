package com.ecommerce.hospitalmanagementservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDto {

    @NotBlank(message = "Name can not be null")
    @Size(max = 100, message = "Name's length must be at least 100")
    private String name;

    @Size(max = 200, message = "Description's length must be at least 100")
    private String description;
}
