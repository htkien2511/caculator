package kien.caculatorbonus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private TextView tvResult;

    private Button btnSin;
    private Button btnCos;
    private Button btnTan;
    private Button btnPT;
    private Button btnphantram;
    private Button btnptb1;
    private Button btnptb2;
    private Button btnTTD;

    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickView();


    }
    public void initWidget(){
        edtNumber=(EditText) findViewById(R.id.edt_input);
        tvResult=(TextView) findViewById(R.id.tv_result);

        btnSin=(Button) findViewById(R.id.btnSin);
        btnCos=(Button) findViewById(R.id.btnCos);
        btnTan=(Button) findViewById(R.id.btnTan);
        btnPT=(Button) findViewById(R.id.btnCb2);
        btnphantram=(Button) findViewById(R.id.btnSomu);
        btnptb1=(Button) findViewById(R.id.btnptb1);
        btnptb2=(Button) findViewById(R.id.btnptb2);
        btnTTD=(Button) findViewById(R.id.btnTriTDoi);

        btnNumber1=(Button) findViewById(R.id.btnNumber1);
        btnNumber2=(Button) findViewById(R.id.btnNumber2);
        btnNumber3=(Button) findViewById(R.id.btnNumber3);
        btnNumber4=(Button) findViewById(R.id.btnNumber4);
        btnNumber5=(Button) findViewById(R.id.btnNumber5);
        btnNumber6=(Button) findViewById(R.id.btnNumber6);
        btnNumber7=(Button) findViewById(R.id.btnNumber7);
        btnNumber8=(Button) findViewById(R.id.btnNumber8);
        btnNumber9=(Button) findViewById(R.id.btnNumber9);
        btnNumber0=(Button) findViewById(R.id.btnNumber0);

        btnCong=(Button) findViewById(R.id.btnCong);
        btnTru=(Button) findViewById(R.id.btnTru);
        btnNhan=(Button) findViewById(R.id.btnNhan);
        btnChia=(Button) findViewById(R.id.btnChia);

        btnPoint=(Button) findViewById(R.id.btnPoint);
        btnResult=(Button) findViewById(R.id.btnResult);
        btnClear=(Button) findViewById(R.id.btnClear);
        btnClearAll=(Button) findViewById(R.id.btnClearAll);

    }

    public void setEventClickView(){
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnPT.setOnClickListener(this);
        btnphantram.setOnClickListener(this);

        btnptb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Activity_PTB1.class);
                startActivityForResult(intent,1);
            }
        });

        btnptb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Activity_PTB2.class);
                startActivityForResult(intent,1);
            }
        });
        btnTTD.setOnClickListener(this);

        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNumber0:
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                edtNumber.append("9");
                break;
            case R.id.btnCong:
                edtNumber.append("+");
                break;
            case R.id.btnTru:
                edtNumber.append("-");
                break;
            case R.id.btnNhan:
                edtNumber.append("*");
                break;
            case R.id.btnChia:
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                edtNumber.append(".");
                break;
            case R.id.btnSin:
                addNumber(edtNumber.getText().toString());
                if(arrNumber.size()<1){
                    Toast.makeText(this, "vui lòng nhập số cần tính", Toast.LENGTH_SHORT).show();
                }else {
                    DecimalFormat df1 = new DecimalFormat("###.#######");
                    String str1 = edtNumber.getText().toString().trim();
                    Double a1 = Double.parseDouble(str1);
                    double radians1 = Math.toRadians(a1);
                    double kq1 = Math.sin(radians1);
                    tvResult.setText(df1.format(kq1) + "");
                }
                break;
            case R.id.btnCos:
                addNumber(edtNumber.getText().toString());
                if(arrNumber.size()<1){
                    Toast.makeText(this, "vui lòng nhập số cần tính", Toast.LENGTH_SHORT).show();
                }else{
                DecimalFormat df2 = new DecimalFormat("###.#######");
                String str2=edtNumber.getText().toString().trim();
                Double a2 = Double.parseDouble(str2);
                double radians2 = Math.toRadians(a2);
                double kq2=Math.cos(radians2);
                tvResult.setText(df2.format(kq2) + "");
                }
                break;
            case R.id.btnTan:
                addNumber(edtNumber.getText().toString());
                if(arrNumber.size()<1){
                    Toast.makeText(this, "vui lòng nhập số cần tính", Toast.LENGTH_SHORT).show();
                }else{
                DecimalFormat df3 = new DecimalFormat("###.#######");
                String str3=edtNumber.getText().toString().trim();
                Double a3 = Double.parseDouble(str3);
                double radians3 = Math.toRadians(a3);
                double kq3=Math.tan(radians3);
                tvResult.setText(df3.format(kq3) + "");}
                break;
            case R.id.btnSomu:
                edtNumber.append("^");
                break;
            case R.id.btnCb2:
                addNumber(edtNumber.getText().toString());
                if(arrNumber.size()<1){
                    Toast.makeText(this, "vui lòng nhập số cần tính", Toast.LENGTH_SHORT).show();
                }else{
                DecimalFormat df4 = new DecimalFormat("###.#######");
                String str4=edtNumber.getText().toString().trim();
                Double a4 = Double.parseDouble(str4);
                Double kq4= Math.sqrt(a4);
                tvResult.setText(df4.format(kq4) + "");}
                break;
            case R.id.btnTriTDoi:
                addNumber(edtNumber.getText().toString());
                if(arrNumber.size()<1){
                    Toast.makeText(this, "vui lòng nhập số cần tính", Toast.LENGTH_SHORT).show();
                }else{
                DecimalFormat df5 = new DecimalFormat("###.#######");
                String str5=edtNumber.getText().toString().trim();

                Double a5 = Double.parseDouble(str5);
                Double kq5= Math.abs(a5);
                addNumber(edtNumber.getText().toString());
                tvResult.setText(df5.format(kq5) + "");}
                break;
            case R.id.btnResult:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;

                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                // Thuật toán tính toán biểu thức
                if(arrOperation.size()> arrNumber.size()|| arrOperation.size() < 1) {
                    tvResult.setText("Lỗi định dạng");
                }
                else{
                        for (int i = 0; i < (arrNumber.size() - 1); i++) {
                            switch (arrOperation.get(i)) {

                                case "*":
                                    if (i == 0) {
                                        result = arrNumber.get(i) * arrNumber.get(i + 1);
                                    } else {
                                        result = result * arrNumber.get(i + 1);
                                    }
                                    break;
                                case "/":
                                    if (i == 0) {
                                        result = arrNumber.get(i) / arrNumber.get(i + 1);
                                    } else {
                                        result = result / arrNumber.get(i + 1);
                                    }
                                    break;
                                case "+":
                                    if (i == 0) {
                                        result = arrNumber.get(i) + arrNumber.get(i + 1);
                                    } else {
                                        result = result + arrNumber.get(i + 1);
                                    }
                                    break;
                                case "-":
                                    if (i == 0) {
                                        result = arrNumber.get(i) - arrNumber.get(i + 1);
                                    } else {
                                        result = result - arrNumber.get(i + 1);
                                    }
                                    break;
                                case "^":
                                    result=1;
                                    for(int j=0;j<arrNumber.get(i + 1);j++) {
                                        result = result*arrNumber.get(i) ;

                                        }

                                    break;
                                default:
                                    break;
                            }
                        }
                        tvResult.setText(df.format(result) + "");
                }
                break;
            case R.id.btnClear:
                BaseInputConnection textFieldInputConnection=new BaseInputConnection(edtNumber,true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                break;
        }
    }
    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '^':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }


}
