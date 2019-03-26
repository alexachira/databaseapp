package reen.com.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Displayactivity extends AppCompatActivity {

    @BindView(R.id.list_accounts)
    ListView listView;

    List<Account> data;

    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayactivity);
         ButterKnife.bind(this);

        data=Ourdatabase.getInstance(this).accountdao().getallaccounts();
        adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return data.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View V = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, parent, false);

                TextView tvname = V.findViewById(R.id.textViewname);
                TextView tvaccount = V.findViewById(R.id.textViewaccount);
                TextView tvbalance = V.findViewById(R.id.textViewbalance);

                ImageView imgdelete = V.findViewById(R.id.imageviewdelete);
                ImageView imgedit = V.findViewById(R.id.imageviewedit);

                final Account x = data.get(position);
                tvname.setText(x.getName());
                tvaccount.setText(x.getAccnumber());
                tvbalance.setText("ksh" + x.getBalance());

                imgdelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Ourdatabase.getInstance(getBaseContext()).accountdao().delete(x);
                        data.remove(x);
                        notifyDataSetChanged();
                    }
                });

                imgedit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO ADD UPDATE CODE
                    }
                });

                return V;
            }
        };
        listView.setAdapter(adapter);
    }
}
