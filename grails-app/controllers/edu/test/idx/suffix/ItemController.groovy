package edu.test.idx.suffix

import grails.converters.JSON

class ItemController {

    def index() {
        def item = Item.get(1)
        def collection = item?.media.findAll{it.fileName != null}
        render collection as JSON
    }
}
