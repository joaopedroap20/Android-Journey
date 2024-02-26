package com.example.freestyle

//GENERICS //OBJECTS //EXTENSIONS
class GenericsObjectsExtentions{
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

class Quiz : ProgressPrintable {

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    val question1 =
        Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 =
        Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}


val Quiz.StudentProgress.timesFarded: Int
    get() = total


interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


fun main() {
    Quiz().apply {
        printQuiz()
    }
    Quiz().printProgressBar()
    }
}

//HIGH-ORDER FUNCTIONS WITH COLLECTIONS
class highOrderFunctionsWIthCollections {

    class Cookie(
        val name: String,
        val softBaked: Boolean,
        val hasFilling: Boolean,
        val price: Double
    )

    val words = listOf<String>(
        "shmimbo", "muh'kwam'bi", "caca", "glumbo"
    )
    val cookies = listOf(
        Cookie(
            name = "Chocolate Chip",
            softBaked = false,
            hasFilling = false,
            price = 1.69
        ),
        Cookie(
            name = "Banana Walnut",
            softBaked = true,
            hasFilling = false,
            price = 1.49
        ),
        Cookie(
            name = "Vanilla Creme",
            softBaked = false,
            hasFilling = true,
            price = 1.59
        ),
        Cookie(
            name = "Chocolate Peanut Butter",
            softBaked = false,
            hasFilling = true,
            price = 1.49
        ),
        Cookie(
            name = "Snickerdoodle",
            softBaked = true,
            hasFilling = false,
            price = 1.39
        ),
        Cookie(
            name = "Blueberry Tart",
            softBaked = true,
            hasFilling = true,
            price = 1.79
        ),
        Cookie(
            name = "Sugar and Sprinkles",
            softBaked = false,
            hasFilling = false,
            price = 1.39
        )
    )

val groupedMenu = cookies.groupBy {
    it.softBaked
}
val softBakedMenu = groupedMenu[true] ?: listOf()
val crunchyMenu = groupedMenu[false] ?: listOf()


val fullMenu = cookies.map {
    "${it.name} - $${it.price}"

}
val wordslol = words.fold("") { acc, s -> if (acc.isEmpty()) s else "$acc$s"}

val totalPrice = cookies.fold(0.0) {
    total, cookie -> total + cookie.price
}

    fun main() {

        println("Menu item:")

        println("Soft cookies:")
        softBakedMenu.forEach {
            println("${it.name} - $${it.price}")
        }
        println()
        println("Crunchy cookies:")
        crunchyMenu.forEach {
            println("${it.name} - $${it.price}")
        }

        println(wordslol)
        println(totalPrice)
    }
}

//PRACTICE
//class practiceClassesandCollections {

/*
//TASK 1
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}
class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart, //not suppose to be enum class with each stage of the day cycle?
    val durationInMinutes: Int
)
    val event1: Event = Event(title="Study Kotlin", description="Commit to studying Kotlin at least 15 minutes per day.", daypart="Evening", durationInMinutes=15)
fun main() {

}
*/

/*
//TASK 1 solution
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int,
)
*/
/*
//TASK 3
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
/*
val eventList = listOf(
        Event(
            title = "Wake up",
            description = "Time to get up",
            daypart = Daypart.MORNING,
            durationInMinutes = 0),

        Event(
            title = "Eat breakfast",
            daypart = Daypart.MORNING,
            durationInMinutes = 15),

        Event(
            title = "Learn about Kotlin",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 30),

        Event(
            title = "Practice Compose",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 60),

        Event(
            title = "Watch latest DevBytes video",
            daypart = Daypart.AFTERNOON,
            durationInMinutes = 10),

        Event(
            title = "Check out latest Android Jetpack library",
            daypart = Daypart.EVENING,
            durationInMinutes = 45)
)
*/

val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

val eventsList = mutableListOf<Event>( event1, event2, event3, event4, event5, event6 )

fun main(){
    println("Scheduled Events: ")
    println()
    eventsList.forEach {
        println( it.title)
    }
}
*/

//TASK 4

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)


val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

val groupedEvent = events.groupBy {
    it.durationInMinutes < 60
}
val shortEvents = groupedEvent[true] ?: listOf()
val longEvents = groupedEvent[false] ?: listOf()
//OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR

val shortEventFiltered = events.filter { it.durationInMinutes < 60 }

//TASK 5
val morningEvents = events.filter { it.daypart == Daypart.MORNING }
val afternoonEvents = events.filter { it.daypart == Daypart.AFTERNOON }
val eveningEvents = events.filter { it.daypart == Daypart.EVENING }
//OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR OR
val groupedEvents = events.groupBy { it.daypart }

//TASK 7
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    }else {
        "long"
    }

val colors = listOf("Red", "Green", "Blue")


fun main() {

    println(colors.get(2))
    println("You have ${shortEventFiltered.size} short events.")
    println("Morning: ${morningEvents.size}")
    println("Afternoon: ${afternoonEvents.size}")
    println("Evening: ${eveningEvents.size}")
    println()
    groupedEvents.forEach{(daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    println()
    //TASK 6
    println("Last even of the day: ${events.last().title}")
    println()
    //TASK 7
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}
//}