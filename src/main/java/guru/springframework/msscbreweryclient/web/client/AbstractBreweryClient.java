package guru.springframework.msscbreweryclient.web.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sergey Ivanov
 * @since 2023/01/22
 */
public abstract class AbstractBreweryClient {
	@Value("${sfg.brewery.apihost}")
	protected String apiHost;
	protected final String BEER_PATH_V1 = "/api/v1/beer/";
	protected final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

	protected final RestTemplate restTemplate;

	public AbstractBreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

}
