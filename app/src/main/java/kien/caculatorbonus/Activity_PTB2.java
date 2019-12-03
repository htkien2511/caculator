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

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Activity_PTB2 extends AppCompatActivity implements View.OnClickListener {
    EditText edt_ab2;
    EditText edt_bb2;
    EditText edt_cb2;
    Button btn_giaib2;
    Button btn_back1;
    Button btn_clear;
    ListView lvResult;
    private ArrayList<String> arrayPt;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaiphuongtrinh);


        edt_ab2 = findViewById(R.id.edt_ab2);
        edt_bb2 = findViewById(R.id.edt_bb2);
        edt_cb2 = findViewById(R.id.edt_cb2);
        btn_giaib2 = findViewById(R.id.btn_giaib2);
        btn_back1 = findViewById(R.id.btn_back1);
        btn_clear = findViewById(R.id.btn_clear);
        btn_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvResult = findViewById(R.id.lv_resultb2);

        arrayPt = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayPt);
        lvResult.setAdapter(adapter);
        btn_giaib2.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }

// oke


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_giaib2:
                String a = edt_ab2.getText().toString().trim();
                String b = edt_bb2.getText().toString().trim();
                String c = edt_cb2.getText().toString().trim();
                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
                    Toast.makeText(Activity_PTB2.this, "Please Input A or B or C", Toast.LENGTH_SHORT).show();
                }
                else if(!(IsNumber(a) && IsNumber(b) && IsNumber(c))){
                    Toast.makeText(Activity_PTB2.this, "Please Input Number",Toast.LENGTH_SHORT).show();
                }
                else {
                    double aVal = Double.parseDouble(a);
                    double bVal = Double.parseDouble(b);
                    double cVal = Double.parseDouble(c);
                    double delta = bVal*bVal - 4*aVal*cVal,x1,x2;
                    if (aVal == 0) {
                        Toast.makeText(Activity_PTB2.this,"a phải khác 0",Toast.LENGTH_SHORT).show();
                    }
                    else if(delta<0) {
                        String stringResult =aVal+"x^2"+(bVal>0?"+"+bVal:bVal)+"x"+(cVal>0?"+"+cVal:cVal)+"=0 vo nghiem";
                        arrayPt.add(0,stringResult);
                        adapter.notifyDataSetChanged();
                    }
                    else if(delta>0) {
                        DecimalFormat df = new DecimalFormat("###.#######");
                        x1 = ((-bVal+Math.sqrt(delta)))/(2*aVal);
                        x2 = ((-bVal-Math.sqrt(delta)))/(2*aVal);
                        df.format(x1);
                        df.format(x2);
                        df.format(aVal);
                        df.format(bVal);
                        df.format(cVal);
                        String stringResult = aVal+"x^2"+(bVal>0?"+"+bVal:bVal)+"x"+(cVal>0?"+"+cVal:cVal)+"=0 co 2 nghiem:\n"+ "x1=" +x1+"\nx2="+x2;
                        arrayPt.add(0,stringResult);
                        adapter.notifyDataSetChanged();
                    }
                    else {
                        String stringResult = aVal+"x^2"+(bVal>0?"+"+bVal:bVal)+"x"+(cVal>0?"+"+cVal:cVal)+"=0 co nghiem kep x= " + (double)(-bVal)/(2*aVal);
                        arrayPt.add(0,stringResult);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.btn_clear:
                edt_ab2.setText("");
                edt_bb2.setText("");
                edt_cb2.setText("");
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
