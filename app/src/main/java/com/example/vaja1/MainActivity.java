package com.example.vaja1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.editTextText);
        EditText fullName = findViewById(R.id.editTextText2);
        EditText country = findViewById(R.id.editTextText3);
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText phone = findViewById(R.id.editTextPhone);
        EditText password = findViewById(R.id.editTextTextPassword);

        RadioGroup gender = findViewById(R.id.radioGroup);
        CheckBox terms = findViewById(R.id.checkBox);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String user = username.getText().toString();
            String name = fullName.getText().toString();
            String drzava = country.getText().toString();
            String mail = email.getText().toString();
            String telefon = phone.getText().toString();
            String geslo = password.getText().toString();

            String spol = "Not selected";

            int selectedId = gender.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selected = findViewById(selectedId);
                spol = selected.getText().toString();
            }

            String pogoji;

            if (terms.isChecked()) {
                pogoji = "Yes";
            } else {
                pogoji = "No";
            }

            String podatki =
                    "Username: " + user +
                            "\nName: " + name +
                            "\nCountry: " + drzava +
                            "\nEmail: " + mail +
                            "\nPhone: " + telefon +
                            "\nPassword: " + geslo +
                            "\nGender: " + spol +
                            "\nTerms Accepted: " + pogoji;

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Registration Details")
                    .setMessage(podatki)
                    .setPositiveButton("OK", null)
                    .show();

        });
    }
}