package com.alphware.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.alphware.IntegrationTest;
import com.alphware.domain.Customer;
import com.alphware.repository.CustomerRepository;
import com.alphware.service.dto.CustomerDTO;
import com.alphware.service.mapper.CustomerMapper;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link CustomerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CustomerResourceIT {

    private static final String DEFAULT_ACCOUNT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_AADHAR_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_AADHAR_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PANCARD_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PANCARD_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTHDATE = "AAAAAAAAAA";
    private static final String UPDATED_BIRTHDATE = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGE = 1;
    private static final Integer UPDATED_AGE = 2;

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_MARITAL_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_MARITAL_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_RESIDENTIAL_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RESIDENTIAL_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_FORM_60 = "AAAAAAAAAA";
    private static final String UPDATED_FORM_60 = "BBBBBBBBBB";

    private static final String DEFAULT_FORM_SIXTY_ACKGE_NO = "AAAAAAAAAA";
    private static final String UPDATED_FORM_SIXTY_ACKGE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE = "BBBBBBBBBB";

    private static final String DEFAULT_VERIFY = "AAAAAAAAAA";
    private static final String UPDATED_VERIFY = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_MOB_1 = "AAAAAAAAAA";
    private static final String UPDATED_MOB_1 = "BBBBBBBBBB";

    private static final String DEFAULT_MOB_2 = "AAAAAAAAAA";
    private static final String UPDATED_MOB_2 = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_CKYC = "AAAAAAAAAA";
    private static final String UPDATED_CKYC = "BBBBBBBBBB";

    private static final String DEFAULT_REFCKYC = "AAAAAAAAAA";
    private static final String UPDATED_REFCKYC = "BBBBBBBBBB";

    private static final String DEFAULT_GSTN = "AAAAAAAAAA";
    private static final String UPDATED_GSTN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATED_AT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATED_AT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_MODIFIED_AT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_MODIFIED_AT = LocalDate.now(ZoneId.systemDefault());

    private static final Boolean DEFAULT_ENABLE = false;
    private static final Boolean UPDATED_ENABLE = true;

    private static final String ENTITY_API_URL = "/api/customers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{customerId}";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private Customer customer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createEntity(EntityManager em) {
        Customer customer = new Customer()
            .accountNumber(DEFAULT_ACCOUNT_NUMBER)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .fullName(DEFAULT_FULL_NAME)
            .email(DEFAULT_EMAIL)
            .aadharNumber(DEFAULT_AADHAR_NUMBER)
            .pancardNumber(DEFAULT_PANCARD_NUMBER)
            .birthdate(DEFAULT_BIRTHDATE)
            .age(DEFAULT_AGE)
            .gender(DEFAULT_GENDER)
            .maritalStatus(DEFAULT_MARITAL_STATUS)
            .residentialStatus(DEFAULT_RESIDENTIAL_STATUS)
            .form60(DEFAULT_FORM_60)
            .formSixtyAckgeNo(DEFAULT_FORM_SIXTY_ACKGE_NO)
            .category(DEFAULT_CATEGORY)
            .nominee(DEFAULT_NOMINEE)
            .verify(DEFAULT_VERIFY)
            .fax(DEFAULT_FAX)
            .mob1(DEFAULT_MOB_1)
            .mob2(DEFAULT_MOB_2)
            .telephone(DEFAULT_TELEPHONE)
            .ckyc(DEFAULT_CKYC)
            .refckyc(DEFAULT_REFCKYC)
            .gstn(DEFAULT_GSTN)
            .createdAt(DEFAULT_CREATED_AT)
            .modifiedAt(DEFAULT_MODIFIED_AT)
            .enable(DEFAULT_ENABLE);
        return customer;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createUpdatedEntity(EntityManager em) {
        Customer customer = new Customer()
            .accountNumber(UPDATED_ACCOUNT_NUMBER)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .fullName(UPDATED_FULL_NAME)
            .email(UPDATED_EMAIL)
            .aadharNumber(UPDATED_AADHAR_NUMBER)
            .pancardNumber(UPDATED_PANCARD_NUMBER)
            .birthdate(UPDATED_BIRTHDATE)
            .age(UPDATED_AGE)
            .gender(UPDATED_GENDER)
            .maritalStatus(UPDATED_MARITAL_STATUS)
            .residentialStatus(UPDATED_RESIDENTIAL_STATUS)
            .form60(UPDATED_FORM_60)
            .formSixtyAckgeNo(UPDATED_FORM_SIXTY_ACKGE_NO)
            .category(UPDATED_CATEGORY)
            .nominee(UPDATED_NOMINEE)
            .verify(UPDATED_VERIFY)
            .fax(UPDATED_FAX)
            .mob1(UPDATED_MOB_1)
            .mob2(UPDATED_MOB_2)
            .telephone(UPDATED_TELEPHONE)
            .ckyc(UPDATED_CKYC)
            .refckyc(UPDATED_REFCKYC)
            .gstn(UPDATED_GSTN)
            .createdAt(UPDATED_CREATED_AT)
            .modifiedAt(UPDATED_MODIFIED_AT)
            .enable(UPDATED_ENABLE);
        return customer;
    }

    @BeforeEach
    public void initTest() {
        customer = createEntity(em);
    }

    @Test
    @Transactional
    void createCustomer() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();
        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);
        restCustomerMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isCreated());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate + 1);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getAccountNumber()).isEqualTo(DEFAULT_ACCOUNT_NUMBER);
        assertThat(testCustomer.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testCustomer.getFullName()).isEqualTo(DEFAULT_FULL_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCustomer.getAadharNumber()).isEqualTo(DEFAULT_AADHAR_NUMBER);
        assertThat(testCustomer.getPancardNumber()).isEqualTo(DEFAULT_PANCARD_NUMBER);
        assertThat(testCustomer.getBirthdate()).isEqualTo(DEFAULT_BIRTHDATE);
        assertThat(testCustomer.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testCustomer.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testCustomer.getMaritalStatus()).isEqualTo(DEFAULT_MARITAL_STATUS);
        assertThat(testCustomer.getResidentialStatus()).isEqualTo(DEFAULT_RESIDENTIAL_STATUS);
        assertThat(testCustomer.getForm60()).isEqualTo(DEFAULT_FORM_60);
        assertThat(testCustomer.getFormSixtyAckgeNo()).isEqualTo(DEFAULT_FORM_SIXTY_ACKGE_NO);
        assertThat(testCustomer.getCategory()).isEqualTo(DEFAULT_CATEGORY);
        assertThat(testCustomer.getNominee()).isEqualTo(DEFAULT_NOMINEE);
        assertThat(testCustomer.getVerify()).isEqualTo(DEFAULT_VERIFY);
        assertThat(testCustomer.getFax()).isEqualTo(DEFAULT_FAX);
        assertThat(testCustomer.getMob1()).isEqualTo(DEFAULT_MOB_1);
        assertThat(testCustomer.getMob2()).isEqualTo(DEFAULT_MOB_2);
        assertThat(testCustomer.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testCustomer.getCkyc()).isEqualTo(DEFAULT_CKYC);
        assertThat(testCustomer.getRefckyc()).isEqualTo(DEFAULT_REFCKYC);
        assertThat(testCustomer.getGstn()).isEqualTo(DEFAULT_GSTN);
        assertThat(testCustomer.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testCustomer.getModifiedAt()).isEqualTo(DEFAULT_MODIFIED_AT);
        assertThat(testCustomer.getEnable()).isEqualTo(DEFAULT_ENABLE);
    }

    @Test
    @Transactional
    void createCustomerWithExistingId() throws Exception {
        // Create the Customer with an existing ID
        customer.setCustomerId("existing_id");
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        int databaseSizeBeforeCreate = customerRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCustomerMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCustomers() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        // Get all the customerList
        restCustomerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=customerId,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(customer.getCustomerId())))
            .andExpect(jsonPath("$.[*].accountNumber").value(hasItem(DEFAULT_ACCOUNT_NUMBER)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].fullName").value(hasItem(DEFAULT_FULL_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].aadharNumber").value(hasItem(DEFAULT_AADHAR_NUMBER)))
            .andExpect(jsonPath("$.[*].pancardNumber").value(hasItem(DEFAULT_PANCARD_NUMBER)))
            .andExpect(jsonPath("$.[*].birthdate").value(hasItem(DEFAULT_BIRTHDATE)))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].maritalStatus").value(hasItem(DEFAULT_MARITAL_STATUS)))
            .andExpect(jsonPath("$.[*].residentialStatus").value(hasItem(DEFAULT_RESIDENTIAL_STATUS)))
            .andExpect(jsonPath("$.[*].form60").value(hasItem(DEFAULT_FORM_60)))
            .andExpect(jsonPath("$.[*].formSixtyAckgeNo").value(hasItem(DEFAULT_FORM_SIXTY_ACKGE_NO)))
            .andExpect(jsonPath("$.[*].category").value(hasItem(DEFAULT_CATEGORY)))
            .andExpect(jsonPath("$.[*].nominee").value(hasItem(DEFAULT_NOMINEE)))
            .andExpect(jsonPath("$.[*].verify").value(hasItem(DEFAULT_VERIFY)))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX)))
            .andExpect(jsonPath("$.[*].mob1").value(hasItem(DEFAULT_MOB_1)))
            .andExpect(jsonPath("$.[*].mob2").value(hasItem(DEFAULT_MOB_2)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].ckyc").value(hasItem(DEFAULT_CKYC)))
            .andExpect(jsonPath("$.[*].refckyc").value(hasItem(DEFAULT_REFCKYC)))
            .andExpect(jsonPath("$.[*].gstn").value(hasItem(DEFAULT_GSTN)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].modifiedAt").value(hasItem(DEFAULT_MODIFIED_AT.toString())))
            .andExpect(jsonPath("$.[*].enable").value(hasItem(DEFAULT_ENABLE.booleanValue())));
    }

    @Test
    @Transactional
    void getCustomer() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        // Get the customer
        restCustomerMockMvc
            .perform(get(ENTITY_API_URL_ID, customer.getCustomerId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.customerId").value(customer.getCustomerId()))
            .andExpect(jsonPath("$.accountNumber").value(DEFAULT_ACCOUNT_NUMBER))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.fullName").value(DEFAULT_FULL_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.aadharNumber").value(DEFAULT_AADHAR_NUMBER))
            .andExpect(jsonPath("$.pancardNumber").value(DEFAULT_PANCARD_NUMBER))
            .andExpect(jsonPath("$.birthdate").value(DEFAULT_BIRTHDATE))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.maritalStatus").value(DEFAULT_MARITAL_STATUS))
            .andExpect(jsonPath("$.residentialStatus").value(DEFAULT_RESIDENTIAL_STATUS))
            .andExpect(jsonPath("$.form60").value(DEFAULT_FORM_60))
            .andExpect(jsonPath("$.formSixtyAckgeNo").value(DEFAULT_FORM_SIXTY_ACKGE_NO))
            .andExpect(jsonPath("$.category").value(DEFAULT_CATEGORY))
            .andExpect(jsonPath("$.nominee").value(DEFAULT_NOMINEE))
            .andExpect(jsonPath("$.verify").value(DEFAULT_VERIFY))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX))
            .andExpect(jsonPath("$.mob1").value(DEFAULT_MOB_1))
            .andExpect(jsonPath("$.mob2").value(DEFAULT_MOB_2))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.ckyc").value(DEFAULT_CKYC))
            .andExpect(jsonPath("$.refckyc").value(DEFAULT_REFCKYC))
            .andExpect(jsonPath("$.gstn").value(DEFAULT_GSTN))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.modifiedAt").value(DEFAULT_MODIFIED_AT.toString()))
            .andExpect(jsonPath("$.enable").value(DEFAULT_ENABLE.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingCustomer() throws Exception {
        // Get the customer
        restCustomerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingCustomer() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).orElseThrow();
        // Disconnect from session so that the updates on updatedCustomer are not directly saved in db
        em.detach(updatedCustomer);
        updatedCustomer
            .accountNumber(UPDATED_ACCOUNT_NUMBER)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .fullName(UPDATED_FULL_NAME)
            .email(UPDATED_EMAIL)
            .aadharNumber(UPDATED_AADHAR_NUMBER)
            .pancardNumber(UPDATED_PANCARD_NUMBER)
            .birthdate(UPDATED_BIRTHDATE)
            .age(UPDATED_AGE)
            .gender(UPDATED_GENDER)
            .maritalStatus(UPDATED_MARITAL_STATUS)
            .residentialStatus(UPDATED_RESIDENTIAL_STATUS)
            .form60(UPDATED_FORM_60)
            .formSixtyAckgeNo(UPDATED_FORM_SIXTY_ACKGE_NO)
            .category(UPDATED_CATEGORY)
            .nominee(UPDATED_NOMINEE)
            .verify(UPDATED_VERIFY)
            .fax(UPDATED_FAX)
            .mob1(UPDATED_MOB_1)
            .mob2(UPDATED_MOB_2)
            .telephone(UPDATED_TELEPHONE)
            .ckyc(UPDATED_CKYC)
            .refckyc(UPDATED_REFCKYC)
            .gstn(UPDATED_GSTN)
            .createdAt(UPDATED_CREATED_AT)
            .modifiedAt(UPDATED_MODIFIED_AT)
            .enable(UPDATED_ENABLE);
        CustomerDTO customerDTO = customerMapper.toDto(updatedCustomer);

        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, customerDTO.getCustomerId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getAccountNumber()).isEqualTo(UPDATED_ACCOUNT_NUMBER);
        assertThat(testCustomer.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testCustomer.getFullName()).isEqualTo(UPDATED_FULL_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getAadharNumber()).isEqualTo(UPDATED_AADHAR_NUMBER);
        assertThat(testCustomer.getPancardNumber()).isEqualTo(UPDATED_PANCARD_NUMBER);
        assertThat(testCustomer.getBirthdate()).isEqualTo(UPDATED_BIRTHDATE);
        assertThat(testCustomer.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testCustomer.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testCustomer.getMaritalStatus()).isEqualTo(UPDATED_MARITAL_STATUS);
        assertThat(testCustomer.getResidentialStatus()).isEqualTo(UPDATED_RESIDENTIAL_STATUS);
        assertThat(testCustomer.getForm60()).isEqualTo(UPDATED_FORM_60);
        assertThat(testCustomer.getFormSixtyAckgeNo()).isEqualTo(UPDATED_FORM_SIXTY_ACKGE_NO);
        assertThat(testCustomer.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testCustomer.getNominee()).isEqualTo(UPDATED_NOMINEE);
        assertThat(testCustomer.getVerify()).isEqualTo(UPDATED_VERIFY);
        assertThat(testCustomer.getFax()).isEqualTo(UPDATED_FAX);
        assertThat(testCustomer.getMob1()).isEqualTo(UPDATED_MOB_1);
        assertThat(testCustomer.getMob2()).isEqualTo(UPDATED_MOB_2);
        assertThat(testCustomer.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testCustomer.getCkyc()).isEqualTo(UPDATED_CKYC);
        assertThat(testCustomer.getRefckyc()).isEqualTo(UPDATED_REFCKYC);
        assertThat(testCustomer.getGstn()).isEqualTo(UPDATED_GSTN);
        assertThat(testCustomer.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testCustomer.getModifiedAt()).isEqualTo(UPDATED_MODIFIED_AT);
        assertThat(testCustomer.getEnable()).isEqualTo(UPDATED_ENABLE);
    }

    @Test
    @Transactional
    void putNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, customerDTO.getCustomerId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCustomerWithPatch() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer using partial update
        Customer partialUpdatedCustomer = new Customer();
        partialUpdatedCustomer.setCustomerId(customer.getCustomerId());

        partialUpdatedCustomer
            .accountNumber(UPDATED_ACCOUNT_NUMBER)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .aadharNumber(UPDATED_AADHAR_NUMBER)
            .birthdate(UPDATED_BIRTHDATE)
            .gender(UPDATED_GENDER)
            .maritalStatus(UPDATED_MARITAL_STATUS)
            .formSixtyAckgeNo(UPDATED_FORM_SIXTY_ACKGE_NO)
            .nominee(UPDATED_NOMINEE)
            .verify(UPDATED_VERIFY)
            .mob1(UPDATED_MOB_1)
            .mob2(UPDATED_MOB_2)
            .telephone(UPDATED_TELEPHONE)
            .refckyc(UPDATED_REFCKYC)
            .createdAt(UPDATED_CREATED_AT)
            .enable(UPDATED_ENABLE);

        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCustomer.getCustomerId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCustomer))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getAccountNumber()).isEqualTo(UPDATED_ACCOUNT_NUMBER);
        assertThat(testCustomer.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testCustomer.getFullName()).isEqualTo(DEFAULT_FULL_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCustomer.getAadharNumber()).isEqualTo(UPDATED_AADHAR_NUMBER);
        assertThat(testCustomer.getPancardNumber()).isEqualTo(DEFAULT_PANCARD_NUMBER);
        assertThat(testCustomer.getBirthdate()).isEqualTo(UPDATED_BIRTHDATE);
        assertThat(testCustomer.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testCustomer.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testCustomer.getMaritalStatus()).isEqualTo(UPDATED_MARITAL_STATUS);
        assertThat(testCustomer.getResidentialStatus()).isEqualTo(DEFAULT_RESIDENTIAL_STATUS);
        assertThat(testCustomer.getForm60()).isEqualTo(DEFAULT_FORM_60);
        assertThat(testCustomer.getFormSixtyAckgeNo()).isEqualTo(UPDATED_FORM_SIXTY_ACKGE_NO);
        assertThat(testCustomer.getCategory()).isEqualTo(DEFAULT_CATEGORY);
        assertThat(testCustomer.getNominee()).isEqualTo(UPDATED_NOMINEE);
        assertThat(testCustomer.getVerify()).isEqualTo(UPDATED_VERIFY);
        assertThat(testCustomer.getFax()).isEqualTo(DEFAULT_FAX);
        assertThat(testCustomer.getMob1()).isEqualTo(UPDATED_MOB_1);
        assertThat(testCustomer.getMob2()).isEqualTo(UPDATED_MOB_2);
        assertThat(testCustomer.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testCustomer.getCkyc()).isEqualTo(DEFAULT_CKYC);
        assertThat(testCustomer.getRefckyc()).isEqualTo(UPDATED_REFCKYC);
        assertThat(testCustomer.getGstn()).isEqualTo(DEFAULT_GSTN);
        assertThat(testCustomer.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testCustomer.getModifiedAt()).isEqualTo(DEFAULT_MODIFIED_AT);
        assertThat(testCustomer.getEnable()).isEqualTo(UPDATED_ENABLE);
    }

    @Test
    @Transactional
    void fullUpdateCustomerWithPatch() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer using partial update
        Customer partialUpdatedCustomer = new Customer();
        partialUpdatedCustomer.setCustomerId(customer.getCustomerId());

        partialUpdatedCustomer
            .accountNumber(UPDATED_ACCOUNT_NUMBER)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .fullName(UPDATED_FULL_NAME)
            .email(UPDATED_EMAIL)
            .aadharNumber(UPDATED_AADHAR_NUMBER)
            .pancardNumber(UPDATED_PANCARD_NUMBER)
            .birthdate(UPDATED_BIRTHDATE)
            .age(UPDATED_AGE)
            .gender(UPDATED_GENDER)
            .maritalStatus(UPDATED_MARITAL_STATUS)
            .residentialStatus(UPDATED_RESIDENTIAL_STATUS)
            .form60(UPDATED_FORM_60)
            .formSixtyAckgeNo(UPDATED_FORM_SIXTY_ACKGE_NO)
            .category(UPDATED_CATEGORY)
            .nominee(UPDATED_NOMINEE)
            .verify(UPDATED_VERIFY)
            .fax(UPDATED_FAX)
            .mob1(UPDATED_MOB_1)
            .mob2(UPDATED_MOB_2)
            .telephone(UPDATED_TELEPHONE)
            .ckyc(UPDATED_CKYC)
            .refckyc(UPDATED_REFCKYC)
            .gstn(UPDATED_GSTN)
            .createdAt(UPDATED_CREATED_AT)
            .modifiedAt(UPDATED_MODIFIED_AT)
            .enable(UPDATED_ENABLE);

        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCustomer.getCustomerId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCustomer))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getAccountNumber()).isEqualTo(UPDATED_ACCOUNT_NUMBER);
        assertThat(testCustomer.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testCustomer.getFullName()).isEqualTo(UPDATED_FULL_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getAadharNumber()).isEqualTo(UPDATED_AADHAR_NUMBER);
        assertThat(testCustomer.getPancardNumber()).isEqualTo(UPDATED_PANCARD_NUMBER);
        assertThat(testCustomer.getBirthdate()).isEqualTo(UPDATED_BIRTHDATE);
        assertThat(testCustomer.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testCustomer.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testCustomer.getMaritalStatus()).isEqualTo(UPDATED_MARITAL_STATUS);
        assertThat(testCustomer.getResidentialStatus()).isEqualTo(UPDATED_RESIDENTIAL_STATUS);
        assertThat(testCustomer.getForm60()).isEqualTo(UPDATED_FORM_60);
        assertThat(testCustomer.getFormSixtyAckgeNo()).isEqualTo(UPDATED_FORM_SIXTY_ACKGE_NO);
        assertThat(testCustomer.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testCustomer.getNominee()).isEqualTo(UPDATED_NOMINEE);
        assertThat(testCustomer.getVerify()).isEqualTo(UPDATED_VERIFY);
        assertThat(testCustomer.getFax()).isEqualTo(UPDATED_FAX);
        assertThat(testCustomer.getMob1()).isEqualTo(UPDATED_MOB_1);
        assertThat(testCustomer.getMob2()).isEqualTo(UPDATED_MOB_2);
        assertThat(testCustomer.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testCustomer.getCkyc()).isEqualTo(UPDATED_CKYC);
        assertThat(testCustomer.getRefckyc()).isEqualTo(UPDATED_REFCKYC);
        assertThat(testCustomer.getGstn()).isEqualTo(UPDATED_GSTN);
        assertThat(testCustomer.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testCustomer.getModifiedAt()).isEqualTo(UPDATED_MODIFIED_AT);
        assertThat(testCustomer.getEnable()).isEqualTo(UPDATED_ENABLE);
    }

    @Test
    @Transactional
    void patchNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, customerDTO.getCustomerId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setCustomerId(UUID.randomUUID().toString());

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(customerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCustomer() throws Exception {
        // Initialize the database
        customer.setCustomerId(UUID.randomUUID().toString());
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeDelete = customerRepository.findAll().size();

        // Delete the customer
        restCustomerMockMvc
            .perform(delete(ENTITY_API_URL_ID, customer.getCustomerId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
