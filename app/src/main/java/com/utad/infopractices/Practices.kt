package com.utad.infopractices

import android.os.Parcel
import android.os.Parcelable


data class Practices(val Image : Int, val Company : String, val Time : String, val locationImage : Int, val locationText : String, val description : String) :

    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Practices> {
        override fun createFromParcel(parcel: Parcel): Practices {
            return Practices(parcel)
        }

        override fun newArray(size: Int): Array<Practices?> {
            return arrayOfNulls(size)
        }
    }
}
