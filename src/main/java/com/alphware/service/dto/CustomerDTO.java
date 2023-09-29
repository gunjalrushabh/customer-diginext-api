package com.alphware.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.alphware.domain.Customer} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CustomerDTO implements Serializable {

    private String customerId;

    private String accountNumber;

    private String phoneNumber;

    private String fullName;

    private String email;

    private String aadharNumber;

    private String pancardNumber;

    private String birthdate;

    private Integer age;

    private String gender;

    private String maritalStatus;

    private String residentialStatus;

    private String form60;

    private String formSixtyAckgeNo;

    private String category;

    private String nominee;

    private String verify;

    private String fax;

    private String mob1;

    private String mob2;

    private String telephone;

    private String ckyc;

    private String refckyc;

    private String gstn;

    private LocalDate createdAt;

    private LocalDate modifiedAt;

    private Boolean enable;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPancardNumber() {
        return pancardNumber;
    }

    public void setPancardNumber(String pancardNumber) {
        this.pancardNumber = pancardNumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getForm60() {
        return form60;
    }

    public void setForm60(String form60) {
        this.form60 = form60;
    }

    public String getFormSixtyAckgeNo() {
        return formSixtyAckgeNo;
    }

    public void setFormSixtyAckgeNo(String formSixtyAckgeNo) {
        this.formSixtyAckgeNo = formSixtyAckgeNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMob1() {
        return mob1;
    }

    public void setMob1(String mob1) {
        this.mob1 = mob1;
    }

    public String getMob2() {
        return mob2;
    }

    public void setMob2(String mob2) {
        this.mob2 = mob2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCkyc() {
        return ckyc;
    }

    public void setCkyc(String ckyc) {
        this.ckyc = ckyc;
    }

    public String getRefckyc() {
        return refckyc;
    }

    public void setRefckyc(String refckyc) {
        this.refckyc = refckyc;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerDTO)) {
            return false;
        }

        CustomerDTO customerDTO = (CustomerDTO) o;
        if (this.customerId == null) {
            return false;
        }
        return Objects.equals(this.customerId, customerDTO.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.customerId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
            "customerId='" + getCustomerId() + "'" +
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
