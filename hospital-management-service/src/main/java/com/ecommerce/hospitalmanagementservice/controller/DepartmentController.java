package com.ecommerce.hospitalmanagementservice.controller;

import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @Valid @RequestBody DepartmentUpdateDto departmentUpdateDto,
            @PathVariable Long id) {
        DepartmentResponseDto departmentResponseDto = departmentService
                .updateDepartment(departmentUpdateDto, id);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        String str = departmentService.deleteDepartment(id);
        return new ResponseEntity<>(str, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {
        List<DepartmentResponseDto> departmentResponseDtos = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentResponseDtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DepartmentResponseDto> getDepartmentByName(@RequestParam String name) {
        DepartmentResponseDto departmentResponseDto = departmentService.getDepartmentByName(name);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.OK);
    }

}
