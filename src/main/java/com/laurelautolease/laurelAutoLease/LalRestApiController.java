package com.laurelautolease.laurelAutoLease;

import com.laurelautolease.vehicle.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LalRestApiController {

	private static final Logger logger = LoggerFactory.getLogger(LalRestApiController.class);

	private final LalRepository lalService;

	@Autowired
	public LalRestApiController(LalRepository lalService) {
		this.lalService = lalService;
	}

	// -------------------Retrieve All LaurelAutoLeases---------------------------------------------

	@RequestMapping(value = "/laurelAutoLease/", method = RequestMethod.GET)
	public ResponseEntity<?> getLaurelAutoLease() {
		Optional<Lal> LaurelAutoLease = lalService.findById("0");
		return LaurelAutoLease.<ResponseEntity<?>>map(lal -> new ResponseEntity<>(lal, HttpStatus.OK)).orElseGet(() ->
				new ResponseEntity<>(new LalErrorType("Lal not found"), HttpStatus.NOT_FOUND));
	}

    @RequestMapping(value = "/laurelAutoLease/", method = RequestMethod.POST)
    public ResponseEntity<?> createLaurelAutoLease(@RequestBody Lal lal, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Lal : {}", lal);
        lal.id="0";
        if (lalService.existsById(lal.getId())) {
            logger.error("Unable to create. A Lal with name {} already exist", lal.getId());
            return new ResponseEntity<>(new LalErrorType("Unable to create. A Lal with id " +
                    lal.getId() + " already exist. Try update instead"), HttpStatus.CONFLICT);
        }
        lalService.save(lal);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/Lal/{id}").buildAndExpand(lal.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	// ------------------- Update a Lal ------------------------------------------------

	@RequestMapping(value = "/laurelAutoLease/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLaurelAutoLease(@RequestBody Lal Lal) {
		Optional<Lal> currentLaurelAutoLease = lalService.findById("0");
		if (!currentLaurelAutoLease.isPresent()) {
			return new ResponseEntity<>(new LalErrorType("Unable to update. Lal not found."),
					HttpStatus.NOT_FOUND);
		}
		BeanUtils.copyProperties(Lal, currentLaurelAutoLease.get());

		lalService.save(currentLaurelAutoLease.get());
		return new ResponseEntity<>(currentLaurelAutoLease, HttpStatus.OK);
	}

	@RequestMapping(value = "/laurelAutoLease/dummy/", method = RequestMethod.GET)
	public ResponseEntity<?> putDummyLaurelAutoLeases() {
		Lal Lal = new Lal(true);
		return new ResponseEntity<>(Lal, HttpStatus.OK);
	}

	@RequestMapping(value = "/laurelAutoLease/template/", method = RequestMethod.GET)
	public ResponseEntity<?> getTemplate(Lal Lal) {
		return new ResponseEntity<>(Lal, HttpStatus.OK);
	}

}