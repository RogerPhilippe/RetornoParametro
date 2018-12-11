package br.com.philippesis.retornoparametro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends Activity {

    private EditText editNum1, editNum2;
    private Button btnEnviar1;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = (EditText) findViewById(R.id.idEditNum1);
        editNum2 = (EditText) findViewById(R.id.idEditNum2);

        btnEnviar1 = (Button) findViewById(R.id.btnEnviar1);

        txtResultado = (TextView) findViewById(R.id.idTxtResultado);

        btnEnviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num1 = editNum1.getText().toString();
                String num2 = editNum2.getText().toString();

                if ( num1.isEmpty() && num2.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Preencha ambos os campos!", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    try {
                        startActivityForResult(intent, 1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == 1 && resultCode == RESULT_OK ) {
            txtResultado.setText("Resultado: "+data.getStringExtra("result"));
        }

    }
}
