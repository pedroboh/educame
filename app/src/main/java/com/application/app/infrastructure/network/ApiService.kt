package com.lastcode.educame.infrastructure.network

import android.os.Build
import androidx.annotation.RequiresApi
import com.application.app.infrastructure.adapters.CustomDateAdapter
import com.squareup.moshi.*
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


//TODO Troque a url abaixo pela url da a api que voce publicou
private const val BASE_URL =
//    "http://ip172-18-0-36-cc7sndld48eg00dtc9v0-8080.direct.labs.play-with-docker.com/"
    "https://educaappwebapi-jgh3opyuea-rj.a.run.app/"
//singleton
object RetrofitHelper {

    fun getInstance(): Retrofit {
        val moshi = Moshi.Builder()
//            .add(Date::class.java, Rfc3339DateJsonAdapter().lenient().nullSafe())
//            .add(Date::class.java, CustomDateAdapter().nullSafe())
            .add(KotlinJsonAdapterFactory())
            .build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))

            .baseUrl(BASE_URL)
            .build()

        return retrofit
    }
}




//@RequiresApi(Build.VERSION_CODES.O)
//val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//@RequiresApi(Build.VERSION_CODES.O)
//val date = LocalDate.parse("2019-08-07 09:00:00" , firstApiFormat)
//
//@RequiresApi(Build.VERSION_CODES.O)
//@ToJson
//@Synchronized
//fun dateToJson(d: Date): String? {
//
//
//}


//Log.d("parseTesting", date.dayOfWeek.toString()) // prints Wednesday
//Log.d("parseTesting", date.month.toString()) // prints August
//
//
//
//object customDateAdapter{
//    val dateFormat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss.SSS")
//    } else {
//        TODO("VERSION.SDK_INT < O")
//    }
//}


//private fun DateTimeFormatter.format(d: Date?): String? {
//    return dateFormat.fo
//}
//val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

//object customDateAdapter  {
//    val dateFormat : DateFormat
//    {
//        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//    }
//
//    @ToJson synchronized String dateToJson(Date d) {
//        return dateFormat.format(d);
//    }
//
//    @FromJson synchronized Date dateToJson(String s) throws ParseException {
//        return dateFormat.parse(s);
//    }
//}
//
//Moshi moshi = new Moshi.Builder()
//.add(customDateAdapter)
//.build();
//
//JsonAdapter<Date> dateAdapter = moshi.adapter(Date.class);
//assertThat(dateAdapter.fromJson("\"1985-04-12T23:20\""))
//.isEqualTo(newDate(1985, 4, 12, 23, 20, 0, 0, 0));