import shared

enum DatabaseUiState: Equatable {
    case idle
    case data(
        name: String
    )
}
