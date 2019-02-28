package fpttest.smart.ktec.com.contentproviderfromotherapp;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
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
                LoaderManager.getInstance(Main2Activity.this).initLoader(1, null, Main2Activity.this);
            }
        });
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        cursorLoader = new CursorLoader(this, Uri.parse("content://fpttest.smart.ktec.com.contentprovidersample.StudentsProvider/students"), null, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            Toast.makeText(getBaseContext(), "Has records", Toast.LENGTH_SHORT).show();
            if (cursor.moveToFirst()) {
                do {
                    Log.d("TAGGG",
                            cursor.getString(cursor.getColumnIndex(MainActivity._ID)) + ", " +
                                    cursor.getString(cursor.getColumnIndex(MainActivity.NAME)) + ", " +
                                    cursor.getString(cursor.getColumnIndex(MainActivity.GRADE)));
                } while (cursor.moveToNext());
            }
        } else {
            Toast.makeText(getBaseContext(), "No records", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
