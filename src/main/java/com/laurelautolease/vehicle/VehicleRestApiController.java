package com.laurelautolease.vehicle;

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
public class VehicleRestApiController {

	private static final Logger logger = LoggerFactory.getLogger(VehicleRestApiController.class);

	private final VehicleRepository vehicleRepository; //Service which will do all data retrieval/manipulation work

	@Autowired
	public VehicleRestApiController(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	// -------------------Retrieve All Vehicles---------------------------------------------

	@RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> listAllVehicles() {
		List<Vehicle> vehicleEntities = (List<Vehicle>) vehicleRepository.findAll();
		if (vehicleEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<>(vehicleEntities, HttpStatus.OK);
	}

	// -------------------Retrieve Single Vehicle------------------------------------------

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getVehicle(@PathVariable("id") String id) {
		logger.info("Fetching Vehicle with id {}", id);
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (!vehicle.isPresent()) {
			logger.error("Vehicle with id {} not found.", id);
			return new ResponseEntity<>(new VehicleErrorType("Vehicle with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
	}

	// -------------------Create a Vehicle-------------------------------------------

	@RequestMapping(value = "/vehicle/", method = RequestMethod.POST)
	public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Vehicle : {}", vehicle);

		if (vehicle.getId()!=null&& vehicleRepository.existsById(vehicle.getId())) {
			logger.error("Unable to create. A Vehicle with name {} already exist", vehicle.getModel());
			return new ResponseEntity<>(new VehicleErrorType("Unable to create. A Vehicle with name " +
					vehicle.getModel() + " already exist."), HttpStatus.CONFLICT);
		}
		vehicleRepository.save(vehicle);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Vehicle ------------------------------------------------

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateVehicle(@PathVariable("id") String id, @RequestBody Vehicle vehicle) {
		logger.info("Updating Vehicle with id {}", id);

		Optional<Vehicle> currentVehicle = vehicleRepository.findById(id);

		if (!currentVehicle.isPresent()) {
			logger.error("Unable to update. Vehicle with id {} not found.", id);
			return new ResponseEntity<>(new VehicleErrorType("Unable to update. Vehicle with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}


		BeanUtils.copyProperties(vehicle, currentVehicle.get());

		vehicleRepository.save(currentVehicle.get());
		return new ResponseEntity<>(currentVehicle, HttpStatus.OK);
	}

	// ------------------- Delete a Vehicle-----------------------------------------

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVehicle(@PathVariable("id") String id) {
		logger.info("Fetching & Deleting Vehicle with id {}", id);

		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (!vehicle.isPresent()) {
			logger.error("Unable to delete. Vehicle with id {} not found.", id);
			return new ResponseEntity<>(new VehicleErrorType("Unable to delete. Vehicle with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		vehicleRepository.deleteById(id);
		return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Vehicles-----------------------------

	@RequestMapping(value = "/vehicle/", method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteAllVehicles() {
		logger.info("Deleting All Vehicles");

		vehicleRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/vehicle/dummy/", method = RequestMethod.GET)
	public ResponseEntity<?> putDummyVehicles() {
		Vehicle vehicle = new Vehicle(true);
		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}

	@RequestMapping(value = "/vehicle/template/", method = RequestMethod.GET)
	public ResponseEntity<?> getTemplate(Vehicle vehicle) {

		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}

}
