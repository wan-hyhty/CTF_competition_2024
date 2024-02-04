#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <sstream>
#include <iomanip>
#include <vector>

std::vector<char> keyArr = {'k', 'e', 'y', '_', '0', 'r', '_', 'k', '3', 'y'};
std::string enc = "O43ald3a482d3O3452Od34Oa262655l337";


std::string notDoingAnything(std::string str) {
    std::replace(str.begin(), str.end(), 'O', '0');
    std::replace(str.begin(), str.end(), 'l', '1');
    return str;
}

std::string encryptDecrypt(const std::vector<char>& cArr, const std::vector<uint8_t>& bArr) {
    std::string result;
    for (size_t i = 0; i < bArr.size(); i++) {
        result += static_cast<char>(bArr[i] ^ cArr[i % cArr.size()]);
    }
    return result;
}

std::vector<uint8_t> hexStringToByteArray(const std::string& str) {
    std::vector<uint8_t> bArr;
    for (size_t i = 0; i < str.length(); i += 2) {
        std::string byteString = str.substr(i, 2);
        uint8_t byteValue = static_cast<uint8_t>(std::stoi(byteString, nullptr, 16));
        bArr.push_back(byteValue);
    }
    return bArr;
}

std::string sha1Encrypt(const std::string& str) {
    // Implement your SHA1 encryption logic here
    // This is just a placeholder
    return str;
}

void checkFlag(const std::string& str) {

    std::cout << (encryptDecrypt(keyArr, hexStringToByteArray(notDoingAnything(enc))));
}

int main() {
    // std::string input;
    std::cout << "Enter flag: ";
    checkFlag(enc);
    std::string input = "a6601b44d0951ee66730d4aff230a795de18e254";
std::string substr = input.substr(10, input.length() - 1);
std::cout << substr << std::endl;

    return 0;
}