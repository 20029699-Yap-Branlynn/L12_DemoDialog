package sg.edu.rp.c346.id20029699.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button demoBtn1, demoBtn2;
    TextView demo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoBtn1 = findViewById(R.id.button1);
        demoBtn2 = findViewById(R.id.button2);
        demo2 = findViewById(R.id.textViewDemo2);

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
    }
}