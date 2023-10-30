package com.example.kupujemprodajemaplikacija.models

import android.os.Parcel
import android.os.Parcelable

class Ad() : Parcelable{
    val ad_id: Int? = null
    val currency: String? = null
    val favorite_count: Int? = null
    val is_following_ad: Boolean? = null
    val location_name: String? = null
    val name: String? = null
    val photo1_tmb_300x300: String? = null
    val posted: String? = null
    val price: String? = null
    val price_fixed: String? = null

    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ad> {
        override fun createFromParcel(parcel: Parcel): Ad {
            return Ad(parcel)
        }

        override fun newArray(size: Int): Array<Ad?> {
            return arrayOfNulls(size)
        }
    }
}

data class AdList(val ads: List<Ad>)