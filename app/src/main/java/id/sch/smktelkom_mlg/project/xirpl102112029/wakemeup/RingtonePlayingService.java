package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Aqshal Fajar Putra on 2016/11/17.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("LocalService", "Received start id" + startId + ": " + intent);

        String state = intent.getExtras().getString("extra");

        Log.e("oyi", state);

        assert state != null;
        switch (state) {
            case "on":
                startId = 1;
                break;
            case "off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }

        if (startId == 1) {
            NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setCategory(Notification.CATEGORY_ALARM)
                    .setSmallIcon(R.drawable.ic_menu_send) // notification icon
                    .setContentTitle("WakeMeUp") // title for notification
                    .setContentText("It's Time To Wake up Friend :D") // message for notification
                    .setAutoCancel(true); // clear notification after click

            intent = new Intent(this, MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
            mBuilder.setContentIntent(pi);
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());


            media_song = MediaPlayer.create(this, R.raw.door);
            media_song.setLooping(true);
            media_song.start();

        } else if (startId == 0) {
            media_song.stop();
        }




        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "on Destroy called", Toast.LENGTH_SHORT);
        media_song.stop();
    }


}