package edu.test.idx.suffix

class Item {

    static constraints = {
    }

    List media = []

    static mapping = {
        media cascade: 'all-delete-orphan', lazy: false
    }

    static hasMany = [
            media: Media
    ]

    String itemName;
}
