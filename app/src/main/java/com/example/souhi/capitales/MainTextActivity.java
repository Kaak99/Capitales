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

public class MainTextActivity extends AppCompatActivity {



    //initialisation

    private static final String TAG = "MyActivity";


    TextView tvWhatis;
    Button btnPays1, btnPays2, btnPays3, btnPays4, btnPays5;
    EditText etCapit1, etCapit2, etCapit3, etCapit4, etCapit5;
    Button butStart, butCheck;
    boolean controleStart = false, controleCheck = false;

    final int QUESTION_NUMBER = 5;
    int index = 0, score = 5; //(on met score au max, on decremente par erreur)
    //index sera resultat tirage au sort du pays (5 fois)
    String pays, capitale, userAnswer;
    String[] tabCapitale = {"", "", "", "", "", ""};


    Button[] boutonPays = new Button[QUESTION_NUMBER];
    EditText[] etCapitale = new EditText[QUESTION_NUMBER];


    String[][] tabPayCap = {
            {"Finlande", "Helsinki"}, {"Irlande", "Dublin"}, {"Allemagne", "Berlin"}, {"Suisse", "Berne"},
            {"Arménie", "Erevan"}, {"Thailande", "Bangkok"}, {"Inde", "Delhi"}, {"Soudan", "Khartoum"},
            {"Mali", "Bamako"}, {"Liban", "Beyrouth"}, {"Serbie", "Belgrade"}, {"Sénégal", "Dakar"},
            {"Brésil", "Brasilia"}, {"Colombie", "Bogota"}, {"Roumanie", "Bucarest"}, {"Syrie", "Damas"},
            {"Pakistan", "Islamabad"}, {"Autriche", "Vienne"}, {"Ukraine", "Kiev"}, {"Rwanda", "Kigali"},
            {"Pays-Bas", "Amsterdam"}, {"Jordanie", "Amman"}, {"Turquie", "Ankara"}, {"Madagascar", "Antananarivo"},
            {"Slovaquie", "Batislava"}, {"République du Congo", "Brazzaville"}, {"Hongrie", "Budapest"}, {"Australie", "Canberra"},
            {"Venezuela", "Caracas"}, {"Guinée", "Conakry"}, {"Guinée-Bissau", "Bissau"}, {"Danemark", "Copenhague"},
            {"Bangladesh", "Dacca"}, {"Djibouti", "Djibouti"}, {"Tanzanie", "Dodoma"}, {"Qatar", "Doha"},
            {"Pays-Sierra Leone", "Freetown"}, {"Botswana", "Gaborone"}, {"Guatemala", "Guatemala"}, {"Indonésie", "Jakarta"},
            {"Afghanistan", "Kaboul"}, {"Ouganda", "Kampala"}, {"Népal", "Katmandou"}, {"Jamaique", "Kingston"},
            {"Rép.Démocratique du Congo", "Kinshasa"}, {"Koweït", "Koweït"}, {"Gabon", "Libreville"}, {"Malawi", "Lilongwe"},
            {"Pérou", "Lima"}, {"Portugal", "Lisbonne"}, {"Royaume-Uni", "Londres"}, {"Angola", "Luanda"},
            {"Luxembourg", "Luxembourg"}, {"Espagne", "Madrid"}, {"Croatie", "Zagreb"}, {"Philippines", "Manille"},
            {"Mozambique", "Maputo"}, {"Lesotho", "Maseru"}, {"Swaziland", "Mbabane"}, {"Mexique", "Mexico"},
            {"Biélorussie", "Minsk"}, {"Monaco", "Monaco"}, {"Liberia", "Monrovia"}, {"Uruguay", "Montevideo"},
            {"Comores", "Moroni"}, {"Russie", "Moscou"}, {"Kenya", "Nairobi"}, {"Bahamas", "Nassau"},
            {"Niger", "Niamey"}, {"Mauritanie", "Nouakchott"}, {"Norvège", "Oslo"}, {"Canada", "Ottawa"},
            {"Burkina Faso", "Ouagadougou"}, {"Suriname", "Paramaribo"}, {"République tchèque", "Prague"}, {"Italie", "Rome"},
            {"Corée du Nord", "Pyongyang"}, {"Equateur", "Quito"}, {"Maroc", "Rabat"}, {"Palestine", "Ramallah "},
            {"Islande", "Reykjavik"}, {"Lettonie", "Riga"}, {"Arabie saoudite", "Ryiad"}, {"Afrique du Sud", "Pretoria"},
            {"Chili", "Santiago"}, {"Yémen", "Sanaa"}, {"Bosnie-Herzégovine", "Sarajevo"}, {"Singapour", "Singapour "},
            {"Bulgarie", "Sofia"}, {"Suède", "Stockholm"}, {"Bhoutan", "Thimphou"}, {"Albanie", "Tirana"},
            {"Japon", "Tokyo"}, {"Lybie", "Tripoli"}, {"Tunisie", "Tunis"}, {"Pologne", "Varsovie "},
            {"Samoa", "Apia"}, {"Érythrée", "Asmara"}, {"Azerbaïdjan", "Bakou"}, {"République centrafricaine", "Bangui"}
    };  //25*4= 100 pays et 100 capitales

    ArrayList<Integer> indexAlreadyUsed = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_text);


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
                controleStart = true;
                controleCheck = false;
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

                    userAnswer = etCapitale[i].getText().toString().trim();
                    if (!userAnswer.equalsIgnoreCase(tabCapitale[i])) {
                        //change couleur texte ou fond, echec fond
                        //etCapitale[i].setBackgroundColor(R.color.colorPrimary);
                        //etCapitale[i].setBackgroundColor(Color.red(1));
                        etCapitale[i].setTextColor(0xFFF00F00);
                        etCapitale[i].setText(tabCapitale[i]);
                        score--;
                    } else {
                        etCapitale[i].setTextColor(0xFF000000);
                        etCapitale[i].setText(tabCapitale[i]);
                    }

                }
                //Log.v(TAG, "" + tabPayCap[i][1]);


                if (controleStart & !controleCheck)

                {
                    tvWhatis.setText("Votre score = " + score + " / 5");

                }

                score = 5;
                controleStart = !controleStart;
                controleCheck = true;
            } //fin des action si click CHECK
        });

//desactiver inputText au demarrage? editText.setInputType(InputType.TYPE_NULL);
        //rajouter un splashScreen, du son
        //augmenter la bdd


    }  //fin du on create


}  // fin du main