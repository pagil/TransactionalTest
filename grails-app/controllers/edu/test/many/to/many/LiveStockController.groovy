package edu.test.many.to.many

import grails.converters.JSON

class LiveStockController {

    def index() {
        render (['I am working!'] as JSON)
    }

    def sort() {
//        def result = LiveStock.createCriteria().list {
//            order ('valueNotNull', 'desc')
//            order("lastPriceChangeDate", "asc")
//        }

        def result = LiveStock.createCriteria().list {
            if ('true'.equalsIgnoreCase(params.nullsLast)) order ('valueNotNull', 'desc')
        }
        render (result as JSON)
    }

    def lastChangeDate() {
        println params.id
        def priceHistories = LiveStock.get(params.id).priceHistories
        def lastPriceChangeDate = priceHistories.size() > 1 ? priceHistories.max {it.changeDate}.changeDate : null
        render ([lastPriceChangeDate] as JSON)
    }
}
