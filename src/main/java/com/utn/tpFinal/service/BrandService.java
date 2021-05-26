package com.utn.tpFinal.service;

import com.utn.tpFinal.domain.Brand;

import com.utn.tpFinal.domain.Model;
import com.utn.tpFinal.domain.PostResponse;
import com.utn.tpFinal.repository.BrandRepository;
import com.utn.tpFinal.utils.EntityURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class BrandService {

    private static final String BRAND_PATH ="Brand";
    private BrandRepository brandRepository;
    private ModelService modelService;

    @Autowired
    public BrandService(BrandRepository brandRepository, ModelService modelService) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
    }

    public PostResponse save(Brand newBrand) {
        Brand b = brandRepository.save(newBrand);
        return PostResponse
                .builder()
                .status(HttpStatus.CREATED)
                .url(EntityURLBuilder.buildURL(BRAND_PATH, b.getBrandId().toString()))
                .build();
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Integer brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteByBrandId(Integer brandId) {
        brandRepository.deleteById(brandId);
    }


    public void addModelInBrand(Integer branId, Integer modelId) {

        Brand brand = getBrandById(branId);
        Model model = modelService.getModelById(modelId);

        brand.getModelList().add(model);
        brandRepository.save(brand);

    }
}
