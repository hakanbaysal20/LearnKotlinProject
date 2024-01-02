package com.hakanbaysal20.preferencesdatastoreusages

import android.content.Context
import android.preference.Preference
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import java.util.ArrayList

class AppPref(var context:Context) {
    val Context.ds: DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object {
        val AD_KEY = stringPreferencesKey("AD")
        val YAS_KEY = intPreferencesKey("YAS")
        val BOY_KEY = floatPreferencesKey("BOY")
        val BEKARMI_KEY = booleanPreferencesKey("BEKARMI")
        val ARKADAS_LISTE_KEY = stringSetPreferencesKey("ARKADAS_LISTE")
    }

    suspend fun kayitKisi(kisi: Kisi) {
        context.ds.edit {
            it[AD_KEY] = kisi.ad
            it[YAS_KEY] = kisi.yas
            it[BOY_KEY] = kisi.boy
            it[BEKARMI_KEY] = kisi.bekarMi
        }
    }
    suspend fun kayitArkadaslarListesi(list:Set<String>){
        context.ds.edit {
            it[ARKADAS_LISTE_KEY] = list
        }
    }
    suspend fun okuArkadasListesi():Set<String>?{
        val p = context.ds.data.first()
        return p[ARKADAS_LISTE_KEY]
    }

    suspend fun okuKisi(): Kisi {
        val p = context.ds.data.first()
        return Kisi(p[AD_KEY] ?:"isim yok",p[YAS_KEY]?:0,p[BOY_KEY]?:0.0f,p[BEKARMI_KEY]?:false)
    }

    suspend fun silKisi() {
        context.ds.edit {
            it.remove(AD_KEY)
            it.remove(YAS_KEY)
            it.remove(BOY_KEY)
            it.remove(BEKARMI_KEY)
        }
    }
    suspend fun silArkadasListesi(){
        context.ds.edit {
            it.remove(ARKADAS_LISTE_KEY)
        }
    }

}