package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    public Boolean isOperationClick;
    private Double first,second,result;
    private String operation="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_comma=findViewById(R.id.comma);
        Button btn_zero=findViewById(R.id.zero);
        Button btn_nine=findViewById(R.id.nine);
        Button btn_eight=findViewById(R.id.eight);
        Button btn_seven=findViewById(R.id.seven);
        Button btn_six=findViewById(R.id.six);
        Button btn_five=findViewById(R.id.five);
        Button btn_four=findViewById(R.id.four);
        Button btn_thre=findViewById(R.id.thre);
        Button btn_two=findViewById(R.id.two);
        Button btn_one=findViewById(R.id.one);

        Button btn_plus=findViewById(R.id.plus);
        Button btn_minus=findViewById(R.id.minus);
        Button btn_prozzent=findViewById(R.id.prozzent);
        Button btn_multiply=findViewById(R.id.multiplicain);
        Button btn_equals=findViewById(R.id.ravno);
        Button btn_division=findViewById(R.id.division);
        Button btn_plus_minus=findViewById(R.id.plus_minus);
        Button btn_clear=findViewById(R.id.clear);

        textView=findViewById(R.id.input);

        btn_zero.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_one.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_two.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_thre.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_four.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_five.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_six.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_seven.setOnClickListener(view -> {
         onNumberClick(view);
        }); btn_eight.setOnClickListener(view -> {
         onNumberClick(view);
        });btn_nine.setOnClickListener(view -> {
         onNumberClick(view);
        });btn_comma.setOnClickListener(view -> {
         onNumberClick(view);
        });


        btn_clear.setOnClickListener(view -> {
         onOperationClick(view);
        });

        btn_division.setOnClickListener(view -> {
          onOperationClick(view);
        });
        btn_minus.setOnClickListener(view -> {
            onOperationClick(view);
        });
        btn_plus.setOnClickListener(view -> {
           onOperationClick(view);
        });
        btn_multiply.setOnClickListener(view ->  {
            onOperationClick(view);
        });
        btn_plus_minus.setOnClickListener(view -> {
            onOperationClick(view);
        });
        btn_prozzent.setOnClickListener(view -> {
            onOperationClick(view);
        });

        btn_equals.setOnClickListener(view -> {
            onOperationClick(view);
        });
    }

    private void onOperationClick(View view) {
       if(view.getId()==R.id.clear){
           textView.setText("0");
           first=0.0;
           second=0.0;
       }  else if (view.getId()==R.id.ravno) {
           second=Double.parseDouble(textView.getText().toString());
         if (operation.equals("%")) {
           result=(first/100)*second;
           textView.setText(canselDouble(result));
       }
       else if (operation.equals("*")){
           result=first*second;
           textView.setText(canselDouble(result));
       } else if (operation.equals("+")) {
           result= first+second;
           textView.setText(canselDouble(result));
       } else if (operation.equals("-")) {
           result= first-second;
           textView.setText(canselDouble(result));
       } else if (operation.equals("/")) {
             if (second == 0) {
                 textView.setText("на нолоь делить нельзя");
             } else {
                 result = first / second;
                 textView.setText(canselDouble(result));
             }
            isOperationClick=true;
         }
       }

       else if (view.getId()==R.id.plus) {
           operation="+";
           first=Double.parseDouble(textView.getText().toString());
           isOperationClick=true;
       }
       else if (view.getId()==R.id.minus) {
           operation="-";
           first=Double.parseDouble(textView.getText().toString());
           isOperationClick=true;
       }
       else if (view.getId()==R.id.multiplicain) {
           operation="*";
           first=Double.parseDouble(textView.getText().toString());
           isOperationClick=true;
       }
       else if (view.getId()==R.id.prozzent) {
           operation="%";
           first=Double.parseDouble(textView.getText().toString());
           isOperationClick=true;
       }
       else if (view.getId()==R.id.division) {
           operation="/";
           first=Double.parseDouble(textView.getText().toString());
           isOperationClick=true;
       }
    }

    private String canselDouble(Double result) {
        String text= result.toString();
        if(text.substring(text.length()-2).equals(".0")){
            return text.substring(0,text.length()-2);
        }else {
            return result.toString();
        }
    }

    private void onNumberClick(View view) {
        if (view.getId() == R.id.zero) {
            setNumber("0");
        } else if (view.getId() == R.id.one) {
            setNumber("1");
        }else if (view.getId() == R.id.two) {
            setNumber("2");
        }else if (view.getId() == R.id.thre) {
            setNumber("3");
        }else if (view.getId() == R.id.four) {
            setNumber("4");
        }else if (view.getId() == R.id.five) {
            setNumber("5");
        }else if (view.getId() == R.id.six) {
            setNumber("6");
        }else if (view.getId() == R.id.seven) {
            setNumber("7");
        }else if (view.getId() == R.id.eight) {
            setNumber("8");
        }else if (view.getId() == R.id.nine) {
            setNumber("9");
        } else if (view.getId()==R.id.comma) {
            setNumber(".");

        }
    }

    public void setNumber(String number) {

        if(textView.getText().toString().equals("0")){
            textView.setText(number);
        }
        else if(isOperationClick){
            textView.setText(number);
        }
        else {
            textView.append(number);
        }
        isOperationClick=false;
    }

}