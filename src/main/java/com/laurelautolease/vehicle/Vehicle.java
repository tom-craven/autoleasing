package com.laurelautolease.vehicle;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Vehicle")
public class Vehicle {

    public String description;
    public String id;
    public String imageUrl;
    public String model;
    public String make;
    public String year;
    public String lowestPrice;
    //weight and capacity
    public String fuelTankCapacityLitres;
    public String grossVehicleWeight;
    public String luggageCapacitySeatsDown;
    public String luggageCapacitySeatsUp;
    public String maxTowingWeightBraked;
    public String maxTowingWeightUnbraked;
    public String noOfSeats;
    public String turningCircleKerbToKerb;
    public String cO2Emissions;
    public String standardEuroEmissions;
    public String capacity;
    public String gears;
    public String numberOfValves;
    public String transmission;
    public String fuelType;
    public String eCCombined;
    public String eCExtraUrban;
    public String eCUrban;
    public String paintworkWarrantyMonths;
    public String serviceIntervalFrequencyMonths;
    public String serviceIntervalMileage;
    public String standardManufacturersWarrantyMiles;
    public String standardManufacturersWarrantyYears;
    public String insuranceGroup;
    public String nCAPAdultOccupantProtection;
    public String nCAPChildOccupantProtection;
    public String nCAPOverallRating;
    public String nCAPPedestrianProtection;
    public String nCAPSafetyAssist;
    public String zeroToSixty;
    public String enginePower;
    public String maximumEnginePowerRPM;
    public String engineTorque;
    public String maximumEngineTorque;
    public String topSpeed;
    public String tyreSizeFront;
    public String tyreSizeRear;
    public String height;
    public String length;
    public String wheelbase;
    public String widthIncludingMirrors;

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @DynamoDBAttribute
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @DynamoDBAttribute
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @DynamoDBAttribute
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    @DynamoDBAttribute
    public String getLowestPrice() {
        return lowestPrice;
    }
    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @DynamoDBAttribute
    public String getFuelTankCapacityLitres() {
        return fuelTankCapacityLitres;
    }
    public void setFuelTankCapacityLitres(String fuelTankCapacityLitres) {
        this.fuelTankCapacityLitres = fuelTankCapacityLitres;
    }

    @DynamoDBAttribute
    public String getGrossVehicleWeight() {
        return grossVehicleWeight;
    }
    public void setGrossVehicleWeight(String grossVehicleWeight) {
        this.grossVehicleWeight = grossVehicleWeight;
    }

    @DynamoDBAttribute
    public String getLuggageCapacitySeatsDown() {
        return luggageCapacitySeatsDown;
    }
    public void setLuggageCapacitySeatsDown(String luggageCapacitySeatsDown) {
        this.luggageCapacitySeatsDown = luggageCapacitySeatsDown;
    }

    @DynamoDBAttribute
    public String getLuggageCapacitySeatsUp() {
        return luggageCapacitySeatsUp;
    }
    public void setLuggageCapacitySeatsUp(String luggageCapacitySeatsUp) {
        this.luggageCapacitySeatsUp = luggageCapacitySeatsUp;
    }

    @DynamoDBAttribute
    public String getMaxTowingWeightBraked() {
        return maxTowingWeightBraked;
    }
    public void setMaxTowingWeightBraked(String maxTowingWeightBraked) {
        this.maxTowingWeightBraked = maxTowingWeightBraked;
    }

    @DynamoDBAttribute
    public String getMaxTowingWeightUnbraked() {
        return maxTowingWeightUnbraked;
    }
    public void setMaxTowingWeightUnbraked(String maxTowingWeightUnbraked) {
        this.maxTowingWeightUnbraked = maxTowingWeightUnbraked;
    }

    @DynamoDBAttribute
    public String getNoOfSeats() {
        return noOfSeats;
    }
    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @DynamoDBAttribute
    public String getTurningCircleKerbToKerb() {
        return turningCircleKerbToKerb;
    }
    public void setTurningCircleKerbToKerb(String turningCircleKerbToKerb) {
        this.turningCircleKerbToKerb = turningCircleKerbToKerb;
    }

    @DynamoDBAttribute
    public String getcO2Emissions() {
        return cO2Emissions;
    }
    public void setcO2Emissions(String cO2Emissions) {
        this.cO2Emissions = cO2Emissions;
    }

    @DynamoDBAttribute
    public String getStandardEuroEmissions() {
        return standardEuroEmissions;
    }
    public void setStandardEuroEmissions(String standardEuroEmissions) {
        this.standardEuroEmissions = standardEuroEmissions;
    }

    @DynamoDBAttribute
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @DynamoDBAttribute
    public String getGears() {
        return gears;
    }

    public void setGears(String gears) {
        this.gears = gears;
    }

    @DynamoDBAttribute
    public String getNumberOfValves() {
        return numberOfValves;
    }

    public void setNumberOfValves(String numberOfValves) {
        this.numberOfValves = numberOfValves;
    }

