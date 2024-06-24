import shared

enum JokeUiState: Equatable {
    case loading
    case data(
        joke: Joke
    )
}
