package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

/**
 * Created by Akito on 17/11/2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We are in the receiver", "Yay!");

        String my_string = intent.getExtras().getString("extra");

        Log.e("We are in the receiver", my_string);


        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        service_intent.putExtra("extra", my_string);
        context.startService(service_intent);


    }


}