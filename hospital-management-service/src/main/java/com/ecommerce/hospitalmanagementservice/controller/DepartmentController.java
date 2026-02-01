package com.ecommerce.hospitalmanagementservice.controller;

import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentRequestDto;
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

    @PutMapping
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @Valid @RequestBody DepartmentRequestDto departmentRequestDto,
            @RequestParam Long id) {
        DepartmentResponseDto departmentResponseDto = departmentService
                .updateDepartment(departmentRequestDto, id);
        return new ResponseEntity<>(departmentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteDepartment(@RequestParam Long id) {
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
