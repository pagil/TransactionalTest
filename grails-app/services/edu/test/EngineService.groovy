package edu.test

import grails.transaction.Transactional
import org.springframework.transaction.annotation.Propagation
//import org.springframework.transaction.annotation.Transactional

//@Transactional(propagation = Propagation.REQUIRES_NEW)
@Transactional
class EngineService {

    public createEngine(String t) {
        try {
            def e = new Engine(type: t)
            def p
            p.class
            e.save()
        } catch (e) {
            e.printStackTrace()
        }
    }
}
