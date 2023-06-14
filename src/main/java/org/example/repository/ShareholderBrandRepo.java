package org.example.repository;

import org.example.entity.ShareholderBrand;

public interface ShareholderBrandRepo {
    ShareholderBrand[] loadByShareholder(String shareholderName);
    ShareholderBrand[] loadByBrand(String brandName);
    ShareholderBrand[] loadAll();



}
