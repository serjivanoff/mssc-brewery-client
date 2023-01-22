package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sergey Ivanov
 * @since 2023/01/17
 */
@Component
@Slf4j
public class CustomerClient {

	private static final String CUSTOMER_PATH = "/api/v1/customer/";
	@Value("${sfg.brewery.apihost}")
	private String apiHost;

	private final RestTemplate restTemplate;

	public CustomerClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public CustomerDto getById(UUID uuid) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH + uuid.toString(), CustomerDto.class);
	}

	public URI create(CustomerDto customerDto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH, customerDto);
	}

	public void update(UUID uuid, CustomerDto customerDto) {
		restTemplate.put(apiHost + CUSTOMER_PATH + uuid.toString(), customerDto);
	}

	public void delete(UUID uuid) {
		restTemplate.delete(apiHost + CUSTOMER_PATH + uuid.toString());
	}
}
