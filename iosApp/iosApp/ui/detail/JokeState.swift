import shared

enum JokeState: Equatable {
    case initialLoading
    case data(
        joke: Joke
    )
}
