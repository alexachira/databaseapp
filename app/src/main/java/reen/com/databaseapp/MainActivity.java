package reen.com.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.inputname)
    EditText inputname;

    @BindView(R.id.inputnumber)
    EditText inputnumber;

    @BindView(R.id.inputbalance)
    EditText inputbalance;

@BindView(R.id.textviewcounts)
    TextView txtcount;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void save(View view) {
        String name=inputname.getText().toString().trim();
        String number=inputnumber.getText().toString().trim();
        String bal=inputbalance.getText().toString().trim();

        if (name.isEmpty()||number.isEmpty()|| bal.isEmpty())
        {
            return;
        }
        double balance=Double.parseDouble(bal);//convert string to double
        Account X=new Account();
        X.setName(name);
        X.setAccnumber(number);
        X.setBalance(balance);

        //save to db
        Ourdatabase.getInstance(this).accountdao().insertaccount(X);
        int count =Ourdatabase.getInstance(this).accountdao().getallaccounts().size();

        txtcount.setText("successfully saved");

        //clear
        inputname.setText("");
        inputbalance.setText("");
        inputnumber.setText("");
    }


    public void account(View view) {
        Intent X =new Intent(this,Displayactivity.class);
        startActivity(X);
    }
}
