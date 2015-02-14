package pe.entel.basesdedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText ET_Nombre,ET_Apellido,ET_Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_Nombre = (EditText) findViewById(R.id.ET_Nombre);
        ET_Apellido = (EditText) findViewById(R.id.ET_Apellido);
        ET_Edad= (EditText) findViewById(R.id.ET_Edad);
    }

    public void GuardarDatos(View v){

        String nombre= ET_Nombre.getText().toString();
        String apellido= ET_Apellido.getText().toString();
        int edad= Integer.parseInt(ET_Edad.getText().toString());

        BaseHelper baseHelper= new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db= baseHelper.getWritableDatabase();
        if (db!=null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Nombre",nombre);
            registronuevo.put("Apellido",apellido);
            registronuevo.put("Edad",edad);

            long i = db.insert("Personas",null,registronuevo);
            if(i>0){
                Toast.makeText(this,"Registro Insertado!",Toast.LENGTH_LONG).show();

            }

        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_listar) {
            startActivity(new Intent(this,Segunda.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
