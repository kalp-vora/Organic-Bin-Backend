package com.organicbin.model;

public record LoginResponse(Long userId, String email, String role, String token) {
}
