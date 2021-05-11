package com.utn.tpFinal.service;

import com.utn.tpFinal.domain.Tariff;
import com.utn.tpFinal.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class TariffService {

    private TariffRepository tariffRepository;

    @Autowired
    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public void addTariff(Tariff newTariff) {
        tariffRepository.save(newTariff);
    }

    public Tariff getTariffById(Integer idTariff) {
        return tariffRepository.findById(idTariff)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteAddressById(Integer idTariff) {

        tariffRepository.deleteById(idTariff);
    }
}
