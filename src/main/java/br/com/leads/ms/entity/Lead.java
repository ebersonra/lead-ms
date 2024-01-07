package br.com.leads.ms.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "LEAD")
public class Lead extends EntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, name = "LEAD_ID")
    private UUID uniqueId;

    @Column(nullable = false, name = "LEAD_PHONE", unique = true)
    private String phone;

    @Column(name = "LEAD_EMAIL")
    private String email;

    @Column(name = "LEAD_FIRSTNAME")
    private String firstname;

    @Column(name = "LEAD_LASTNAME")
    private String lastname;

    // 1 Lead has many Addresses
    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Lead() {
    }

    public Lead(UUID uniqueId, String phone, String email, String firstname, String lastname) {
        this.uniqueId = uniqueId;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.lastname = lastname;
    }

    public Lead(String phone, String email, String firstname, String lastname) {
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.lastname = lastname;
    }

    // getters and setters

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Lead lead = (Lead) obj;
        return (getUniqueId() == lead.getUniqueId()) && (Objects.equals(uniqueId, lead.uniqueId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId(), uniqueId);
    }
}
