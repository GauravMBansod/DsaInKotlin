package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val strings = ArrayList<String>()
    strings.add("Hello")
    strings.add(":")
    strings.add("World")
    val encodedString = encode(strings)
    println(encodedString)
    val decodedString = decode(encodedString)
    println(decodedString)
}

fun encode(strings: ArrayList<String>) : String {
    var encodedString = StringBuilder()
    for (str in strings){
        encodedString.append(str.length.toString() + "#" + str)
    }
    return encodedString.toString()
}// TC: O(n), SC: O(n)

fun decode(str : String) :  ArrayList<String>{

    val decodedString = ArrayList<String>()

    var i = 0
    while ( i < str.length){
        var j = i
        while (str[j] != '#'){
            j++
        }

        val length = str.substring(i,j).toInt()
        decodedString.add(str.substring(j+1,j+1+length))
        i = j+1+length
    }

    return decodedString
}// TC: O(n), SC: O(n)

/*Practice - Encode and Decode Strings
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode.



Implement the encode and decode methods.

You are not allowed to solve the problem using any serialize methods (such as eval).



string encode(vector strs) {
  // ... your code
  return encoded_string;
}
vector decode(string s) {
  //... your code
  return strs;
}


Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"


Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"


Constraints:

1 <= strs.length <= 200

0 <= strs[i].length <= 200

strs[i] contains any possible characters out of 256 valid ASCII characters.



Follow up: Could you write a generalized algorithm to work on any possible set of characters?

*/