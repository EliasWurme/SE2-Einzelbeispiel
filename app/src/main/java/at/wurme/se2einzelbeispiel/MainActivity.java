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

        Button btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed = findViewById(R.id.editTextNumber);
                TextView tv = findViewById(R.id.textViewAnswer);
                String msg = ed.getText().toString();
                ConnectionManager conn = new ConnectionManager("se2-isys.aau.at", 53212);
                try {
                    String answer = conn.communicate(msg);
                    tv.setText(answer);
                }catch (Exception e){
                    tv.setText("Fehler: " + msg);
                }
            }
        });


    }

}
