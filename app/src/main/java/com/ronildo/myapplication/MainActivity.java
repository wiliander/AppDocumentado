package com.ronildo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ronildo.myapplication.exception.DivisaoPorZeroException;

/**
 * Essa classe realiza as quatro operações matemáticas
 * @author WIll
 */
public class MainActivity extends AppCompatActivity {

    /***
     * variáveis locais tipadas para manipulação
     */
    private EditText textViewValor1;
    private EditText textViewVAlor2;
    private EditText textViewOperacao;
    private TextView textViewResultado;

    /**
     * Este método realiza a ação onClick do componente button.
     * declara uma operação matematica e faz a validação para chamada dos métodos
     * feita todas as validações
     * @param view encontra a view responsável pelo método
     */
    public void calcular(View view) {

        // pega operação que o usuario digitou
        String operacao = textViewOperacao.getText().toString();

        float float1 = 0;
        float float2 = 0;

        try {
            //converte os valores da tela para float e armazena na variavel do mesmo tipo
             float1 = Float.parseFloat(textViewValor1.getText().toString());
             float2 = Float.parseFloat(textViewVAlor2.getText().toString());

            String resultado = new String();

            //inicio do método switch para saber oq o usuario digitou e invocar o método
            switch (operacao) {
                case "+":
                    resultado = this.mais(float1, float2).toString(); //invoca o metodo mais
                    break;
                case "-":
                    resultado = this.menos(float1, float2).toString(); //invoda o metodo menos
                    break;
                case "*":
                    resultado = this.vezes(float1, float2).toString(); //invoca o metodo vezes
                    break;
                case "/":
                    resultado = this.dividido(float1, float2).toString(); //invoca o metodo dividido
                    break;
                default:
                    Toast.makeText(this, "Operação inválida", Toast.LENGTH_SHORT).show(); //caso não encontrar operações validas
                    resultado = "";
            }

            textViewResultado.setText(resultado); //seta para a label o resultado

        } catch (NumberFormatException e) {
            //se nenhum campo foi preenchido cai nessa mensagem
            Toast.makeText(this, "Iforme os valores!", Toast.LENGTH_SHORT).show();
        } catch (DivisaoPorZeroException e) {
            //se a operação não foi preenchida cai nessa mensagem
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * metodo responsável pela instancia do layout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupera os valores que estão na tela e armazena nas variaveis definidas no contexto
        this.textViewValor1 = findViewById(R.id.valor1);
        this.textViewVAlor2 = findViewById(R.id.valor2);
        this.textViewOperacao  = findViewById(R.id.operacao);
        this.textViewResultado  = findViewById(R.id.resultado);
    }

    /**
     * Realiza operações de soma utilizando dois parametros.
     * O método retorna um objeto Float
     *
     * @param valor1 - primeiro parametro float
     * @param valor2 - segundo parametro float
     * @return - retorna a soma do primeiro e o segundo parametro
     */
    private Float mais(float valor1, float valor2) {
        return valor1 + valor2;
    }//fim do metodo  mais


    /**
     * Realiza operações de subtração utilizando dois parametros.
     * O método retorna um objeto Float
     *
     * @param valor1 - primeiro parametro float
     * @param valor2 - segundo parametro float
     * @return - retorna a substração do primeiro e o segundo parametro
     */
    private Float menos(float valor1, float valor2) {
        return valor1 - valor2;
    }//fim do metodo  menos

    /**
     * Realiza operações de multiplicação utilizando dois parametros.
     * O método retorna um objeto Float
     *
     * @param valor1 - primeiro parametro float
     * @param valor2 - segundo parametro float
     * @return - retorna a multiplicação do primeiro e o segundo parametro
     */
    private Float vezes(float valor1, float valor2) {
        return valor1 * valor2;
    }//fim do metodo  vezes

    /**
     * Realiza operações de divisao utilizando dois parametros.
     * O método retorna um objeto Float
     * valida se o segundo numero é zero
     * @param valor1 - primeiro parametro float
     * @param valor2 - segundo parametro float
     * @return - retorna a divisão do primeiro e o segundo parametro
     */
    private Float dividido(float valor1, float valor2) throws DivisaoPorZeroException {
        //se o segundo valor é zero instancia a classe
        if(valor2 == 0) {
            throw new DivisaoPorZeroException();
        }
        return valor1 / valor2;
    }//fim do metodo  dividido
}
