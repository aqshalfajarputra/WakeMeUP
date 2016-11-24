package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity2 extends AppCompatActivity {
    final static int RQS_1 = 1;
    TextView soal2;
    Button jaw2a, jaw2b, jaw2c, jaw2d;
    int open;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        soal2 = (TextView) findViewById(R.id.soal2);
        jaw2a = (Button) findViewById(R.id.jaw2a);
        jaw2b = (Button) findViewById(R.id.jaw2b);
        jaw2c = (Button) findViewById(R.id.jaw2c);
        jaw2d = (Button) findViewById(R.id.jaw2d);
        jaw2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah();
            }
        });
        jaw2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), AlarmReciever.class);
                intent.putExtra("extra", "off");
                pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
                alarmManager.cancel(pendingIntent);
                sendBroadcast(intent);
            }
        });
        jaw2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah2();
            }
        });
        jaw2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah3();
            }
        });
    }

    private void pindah() {
        Intent intent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(intent);
    }

    private void pindah2() {
        Intent intent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(intent);
    }

    private void pindah3() {
        Intent intent = new Intent(getBaseContext(), QuizActivity3.class);
        startActivity(intent);
    }

}

