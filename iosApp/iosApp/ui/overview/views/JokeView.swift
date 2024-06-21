import SwiftUI
import shared

struct JokeView: View {
    var jokeUiState: JokeUiState
    
    init(jokeUiState: JokeUiState) {
        self.jokeUiState = jokeUiState
    }
    var body: some View {
        Group {
            switch jokeUiState {
            case is JokeUiStateIdle:
                Text("Press the button and laugh :)")
            case is JokeUiStateLoading:
                ProgressView()
            case let dataState as JokeUiStateData:
                JokeTextView(jokeResponse: dataState.jokeResponse)
            default:
                Text("")
            }
        }
    }
}
