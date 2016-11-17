package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
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

        media_song = MediaPlayer.create(this, R.raw.uye);
        media_song.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "on Destroy called", Toast.LENGTH_SHORT);
        media_song.stop();
    }


}