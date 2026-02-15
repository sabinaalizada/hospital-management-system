package com.ecommerce.hospitalmanagementservice.controller;

import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> createDepartment(
            @Valid @RequestBody DepartmentRequestDto departmentRequestDto) {
        DepartmentResponseDto departmentResponseDto = departmentService
                .addDepartment(departmentRequestDto);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{publicId}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @Valid @RequestBody DepartmentUpdateDto departmentUpdateDto,
            @PathVariable UUID publicId) {
        DepartmentResponseDto departmentResponseDto = departmentService
                .updateDepartment(departmentUpdateDto, publicId);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/delete/{publicId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID publicId) {
        departmentService.deleteDepartment(publicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {
        List<DepartmentResponseDto> departmentResponseDtos = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DepartmentResponseDto> getDepartmentByName(@PathVariable String name) {
        DepartmentResponseDto departmentResponseDto = departmentService.getDepartmentByName(name);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

}
