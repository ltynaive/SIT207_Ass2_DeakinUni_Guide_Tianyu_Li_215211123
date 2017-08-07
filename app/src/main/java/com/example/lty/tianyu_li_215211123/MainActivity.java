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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationsButtonOnClick();
        CampusMapsButtonOnClick();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Move to..")
                .setCancelable(false)
                .setItems(R.array.Moveto_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] Moveto_array = getResources().getStringArray(R.array.Moveto_array);
                        switch (which) {
                            case 0:
                                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2 = new Intent(MainActivity.this, AboutDeakinActivity.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3 = new Intent(MainActivity.this, MessageActivity.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4 = new Intent(MainActivity.this, QuickLinkActivity.class);
                                startActivity(intent4);
                                break;
                        }
                    }
                }).setNegativeButton("Cancel", null).show();
    }


    public void GotoAboutDeakinActivity(View view) {
        //intent to AboutDeakin
        Intent intent = new Intent(this, AboutDeakinActivity.class);
        startActivity(intent);
    }

    public void GotoMessageActivity(View view) {
        //intent to Message
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }

    public void GotoQuickLinkActivity(View view) {
        //intent to Message
        Intent intent = new Intent(this, QuickLinkActivity.class);
        startActivity(intent);
    }

    public void GotoIntroduceVideoActivity(View view) {
        //intent to Message
        Intent intent = new Intent(this, IntroduceVideoActivity.class);
        startActivity(intent);
    }


    //Locations Button
    private void LocationsButtonOnClick() {
        Button LocationsButton = (Button) findViewById(R.id.Locations_button);
        LocationsButton.setOnClickListener(new View.OnClickListener() {
            //Locations dialog
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Locations")
                        .setCancelable(false)
                        .setItems(R.array.Locations_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String[] locations_array = getResources().getStringArray(R.array.Locations_array);
                                switch (which) {
                                    case 0:
                                        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-37.846531, 145.114995"));
                                        startActivity(intent1);
                                        break;
                                    case 1:
                                        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-38.198373,144.298927"));
                                        startActivity(intent2);
                                        break;
                                    case 2:
                                        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-38.143744,144.36024"));
                                        startActivity(intent3);
                                        break;
                                    case 3:
                                        Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-38.387654,142.539972"));
                                        startActivity(intent4);
                                        break;
                                    case 4:
                                        Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.deakin.edu.au/courses/study-online"));
                                        startActivity(intent5);
                                        break;
                                }
                            }
                        }).setNegativeButton("Cancel", null).show();
            }
        });
    }

    //CampusMaps Button
    private void CampusMapsButtonOnClick() {
        Button CampusMapsButton = (Button) findViewById(R.id.Campus_Maps_button);
        CampusMapsButton.setOnClickListener(new View.OnClickListener() {
            //Locations dialog
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Campus Maps")
                        .setCancelable(false)
                        .setItems(R.array.CampusMaps_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String[] CampusMaps_array = getResources().getStringArray(R.array.CampusMaps_array);
                                switch (which) {
                                    case 0:
                                        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/gview?embedded=true&url=http://www.deakin.edu.au/__data/assets/pdf_file/0005/556196/Burwood-June2016.pdf"));
                                        startActivity(intent1);
                                        break;
                                    case 1:
                                        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/gview?embedded=true&url=http://www.deakin.edu.au/__data/assets/pdf_file/0007/557728/WaurnPonds-June2016.pdf"));
                                        startActivity(intent2);
                                        break;
                                    case 2:
                                        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/gview?embedded=true&url=http://www.deakin.edu.au/__data/assets/pdf_file/0020/556202/Waterfront-June2016.pdf"));
                                        startActivity(intent3);
                                        break;
                                    case 3:
                                        Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/gview?embedded=true&url=http://www.deakin.edu.au/__data/assets/pdf_file/0005/556205/Warrnambool-June2016.pdf"));
                                        startActivity(intent5);
                                        break;
                                }
                            }
                        }).setNegativeButton("Cancel", null).show();
            }
        });
    }

}
