package br.com.valeimoveisadm.vibrealestate.application.core.domain;

import br.com.valeimoveisadm.vibrealestate.application.core.enums.BusinessType;
import br.com.valeimoveisadm.vibrealestate.application.core.enums.RealEstateCategory;
import br.com.valeimoveisadm.vibrealestate.application.core.enums.RealEstateType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RealEstate {

    private Long id;
    private Owner owner;
    private Address address;
    private String description;
    private BigDecimal value;
    private BusinessType businessType;
    private RealEstateCategory realEstateCategory;
    private RealEstateType realEstateType;
    private Integer dormitoryQuantity;
    private Integer bathroomsQuantity;
    private Integer garageQuantity;
    private List<Complements> complementsList = new ArrayList<>();

    public RealEstate(Long id, Owner owner, Address address, String description, BigDecimal value, BusinessType businessType, RealEstateCategory realEstateCategory, RealEstateType realEstateType, Integer dormitoryQuantity, Integer bathroomsQuantity, Integer garageQuantity, List<Complements> complementsList) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.description = description;
        this.value = value;
        this.businessType = businessType;
        this.realEstateCategory = realEstateCategory;
        this.realEstateType = realEstateType;
        this.dormitoryQuantity = dormitoryQuantity;
        this.bathroomsQuantity = bathroomsQuantity;
        this.garageQuantity = garageQuantity;
        this.complementsList = complementsList;
    }

    public RealEstate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public RealEstateCategory getRealEstateCategory() {
        return realEstateCategory;
    }

    public void setRealEstateCategory(RealEstateCategory realEstateCategory) {
        this.realEstateCategory = realEstateCategory;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public Integer getDormitoryQuantity() {
        return dormitoryQuantity;
    }

    public void setDormitoryQuantity(Integer dormitoryQuantity) {
        this.dormitoryQuantity = dormitoryQuantity;
    }

    public Integer getBathroomsQuantity() {
        return bathroomsQuantity;
    }

    public void setBathroomsQuantity(Integer bathroomsQuantity) {
        this.bathroomsQuantity = bathroomsQuantity;
    }

    public Integer getGarageQuantity() {
        return garageQuantity;
    }

    public void setGarageQuantity(Integer garageQuantity) {
        this.garageQuantity = garageQuantity;
    }

    public List<Complements> getComplementsList() {
        return complementsList;
    }

    public void addNewComplement(Complements complement){
        this.complementsList.add(complement);
    }

    public void removeComplement(Complements complements){
        this.complementsList.remove(complements);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof RealEstate that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
