package com.nt.offers.repository;

import com.nt.entity.promotions.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfferRepo extends JpaRepository<Offer,Integer> {
}
