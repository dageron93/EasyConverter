package boroda.com.easyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_main_menu);
    }

    public void toLengthPage(View v) {
        Intent intentLength = new Intent(this, LengthMain.class);
        startActivity(intentLength);
    }

    public void toMassPage(View v) {
        Intent intentMass = new Intent(this, MassMain.class);
        startActivity(intentMass);
    }

    public void toTemperaturePage(View v) {
        Intent intentTemperature = new Intent(this, TemperatureMain.class);
        startActivity(intentTemperature);
    }
}