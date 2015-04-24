package dcshackathon2015.guardian;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Home extends ActionBarActivity {

    private EditText fullname;
    private EditText platenumber;
    private EditText temp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fullname = (EditText) findViewById(R.id.username);
        platenumber = (EditText) findViewById(R.id.platenumber);
        temp1 = (EditText) findViewById(R.id.temp1);

        Button activate = (Button) findViewById(R.id.start);
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean valid = false;
                List<String> dataFields = new ArrayList<String>();
                dataFields.add(fullname.getText().toString());
                dataFields.add(platenumber.getText().toString());
                dataFields.add(temp1.getText().toString());
                for(int i=0;i<dataFields.size();i++){
                    valid = sanitizeText(dataFields.get(i));
                }
                if(valid){
                    startActivity(new Intent(getApplicationContext(), Tracking.class));
                    finish();
                }
            }
        });
    }

    public boolean sanitizeText(String t){
        Boolean valid = true;
        valid = t.matches("[a-zA-Z ]");
        if(t.length() > 50){
            valid = false;
        }
        return valid;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
}
