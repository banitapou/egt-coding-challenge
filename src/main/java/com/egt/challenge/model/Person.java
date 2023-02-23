package com.egt.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address mainAddress;
    private Set<Address> additionalAddresses;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Address getMainAddress() {
		return mainAddress;
	}
	public void setMainAddress(Address mainAddress) {
		this.mainAddress = mainAddress;
	}
	public Set<Address> getAdditionalAddresses() {
		return additionalAddresses;
	}
	public void setAdditionalAddresses(Set<Address> additionalAddresses) {
		this.additionalAddresses = additionalAddresses;
	}
}
