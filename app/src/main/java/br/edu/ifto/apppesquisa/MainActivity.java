package br.edu.ifto.apppesquisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifto.apppesquisa.enums.Cidades;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout nome = findViewById(R.id.nome);
        AutoCompleteTextView cidade = findViewById(R.id.cidade);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line,Cidades.values());
        cidade.setAdapter(adapter);

        SeekBar satisfacaoSeekbar = findViewById(R.id.satisfacao);
        satisfacaoSeekbar.setProgress(1);
        ImageView imgSatisfacao = findViewById(R.id.imgSatisfacao);
        imgSatisfacao.setImageResource(R.drawable.bom);
        satisfacaoSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int opcao, boolean b) {
                switch(opcao){
                    case 0:
                        imgSatisfacao.setImageResource(R.drawable.ruim);
                        break;
                    case 1:
                        imgSatisfacao.setImageResource(R.drawable.bom);
                        break;
                    case 2:
                        imgSatisfacao.setImageResource(R.drawable.otimo);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button button = findViewById(R.id.botaoEnviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> dadosPesquisa = new ArrayList<>();
                dadosPesquisa.add(nome.getEditText().getText().toString());
                dadosPesquisa.add(cidade.getText().toString());
                dadosPesquisa.add(String.valueOf(satisfacaoSeekbar.getProgress()));
                Intent intent = new Intent(getActivity(),DadosActivity.class);
                intent.putStringArrayListExtra("dadosPesquisa", dadosPesquisa);
                startActivity(intent);
            }
        });
    }

    public Context getActivity(){
        return this;
    }
}

