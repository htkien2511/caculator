package kien.caculatorbonus;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_PTB1 extends AppCompatActivity implements View.OnClickListener {
    EditText edt_ab1;
    EditText edt_bb1;

    Button btn_giaib1;
    Button btn_back2;
    Button btn_clear1;
    ListView lvResult;
    private ArrayList<String> arrayPt;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaiphuongtrinhbac1);

        edt_ab1 = findViewById(R.id.edt_ab1);
        edt_bb1 = findViewById(R.id.edt_bb1);

        btn_giaib1 = findViewById(R.id.btn_giaib1);
        btn_back2 = findViewById(R.id.btn_back2);
        btn_clear1 = findViewById(R.id.btn_clear1);
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvResult = findViewById(R.id.lv_resultb1);

        arrayPt = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayPt);
        lvResult.setAdapter(adapter);

        btn_giaib1.setOnClickListener(this);
        btn_clear1.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_giaib1:
                String a = edt_ab1.getText().toString().trim();
                String b = edt_bb1.getText().toString().trim();

                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b) ) {
                    Toast.makeText(Activity_PTB1.this, "Please Input A or B ", Toast.LENGTH_SHORT).show();
                }
                else if(!(IsNumber(a) && IsNumber(b) )){
                    Toast.makeText(Activity_PTB1.this, "Please Input Number",Toast.LENGTH_SHORT).show();
                }
                else {
                    double aVal = Double.parseDouble(a);
                    double bVal = Double.parseDouble(b);

                    if (aVal == 0) {
                        Toast.makeText(Activity_PTB1.this,"a phải khác 0",Toast.LENGTH_SHORT).show();
                    }else if(bVal == 0){
                        String stringResult ="Phương trình có vô số nghiệm";
                        arrayPt.add(0,stringResult);
                        adapter.notifyDataSetChanged();
                    }else {
                        String stringResult =aVal+"x+"+bVal+"=0 có nghiệm là:"+(-bVal/aVal);
                        arrayPt.add(0,stringResult);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.btn_clear1:
                edt_ab1.setText("");
                edt_bb1.setText("");
                break;
        }

    }
    public boolean IsNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        }catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
