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

        new LiveStock(name: "Test1")
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test2")
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test3")
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test4")
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test5").save()

        new LiveStock(name: "Test6")
                .addToPriceHistories(new PriceHistory(value: 500, changeDate: generateRandomDate()))
                .save()

    }

    def destroy = {
    }

    def generateRandomDate() {
        (new Date()..new Date(2014-1900,5,1)).toList().sort{Math.random()}[0]
    }

}
