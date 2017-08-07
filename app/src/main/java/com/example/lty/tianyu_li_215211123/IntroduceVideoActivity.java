package com.example.lty.tianyu_li_215211123;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class IntroduceVideoActivity extends AppCompatActivity {

    VideoView myVideoView;
    String localFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_video);

        localFilePath = "android.resource://" + getPackageName() + "/" + R.raw.introducevideo;
    }


    public void playVideo(View view) {
        myVideoView = (VideoView) findViewById(R.id.videoView);
        myVideoView.setVideoURI(Uri.parse(localFilePath));
        myVideoView.setMediaController(new MediaController(this));
        myVideoView.start();

        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplication(), "End", Toast.LENGTH_LONG).show();
            }
        });
    }


    //Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.moveto) {
            MovetoDialog();
            return true;
        }
        if (id == R.id.back) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Move to dialog
    private void MovetoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(IntroduceVideoActivity.this);
        builder.setTitle("Move to..")
                .setCancelable(false)
                .setItems(R.array.Moveto_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] Moveto_array = getResources().getStringArray(R.array.Moveto_array);
                        switch (which) {
                            case 0:
                                Intent intent1 = new Intent(IntroduceVideoActivity.this, MainActivity.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2 = new Intent(IntroduceVideoActivity.this, AboutDeakinActivity.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3 = new Intent(IntroduceVideoActivity.this, MessageActivity.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4 = new Intent(IntroduceVideoActivity.this, QuickLinkActivity.class);
                                startActivity(intent4);
                                break;
                        }
                    }
                }).setNegativeButton("Cancel", null).show();
    }

}