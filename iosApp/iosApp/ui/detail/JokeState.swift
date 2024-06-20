import shared

enum JokeState: Equatable {
    case initialLoading
    case data(
        jokeResponse: JokeResponse
    )
}
