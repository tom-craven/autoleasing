var vm = new Vue({
    el: '#vue_data',
    data: {
        leaseholder: [],
        deal: [],
        finance: "${vehicle.toString()}",
        vehicle: [{
            model: "Honda",
            make: "",
            year: "",
            emissions: [{
                cO2Emissions: "",
                standardEuroEmissions: ""
            }],
            engineAndDriveTrain: [{
                fuelType: "",
                capacity: "",
                gears: "",
                numberOfValves: "",
                transmission: ""
            }],
            fuelConsumption: [{
                eCCombined: "",
                eCExtraUrban: "",
                eCUrban: ""
            }],
            warranty: [{
                paintworkWarrantyMonths: "",
                serviceIntervalFrequencyMonths: "",
                serviceIntervalMileage: "",
                standardManufacturersWarrantyMiles: "",
                standardManufacturersWarrantyYears: ""
            }],
            ip: [{
                insuranceGroup: "",
                nCAPAdultOccupantProtection: "",
                nCAPChildOccupantProtection: "",
                nCAPOverallRating: "",
                nCAPPedestrianProtection: "",
                nCAPSafetyAssist: ""
            }],
            performance: [{
                zeroToSixty: "",
                enginePower: "",
                maximumEnginePowerRPM: "",
                engineTorque: "",
                maximumEngineTorque: "",
                topSpeed: ""
            }],
            tyres: [{
                tyreSizeFront: "",
                tyreSizeRear: ""
            }],
            vehicleDimensions: [{
                height: "",
                length: "",
                wheelbase: "",
                widthIncludingMirrors: ""
            }],
            weightAndCapacity: [{
                fuelTankCapacityLitres: "",
                grossVehicleWeight: "",
                luggageCapacitySeatsDown: "",
                luggageCapacitySeatsUp: "",
                maxTowingWeightBraked: "",
                maxTowingWeightUnbraked: "",
                noOfSeats: "",
                turningCircleKerbToKerb: ""
            }]
        }]
    }
});


