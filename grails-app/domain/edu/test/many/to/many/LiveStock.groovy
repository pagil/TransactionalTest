package edu.test.many.to.many

class LiveStock {

    String name
    Date lastPriceChangeDate
    Integer testValue
    boolean valueNotNull

    static hasMany = [priceHistories: PriceHistory]

    static constraints = {
        testValue nullable: true
    }

    // IMPORTANT: () - are very important and necessary in the Derived Properties
    static mapping = {
        priceHistories cascade: "all-delete-orphan"
        lastPriceChangeDate formula: "(select MAX(ph.CHANGE_DATE) from PRICE_HISTORY ph join LIVE_STOCK_PRICE_HISTORY lsph on lsph.PRICE_HISTORY_ID =  ph.ID where lsph.LIVE_STOCK_PRICE_HISTORIES_ID = id)"
        valueNotNull formula: "(DECODE(TEST_VALUE, NULL, 0, 1))"
    }
}
