package com.nt.entity.promotions;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="Offer_Info")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Offer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer offerId;
    @Column(length = 30)
    @NonNull
    private String offerName;
    @Column(length = 30)
    @NonNull
    private String offerCode;
    @NonNull
    private LocalDate validUpto;
}
