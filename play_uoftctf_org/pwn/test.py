import requests

url = "https://uoftctf-no-code.chals.io/execute"  # Đặt URL của endpoint tại đây


code = b"\u0020"  # Đặt giá trị code tại đây

data = {"code": code}  # Đặt giá trị code trong một dictionary

response = requests.post(url, data=data)


result = response.json()
output = result.get("output")
print("Output:", output)
