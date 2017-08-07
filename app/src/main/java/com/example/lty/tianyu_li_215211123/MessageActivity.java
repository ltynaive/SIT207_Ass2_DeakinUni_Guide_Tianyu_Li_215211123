package com.example.lty.tianyu_li_215211123;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    EditText name;
    EditText Message;
    Button Submit;
    ListView listView;
    CustomOpenHelper myOpenHelper;
    private final static String DATABASE_NAME = "SQLiteDataBase.db";
    private final static int VERSION_NUMBER = 1;


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
        AlertDialog.Builder builder = new AlertDialog.Builder(MessageActivity.this);
        builder.setTitle("Move to..")
                .setCancelable(false)
                .setItems(R.array.Moveto_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] Moveto_array = getResources().getStringArray(R.array.Moveto_array);
                        switch (which) {
                            case 0:
                                Intent intent1 = new Intent(MessageActivity.this, MainActivity.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2 = new Intent(MessageActivity.this, AboutDeakinActivity.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3 = new Intent(MessageActivity.this, MessageActivity.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4 = new Intent(MessageActivity.this, QuickLinkActivity.class);
                                startActivity(intent4);
                                break;
                        }
                    }
                }).setNegativeButton("Cancel", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        name = (EditText) findViewById(R.id.NameEditText);
        Message = (EditText) findViewById(R.id.MessageEditText);
        Submit = (Button) findViewById(R.id.Submit);
        listView = (ListView) findViewById(R.id.Message);

        myOpenHelper = new CustomOpenHelper(this, DATABASE_NAME, null, VERSION_NUMBER);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = name.getText().toString();
                String inputMessage = Message.getText().toString();

                SQLiteDatabase db = myOpenHelper.getWritableDatabase();

                //wrap the database data
                ContentValues values = new ContentValues();
                values.put("name", inputName);
                values.put("message", inputMessage);

                db.insert(CustomOpenHelper.TABLE_NAME, null, values);

                displayDataInTable();
            }
        });
    }

    void displayDataInTable() {
        String[] values = queryTable();
        if (values != null) {
            //use the MySimpleArrayAdapter to show the elements in a ListView
            MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
            listView.setAdapter(adapter);
        }
    }

    public String[] queryTable() {
        List<String> leavemessage = new ArrayList<String>();

        SQLiteDatabase sqLiteDatabase = myOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(CustomOpenHelper.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String message = cursor.getString(cursor.getColumnIndex("message"));
            leavemessage.add(name + ": " + message);
        }
        String[] resArray = new String[leavemessage.size()];
        resArray = leavemessage.toArray(resArray);

        return resArray;
    }
}
