package fpttest.smart.ktec.com.contentprovidersample;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;

import android.content.ContentValues;
import android.content.CursorLoader;

import android.database.Cursor;

import android.util.Log;
import android.view.Menu;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
//        String URL = "content://fpttest.smart.ktec.com.contentprovidersample.StudentsProvider";
//
//        Uri students = Uri.parse(URL);
//        Cursor c = managedQuery(students, null, null, null, "name");
//
//        if (c.moveToFirst()) {
//            do{
//                Toast.makeText(this,
//                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
//                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
//                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
//                        Toast.LENGTH_SHORT).show();
//            } while (c.moveToNext());
//        }

        String URL = "content://fpttest.smart.ktec.com.contentprovidersample.StudentsProvider";

        Uri allTitles = Uri.parse(URL);
//
//        Uri allTitles = Uri.parse(
//                "content://" + BooksProvider.PROVIDER_NAME + "/books");
        Cursor c = getContentResolver().query(
                allTitles,
                null,
                null,
                null,
                StudentsProvider.NAME + " desc");
        if (c.moveToFirst()) {
            do {
                Log.d("TAGGG",
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) + ", " +
                                c.getString(c.getColumnIndex(StudentsProvider.NAME)) + ", " +
                                c.getString(c.getColumnIndex(StudentsProvider.GRADE)));
            } while (c.moveToNext());
        }
    }
}