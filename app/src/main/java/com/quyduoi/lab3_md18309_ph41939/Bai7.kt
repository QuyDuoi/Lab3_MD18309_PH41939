import com.quyduoi.lab3_md18309_ph41939.CBGV
import java.util.Scanner

class QuanLyCBGV {
    private val danhSachCBGV = mutableListOf<CBGV>()

    fun themCBGV(giaoVien: CBGV) {
        danhSachCBGV.add(giaoVien)
    }

    fun xoaCBGV(maSoGV: String) {
        val giaoVien = danhSachCBGV.find { it.maSo == maSoGV }
        if (giaoVien == null) {
            println("Không tìm thấy giáo viên có mã số $maSoGV trong danh sách!")
        } else {
            danhSachCBGV.remove(giaoVien)
            println("Giáo viên có mã số $maSoGV đã được xóa khỏi danh sách!")
        }
    }

    fun hienThiDS() {
        println("Danh sách giáo viên:")
        danhSachCBGV.forEach {
            println("Họ tên: ${it.hoTen}")
            println("Tuổi: ${it.tuoi ?: "Không có thông tin"}")
            println("Quê quán: ${it.queQuan ?: "Không có thông tin"}")
            println("Mã số: ${it.maSo}")
            println("Lương cứng: ${String.format("%.2f", it.luongCung)}")
            println("Lương thưởng: ${it.luongThuong?.let { luong -> String.format("%.2f", luong) } ?: "Không có thông tin"}")
            println("Tiền phạt: ${it.tienPhat?.let { phat -> String.format("%.2f", phat) } ?: "Không có thông tin"}")
            println("Lương thực lĩnh: ${String.format("%.2f", it.luongThucLinh)}")
            println("------------")
        }
    }
}

fun main() {
    val quanLy = QuanLyCBGV()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n--- Menu ---")
        println("1. Thêm giáo viên")
        println("2. Xóa giáo viên")
        println("3. Hiển thị danh sách giáo viên")
        println("0. Thoát")

        print("Nhập lựa chọn của bạn: ")
        val choice = scanner.nextLine().toIntOrNull()

        when (choice) {
            1 -> {
                println("\n--- Thêm giáo viên ---")

                val hoTen = getStringInput(scanner, "Nhập họ tên: ")

                val tuoi = getOptionalIntInput(scanner, "Nhập tuổi: ")

                val queQuan = checkRong(scanner, "Nhập quê quán: ")

                val maSo = getStringInput(scanner, "Nhập mã số: ")

                val luongCung = getFloatInput(scanner, "Nhập lương cứng: ")

                val luongThuong = getOptionalFloatInput(scanner, "Nhập lương thưởng: ")

                val tienPhat = getOptionalFloatInput(scanner, "Nhập tiền phạt: ")

                val giaoVien = CBGV(hoTen, tuoi, queQuan, maSo, luongCung, luongThuong, tienPhat)
                quanLy.themCBGV(giaoVien)
                println("Giáo viên đã được thêm thành công!")
            }
            2 -> {
                println("\n--- Xóa giáo viên ---")

                val maSoGV = getStringInput(scanner, "Nhập mã số giáo viên cần xóa: ")

                quanLy.xoaCBGV(maSoGV)
            }
            3 -> {
                quanLy.hienThiDS()
            }
            0 -> {
                println("Kết thúc chương trình.")
                break
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    }
}

fun getStringInput(scanner: Scanner, prompt: String): String {
    while (true) {
        print(prompt)
        val input = scanner.nextLine()
        if (input.isNotBlank()) return input
        println("Giá trị không được để trống. Vui lòng nhập lại.")
    }
}

fun checkRong (scanner: Scanner, prompt: String) : String? {
    println(prompt)
    val input = scanner.nextLine()
    if (input.isBlank()) {
        return null
    } else {
        return input.toString()
    }
}
fun getOptionalIntInput(scanner: Scanner, prompt: String): Int? {
    while (true) {
        print(prompt)
        val input = scanner.nextLine()
        if (input.isBlank()) return null
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            println("Giá trị không hợp lệ. Vui lòng nhập lại.")
        }
    }
}

fun getFloatInput(scanner: Scanner, prompt: String): Float {
    while (true) {
        print(prompt)
        val input = scanner.nextLine()
        try {
            return input.toFloat()
        } catch (e: NumberFormatException) {
            println("Giá trị không hợp lệ. Vui lòng nhập lại.")
        }
    }
}

fun getOptionalFloatInput(scanner: Scanner, prompt: String): Float? {
    while (true) {
        print(prompt)
        val input = scanner.nextLine()
        if (input.isBlank()) return null
        try {
            return input.toFloat()
        } catch (e: NumberFormatException) {
            println("Giá trị không hợp lệ. Vui lòng nhập lại.")
        }
    }
}
