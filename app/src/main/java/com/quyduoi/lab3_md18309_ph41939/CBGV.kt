package com.quyduoi.lab3_md18309_ph41939

class CBGV (
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSo: String,
    var luongCung: Int,
    var luongThuong: Int,
    var tienPhat: Int
) : Nguoi(hoTen, tuoi, queQuan, maSo) {
    var luongThucLinh: Int = 0

    init {
        tinhLuongThucLinh()
    }

    private fun tinhLuongThucLinh() {
        luongThucLinh = luongCung + luongThuong - tienPhat
    }
}