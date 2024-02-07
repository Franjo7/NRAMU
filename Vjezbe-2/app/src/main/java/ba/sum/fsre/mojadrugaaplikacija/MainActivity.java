package ba.sum.fsre.mojadrugaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button HelloBtn = findViewById(R.id.HelloBtn);
        HelloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "Pozdrav svima!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        Button OpenBtn = findViewById(R.id.OpenBtn);
        OpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DrugaAktivnost.class);
                startActivity(i);
            }
        });

    }
}