package com.ecommerce.hospitalmanagementservice.dto.request;

import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
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

    @NotBlank(message = "Name can not be null or empty")
    @Size(min = 3, max = 100, message = "Name's length must be at least 100")
    @OnlyLetters(allowSpace = true)
    private String name;

    @NotBlank(message = "Description can not be null or empty")
    @Size(max = 200, message = "Description's length must be at least 100")
    @OnlyLetters(allowSpace = true)
    private String description;
}
