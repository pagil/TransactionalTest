package edu.test.many.to.many

class LiveStock {

    String name

    static hasMany = [priceHistories: PriceHistory]

    static mapping = {
        priceHistories cascade: "all-delete-orphan"
    }
}
