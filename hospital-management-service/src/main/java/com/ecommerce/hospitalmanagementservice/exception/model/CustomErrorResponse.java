package com.ecommerce.hospitalmanagementservice.exception.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponse {
    private String type;
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
}
