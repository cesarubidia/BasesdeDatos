package pe.entel.basesdedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cesar on 13/02/2015.
 */
public class BaseHelper extends SQLiteOpenHelper {

    String tabla= "CREATE TABLE Personas(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT,Edad INTEGER)";


    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
