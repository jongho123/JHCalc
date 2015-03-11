package sloth.jhcalc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private ImageView plus;
    private ImageView minus;
    private ImageView multiply;
    private ImageView division;

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

                case R.id.division:
                    // Exception, not divided into 0
                    if(num2==0) {
                        ans.setText("not divided into 0");
                        return;
                    }

                    ans.setText(""+calc.division());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus = (ImageView) findViewById (R.id.plus);
        minus = (ImageView) findViewById (R.id.minus);
        multiply = (ImageView) findViewById (R.id.multiply);
        division = (ImageView) findViewById(R.id.division);

        var1 = (EditText) findViewById(R.id.editvar1);
        var2 = (EditText) findViewById(R.id.editvar2);
        ans = (TextView) findViewById(R.id.editans);

        // add click listener
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        division.setOnClickListener(listener);
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
