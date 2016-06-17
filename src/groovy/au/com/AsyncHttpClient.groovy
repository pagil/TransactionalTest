package au.com

import groovyx.net.http.AsyncHTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method

/**
 * To test async requests sending:
 * 1. Run the "Grails: TransactionTest" Grails application
 * 2. Run AsyncHttpClient class as a console application
 * 3. Check the console output
 *
 * Perfect example is published here:
 * https://github.com/jgritman/httpbuilder/wiki/AsyncHTTPBuilder
 */
class AsyncHttpClient {
    public static void main (String[] args) {
        def map = [key: "value"]
        def http = new AsyncHTTPBuilder(uri: "http://localhost:8090/TransactionalTest/listener")
        println "Before posting data: ${new Date()}"
        def promise = http.request(Method.POST) { request ->
            requestContentType = ContentType.JSON
            body = map
            response.success = { resp, json ->
                println "Sent data successfully and received response: ${json}"
            }
            response.failure = {
                println "Unexpected error when sending data: ${map}"
            }
        }
        println "After posting data - request sent without delay: ${new Date()}"
        while (!promise.done) {
            println 'waiting...'
            Thread.sleep(2000)
        }
        println "Response received at: ${new Date()} value: ${promise.get()}"
        // Without line of code below the application does not stop runnign after completing the jo. Instead it its stuck waiting for other threads to finish running.
        // But they do not - the app gets stuck.
        System.exit(0)
    }
}
