package edu.test.many.to.many

import grails.converters.JSON

class LiveStockController {

    def index() {
        render (['I am working!'] as JSON)
    }

    def sort() {
        def result = LiveStock.createCriteria().list {
            order("lastPriceChangeDate", "desc")
        }
        render (result as JSON)
    }
}
