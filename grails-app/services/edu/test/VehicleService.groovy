package edu.test

import grails.transaction.Transactional

@Transactional
class VehicleService {
    def engineService

    def createVehicle(String n) {
        def v = new Vehicle(name: n)
        v.save()
        def e = engineService.createEngine('diesel')
        return v
    }
}
