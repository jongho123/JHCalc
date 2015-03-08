package sloth.jhcalc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button division1;
    private Button division2;

    private EditText var1;
    private EditText var2;
    private TextView ans;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Exception, var1 or var2 has not been entered
            if(var1.getText().toString().compareTo("") == 0 || var2.getText().toString().compareTo("") == 0)
            {
                ans.setText("Please enter the integer of var1 and var2");
                return ;
            }

            // convert the text to an integer
            int num1 = Integer.parseInt(var1.getText().toString());
            int num2 = Integer.parseInt(var2.getText().toString());

            Calculator calc = new Calculator(num1, num2);

            switch (v.getId()) {
                case R.id.plus:
                    ans.setText(""+calc.plus());
                    break;

                case R.id.minus:
                    ans.setText(""+calc.minus());
                    break;

                case R.id.multiply:
                    ans.setText(""+calc.multiply());
                    break;

                case R.id.division1:
                    // Exception, not divided into 0
                    if(num2==0) {
                        ans.setText("not divided into 0");
                        return;
                    }

                    ans.setText(""+calc.division1());
                    break;

                case R.id.division2:
                    // Exception, not divided into 0
                    if(num2==0) {
                        ans.setText("not divided into 0");
                        return;
                    }

                    ans.setText(""+calc.division2());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus = (Button) findViewById (R.id.plus);
        minus = (Button) findViewById (R.id.minus);
        multiply = (Button) findViewById (R.id.multiply);
        division1 = (Button) findViewById(R.id.division1);
        division2 = (Button) findViewById(R.id.division2);

        var1 = (EditText) findViewById(R.id.editvar1);
        var2 = (EditText) findViewById(R.id.editvar2);
        ans = (TextView) findViewById(R.id.editans);

        // add click listener
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        division1.setOnClickListener(listener);
        division2.setOnClickListener(listener);
    }

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
