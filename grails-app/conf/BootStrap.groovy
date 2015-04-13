import edu.test.many.to.many.Author
import edu.test.many.to.many.Book
import edu.test.many.to.many.LiveStock
import edu.test.many.to.many.PriceHistory

class BootStrap {

    def init = { servletContext ->

        new Author(name: "Stephen King")
                .addToBooks(new Book(title: "The Stand"))
                .addToBooks(new Book(title: "The Shining"))
                .save()

        new Book(name: "Groovy in Action")
                .addToAuthors(new Author(name: "Dierk Koenig"))
                .addToAuthors(new Author(name: "Guillaume Laforge"))
                .save()

        new LiveStock(name: "Test")
                .addToPriceHistories(new PriceHistory(value: 100))
                .addToPriceHistories(new PriceHistory(value: 200))
                .addToPriceHistories(new PriceHistory(value: 300))
                .save()

    }
    def destroy = {
    }
}
