package com.example.agenda

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE, null, 1) {
    companion object{
        const val TABLE_NAME = "friends"
        const val FIELD_ID = "_id"
        const val FIELD_NAME = "nombre"
        const val FIELD_SUBNAME ="apellidos"
        const val FIELD_EMAIL = "email"
        const val FIELD_PHONE = "telefono"
    }
    // Creo una tabla utilizando un comando SQL
    override fun onCreate(db: SQLiteDatabase?) {
        // Esto debe hacerse dentro de un bloque try-catch
        val commandCreate = "CREATE TABLE $TABLE_NAME " +
                "($FIELD_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$FIELD_NAME TEXT,"+
                "$FIELD_SUBNAME TEXT," +
                "$FIELD_EMAIL TEXT,"+
                "$FIELD_PHONE TEXT)"
        db!!.execSQL(commandCreate)
    }
    // Se llamará a esta función cuando se actualice la versión de la DB
    // Por ejemplo cuando hay que añadir más campos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Ejemplo
        val commandDelete = "DROP TABLE IF EXISTS $TABLE_NAME"
        db!!.execSQL(commandDelete)
        onCreate(db)
    }

    // Creamos una función para AÑADIR datos
    fun addData (nombre: String, apellidos:String, email: String ,telefono:String) {
        // ContentValues tiene una estructura de tipo Map()
        val data = ContentValues()
        data.put(FIELD_NAME, nombre)
        data.put(FIELD_SUBNAME,apellidos)
        data.put(FIELD_EMAIL, email)
        data.put(FIELD_PHONE, telefono)
        // Abro la DB en modo ESCRITURA
        val db = this.writableDatabase
        db.insert("friends", null,data)
        db.close()
    }

    // Creamos una función para BORRAR datos
    fun deleteData (id: String) : Int {
        val args = arrayOf(id)

        val db = this.writableDatabase
        // La ejecución de este comando devuelve el número de registros afectados
        val affectedRows = db.delete(TABLE_NAME, "$FIELD_ID = ?",args)
        // Alternativamente. Pero esta forma no devuelve nada
        // db.execSQL("DELETE FROM friends WHERE _id = ?", args)
        db.close()
        return affectedRows
    }

    // Creamos una función para MODIFICAR datos
    fun updateData (id:String, name: String, apellido: String, email: String, telefono: String ) {
        val args = arrayOf(id)

        // ContentValues tiene una estructura de tipo Map()
        val data = ContentValues()
        data.put(FIELD_ID, id)
        data.put(FIELD_NAME,name)
        data.put(FIELD_SUBNAME, apellido)
        data.put(FIELD_EMAIL, email)
        data.put(FIELD_PHONE, telefono)
        // Abro la DB en modo ESCRITURA
        val db = this.writableDatabase
        // La ejecución de este comando devuelve el número de registros afectados
        db.update(TABLE_NAME, data, "$FIELD_ID = ?",args)
        db.close()
    }

}