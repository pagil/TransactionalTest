package edu.test

import grails.converters.JSON

class ListenerController {

    def index() {
        def requestJson = request.JSON
        println requestJson
        println "Started waiting..."
        System.sleep(10000)
        println "Stopped waiting!"
        render([result: "OK"] as JSON)
    }
}
