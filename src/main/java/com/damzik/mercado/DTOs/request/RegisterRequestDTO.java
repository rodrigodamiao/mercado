package com.damzik.mercado.DTOs.request;

import com.damzik.mercado.enums.Cargo;

public record RegisterRequestDTO(String email, String password, Cargo cargo) {
}
