package com.utn.tpFinal.controller;

import com.utn.tpFinal.domain.Meter;
import com.utn.tpFinal.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/Meter")
public class MeterController {

    private MeterService meterService;

    @Autowired
    public MeterController(MeterService meterService) {
        this.meterService = meterService;
    }

    @PostMapping
    public void addMeter(@RequestBody Meter newMeter){
        meterService.addMeter(newMeter);
    }

    @GetMapping("/{serialNumber}")
    public Meter getMeterBySerialNumber(@PathVariable Integer serialNumber){

        return meterService.getMeterBySerialNumber(serialNumber);
    }
    @DeleteMapping("/{serialNumber}")
    public void deleteBySerialNumber(@PathVariable Integer serialNumber){

        meterService.deleteBySerialNumber(serialNumber);
    }
}
