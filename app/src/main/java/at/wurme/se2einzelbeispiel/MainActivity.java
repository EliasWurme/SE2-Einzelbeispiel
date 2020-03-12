package at.wurme.se2einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed = findViewById(R.id.editTextNumber);
                TextView tv = findViewById(R.id.textViewAnswer);
                TextView tvOption = findViewById(R.id.textViewOption);
                tvOption.setText("Antwort vom Server");
                String msg = ed.getText().toString();
                ConnectionManager conn = new ConnectionManager("se2-isys.aau.at", 53212);
                try {
                    String answer = conn.communicate(msg);
                    tv.setText(answer);
                } catch (Exception e) {
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed = findViewById(R.id.editTextNumber);
                TextView tv = findViewById(R.id.textViewAnswer);
                TextView tvOption = findViewById(R.id.textViewOption);
                tvOption.setText("Sortierte Ziffern ohne Primzahlen");

                String numbersString = ed.getText().toString();
                NumberSorter ns = new NumberSorter();
                try {
                    String output = ns.sortInput(numbersString);
                    tv.setText(output);
                } catch (Exception e) {

                }

            }
        });


    }

}
