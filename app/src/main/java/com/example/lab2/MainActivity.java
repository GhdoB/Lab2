package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.utils.TextCalc;

public class MainActivity extends AppCompatActivity {

    TextView tvResults;
    EditText edUserInput;
    Spinner spinnerUserOptions;
    Button btCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvResults = findViewById(R.id.tvResults);
        edUserInput = findViewById(R.id.edUserInput);
        spinnerUserOptions = findViewById(R.id.spinnerUserOptions);
        btCount = findViewById(R.id.btCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_content,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUserOptions.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBtnClick(View view) {
        String inputText = edUserInput.getText().toString();

        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter text!", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedMetric = spinnerUserOptions.getSelectedItem().toString();
        int result = 0;

        switch (selectedMetric) {
            case "Sentences":
                result = TextCalc.countSentences(inputText);
                break;
            case "Words":
                result = TextCalc.countWords(inputText);
                break;
            case "Punctuation":
                result = TextCalc.countPunctuation(inputText);
                break;
            case "Numbers":
                result = TextCalc.countNumbers(inputText);
                break;
            default:
                Toast.makeText(MainActivity.this, "Invalid selection!", Toast.LENGTH_SHORT).show();
                return;
        }

        tvResults.setText("Result: " + result);
    }
}

