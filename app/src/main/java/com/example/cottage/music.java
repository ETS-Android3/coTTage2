package com.example.cottage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class music extends AppCompatActivity {
    TextView playerPosition, playerDuration;
    SeekBar seekbar;
    ImageView btRew, btPlay, btPause, btFf;
    MediaPlayer mediaPlayer;
    Handler handler= new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        playerPosition=findViewById(R.id.playerposition);
        playerDuration=findViewById(R.id.playerduration);
        seekbar=findViewById(R.id.seekbar);
        btRew=findViewById(R.id.bt_rewind);
        btPlay=findViewById(R.id.bt_play);
        btPause=findViewById(R.id.bt_pause);
        btFf=findViewById(R.id.bt_ff);
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        runnable=new Runnable() {
            @Override
            public void run() {
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 50000);
            }
        };

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btPause.setVisibility(view.GONE);
                btPlay.setVisibility(view.VISIBLE);
                mediaPlayer.pause();
                handler.removeCallbacks(runnable);
            }
        });
        btFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition=mediaPlayer.getCurrentPosition();
                int duration= mediaPlayer.getDuration();
                if (mediaPlayer.isPlaying() && duration!=currentPosition){
                    currentPosition=currentPosition+5000;
                    playerPosition.setText(convertFormat(currentPosition));
        mediaPlayer.seekTo(currentPosition);
                }
            }
        });
     int currentPosition=mediaPlayer.getCurrentPosition();
     if (mediaPlayer.isPlaying() && currentPosition>5000){
         currentPosition=currentPosition-5000;
         playerPosition.setText(convertFormat(currentPosition));
         mediaPlayer.seekTo(currentPosition);

     }
     seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
         @Override
         public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
             if(fromUser){
                 mediaPlayer.seekTo(progress);}
             playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
             }
         }

         @Override
         public void onStartTrackingTouch(SeekBar seekBar) {

         }

         @Override
         public void onStopTrackingTouch(SeekBar seekBar) {

         }
         mediaPlayer.setOnCompletionListener(new mediaPlayer .setOnCompletionListener(); );
     });


}


    }
}