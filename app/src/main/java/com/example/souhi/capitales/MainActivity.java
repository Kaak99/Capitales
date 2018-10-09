package com.example.souhi.capitales;

import android.graphics.Color;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //initialisation

    private static final String TAG = "MyActivity";

    TextView tvWhatis;
    Button btnPays1, btnPays2, btnPays3, btnPays4, btnPays5;
    EditText etCapit1, etCapit2, etCapit3, etCapit4, etCapit5;
    Button butStart, butCheck;

    //final int COUNTRY_NUMBER = 20;//inutile et arisque: pre,dre tab-lentght
    final int QUESTION_NUMBER = 5;
    int index=0, score=5; //(on met score au max, on decremente par erreur)
    //index sera resultat tirage au sort du pays (5 fois)
    String pays, capitale, userAnswer;
    String[] tabCapitale = {"","","","","",""};
    //String[] userCapitale = {"","","","","",""};//tab des 5 cap données par user créé et init
    //inutile

    Button[] boutonPays = new Button[QUESTION_NUMBER];
    EditText[] etCapitale = new EditText[QUESTION_NUMBER];


    String[][] tabPayCap = {
            {"Finlande", "Helsinki"}, {"Irlande", "Dublin"}, {"Allemagne", "Berlin"}, {"Suisse", "Berne"},
            {"Arménie", "Erevan"}, {"Thailande", "Bangkok"}, {"Inde", "Delhi"}, {"Soudan", "Khartoum"},
            {"Mali", "Bamako"}, {"Liban", "Beyrouth"}, {"Serbie", "Belgrade"}, {"Sénégal", "Dakar"},
            {"Brésil", "Brasilia"}, {"Colombie", "Bogota"}, {"Roumanie", "Bucarest"}, {"Syrie", "Damas"},
            {"Pakistan", "Islamabad"}, {"Autriche", "Vienne"}, {"Ukraine", "Kiev"}, {"Rwanda", "Kigali"}
    };  //20pays et 20 capitales

    ArrayList<Integer> indexAlreadyUsed = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//initialisation View by ID
        tvWhatis = findViewById(R.id.tvWhatis);
        boutonPays[0] = findViewById(R.id.btnPays1);
        boutonPays[1] = findViewById(R.id.btnPays2);
        boutonPays[2] = findViewById(R.id.btnPays3);
        boutonPays[3] = findViewById(R.id.btnPays4);
        boutonPays[4] = findViewById(R.id.btnPays5);
//        btnPays1 = findViewById(R.id.btnPays1);
//        btnPays2 = findViewById(R.id.btnPays2);
//        btnPays3 = findViewById(R.id.btnPays3);
//        btnPays4 = findViewById(R.id.btnPays4);
//        btnPays5 = findViewById(R.id.btnPays5);
        etCapitale[0] = findViewById(R.id.etCapit1);
        etCapitale[1] = findViewById(R.id.etCapit2);
        etCapitale[2] = findViewById(R.id.etCapit3);
        etCapitale[3] = findViewById(R.id.etCapit4);
        etCapitale[4] = findViewById(R.id.etCapit5);
//        etCapit1 = findViewById(R.id.etCapit1);
//        etCapit2 = findViewById(R.id.etCapit2);
//        etCapit3 = findViewById(R.id.etCapit3);
//        etCapit4 = findViewById(R.id.etCapit4);
//        etCapit5 = findViewById(R.id.etCapit5);

        butStart = findViewById(R.id.butStart);
        butCheck = findViewById(R.id.butCheck);


//start

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //qd clic start, tire au sort+affiche 5 pays

                tvWhatis.setText(R.string.whatIsText);

                //on va tirer au sort 5(=QUESTION_NUMBER) index avec boucle for

                for (int i = 0; i < QUESTION_NUMBER; i++) {

                    etCapitale[i].setTextColor(0xFF000000); //reinit les editText des capitales
                    etCapitale[i].setText(""); //en mettangt text=0 et couleur noire

                    do {                   //index tiré entre 0 et <n=taille tableau pays/capitales
                        Random random = new Random();//jusqu'à en avoir un pas inscrit dans Arraylst
                        index = random.nextInt(tabPayCap.length);
                    } while (indexAlreadyUsed.contains(index));
                    //il a inscrit un nombre x de deja tiré ds arraylist

                    indexAlreadyUsed.add(index); // fin tirage=rajoute index tiré à liste de ceux deja utilisés

                    pays = tabPayCap[index][0]; //le pays obtenu est
                    //capitale = tabPayCap[index][1];// la capitale obtenue alors est
                    boutonPays[i].setText(pays); // on affiche nom du pays
                    tabCapitale[i] = tabPayCap[index][1];// range nom chaque cap ds tabCap
                }     // fin du tirage au sort
                //avant de retirer au sort 5(n) questions, on efface la base de donnée des index deja tirés
                for (int j = 0; j < indexAlreadyUsed.size(); j++) {
                    indexAlreadyUsed.set(j, null);
                }

            }//fin de l'action du onclick
        });


        //CHECK
//qd on clique sur check, on compare edit text et la bonne cap
        //si ok, score+1
        //sinon on ecrit la bonne reponse en rouge
        //on affichje score/5 dans le textView

        butCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < QUESTION_NUMBER; i++) {

                    userAnswer = etCapitale[i].getText().toString();
                        if (!userAnswer.equalsIgnoreCase(tabCapitale[i])) {
                        //change couleur texte ou fond, echec fond
                        //etCapitale[i].setBackgroundColor(R.color.colorPrimary);
                        //etCapitale[i].setBackgroundColor(Color.red(1));
                        etCapitale[i].setTextColor(0xFFF00F00);
                        etCapitale[i].setText(tabCapitale[i]);
                        score--;
                    }

                    //Log.v(TAG, "" + tabPayCap[i][1]);

                }
                tvWhatis.setText("Votre score = " + score + " / 5");
                score = 0;
            } //fin des action si click CHECK
        });




    }  //fin du on create


}  // fin du main
