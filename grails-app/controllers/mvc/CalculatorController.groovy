package mvc

import grails.validation.Validateable
import org.hibernate.validator.internal.metadata.facets.Validatable

class CalculatorController {

    def calc(CalculatorModel calculatorModel) {
        double result = (calculatorModel.en + calculatorModel.exam) / 2
        // Investigate 'calculatorModel.errors' to find out which field is concerned.
        // Refer to 'feature/validation' branch
        if(1 > calculatorModel.en || calculatorModel.en > 6){
            //Problematic 'en'
            calculatorModel.result = "'en' input is wrong"
        }else if(1 > calculatorModel.exam || calculatorModel.exam > 6){
            //Problematic 'exam'
            calculatorModel.result = "'exam' input is wrong"
        }else{
            calculatorModel.result = result;
        }
        calculatorModel.result = result
        render view: "CalculatorOutput", model: [model: calculatorModel]
    }
}

class CalculatorModel implements Validateable{
    double en
    double exam
    String result

    static constraints ={
        //deklarative Validierung, da dabei keine Logik vorhanden ist.
        en min:1d, max:6d, scale:1
        exam min:1d, max:6d, scale:1
        result nullable: true
    }
}