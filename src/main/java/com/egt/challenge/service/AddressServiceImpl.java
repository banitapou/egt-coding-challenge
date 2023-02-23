package com.egt.challenge.service;

import com.egt.challenge.repo.AddressRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.egt.challenge.model.Address;
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @NonNull
    private final AddressRepository addressRepository;
    
    public AddressServiceImpl(AddressRepository repo) {
    	this.addressRepository = repo;
    }
    
    public List<Address> all() {
    	return addressRepository.findAll();
    }
    
    public Optional<Address> find(long id) {
    	return addressRepository.findById(id);
    }
    
    public Address addAddress(Address address) {
    	return addressRepository.save(address);
    }
    
    public Address updateAddress(Address address, long id) {
    	 return addressRepository.findById(id)
    		.map(ad -> {
    			ad.setPerson(address.getPerson());
    			ad.setStreet1(address.getStreet1());
    			ad.setStreet2(address.getStreet2());
    			ad.setCity(address.getCity());
    			ad.setState(address.getState());
    			return ad;
    		}).orElseGet(() -> {
    			return addressRepository.save(address);
    		});
    }
    
    public void deleteAddress(Address address) {
    	addressRepository.delete(address);
    }
    // TODO create methods to create, read, update, and delete Persons as outlined in the README
}
