package com.hakanbaysal20.sayac

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppRef(var context:Context) {
    val Context.ds : DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("bilgiler")

    companion object{
        val SAYAC_KEY = intPreferencesKey("SAYAC")
        val SAYAC_2_KEY = intPreferencesKey("SAYAC2")
    }

    // 1. yöntem
    suspend fun sayac():Int{
        val p = context.ds.data.first()
      var sayac = p[SAYAC_KEY]
      if (sayac == null){
          context.ds.edit {
              it[SAYAC_KEY] = 0
          }
          return 0
      }else{
          context.ds.edit {
              it[SAYAC_KEY] = ++sayac
          }
          return sayac
      }

    }
    // 2. yöntem
    suspend fun kayitSayac(sayac:Int){
        context.ds.edit {
            it[SAYAC_2_KEY] = sayac
        }
    }
    suspend fun okuSayac():Int{
        val p = context.ds.data.first()
        return p[SAYAC_2_KEY] ?: 0
    }



}


