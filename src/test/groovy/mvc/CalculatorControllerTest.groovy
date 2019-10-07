package mvc

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CalculatorControllerTest extends Specification
implements ControllerUnitTest<CalculatorController>{
    //Methode können bei Groovy mit Abstand geschrieben werden, was in Java nicht funktioniert.
    def "simple average of #en and #exam should be #result"() {
        when:
        controller.calc(2.0, 1.0)
        then:
        model.result == 2.0
    }
}
