package com.example.rc3b2week

import android.os.Parcel
import android.os.Parcelable

class MyData() :Parcelable {

    lateinit var name: String
    lateinit var address: String

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyData> {
        override fun createFromParcel(parcel: Parcel): MyData {
            return MyData(parcel)
        }

        override fun newArray(size: Int): Array<MyData?> {
            return arrayOfNulls(size)
        }
    }
}