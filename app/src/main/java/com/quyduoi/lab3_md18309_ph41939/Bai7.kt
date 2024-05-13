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
            println("${it.hoTen} - Mã số: ${it.maSo} - Lương thực lĩnh: ${it.luongThucLinh}")
        }
    }
}

fun main() {
    val quanLy = QuanLyCBGV()
    val scanner = Scanner(System.`in`)

    var choice: Int
    do {
        println("\n--- Menu ---")
        println("1. Thêm giáo viên")
        println("2. Xóa giáo viên")
        println("3. Hiển thị danh sách giáo viên")
        println("0. Thoát")

        print("Nhập lựa chọn của bạn: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("\n--- Thêm giáo viên ---")
                print("Nhập họ tên: ")
                val hoTen = scanner.nextLine()
                scanner.nextLine()
                print("Nhập tuổi: ")
                val tuoi = scanner.nextInt()
                scanner.nextLine()
                print("Nhập quê quán: ")
                val queQuan = scanner.nextLine()
                scanner.nextLine()
                print("Nhập mã số: ")
                val maSo = scanner.nextLine()
                print("Nhập lương cứng: ")
                val luongCungInput = scanner.nextLine()
                val luongCung = if (luongCungInput.isNotBlank()) luongCungInput.toInt() else 0
                print("Nhập lương thưởng: ")
                val luongThuongInput = scanner.nextLine()
                val luongThuong = if (luongThuongInput.isNotBlank()) luongThuongInput.toInt() else 0
                print("Nhập tiền phạt: ")
                val tienPhatInput = scanner.nextLine()
                val tienPhat = if (tienPhatInput.isNotBlank()) tienPhatInput.toInt() else 0

                val giaoVien = CBGV(hoTen, tuoi, queQuan, maSo, luongCung, luongThuong, tienPhat)
                quanLy.themCBGV(giaoVien)
                println("Giáo viên đã được thêm thành công!")
            }
            2 -> {
                println("\n--- Xóa giáo viên ---")
                print("Nhập mã số giáo viên cần xóa: ")
                val maSoGV = scanner.nextLine()
                scanner.nextLine()

                quanLy.xoaCBGV(maSoGV)
            }
            3 -> {
                quanLy.hienThiDS()
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
