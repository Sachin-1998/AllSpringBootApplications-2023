package com.nt.runners;

import com.nt.entity.prod.Product;
import com.nt.entity.promotions.Offer;
import com.nt.offers.repository.IOfferRepo;
import com.nt.product.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MultipleDbsRunner implements CommandLineRunner
{

    @Autowired
    private IProductRepo ProdRepo;

    @Autowired
    private IOfferRepo OfferRepo;

    @Override
    public void run(String... args) throws Exception
    {
        Product p1=new Product("ClothsStorageBox",13000.0,1);
        Product p2=new Product("Cooler",5000.0,1);
        Product p3=new Product("OnePlusMobile",28000.0,1);
        ProdRepo.saveAll(List.of(p1,p2,p3));
        System.out.println("Products saved Successfully");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Offer offer1=new Offer("SummerOffer","B1G1", LocalDate.of(2023,05,27));
        Offer offer2=new Offer("GudiPadwaOffer","B2G1", LocalDate.of(2023,03,31));
        OfferRepo.saveAll(List.of(offer1,offer2));
        System.out.println("Offers saved Successfully");



    }
}
