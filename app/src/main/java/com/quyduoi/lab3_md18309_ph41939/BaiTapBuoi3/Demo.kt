package com.quyduoi.lab3_md18309_ph41939.BaiTapBuoi3

fun main () {
    // Khai bao va su dung lambda function
    val soA : Int? = 5
    val soB : Int? = 10
    val tong = tinhTong(soA!!, soB!!)
    val hieu = tinhHieu(soA!!, soB!!)
    val tenSv = "nguyễn sỹ quý"
    println("Tổng hai số $soA và $soB = $tong")
    println("Hiệu hai số $soA và $soB = $hieu")
    println("Bình phương số $soA = ${binhPhuong(soA)}")
    println("Thương của hai số $soA và $soB = ${tinhThuong(soA.toFloat(), soB.toFloat()) ()}")
    println("In hoa chuỗi $tenSv = ${inHoa(tenSv)}")
}

val tinhTong : (Int, Int) -> Int = {soA : Int, soB : Int -> (soA + soB)}

val tinhHieu = {soA : Int, soB : Int -> (soA - soB)}

val binhPhuong : (Int) -> Int = {it * it}

val tinhThuong = {soA : Float, soB : Float -> {
    if (soB == 0f) {
        "Số bị chia phải khác không!"
    } else {
        val c = soA / soB
        c
    }
}}

val inHoa : (String) -> (String) = String::uppercase