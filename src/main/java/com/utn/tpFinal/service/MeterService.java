package com.utn.tpFinal.service;

import com.utn.tpFinal.domain.Meter;
import com.utn.tpFinal.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class MeterService {

    private MeterRepository meterRepository;

    @Autowired
    public MeterService(MeterRepository meterRepository) {
        this.meterRepository = meterRepository;
    }

    public void addMeter(Meter newMeter) {
        meterRepository.save(newMeter);
    }

    public Meter getMeterBySerialNumber(Integer serialNumber) {
        return meterRepository.findById(serialNumber)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteBySerialNumber(Integer serialNumber) {
        meterRepository.deleteById(serialNumber);
    }
}
