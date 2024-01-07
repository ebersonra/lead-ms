package br.com.leads.ms.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
public class Address extends EntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ADDRESS_ID")
    private UUID uniqueId;

    @Column(name = "ADDRESS_STREET")
    private String street;

    @Column(name = "ADDRESS_CITY")
    private String city;

    @Column(name = "ADDRESS_STATE")
    private String state;

    @Column(name = "ADDRESS_ZIP_CODE")
    private String zipCode;

    @Column(name = "ADDRESS_NUMBER")
    private Long number;

    @Column(name = "ADDRESS_COMPLEMENT")
    private String complement;

    @Column(name = "ADDRESS_DISTRICT")
    private String district;

    // N Addresses has 1 Lead
    @ManyToOne
    @JoinColumn(name = "LEAD_ID")
    private Lead lead;

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Address address = (Address) obj;
        return (getUniqueId() == address.getUniqueId()) && (Objects.equals(uniqueId, address.uniqueId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId(), uniqueId);
    }
}
