package fr.emilie.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // Variables
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPoint;
    Button buttonMoins;
    Button buttonPlus;
    Button buttonMultiplie;
    Button buttonDivise;
    Button buttonEgal;
    Button buttonReset;
    TextView textEcran;

    double chiffre;
    boolean clicCalcul = false;
    boolean update = false;
    String operateur = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // On relie les variables au fichier layout
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMultiplie = (Button) findViewById(R.id.buttonMultiplier);
        buttonDivise = (Button) findViewById(R.id.buttonDivision);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        buttonReset = (Button) findViewById(R.id.buttonC);
        textEcran = (TextView) findViewById(R.id.ecran);

        // On met un listener sur chaque bouton
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre("9");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicChiffre(".");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur = "+";
                clicOperateur();
            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur = "-";
                clicOperateur();
            }
        });

        buttonMultiplie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur = "*";
                clicOperateur();
            }
        });

        buttonDivise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operateur = "/";
                clicOperateur();
            }
        });
/*
        buttonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicEgal();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicReset();
            }
        });
*/
    }


    // Afficher les chiffres à l'écran
    public void clicChiffre(String affiche){
        if(update)
            update = false;
        else{
            if(!textEcran.getText().equals("0"))
                affiche = textEcran.getText() + affiche;
            }
        textEcran.setText(affiche);
    }

    // Quand on clique sur un operateur
    public void clicOperateur(){
        if(clicCalcul){
            calcul();
            textEcran.setText(String.valueOf(chiffre));
        }else {
            chiffre = Double.valueOf(textEcran.getText().toString()).doubleValue();
            clicCalcul = true;
        }
        update = true;
    }

    // Calculer
    public void calcul(){
        if(operateur.equals("+")){
            chiffre = chiffre + Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre));
        }else if(operateur.equals("-")){
            chiffre = chiffre - Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre));
        }else if(operateur.equals("*")){
            chiffre = chiffre * Double.valueOf(textEcran.getText().toString()).doubleValue();
            textEcran.setText(String.valueOf(chiffre));
        }else if(operateur.equals("/")){
            try {
                chiffre = chiffre / Double.valueOf(textEcran.getText().toString()).doubleValue();
                textEcran.setText(String.valueOf(chiffre));
            }catch(ArithmeticException e){ //on empeche une division par 0
                textEcran.setText("0");
            }
        }
    }


    // Quand on clique sur reset
    public void clicReset(View v){
        update = true;
        chiffre = 0;
        clicCalcul = false;
        textEcran.setText("0");
    }

    // Quand on clique sur Egal
    public void clicEgal(View v){
        calcul();
        update = true;
        clicCalcul = false;
    }

}
