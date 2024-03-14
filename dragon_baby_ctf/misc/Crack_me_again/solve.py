import py7zr
import os

def extract_7z(file_path, output_dir, password_file):
    with open(password_file, 'r') as f:
        passwords = f.readlines()

    for password in passwords:
        password = password.strip()
        try:
            with py7zr.SevenZipFile(file_path, mode='r', password=password) as z:
                z.extractall(path=output_dir)
            print(f"Successfully extracted with password: {password}")
            return  # Dừng vòng lặp nếu giải nén thành công
        except:
            print(f"Invalid password: {password}")

    print("Could not extract the file. None of the passwords worked.")
# Ví dụ sử dụng
file_path = './flag.7z'
output_dir = './flag'
password_file = './password'

extract_7z(file_path, output_dir, password_file)
