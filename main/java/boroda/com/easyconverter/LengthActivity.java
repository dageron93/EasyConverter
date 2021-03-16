package boroda.com.easyconverter;

import java.text.NumberFormat;

public class LengthActivity {

    final double meter = 1;
    final double kilometer = 0.001;
    final double centimeter = 100;
    final double millimeter = 1000;
    final double micrometer = 1000000;
    final double nanometer = 1e9;
    //final double nanometer = 1.0e-9;
    final double mile = 0.000621371192;
    final double yard = 1.0936133;
    final double foot = 3.2808399;
    final double inch = 39.3700787;
    final double nautical_mile = 0.000539956803;

    private double textValue;
    private double textResult;
    private String spinnerEnter;
    private String spinnerOutput;

    // Конструктор
    public void lengthConversion() {
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
        if (unitType.equals("Kilometer")) {
            return kilometer;
        }
        if (unitType.equals("Meter")) {
            return meter;
        }
        if (unitType.equals("Centimeter")) {
            return centimeter;
        }
        if (unitType.equals("Millimeter")) {
            return millimeter;
        }
        if (unitType.equals("Micrometer")) {
            return micrometer;
        }
        if (unitType.equals("Nanometer")) {
            return nanometer;
        }
        if (unitType.equals("Mile")) {
            return mile;
        }
        if (unitType.equals("Yard")) {
            return yard;
        }
        if (unitType.equals("Foot")) {
            return foot;
        }
        if (unitType.equals("Inch")) {
            return inch;
        }
        if (unitType.equals("Nautical mile")) {
            return nautical_mile;
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
        resultValue = meter / firstSpinner;
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

        switch (spinnerOutput) {
            case "Kilometer":
            case "Meter":
            case "Centimeter":
            case "Millimeter":
                nf.setMaximumFractionDigits(12);
                break;
            case "Micrometer":
            case "Nanometer":
                nf.setMaximumFractionDigits(14);
                break;
            case "Inch":
            case "Foot":
            case "Yard":
                nf.setMaximumFractionDigits(4);
                break;
            case "Mile":
            case "Nautical mile":
                nf.setMaximumFractionDigits(9);
                break;
        }
        return nf.format(getTextResult());
        //return nf.format(getTextResult()) + " " + getSpinnerFrom();
    }
}
