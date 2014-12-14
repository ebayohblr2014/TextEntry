package lnarasimhan.com.textentry;

import android.preference.EditTextPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    EditText contact_name, contact_phone, contact_email;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_name=(EditText)findViewById(R.id.contact_name);
        contact_email=(EditText)findViewById(R.id.contact_email);
        contact_phone=(EditText)findViewById(R.id.contact_phone);
        submit_button=(Button)findViewById(R.id.submit_button);
        submit_button.setEnabled(false);
        //output=(EditText)findViewById(R.id.output);
        //submit=(EditText)findViewById(R.id.su)
        //input.addTextChangedListener(myWatcher);
        contact_name.addTextChangedListener(myWatcher);
    }
    TextWatcher myWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //input.clearComposingText();
            //input.setText("");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            submit_button.setEnabled(!contact_name.getText().toString().trim().isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
           // output.setText(input.getText());
            StringBuffer possible_email= new StringBuffer(contact_name.getText());
            possible_email.append("@gmail.com");
            contact_email.setText(possible_email);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
