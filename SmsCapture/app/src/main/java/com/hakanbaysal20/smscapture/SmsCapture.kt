package com.hakanbaysal20.smscapture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast

class SmsCapture: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val b = intent?.extras
        if (b != null){
            val pdusObj = b.get("pdus") as Array<Any>

            for (i in pdusObj.indices){
                val currenMessage:SmsMessage
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // ANDROID sürümü mden büyükse
                    val format = b.getString("format")
                    currenMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray,format)

                }else{
                    currenMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                }
                val telNo = currenMessage.displayOriginatingAddress
                val message = currenMessage.displayMessageBody
                Toast.makeText(context,"$telNo - $message",Toast.LENGTH_SHORT).show()
            }
        }
    }
}