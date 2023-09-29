package com.alphware.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.domain.Persistable;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
@JsonIgnoreProperties(value = { "new" })
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Customer implements Serializable, Persistable<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name = "pancard_number")
    private String pancardNumber;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "residential_status")
    private String residentialStatus;

    @Column(name = "form_60")
    private String form60;

    @Column(name = "form_sixty_ackge_no")
    private String formSixtyAckgeNo;

    @Column(name = "category")
    private String category;

    @Column(name = "nominee")
    private String nominee;

    @Column(name = "verify")
    private String verify;

    @Column(name = "fax")
    private String fax;

    @Column(name = "mob_1")
    private String mob1;

    @Column(name = "mob_2")
    private String mob2;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "ckyc")
    private String ckyc;

    @Column(name = "refckyc")
    private String refckyc;

    @Column(name = "gstn")
    private String gstn;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "modified_at")
    private LocalDate modifiedAt;

    @Column(name = "enable")
    private Boolean enable;

    @Transient
    private boolean isPersisted;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonIgnoreProperties(value = { "customer" }, allowSetters = true)
    private Set<Address> addresses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getCustomerId() {
        return this.customerId;
    }

    public Customer customerId(String customerId) {
        this.setCustomerId(customerId);
        return this;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Customer accountNumber(String accountNumber) {
        this.setAccountNumber(accountNumber);
        return this;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Customer phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Customer fullName(String fullName) {
        this.setFullName(fullName);
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public Customer email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadharNumber() {
        return this.aadharNumber;
    }

    public Customer aadharNumber(String aadharNumber) {
        this.setAadharNumber(aadharNumber);
        return this;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPancardNumber() {
        return this.pancardNumber;
    }

    public Customer pancardNumber(String pancardNumber) {
        this.setPancardNumber(pancardNumber);
        return this;
    }

    public void setPancardNumber(String pancardNumber) {
        this.pancardNumber = pancardNumber;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public Customer birthdate(String birthdate) {
        this.setBirthdate(birthdate);
        return this;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return this.age;
    }

    public Customer age(Integer age) {
        this.setAge(age);
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public Customer gender(String gender) {
        this.setGender(gender);
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public Customer maritalStatus(String maritalStatus) {
        this.setMaritalStatus(maritalStatus);
        return this;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getResidentialStatus() {
        return this.residentialStatus;
    }

    public Customer residentialStatus(String residentialStatus) {
        this.setResidentialStatus(residentialStatus);
        return this;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getForm60() {
        return this.form60;
    }

    public Customer form60(String form60) {
        this.setForm60(form60);
        return this;
    }

    public void setForm60(String form60) {
        this.form60 = form60;
    }

    public String getFormSixtyAckgeNo() {
        return this.formSixtyAckgeNo;
    }

    public Customer formSixtyAckgeNo(String formSixtyAckgeNo) {
        this.setFormSixtyAckgeNo(formSixtyAckgeNo);
        return this;
    }

    public void setFormSixtyAckgeNo(String formSixtyAckgeNo) {
        this.formSixtyAckgeNo = formSixtyAckgeNo;
    }

    public String getCategory() {
        return this.category;
    }

    public Customer category(String category) {
        this.setCategory(category);
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNominee() {
        return this.nominee;
    }

    public Customer nominee(String nominee) {
        this.setNominee(nominee);
        return this;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getVerify() {
        return this.verify;
    }

    public Customer verify(String verify) {
        this.setVerify(verify);
        return this;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getFax() {
        return this.fax;
    }

    public Customer fax(String fax) {
        this.setFax(fax);
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMob1() {
        return this.mob1;
    }

    public Customer mob1(String mob1) {
        this.setMob1(mob1);
        return this;
    }

    public void setMob1(String mob1) {
        this.mob1 = mob1;
    }

    public String getMob2() {
        return this.mob2;
    }

    public Customer mob2(String mob2) {
        this.setMob2(mob2);
        return this;
    }

    public void setMob2(String mob2) {
        this.mob2 = mob2;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Customer telephone(String telephone) {
        this.setTelephone(telephone);
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCkyc() {
        return this.ckyc;
    }

    public Customer ckyc(String ckyc) {
        this.setCkyc(ckyc);
        return this;
    }

    public void setCkyc(String ckyc) {
        this.ckyc = ckyc;
    }

    public String getRefckyc() {
        return this.refckyc;
    }

    public Customer refckyc(String refckyc) {
        this.setRefckyc(refckyc);
        return this;
    }

    public void setRefckyc(String refckyc) {
        this.refckyc = refckyc;
    }

    public String getGstn() {
        return this.gstn;
    }

    public Customer gstn(String gstn) {
        this.setGstn(gstn);
        return this;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public Customer createdAt(LocalDate createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return this.modifiedAt;
    }

    public Customer modifiedAt(LocalDate modifiedAt) {
        this.setModifiedAt(modifiedAt);
        return this;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public Customer enable(Boolean enable) {
        this.setEnable(enable);
        return this;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @PostLoad
    @PostPersist
    public void updateEntityState() {
        this.setIsPersisted();
    }

    @Override
    public String getId() {
        return this.customerId;
    }

    @Transient
    @Override
    public boolean isNew() {
        return !this.isPersisted;
    }

    public Customer setIsPersisted() {
        this.isPersisted = true;
        return this;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setCustomer(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setCustomer(this));
        }
        this.addresses = addresses;
    }

    public Customer addresses(Set<Address> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public Customer addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
        return this;
    }

    public Customer removeAddress(Address address) {
        this.addresses.remove(address);
        address.setCustomer(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return customerId != null && customerId.equals(((Customer) o).customerId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "customerId=" + getCustomerId() +
            ", accountNumber='" + getAccountNumber() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", aadharNumber='" + getAadharNumber() + "'" +
            ", pancardNumber='" + getPancardNumber() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", age=" + getAge() +
            ", gender='" + getGender() + "'" +
            ", maritalStatus='" + getMaritalStatus() + "'" +
            ", residentialStatus='" + getResidentialStatus() + "'" +
            ", form60='" + getForm60() + "'" +
            ", formSixtyAckgeNo='" + getFormSixtyAckgeNo() + "'" +
            ", category='" + getCategory() + "'" +
            ", nominee='" + getNominee() + "'" +
            ", verify='" + getVerify() + "'" +
            ", fax='" + getFax() + "'" +
            ", mob1='" + getMob1() + "'" +
            ", mob2='" + getMob2() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", ckyc='" + getCkyc() + "'" +
            ", refckyc='" + getRefckyc() + "'" +
            ", gstn='" + getGstn() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", modifiedAt='" + getModifiedAt() + "'" +
            ", enable='" + getEnable() + "'" +
            "}";
    }
}
