package com.example.rta.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        EditText et = (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        String item = intent.getStringExtra("item clicked is");
        et.setText(item);
        et.setSelection(et.getText().length());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onSaveItem(View view) {
        Intent intent = getIntent();
        int item_position = intent.getExtras().getInt("clicked row");
        EditText et = (EditText) findViewById(R.id.editText2);
        Intent editIntent = new Intent();
        editIntent.putExtra("Edited Item", et.getText().toString());
        editIntent.putExtra("position", item_position);
        setResult(RESULT_OK, editIntent);
        finish();
    }

}
