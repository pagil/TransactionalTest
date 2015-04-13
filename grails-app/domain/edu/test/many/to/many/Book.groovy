package edu.test.many.to.many

class Book {

    static belongsTo = Author
    static hasMany = [authors: Author]

    String title
}
