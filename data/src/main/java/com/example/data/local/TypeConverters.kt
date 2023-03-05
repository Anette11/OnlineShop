package com.example.data.local

import android.net.Uri
import androidx.room.TypeConverter

class TypeConverters {

    @TypeConverter
    fun convertUriToString(uri: Uri?): String? =
        uri?.toString()

    @TypeConverter
    fun convertStringToUri(string: String?): Uri? =
        if (string == null) null else Uri.parse(string)
}