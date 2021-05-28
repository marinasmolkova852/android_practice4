package ru.mirea.smolkova.mireaproject.ui.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.mirea.smolkova.mireaproject.R;

public class MusicFragment extends Fragment {

    MediaPlayer mPlayer;
    Button btnStart, btnStop;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_music, container, false);

        btnStart = root.findViewById(R.id.button5);
        btnStop = root.findViewById(R.id.button7);

        mPlayer= MediaPlayer.create(getActivity(), R.raw.boy);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });

        return  root;
    }

    private void stopPlay(){
        mPlayer.stop();
        btnStop.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            btnStart.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void play(){
        mPlayer.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }
    public void stop(){
//        mPlayer.stop();
//        btnStop.setEnabled(false);
//        btnStart.setEnabled(true);
        stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }

}
