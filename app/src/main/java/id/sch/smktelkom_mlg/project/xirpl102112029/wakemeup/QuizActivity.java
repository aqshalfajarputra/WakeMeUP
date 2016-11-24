package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class QuizActivity extends AppCompatActivity {
    final static int RQS_1 = 1;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    TextView soal1;
    Button jaw1a, jaw1b, jaw1c, jaw1d;
    int open;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        soal1 = (TextView) findViewById(R.id.soal1);
        jaw1a = (Button) findViewById(R.id.jaw1a);
        jaw1b = (Button) findViewById(R.id.jaw1b);
        jaw1c = (Button) findViewById(R.id.jaw1c);
        jaw1d = (Button) findViewById(R.id.jaw1d);

        jaw1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah2();
            }
        });
        jaw1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), AlarmReciever.class);
                intent.putExtra("extra", "off");
                pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
                alarmManager.cancel(pendingIntent);
                sendBroadcast(intent);
            }
        });
        jaw1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah3();
            }
        });
        jaw1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah();
            }
        });
    }

    private void pindah() {
        Intent intent = new Intent(getBaseContext(), QuizActivity2.class);
        startActivity(intent);
        finish();
    }

    private void pindah2() {
        Intent intent = new Intent(getBaseContext(), QuizActivity2.class);
        startActivity(intent);
        finish();

    }

    private void pindah3() {
        Intent intent = new Intent(getBaseContext(), QuizActivity3.class);
        startActivity(intent);
        finish();

    }


}
