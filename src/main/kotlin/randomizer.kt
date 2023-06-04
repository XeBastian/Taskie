import kotlin.random.Random

class Randomizer {

    fun generateRandomString(): String {
        val charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-"
        val randomString = StringBuilder(6)

        for (i in 0 until 6) {
            val randomIndex = Random.nextInt(0, charPool.length)
            val randomChar = charPool[randomIndex]
            randomString.append(randomChar)
        }

        return randomString.toString()
    }
}