package com.example.BurgersApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BurgersResponse(
        List<Receta> recetas
) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Image(
        String sm,
        String lg
) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Ingredient(
        int id,
        String name,
        String img
) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Receta(
        int id,
        String name,
        List<Image> images,
        String desc,
        List<Ingredient> ingredients,
        double price,
        boolean veg
) {}
