package com.project.shopapp.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DTOcategory {
    @NotEmpty(message = "Category not empty")
    private String name;
}
