package id.sch.smktelkom_mlg.project.xirpl102112029.wakemeup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Aqshal Fajar Putra on 2016/11/11.
 */

public class SecondFragment extends Fragment {

    View myView;
    Button btOk;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        btOk = (Button) myView.findViewById(R.id.buttonok);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Thankyou! for sharing this link. Support us on github : https://github.com/aqshalfajarputra/WakeMeUP";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

        return myView;

    }
}