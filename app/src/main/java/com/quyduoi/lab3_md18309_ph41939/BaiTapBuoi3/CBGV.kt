package com.quyduoi.lab3_md18309_ph41939.BaiTapBuoi3

class CBGV(
    hoTen: String,
    tuoi: Int?,
    queQuan: String?,
    maSo: String,
    val luongCung: Float,
    val luongThuong: Float? = 0f,
    val tienPhat: Float? = 0f
) : Nguoi(hoTen, tuoi, queQuan, maSo) {

    val luongThucLinh: Float

    init {
        luongThucLinh = tinhLuongThucLinh()
    }

    private fun tinhLuongThucLinh(): Float {
        return luongCung + (luongThuong ?: 0f) - (tienPhat ?: 0f)
    }
}