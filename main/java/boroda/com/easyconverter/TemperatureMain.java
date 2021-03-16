package boroda.com.easyconverter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureMain extends AppCompatActivity {

    Spinner spinnerFrom;
    Spinner spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);

        // Адаптер к спиннерам
        ArrayAdapter<?> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.spinnerTemperature, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnerAdapter);
        spinnerTo.setAdapter(spinnerAdapter);
        spinnerTo.setSelection(1);
    }

    public void onClickTemperatureActivity(View e) {

        // Объявляем переменные
        double firstValueText;
        double secondValueText;
        String firstSpinnerStringType;
        String secondSpinnerStringType;

        // Объявляем компоненты
        EditText enterNumbers = (EditText) findViewById(R.id.textValue);
        EditText outputNumbers = (EditText) findViewById(R.id.textResult);

        // Создаем объект для конвертации
        TemperatureActivity temperatureActivity = new TemperatureActivity();

        // проверка ввода числа
        if (!enterNumbers.getText().toString().equals("")) {

            // получаем вводимые данные пользователя из полей
            firstValueText = Double.parseDouble(enterNumbers.getText().toString());
            firstSpinnerStringType = spinnerFrom.getSelectedItem().toString();
            secondSpinnerStringType = spinnerTo.getSelectedItem().toString();

            // ввод данных в объект
            temperatureActivity.setTextValue(firstValueText);
            temperatureActivity.setSpinnerEnter(firstSpinnerStringType);
            temperatureActivity.setSpinnerOutput(secondSpinnerStringType);

            // рассчитываем результат конвертации
            secondValueText = temperatureActivity.calculateSecondValue();
            temperatureActivity.setTextResult(secondValueText);

            // выводим результат преобразования в консоль
            outputNumbers.setText(temperatureActivity.resultOutput());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Enter Quantity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}