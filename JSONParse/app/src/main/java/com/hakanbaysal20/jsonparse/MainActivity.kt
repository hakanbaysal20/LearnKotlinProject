package com.hakanbaysal20.jsonparse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonFlagsResult =
            "{\"bayraklar\":[{\"bayrak_id\":\"1\",\"bayrak_ad\":\"T\\u00fcrkiye\",\"bayrak_resim\":\"turkiye\"},{\"bayrak_id\":\"2\",\"bayrak_ad\":\"Almanya\",\"bayrak_resim\":\"almanya\"},{\"bayrak_id\":\"3\",\"bayrak_ad\":\"\\u0130talya\",\"bayrak_resim\":\"italya\"},{\"bayrak_id\":\"4\",\"bayrak_ad\":\"Fransa\",\"bayrak_resim\":\"fransa\"},{\"bayrak_id\":\"5\",\"bayrak_ad\":\"Hollanda\",\"bayrak_resim\":\"hollanda\"},{\"bayrak_id\":\"6\",\"bayrak_ad\":\"\\u0130spanya\",\"bayrak_resim\":\"ispanya\"},{\"bayrak_id\":\"7\",\"bayrak_ad\":\"Slovenya\",\"bayrak_resim\":\"slovenya\"},{\"bayrak_id\":\"8\",\"bayrak_ad\":\"Slovakya\",\"bayrak_resim\":\"slovakya\"},{\"bayrak_id\":\"9\",\"bayrak_ad\":\"Estonya\",\"bayrak_resim\":\"estonya\"},{\"bayrak_id\":\"10\",\"bayrak_ad\":\"Rusya\",\"bayrak_resim\":\"rusya\"},{\"bayrak_id\":\"11\",\"bayrak_ad\":\"Bulgaristan\",\"bayrak_resim\":\"bulgaristan\"},{\"bayrak_id\":\"12\",\"bayrak_ad\":\"Romanya\",\"bayrak_resim\":\"romanya\"},{\"bayrak_id\":\"13\",\"bayrak_ad\":\"Norve\\u00e7\",\"bayrak_resim\":\"norvec\"},{\"bayrak_id\":\"14\",\"bayrak_ad\":\"Yunanistan\",\"bayrak_resim\":\"yunanistan\"},{\"bayrak_id\":\"15\",\"bayrak_ad\":\"Bosna Hersek\",\"bayrak_resim\":\"bosnahersek\"}],\"success\":1}"
        val jsonFilmsResult =
            "{\"filmler\":[{\"film_id\":\"1\",\"film_ad\":\"Interstellar\",\"film_yil\":\"2015\",\"film_resim\":\"interstellar.png\",\"category\":{\"category_id\":\"4\",\"category_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"2\",\"film_ad\":\"Inception\",\"film_yil\":\"2010\",\"film_resim\":\"inception.png\",\"category\":{\"category_id\":\"4\",\"category_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"3\",\"film_ad\":\"The Pianist\",\"film_yil\":\"2002\",\"film_resim\":\"thepianist.png\",\"category\":{\"category_id\":\"3\",\"category_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"4\",\"yonetmen_ad\":\"Roman Polanski\"}},{\"film_id\":\"4\",\"film_ad\":\"Anadoluda\",\"film_yil\":\"2011\",\"film_resim\":\"birzamanlaranadoluda.png\",\"category\":{\"category_id\":\"3\",\"category_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"3\",\"yonetmen_ad\":\"Nuri Bilge Ceylan\"}},{\"film_id\":\"5\",\"film_ad\":\"The Hateful Eight\",\"film_yil\":\"2015\",\"film_resim\":\"thehatefuleight.png\",\"category\":{\"category_id\":\"1\",\"category_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}},{\"film_id\":\"18\",\"film_ad\":\"Django\",\"film_yil\":\"2013\",\"film_resim\":\"django.png\",\"category\":{\"category_id\":\"1\",\"category_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}}],\"success\":1}"


        /*
        // flags
        try {
            val jsonObject = JSONObject(jsonFlagsResult)
            val flagsList = jsonObject.getJSONArray("bayraklar")

            for (i in 0 until flagsList.length()){
                val f = flagsList.getJSONObject(i)
                val flag_id = f.getInt("bayrak_id")
                val flag_name = f.getString("bayrak_ad")
                val flag_image = f.getString("bayrak_resim")

                Log.e("id",flag_id.toString())
                Log.e("ad",flag_name)
                Log.e("resim",flag_image)

            }

        }catch (e:JSONException){
            e.printStackTrace()
        }*/
        //films
        /*   try {
            val jsonObject = JSONObject(jsonFilmsResult)
            val filmList = jsonObject.getJSONArray("filmler")
            for (i in 0 until filmList.length()){
                val film = filmList.getJSONObject(i)
                
                //category
                val category = film.getJSONObject("category")
                val category_id = category.getInt("category_id")
                val category_name = category.getString("category_ad")
                //direction

                val direction = film.getJSONObject("yonetmen")
                val direction_id = direction.getInt("yonetmen_id")
                val direction_ad = direction.getString("yonetmen_ad")


                val film_name = film.getString("film_ad")
                val film_id = film.getInt("film_id")
                val film_year = film.getInt("film_yil")
                val film_image = film.getString("film_resim")

                Log.e("category",category_name)
                Log.e("direction",direction_ad)
                Log.e("film",film_name)
                Log.e("year",film_year.toString())
                Log.e("image",film_image)
            }

        }catch (e:JSONException){
            e.printStackTrace()
        }*/


      //  getUser()
        searchUser()
    }

    fun deleteUser() {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php"
        val request = object : StringRequest(Method.POST, baseUrl, Response.Listener { response ->
            Log.e("Silme işlemi cevap", response)

        }, Response.ErrorListener { error ->
            error.printStackTrace()
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_id"] = "16701"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun addUser() {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"
        val request = object : StringRequest(Method.POST, baseUrl, Response.Listener { response ->
            Log.e("kişi eklendi mi", response)
        }, Response.ErrorListener { error ->
            error.printStackTrace()
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_ad"] = "Hakan Baysal"
                params["kisi_tel"] = "555555"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun updateUser() {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php"
        val request = object : StringRequest(Method.POST, baseUrl, Response.Listener { response ->
            Log.e("Güncelleme işlemi cevap", response)

        }, Response.ErrorListener { error ->
            error.printStackTrace()
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_id"] = "16759"
                params["kisi_ad"] = "Hakann Baysall"
                params["kisi_tel"] = "5555555555555555555"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
    fun getUser() {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"
        val request = StringRequest(Request.Method.GET, baseUrl, Response.Listener { response ->
            Log.e("Veri Okuma işlemi cevap", response)
            try {
                val jsonObject = JSONObject(response)
                val list = jsonObject.getJSONArray("kisiler")
                for (i in 0 until list.length()) {
                    val person = list.getJSONObject(i)
                    val person_id = person.getInt("kisi_id")
                    val person_name = person.getString("kisi_ad")
                    val person_no = person.getString("kisi_tel")
                    Log.e("Kişi id ", person_id.toString())
                    Log.e("Kisi ad", person_name)
                    Log.e("Kisi tel", person_no)
                    Log.e("***************", "*********************")

                }

            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }, Response.ErrorListener { error ->
            error.printStackTrace()
        })
       Volley.newRequestQueue(this@MainActivity).add(request)
    }
    fun searchUser() {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php"
        val request = object : StringRequest(Method.POST,baseUrl,Response.Listener { response ->
            Log.e("response",response)
            try {
                val jsonObject = JSONObject(response)
                val personList = jsonObject.getJSONArray("kisiler")
                for (i in 0 until personList.length()){
                    val person = personList.getJSONObject(i)
                    val person_id =  person.getInt("kisi_id")
                    val person_name = person.getString("kisi_ad")
                    val person_no = person.getString("kisi_tel")
                    Log.e("person_id",person_id.toString())
                    Log.e("person_name",person_name)
                    Log.e("person_Tel",person_no)
                    Log.e("*****","***********/*/************")
                }

            }catch (e:JSONException){
                e.printStackTrace()
            }

        },Response.ErrorListener {error -> error.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kisi_ad"] = "Hakan"
                return params
            }

        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}
