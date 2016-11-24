package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QuizActivity3 extends AppCompatActivity {
    final static int RQS_1 = 1;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Intent intent = getIntent();
    Button jaw3a, jaw3b, jaw3c, jaw3d;
    int open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        jaw3a = (Button) findViewById(R.id.jaw3a);
        jaw3b = (Button) findViewById(R.id.jaw3b);
        jaw3c = (Button) findViewById(R.id.jaw3c);
        jaw3d = (Button) findViewById(R.id.jaw3d);
        jaw3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah();
            }
        });
        jaw3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), AlarmReciever.class);
                intent.putExtra("extra", "off");
                pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
                alarmManager.cancel(pendingIntent);
                sendBroadcast(intent);
            }
        });
        jaw3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah2();
            }
        });
        jaw3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah3();
            }
        });

    }


    private void pindah() {
        Intent intent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(intent);
        finish();
    }

    private void pindah2() {
        Intent intent = new Intent(getBaseContext(), QuizActivity2.class);
        startActivity(intent);
        finish();
    }

    private void pindah3() {
        Intent intent = new Intent(getBaseContext(), QuizActivity2.class);
        startActivity(intent);
        finish();
    }

}
