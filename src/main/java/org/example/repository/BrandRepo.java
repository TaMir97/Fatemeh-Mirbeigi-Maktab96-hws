package org.example.repository;

import org.example.entity.Brand;

public interface BrandRepo {
    int addNewBrand(Brand brand);

    int updateBrand(Brand brand);

    int deleteBrand(Brand brand);

    Brand isExist(String brandName);

    Brand[] loadAllBrands();
    public int recordCounter();
}
