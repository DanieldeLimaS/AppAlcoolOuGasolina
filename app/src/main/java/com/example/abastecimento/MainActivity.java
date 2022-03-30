package com.example.abastecimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtGasolina, edtAlcool;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
        configurarBotaoCalcular();

    }
    //CARREGA OS COMPONENTES EM UMA VARIAVEL DECALRADA NO INICIO DESSA CLASSE
    private void carregarComponentes() {
        edtGasolina = findViewById(R.id.edtPrecoGasolina);
        edtAlcool = findViewById(R.id.edtPrecoAlcool);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

    }

    //MÉTODO PRINCIPAL QUE CONTEM TODA A ESTRUTURA DE EVENTO QUE O BOTÃO CALCULAR IRÁ REALIZAR
    protected void configurarBotaoCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculoRetornaMensagem();
                Log.d("resultado", resultado);
                exibiResultado(resultado);
                limpaCampos();
                HideKeyboard();
            }
            public void HideKeyboard(){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edtAlcool.getWindowToken(),0);
                imm.hideSoftInputFromWindow(edtGasolina.getWindowToken(),0);
            }

            //REALIZA O CALCULO E RETORNA A MENSAGEM FILTRADA PARA A TELA
            protected String realizaCalculoRetornaMensagem() {
                double precoGasolina = edtGasolina.getText().length() > 0 ? Double.parseDouble(edtGasolina.getText().toString().replace(",", ".")) : 0;
                double precoAlcool = edtAlcool.getText().length() > 0 ? Double.parseDouble(edtAlcool.getText().toString().replace(",", ".")) : 0;
                if (precoGasolina == 0 || precoAlcool == 0)
                    return "Valores inválidos, tente novamente!";
                else {
                    double resultado = precoAlcool / precoGasolina;
                    if (resultado < 0.7)
                        return "É melhor abastecer com Álcool";
                    else return "É melhor abastecer com Gasolina";
                }
            }


            //RESPONSÁVEL POR APENAS EXIBIR A MENSAGEM/RESULTADO NA TELA
            protected void exibiResultado(String resultado) {
                txtResultado.setText(resultado);
            }

            //LIMPA OS CAMPOS DE PESO E ALTURA APOS APRESENTAR O RESULTADO NA TELA
            protected void limpaCampos() {
                edtAlcool.setText("");
                edtGasolina.setText("");
                edtGasolina.requestFocus();
            }
        });
    }
}