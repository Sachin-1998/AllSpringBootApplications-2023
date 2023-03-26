package com.nt.entity.prod;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="JPA_Product")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Product
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer prodId;
   @Column(length = 30)
   @NonNull
   private String prodName;
   @NonNull
   private Double prodPrice;
   @NonNull
   private Integer prodQuantity;
}
