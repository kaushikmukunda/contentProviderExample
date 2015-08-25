package qlearn.qualcomm.com.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    ListView dTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dTv = (ListView) findViewById(R.id.dictionary_tv);
        printCustomDictionary();
    }

    private void printCustomDictionary() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);

        String[] cols = {UserDictionary.Words.WORD,  UserDictionary.Words.FREQUENCY};
        int[] viewIds = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            android.R.layout.two_line_list_item,
            cursor,
            cols,
            viewIds,
            0);

        dTv.setAdapter(adapter);
    }

}
