package com.curso.formularioconcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    EditText age;
    RadioButton male;
    RadioButton female;
    EditText contestName;
    int edad=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        age = findViewById(R.id.age);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        contestName = findViewById(R.id.namecontest);


        Switch contest = findViewById(R.id.botonConcurso);
        contest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contest.isChecked()) {
                    contestName.setVisibility(View.VISIBLE);
                } else {
                    contestName.setVisibility(View.INVISIBLE);
                }
            }
        });

        Button inscription = findViewById(R.id.inscription);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String number = age.getText().toString();
                    edad = Integer.parseInt(number);
                } catch (NumberFormatException nfe) {
                    edad = 0;
                }

                if (!name.getText().toString().isEmpty() && !surname.getText().toString().isEmpty()) {
                    if (!age.getText().toString().isEmpty()) {
                        if (edad >= 18) {
                            if (male.isChecked() || female.isChecked()) {
                                if (!contest.isChecked()) {
                                    Toast.makeText(getApplicationContext(), "¡Se ha inscrito" +
                                            " en el concurso!", Toast.LENGTH_SHORT).show();
                                } else if (contestName.getText().toString().isEmpty()) {
                                    Toast.makeText(getApplicationContext(), "Rellene el " +
                                            "nombre del concurso", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "¡Se ha inscrito " +
                                            "en el concurso!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Seleccione un sexo",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Debe ser mayor de edad " +
                                    "para inscribirse", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Debe rellenar el campo edad",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}


