package boroda.com.easyconverter;

import java.text.NumberFormat;

public class MassActivity {

    final double kilogram = 1;
    final double tonne = 0.001;
    final double gram = 1000;
    final double milligram = 1000000;
    final double microgram = 1e9;
    final double uk_hundredweight = 0.0196841306;
    //final double nanometer = 1.0e-9;
    final double us_hundredweight = 0.0220462262;
    final double stone = 0.157473044;
    final double pound = 2.20462262;
    final double ounce = 35.2739619;

    private double textValue;
    private double textResult;
    private String spinnerEnter;
    private String spinnerOutput;

    // Конструктор
    public void massConversion() {
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
        if (unitType.equals("Tonne")) {
            return tonne;
        }
        if (unitType.equals("Kilogram")) {
            return kilogram;
        }
        if (unitType.equals("Gram")) {
            return gram;
        }
        if (unitType.equals("Milligram")) {
            return milligram;
        }
        if (unitType.equals("Microgram")) {
            return microgram;
        }
        if (unitType.equals("UK Hundredweight")) {
            return uk_hundredweight;
        }
        if (unitType.equals("US Hundredweight")) {
            return us_hundredweight;
        }
        if (unitType.equals("Stone")) {
            return stone;
        }
        if (unitType.equals("Pound")) {
            return pound;
        }
        if (unitType.equals("Ounce")) {
            return ounce;
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
        resultValue = kilogram / firstSpinner;
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

        if (spinnerOutput.equals("Tonne") ||
                spinnerOutput.equals("Kilogram") ||
                spinnerOutput.equals("Gram") ||
                spinnerOutput.equals("Milligram")) {
            nf.setMaximumFractionDigits(6);
        } else if (spinnerOutput.equals("Microgram") ||
                spinnerOutput.equals("UK Hundredweight") ||
                spinnerOutput.equals("US Hundredweight") ||
                spinnerOutput.equals("Stone")) {
            nf.setMaximumFractionDigits(7);
        } else if (spinnerOutput.equals("Pound")) {
            nf.setMaximumFractionDigits(8);
        } else if (spinnerOutput.equals("Ounce")) {
            nf.setMaximumFractionDigits(9);
        }
        return nf.format(getTextResult());
        //return nf.format(getTextResult()) + " " + getSpinnerFrom();
    }
}
