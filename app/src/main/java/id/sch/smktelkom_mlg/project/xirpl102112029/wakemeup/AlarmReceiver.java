package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Aqshal Fajar Putra on 2016/11/11.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent arg1) {
        Log.e("We are in the receiver", "Yay!");

        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        context.startService(service_intent);
    }


}