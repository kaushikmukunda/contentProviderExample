package qlearn.qualcomm.com.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView dTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dTv = (TextView) findViewById(R.id.dictionary_tv);
        printCustomDictionary();
    }

    private void printCustomDictionary() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);

        int idCol = cursor.getColumnIndex(UserDictionary.Words._ID);
        int freqCol = cursor.getColumnIndex(UserDictionary.Words.FREQUENCY);
        int wordCol = cursor.getColumnIndex(UserDictionary.Words.WORD);
        StringBuffer res = new StringBuffer();

        while (cursor.moveToNext()) {
            StringBuffer sb = new StringBuffer();
            sb.append(cursor.getInt(idCol) + " " +
                      cursor.getInt(freqCol) + " " +
                      cursor.getString(wordCol) + "\n");
            res.append(sb.toString());
        }

        cursor.close();
        dTv.setText(res.toString());
    }

}
