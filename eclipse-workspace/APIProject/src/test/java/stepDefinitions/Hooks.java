package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@deleteplace")
	public void beforeScenario() throws IOException {
		StepDefinitions sd = new StepDefinitions();

		if (StepDefinitions.place_id == null) {
            sd.add_place_pay_load_with("Shankar", "Kannada", "Newland");
			sd.user_calls_with_http_request("AddplaceAPI", "Post");
			sd.verify_place_ID_created_maps_to_using("Shankar", "getplaceAPI");
		}
	}

}
