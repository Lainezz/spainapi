package com.es.spainapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ProvinciaDTO {

    @NotBlank(message = "El código de provincia es obligatorio")
    @Size(min = 2, max = 3, message = "La provincia debe tener entre 2 y 3 caracteres")
    @Pattern(regexp = "^[0-9]{2,3}$", message = "El código debe ser numérico")
    private String cprov;

    @NotBlank(message = "El nombre de provincia es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nprov;
}
