package sg.edu.rp.c346.id20029699.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button demoBtn1, demoBtn2, demoBtn3, exerciseBtn, demoBtn4, demoBtn5;
    TextView demo2, demo3, TVexercise, demo4, demo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoBtn1 = findViewById(R.id.button1);
        demoBtn2 = findViewById(R.id.button2);
        demoBtn3 = findViewById(R.id.button3);
        exerciseBtn = findViewById(R.id.buttonExercise);
        demoBtn4 = findViewById(R.id.button4);
        demoBtn5 = findViewById(R.id.button5);
        demo2 = findViewById(R.id.textViewDemo2);
        demo3 = findViewById(R.id.textViewDemo3);
        TVexercise = findViewById(R.id.textViewExercise);
        demo4 = findViewById(R.id.textView4);
        demo5 = findViewById(R.id.textView5);

        demoBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);

                /*
                b.setTitle("Demo 1 - Simple Dialog");
                b.setMessage("I can develop Android App");
                b.setCancelable(false);
                b.setPositiveButton("Close", null);
                */

                b.setTitle("Congratulations");
                b.setMessage("You have completed a simple Dialog Box");
                b.setCancelable(true);
                b.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = b.create();
                myDialog.show();
            }
        });

        demoBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder btnDialog = new AlertDialog.Builder(MainActivity.this);

                btnDialog.setTitle("Demo 2 - Button Dialog");
                btnDialog.setMessage("Select one of the Buttons B");
                btnDialog.setCancelable(false);
                btnDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        demo2.setText("You have selected Yes");
                    }
                });
                btnDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        demo2.setText("You have selected No");
                    }
                });

                btnDialog.setNeutralButton("Cancel", null);

                AlertDialog myDialog = btnDialog.create();
                myDialog.show();
            }
        });

        demoBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input1, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editText);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        demo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        exerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextNumber);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNumber2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        int num1 = Integer.parseInt(etInput.getText().toString());
                        int num2 = Integer.parseInt(etInput2.getText().toString());
                        int sum = num1 + num2;
                        // Set the text to the TextView
                        TVexercise.setText("The sum is "+ sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        demoBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        demo4.setText("Date: " + day + "/" + (month+1) + "/" + year);
                    }
                };

                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(MainActivity.this,
                        date, year, month, day);
                dateDialog.show();
            }
        });

        demoBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hr, int min) {
                        demo5.setText("Time " + hr + min);
                    }
                };
                /*
                TimePickerDialog timeDialog = new TimePickerDialog(MainActivity.this,
                time, 20, 00, true);

                TimePickerDialog timeDialog = new TimePickerDialog(MainActivity.this,
                        time, 20, 00, false);
                timeDialog.show();
                */
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog timeDialog = new TimePickerDialog(MainActivity.this,
                        time, hourOfDay, minute, true);
                timeDialog.show();
            }
        });
    }
}