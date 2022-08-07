package com.getworld.controlefinanceiro.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    private static FirebaseAuth auteticacao;
    
    //retorna a instancia do Firebase
    public static FirebaseAuth getFirebaseAutenticacao(){

        if( auteticacao == null){
            auteticacao = FirebaseAuth.getInstance();
        }

        return auteticacao;


    }

}