    @DynamoDBAttribute
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @DynamoDBAttribute
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @DynamoDBAttribute
    public String geteCCombined() {
        return eCCombined;
    }

    public void seteCCombined(String eCCombined) {
        this.eCCombined = eCCombined;
    }

    @DynamoDBAttribute
    public String geteCExtraUrban() {
        return eCExtraUrban;
    }

    public void seteCExtraUrban(String eCExtraUrban) {
        this.eCExtraUrban = eCExtraUrban;
    }

    @DynamoDBAttribute
    public String geteCUrban() {
        return eCUrban;
    }

    public void seteCUrban(String eCUrban) {
        this.eCUrban = eCUrban;
    }

    @DynamoDBAttribute
    public String getPaintworkWarrantyMonths() {
        return paintworkWarrantyMonths;
    }

    public void setPaintworkWarrantyMonths(String paintworkWarrantyMonths) {
        this.paintworkWarrantyMonths = paintworkWarrantyMonths;
    }

    @DynamoDBAttribute
    public String getServiceIntervalFrequencyMonths() {
        return serviceIntervalFrequencyMonths;
    }

    public void setServiceIntervalFrequencyMonths(String serviceIntervalFrequencyMonths) {
        this.serviceIntervalFrequencyMonths = serviceIntervalFrequencyMonths;
    }

    @DynamoDBAttribute
    public String getServiceIntervalMileage() {
        return serviceIntervalMileage;
    }

    public void setServiceIntervalMileage(String serviceIntervalMileage) {
        this.serviceIntervalMileage = serviceIntervalMileage;
    }

    @DynamoDBAttribute
    public String getStandardManufacturersWarrantyMiles() {
        return standardManufacturersWarrantyMiles;
    }

    public void setStandardManufacturersWarrantyMiles(String standardManufacturersWarrantyMiles) {
        this.standardManufacturersWarrantyMiles = standardManufacturersWarrantyMiles;
    }

    @DynamoDBAttribute
    public String getStandardManufacturersWarrantyYears() {
        return standardManufacturersWarrantyYears;
    }

    public void setStandardManufacturersWarrantyYears(String standardManufacturersWarrantyYears) {
        this.standardManufacturersWarrantyYears = standardManufacturersWarrantyYears;
    }

    @DynamoDBAttribute
    public String getInsuranceGroup() {
        return insuranceGroup;
    }

    public void setInsuranceGroup(String insuranceGroup) {
        this.insuranceGroup = insuranceGroup;
    }

    @DynamoDBAttribute
    public String getnCAPAdultOccupantProtection() {
        return nCAPAdultOccupantProtection;
    }

    public void setnCAPAdultOccupantProtection(String nCAPAdultOccupantProtection) {
        this.nCAPAdultOccupantProtection = nCAPAdultOccupantProtection;
    }

    @DynamoDBAttribute
    public String getnCAPChildOccupantProtection() {
        return nCAPChildOccupantProtection;
    }

    public void setnCAPChildOccupantProtection(String nCAPChildOccupantProtection) {
        this.nCAPChildOccupantProtection = nCAPChildOccupantProtection;
    }

    @DynamoDBAttribute
    public String getnCAPOverallRating() {
        return nCAPOverallRating;
    }

    public void setnCAPOverallRating(String nCAPOverallRating) {
        this.nCAPOverallRating = nCAPOverallRating;
    }

    @DynamoDBAttribute
    public String getnCAPPedestrianProtection() {
        return nCAPPedestrianProtection;
    }

    public void setnCAPPedestrianProtection(String nCAPPedestrianProtection) {
        this.nCAPPedestrianProtection = nCAPPedestrianProtection;
    }

    @DynamoDBAttribute
    public String getnCAPSafetyAssist() {
        return nCAPSafetyAssist;
    }

    public void setnCAPSafetyAssist(String nCAPSafetyAssist) {
        this.nCAPSafetyAssist = nCAPSafetyAssist;
    }

    @DynamoDBAttribute
    public String getZeroToSixty() {
        return zeroToSixty;
    }
    public void setZeroToSixty(String zeroToSixty) {
        this.zeroToSixty = zeroToSixty;
    }

