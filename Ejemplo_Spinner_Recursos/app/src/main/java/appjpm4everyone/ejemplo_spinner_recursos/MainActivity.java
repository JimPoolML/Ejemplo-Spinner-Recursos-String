package appjpm4everyone.ejemplo_spinner_recursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Mapeo de variables
    TextView estado;
    Spinner combo_dias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //Casting de variables desde XML
     estado = (TextView)  findViewById(R.id.etiSeleccion);
     combo_dias = (Spinner) findViewById(R.id.idSpinnerDias);

     //Creo un adaptador para cargar los arrays.xml al Spinner de XML

     ArrayAdapter <CharSequence> adapter = ArrayAdapter.
           createFromResource(this,R.array.combo_dias,
           android.R.layout.simple_spinner_item);

     combo_dias.setAdapter(adapter);

     //Saber que elemento de la lista  seleccionó
     combo_dias.setOnItemSelectedListener(new AdapterView.
                 OnItemSelectedListener(){

         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

             //Visualizo la opcion seleccionada en un Text view
             estado.setText("Seleccion: "+parent.getItemAtPosition(position).toString() + " # " + position);
         }


         @Override
         public void onNothingSelected (AdapterView<?> parent) {

         }

      }); //final combo_dias.setItemSelectedListener

    }
}
