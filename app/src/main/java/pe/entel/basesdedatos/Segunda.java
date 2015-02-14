package pe.entel.basesdedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;


public class Segunda extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        cargar();


    }
    public void cargar(){
        BaseHelper baseHelper= new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db= baseHelper.getReadableDatabase();
        if (db!=null) {
            Cursor c=db.rawQuery("select * from Personas",null);
            int cantidad =c.getCount();
            int i=0;
            String[] arreglo=new String[cantidad];

            if(c.moveToFirst()){
            do{

               String linea =c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getInt(3);
                
                arreglo[i] = linea;
                i++;
            }while (c.moveToNext());

         }

            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista = (ListView) findViewById(R.id.Lista);
            lista.setAdapter(adapter);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
