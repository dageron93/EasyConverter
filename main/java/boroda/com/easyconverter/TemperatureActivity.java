package boroda.com.easyconverter;

import java.text.NumberFormat;

public class TemperatureActivity {

    final double celsius = 1;
    final double fahrenheit = 33.8;
    final double kelvin = 274.15;

    private double textValue;
    private double textResult;
    private String spinnerEnter;
    private String spinnerOutput;

    // Конструктор
    public void temperatureConversion() {
        textValue = 0;
        textResult = 0;
        spinnerEnter = "";
        spinnerOutput = "";
    }

    public double getTextValue() {
        return textValue;
    }

    public void setTextValue(double textValue) {
        this.textValue = textValue;
    }

    public double getTextResult() {
        return textResult;
    }

    public void setTextResult(double textResult) {
        this.textResult = textResult;
    }

    public String getSpinnerEnter() {
        return spinnerEnter;
    }

    public void setSpinnerEnter(String spinnerEnter) {
        this.spinnerEnter = spinnerEnter;
    }

    public String getSpinnerOutput() {
        return spinnerOutput;
    }

    public void setSpinnerOutput(String spinnerOutput) {
        this.spinnerOutput = spinnerOutput;
    }

    public double getUnitTypeConstant(String unitType) {
        if (unitType.equals("Celsius")) {
            return celsius;
        }
        if (unitType.equals("Fahrenheit")) {
            return fahrenheit;
        }
        if (unitType.equals("Kelvin")) {
            return kelvin;
        }
        return 0;
    }

    // Метод вычисления
    public double calculateSecondValue() {

        // Объявляем и инициализируем переменные
        double firstValue = getTextValue();
        double resultValue = getTextResult();
        double firstSpinner = getUnitTypeConstant(getSpinnerEnter());
        double secondSpinner = getUnitTypeConstant(getSpinnerOutput());

        // Конвертируем в метры
        resultValue = celsius / firstSpinner;
        //firstValue = firstValue * kilometer;


        // Конвертируем из метров
        resultValue = resultValue * secondSpinner;
        //firstValue = firstValue / secondSpinner;

        // Умножаем на начальную сумму что бы получить конечную сумму
        resultValue = resultValue * firstValue;
        //resultValue = firstValue;

        return resultValue;
    }

    public String resultOutput() {

        // Форматирование чисел
        NumberFormat nf = NumberFormat.getNumberInstance();

        if (spinnerOutput.equals("Celsius") ||
                spinnerOutput.equals("Fahrenheit") ||
                spinnerOutput.equals("Kelvin") ||
                spinnerOutput.equals("Milligram")) {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getTextResult());
        //return nf.format(getTextResult()) + " " + getSpinnerFrom();
    }
}
