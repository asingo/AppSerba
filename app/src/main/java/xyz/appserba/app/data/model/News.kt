package xyz.appserba.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val FID: Int = 0,
    val Kode_Provi: Int = 0,
    val Provinsi: String = "",
    val Kasus_Posi: Int = 0,
    val Kasus_Semb: Int = 0,
    val Kasus_Meni: Int = 0,
    val pic: String = "https://bulukumbakab.go.id/uploads/images/image_750x_5edccf1ed6f85.jpg"
) : Parcelable
