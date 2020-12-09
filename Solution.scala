/* 
    Given an integer, convert it to a roman numeral.
*/

object Solution {
    def intToRoman(num: Int): String = {
        if (num > 3999 || num < 1) {
            return ""
        }

        val numerals = List("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
        val values = List(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)

        var number = num
        var result = ""
        var index = 12

        while (number != 0) {
            var quo = number / values(index)
            
            for (i <- 1 to quo) {
                result = result + numerals(index)
            }

            number = number % values(index)
            index -= 1

            // println(s"quo = $quo number = $number result = $result index = $index")
        }

        return result
    }

    def main(args: Array[String]): Unit = {
        val num = 3999
        println(intToRoman(num))
    }
}