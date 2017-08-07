package com.example.lty.tianyu_li_215211123;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class QuickLinkActivity extends AppCompatActivity {

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
        AlertDialog.Builder builder = new AlertDialog.Builder(QuickLinkActivity.this);
        builder.setTitle("Move to..")
                .setCancelable(false)
                .setItems(R.array.Moveto_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] Moveto_array = getResources().getStringArray(R.array.Moveto_array);
                        switch (which) {
                            case 0:
                                Intent intent1 = new Intent(QuickLinkActivity.this, MainActivity.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2 = new Intent(QuickLinkActivity.this, AboutDeakinActivity.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3 = new Intent(QuickLinkActivity.this, MessageActivity.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4 = new Intent(QuickLinkActivity.this, QuickLinkActivity.class);
                                startActivity(intent4);
                                break;
                        }
                    }
                }).setNegativeButton("Cancel", null).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_link);

        DeakinSyncButtonClickListener();
        CloudDeakinButtonClickListener();
        DeakinMailButtonClickListener();
        DeakinStudentConnectButtonClickListener();


    }


    //DeakinSyncButton onclicklistener
    public void DeakinSyncButtonClickListener() {
        Button DeakinSyncButton = (Button) findViewById(R.id.DeakinSyncButton);
        DeakinSyncButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(QuickLinkActivity.this);
                        a_builder.setMessage("Do you want to open DeakinSync Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to DeakinSync Website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sync.deakin.edu.au/"));
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //cancel
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Message");
                        alert.show();
                    }
                }
        );
    }

    //CloudDeakinButton onclicklistener
    public void CloudDeakinButtonClickListener() {
        Button CloudDeakinButton = (Button) findViewById(R.id.CloudDeakinButton);
        CloudDeakinButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(QuickLinkActivity.this);
                        a_builder.setMessage("Do you want to open CloudDeakin Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to CloudDeakin Website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.deakin.edu.au/clouddeakin"));
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //cancel
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Message");
                        alert.show();
                    }
                }
        );
    }

    //DeakinMailButton onclicklistener
    public void DeakinMailButtonClickListener() {
        Button DeakinMailButton = (Button) findViewById(R.id.DeakinMailButton);
        DeakinMailButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(QuickLinkActivity.this);
                        a_builder.setMessage("Do you want to open DeakinMail Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to DeakinMail Website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sync.deakin.edu.au/redirects/link/type/mail"));
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //cancel
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Message");
                        alert.show();
                    }
                }
        );
    }

    //DeakinStudentConnectButton onclicklistener
    public void DeakinStudentConnectButtonClickListener() {
        Button DeakinStudentConnectButton = (Button) findViewById(R.id.DeakinStudentConnectButton);
        DeakinStudentConnectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(QuickLinkActivity.this);
                        a_builder.setMessage("Do you want to open Deakin Student Connect Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to Deakin Student Connect Website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studentconnect.deakin.edu.au/connect/webconnect"));
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //cancel
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Message");
                        alert.show();
                    }
                }
        );
    }
}