    @DynamoDBAttribute
    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }
    @DynamoDBAttribute
    public String getMaximumEnginePowerRPM() {
        return maximumEnginePowerRPM;
    }

    public void setMaximumEnginePowerRPM(String maximumEnginePowerRPM) {
        this.maximumEnginePowerRPM = maximumEnginePowerRPM;
    }
    @DynamoDBAttribute
    public String getEngineTorque() {
        return engineTorque;
    }

    public void setEngineTorque(String engineTorque) {
        this.engineTorque = engineTorque;
    }
    @DynamoDBAttribute
    public String getMaximumEngineTorque() {
        return maximumEngineTorque;
    }

    public void setMaximumEngineTorque(String maximumEngineTorque) {
        this.maximumEngineTorque = maximumEngineTorque;
    }
    @DynamoDBAttribute
    public String getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }
    @DynamoDBAttribute
    public String getTyreSizeFront() {
        return tyreSizeFront;
    }

    public void setTyreSizeFront(String tyreSizeFront) {
        this.tyreSizeFront = tyreSizeFront;
    }
    @DynamoDBAttribute
    public String getTyreSizeRear() {
        return tyreSizeRear;
    }

    public void setTyreSizeRear(String tyreSizeRear) {
        this.tyreSizeRear = tyreSizeRear;
    }
    @DynamoDBAttribute
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    @DynamoDBAttribute
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
    @DynamoDBAttribute
    public String getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    @DynamoDBAttribute
    public String getWidthIncludingMirrors() {
        return widthIncludingMirrors;
    }
    public void setWidthIncludingMirrors(String widthIncludingMirrors) {
        this.widthIncludingMirrors = widthIncludingMirrors;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle(Boolean populate) {
        this.description="Contrary to popular belief, Lorem Ipsum is not simply random text.";
        this.model = "accord";
        this.year = "2012";
        this.lowestPrice = "£299.99";
        this.cO2Emissions = "116 g/km";
        this.standardEuroEmissions = "EURO6";
        this.make = "honda";
        this.imageUrl = "300.jpg";
        this.capacity = "6";
        this.gears = "6";
        this.zeroToSixty = "5sec";
        this.enginePower = "200";
        this.maximumEnginePowerRPM = "N/A";
        this.engineTorque = "150lb";
        this.maximumEngineTorque = "@5000rpm";
        this.topSpeed = "150mph";
        this.capacity = "2.0litre + 12kw";
        this.gears = "10";
        this.numberOfValves = "4";
        this.transmission = "automatic";
        this.fuelType = "Petrol/Hybrid";
        this.eCCombined = "56.5 mpg";
        this.eCExtraUrban = "65.7 mpg";
        this.eCUrban = "46.3 mpg";
        this.tyreSizeFront = "185-60HR15";
        this.tyreSizeRear = "185-60HR15";
        this.height = "1550 mm";
        this.length = "3995 mm";
        this.wheelbase = "2530 mm";
        this.widthIncludingMirrors = "1980 mm";
        this.insuranceGroup = "13E";
        this.nCAPAdultOccupantProtection = "93%";
        this.nCAPChildOccupantProtection = "85%";
        this.nCAPOverallRating = "5";
        this.nCAPPedestrianProtection = "73%";
        this.nCAPSafetyAssist = "71%";
        this.paintworkWarrantyMonths = "36";
        this.serviceIntervalFrequencyMonths = "12";
        this.serviceIntervalMileage = "12500";
        this.standardManufacturersWarrantyMiles = "90000";
        this.standardManufacturersWarrantyYears = "3";
        this.fuelTankCapacityLitres = "40";
        this.grossVehicleWeight = "1605 kg";
        this.luggageCapacitySeatsDown = "884 litres";
        this.luggageCapacitySeatsUp = "354 litres";
        this.maxTowingWeightBraked = "1000 kg";
        this.maxTowingWeightUnbraked = "450 kg";
        this.noOfSeats = "5";
        this.turningCircleKerbToKerb = "10.6 m";
    }

    public Vehicle() {
        this.description="";
        this.model = "";
        this.year = "";
        this.lowestPrice = "";
        this.cO2Emissions = "";
        this.standardEuroEmissions = "";
        this.make = "";
        this.imageUrl = "";
        this.capacity = "";
        this.gears = "";
        this.zeroToSixty = "";
        this.enginePower = "";
        this.maximumEnginePowerRPM = "";
        this.engineTorque = "";
        this.maximumEngineTorque = "";
        this.topSpeed = "";
        this.numberOfValves = "";
        this.transmission = "";
        this.fuelType = "";
        this.eCCombined = "";
        this.eCExtraUrban = "";
        this.eCUrban = "";
        this.tyreSizeFront = "";
        this.tyreSizeRear = "";
        this.height = "";
        this.length = "";
        this.wheelbase = "";
        this.widthIncludingMirrors = "";
        this.insuranceGroup = "";
        this.nCAPAdultOccupantProtection = "";
        this.nCAPChildOccupantProtection = "";
        this.nCAPOverallRating = "";
        this.nCAPPedestrianProtection = "";
        this.nCAPSafetyAssist = "";
        this.paintworkWarrantyMonths = "";
        this.serviceIntervalFrequencyMonths = "";
        this.serviceIntervalMileage = "";
        this.standardManufacturersWarrantyMiles = "";
        this.standardManufacturersWarrantyYears = "";
        this.fuelTankCapacityLitres = "";
        this.grossVehicleWeight = "";
        this.luggageCapacitySeatsDown = "";
        this.luggageCapacitySeatsUp = "";
        this.maxTowingWeightBraked = "";
        this.maxTowingWeightUnbraked = "";
        this.noOfSeats = "";
        this.turningCircleKerbToKerb = "";
    }
}