import SwiftUI
import shared

struct MainUiStateView: View {
    var mainUiState: MainUiState
    
    init(mainUiState: MainUiState) {
        self.mainUiState = mainUiState
    }
    var body: some View {
        GeometryReader { geo in
            Group {
                switch mainUiState {
                case is MainUiStateIdle:
                    Text("Press Button to load a joke")
                case is MainUiStateLoading:
                    ProgressView()
                case let dataState as MainUiStateData:
                    let jokeResponse = dataState.jokeResponse
                    JokeView(jokeResponse: jokeResponse)
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
