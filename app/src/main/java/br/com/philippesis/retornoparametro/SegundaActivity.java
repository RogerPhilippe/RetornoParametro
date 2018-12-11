package br.com.philippesis.retornoparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends Activity {

    private Button btnEnviarResult;
    private TextView txtRecNum1, txtRecNum2;

    private String valRec1, valRec2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btnEnviarResult = (Button) findViewById(R.id.idBtnReenviar);

        txtRecNum1 = (TextView) findViewById(R.id.idTxtRecNum1);
        txtRecNum2 = (TextView) findViewById(R.id.idTxtRecNum2);

        Intent intent = getIntent();

        valRec1 = intent.getExtras().getString("num1");
        valRec2 = intent.getExtras().getString("num2");

        txtRecNum1.setText("Valor 1: "+valRec1);
        txtRecNum2.setText("Valor 2: "+valRec2);

        btnEnviarResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", String.valueOf(Integer.parseInt(valRec1) + Integer.parseInt(valRec2)) );
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

    }
}
