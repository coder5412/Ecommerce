package com.example.Ecommerce.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductInCartDto {
    private int productId;
    private int userId;

}
