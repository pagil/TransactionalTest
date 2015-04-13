package edu.test.many.to.many

class Author {

    static hasMany = [books: Book]

    String name
}
