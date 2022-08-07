package com.getworld.controlefinanceiro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getworld.controlefinanceiro.R;
import com.getworld.controlefinanceiro.config.ConfiguracaoFirebase;
import com.getworld.controlefinanceiro.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;

    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperar o que foi digitado
                String textNome = campoNome.getText().toString();
                String textEmail = campoEmail.getText().toString();
                String textSenha = campoSenha.getText().toString();

                //validar se foi digitado algo
                if(!textNome.isEmpty()){

                    if (!textEmail.isEmpty()){

                        if (!textSenha.isEmpty()){

                            usuario = new Usuario();
                            usuario.setNome ( textNome );
                            usuario.setEmail( textEmail );
                            usuario.setSenha( textSenha );
                            cadastrarUsuario();

                        }else{
                            Toast.makeText(CadastroActivity.this,
                                    "Preencha o senha",
                                    Toast.LENGTH_LONG ).show();
                        }

                    }else{
                        Toast.makeText(CadastroActivity.this,
                                "Preencha o e-mail",
                                Toast.LENGTH_LONG ).show();
                    }

                }else{
                    Toast.makeText(CadastroActivity.this,
                            "Preencha o nome",
                            Toast.LENGTH_LONG ).show();

                }


            }
        });


    }

    public void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //cadastrar usuario
        autenticacao.createUserWithEmailAndPassword
                (usuario.getEmail(),usuario.getSenha());
    }

}