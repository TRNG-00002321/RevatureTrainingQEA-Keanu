#reverses elements in a string
def reverseString(s):
    return s[::-1]

#checks if a string is a palindrome
def checkPalindrome(s):
    return s == s[::-1]

#finds substring within input string and returns index of the start of the substring
def findSubstring(s, p):
    #index = -1

    index = s.find(p[0])

    return index