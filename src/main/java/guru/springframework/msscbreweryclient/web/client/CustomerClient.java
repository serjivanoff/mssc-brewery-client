package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Ivanov
 * @since 2023/01/17
 */
@Component
@Slf4j
public class CustomerClient extends AbstractBreweryClient{

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public CustomerDto getById(UUID uuid) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
	}

	public URI create(CustomerDto customerDto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
	}

	public void update(UUID uuid, CustomerDto customerDto) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
	}

	public void delete(UUID uuid) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + uuid.toString());
	}
}
