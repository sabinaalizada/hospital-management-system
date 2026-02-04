package com.ecommerce.hospitalmanagementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "PublicId", columnNames = {"public_Id"}),
        @UniqueConstraint(name = "DoctorPhone", columnNames = {"phone"}),
        @UniqueConstraint(name = "DoctorLicenseNumber", columnNames = {"license_Number"})
})
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private UUID publicId;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String phone;

    @Column(length = 50)
    private String specialization;

    @Column(nullable = false, length = 9)
    private String licenseNumber;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private List<Patient> patients;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (publicId == null) {
            publicId = UUID.randomUUID();
        }
    }
}
