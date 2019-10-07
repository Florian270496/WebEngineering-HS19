package mvc

class CalculatorController {

    def calc(CalculatorModel calculatorModel) {
        double result = (calculatorModel.en + calculatorModel.exam) / 2
        calculatorModel.result = result
        render view: "CalculatorOutput", model: [model: calculatorModel]
    }
}

class CalculatorModel{
    double en
    double exam
    double result
}