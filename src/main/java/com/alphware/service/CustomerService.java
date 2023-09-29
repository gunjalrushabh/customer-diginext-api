package com.alphware.service;

import com.alphware.service.dto.CustomerDTO;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import net.sf.jasperreports.engine.JRException;

/**
 * Service Interface for managing {@link com.alphware.domain.Customer}.
 */
public interface CustomerService {
    /**
     * Save a customer.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Updates a customer.
     *
     * @param customerDTO the entity to update.
     * @return the persisted entity.
     */
    CustomerDTO update(CustomerDTO customerDTO);

    /**
     * Partially updates a customer.
     *
     * @param customerDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CustomerDTO> partialUpdate(CustomerDTO customerDTO);

    /**
     * Get all the customers.
     *
     * @return the list of entities.
     */
    List<CustomerDTO> findAll();

    /**
     * Get the "id" customer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(String id);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    String generateReport(String format) throws FileNotFoundException, JRException;
}
