import SwiftUI
import shared

struct MainContent: View {
    var mainUiState: MainUiState
    
    init(mainUiState: MainUiState) {
        self.mainUiState = mainUiState
    }
    var body: some View {
        GeometryReader { geo in
            Group {
                switch mainUiState {
                case is MainUiStateIdle:
                    JokeExplanation()
                case is MainUiStateLoading:
                    ProgressView()
                case let dataState as MainUiStateData:
                    JokeView(jokeResponse: dataState.jokeResponse)
                default:
                    Text("")
                }
            }.frame(
                width: geo.size.width,
                height: geo.size.height*0.5
            )
        }
    }
}

struct JokeExplanation: View {
    
    var body: some View {
        Text("Press Button to load a joke")
    }
}

struct JokeView: View {
    var jokeResponse: JokeResponse
    
    init(jokeResponse: JokeResponse) {
        self.jokeResponse = jokeResponse
    }
    
    var body: some View {
        VStack {
            if (!self.jokeResponse.joke.isEmpty) {
                Text(jokeResponse.joke)
                    .multilineTextAlignment(.center)
            } else if (!jokeResponse.question.isEmpty && !jokeResponse.answer.isEmpty) {
                Text(jokeResponse.question)
                    .multilineTextAlignment(.center)
                Text(jokeResponse.answer)
                    .multilineTextAlignment(.center)
            }
        }
    }
}
