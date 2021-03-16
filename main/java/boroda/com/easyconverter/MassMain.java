package boroda.com.easyconverter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MassMain extends AppCompatActivity {

    Spinner spinnerFrom;
    Spinner spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);

        // Адаптер к спиннерам
        ArrayAdapter<?> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.spinnerMass, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(spinnerAdapter);
        spinnerTo.setAdapter(spinnerAdapter);
        spinnerTo.setSelection(1);
    }

    public void onClickMassConversion(View w) {

        // Объявляем переменные
        double firstValueText;
        double secondValueText;
        String firstSpinnerStringType;
        String secondSpinnerStringType;

        // Объявляем компоненты
        EditText enterNumbers = (EditText) findViewById(R.id.textValue);
        EditText outputNumbers = (EditText) findViewById(R.id.textResult);

        // Создаем объект для конвертации
        MassActivity massActivity = new MassActivity();

        // проверка ввода числа
        if (!enterNumbers.getText().toString().equals("")) {

            // получаем вводимые данные пользователя из полей
            firstValueText = Double.parseDouble(enterNumbers.getText().toString());
            firstSpinnerStringType = spinnerFrom.getSelectedItem().toString();
            secondSpinnerStringType = spinnerTo.getSelectedItem().toString();

            // ввод данных в объект
            massActivity.setTextValue(firstValueText);
            massActivity.setSpinnerEnter(firstSpinnerStringType);
            massActivity.setSpinnerOutput(secondSpinnerStringType);

            // рассчитываем результат конвертации
            secondValueText = massActivity.calculateSecondValue();
            massActivity.setTextResult(secondValueText);

            // выводим результат преобразования в консоль
            outputNumbers.setText(massActivity.resultOutput());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Enter Quantity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}