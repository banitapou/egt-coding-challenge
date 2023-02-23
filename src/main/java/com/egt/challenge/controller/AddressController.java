package com.egt.challenge.controller;

import com.egt.challenge.service.AddressService;
import com.egt.challenge.service.AddressServiceImpl;
import com.egt.challenge.service.PersonService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egt.challenge.repo.AddressRepository;
@RestController
@RequestMapping(AddressController.BASE_URL)
@RequiredArgsConstructor
public class AddressController {
    public static final String BASE_URL = "/api/addresses";

    @NonNull
    private final AddressService addressService;
    @NonNull
    private final PersonService personService;
    
    AddressController(AddressRepository addressRepo){
    	this.addressService = new AddressServiceImpl(addressRepo);
		this.personService = null;
    }
    // TODO create the appropriate end points as outlined in the README
}
