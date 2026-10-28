package org.example.session07.models.dto.req;

import jakarta.validation.constraints.*;

// Đối tượng Imutable - đối tượng bất biết
public record PersonReq(
        @NotBlank(message = "Tên người dùng không được để trống")
        String fullName,

        @NotNull(message = "Tuổi không được để trống")
        @Positive(message = "Tuổi không được âm")
        Integer age,
//        @Email(message = "Email không đúng định dạng")

        @NotBlank(message = "Email không được để trống")
        @Pattern(
                regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message = "Email không đúng định dạng")
        String email
) {
}
