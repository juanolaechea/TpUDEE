package com.utn.tpFinal.controller;


import com.utn.tpFinal.domain.Address;
import com.utn.tpFinal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/Address")
public class AddressController {


    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public void addAddress(@RequestBody Address newAddress){
        addressService.addAddress(newAddress);
    }
    @GetMapping("/{idAddress}")
    public Address getAddressById(@PathVariable Integer IdAddress){

        return addressService.getAddressById(IdAddress);
    }
    @DeleteMapping("/{idAddress}")
    public void deleteAddressById(@PathVariable Integer IdAddress){
        addressService.deleteAddressById(IdAddress);
    }


}
