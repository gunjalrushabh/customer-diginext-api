package com.alphware.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.alphware.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Customer.class);
        Customer customer1 = new Customer();
        customer1.setCustomerId("id1");
        Customer customer2 = new Customer();
        customer2.setCustomerId(customer1.getCustomerId());
        assertThat(customer1).isEqualTo(customer2);
        customer2.setCustomerId("id2");
        assertThat(customer1).isNotEqualTo(customer2);
        customer1.setCustomerId(null);
        assertThat(customer1).isNotEqualTo(customer2);
    }
}
