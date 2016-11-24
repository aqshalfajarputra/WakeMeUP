package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Aqshal Fajar Putra on 2016/11/11.
 */

public class FirstFragment extends Fragment {

    final static int RQS_1 = 1;
    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    Button buttonOffAlarm;
    AlarmManager alarmManager;
    TextView info;
    Context context;
    PendingIntent pendingIntent;
    View myView;

    public FirstFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.first_layout, container, false);
        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        info = (TextView) myView.findViewById(R.id.info);
        pickerDate = (DatePicker) myView.findViewById(R.id.pickerdate);
        pickerTime = (TimePicker) myView.findViewById(R.id.pickertime);

        Calendar now = Calendar.getInstance();

        pickerDate.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

        buttonSetAlarm = (Button) myView.findViewById(R.id.setalarm);
        buttonOffAlarm = (Button) myView.findViewById(R.id.buttonOff);
        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar current = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                cal.set(pickerDate.getYear(),
                        pickerDate.getMonth(),
                        pickerDate.getDayOfMonth(),
                        pickerTime.getCurrentHour(),
                        pickerTime.getCurrentMinute(),
                        00);

                if (cal.compareTo(current) <= 0) {
                    //The set Date/Time already passed
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Invalid Date/Time",
                            Toast.LENGTH_LONG).show();
                } else {

                    setAlarm(cal);
                }

            }
        });


        buttonOffAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();

            }
        });
        return myView;
    }


    private void cancelAlarm() {
        Intent intent = new Intent(getActivity().getBaseContext(), AlarmReciever.class);
        intent.putExtra("extra", "off");
        pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), RQS_1, intent, 0);
        alarmManager.cancel(pendingIntent);
        getActivity().sendBroadcast(intent);
    }


    private void setAlarm(Calendar targetCal) {

        info.setText("\n\n***\n"
                + "Alarm is set@ " + targetCal.getTime() + "\n"
                + "***\n");

        Intent intent = new Intent(getActivity().getBaseContext(), AlarmReciever.class);
        intent.putExtra("extra", "on");
        pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), RQS_1, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }
}
