package au.edu.swin.sdmd.w05_myfirstintent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class multiplication(val firstInput: Int, val secondInput: Int) : Parcelable