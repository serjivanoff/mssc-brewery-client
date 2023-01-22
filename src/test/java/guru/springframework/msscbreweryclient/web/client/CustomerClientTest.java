package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Sergey Ivanov
 * @since 2023/01/19
 */
@SpringBootTest
public class CustomerClientTest {
	@Autowired
	private CustomerClient customerClient;

	@Test
	public void getCustomerTest() {
		CustomerDto customer = customerClient.getById(UUID.randomUUID());

		assertNotNull(customer);
	}

	@Test
	public void createCustomerTest() {
		URI uri = customerClient.create(CustomerDto.builder().build());

		assertNotNull(uri);
	}

	@Test
	public void updateCustomerTest() {
		customerClient.update(UUID.randomUUID(), CustomerDto.builder().build());
	}

	@Test
	public void deleteCustomerTest() {
		customerClient.delete(UUID.randomUUID());
	}
}
