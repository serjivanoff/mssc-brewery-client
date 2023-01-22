package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import java.net.URI;
import java.util.UUID;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 2019-04-23.
 */
@Component
public class BreweryClient extends AbstractBreweryClient {


	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}

	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + uuid, beerDto);
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + uuid);
	}

}
