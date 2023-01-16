package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "firstName cannot be empty.")
    @Pattern(regexp = "[A-Za-z-]*", message = "firstName cannot contains illegal characters.")
    private String firstName;
    @NotBlank(message = "lastName cannot be empty.")
    @Pattern(regexp = "[A-Za-z-]*", message = "lastName cannot contains illegal characters.")
    private String lastName;
    @NotBlank(message = "phoneNumber cannot be empty.")
    @Pattern(regexp = "[0-9\\-+]*", message = "phoneNumber cannot contains illegal characters.")
    private String phoneNumber;
    @NotBlank(message = "address cannot be empty.")
    @Pattern(regexp = "[\\w -\\-/,]*", message = "address cannot contains illegal characters.")
    private String address;
    @NotBlank(message = "cubicleNo cannot be blank.")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",message = "cubicleNo cannot contains illegal characters.")
    private String cubicleNo;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String address, String phoneNumber, String cubicleNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cubicleNo = cubicleNo;
    }
}
