# Phân tích chiến lược xử lý ngoại lệ

## Bài toán

Hệ thống cần:
1. Trả JSON lỗi chuẩn cho Frontend
2. Ghi log lỗi nội bộ để debug
3. Không lộ StackTrace ra ngoài API
4. Không làm rối code Service bằng try-catch

---

# So sánh @RestControllerAdvice và @AfterThrowing

| Tiêu chí | @RestControllerAdvice | @AfterThrowing |
|---|---|---|
| Phạm vi hoạt động | Tầng Web/API | Tầng Service/AOP |
| Mục đích chính | Chuẩn hóa HTTP Response | Audit log / ghi nhận lỗi |
| Can thiệp JSON Response | Có | Không |
| Đổi HTTP Status Code | Có | Không |
| Ghi log ngầm | Có thể nhưng không tối ưu | Rất phù hợp |
| Hoạt động sau khi Exception xảy ra | Có | Có |
| Phù hợp cho Frontend | Rất phù hợp | Không |
| Phù hợp cho Debug nội bộ | Trung bình | Rất phù hợp |
| Làm sạch tầng Service | Có | Có |

---

# Kết luận lựa chọn

## @RestControllerAdvice dùng để:
- gom lỗi toàn cục
- trả JSON chuẩn
- đổi HTTP status
- bảo vệ API không lộ stacktrace

Ví dụ:
{
"status": 404,
"message": "Không tìm thấy khóa học"
}

---

## @AfterThrowing dùng để:
- ghi log bí mật
- audit lỗi nội bộ
- debug hệ thống
- theo dõi method gây lỗi

Frontend sẽ KHÔNG thấy các log này.

---

# Giải pháp tối ưu

Kết hợp cả hai:

1. @AfterThrowing
   → ghi log nội bộ ở tầng service

2. @RestControllerAdvice
   → trả JSON sạch cho client

=> vừa bảo mật vừa dễ debug.