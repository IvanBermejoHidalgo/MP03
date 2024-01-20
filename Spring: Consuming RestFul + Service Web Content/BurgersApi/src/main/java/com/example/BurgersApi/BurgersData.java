package com.example.BurgersApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BurgersData(
        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("images") List<Image> images,
        @JsonProperty("desc") String desc,
        @JsonProperty("ingredients") List<Ingredient> ingredients,
        @JsonProperty("price") double price,
        @JsonProperty("veg") boolean veg
) {}
