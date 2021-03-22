package tw.edu.yuntech.myapplication04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9, Num0;
    Button equ, div, mul, add, sub, dot, del, butAC;
    TextView result;
    int Cal_index = 0 ; //判斷是否
    int Index_Value = 0 ; //是否按下按鍵
    String NU1 = "0" , NU2 = "0" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Num0 = findViewById(R.id.Num0);
        Num1 = findViewById(R.id.Num1);
        Num2 = findViewById(R.id.Num2);
        Num3 = findViewById(R.id.Num3);
        Num4 = findViewById(R.id.Num4);
        Num5 = findViewById(R.id.Num5);
        Num6 = findViewById(R.id.Num6);
        Num7 = findViewById(R.id.Num7);
        Num8 = findViewById(R.id.Num8);
        Num9 = findViewById(R.id.Num9);
        equ = findViewById(R.id.equ);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        dot = findViewById(R.id.dot);
        del = findViewById(R.id.del);
        result = findViewById(R.id.result);
        butAC = findViewById(R.id.ac);
        SetMyOnClick();
    }

    private void SetMyOnClick() {
        Num0.setOnClickListener(MyOnClick);
        Num1.setOnClickListener(MyOnClick);
        Num2.setOnClickListener(MyOnClick);
        Num3.setOnClickListener(MyOnClick);
        Num4.setOnClickListener(MyOnClick);
        Num5.setOnClickListener(MyOnClick);
        Num6.setOnClickListener(MyOnClick);
        Num7.setOnClickListener(MyOnClick);
        Num8.setOnClickListener(MyOnClick);
        Num9.setOnClickListener(MyOnClick);
        dot.setOnClickListener(MyOnClick);
        add.setOnClickListener(MyOnClick);
        sub.setOnClickListener(MyOnClick);
        div.setOnClickListener(MyOnClick);
        mul.setOnClickListener(MyOnClick);
        del.setOnClickListener(MyOnClick);
        equ.setOnClickListener(MyOnClick);
        butAC.setOnClickListener(MyOnClick);
        del.setOnClickListener(MyOnClick);
    }

    private Button.OnClickListener MyOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String Str_Value;
            Str_Value = result.getText().toString();  //why?
            switch (v.getId()) {
                case R.id.Num0:
                    DisplayNU("0");
                    break;
                case R.id.Num1:
                    DisplayNU("1");
                    break;
                case R.id.Num2:
                    DisplayNU("2");
                    break;
                case R.id.Num3:
                    DisplayNU("3");
                    break;
                case R.id.Num4:
                    DisplayNU("4");
                    break;
                case R.id.Num5:
                    DisplayNU("5");
                    break;
                case R.id.Num6:
                    DisplayNU("6");
                    break;
                case R.id.Num7:
                    DisplayNU("7");
                    break;
                case R.id.Num8:
                    DisplayNU("8");
                    break;
                case R.id.Num9:
                    DisplayNU("9");
                    break;
                case R.id.dot:
                    DisplayNU(".");
                    break;
                case R.id.ac:
                    result.setText("0");
                    break;
                case R.id.add:
                    Calculate(0, Str_Value);
                    break; //do + operation
                case R.id.sub:
                    Calculate(1, Str_Value);
                    break; //do - operation
                case R.id.mul:
                    Calculate(2, Str_Value);
                    break; //do * operation
                case R.id.div:
                    Calculate(3, Str_Value);
                    break; //do / operation
                case R.id.del:
                    Calculate(4, Str_Value);
                    break; //do / operation
                case R.id.equ:
                    Calculate(99, Str_Value);
                    break;
            }
        }

        ;
    };

    private void DisplayNU(String S)
    {
        String str;
        String Zero = "0" ;
        str = result.getText().toString();
        if(Zero.equals(str) || Index_Value !=0)
        {//空的
            result.setText(""); //clean textview
            result.setText(S);
            Index_Value = 0 ;
        }
        else
        {
            result.setText(str + S);
        }
    }

    private void Calculate (int Cal_value , String Cal_Nu) {
        double x;
        String Ans;
        switch (Cal_value) {
            case 0:
                NU1 = Cal_Nu;
                Cal_index = 0;
                result.setText("");
                break;
            case 1:
                NU1 = Cal_Nu;
                Cal_index = 1;
                result.setText("");
                break;
            case 2:
                NU1 = Cal_Nu;
                Cal_index = 2;
                result.setText("");
                break;
            case 3:
                NU1 = Cal_Nu;
                Cal_index = 3;
                result.setText("");
                break;
            case 4:
                NU1 = Cal_Nu;
                NU2 = result.getText().toString();
                Ans = NU2.substring(0,NU2.length() - 1);
                result.setText(Ans);
                break;

//----------------------------------------------------
            case 99:
                NU2 = result.getText().toString();
                double i = Double.valueOf(NU1);
                double j = Double.valueOf(NU2);
                switch (Cal_index) {
                    case 0:
                        x = i + j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 1:
                        x = i - j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 2:
                        x = i * j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 3:
                        x = i / j;
                        Ans = Double.toString(x);
                        result.setText(Ans);
                        break;
                    case 4:
                        Ans = NU2.substring(0,NU2.length() - 1);
                        result.setText(Ans);
                        break;
                }
                break;
        }
    }


}