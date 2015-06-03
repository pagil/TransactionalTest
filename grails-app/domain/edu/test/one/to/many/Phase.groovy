package edu.test.one.to.many

class Phase {
    static mapping = {
        id generator: 'assigned', column: "id", sqlType: "number", length: 20, precision: 0
        advertisement sqlType: "number", length: 20, precision: 0
    }

    static belongsTo = [advertisement: Advertisement]

    String phaseName
    Date phaseEndDate
}
