def reverseString(s):
    return s[::-1]

def checkPalindrome(s):
    return s == s[::-1]

def findSubstring(s, p):
    #index = -1

    index = s.find(p[0])

    return index