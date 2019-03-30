package io.apl.springstarter.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apl.springstarter.model.Player;

@RestController
public class APLAuctionDetailsController {

	
	@RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

	
//	@RequestMapping(value ="/playerdetails",consumes = MediaType.)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@PostMapping("/post")
//	
	@CrossOrigin(origins = "https://webmountstudio.com/")
	@PostMapping(path = "/playerdetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> newBazz(@RequestBody Player playerDetail){
		try {
			PlayerDBAccess playerDB = new PlayerDBAccess();
			boolean isPlayerRegistered = false;
			if(playerDetail!=null)
				 isPlayerRegistered = playerDB.registerPlayer(playerDetail);
			
			
			if(isPlayerRegistered)
				return new ResponseEntity<>("Player successfully registered", HttpStatus.OK);
			else
				return new ResponseEntity<>("problem", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
			
	}
}
