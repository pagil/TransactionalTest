import edu.test.many.to.many.Author
import edu.test.many.to.many.Book
import edu.test.many.to.many.LiveStock
import edu.test.many.to.many.PriceHistory
import org.apache.commons.lang.math.RandomUtils

class BootStrap {

    static def datesRange = (new Date()..new Date(2014-1900,5,1)).toList()

    def init = { servletContext ->

        new Author(name: "Stephen King", testValue: null)
                .addToBooks(new Book(title: "The Stand"))
                .addToBooks(new Book(title: "The Shining"))
                .save()

        new Book(name: "Groovy in Action", testValue: null)
                .addToAuthors(new Author(name: "Dierk Koenig"))
                .addToAuthors(new Author(name: "Guillaume Laforge"))
                .save()

        new LiveStock(name: "Test1", testValue: 3)
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test2", testValue: null)
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test3", testValue: 0)
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test4", testValue: null)
                .addToPriceHistories(new PriceHistory(value: 100, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 200, changeDate: generateRandomDate()))
                .addToPriceHistories(new PriceHistory(value: 300, changeDate: generateRandomDate()))
                .save()

        new LiveStock(name: "Test5", testValue: 7).save()

        new LiveStock(name: "Test6", testValue: 10)
                .addToPriceHistories(new PriceHistory(value: 500, changeDate: generateRandomDate()))
                .save()
        new LiveStock(name: "Test7", testValue: null).save()
        new LiveStock(name: "Test8", testValue: 1).save()
        new LiveStock(name: "Test9", testValue: 5).save()
        new LiveStock(name: "Test10", testValue: null).save()
    }

    def destroy = {
    }

    def generateRandomDate() {
        datesRange[RandomUtils.nextInt(datesRange.size()-1)]
    }

}
