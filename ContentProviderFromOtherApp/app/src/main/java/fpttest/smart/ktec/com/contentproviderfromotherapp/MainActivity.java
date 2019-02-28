package fpttest.smart.ktec.com.contentproviderfromotherapp;

import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String _ID = "_id";
    static final String NAME = "name";
    static final String GRADE = "grade";
    CursorLoader cursorLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnGet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "content://fpttest.smart.ktec.com.contentprovidersample.StudentsProvider/students";

                Uri uri = Uri.parse(URL);

                Cursor c = getContentResolver().query(
                        uri,
                        null,
                        null,
                        null,
                        MainActivity.NAME + " desc");
                if (c.moveToFirst()) {
                    do {
                        Log.d("TAGGG",
                                c.getString(c.getColumnIndex(MainActivity._ID)) + ", " +
                                        c.getString(c.getColumnIndex(MainActivity.NAME)) + ", " +
                                        c.getString(c.getColumnIndex(MainActivity.GRADE)));
                    } while (c.moveToNext());
                }
            }
        });
    }
}
