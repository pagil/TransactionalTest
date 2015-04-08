package edu.test

import grails.converters.JSON

class VehicleController {
    def vehicleService

    def index() {
        render(['Up and running!'] as JSON)
    }

    def create() {
        def v = vehicleService.createVehicle(params.name)
        render(v as JSON)
    }
}
