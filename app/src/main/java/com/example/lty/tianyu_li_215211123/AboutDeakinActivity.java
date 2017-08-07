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

public class AboutDeakinActivity extends AppCompatActivity {

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
        AlertDialog.Builder builder = new AlertDialog.Builder(AboutDeakinActivity.this);
        builder.setTitle("Move to..")
                .setCancelable(false)
                .setItems(R.array.Moveto_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] Moveto_array = getResources().getStringArray(R.array.Moveto_array);
                        switch (which) {
                            case 0:
                                Intent intent1 = new Intent(AboutDeakinActivity.this, MainActivity.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2 = new Intent(AboutDeakinActivity.this, AboutDeakinActivity.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3 = new Intent(AboutDeakinActivity.this, MessageActivity.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4 = new Intent(AboutDeakinActivity.this, QuickLinkActivity.class);
                                startActivity(intent4);
                                break;
                        }
                    }
                }).setNegativeButton("Cancel", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_deakin);
        DeakinWebButtonClickListener();
        AboutDeakinButtonClickListener();
        ContactButtonOnClick();
        FindCourseBbuttonClickListener();
    }


    //Deakin Web Button onclicklistener
    public void DeakinWebButtonClickListener() {
        Button DeakinWebButton = (Button) findViewById(R.id.DeakinWeb_button);
        DeakinWebButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(AboutDeakinActivity.this);
                        a_builder.setMessage("Do you want to open Deakin Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to Deakin Website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.deakin.edu.au"));
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


    //About Deakin Button onclicklistener
    public void AboutDeakinButtonClickListener() {
        Button AboutDeakinButton = (Button) findViewById(R.id.AboutDeakin_button);
        AboutDeakinButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(AboutDeakinActivity.this);
                        a_builder.setMessage("Do you want to open About Deakin Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to About Deakin website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.deakin.edu.au/about-deakin"));
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

    //Contact Button OnClick
    private void ContactButtonOnClick() {
        Button ContactButton = (Button) findViewById(R.id.Contact_button);
        ContactButton.setOnClickListener(new View.OnClickListener() {
            //Contact dialog
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AboutDeakinActivity.this);
                builder.setTitle("Contact")
                        .setCancelable(false)
                        .setItems(R.array.contact_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String[] contact_array = getResources().getStringArray(R.array.contact_array);
                                switch (which) {
                                    case 0:
                                        Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:myfuture@deakin.edu.au"));
                                        startActivity(intent1);
                                        break;
                                    case 1:
                                        Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 693 888"));
                                        startActivity(intent2);
                                        break;
                                    case 2:
                                        Intent intent3 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:study@deakin.edu.au"));
                                        startActivity(intent3);
                                        break;
                                    case 3:
                                        Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+61 3 9627 4877"));
                                        startActivity(intent4);
                                        break;
                                }
                            }
                        }).setNegativeButton("Cancel", null).show();
            }
        });
    }

    //Find Course Bbutton onclicklistener
    public void FindCourseBbuttonClickListener() {
        Button FindCourseBbutton = (Button) findViewById(R.id.Find_course_button);
        FindCourseBbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(AboutDeakinActivity.this);
                        a_builder.setMessage("Do you want to open Deakin Course Website?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent to Deakin Course website
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.deakin.edu.au/courses"));
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
