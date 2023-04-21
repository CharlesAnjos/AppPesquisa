package br.edu.ifto.apppesquisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        ArrayList<String> dadosPesquisa = getIntent().getStringArrayListExtra(
                "dadosPesquisa");
        TextView textView = findViewById(R.id.dadosPesquisa);
        textView.append("\n");
        textView.append("\n");
        textView.append("Nome do pesquisado: "+dadosPesquisa.get(0)+"\n");
        textView.append("Cidade do pesquisado: "+dadosPesquisa.get(1)+"\n");
        switch(Integer.parseInt(dadosPesquisa.get(2))){
            case 0:
                textView.append("Satisfação do pesquisado: Ruim");
                break;
            case 1:
                textView.append("Satisfação do pesquisado: Boa");
                break;
            case 2:
                textView.append("Satisfação do pesquisado: Ótima");
                break;
        }
    }
}