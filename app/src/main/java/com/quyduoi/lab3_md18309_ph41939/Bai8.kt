package com.quyduoi.lab3_md18309_ph41939

import java.util.*

class QuanLyTheMuon {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        val theMuon = danhSachTheMuon.find { it.maPhieuMuon == maPhieuMuon }
        theMuon?.let {
            danhSachTheMuon.remove(it)
            println("Đã xóa phiếu mượn có mã: $maPhieuMuon")
        } ?: run {
            println("Không tìm thấy phiếu mượn có mã: $maPhieuMuon")
        }
    }

    fun hienThiDanhSachTheMuon() {
        println("Danh sách các thẻ mượn sách:")
        danhSachTheMuon.forEachIndexed { index, theMuon ->
            println("${index + 1}. Mã phiếu mượn: ${theMuon.maPhieuMuon}\n" +
                    "   Ngày mượn: ${theMuon.ngayMuon}\n" +
                    "   Hạn trả: ${theMuon.hanTra}\n" +
                    "   Số hiệu sách: ${theMuon.soHieuSach}\n" +
                    "   Thông tin sinh viên: ${theMuon.sinhVien.hoTen} - Tuổi: ${theMuon.sinhVien.tuoi} - Lớp: ${theMuon.sinhVien.lop}")
        }
    }
}

fun isValidDate(date: String): Boolean {
    val regex = Regex("""^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])$""")
    return regex.matches(date)
}

fun isValidDueDate(startDate: String, dueDate: String): Boolean {
    val startDateParts = startDate.split("/")
    val dueDateParts = dueDate.split("/")

    val startDay = startDateParts[0].toInt()
    val startMonth = startDateParts[1].toInt()

    val dueDay = dueDateParts[0].toInt()
    val dueMonth = dueDateParts[1].toInt()

    if (dueMonth < startMonth || (dueMonth == startMonth && dueDay <= startDay)) {
        return false
    }

    return true
}

fun main() {
    val quanLyTheMuon = QuanLyTheMuon()
    val scanner = Scanner(System.`in`)

    var choice: Int
    do {
        println("\n--- Menu ---")
        println("1. Thêm thẻ mượn sách")
        println("2. Xoá thẻ mượn sách theo mã phiếu")
        println("3. Hiển thị danh sách thẻ mượn sách")
        println("0. Thoát")

        print("Nhập lựa chọn của bạn: ")
        while (true) {
            try {
                choice = scanner.nextInt()
                break
            } catch (e: Exception) {
                println("Lựa chọn không hợp lệ. Vui lòng nhập lại:")
                scanner.nextLine()
            }
        }

        when (choice) {
            1 -> {
                println("\n--- Thêm thẻ mượn sách ---")
                print("Nhập mã phiếu mượn: ")
                val maPhieuMuon = scanner.next()
                print("Nhập ngày mượn (dd/mm): ")
                var ngayMuon = scanner.next()
                while (!isValidDate(ngayMuon)) {
                    println("Ngày không hợp lệ. Vui lòng nhập lại.")
                    print("Nhập ngày mượn (dd/mm): ")
                    ngayMuon = scanner.next()
                }
                print("Nhập hạn trả (dd/mm): ")
                var hanTra = scanner.next()
                while (!isValidDate(hanTra) || !isValidDueDate(ngayMuon, hanTra)) {
                    if (!isValidDate(hanTra)) {
                        println("Ngày không hợp lệ. Vui lòng nhập lại.")
                        print("Nhập hạn trả (dd/mm): ")
                    } else {
                        println("Ngày hết hạn phải sau ngày mượn. Vui lòng nhập lại.")
                        print("Nhập hạn trả (dd/mm): ")
                    }
                    hanTra = scanner.next()
                }
                print("Nhập số hiệu sách: ")
                val soHieuSach = scanner.next()
                scanner.nextLine()
                print("Nhập họ tên sinh viên: ")
                val hoTen = scanner.nextLine()
                var tuoi: Int? = null
                while (tuoi == null) {
                    print("Nhập tuổi sinh viên: ")
                    val input = scanner.next()
                    if (input.toIntOrNull() != null) {
                        tuoi = input.toInt()
                    } else {
                        println("Tuổi phải là một số. Vui lòng nhập lại.")
                    }
                }
                scanner.nextLine()
                print("Nhập lớp sinh viên: ")
                val lop = scanner.nextLine()

                val sinhVien = SinhVien(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
                quanLyTheMuon.themTheMuon(theMuon)
                println("Thẻ mượn sách đã được thêm thành công!")
            }
            2 -> {
                println("\n--- Xoá thẻ mượn sách ---")
                print("Nhập mã phiếu mượn cần xoá: ")
                val maPhieuMuon = scanner.next()
                quanLyTheMuon.xoaTheMuon(maPhieuMuon)
            }
            3 -> {
                quanLyTheMuon.hienThiDanhSachTheMuon()
            }
            0 -> {
                println("Kết thúc chương trình.")
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    } while (choice != 0)
}
